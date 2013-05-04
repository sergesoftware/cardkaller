import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Font;
import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.component.Dialog;

public class UnderlinedLabelField extends MyLabelField{
      UnderlinedLabelField()
      {
          super();
           Font font = Font.getDefault().derive(Font.UNDERLINED);
              setFont(font);
              
      }
        public boolean isFocusable() {
                return true;
        }
         protected void drawFocus(Graphics graphics, boolean on)
         {
            Font font = Font.getDefault().derive(Font.UNDERLINED|Font.BOLD);
            setFont(font);
            invalidate();
            getManager().invalidate();
          }

          public void  onUnfocus()
          {
              Font font = Font.getDefault().derive(Font.UNDERLINED);
              setFont(font);
              invalidate();
          }
          
           public int getPreferredWidth()
           {
              // Font font = Font.getDefault().derive(Font.BOLD|Font.UNDERLINED);
               return this.getScreen().getWidth()*3/4;
            }
            public boolean keyChar(char key, int status, int time) 
                        {
                                boolean retval = false;
                                switch (key) 
                                {
                                        case Characters.ENTER:
                                        {
                                                processEnter();
                                        }
                                }
                                return retval;
                        }
                         protected boolean trackwheelClick(int status,
                                int time)
                        {
                              processEnter();
                              return true;
                         }
             public void processEnter()
             {
             }
}
