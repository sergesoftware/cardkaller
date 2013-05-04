import java.io.IOException;
import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.Font;
import net.rim.device.api.system.DeviceInfo;


//create a new screen that extends MainScreen, which provides
//default standard behavior for BlackBerry applications
public class KeyEntryScreen extends MyBaseScreen
{
        //declare variables for later use

     MyBasicEditField keyName;
     MyLabelField  label;
     MyLabelField  label1;
     MyLabelField  label2;
     MyLabelField  label3;
     MyLabelField  label4;
     MyLabelField  label5;
     MyLabelField  label6;
     MyLabelField  label7;
     MyLabelField  label8;
     MyLabelField  keyEntryLabel;
     UnderlinedLabelField nextField;
     UnderlinedLabelField backField;
     VerticalFieldManager labelManager4;
     VerticalFieldManager labelManager1; 
        public KeyEntryScreen()
        {
                //invoke the MainScreen constructor
                super();
               setTitleBitmap(1);
               
                VerticalFieldManager labelManager = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
                label = new MyLabelField();
                
                labelManager1 = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
                label1 = new MyLabelField();
                
                if(!CardKallerModel.permanentKey &&
                    !CardKallerMain.isValidLicense_)
                    {
                        label.setText("Trial Expired");
                        label1.setText("Your trial of CardKaller has expired.");
                    }
                    else
                    {
                        label.setText("CardKaller Trial");
                        label1.setText("We hope you are enjoying the trial.");
                    }
                label.setFont(Font.getDefault().derive(Font.BOLD));
                labelManager.add(label);
                
                
               
                labelManager1.add(label1);
              
                VerticalFieldManager labelManager2 = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
                label2 = new MyLabelField();
                label2.setText("Please visit cardkaller.com to purchase the");
                labelManager2.add(label2);
                
                VerticalFieldManager labelManager3 = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
                label3 = new MyLabelField();
                label3.setText("software and receive an activation key. ");
                labelManager3.add(label3);
                
                labelManager4 = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
                label4 = new MyLabelField();
                label4.setText("Activate");
                label4.setFont(Font.getDefault().derive(Font.BOLD));
                labelManager4.add(label4);
                
                label5 = new MyLabelField();
                label6 = new MyLabelField();
                label7 = new MyLabelField();
                label8 = new MyLabelField();
                
                add(labelManager);
                add(label5);
                add(labelManager1);
                add(label6);
                add(labelManager2);
                add(labelManager3);
                add(label7);
                add(labelManager4);
                add(label8);
                
                
                int pin = DeviceInfo.getDeviceId();
                String hexPIN = Integer.toHexString(pin);
                hexPIN = hexPIN.toUpperCase();
                MyLabelField pinLabel = new MyLabelField();
                pinLabel.setText("Your PIN: " + hexPIN);
                add(pinLabel);
                
                keyEntryLabel = new MyLabelField();
                keyEntryLabel.setText("Activation key:");
                add(keyEntryLabel);
                
              
               
                
                keyName = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|MyBasicEditField.FILTER_INTEGER)
                {
                        public boolean keyChar(char key, int status, int time) 
                        {
                                boolean retval = false;
                                switch (key) 
                                {
                                        case Characters.ENTER:
                                        {
                                            processNext();  
                                        }
                                        default:super.keyChar( key,  status,  time);
                                }
                                return retval;
                        }
                         protected boolean trackwheelClick(int status,
                                int time)
                        {
                              processNext();
                              return true;
                         }
                };
               
                add(keyName);
                keyName.setFocus();
                nextField = new UnderlinedLabelField()
                {
                       public void processEnter()
                        {
                             processNext();
                        }
                };
                nextField.setText("Next");
                add(nextField);
                
                backField = new UnderlinedLabelField()
                {
                       public void processEnter()
                        {
                             processBack();
                        }
                };
                backField.setText("Back");
                add(backField);
        }
         public void processBack()
        {
                    if(CardKallerMain.isValidPINkey(keyName.getText()))
                    {
                        CardKallerMain.setKey(keyName.getText());
                        launchApp();
                    }
                    else
                    {
                            System.exit(0);
                    }
        }
        
          public void processNext()
        {
                    if(CardKallerMain.isValidPINkey(keyName.getText()))
                    {
                        if(!keyEntryLabel.getText().equals(""))
                        {
                            nextField.setText("Back");
                            label.setText("Successfully Registered");
                            delete(labelManager1);
                            label2.setText("Thank you for choosing CardKaller");
                            label3.setText("Activation code " + keyName.getText() + ".");
                            delete(label6);
                            delete(label7);
                            delete(label8);
                            delete(labelManager4);
                            delete(keyName);
                            delete(backField);
                            keyEntryLabel.setText("");
                            delete(keyEntryLabel);
                        }
                        else
                        {
                            CardKallerMain.setKey(keyName.getText());
                            launchApp();
                        }
                            
                    }
                    else
                    {
                           label.setText("Invalid Key");
                           label1.setText("Please Try Again");
                    }
        }
        private void launchApp()
        {
                if(CardKallerMain.phoneNumber_.equals(""))
                {
                        CardKallerMainScreen mainScreen = new CardKallerMainScreen();
                        UiApplication.getUiApplication().pushScreen(mainScreen);
                }
                else
                {
                        CardKallerCardNameSelection screen = new CardKallerCardNameSelection(CardKallerModel.getCardNames(),CardKallerMain.phoneNumber_,1);
                        UiApplication.getUiApplication().pushScreen(screen);
                }
        }
}


