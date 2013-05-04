import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.Menu;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.ContextMenu;
import net.rim.device.api.ui.MenuItem;
import net.rim.device.api.ui.Keypad;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.Field;
import net.rim.device.api.system.EventInjector;
import net.rim.device.api.ui.Keypad;
import net.rim.device.api.system.EventInjector.KeyEvent;
import net.rim.device.api.system.KeyListener;
import net.rim.device.api.ui.Keypad;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.Graphics;

public class MyBaseScreen extends MainScreen implements KeyListener
{
    private static Bitmap addCardImage = Bitmap.getBitmapResource("header_240x48.png");
    private static Bitmap editCardImage = Bitmap.getBitmapResource("header_240x48.png");
    private static Bitmap deleteCardImage = Bitmap.getBitmapResource("header_240x48.png");
    private static Bitmap callCardImage = Bitmap.getBitmapResource("header_240x48.png");
    HorizontalFieldManager titleManager;
        
   public boolean keyDown(int keycode, int time) 
   {
         if(keycode == 1179648)
         {
             System.exit(0);
         }
         return super.keyDown(keycode, time);
         //Invoked when a key has been pressed. 
        }
        
      
    public boolean keyRepeat(int keycode, int time) 
    {
           return super.keyRepeat(keycode, time);
           //Invoked when a key has been repeated. 
    }
    public boolean keyStatus(int keycode, int time) 
    {
      return super.keyStatus(keycode, time);
           //Invoked when the ALT or SHIFT status has changed. 
    }
    public boolean keyUp(int keycode, int time) 
    {
      return super.keyUp(keycode,time);
           //Invoked when a key has been released. 
    }
    
    public boolean keyChar(char key,
                       int status,
                       int time)
    {
        boolean returnValue = super.keyChar(key, status, time);
        super.getScreen().setDirty(false);
        return returnValue;
    }
    
    public void setTitleBitmap(int bmp)
    {
        titleManager = new HorizontalFieldManager(HorizontalFieldManager.FIELD_HCENTER);
        
        MyBitmapField title = new MyBitmapField();
        title.setDrawWidth(240);
        title.setDrawHeight(48);
        title.setBitmapPosition(0,0,240,48);
            
        switch(bmp){
        case 1: title.setBitMap(addCardImage);
                break;
        case 2: title.setBitMap(editCardImage);
                break;
        case 3: title.setBitMap(deleteCardImage);
                break;
        case 4: title.setBitMap(callCardImage);
                break;
        }
        titleManager.add(title);
        setTitle(titleManager);
        }
        
        protected boolean trackwheelRoll(int amount,
                                 int status,
                                 int time)
                                 {
                                     setDirty(false);
                                     return super.trackwheelRoll(amount,status,time);
                                     
                                    }
       
  //   public  void paint(Graphics graphics)
  //                  {
   //                     super.paint(graphics);
   //                     graphics.setBackgroundColor(0x003B3B3B );
   //                     graphics.setColor(0x0003B3B3B );
   //                     graphics.fillRect(0,0,getWidth(),23);
    //
     //                   }    
 //       public boolean onSave()
 //       {
 //           return true;
  //      }
     //override onClose() to display a dialog box
        //when the application is closed
 //       public boolean onClose()
 //       {
 //               Dialog.alert("Goodbye!");
 //               System.exit(0);
 //               return true;
 //       }


        //create a menu item for users to close the application
//        private MenuItem _closeItem = new MenuItem("Close", 200000, 10) 
//        {
//                public void run()
//                {
//                        onClose();
//                }
//        };
      //override onClose() to display a dialog box
        //when the application is closed
//        public boolean onSelect()
//        {
//            return true;
//        }
            
      //     EventInjector.invokeEvent(EventInjector.KEY_DOWN,Keypad.map(Keypad.KEY_ENTER ),0,100);
//      EventInjector.invokeEvent(EventInjector.KEY_UP,Keypad.map(Keypad.KEY_ENTER ),0,100);
               // call select entry, either emulate key entry or call screen getting focus
//                return true;
 //       }


        //create a menu item for users to close the application
//        private MenuItem _selectItem = new MenuItem("Select", 200000, 10) 
//        {
//                public void run()
//                {
//                        onSelect();
//                }
//        };

        //override makeMenu to add the new menu items
//        protected void makeMenu( Menu menu, int instance )
//        {
//                
//                menu.add(_closeItem);
//                menu.add(_selectItem);
//        }

protected void makeMenu(Menu menu, int instance)
{
    //The following will add the menu items associated with the current field
    //with focus (Copy, Paste, Change Option, etc...) to the top of the menu.
    Field focus = UiApplication.getUiApplication().getActiveScreen().getLeafFieldWithFocus();
    if(focus != null)
    {
        
        //      EventInjector.invokeEvent(new EventInjector.KeyEvent(EventInjector.KeyEvent.KEY_DOWN,Keypad.map(Keypad.KEY_ENTER),KeyListener.STATUS_NOT_FROM_KEYPAD,100));
        //     EventInjector.invokeEvent(new EventInjector.KeyEvent(EventInjector.KeyEvent.KEY_UP,Keypad.map(Keypad.KEY_ENTER),KeyListener.STATUS_NOT_FROM_KEYPAD,100));   
        ContextMenu contextMenu = focus.getContextMenu();
        if(!contextMenu.isEmpty())
        {
            menu.add(contextMenu);
            menu.addSeparator();
        }
    }
//If we were to call "super.makeMenu(menu, instance);" here the default menu
//items would be added (Close, Hide, etc...).
}


}
