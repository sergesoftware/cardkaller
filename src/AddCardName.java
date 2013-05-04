import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.UiApplication;

//create a new screen that extends MainScreen, which provides
//default standard behavior for BlackBerry applications
public class AddCardName extends MyBaseScreen
{
        //declare variables for later use
//        private  InfoScreen  _infoScreen;
       public MyBasicEditField cardName_;
       public static CardKallerModel datamodel_;
     
        public AddCardName()
        {
                //invoke the MainScreen constructor
                super();
                setTitleBitmap(1);
                datamodel_ = new CardKallerModel();
                MyLabelField  CallingCardNameLabel = new MyLabelField();
                CallingCardNameLabel.setText("Card name");
                add(CallingCardNameLabel);
                
                MyLabelField  exampleLabel = new MyLabelField();
                exampleLabel.setText("(e.g. AT&T)");
                add(exampleLabel);
                
                cardName_ = new MyBasicEditField(MyBasicEditField.NO_NEWLINE );
                String name = AddCardName.datamodel_.getCardName_();                                                    
                if(!name.equals(""))
                {
                        cardName_.setText(name);
                        cardName_.setCursorPosition(name.length());
                }
                add(cardName_);
                cardName_.setFocus();
                
                UnderlinedLabelField nextField = new UnderlinedLabelField()
                {
                       public void processEnter()
                        {
                             processNext();
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
                
               UnderlinedLabelField advancedUserStep = new UnderlinedLabelField()
               {
                        public void processEnter()
                        {
                             datamodel_.setCardName_(getAccessCardText());
                            AdvancedUserStep screen = new AdvancedUserStep();
                            UiApplication.getUiApplication().pushScreen(screen);
                        }
                };

                advancedUserStep.setText("Advanced user setup");
                add(advancedUserStep);
           
        }
        
        
        public String getAccessCardText()
        {
                return cardName_.getText().trim();
        }
        public void processNext()
        {
            String cardData = CardKallerModel.getCardData(cardName_.getText());
            if( cardData != null && !CardKallerMainScreen.isEditing_)
            {
                Dialog.ask(Dialog.D_OK, "Card Name already exists");
                cardName_.setCursorPosition(cardName_.getText().length());
            }
            else
            {
                String name = getAccessCardText();
                if(name.equals(""))
                {
                    Dialog.ask(Dialog.D_OK, "Please enter a card name");
                    cardName_.setFocus();
                    cardName_.setCursorPosition(0);
                }
                else
                {
                    datamodel_.setCardName_(getAccessCardText());
                    AddAccessCardNumber screen = new AddAccessCardNumber();
                    UiApplication.getUiApplication().pushScreen(screen);
                }
            }
        }
         public boolean onClose()
        {
            CardKallerMainScreen cardMain = new CardKallerMainScreen();
            UiApplication.getUiApplication().pushScreen(cardMain);
            return true;
        }

}


