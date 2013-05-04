import java.util.Vector;
import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.UiApplication;

public class AddCardExtraStep extends MyBaseScreen
{
        MyBasicEditField  nameField;
        int whichAddExtraStep_;
        MyBasicEditField pauseField_;
        boolean isExtraStep = false;
        public AddCardExtraStep(int whichAddExtraStep)
        {
                //invoke the MainScreen constructor
                super();
                isExtraStep = false;
                setTitleBitmap(1);
                whichAddExtraStep_ = whichAddExtraStep;
                MyLabelField line1Label = new MyLabelField();
                line1Label.setText("Extra step choice(e.g. 1, 2 )");
                add(line1Label);
                
                nameField = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|MyBasicEditField.FILTER_NUMERIC);
                add(nameField);
                nameField.setFocus();
                
                MyLabelField  CallingCardNameLabel = new MyLabelField();
               
                CallingCardNameLabel.setText("Number of 2 second pauses");
                add(CallingCardNameLabel);
                
                MyLabelField  exampleLabel1 = new MyLabelField();
                exampleLabel1.setText("(e.g. 4 pauses=8 seconds)");
                add(exampleLabel1);
                
                pauseField_ = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|
                                                                    MyBasicEditField.FILTER_INTEGER);
               add(pauseField_);
                UnderlinedLabelField nextField = new UnderlinedLabelField()
                {
                    public void processEnter()
                    {
                        isExtraStep = false;
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
                
                UnderlinedLabelField addExtraStepField = new UnderlinedLabelField()
                {
                    public void processEnter()
                    {
                        isExtraStep = true;
                        processNext();
                    }
                };
                
                addExtraStepField.setText("Add another extra step");
                add(addExtraStepField);
                

        }
         
        private String getExtraStep()
        {
                return nameField.getText();
        }
        public String getPauses()
        {
                return CardKallerModel.getPauseText(pauseField_.getText());
        }
        
        public void processNext()
        {
            Vector extraSteps;
            String extraStep = getExtraStep();
            String pause = getPauses();
            if(!(extraStep.equals("") && pause.equals("")))
            {
                if(whichAddExtraStep_ == 1)
                {
                    extraSteps = AddCardName.datamodel_.getExtraSteps_();
                    extraSteps.addElement(extraStep + CardKallerModel.TOKEN2 +pause);
                    AddCardName.datamodel_.setExtraSteps_(extraSteps);
                    if(isExtraStep)
                    {
                        clearScreen();
                    }
                    else
                    {
                        AddCardCardNumber screen = new AddCardCardNumber();
                        UiApplication.getUiApplication().pushScreen(screen);
                    }
                }
                if(whichAddExtraStep_ == 2)
                {
                    extraSteps = AddCardName.datamodel_.getExtraSteps1_();
                    extraSteps.addElement(extraStep + CardKallerModel.TOKEN2 +pause);
                    AddCardName.datamodel_.setExtraSteps1_(extraSteps);
                    if(isExtraStep)
                    {
                        clearScreen();
                    }
                    else
                    {
                        AddPin screen = new AddPin();
                        UiApplication.getUiApplication().pushScreen(screen);
                    }
                }
                if(whichAddExtraStep_ == 3)
                {
                    extraSteps = AddCardName.datamodel_.getExtraSteps2_();
                    extraSteps.addElement(extraStep + CardKallerModel.TOKEN2 +pause);
                    AddCardName.datamodel_.setExtraSteps2_(extraSteps);
                    if(isExtraStep)
                    {
                        clearScreen();
                    }
                    else
                    {
                        AddCardPrefixTerm screen = new AddCardPrefixTerm();
                        UiApplication.getUiApplication().pushScreen(screen);
                    }
                }
            }
         }
         
        private void clearScreen()
        {
            nameField.setText("");
            pauseField_.setText("");
            nameField.setFocus();
        }
         public boolean onClose()
        {
                 if(whichAddExtraStep_ == 1)
                {
                    AddAccessCardNumber screen = new AddAccessCardNumber();
                    UiApplication.getUiApplication().pushScreen(screen);
                }
                if(whichAddExtraStep_ == 2)
                {
                    AddCardCardNumber screen = new AddCardCardNumber();
                    UiApplication.getUiApplication().pushScreen(screen);
                    }
                    
                if(whichAddExtraStep_ == 3)
                {
                AddPin screen = new AddPin();
                UiApplication.getUiApplication().pushScreen(screen);
                }
                return true;
        } 
}


