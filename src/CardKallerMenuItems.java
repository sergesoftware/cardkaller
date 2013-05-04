
import javax.microedition.pim.Contact;
import javax.microedition.pim.PIMException;
import net.rim.device.api.system.Application;
import net.rim.blackberry.api.menuitem.ApplicationMenuItemRepository;
import net.rim.blackberry.api.menuitem.ApplicationMenuItem;
import net.rim.blackberry.api.pdap.BlackBerryContact;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.system.ApplicationManager;
import net.rim.device.api.system.ApplicationDescriptor;
import net.rim.device.api.ui.component.Dialog;
import net.rim.blackberry.api.phone.phonelogs.PhoneCallLog;
import net.rim.blackberry.api.phone.phonelogs.PhoneLogs;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.Field;
import net.rim.device.api.system.ApplicationManagerException;
import net.rim.device.api.system.CodeModuleManager;
import net.rim.device.api.ui.component.EditField;
import net.rim.blackberry.api.phone.Phone;

import net.rim.device.api.ui.Screen;

        public final class CardKallerMenuItems extends Application 
        {
            
            public static void main(String[] args) 
            {
                CardKallerMenuItems menus = new CardKallerMenuItems();
                menus.enterEventDispatcher();
            }
            
            CardKallerMenuItems() 
            {
                ApplicationMenuItemRepository amir = 
                ApplicationMenuItemRepository.getInstance();
                if(CardKallerMenuItem.getOSVersion().startsWith("4.0"))
                {
                    amir.addMenuItem(ApplicationMenuItemRepository.MENUITEM_SYSTEM,
                        new CardKallerMenuItem());
                }
                else
                {
                        amir.addMenuItem(ApplicationMenuItemRepository.MENUITEM_ADDRESSBOOK_LIST,
                        new CardKallerMenuItem());
                        amir.addMenuItem(ApplicationMenuItemRepository.MENUITEM_ADDRESSCARD_VIEW,
                        new CardKallerMenuItem());
                        amir.addMenuItem(ApplicationMenuItemRepository.MENUITEM_ADDRESSCARD_EDIT,
                        new CardKallerMenuItem());
                         
                         
 MakeCallStatus stat = new MakeCallStatus();
Phone.addPhoneListener(stat);
                         
                         amir.addMenuItem(ApplicationMenuItemRepository.MENUITEM_PHONELOG_VIEW ,
                        new CardKallerMenuItem(new String("view"),20));
                         amir.addMenuItem(ApplicationMenuItemRepository.MENUITEM_PHONE ,
                        new CardKallerMenuItem(new String("view"),20));
                }

            }
            
            
           
            private static class CardKallerMenuItem extends ApplicationMenuItem 
            {
                CardKallerMenuItem() {
                    super(20);
                }
                CardKallerMenuItem(Object context, int val) {
                    super(context, val);
                }
                
                public String toString() {
                    return "CardKaller Call";
                }
                
                public Object run(Object context) 
                {
                     String[] phoneNumbers = new String[]{};
                    if(context == null)
                    {
                      //  UiApplication uiApp = UiApplication.getUiApplication().getActiveScreen().getFieldWithFocus();
                       
                        Screen screen = UiApplication.getUiApplication().getActiveScreen();
                        if(screen.getClass().getName().equals("net.rim.device.apps.internal.phone.PhoneAppScreen"))
                        { 
                           Field field = screen.getFieldWithFocus();
                           if( field instanceof EditField)
                           {
                               EditField ef = (EditField)field;
                               String num = ef.getText();
                               phoneNumbers = new String[]{num};
                            }
                        }
                        else if(screen.getClass().getName().equals("net.rim.device.apps.internal.addressbook.addresscard.ViewAddressCardScreen"))
                        {
                            Field field = screen.getFieldWithFocus();
                           if( field instanceof EditField)
                           {
                               EditField ef = (EditField)field;
                               String num = ef.getText();
                               phoneNumbers = new String[]{num};
                            }
                        }
                    }
                    Contact c = null;
                    PhoneCallLog cl = null;
                    if( context instanceof Contact)
                    {
                        c = (Contact)context; //an error if this doesn't work
                        try 
                        {
                            phoneNumbers = createPhoneText(c);
                        } 
                        catch (PIMException e) 
                        {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        
                    }
                    else if(context instanceof PhoneCallLog)
                    {
                        cl = (PhoneCallLog)context;
                        phoneNumbers = new String[]{cl.getParticipant().getNumber()};
                    }
                    else if(context instanceof String)
                    {
                        phoneNumbers = new String[]{(String)context};
                    }
                    else if(context != null)
                    {
                        Dialog.alert("Please call Tech Support:" + context.getClass().getName());
                    }
                    if(phoneNumbers.length == 1)
                    {
                          //the listener is only added the a choice field, so cast it
                        int moduleHandle = CodeModuleManager.getModuleHandle("CardKallerApp");
                        ApplicationDescriptor[] desc = CodeModuleManager.getApplicationDescriptors(moduleHandle);
                        ApplicationManager manager = ApplicationManager.getApplicationManager();
                
                        ApplicationDescriptor descriptor = new ApplicationDescriptor(desc[0],new String[]{phoneNumbers[0]});
                        try 
                        {
                     
                                manager.runApplication(descriptor, true);
                        } 
                        catch (ApplicationManagerException e) 
                        {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                        
                    }  
                    else if ( phoneNumbers.length > 0)
                    {
                        PhoneNumberSelection selectPhoneNumber = new PhoneNumberSelection(phoneNumbers);
                        UiApplication.getUiApplication().pushScreen(selectPhoneNumber);
                    } 
                
                    return null;
                }
                
                static public String getOSVersion() 
                {
                        ApplicationDescriptor[] appDes = ApplicationManager.getApplicationManager().getVisibleApplications();

                        for (int i = appDes.length - 1; i >= 0; --i) 
                        {
                            if ((appDes[i].getModuleName()).equals("net_rim_bb_ribbon_app")) 
                            {
                                return appDes[i].getVersion();
                            }
                        }
                        return "";
                }           

                private String[] createPhoneText(Contact contact) throws PIMException
                {
                        String phoneNumbers[] = new String[contact.countValues(Contact.TEL)];
                                for(int i =0; i < phoneNumbers.length; i++)
                                {
                                        phoneNumbers[i] = contact.getString(Contact.TEL, i);
                                        
                                
                                        int attr = contact.getAttributes(Contact.TEL, i);
                                        
                                        if(attr == Contact.ATTR_WORK)
                                        {
                                                phoneNumbers[i] = "Work: " + phoneNumbers[i];
                                        }
                                        else if (attr == Contact.ATTR_HOME)
                                        {
                                                phoneNumbers[i] = "Home: " + phoneNumbers[i];
                                        }
                                        else if (attr == Contact.ATTR_MOBILE)
                                        {
                                                phoneNumbers[i] = "Mobile: " + phoneNumbers[i];
                                        }
                                        else if (attr == Contact.ATTR_PAGER)
                                        {
                                                phoneNumbers[i] = "Pager: " + phoneNumbers[i];
                                        }
                                        else if (attr == Contact.ATTR_FAX)
                                        {
                                                phoneNumbers[i] = "Fax: " + phoneNumbers[i];
                                        }
                                        else if (attr == Contact.ATTR_OTHER)
                                        {
                                                phoneNumbers[i] = "Other: " + phoneNumbers[i];
                                        }
                                
                }
                                return phoneNumbers;
            }
        }
        }
