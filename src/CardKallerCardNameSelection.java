import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.Graphics;

//create a new screen that extends MainScreen, which provides
//default standard behavior for BlackBerry applications
public class CardKallerCardNameSelection extends MyBaseScreen
{
        private int action_ = 1;
        private String[] cardNumbers_;
        private static String phoneNumber_;
        public CardKallerCardNameSelection()
        {
        }
        // action is 1 phone, 2 edit, 3 delete
        public CardKallerCardNameSelection(String[] cardNumbers, String phoneNumber, int action)
        {
                //invoke the MainScreen constructor
                super();
                setTitleBitmap(1);
                action_ = action;
                cardNumbers_ = cardNumbers;
                phoneNumber_ = phoneNumber;
                
                 if(cardNumbers.length == 1 && 
                    action == 1 && 
                    phoneNumber != null)
                {
                    fieldSelected(cardNumbers[0]);
                }
                MyLabelField  CallingCardNameLabel = new MyLabelField();
                CallingCardNameLabel.setText("Select calling card:");
                CallingCardNameLabel.setFont(Font.getDefault().derive(Font.BOLD));
                add(CallingCardNameLabel);
                
                MyLabelField  space1 = new MyLabelField();
                add(space1);
                
                for(int i=0; i < cardNumbers_.length; i++)
                {
                        
                        CardKallerModel model = new CardKallerModel(cardNumbers_[i],
                                                                    CardKallerModel.getCardData(cardNumbers_[i]));
                        final MyLabelField  myNumber = new MyLabelField(model.getAccessNumber_());
                        UnderlinedLabelField  myName = new UnderlinedLabelField()
                        {
                            public void processEnter()
                            {
                                fieldSelected(getText());
                            }
                              protected void drawFocus(Graphics graphics, boolean on)
                            {
                                Font font = Font.getDefault().derive(Font.UNDERLINED|Font.BOLD);
                                setFont(font);
                                Font fontb = Font.getDefault().derive(Font.BOLD);
                                myNumber.setFont(fontb);
                                invalidate();
                                getManager().invalidate();
                            }
                    
                            public void  onUnfocus()
                            {
                                Font font = Font.getDefault().derive(Font.UNDERLINED);
                                setFont(font);
                                 Font fontb = Font.getDefault();
                                myNumber.setFont(fontb);
                                invalidate();
                            }
       
                        };
                    myName.setText(cardNumbers_[i]);
                    add(myName);
                    
                     
                   
                        add(myNumber);
                        
                     MyLabelField label = new MyLabelField();
                     add(label);
                }
                  MyLabelField  space = new MyLabelField();
                add(space);
                UnderlinedLabelField mainMenuField = new UnderlinedLabelField()
                {
                        public void processEnter()
                        {
                            onClose();       
                        }
                };

                mainMenuField.setText("Back");
                add(mainMenuField);
               
                        
        }

 
     
        public void fieldSelected(String cardName) {
           
            if(action_ == 1)
            {
                phoneNumber(cardName);
            }
            else if(action_ == 2)
            {
                editCard(cardName);
            }
            else if(action_ == 3)
            {
                deleteCard(cardName);
            }
                    
                    
           
          
        }
        
        private void deleteCard(String card)
        {
                DeleteCardConfirm screen = new DeleteCardConfirm(cardNumbers_, card);
                        UiApplication.getUiApplication().pushScreen(screen);
        }
        
        private void phoneNumber(String card)
        {
                CardKallerModel model = new CardKallerModel(card, CardKallerModel.getCardData(card));
                model.prioritizeName(card);
                String dialedNumber = model.generateString(phoneNumber_);
                MakeCallStatus status = new MakeCallStatus();
                status.placeCall(dialedNumber);
        }
        
        private void editCard( String card)
        {
             CardKallerModel model = new CardKallerModel(card, CardKallerModel.getCardData(card));
             AddCardName.datamodel_ = model;
             if(model.getAdvancedUser_().equals(""))
             {
                 Edit screen = new Edit();
                 UiApplication.getUiApplication().pushScreen(screen);
             }
             else
             {
                 CardKallerMainScreen.isEditing_ = true;
                 AdvancedUserStep screen = new AdvancedUserStep();
                 UiApplication.getUiApplication().pushScreen(screen);
             }
        }
         public boolean onClose()
        {
            if(action_ == 1)
            {
                MakeCallPhoneNumber makeCallScreen = new MakeCallPhoneNumber();
                UiApplication.getUiApplication().pushScreen(makeCallScreen); 
            }
            else
            {
                CardKallerMainScreen screen = new CardKallerMainScreen();
                UiApplication.getUiApplication().pushScreen(screen);
            }
            return true;
        }

}


