import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.UiApplication;


public class AddCardCardNumber extends MyBaseScreen
{
        MyBasicEditField cardNumberField_;
        MyBasicEditField pauseField_;
        public AddCardCardNumber()
        {
                //invoke the MainScreen constructor
                super();
                setTitleBitmap(1);
                MyLabelField  cardLabel = new MyLabelField();
                cardLabel.setText("Card number, if needed");
                add(cardLabel);
                
                MyLabelField  exampleLabel = new MyLabelField();
              
                exampleLabel.setText("(e.g. 542894054)");
                add(exampleLabel);
                
                
                cardNumberField_ = new MyBasicEditField(MyBasicEditField.NO_NEWLINE |
                                                        MyBasicEditField.FILTER_PHONE);
                
                String cardNumber = AddCardName.datamodel_.getCardNumber_();
                if(!cardNumber.equals(""))
                {
                        cardNumberField_.setText(cardNumber);
                        cardNumberField_.setCursorPosition(cardNumber.length());
                }
               
                add(cardNumberField_);
                cardNumberField_.setFocus();
                
                 MyLabelField  CallingCardNameLabel = new MyLabelField();
               
                CallingCardNameLabel.setText("Number of 2 second pauses");
                add(CallingCardNameLabel);
                
                MyLabelField  exampleLabel1 = new MyLabelField();
                exampleLabel1.setText("(e.g. 4 pauses=8 seconds)");
                add(exampleLabel1);
                
                pauseField_ = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|
                                                                    MyBasicEditField.FILTER_INTEGER);
                String pauses = AddCardName.datamodel_.getNumberOfPauses(AddCardName.datamodel_.getPause1_());                                                    
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
                            AddCardName.datamodel_.setCardNumber_(getCardNumberText());
                            AddCardName.datamodel_.setPause1_(getPauses());
                            AddPin pinScreen = new AddPin();
                            UiApplication.getUiApplication().pushScreen(pinScreen);
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
                        AddCardName.datamodel_.setCardNumber_(getCardNumberText());
                        AddCardName.datamodel_.setPause1_(getPauses());
                        AddCardExtraStep screen = new AddCardExtraStep(2);
                        UiApplication.getUiApplication().pushScreen(screen); 
                    }
                };
                addExtraStepField.setText("Add extra step");
                add(addExtraStepField);
               
           
        }
        
        public String getCardNumberText()
        {
                return cardNumberField_.getText().trim();
        }
        public String getPauses()
        {
                return CardKallerModel.getPauseText(pauseField_.getText());
        }
         public boolean onClose()
        {
                 AddAccessCardNumber screen = new AddAccessCardNumber();
                 UiApplication.getUiApplication().pushScreen(screen);   
                return true;
        }
     
        

}


