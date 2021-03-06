import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Hashtable;
import net.rim.device.api.io.Base64InputStream;
import net.rim.device.api.io.Base64OutputStream;
import net.rim.device.api.system.PersistentObject;
import net.rim.device.api.system.PersistentStore;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.i18n.SimpleDateFormat;
import net.rim.device.api.system.DeviceInfo;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

        public final class CardKallerMain extends UiApplication {
            
            public static PersistentObject persistentObject;
                
            public static final String VERSION = "1.0";
            public static final long MY_DATA_ID = 0x33fff136e98edf2eL; // data id of persistant data of License encrypted key
            public static final String LICENSE = "licenseKey"; // hashtable key id of License
            public static String phoneNumber_="";
            public static boolean isValidLicense_ = false;
            public static CardKallerMain instance = null;
            public static void main(String[] args) throws IOException {
            
                //int deviceID = DeviceInfo.getDeviceId();
                //int convert = Integer.parseInt("2100000A", 16);
                if(args.length > 0)
                {
                        phoneNumber_ = args[0].substring(args[0].indexOf(":")+1, args[0].length()).trim();
                }
                Font font = null;
                try
                {
                    font = FontFamily.forName("BBClarity").getFont(Font.PLAIN,10);
                }
                catch(ClassNotFoundException e)
                {
                     font = font.derive(Font.PLAIN, 10);
                }
                //Font.setDefaultFont(font);
                 
                  byte[] expiry = new byte[]{'2','0','0','8','1','0','1','1','P'};
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                
               // os.write(expiry);
               Base64OutputStream stream = new Base64OutputStream(os,true, true);
               // byte[] expiry = new byte[]{'2','0','0','8','1','0','1','1','P'};
                stream.write(expiry);
                stream.close();
               
              // byte[] encodeExiry1 = stream.encode(expiry, 0, expiry.length, false, false);
               byte[] encodeExiry = os.toByteArray();

               // String encodedExpiryString = new String(encodeExiry);
               String encodedExpiryString = os.toString();
                //"encodedExpiryString"= "MjAwODEwMTFB" is 20081011
                //"encodedExpiryString"= "MjAwODEwMTFQ" is Permanent key
                if(instance == null)
                {
                    instance = new CardKallerMain();
                    instance.enterEventDispatcher();
                }
                
            }
            CardKallerMain()
            {
                start();
            }
            public void start() 
            {
                PersistentObject persistentObject = PersistentStore.getPersistentObject( MY_DATA_ID );
                String myHashtable = (String)persistentObject.getContents();
                  if(myHashtable != null)
                  {
                       Calendar cal = Calendar.getInstance();
                       long now = cal.getTime().getTime();
                        cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
                        cal.set(Calendar.YEAR, 2012);
                        cal.set(Calendar.DATE, 15);
                        if (now < cal.getTime().getTime())
                        {
                            PersistentStore.destroyPersistentObject(MY_DATA_ID);
                        }
                   }
                CardKallerModel.checkDataIntegrity();
            if(myHashtable == null)
                {
                    // enter a trial license
                    Calendar cal = Calendar.getInstance();
                    // cal.set(Calendar.MONTH, cal.get(Calendar.HOUR) + 1); // add 1 hour trial to current date
                    cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 3); // add 3 months trial to current date
                    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                    Date eval = cal.getTime();
                    String unEncodedDate = format.formatLocal(eval.getTime()) + "A";
                    
                    ByteArrayOutputStream os = new ByteArrayOutputStream();
                    try
                    {
                        Base64OutputStream stream = new Base64OutputStream(os);
                        stream.write(unEncodedDate.getBytes("UTF-8"));
                        stream.close();
                    }
                    catch(java.io.UnsupportedEncodingException e)
                    {
                    }
                    catch(java.io.IOException e1)
                    {
                        
                    }
               
                    String encodeExiry = os.toString();
                    setKey(encodeExiry);
                    isValidLicense_ = true;
                    CardKallerMainScreen mainScreen = new CardKallerMainScreen();                             
                    pushScreen(mainScreen);
                     
                
                }
            else 
            {
                String encodedExpiryString = myHashtable;
                
                //(String)myHashtable.get(LICENSE);
                if(encodedExpiryString.length() > 5)
                {
                    isValidLicense_ = isValidKey(encodedExpiryString);
                }
                else
                {
                    isValidLicense_ = isValidPINkey(encodedExpiryString);
                }
             
                if(isValidLicense_)
                {
                        if(phoneNumber_.equals(""))
                        {
                                
                                CardKallerMainScreen mainScreen = new CardKallerMainScreen();
                                
                                pushScreen(mainScreen);
                        }
                        else if(phoneNumber_.equals("NONUMBER"))
                        {
                                MakeCallPhoneNumber makeCallScreen = new MakeCallPhoneNumber();
                                UiApplication.getUiApplication().pushScreen(makeCallScreen); 
                        }
                        else
                        {
                                    CardKallerCardNameSelection screen = new CardKallerCardNameSelection(CardKallerModel.getCardNames(),phoneNumber_,1);
                                UiApplication.getUiApplication().pushScreen(screen);
                        }
                }
                else
                {
                        KeyEntryScreen screen = new KeyEntryScreen();
                        pushScreen(screen);
                }
                             
            }
                
            }
            protected void onExit() {
            } 
            
            // using handango dynamic registration
            // An RPN string of "i 0 == 121 * key + c 3 * +"
            // would add up the ASCII values of all the characters in the C/DUI({PIN).
            // Multiply that by 3 and add 121 to that.
            public static boolean isValidPINkey(String key)
            {
                boolean returnValue = false;
                try
                {
                    int intKey = Integer.parseInt(key); 
                    int pin = DeviceInfo.getDeviceId();
                    String hexPIN = Integer.toHexString(pin);
                    hexPIN = hexPIN.toUpperCase();
                    byte[] pins = hexPIN.getBytes("US-ASCII");
                    int result = 0;
                    for(int i =0; i < pins.length; i++)
                    {
                        result = result + pins[i];
                    }
                    
                    result = result * 3;
                    result = result + 121;
                    
                    if(result == intKey && key.length() <= 5)
                    {
                        CardKallerModel.permanentKey = true;
                        returnValue = true;
                    }
                }
                catch(Exception e)
                {
                    // better support ascii
                }
                
                return returnValue;
            }
            
            // old way using base64
            public static boolean isValidKey(String encodedString)
            {
               boolean returnValue = false;
               try
               {
                    if(encodedString != null)
                    {
                        byte[] encodedExpiryBytes = encodedString.getBytes();
                        byte[] decodedExpiry = new byte[9];
                        ByteArrayInputStream bais = new ByteArrayInputStream(encodedExpiryBytes); 
                        // byte[] decodedExpiry = Base64InputStream.decode(encodedExpiryBytes, 0, encodedExpiryBytes.length);
                        Base64InputStream stream = new Base64InputStream(bais);
                        int success1 = stream.read(decodedExpiry,0, decodedExpiry.length);
                        // int success = bais.read(decodedExpiry,0, decodedExpiry.length);
                        String decodedExpiryString = new String(decodedExpiry);
                        
                        returnValue = isValidDate(decodedExpiryString);
                     }
                }
                catch(IOException e)
                {
                    // should not happen
                }
                return returnValue;
            }
            
             public static boolean isValidDate(String decodedExpiryString) throws IOException
            {
                boolean returnValue = false;
                try
                {
                    int year = Integer.parseInt(decodedExpiryString.substring(0,4));
                    int month = Integer.parseInt(decodedExpiryString.substring(4,6));
                    int date = Integer.parseInt(decodedExpiryString.substring(6,8));
                     String code = decodedExpiryString.substring(8,9);
                
                    Calendar cal = Calendar.getInstance();
                    cal.set(Calendar.YEAR, year);
                    cal.set(Calendar.MONTH, month-1);
                    cal.set(Calendar.DATE, date);
                    if(code.equals("P"))
                    {
                        CardKallerModel.permanentKey = true;
                        returnValue = true;
                    }
                    else if(cal.after(Calendar.getInstance()))
                    {
                            returnValue = true;
                    }
                }
                catch(NumberFormatException e)
                {
                    
                }
                
                
                return returnValue;
                
        }
            
            public static void setKey(String key)
            {
                persistentObject = PersistentStore.getPersistentObject( MY_DATA_ID );
               synchronized(persistentObject) 
               {
                    persistentObject.setContents(key);
                    persistentObject.commit();
               }
            }
           
            
        }
