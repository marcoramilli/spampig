/*
 * ProgressFrameThread.java
 *
 * Created on 20 gennaio 2007, 11.14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package thread;

import spampiGUI.progressFrame;

/**
 *
 * @author marcoramilli
 */
public class ProgressFrameThread implements Runnable{
    private progressFrame pf;
    
    /** Creates a new instance of ProgressFrameThread */
    public ProgressFrameThread(String text,int max) {
             pf = new progressFrame();
             pf.setText(text);
             pf.setMax(max);
             
    }
    
    public void run(){

    
    }
    public void goOn(int p){
        pf.setProgress(p);
    }

}
