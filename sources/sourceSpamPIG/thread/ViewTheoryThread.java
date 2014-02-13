/*
 * ViewTheoryThread.java
 *
 * Created on 20 gennaio 2007, 11.06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package thread;

import spampiGUI.viewTheoryGUI;

/**
 *
 * @author marcoramilli
 */
public class ViewTheoryThread implements Runnable{
    
    private viewTheoryGUI viewer;
    
    /** Creates a new instance of ViewTheoryThread */
    public ViewTheoryThread() {
    }
    
    public void run(){
        new viewTheoryGUI().setVisible(true);
        System.out.println("qui");
    
    }
    
}
