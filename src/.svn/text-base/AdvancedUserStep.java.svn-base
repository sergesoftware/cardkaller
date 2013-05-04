import java.util.Hashtable;
import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.UiApplication;

public class AdvancedUserStep extends MyBaseScreen
{
        MyBasicEditField cardNameField_;
        MyBasicEditField cardNumberField_;
        public AdvancedUserStep()
        {
                //invoke the MainScreen constructor
                super();
                
                setTitleBitmap(1);
                
                MyLabelField  cardLabel = new MyLabelField();
                cardLabel.setText("Card name");
                add(cardLabel);
                
                MyLabelField  exampleLabel = new MyLabelField();
                exampleLabel.setText("(e.g. AT&T)");
                add(exampleLabel);
                
                
                cardNameField_ = new MyBasicEditField(MyBasicEditField.NO_NEWLINE )
                {
                        public void processEnter()
                        {   
                            String cardData = CardKallerModel.getCardData(getText());
                            if( cardData != null)
                            {
                                    if(CardKallerMainScreen.isEditing_)
                                    {
                                            AddCardName.datamodel_ = new CardKallerModel(getText(),cardData);
                                            cardNumberField_.setText(AddCardName.datamodel_.getAdvancedUser_());
                                            cardNumberField_.setCursorPosition(cardNumberField_.getText().length());
                                    }
                                    else
                                    {
                                            Dialog.ask(Dialog.D_OK, "Card Name already exists");
                                            cardNameField_.setCursorPosition(cardNameField_.getText().length());
                                    }
                            }         
                        }
                };
                
                if(!AddCardName.datamodel_.getCardName_().equals("") )
                {
                        cardNameField_.setText(AddCardName.datamodel_.getCardName_());
                }
               
                add(cardNameField_);
                
                
                MyLabelField  cardNumberLabel = new MyLabelField();
                cardNumberLabel.setText("Manually enter calling");
                add(cardNumberLabel);
                
                MyLabelField  cardNumberLabel1 = new MyLabelField();
                cardNumberLabel1.setText("sequence.");
                add(cardNumberLabel1);
                
                MyLabelField  cardNumberLabel3 = new MyLabelField();
                cardNumberLabel3.setText("Use a comma to denote a");
                add(cardNumberLabel3);
                
                 MyLabelField  cardNumberLabel2 = new MyLabelField();
                cardNumberLabel2.setText("pause of 2 seconds.");
                add(cardNumberLabel2);
                
                MyLabelField  cardNumberLabel4 = new MyLabelField();
                cardNumberLabel4.setText("Use N to denote the phone");
                add(cardNumberLabel4);
                
                MyLabelField  cardNumberLabel5 = new MyLabelField();
                cardNumberLabel5.setText("number.");
                add(cardNumberLabel5);
                
                MyLabelField  cardNumberLabel7 = new MyLabelField();
                cardNumberLabel7.setText("(e.g. 18009800575,,,,,,,,N)");
                add(cardNumberLabel7);
                
                cardNumberField_ = new MyBasicEditField(MyBasicEditField.NO_NEWLINE |
                                    MyBasicEditField.FILTER_PHONE);
                String number = AddCardName.datamodel_.getAdvancedUser_();             
                 if(!number.equals("") )
                {
                        cardNumberField_.setText(number);
                }
               
                add(cardNumberField_);
               
                 if(!AddCardName.datamodel_.getCardName_().equals("") )
                {
                        cardNumberField_.setFocus();
                }
                else
                {
                    cardNameField_.setFocus();
                }
               
                UnderlinedLabelField nextField = new UnderlinedLabelField()
                {
                     public void processEnter()
                        {   
                         String cardData = CardKallerModel.getCardData(cardNameField_.getText() );
                            if( cardData != null && !CardKallerMainScreen.isEditing_)
                            {
                                Dialog.ask(Dialog.D_OK, "Card Name already exists");
                                cardNameField_.setCursorPosition(cardNameField_.getText().length());
                            }
                            else
                            {
                                AddCardName.datamodel_.deleteCardName(cardNameField_.getText());
                                AddCardName.datamodel_.addCardName(cardNameField_.getText());
                                AddCardName.datamodel_ = new CardKallerModel();
                                AddCardName.datamodel_.setCardName_(cardNameField_.getText());
                                AddCardName.datamodel_.setAdvancedUser_(cardNumberField_.getText());
                                Hashtable hash = CardKallerModel.getData();
                                hash.put(cardNameField_.getText(), AddCardName.datamodel_.generateString());
                               
                                CardKallerModel.setData(hash);
                                CardKallerMainScreen.isEditing_ = false;
                                AddCardComplete screen = new AddCardComplete(cardNameField_.getText());
                                UiApplication.getUiApplication().pushScreen(screen);
                            }        
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
                
               
           
        } 
        public boolean onClose()
        {
            if(CardKallerMainScreen.isEditing_)
            {
                CardKallerMainScreen.isEditing_ = false;
                CardKallerCardNameSelection screen = new CardKallerCardNameSelection(CardKallerModel.getCardNames(),"",2);
                UiApplication.getUiApplication().pushScreen(screen);
            }
            else
            {
                AddCardName screen = new AddCardName();
                UiApplication.getUiApplication().pushScreen(screen); 
            }
            return true;
        }

}


