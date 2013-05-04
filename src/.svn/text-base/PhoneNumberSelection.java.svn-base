import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.MenuItem;
import net.rim.device.api.ui.component.Menu;
import net.rim.device.api.ui.container.*;
import net.rim.device.api.system.Application;
import net.rim.device.api.system.ApplicationManager;
import net.rim.device.api.system.ApplicationDescriptor;
import net.rim.device.api.system.ApplicationManagerException;
import net.rim.device.api.system.CodeModuleManager;
import net.rim.device.api.ui.Font;

public class PhoneNumberSelection extends MyBaseScreen implements FieldChangeListener
{
        public PhoneNumberSelection()
        {
        }
        public PhoneNumberSelection(String[] phoneNumbers)
        {
                //invoke the MainScreen constructor
                super();
                
               
                setTitleBitmap(1);
                MyLabelField  CallingCardNameLabel = new MyLabelField();
                CallingCardNameLabel.setText("Select number to call:");
                CallingCardNameLabel.setFont(Font.getDefault().derive(Font.BOLD));
                add(CallingCardNameLabel);
                
                MyLabelField  space = new MyLabelField();
                add(space);
                
                for(int i=0; i < phoneNumbers.length; i++)
                {
                        UnderlinedLabelField  myList = new UnderlinedLabelField()
                        {
                            public void processEnter()
                            {
                                fieldChanged(this, 0);
                            }
                        };
                        myList.setText(phoneNumbers[i]);
                      
                        myList.setChangeListener(this);
                        add(myList);

                        MyLabelField label = new MyLabelField();
                        add(label);
                }
        
        }

        //override onClose() to display a dialog box
        //when the application is closed
        public boolean onClose()
        {
            this.close();
                return true;
                }


        //create a menu item for users to close the application
        private MenuItem _closeItem = new MenuItem("Close", 200000, 10) {
                public void run()
                {
                        onClose();
                }
        };

        //override makeMenu to add the new menu items
        protected void makeMenu( Menu menu, int instance )
        {
                menu.add(_closeItem);
        }

      public boolean keyDown(int keycode, int time) 
   {
         if(keycode == 1179648)
         {
             onClose();
         }
         return super.keyDown(keycode, time);
         //Invoked when a key has been pressed. 
        }
        
        public void fieldChanged(Field field, int context) { 
             onClose();
            //the listener is only added the a choice field, so cast it
                UnderlinedLabelField textField = (UnderlinedLabelField)field;
                int moduleHandle = CodeModuleManager.getModuleHandle("CardKallerApp");
                ApplicationDescriptor[] desc = CodeModuleManager.getApplicationDescriptors(moduleHandle);
                ApplicationManager manager = ApplicationManager.getApplicationManager();
                
                ApplicationDescriptor descriptor = new ApplicationDescriptor(desc[0],new String[]{textField.getText()});
                try {
                     
                                manager.runApplication(descriptor, true);
                        } catch (ApplicationManagerException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
        }

}


