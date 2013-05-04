import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.UiApplication;

public class AddCardAddPause extends MyBaseScreen
{
        int screenNumber_ = 0;
        MyBasicEditField pauseField_;
        //constructor 
        public AddCardAddPause()
         {
         }
        public AddCardAddPause(int screenNumber)
        {
                //invoke the MainScreen constructor
                super();
                setTitleBitmap(1);
                screenNumber_ = screenNumber;
                MyLabelField  CallingCardNameLabel = new MyLabelField();
               
                CallingCardNameLabel.setText("Number of pauses, if needed");
                add(CallingCardNameLabel);
                
                MyLabelField  exampleLabel = new MyLabelField();
                exampleLabel.setText("(e.g. 4 is 8 Seconds)");
                add(exampleLabel);
                
                
                pauseField_ = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|MyBasicEditField.FILTER_INTEGER);
               
                String pauseNumber ="";
                if(screenNumber_ == 1)
                {
                         pauseNumber = AddCardName.datamodel_.getPause_();
                         if(pauseNumber.equals("") &&
                                !AddCardName.datamodel_.getAccessNumber_().equals(""))
                         {
                                 pauseNumber = ",,,,";
                         }
                                 
                }
                if(screenNumber_ == 2)
                {
                        pauseNumber = AddCardName.datamodel_.getPause1_();
                        if(pauseNumber.equals("") &&
                                !AddCardName.datamodel_.getCardNumber_().equals(""))
                         {
                                 pauseNumber = ",,,,";
                         }
                }
                if(screenNumber_ == 3)
                {
                        pauseNumber = AddCardName.datamodel_.getPause2_();
                        if(pauseNumber.equals("") &&
                                !AddCardName.datamodel_.getPin_().equals(""))
                         {
                                 pauseNumber = ",,,,";
                         }
                }
                
                if(!pauseNumber.equals(""))
                {
                        //String numberOfPauses = getNumberOfPauses(pauseNumber);
                        //pauseField_.setText(numberOfPauses);
                        //pauseField_.setCursorPosition(numberOfPauses.length());
                }
               
                add(pauseField_);
               
                UnderlinedLabelField addExtraStepField = new UnderlinedLabelField()
                {
                        public boolean keyChar(char key, int status, int time) 
                        {
                                boolean retval = false;
                                switch (key) 
                                {
                                        case Characters.ENTER:
                                                if(getScreenNumber() == 1)
                                            {
                                                        if(CardKallerMainScreen.isEditing_)
                                                        {
                                                                EditExtraSteps screen = new EditExtraSteps(1);
                                                        UiApplication.getUiApplication().pushScreen(screen);
                                                        }
                                                        else
                                                        {
                                                                AddCardExtraStep screen = new AddCardExtraStep(1);
                                                    UiApplication.getUiApplication().pushScreen(screen);
                                                        }
                                            }
                                                if(getScreenNumber() == 2)
                                            {
                                                        if(CardKallerMainScreen.isEditing_)
                                                        {
                                                                EditExtraSteps screen = new EditExtraSteps(2);
                                                        UiApplication.getUiApplication().pushScreen(screen);
                                                        }
                                                        else
                                                        {
                                                                AddCardExtraStep screen = new AddCardExtraStep(2);
                                                        UiApplication.getUiApplication().pushScreen(screen);
                                                        }
                                            }
                                                if(getScreenNumber() == 3)
                                            {
                                                        if(CardKallerMainScreen.isEditing_)
                                                        {
                                                                EditExtraSteps screen = new EditExtraSteps(3);
                                                        UiApplication.getUiApplication().pushScreen(screen);
                                                        }
                                                        else
                                                        {
                                                                AddCardExtraStep screen = new AddCardExtraStep(3);
                                                        UiApplication.getUiApplication().pushScreen(screen);
                                                        }
                                            }
                                }
                                return retval;
                        }
                };
                if(CardKallerMainScreen.isEditing_)
                {
                        addExtraStepField.setText("Edit extra step");
                }
                else
                {
                        addExtraStepField.setText("Add extra step");
                }
                add(addExtraStepField);
                
                UnderlinedLabelField nextField = new UnderlinedLabelField()
                {
                        public boolean keyChar(char key, int status, int time) 
                        {
                                boolean retval = false;
                                switch (key) 
                                {
                                        case Characters.ENTER:
                                                if(getScreenNumber() == 1)
                                                {
                                                        AddCardName.datamodel_.setPause_(getPauseText());
                                                        AddCardCardNumber screen = new AddCardCardNumber();
                                                        UiApplication.getUiApplication().pushScreen(screen);
                                                }
                                                else if(getScreenNumber() == 2)
                                                {
                                                        AddCardName.datamodel_.setPause1_(getPauseText());
                                                        AddPin screen = new AddPin();
                                                        UiApplication.getUiApplication().pushScreen(screen);
                                                }
                                                else if(getScreenNumber() == 3)
                                                {
                                                        AddCardName.datamodel_.setPause2_(getPauseText());
                                                        AddCardSpecialDigits screen = new AddCardSpecialDigits();
                                                        UiApplication.getUiApplication().pushScreen(screen);
                                                }
                                }
                                return retval;
                        }
                };

                nextField.setText("Next");
                add(nextField);
                
                UnderlinedLabelField backFieldField = new UnderlinedLabelField()
                {
                        public boolean keyChar(char key, int status, int time) 
                        {
                                boolean retval = false;
                                switch (key) 
                                {
                                        case Characters.ENTER:
                                        {
                                                if(getScreenNumber() == 1)
                                                {
                                                        AddAccessCardNumber screen = new AddAccessCardNumber();
                                                        UiApplication.getUiApplication().pushScreen(screen);
                                                }
                                                else if(getScreenNumber() == 2)
                                                {
                                                        AddCardCardNumber screen = new AddCardCardNumber();
                                                        UiApplication.getUiApplication().pushScreen(screen);
                                                }
                                                else if(getScreenNumber() == 3)
                                                {
                                                        AddPin screen = new AddPin();
                                                        UiApplication.getUiApplication().pushScreen(screen);
                                                }
                                                
                                        }
                                }
                                return retval;
                        }
                };

                backFieldField.setText("Back");
                add(backFieldField);
        }
        

        
        public String getPauseText()
        {
                String returnText = "";
                String numberPauses = pauseField_.getText();
                numberPauses = numberPauses.trim();
                
                if(!numberPauses.equals(""))
                {
                        for(int i=0; i < Integer.parseInt(numberPauses); i++)
                        {
                                returnText = returnText + ",";
                        }
                }
                return returnText;
        }
        
        
        
        public int getScreenNumber()
        {
                return screenNumber_;
        }
       
}
