import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.Screen;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.Font;



//create a new screen that extends MainScreen, which provides
//default standard behavior for BlackBerry applications
public class DeleteComplete extends MyBaseScreen
{    
        public DeleteComplete(String cardName)
        {
                //invoke the MainScreen constructor
                super();
                setTitleBitmap(3);
                 // too lazy to build a layout manager, just add spaces to center screen
                MyLabelField space = new MyLabelField();
                
                add(space);
                MyLabelField space1 = new MyLabelField();
               
                add(space1);
                
                MyLabelField space2 = new MyLabelField();
                add(space2);
                
                VerticalFieldManager labelManager = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
                MyLabelField  cardNameLabel = new MyLabelField();
                cardNameLabel.setText(cardName);
                //Font font = Font.getDefault().derive(Font.UNDERLINED);
                cardNameLabel.setFont(Font.getDefault().derive(Font.BOLD));
                labelManager.add(cardNameLabel);
                
                add(labelManager);
                
                VerticalFieldManager labelManager4 = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
                MyLabelField  completeLabel = new MyLabelField();
                completeLabel.setText("card deleted!");
                labelManager4.add(completeLabel);
     
                add(labelManager4);
                
                 MyLabelField space3 = new MyLabelField();
                
                add(space3);
                VerticalFieldManager labelManager3 = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
                UnderlinedLabelField mainMenuField = new UnderlinedLabelField()
                {
                     public void processEnter()
                    {
                        onClose();
                    }
                      public int getPreferredWidth()
                    {
                    Font font = Font.getDefault().derive(Font.BOLD|Font.UNDERLINED);
                        return font.getAdvance(this.getText())+10;
                    }
                };

                mainMenuField.setText("Main Menu");
                labelManager3.add(mainMenuField);
                
                add(labelManager3);
                mainMenuField.setFocus();
               
           
        }
          public boolean onClose()
        {
            Screen screen = Tools.getScreen("CardKallerMainScreen");
            UiApplication.getUiApplication().pushScreen(screen);
            return true;
        }
}


