import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Font;
class MyBasicEditField extends BasicEditField
{
    // type used to identify which BasicEditField it is
    private int type =0;
    private boolean hasFocus = false;
    MyBasicEditField()
    {
        super();
    }
    MyBasicEditField(long style)
    {
        super(style);
    }
    public void setType(int i)
    {
        type =i;
    }
    public int getType()
    {
        return type;
    }

    protected void layout(int width, int height)
    {
        super.layout(width, getPreferredHeight());
        setExtent(width, getPreferredHeight()+6);
    }
    
    protected void drawFocus(Graphics graphics,
                            boolean on)
    {                   
        hasFocus = true;
        invalidate();
    }
    
    protected void onUnfocus()
    {                   
        hasFocus = false;
        invalidate();
    }
    protected void paint(Graphics graphics)
    {
      //     super.paint(graphics);
        // draw and underscore
        graphics.setColor(net.rim.device.api.ui.Color.LIGHTGREY);
        graphics.setFont(Font.getDefault());
        
     //   graphics.drawRect(this.getFont().getAdvance(getLabel())  , 0, getWidth(), getHeight());
        graphics.drawRoundRect(this.getFont().getAdvance(getLabel())+3 , 0, getWidth(), getHeight(),5,5);
        graphics.setColor(net.rim.device.api.ui.Color.DARKGRAY);
        graphics.drawRoundRect(this.getFont().getAdvance(getLabel())+4 , 1, getWidth()-2, getHeight()-2,5,5);
        graphics.setColor(net.rim.device.api.ui.Color.BLACK);
        graphics.drawRoundRect(this.getFont().getAdvance(getLabel())+4 , 1, getWidth()-3, getHeight()-3,5,5);
        String text = getText();
        String label = getLabel();
        if(label != null )
        {
            if( label.length() > 0)
            {
               graphics.drawText(label,2,2);
            }
            graphics.drawText(text,this.getFont().getAdvance(label)+6,2);
        }
        else
        {
            graphics.drawText(text,6,2);
        }
        
        if(hasFocus)
        {
            int x = Font.getDefault().getAdvance(getLabel()) + this.getFont().getAdvance(getText())+4;
            int y = Font.getDefault().getLeading();
            Font font = Font.getDefault().derive(Font.BOLD);
            graphics.setFont(font);
            graphics.drawText("|", x, y);
         }
     //   drawHighlightRegion(graphics,this.HIGHLIGHT_SELECT,true,2, 2, 2,5);

    }
  protected void setCursorPosition(int offset,
                                 int context)
  {
        String text = getText();
        if(text == null)
        {
            super.setCursorPosition(0,context);
        }
        else
        {
            super.setCursorPosition(text.length(),context);
        }
    }
    protected boolean trackwheelClick(int status,
                                int time)
    {
        return true;
    }
}
