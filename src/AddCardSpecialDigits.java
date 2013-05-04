import java.util.Hashtable;
import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.UiApplication;



//create a new screen that extends MainScreen, which provides
//default standard behavior for BlackBerry applications
public class AddCardSpecialDigits extends MyBaseScreen
{
        public AddCardSpecialDigits()
        {
                //invoke the MainScreen constructor
                super();
                setTitleBitmap(1);
                MyLabelField  NameLabel = new MyLabelField();
                NameLabel.setText("Do you need any");
                add(NameLabel);
                
                MyLabelField  NameLabel1 = new MyLabelField();
                NameLabel1.setText("special digits?");
                add(NameLabel1);
                
                MyLabelField  exampleLabel = new MyLabelField();
                exampleLabel.setText("(i.e International Prefixes or");
                add(exampleLabel);
                
                MyLabelField  exampleLabel1 = new MyLabelField();
                exampleLabel1.setText("Termination Characters )");
                add(exampleLabel1);
                
                UnderlinedLabelField YesField = new UnderlinedLabelField()
                {
                    public void processEnter()
                    {
                        AddCardPrefixTerm screen = new AddCardPrefixTerm();
                        UiApplication.getUiApplication().pushScreen(screen);                
                    }
                };

                YesField.setText("Yes");
                add(YesField);
                
                
                UnderlinedLabelField noField = new UnderlinedLabelField()
                {
                    public void processEnter()
                    {
                        String data = AddCardName.datamodel_.generateString();
                        String name = AddCardName.datamodel_.getCardName_();
                                                  
                        Hashtable myHashtable = CardKallerModel.getData();
                        myHashtable.put(name, data);
                        CardKallerModel.setData(myHashtable);
                        AddCardComplete screen = new AddCardComplete(AddCardName.datamodel_.getCardName_());
                        UiApplication.getUiApplication().pushScreen(screen);     
                    }
                };
                noField.setText("No");
                add(noField);
                
                UnderlinedLabelField backField = new UnderlinedLabelField()
                {
                    public void processEnter()
                    {             
                        AddCardAddPause screen = new AddCardAddPause(3);
                        UiApplication.getUiApplication().pushScreen(screen);                     
                    }
                };

                backField.setText("Back");
                add(backField);
        }
}


