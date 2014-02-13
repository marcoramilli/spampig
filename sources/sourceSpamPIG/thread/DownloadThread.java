/*
 * AutoAckThread.java
 *
 * Created on 15 novembre 2005
 * @Author Dott. Ing. Marco Ramilli
 * @mail: marco.ramilli@studio.unibo.it
 *
 * This class is the thread Implementation 
 * 
 * 
 */

package thread;

import java.io.*;
import downloader.*;

/**
 *
 * @author marcoramilli
 */
public class DownloadThread implements Runnable {
    
    private Thread thr;
    private String path;
    private Downloader d;
    private spampiGUI.mainGUI stamp;
    
    public DownloadThread(String path, spampiGUI.mainGUI stamp) {
        this.stamp = stamp;
        this.path = path;
        d = new Downloader();
        thr = new Thread(this);
        thr.start();       
    }
  
    /**
     * Let's Run Thread !
     */
    public void run(){
        stamp.setText("PLEASE BE PATIENT THIS WILL TAKE MUCH TIME ! \n");
        d.download(path);
    }
    
}//thread
