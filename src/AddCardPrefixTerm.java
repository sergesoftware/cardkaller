import java.util.Hashtable;
import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.UiApplication;

//create a new screen that extends MainScreen, which provides
//default standard behavior for BlackBerry applications
public class AddCardPrefixTerm extends MyBaseScreen
{
        MyBasicEditField prefixField_;
        MyBasicEditField terminationField_;
        
        public AddCardPrefixTerm()
        {
                //invoke the MainScreen constructor
                super();
                setTitleBitmap(1);
                MyLabelField  NameLabel = new MyLabelField();
                NameLabel.setText("International prefixes dialed before");
                add(NameLabel);
                
                MyLabelField  NameLabel1 = new MyLabelField();
                NameLabel1.setText("phone number(e.g. 1, 011 )");
                add(NameLabel1);
                
                prefixField_ = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|MyBasicEditField.FILTER_INTEGER);
                
                String prefixNumber = AddCardName.datamodel_.getPrefix_();
                if(!prefixNumber.equals(""))
                {
                        prefixField_.setText(prefixNumber);
                        prefixField_.setCursorPosition(prefixNumber.length());
                }
               
                add(prefixField_);
                prefixField_.setFocus();
               
                MyLabelField  NameLabel2 = new MyLabelField();
                NameLabel2.setText("Termination characters dialed");
                add(NameLabel2);
                
                MyLabelField  NameLabel3 = new MyLabelField();
                NameLabel3.setText("after the phone number(e.g. # )");
                add(NameLabel3);
                
                terminationField_ = new MyBasicEditField(MyBasicEditField.NO_NEWLINE|
                                                         MyBasicEditField.FILTER_PHONE);
                
                String terminationNumber = AddCardName.datamodel_.getTermination_();
                if(!terminationNumber.equals(""))
                {
                        terminationField_.setText(terminationNumber);
                        terminationField_.setCursorPosition(terminationNumber.length());
                }
               
                add(terminationField_);
                
                UnderlinedLabelField nextField = new UnderlinedLabelField()
                {
                    public void processEnter()
                    {
                        AddCardName.datamodel_.setPrefix_(getPrefixText());
                        AddCardName.datamodel_.setTermination_(getTerminationText());
                        String data = AddCardName.datamodel_.generateString();
                        String name = AddCardName.datamodel_.getCardName_();
                        
                        AddCardName.datamodel_.addCardName(name);                          
                        Hashtable myHashtable = CardKallerModel.getData();
                        myHashtable.put(name, data);
                        
                        CardKallerModel.setData(myHashtable);
                        AddCardComplete screen = new AddCardComplete(name);
                        UiApplication.getUiApplication().pushScreen(screen);          
                     }
                };

                nextField.setText("Next");
                add(nextField);
                
                UnderlinedLabelField backFieldField = new UnderlinedLabelField()
                {
                    public void processEnter()
                    {
                       onClose();              
                    }
                };

                

                backFieldField.setText("Back");
                add(backFieldField);
                
               
           
        }
        
        String getPrefixText()
        {
                return prefixField_.getText().trim();
        }
        
        String getTerminationText()
        {
                return terminationField_.getText().trim();
        }
         public boolean onClose()
        {
             AddPin screen = new AddPin();
             UiApplication.getUiApplication().pushScreen(screen);
             return true;
        }
     
}


