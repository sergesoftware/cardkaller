import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import net.rim.device.api.system.PersistentObject;
import net.rim.device.api.system.PersistentStore;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.collection.util.BigVector;


public class CardKallerModel {
        private String cardName_ ="";
        private String accessNumber_ ="";
        private String cardNumber_="";
        private String pause_="";
        private String pause1_="";
        private String pause2_="";
        private String prefix_="";
        private String termination_="";
        private String pin_="";
        private Vector extraSteps_ = new Vector();
        private Vector extraSteps1_ = new Vector();
        private Vector extraSteps2_ = new Vector();
        private String advancedUser_ = "";
        private static String TOKEN = "@:";
        private static String TOKEN1 = "@;";
        public static String TOKEN2 = "@+";
        public static boolean permanentKey = false;
        public static final long MY_DATA_ID1 = 0x33fff136e98edf3fL;// stack of card names for tracking called cards
        public static final long MY_DATA_ID = 0x33fff136e98edf2fL; // data id of persistant data of names/telephone strings
        // data storage stored using colon delimited
        // extra steps are semi colon delimited
        // pauses on extra steps are + delimited
        public  CardKallerModel()
        {
                
        }
        
        public  CardKallerModel(String name, String number)
        {
                parseData(name, number);        
        }
        
        public String generateString()
        {
                String returnValue = advancedUser_ +
                                        TOKEN +
                                        accessNumber_ +
                                        TOKEN +
                                        pause_  +
                                        TOKEN;
                
                for(int i=0; i < extraSteps_.size(); i++)
                {
                        returnValue = returnValue + extraSteps_.elementAt(i);
                        if(i < extraSteps_.size()-1)
                        {
                                returnValue = returnValue +TOKEN1;
                        }
                }
                returnValue = returnValue + TOKEN;
                returnValue = returnValue + 
                                                        cardNumber_ +
                                                        TOKEN +
                                                        pause1_  +
                                                        TOKEN;
                
                for(int i=0; i < extraSteps1_.size(); i++)
                {
                        returnValue = returnValue + extraSteps1_.elementAt(i);
                        if(i < extraSteps1_.size()-1)
                        {
                                returnValue = returnValue + TOKEN1;
                        }
                }
                returnValue = returnValue + TOKEN;
                
                returnValue = returnValue + 
                pin_ +
                TOKEN +
                pause2_  +
                TOKEN;
                
                for(int i=0; i < extraSteps2_.size(); i++)
                {
                        returnValue = returnValue + extraSteps2_.elementAt(i);
                        if(i < extraSteps2_.size()-1)
                        {
                                returnValue = returnValue + TOKEN1;
                        }
                }
                returnValue = returnValue + TOKEN;
                returnValue = returnValue + 
                prefix_ +
                TOKEN +
                termination_  +
                TOKEN;
                
                return returnValue;
        }
        
        
         public String generateString(String phoneNumber)
        {
                 String returnValue = "";
                 if(advancedUser_.equals(""))
                 {
                returnValue = accessNumber_ +
                                     pause_;
                
                for(int i=0; i < extraSteps_.size(); i++)
                {
                    StringTokenizer tokenizer = new StringTokenizer((String)extraSteps_.elementAt(i), TOKEN2);
                    while(tokenizer.hasMoreElements())
                    {
                        returnValue = returnValue + tokenizer.nextElement();
                    }    
                }
             
                returnValue = returnValue + 
                              cardNumber_ +
                              pause1_ ;
                
                for(int i=0; i < extraSteps1_.size(); i++)
                {
                    StringTokenizer tokenizer = new StringTokenizer((String)extraSteps1_.elementAt(i), TOKEN2);
                    while(tokenizer.hasMoreElements())
                    {
                        returnValue = returnValue + tokenizer.nextElement();
                    }
                }
                
                returnValue = returnValue + 
                pin_ +
                pause2_;
                
                for(int i=0; i < extraSteps2_.size(); i++)
                {
                    StringTokenizer tokenizer = new StringTokenizer((String)extraSteps2_.elementAt(i), TOKEN2);
                    while(tokenizer.hasMoreElements())
                    {
                        returnValue = returnValue + tokenizer.nextElement();
                    }
                }
              
                returnValue = returnValue + 
                prefix_ +
                phoneNumber +
                termination_;
                 }
                 else
                 {
                         
                         int letterN = advancedUser_.indexOf("N");
                         if(letterN == -1)
                         {
                                 returnValue = advancedUser_ + phoneNumber;
                         }
                         else
                         {
                                 returnValue = advancedUser_.substring(0, letterN) +
                                                        phoneNumber +
                                                        advancedUser_.substring(letterN+1,advancedUser_.length() );
                         }
                 }
                
                return returnValue;
        }
        private boolean parseData(String name, String number)
        {
            try
            {
                cardName_ = name;
                StringTokenizer tokenizer = new StringTokenizer(number, TOKEN);
                advancedUser_ = tokenizer.nextElement();
                accessNumber_ = tokenizer.nextElement();
                pause_= tokenizer.nextElement();
                String extraSteps = tokenizer.nextElement();
                cardNumber_= tokenizer.nextElement();
                pause1_= tokenizer.nextElement();
                String extraSteps1 = tokenizer.nextElement();
                pin_= tokenizer.nextElement();
                pause2_= tokenizer.nextElement();
                String extraSteps2 = tokenizer.nextElement();
                prefix_= tokenizer.nextElement();
                termination_= tokenizer.nextElement();
                
                extraSteps_ = new Vector();
                if(!extraSteps.equals(""))
                {
                        tokenizer = new StringTokenizer(extraSteps, TOKEN1);
                        
                        while(tokenizer.hasMoreElements())
                        {
                                extraSteps_.addElement(tokenizer.nextElement());
                        }
                }
                
                extraSteps1_ = new Vector();
                if(!extraSteps1.equals(""))
                {
                        tokenizer = new StringTokenizer(extraSteps1, TOKEN1);
                        while(tokenizer.hasMoreElements())
                        {
                                extraSteps1_.addElement(tokenizer.nextElement());
                        }
                }
                
                extraSteps2_ = new Vector();
                if(!extraSteps2.equals(""))
                {
                        tokenizer = new StringTokenizer(extraSteps2, TOKEN1);
                        while(tokenizer.hasMoreElements())
                        {
                                extraSteps2_.addElement(tokenizer.nextElement());
                        }
                }
                return false;
            }
            catch(Throwable e)
            {
                return true;
            }
        }

