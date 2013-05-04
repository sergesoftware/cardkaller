import java.util.Vector;
import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.UiApplication;


// No longer used class, but dont feel like disintegrating

//create a new screen that extends MainScreen, which provides
//default standard behavior for BlackBerry applications
public class EditExtraSteps extends MyBaseScreen
{
        private int pauseScreen_ = 1; 
        private Vector extraSteps_;
        UnderlinedLabelField nextField_;
        MyBasicEditField  addField_;
        public EditExtraSteps()
        {
        }
        // action is 1 first pause Screen, 2 second pause screen, 3 third pause screen
        public EditExtraSteps( int stepLocation)
        {
                //invoke the MainScreen constructor
                super();
                pauseScreen_ = stepLocation;
               
                UnderlinedLabelField mainMenuField = new UnderlinedLabelField()
                {
                        public boolean keyChar(char key, int status, int time) 
                        {
                                boolean retval = false;
                                switch (key) 
                                {
                                        case Characters.ENTER:
                                        {
                                                if(pauseScreen_ == 1)
                                                {
                                                AddCardAddPause pauseScreen = new AddCardAddPause(1);
                                                UiApplication.getUiApplication().pushScreen(pauseScreen);
                                                }
                                                if(pauseScreen_ == 2)
                                                {
                                                AddCardAddPause pauseScreen = new AddCardAddPause(2);
                                                UiApplication.getUiApplication().pushScreen(pauseScreen);
                                                }
                                                if(pauseScreen_ == 3)
                                                {
                                                AddCardAddPause pauseScreen = new AddCardAddPause(3);
                                                UiApplication.getUiApplication().pushScreen(pauseScreen);
                                                }
                                        }
                                }
                                return retval;
                        }
                };

                

                mainMenuField.setText("Back");
                add(mainMenuField);
                
                
                if(pauseScreen_ == 1)
                {
                        extraSteps_ = AddCardName.datamodel_.getExtraSteps_();
                }
                if(pauseScreen_ == 2)
                {
                        extraSteps_ = AddCardName.datamodel_.getExtraSteps1_();
                }
                if(pauseScreen_ == 3)
                {
                        extraSteps_ = AddCardName.datamodel_.getExtraSteps2_();
                }

                for(int i=0; i < extraSteps_.size(); i++)
                {
                        MyBasicEditField  myList = new MyBasicEditField(MyBasicEditField.NO_NEWLINE)
                        {
                        public boolean isFocusable() 
                        {
                                return true;
                        }
                        public boolean isSelectionCopyable() 
                        {
                                return false;
                        }
                        public boolean keyChar(char key, int status, int time) 
                        {
                                boolean retval = false;
                                switch (key) 
                                {
                                        case Characters.ENTER:
                                        default:super.keyChar( key,  status,  time) ;
                                                
                                }
                                return retval;
                        }
                        protected void paint(Graphics graphics)
                        {
                                super.paint(graphics);
                                // draw and underscore
                                graphics.drawRect(this.getFont().getAdvance(getLabel()) , 0, getWidth(), getHeight());
                        }


                    };
                    myList.setLabel(Integer.toString(i+1));
                    myList.setText((String)extraSteps_.elementAt(i));
                    myList.setCursorPosition(((String)extraSteps_.elementAt(i)).length());
                    add(myList);
                    
                }
                
                addField_ = new MyBasicEditField(MyBasicEditField.NO_NEWLINE)
                {
                        public boolean isFocusable() 
                        {
                                return true;
                        }
                        public boolean isSelectionCopyable() 
                        {
                                return false;
                        }
                        public boolean keyChar(char key, int status, int time) 
                        {
                                boolean retval = false;
                                switch (key) 
                                {
                                        case Characters.ENTER:
                                                addField(getText());
                                                setText("");
                                        default:super.keyChar( key,  status,  time);
                                }
                                return retval;
                        }
                        protected void paint(Graphics graphics)
                        {
                                super.paint(graphics);
                                // draw and underscore
                                graphics.drawRect(this.getFont().getAdvance(getLabel())  , 0, getWidth(), getHeight());
                        }
                };
            
                addField_.setLabel("Add Step");
                addField_.setText("");
                add(addField_);

            nextField_ = new UnderlinedLabelField()
            {
                    public boolean keyChar(char key, int status, int time) 
                    {
                            boolean retval = false;
                            switch (key) 
                            {
                                    case Characters.ENTER:
                                    {
                                        fieldSelected();
                                    }
                            }
                            return retval;
                    }
            };

            

            nextField_.setText("Next");
            add(nextField_);
            
                       
                        
        }

        
        public void addField(String contents) 
        {
                        MyBasicEditField  addedField = new MyBasicEditField()
                    {
                    public boolean isFocusable() 
                    {
                            return true;
                    }
                    public boolean isSelectionCopyable() 
                    {
                            return false;
                    }
                    public boolean keyChar(char key, int status, int time) 
                    {
                            boolean retval = false;
                            switch (key) 
                            {
                                    case Characters.ENTER:
                                            
                            }
                            return retval;
                    }
                    protected void paint(Graphics graphics)
                    {
                            super.paint(graphics);
                            // draw and underscore
                            graphics.drawRect(this.getFont().getAdvance(getLabel()) , 0, getWidth(), getHeight());
                    }
        
        
                };
                addedField.setLabel(Integer.toString(extraSteps_.size()+1));
                addedField.setText(contents);
                addedField.setCursorPosition(contents.length());
                add(addedField);
                extraSteps_.addElement("");
                delete(addField_);
                add(addField_);
                delete(nextField_);
                add(nextField_);
        }
        public void fieldSelected() {
           Vector extraSteps = new Vector();
           for(int i=0; i < this.getFieldCount(); i++)
           {
                   Field field = this.getField(i);
                   if(field instanceof MyBasicEditField)
                   {
                           MyBasicEditField basicField = (MyBasicEditField)field;
                     
                 
                           if(!basicField.getText().equals(""))
                           {
                         extraSteps.addElement(basicField.getText());
                              
                           }
                   }
           }
          
                 if(pauseScreen_ == 1)
             {
                         AddCardName.datamodel_.setExtraSteps_(extraSteps);
                         AddCardAddPause screen = new AddCardAddPause(1);
                 UiApplication.getUiApplication().pushScreen(screen);
             }
             if(pauseScreen_ == 2)
             {
                 AddCardName.datamodel_.setExtraSteps1_(extraSteps);
                         AddCardAddPause screen = new AddCardAddPause(2);
                 UiApplication.getUiApplication().pushScreen(screen);
             }
             if(pauseScreen_ == 3)
             {
                 AddCardName.datamodel_.setExtraSteps2_(extraSteps);
                         AddCardAddPause screen = new AddCardAddPause(3);
                 UiApplication.getUiApplication().pushScreen(screen);
                 
             }
             
              
             
          
        }

}


