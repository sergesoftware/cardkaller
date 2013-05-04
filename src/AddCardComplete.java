import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Font;

//create a new screen that extends MainScreen, which provides
//default standard behavior for BlackBerry applications
public class AddCardComplete extends MyBaseScreen
{
        public AddCardComplete(String cardName)
        {
                //invoke the MainScreen constructor
                super();
                setTitleBitmap(1);
                // too lazy to build a layout manager, just add spaces to center screen
                MyLabelField space = new MyLabelField();
                
                add(space);
                MyLabelField space1 = new MyLabelField();
               
                add(space1);
                
                MyLabelField space2 = new MyLabelField();
                add(space2);
                
                VerticalFieldManager labelManager = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER );
                MyLabelField space3 = new MyLabelField();

                space3.setText(cardName);
                space3.setFont(Font.getDefault().derive(Font.BOLD));
                labelManager.add(space3);
                add(labelManager);
                
                VerticalFieldManager manager = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER );
                MyLabelField  CompletionLabel = new MyLabelField();
                
                CompletionLabel.setText("Card setup complete!");
                manager.add(CompletionLabel);
                add(manager);
                
                 MyLabelField space4 = new MyLabelField();
                 add(space4);
             
               VerticalFieldManager manager1 = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER );

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

                mainMenuField.setText("Main menu");
                manager1.add(mainMenuField);
                add(manager1);
                mainMenuField.setFocus();
              
        } 
         public boolean onClose()
        {
                CardKallerMainScreen cardMain = new CardKallerMainScreen();
                UiApplication.getUiApplication().pushScreen(cardMain);
                return true;
        } 

}


