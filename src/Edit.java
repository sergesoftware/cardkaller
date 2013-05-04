import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.Field;
import java.util.Hashtable;
import java.util.Vector;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
public class Edit extends MyBaseScreen
{
    String originalName = "";
        public Edit()
        {
                //invoke the MainScreen constructor
                super();
                setTitleBitmap(2);
            
                MyBasicEditField  cardNameField = new MyBasicEditField(MyBasicEditField.NO_NEWLINE);
                cardNameField.setText(AddCardName.datamodel_.getCardName_());
                //cardNameField.setLabel("Card name:");
                
                MyLabelField cardNameLabel = new MyLabelField();
                cardNameLabel.setText("Card name:");
                add(cardNameLabel);
                
                cardNameField.setType(1);
                add(cardNameField);

                originalName = AddCardName.datamodel_.getCardName_();
   
                MyBasicEditField  accessNumberField = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|
                                                                            MyBasicEditField.FILTER_PHONE);
                accessNumberField.setText(AddCardName.datamodel_.getAccessNumber_());
                //accessNumberField.setLabel("Access number:");
                
                MyLabelField accessNumberFieldLabel = new MyLabelField();
                accessNumberFieldLabel.setText("Access number:");
                add(accessNumberFieldLabel); 
                  
                accessNumberField.setType(2);
                add(accessNumberField);
                