        public String getCardName_() {
                return cardName_;
        }

        public void setCardName_(String cardName_) {
                this.cardName_ = cardName_;
        }

        public String getAccessNumber_() {
                return accessNumber_;
        }

        public void setAccessNumber_(String accessNumber_) {
                this.accessNumber_ = accessNumber_;
        }

        public String getCardNumber_() {
                return cardNumber_;
        }

        public void setCardNumber_(String cardNumber_) {
                this.cardNumber_ = cardNumber_;
        }

        public String getPause_() {
                return pause_;
        }

        public void setPause_(String pause_) {
                this.pause_ = pause_;
        }

        public String getPause1_() {
                return pause1_;
        }

        public void setPause1_(String pause1_) {
                this.pause1_ = pause1_;
        }

        public String getPause2_() {
                return pause2_;
        }

        public void setPause2_(String pause2_) {
                this.pause2_ = pause2_;
        }

        public String getPrefix_() {
                return prefix_;
        }

        public void setPrefix_(String prefix_) {
                this.prefix_ = prefix_;
        }

        public String getTermination_() {
                return termination_;
        }

        public void setTermination_(String termination_) {
                this.termination_ = termination_;
        }

        public String getPin_() {
                return pin_;
        }

        public void setPin_(String pin_) {
                this.pin_ = pin_;
        }

        public Vector getExtraSteps_() {
                return extraSteps_;
        }

        public void setExtraSteps_(Vector extraSteps_) {
                this.extraSteps_ = extraSteps_;
        }

        public Vector getExtraSteps1_() {
                return extraSteps1_;
        }

        public void setExtraSteps1_(Vector extraSteps1_) {
                this.extraSteps1_ = extraSteps1_;
        }

        public Vector getExtraSteps2_() {
                return extraSteps2_;
        }

        public void setExtraSteps2_(Vector extraSteps2_) {
                this.extraSteps2_ = extraSteps2_;
        }
        
        public static Hashtable getData()
        {
                PersistentObject persistentObject = PersistentStore.getPersistentObject( MY_DATA_ID );
                Hashtable myHashtable = (Hashtable)persistentObject.getContents();
                if(myHashtable == null)
                {
                    myHashtable = new Hashtable();
                }
            return myHashtable;
            
        }
        
        public static void checkDataIntegrity()
        {
            Hashtable hash = getData();
            if(hash != null)
            {
            String[] names = new String[hash.size()];
            int originalSize = hash.size();
            Enumeration enums = hash.keys();
                for(int i =0;enums.hasMoreElements();i++)
                {
                    names[i] = (String)enums.nextElement();
                    String value = (String)hash.get(names[i]);
                    if(value == null )
                    {
                        hash.remove(names[i]);
                    }
                    else
                    {
                        CardKallerModel model = new CardKallerModel();
                        if(model.parseData(names[i],value))
                        {
                             hash.remove(names[i]);
                        }
                    }
                }
                
                if(originalSize != hash.size())
                {
                    setData(hash);
                }
            }
        }
        
