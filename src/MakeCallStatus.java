import net.rim.device.api.ui.Screen;
import net.rim.device.api.ui.UiApplication;
import net.rim.blackberry.api.phone.PhoneListener;
import net.rim.blackberry.api.invoke.PhoneArguments;
import net.rim.blackberry.api.invoke.Invoke;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.system.Bitmap;

//create a new screen that extends MainScreen, which provides
//default standard behavior for BlackBerry applications
public class MakeCallStatus extends MyBaseScreen implements PhoneListener
{    
        public String dialNumber_;
        
        public MakeCallStatus()
        {
                super();           
        }   
        
        public void placeCall(String dialNumber)
        {
                dialNumber_ = dialNumber;
                net.rim.device.api.ui.UiApplication.getUiApplication().invokeLater( new MyRunnable());

                
        }


                public void callAdded(int arg0) {
                        
                }


                public void callAnswered(int arg0) { 
                }


                public void callConferenceCallEstablished(int arg0) {
                }


                public void callConnected(int arg0) {
                }


                public void callDirectConnectConnected(int arg0) {
                        // TODO Auto-generated method stub
                }


                public void callDirectConnectDisconnected(int arg0) {
                    System.exit(0);
                        // TODO Auto-generated method stub
                }


                public void callDisconnected(int arg0) {
                       //System.exit(0);
                }


                public void callEndedByUser(int arg0) {
                    //System.exit(0);
                }


                public void callFailed(int arg0, int arg1) {
                }


                public void callHeld(int arg0) {
                }


                public void callIncoming(int arg0) {
                }


                public void callInitiated(int arg0) {
                }


                public void callRemoved(int arg0) {
                }


                public void callResumed(int arg0) {
                }


                public void callWaiting(int arg0) {
                }


                public void conferenceCallDisconnected(int arg0) {
                   // System.exit(0);
                }
                

                public class MyRunnable implements Runnable
                {

                        private Thread thread;

                        /** Creates a new instance of MyRunnable */
                        public MyRunnable() 
                        { 
                            super();
                            thread = new Thread(this);
                        
                        }

                        public void run() 
                        {
                            try 
                            {
                                    Invoke.invokeApplication( Invoke.APP_TYPE_PHONE, new PhoneArguments( PhoneArguments.ARG_CALL, dialNumber_ ) );        
                                    System.exit(0);
                            } 
                            catch (Exception e) 
                            {
                        
                            }
                        } 
                      }

        

}


