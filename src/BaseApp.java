import net.rim.device.api.system.Characters;
import net.rim.device.api.system.KeyListener;
import net.rim.device.api.system.TrackwheelListener;
import net.rim.device.api.ui.ContextMenu;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.Menu;

public abstract class BaseApp extends UiApplication implements KeyListener, TrackwheelListener {
   
   
    public BaseApp() 
    {
  
    }
    /* Override this method to add custom menu items. */
    protected void makeMenu( Menu menu, int instance) {
        Field focus = UiApplication.getUiApplication(). 
        getActiveScreen().getLeafFieldWithFocus();
        if(focus != null) {
            ContextMenu contextMenu = focus.getContextMenu();
            if( !contextMenu.isEmpty()) {
                menu.add(contextMenu);
                menu.addSeparator();
            }
        }
//        menu.add(_closeItem);
    }
    /* Invoked when the trackwheel is clicked. */
    public boolean trackwheelClick( int status, int time ) {
        Menu menu = new Menu();
        makeMenu( menu, 0);
        menu.show();
        return true;
    }
    /* Invoked when the trackwheel is released. */
    public boolean trackwheelUnclick( int status, int time ) {
        return false;
    }
    /* Invoked when the trackwheel is rolled. */
    public boolean trackwheelRoll(int amount, int status, int time) {
        return false;
    }
    public boolean keyChar(char key, int status, int time) {
        /* Intercept the ESC key and exit the application. */
        boolean retval = false;
        switch (key) {
            case Characters.ESCAPE:
            onExit();
            System.exit(0);
            retval = true;
            break;
        }
        return retval;
    }
    /* Implementation of KeyListener.keyDown(). */
    public boolean keyDown(int keycode, int time) {
        return false;
    }
    /* Implementation of KeyListener.keyRepeat(). */
    public boolean keyRepeat(int keycode, int time) {
        return false;
    }
    /* Implementation of KeyListener.keyStatus(). */
    public boolean keyStatus(int keycode, int time) {
        return false;
    }
    /* Implementation of KeyListener.keyUp(). */
    public boolean keyUp(int keycode, int time) {
        return false;
    }
    protected abstract void onExit();
}
