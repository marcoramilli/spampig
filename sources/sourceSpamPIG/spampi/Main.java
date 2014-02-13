/*
 * Main.java
 *
 * Created on 26 gennaio 2006, 8.52
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package spampi;
import spampiGUI.*;

import core.*; 
import popClient.*;

/**
 *
 * @author marcoramilli
 *
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
     
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        new mainGUI().setVisible(true);

        
         //checkSintaxBlackList b = new checkSintaxBlackList();
        //Theory_Interface th = new Theory_Interface();
        /*
        b.setTheory(th);
        b.run();
         
        
        
        //Downloader d = new Downloader();
        //d.download("http://basic.wirehub.nl/spamlist.txt");
        
       */ 
        
        //Filter f = new Filter();
        
        //f.setTheoryInterface(th);
        //f.setBlackPath("Empty path");
        //f.sethamPath("/Users/marcoramilli/Desktop/prova/ham");
        //f.setBlackPath("/Users/marcoramilli/Desktop/prova/black");
        //f.process();
        
       
        
       // PoP3 p = new PoP3();
        /*
        Theory_Interface th = new Theory_Interface();
        Rule r1 = new Rule();
        Rule r2 = new Rule();
        Vector v = new Vector();
        r1.setPattern("gianni.morandi");
        r1.setPoint("100");
        r1.setSide("address");
        v.addElement(r1);
        r2.setPattern("merda.a.colazione");
        r2.setPoint("-100");
        r2.setSide("address");
        v.addElement(r2);
        th.update_theory(v);
        **/
        // p.connect("box.tin.it","user","pass");
        //System.out.println("Number Mail-->"+p.getMessageNumber());
        //System.out.println("Campo From Mail 1 -->"+p.getFrom_Mail(1));
        //System.out.println("Campo Subject From Mail 1 -->"+p.getSubject_Mail(1));
        //System.out.println("Corpo del messaggio From Mail 1 -->"+p.getBody_Mail(1));
        //System.out.println("PUNTEGGIO DELLA MAIL SECONDO LA TEORIA ATTUALE ==>"+th.query_theory(p.getFrom_Mail(1), p.getSubject_Mail(1), p.getBody_Mail(1)) );
        //p.disconnect();
         
    }
    
}
