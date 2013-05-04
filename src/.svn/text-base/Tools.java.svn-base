
import net.rim.device.api.ui.Screen;
class Tools
{
     public static Screen getScreen(String screenName) 
        {
            Screen screen = null;
            try
            {
            Class addCardNameClass = Class.forName(screenName);
            screen  = (Screen)addCardNameClass.newInstance();
            
            }
            catch(java.lang.InstantiationException e)
            {
                }
                catch(java.lang.ClassNotFoundException e1)
            {
            } 
             catch(java.lang.IllegalAccessException e1)
            {
            }   
          return screen;
        }
}
