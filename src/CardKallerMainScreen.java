import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.Screen;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.component.LabelField;

//create a new screen that extends MainScreen, which provides
//default standard behavior for BlackBerry applications
public class CardKallerMainScreen extends MyBaseScreen
{
        private static Bitmap addCardImage = Bitmap.getBitmapResource("addcard_70x54.png");
        private static Bitmap editCardImage = Bitmap.getBitmapResource("editcard_70x54.png");
        private static Bitmap deleteCardImage = Bitmap.getBitmapResource("deletecard_83x52.png");
        private static Bitmap callCardImage = Bitmap.getBitmapResource("makecall_70x52.png");
        private static Bitmap headerImage = Bitmap.getBitmapResource("header_240x48.png");
        private static Bitmap registerImage = Bitmap.getBitmapResource("footer_240x36.png");
        public MyBitmapField registerField;
        public static boolean isEditing_ = false;
        public CardKallerMainScreen()
        {
                //invoke the MainScreen constructor
                super();
                
                HorizontalFieldManager titleManager = new HorizontalFieldManager(HorizontalFieldManager.FIELD_HCENTER );
                MyBitmapField title = new MyBitmapField();
                title.setBitMap(headerImage);
              
                title.setDrawHeight(48);
                
                 title.setDrawWidth(240);
                title.setBitmapPosition(0,0,240,48);
                titleManager.add(title);
                setTitle(titleManager);
                 
             //   HorizontalFieldManager bitmapmanager = new HorizontalFieldManager(HorizontalFieldManager.FIELD_VCENTER|HorizontalFieldManager.FIELD_HCENTER);
               
                 HorizontalFieldManager manager = new HorizontalFieldManager();
               
                 //manager.setExtent(this.getScreen().getPreferredWidth(),100);
                 HorizontalFieldManager manager1 = new HorizontalFieldManager();
               
                 MyBitmapField  addANumber = new MyBitmapField ()
                 {
                    public void processEnter()
                    {
                        callAddCardScreen();
                    }
                 };
              
                 addANumber.setBitMap(addCardImage);
                 addANumber.setBitmapPosition(-1,-1,-1,-1);
                 manager.add(addANumber);
                 add(manager);
                 addANumber.setFocus();
                
                MyBitmapField  editACard = new MyBitmapField ()
                {
                    public void processEnter()
                    {
                        callEditScreen();
                    }
                 };
                                
                editACard.setBitMap(editCardImage);
                editACard.setBitmapPosition(-1,-1,-1,-1);
                manager.add(editACard);
             
                
                 MyBitmapField  deleteACard = new MyBitmapField ()
                 {
                   public void processEnter()
                    {
                        deleteCardScreen();       
                    }
                 };
                deleteACard.setBitMap(deleteCardImage);
                deleteACard.setBitmapPosition(-1,-1,-1,-1);
                manager1.add(deleteACard);
                
                MyBitmapField  makeACall = new MyBitmapField()
                {
                   public void processEnter()
                    {
                        callMakeCallScreen();       
                    }
                 };        
                
                makeACall.setBitMap(callCardImage);
                makeACall.setBitmapPosition(-1,-1,-1,-1);
                manager1.add(makeACall);
                add(manager1);
                    registerField = new MyBitmapField()
                    {
                        public void processEnter()
                        {
                            keyEntryScreen();
                        }
                        
                    };
                    registerField.setBitMap(registerImage);
                    registerField.setDrawWidth(240);
                    registerField.setDrawHeight(36);
                    registerField.setBitmapPosition(0,0,240,36);
                if(!CardKallerModel.permanentKey)
                {
                    add(registerField);
                }
                
    }

        public void callMakeCallScreen() 
        {
            MakeCallPhoneNumber makeCallScreen = new MakeCallPhoneNumber();
            UiApplication.getUiApplication().pushScreen(makeCallScreen);  
          
        }
        public void callAddCardScreen() 
        {
           
            Screen addCardScreen  = Tools.getScreen("AddCardName");
            UiApplication.getUiApplication().pushScreen(addCardScreen);
        }
        
        public void callEditScreen() 
        {
            CardKallerCardNameSelection screen = new CardKallerCardNameSelection(CardKallerModel.getCardNames(),"none", 2);
            UiApplication.getUiApplication().pushScreen(screen);  
          
        }
        public void deleteCardScreen() 
        {
                CardKallerCardNameSelection deleteCardScreen = new CardKallerCardNameSelection(CardKallerModel.getCardNames(),"none", 3);
            UiApplication.getUiApplication().pushScreen(deleteCardScreen);  
          
        }
        
        public void keyEntryScreen()
        {
             KeyEntryScreen screen = new KeyEntryScreen();
             UiApplication.getUiApplication().pushScreen(screen);
        }
         public boolean onClose()
        {
                System.exit(0);
                return true;
        }

}


