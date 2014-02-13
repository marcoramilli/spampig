/*
 * checkSintaxBlackList.java
 *
 * Created on 4 febbraio 2006, 9.57
 *
 *  This class is ablE to download the black list and build a rule vector.
 */

package blackList;
import core.Rule;
import downloader.*;
import java.io.*;
import java.util.*;
import core.*;


/**
 *
 * @author Stefano
 */
public class checkSintaxBlackList {
private String content;  

// make a downloader
private Downloader d = new Downloader();

// fondamental vector !!
private Vector GOD = new Vector();
private Theory_Interface th;



    /** Creates a new instance of checkSintaxBlackList */
    public checkSintaxBlackList() {
        System.out.println("checkSintaxBlackList ready to WORK !");
    }
    
    public void setTheoryInterface(Theory_Interface th){
        this.th = th;
    }
    public void run(){
        try{
         //d.download("http://192.168.0.100/spamlist.txt");
         d.download("http://basic.wirehub.nl/spamlist.txt");
         File inFile = new File("blacklist.temp");
         FileInputStream fis  = new FileInputStream(inFile);
         BufferedReader in = new BufferedReader(new InputStreamReader(fis));
         
         String thisLine = "";
         
            // for each file line, SpamPiG make a rule.
            while ((thisLine = in.readLine()) != null) {
                    if( thisLine.endsWith("SPAMMER") == true ){
                        Rule r = new Rule();
                        r.setPattern(thisLine.split("SPAMMER")[0].trim());
                        r.setSide("address");
                        r.setPoint("11"); // 11 point we are sure that mail will be considerate as spam
                        this.GOD.addElement(r);
                    }else{
                        Rule r = new Rule();
                        r.setPattern(thisLine.split("JUNK")[0].trim());
                        r.setSide("address");
                        r.setPoint("11");// 11 point we are sure that mail will be considerate as spam
                        this.GOD.addElement(r);
                    }
                    
            }
         System.out.println("IL DIO Ž ANCORA IN TERRA !!!!!!");
         
         //update theory, from rule vector to prolog theory
         th.update_theory(GOD);
         System.out.println("IL DIO Ž VOLATO IN CIELO !!!!");
        }catch(Exception e){System.out.println(e);}
    
    }
    
    public String[] getBlackAddress() {
        
      return null;  
    }
    
}
