import java.util.Hashtable;
import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.Font;


//create a new screen that extends MainScreen, which provides
//default standard behavior for BlackBerry applications
public class DeleteCardConfirm extends MyBaseScreen
{    
        private String[] cardNames_;
        private String cardName_;
        public DeleteCardConfirm(String[] cardNames, String cardName)
        {
                //invoke the MainScreen constructor
                super();
                setTitleBitmap(3);
                cardNames_ = cardNames;
                cardName_ = cardName;
                MyLabelField deleteLabel = new MyLabelField();
                deleteLabel.setText("You have chosen to delete");
                add(deleteLabel);
                
                MyLabelField  cardNameLabel = new MyLabelField();
                cardNameLabel.setFont(Font.getDefault().derive(Font.BOLD));
                cardNameLabel.setText("\"" + cardName + "\"");
                add(cardNameLabel);
                
                MyLabelField space = new MyLabelField();
                add(space);
                
                MyLabelField confirmLabel = new MyLabelField();
                confirmLabel.setText("Please confirm:");
                add(confirmLabel);
                
                MyLabelField space1 = new MyLabelField();
                add(space1);
                
                UnderlinedLabelField confirmField = new UnderlinedLabelField()
                {
                    public void processEnter()
                    {
                        Hashtable myHashtable = CardKallerModel.getData();
                        if(myHashtable != null)
                        {
                            myHashtable.remove(cardName_);
                            CardKallerModel.deleteCardName(cardName_);
                            CardKallerModel.setData(myHashtable);
                        }

                        DeleteComplete screen = new DeleteComplete(cardName_);
                        UiApplication.getUiApplication().pushScreen(screen);
                    }
                };

                confirmField.setText("Confirm");
                add(confirmField);
                confirmField.setFocus();
                
                UnderlinedLabelField cancelField = new UnderlinedLabelField()
                {
                    public void processEnter()
                    {
                        onClose();
                    }
                };

                cancelField.setText("Cancel");
                add(cancelField);
        }
         public boolean onClose()
        {
            CardKallerMainScreen screen = new CardKallerMainScreen();
            UiApplication.getUiApplication().pushScreen(screen);
            return true;
        }
}