        public static void setData(Hashtable data)
        {
                PersistentObject persistentObject = PersistentStore.getPersistentObject( MY_DATA_ID );
            persistentObject.setContents(data);
            persistentObject.forceCommit();
            
        }
        public void prioritizeName(String name)
        {
             PersistentObject persistentObject = PersistentStore.getPersistentObject( MY_DATA_ID1 );
            BigVector vec = (BigVector)persistentObject.getContents();
                    
                    if(vec == null)
                    {
                        vec = new BigVector();
                        String[] storedNames = getStoredNames();
                        vec.addElement(name);
                        for(int i = 0; i < storedNames.length; i++)
                        {
                            vec.addElement(storedNames[i]);
                        }
                    }
                    else
                    {
                        if(vec.isEmpty())
                        {
                            String[] storedNames = getStoredNames();
                            vec.addElement(name);
                            for(int i = 0; i < storedNames.length; i++)
                            {
                                vec.addElement(storedNames[i]);
                            }
                        }
                        else
                        {
                            for(int i = 0; i < vec.size(); i++)
                            {
                                if(name.equals((String)vec.elementAt(i)))
                                {
                                    vec.removeElementAt(i);
                                    break;
                                }
                            }
                            vec.insertElementAt(name,0);
                        }                        
                    }
                    
                    persistentObject.setContents(vec);
                    persistentObject.forceCommit();
        }
        public void addCardName(String name)
        {
            PersistentObject persistentObject = PersistentStore.getPersistentObject( MY_DATA_ID1 );
            BigVector vec = (BigVector)persistentObject.getContents();
                    
                    if(vec == null)
                    {
                        vec = new BigVector();
                        String[] storedNames = getStoredNames();
                        vec.addElement(name);
                        for(int i = 0; i < storedNames.length; i++)
                        {
                             if(!name.equals(storedNames[i]))
                             {
                                vec.addElement(storedNames[i]);
                             }
                        }
                    }
                    else
                    {
                        if(vec.isEmpty())
                        {
                            String[] storedNames = getStoredNames();
                            vec.addElement(name);
                            for(int i = 0; i < storedNames.length; i++)
                            {
                                if(!name.equals(storedNames[i]))
                                {
                                    vec.addElement(storedNames[i]);
                                }
                            }
                        }
                        else
                        {
                            vec.insertElementAt(name,0);
                        }                        
                    }
                    
                    persistentObject.setContents(vec);
                    persistentObject.forceCommit();
        }
        
        private String[] getStoredNames()
        {
            Hashtable hash = getData();
            if(hash == null || hash.keys() == null)
            {
                return new String[0];
            }
            else
            {
                Enumeration enums = hash.keys();
                String[] names = new String[hash.size()];
                
                for(int i =0;enums.hasMoreElements();i++)
                {
                    names[i] = (String)enums.nextElement();
                }
                return names;
            }
        }
        public static void deleteCardName(String name)
        {
            PersistentObject persistentObject = PersistentStore.getPersistentObject( MY_DATA_ID1 );
            BigVector vec = (BigVector)persistentObject.getContents();
            if(vec == null)
            {
                Dialog.inform("Data possibly unsynced, please add a card");
            }
           
            for(int i=0; i < vec.size(); i++)
            {
                if(name.equals((String)vec.elementAt(i)))
                {
                    vec.removeElementAt(i);
                    break;
                }
            }
          
            persistentObject.setContents(vec);
            persistentObject.forceCommit();
            
        }
        
         public static String[] getCardNames()
        {
        String[] names = new String[0];
                   
        PersistentObject persistentObject = PersistentStore.getPersistentObject( MY_DATA_ID1 );
        BigVector vec = (BigVector)persistentObject.getContents();
        if(vec == null)
        {
         //   Dialog.inform("Data possibly unsynced, please add a card");
        }
        else
        {
            if(vec.isEmpty())
            {
            }
            else
            {
                names = new String[vec.size()];
                
                for(int i =0; i < vec.size();i++)
                {
                        names[i] = (String)vec.elementAt(i);
                }
            }                        
        }
        
        return names;
                    
     }
         public static String getCardData(String cardName)
     {
                 Hashtable table = getData();
                 String cardInfo = (String)table.get(cardName);
                 return cardInfo;
     
     }

    public String getAdvancedUser_() {
            return advancedUser_;
    }

    public void setAdvancedUser_(String advancedUser_) {
            this.advancedUser_ = advancedUser_;
    }
    
    public static String getExtraStepPause(String extraStep)
    {
        StringTokenizer tokenizer = new StringTokenizer(extraStep, TOKEN2);
        tokenizer.nextElement();
        return getNumberOfPauses(tokenizer.nextElement());
    }
    public static String getExtraStep(String extraStep)
    {
        StringTokenizer tokenizer = new StringTokenizer(extraStep, TOKEN2);
        return tokenizer.nextElement();
    }
    public static String getNumberOfPauses(String pauses)
        {
                String returnText = "";
                
                int count =0;
                for(int i=0; i < pauses.length(); i++)
                {
                        i = pauses.indexOf(",", i);
                        count++;
                }
                
               if(count > 0)
               {
                    returnText = Integer.toString(count);
               }        
               return returnText;
        }
        
         public static String getPauseText(String numberPauses)
        {
                String returnText = "";
                numberPauses = numberPauses.trim();
                
                if(!numberPauses.equals(""))
                {
                        for(int i=0; (i < 50) && (i <Integer.parseInt(numberPauses)); i++)
                        {
                                returnText = returnText + ",";
                        }
                }
                return returnText;
        }
        
}
