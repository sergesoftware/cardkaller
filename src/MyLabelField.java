import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.system.EventInjector;
import net.rim.device.api.system.EventInjector.KeyEvent;
import net.rim.device.api.system.Characters;
import net.rim.device.api.system.KeyListener;
import net.rim.device.api.ui.Keypad;

class MyLabelField extends LabelField
{
    public MyLabelField()
    {
    }
    public MyLabelField(java.lang.String text)
    {
        setText(text);
    }
     public boolean isSelectionCopyable() 
     {
        return false;
     }
     public boolean isFocusable() 
     {
         return false;
     }
                                                      
}
