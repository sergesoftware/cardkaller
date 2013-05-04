import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;

class MyBitmapField extends BitmapField
{
    private  Bitmap myImage = null;
    private  String title = "";
    private int bwidth = -1;
    private int bheight = -1;
    private int bitmapwidth = -1;
    private int bitmapheight = -1;
    private int xposition = -1;
    private int yposition = -1;
   
    public void setBitMap(Bitmap image)
    {
        myImage = image;
    }
    public Bitmap getBitMap()
    {
        return myImage;
    }
    public String getText()
    {
        return title;
    }
    
    public int getDrawHeight()
    {
        return bheight;
    }
    public void setDrawHeight(int h)
    {
        bheight = h;
    }
    public int getDrawWidth()
    {
        return bwidth;
    }
    public void setDrawWidth(int w)
    {
        bwidth = w;
    }
    public void setText(String text)
    {
        title = text;
    }
    public void setBitmapPosition(int x, int y, int w, int h)
    {
        bitmapwidth = w;
        bitmapheight = h;
        xposition = x;
        yposition = y;
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
     public void layout(int width, int height) 
                   {
                        if(bwidth != -1 && bheight != -1)
                        {
                            setExtent(getScreen().getWidth(), bheight);
                        }
                        else
                        {
                              if(!CardKallerModel.permanentKey)
                              {
                                    setExtent(getScreen().getWidth()/2, (getScreen().getHeight()-40-48)/2);
                              }
                              else
                              {
                                    setExtent(getScreen().getWidth()/2, (getScreen().getHeight()-48)/2);
                              }
                           // setExtent(getScreen().getWidth()/2, 70);
                        }
                   }
   
                    public  void paint(Graphics graphics)
                    {
                        graphics.clear();
                        graphics.setColor(Color.LIGHTGREY);
                        graphics.drawRect(0,0 ,getWidth(),getHeight());
                        graphics.setColor(Color.WHITE);
                        graphics.setBackgroundColor(Graphics.FULL_WHITE  );
                        if(xposition != -1 && yposition != -1)
                        {
                            // draw title and register field on mainscreen
                            if(bitmapheight  != 36)
                            {
                                // customize title bar of title screens
                                // have to fill background black as bitmap doesnt fit entire screen
                                graphics.setBackgroundColor(0x00474747);
                                graphics.setColor(0x00474747);
                                graphics.clear();
                                graphics.fillRect(0,0,getScreen().getWidth()+40,getDrawHeight());
                                xposition = getScreen().getWidth()/2 -120;// center title bar
                                graphics.drawBitmap(xposition,yposition,getDrawWidth()-2,getDrawHeight(), myImage, 0,0);
                            }
                            else
                            {
                                if(!CardKallerModel.permanentKey)
                                {
                                    graphics.setColor(Color.WHITE);
                                    graphics.setBackgroundColor(Graphics.FULL_WHITE  );
                                    graphics.clear();
                                    graphics.fillRect(0,0,getScreen().getWidth(),getDrawHeight());
                                    xposition = getScreen().getWidth() - 240;// align register to the right
                                    graphics.drawBitmap(xposition,yposition,getDrawWidth()-10,getDrawHeight()-10, myImage,5 ,5);
                                }
                            }
                            
                            
                      
                        }
                        else
                        {
                            // draw 4 squares on main screen
                            graphics.drawBitmap(getWidth()/2 - myImage.getWidth()/2,(getHeight() - myImage.getHeight())/2,83,54, myImage, 0,0);
                           //graphics.drawBitmap(getWidth()/2 - myImage.getWidth()/2,50,83,54, myImage, 0,0);
                        }
                      //  graphics.setColor(Color.WHITE);
                      //  graphics.setBackgroundColor(Graphics.FULL_WHITE  );
                     //   graphics.clear();
                       // Font font = Font.getDefault().derive(Font.BOLD);
                       // graphics.setFont(font); 
                       // graphics.drawText(title,getWidth()/2- Font.getDefault().getAdvance(title)/2 ,getHeight()- Font.getDefault().getHeight() -5);
                        super.paint(graphics);
                     }
                        
                     protected void drawFocus(Graphics graphics, boolean on)
                     {
                        graphics.setColor(Color.BLACK);
                        graphics.setStrokeWidth(5); 
                        graphics.drawRect(0,0 ,getWidth(),getHeight());
                          
                         
                            }

                      public void  onUnfocus()
                      {
                            invalidate();
                      }
                        
                  
                        public boolean isFocusable() {
                                return true;
                        }
                       
                        
}
