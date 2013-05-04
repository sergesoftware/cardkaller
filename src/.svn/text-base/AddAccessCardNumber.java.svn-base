import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.UiApplication;

public class AddAccessCardNumber extends MyBaseScreen
{
        MyBasicEditField accessNumberField_;
        MyBasicEditField pauseField_;
        public AddAccessCardNumber()
        {
                //invoke the MainScreen constructor
                super();
                setTitleBitmap(1);
                MyLabelField  accessLabel = new MyLabelField();
               
                accessLabel.setText("Access number");
                add(accessLabel);
                
                MyLabelField  exampleLabel = new MyLabelField ();
                exampleLabel.setText("(e.g. 18009800575)");
                add(exampleLabel);
                
                accessNumberField_ = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|MyBasicEditField.FILTER_PHONE);
                
                String accessNumber = AddCardName.datamodel_.getAccessNumber_();
                if(!accessNumber.equals(""))
                {
                        accessNumberField_.setText(accessNumber);
                        accessNumberField_.setCursorPosition(accessNumber.length());
                }
               
                add(accessNumberField_);
                accessNumberField_.setFocus();
                
                 MyLabelField  CallingCardNameLabel = new MyLabelField();
               
                CallingCardNameLabel.setText("Number of 2 second pauses");
                add(CallingCardNameLabel);
                
                MyLabelField  exampleLabel1 = new MyLabelField();
                exampleLabel1.setText("(e.g. 4 pauses=8 seconds)");
                add(exampleLabel1);
                
                
                pauseField_ = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|
                                                                    MyBasicEditField.FILTER_INTEGER);
                String pauses = AddCardName.datamodel_.getNumberOfPauses(AddCardName.datamodel_.getPause_());                                                    
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
                        AddCardName.datamodel_.setAccessNumber_(getAccesscardText());
                        AddCardName.datamodel_.setPause_(getPauses());
                        AddCardCardNumber screen = new AddCardCardNumber();
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
                
                 UnderlinedLabelField addExtraStepField = new UnderlinedLabelField()
                {
                    public void processEnter()
                    {
                        AddCardName.datamodel_.setAccessNumber_(getAccesscardText());
                        AddCardName.datamodel_.setPause_(getPauses());
                        AddCardExtraStep screen = new AddCardExtraStep(1);
                        UiApplication.getUiApplication().pushScreen(screen); 
                    }
                };
                addExtraStepField.setText("Add extra step");
                add(addExtraStepField);
        }
        
     
        public String getAccesscardText()
        {
                return accessNumberField_.getText().trim();
        }
        
        public String getPauses()
        {
                return CardKallerModel.getPauseText(pauseField_.getText());
        }
         public boolean onClose()
        {
                AddCardName cardMain = new AddCardName();
                UiApplication.getUiApplication().pushScreen(cardMain);
                return true;
        }
}