                MyBasicEditField  accessPauseField = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|
                                                                           MyBasicEditField.FILTER_INTEGER);
                accessPauseField.setText(CardKallerModel.getNumberOfPauses(AddCardName.datamodel_.getPause_()));
                //accessPauseField.setLabel("Pauses:");
                
                 MyLabelField accessPauseFieldLabel = new MyLabelField();
                 accessPauseFieldLabel.setText("Pauses:");
                 add(accessPauseFieldLabel);
                
                
                accessPauseField.setType(3);
                add(accessPauseField);
                
                for(int i=0; i < AddCardName.datamodel_.getExtraSteps_().size(); i++)
                {
                    MyBasicEditField  extraStepField = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|
                                                                            MyBasicEditField.FILTER_NUMERIC);
                    extraStepField.setText(CardKallerModel.getExtraStep((String)AddCardName.datamodel_.getExtraSteps_().elementAt(i)));
                    //extraStepField.setLabel("Extra step:");
                    
                    MyLabelField extraStepFieldLabel = new MyLabelField();
                    extraStepFieldLabel.setText("Extra step:");
                    add(extraStepFieldLabel);
                    
                    extraStepField.setType(4);
                    add(extraStepField);
                
                    MyBasicEditField  extraStepPauseField = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|
                                                                                MyBasicEditField.FILTER_INTEGER);
                    extraStepPauseField.setText(CardKallerModel.getExtraStepPause((String)AddCardName.datamodel_.getExtraSteps_().elementAt(i)));
                    //extraStepPauseField.setLabel("Pauses:");
                    
                    MyLabelField extraStepPauseFieldLabel = new MyLabelField();
                    extraStepPauseFieldLabel.setText("Pauses:");
                    add(extraStepPauseFieldLabel);
                    
                    extraStepPauseField.setType(5);
                    add(extraStepPauseField);
                    
                }
                
                MyBasicEditField  cardNumberField = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|
                                                                         MyBasicEditField.FILTER_PHONE);
                cardNumberField.setText(AddCardName.datamodel_.getCardNumber_());
                //cardNumberField.setLabel("Card number:");
                
                 MyLabelField cardNumberFieldLabel = new MyLabelField();
                 cardNumberFieldLabel.setText("Card number:");
                 add(cardNumberFieldLabel);
                 
                cardNumberField.setType(6);
                add(cardNumberField);
                
                MyBasicEditField  cardNumberPauseField = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|
                                                                              MyBasicEditField.FILTER_INTEGER);
                cardNumberPauseField.setText(CardKallerModel.getNumberOfPauses(AddCardName.datamodel_.getPause1_()));
                //cardNumberPauseField.setLabel("Pauses:");
          
                 MyLabelField cardNumberPauseFieldLabel = new MyLabelField();
                 cardNumberPauseFieldLabel.setText("Pauses:");
                 add(cardNumberPauseFieldLabel);

                cardNumberPauseField.setType(7);
                add(cardNumberPauseField);
                
                for(int i=0; i < AddCardName.datamodel_.getExtraSteps1_().size(); i++)
                {
                    MyBasicEditField  extraStepField = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|
                                                                            MyBasicEditField.FILTER_NUMERIC);
                    extraStepField.setText(CardKallerModel.getExtraStep((String)AddCardName.datamodel_.getExtraSteps1_().elementAt(i)));
                    //extraStepField.setLabel("Extra step:");
                    
                    MyLabelField extraStepFieldLabel = new MyLabelField();
                    extraStepFieldLabel.setText("Extra step:");
                    add(extraStepFieldLabel);
                    
                    extraStepField.setType(8);
                    add(extraStepField);
                
                    MyBasicEditField  extraStepPauseField = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|
                                                                                 MyBasicEditField.FILTER_INTEGER);
                    extraStepPauseField.setText(CardKallerModel.getExtraStepPause((String)AddCardName.datamodel_.getExtraSteps1_().elementAt(i)));
                    //extraStepPauseField.setLabel("Pauses:");
                    
                    MyLabelField extraStepPauseFieldLabel = new MyLabelField();
                    extraStepPauseFieldLabel.setText("Pauses:");
                    add(extraStepPauseFieldLabel);
                    
                    extraStepPauseField.setType(9);
                    add(extraStepPauseField);
                    
                }
                MyBasicEditField  pinField = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|
                                                                  MyBasicEditField.FILTER_PHONE);
                pinField.setText(AddCardName.datamodel_.getPin_());
                //pinField.setLabel("PIN:");
                MyLabelField pinFieldLabel = new MyLabelField();
                pinFieldLabel.setText("PIN:");
                add(pinFieldLabel);
                
                pinField.setType(10);
                add(pinField);
                
                MyBasicEditField  pinPauseField = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|
                                                                        MyBasicEditField.FILTER_INTEGER);
                pinPauseField.setText(CardKallerModel.getNumberOfPauses(AddCardName.datamodel_.getPause2_()));
                //pinPauseField.setLabel("Pauses:");
                
                MyLabelField pinPauseFieldLabel = new MyLabelField();
                pinPauseFieldLabel.setText("Pauses:");
                add(pinPauseFieldLabel);
                
                pinPauseField.setType(11);
                add(pinPauseField);
                
                 for(int i=0; i < AddCardName.datamodel_.getExtraSteps2_().size(); i++)
                {
                    MyBasicEditField  extraStepField = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|
                                                                            MyBasicEditField.FILTER_NUMERIC);
                    extraStepField.setText(CardKallerModel.getExtraStep((String)AddCardName.datamodel_.getExtraSteps2_().elementAt(i)));
                    //extraStepField.setLabel("Extra step:");
                    
                    MyLabelField extraStepFieldLabel = new MyLabelField();
                    extraStepFieldLabel.setText("Extra step:");
                    add(extraStepFieldLabel);
                    
                    extraStepField.setType(12);
                    add(extraStepField);
                
                    MyBasicEditField  extraStepPauseField = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|
                                                                                 MyBasicEditField.FILTER_INTEGER);
                    extraStepPauseField.setText(CardKallerModel.getExtraStepPause((String)AddCardName.datamodel_.getExtraSteps2_().elementAt(i)));
                    //extraStepPauseField.setLabel("Pauses:");
                    
                    MyLabelField extraStepPauseFieldLabel = new MyLabelField();
                    extraStepPauseFieldLabel.setText("Pauses:");
                    add(extraStepPauseFieldLabel);
                    
                    extraStepPauseField.setType(13);
                    add(extraStepPauseField);
                    
                }
                
                MyBasicEditField  intlPrefixField = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|
                                                                        MyBasicEditField.FILTER_INTEGER);
                intlPrefixField.setText(AddCardName.datamodel_.getPrefix_());
                //intlPrefixField.setLabel("Intl prefixes:");
                
                MyLabelField intlPrefixFieldLabel = new MyLabelField();
                intlPrefixFieldLabel.setText("Intl prefixes:");
                add(intlPrefixFieldLabel);
                
                intlPrefixField.setType(14);
                add(intlPrefixField);
                
                MyBasicEditField  termCharacterField = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|
                                                                            MyBasicEditField.FILTER_PHONE);
                termCharacterField.setText(AddCardName.datamodel_.getTermination_());
                //termCharacterField.setLabel("Termin characters:");
                
                MyLabelField termCharacterFieldLabel = new MyLabelField();
                termCharacterFieldLabel.setText("Termin characters:");
                add(termCharacterFieldLabel);
                
                termCharacterField.setType(15);
                add(termCharacterField);
                
                 UnderlinedLabelField nextField = new UnderlinedLabelField()
                {
                    public void processEnter()
                    {
                        AddCardName.datamodel_.setExtraSteps_(new Vector());
                            AddCardName.datamodel_.setExtraSteps1_(new Vector());
                            AddCardName.datamodel_.setExtraSteps2_(new Vector());
                        for(int i = 0; i < getScreen().getFieldCount(); i++)
                        {
                            Field field = getScreen().getField(i) ;
                            if(field instanceof MyBasicEditField)
                            {
                                MyBasicEditField myField = (MyBasicEditField)field;
                                int type = myField.getType();
                                switch(type)
                                {
                                    case 1:AddCardName.datamodel_.setCardName_(myField.getText());
                                    break;
                                    case 2:AddCardName.datamodel_.setAccessNumber_(myField.getText());
                                    break;
                                    case 3:AddCardName.datamodel_.setPause_(CardKallerModel.getPauseText(myField.getText()));
                                    break;
                                    case 4:
                                    break;
                                    case 5:Vector extraSteps = AddCardName.datamodel_.getExtraSteps_();
                                           String step = ((MyBasicEditField)getScreen().getField(i-2)).getText();
                                           String pause = CardKallerModel.getPauseText(myField.getText());
                                            if(!(step.equals("") && pause.equals("")))
                                            {
                                                extraSteps.addElement(step + CardKallerModel.TOKEN2 + pause);
                                                AddCardName.datamodel_.setExtraSteps_(extraSteps);
                                            } 
                                    break;
                                    case 6:AddCardName.datamodel_.setCardNumber_(myField.getText());
                                    break;
                                    case 7:AddCardName.datamodel_.setPause1_(CardKallerModel.getPauseText(myField.getText()));
                                    break;
                                    case 8:
                                    break;
                                    case 9:Vector extraSteps1 = AddCardName.datamodel_.getExtraSteps1_();
                                           String step1 = ((MyBasicEditField)getScreen().getField(i-2)).getText();
                                           String pause1 = CardKallerModel.getPauseText(myField.getText());
                                            if(!(step1.equals("") && pause1.equals("")))
                                            {
                                                extraSteps1.addElement(step1 + CardKallerModel.TOKEN2 + pause1);
                                                AddCardName.datamodel_.setExtraSteps1_(extraSteps1);
                                            } 
                                    break;
                                    case 10:AddCardName.datamodel_.setPin_(myField.getText());
                                    break;
                                    case 11:AddCardName.datamodel_.setPause2_(CardKallerModel.getPauseText(myField.getText()));
                                    break;
                                    case 12:
                                    break;
                                    case 13:Vector extraSteps2 = AddCardName.datamodel_.getExtraSteps2_();
                                           String step2 = ((MyBasicEditField)getScreen().getField(i-2)).getText();
                                           String pause2 = CardKallerModel.getPauseText(myField.getText());
                                            if(!(step2.equals("") && pause2.equals("")))
                                            {
                                                extraSteps2.addElement(step2 + CardKallerModel.TOKEN2 + pause2);
                                                AddCardName.datamodel_.setExtraSteps2_(extraSteps2);
                                            } 
                                    break;
                                    case 14:AddCardName.datamodel_.setPrefix_(myField.getText());
                                    break;
                                    case 15:AddCardName.datamodel_.setTermination_(myField.getText());
                                    break;
                                }
                                
                            }
                           
                        }
                        String data = AddCardName.datamodel_.generateString();
                        
                        String name = AddCardName.datamodel_.getCardName_();
                                                  
                        Hashtable myHashtable = CardKallerModel.getData();
                        if(!originalName.equals(name))
                        {
                            CardKallerModel.deleteCardName(originalName);
                            AddCardName.datamodel_.addCardName(name);
                        }
                        myHashtable.put(name, data);
                        CardKallerModel.setData(myHashtable);
                        AddCardComplete screen = new AddCardComplete(name);
                        UiApplication.getUiApplication().pushScreen(screen);          
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
            CardKallerCardNameSelection screen = new CardKallerCardNameSelection(CardKallerModel.getCardNames(),"",2);
            UiApplication.getUiApplication().pushScreen(screen);
            return true;
        }
}
