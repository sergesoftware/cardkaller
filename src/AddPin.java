import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.UiApplication;

public class AddPin extends MyBaseScreen
{
        MyBasicEditField  nameField;
        MyBasicEditField pauseField_;
        public AddPin()
        {
                //invoke the MainScreen constructor
                super();
                setTitleBitmap(1);
                MyLabelField PinLabel = new MyLabelField();
                PinLabel.setText("Enter PIN number /");
                add(PinLabel);
                
                MyLabelField  exampleLabel = new MyLabelField();
                exampleLabel.setText("Verification code, if needed");
                add(exampleLabel);
                
                MyLabelField  exampleLabel1 = new MyLabelField();
                exampleLabel1.setText("(e.g.8472)");
                add(exampleLabel1);
                
                
                nameField = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|MyBasicEditField.FILTER_PHONE);
                
                String pinNumber = AddCardName.datamodel_.getPin_();
                if(!pinNumber.equals(""))
                {
                        nameField.setText(pinNumber);
                        nameField.setCursorPosition(pinNumber.length());
                }
               
                add(nameField);
                nameField.setFocus();
                
                MyLabelField  CallingCardNameLabel = new MyLabelField();
               
                CallingCardNameLabel.setText("Number of 2 second pauses");
                add(CallingCardNameLabel);
                
                MyLabelField  exampleLabel2 = new MyLabelField();
                exampleLabel2.setText("(e.g. 4 pauses=8 seconds)");
                add(exampleLabel2);
               
               pauseField_ = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|
                                                                    MyBasicEditField.FILTER_INTEGER);
               String pauses = AddCardName.datamodel_.getNumberOfPauses(AddCardName.datamodel_.getPause2_());                                                    
                if(!pauses.equals(""))
                {
                        pauseField_.setText(pauses);
                        pauseField_.setCursorPosition(pauses.length());
                }
                add(pauseField_);
                
                UnderlinedLabelField nextField = new UnderlinedLabelField()
                {
                    public void processEnter()
                    {
                        AddCardName.datamodel_.setPin_(getPINText());
                        AddCardName.datamodel_.setPause2_(getPauses());
                        AddCardPrefixTerm prefixScreen = new AddCardPrefixTerm();
                        UiApplication.getUiApplication().pushScreen(prefixScreen);
                    }
                };

                nextField.setText("Next");
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
                
               UnderlinedLabelField addExtraStepField = new UnderlinedLabelField()
                {
                    public void processEnter()
                    {
                        AddCardName.datamodel_.setPin_(getPINText());
                        AddCardName.datamodel_.setPause2_(getPauses());
                        AddCardExtraStep screen = new AddCardExtraStep(3);
                        UiApplication.getUiApplication().pushScreen(screen); 
                    }
                };
                addExtraStepField.setText("Add extra step");
                 add(addExtraStepField);
           
        }
        
        public String getPINText()
        {
                return nameField.getText().trim();
        }
        
        public String getPauses()
        {
                return CardKallerModel.getPauseText(pauseField_.getText());
        }
        public boolean onClose()
        {
            AddCardCardNumber addCardNumberScreen = new AddCardCardNumber();
            UiApplication.getUiApplication().pushScreen(addCardNumberScreen);  
            return true;  
        }
}


