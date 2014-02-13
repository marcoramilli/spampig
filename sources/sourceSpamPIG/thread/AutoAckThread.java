/*
 * AutoAckThread.java
 *
 * Created on 15 novembre 2005
 * @Author Dott. Ing. Marco Ramilli
 * @mail: marco.ramilli@studio.unibo.it
 *
 *This class is able to translate your mail ( ham and black ) in opportuned prolog theory
 * 
 */

package thread;

import java.io.*;
import core.*;

/**
 *
 * @author marcoramilli
 */
public class AutoAckThread implements Runnable {
    
    private Thread thr;
    private Filter filter;
    private String ham;
    private String black;
    
    public AutoAckThread(String black, String ham) {
        this.ham = ham;
        this.black = black;
        filter = new Filter();
        
        thr = new Thread(this);
        thr.start();       
    }
  
    /**
     * Let's Run Thread !
     */
    public void run(){
        this.filter.setBlackPath(this.black);
        this.filter.sethamPath(this.ham);
        this.filter.setTheoryInterface(new Theory_Interface() );
        this.filter.process();
        
       
    }
    
}//thread
