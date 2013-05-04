import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.UiApplication;



//create a new screen that extends MainScreen, which provides
//default standard behavior for BlackBerry applications
public class MakeCallPhoneNumber extends MyBaseScreen
{    
        private MyBasicEditField phoneNumber;
        public MakeCallPhoneNumber()
        {
                super();
                setTitleBitmap(4);
                MyLabelField  phoneLabel = new MyLabelField();
                phoneLabel.setText("Enter phone number to call ");
                add(phoneLabel);
                
                MyLabelField  exampleLabel = new MyLabelField();
                exampleLabel.setText("(e.g. 6044360808)");
                add(exampleLabel);
                
                
                phoneNumber = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|
                                                    MyBasicEditField.FILTER_PHONE);
              
                add(phoneNumber);
                phoneNumber.setFocus();
               
                UnderlinedLabelField nextField = new UnderlinedLabelField()
                {
                       public void processEnter()
                        {    
                            CardKallerCardNameSelection screen = new CardKallerCardNameSelection(CardKallerModel.getCardNames(),getPhoneNumber(),1);
                            UiApplication.getUiApplication().pushScreen(screen);    
                        }
                };

                nextField.setText("Place call");
                add(nextField);
                
                UnderlinedLabelField backFieldField = new UnderlinedLabelField()
                {
                       public void processEnter()
                        { 
                          onClose();
                        }
                };

                backFieldField.setText("Back");
                add(backFieldField);

        }
        
        public String getPhoneNumber()
        {
            return phoneNumber.getText().trim();
    }
    public boolean onClose()
    {
         CardKallerMainScreen cardMain = new CardKallerMainScreen();
         UiApplication.getUiApplication().pushScreen(cardMain);   
         return true;  
    }
}


