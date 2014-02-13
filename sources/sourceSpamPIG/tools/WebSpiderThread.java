/*
 * WebSpiderThread.java
 *
 * Created on 20 gennaio 2007, 19.42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tools;
import websphinx.*;
import rcm.awt.Constrain;
import rcm.awt.PopupDialog;
import java.awt.*;
import websphinx.*;
import websphinx.workbench.*;

/**
 *
 * @author marcoramilli
 */
public class WebSpiderThread implements Runnable{
    
    /** Creates a new instance of WebSpiderThread */
    public WebSpiderThread() {
    }
    
    public void run(){
    
       websphinx.workbench.Workbench w =  new websphinx.workbench.Workbench();
       w.setAllowExit(true);
       Frame  f = w.makeFrame();
       f.show();
    
    }
    
}
