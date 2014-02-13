/*
 * AutoAckThread.java
 *
 * Created on 15 novembre 2005
 * @Author Dott. Ing. Marco Ramilli
 * @mail: marco.ramilli@studio.unibo.it
 *
 * This class is able to download a black list from network, parse it and write into a theory. 
 * 
 * 
 */

package thread;

import core.Theory_Interface;
import java.io.*;
import blackList.*;

/**
 *
 * @author marcoramilli
 */
public class DownloadAndMakeTheoryFromBlack implements Runnable {
    
    private Thread thr;
    private checkSintaxBlackList bla;
   
    public DownloadAndMakeTheoryFromBlack() {
        // SpamPiG call checkSintaxBlackList to parse BL.
        bla = new checkSintaxBlackList();
        // SpamPiG build an Theory_Interface 
        bla.setTheoryInterface(new Theory_Interface() );
        thr = new Thread(this);
        thr.start();       
    }
  
    /**
     * Let's Run Thread !
     */
    public void run(){
        bla.run();
        
    }
    
}//thread
