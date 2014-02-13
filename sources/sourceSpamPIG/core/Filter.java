/*
 * Filter.java
 *From ham and spam folders estract each mail and set point in rule vector 
 * -100 form ham
 * +11 to other.
 */

package core;
import java.io.*;
import java.util.*;
import spampiGUI.*;

/**
 *
 * @author marcoramilli
 */
public class Filter {
    private Theory_Interface th;
    private String hamPath;
    private String blackPath;
    private Vector Rules;
    private progressFrame pf;
    
    /** Creates a new instance of Filter */
    public Filter() {
        System.out.println("Filter Creation ! ");
         Rules = new Vector();
         pf = new progressFrame();
         pf.setTitle("UPDATE AUTO-KNOWNLEDGE");
    }
    
    public void setTheoryInterface(Theory_Interface th){
        this.th = th;
    }
    public void sethamPath(String path){
        this.hamPath = path;
    }
    public void setBlackPath(String path){
        this.blackPath = path;
    }
    
    public void process(){
        
     // Process ham mail !!!
     if(this.hamPath.equalsIgnoreCase("Empty path") == false){   
        File f = new File(this.hamPath);
        String[] files = f.list();
        pf.setMax(files.length);
        pf.setVisible(true);
        for (int i = 0; i < files.length; i++) {
            pf.setText("Processing: "+ files[i].toString() );         
            pf.setProgress(i+1);
          
            
            Rule r = new Rule();
                // new ham rule, set email address to -100
                // for each mail inside  ham folder
                r.setPattern(processMail(this.hamPath + "/" + files[i].toString()).getAddress() );
                r.setSide("address");
                r.setPoint("-100");
                Rules.addElement(r);
        }
        
        pf.setVisible(false);
        pf.setProgress(0);
      }
     
     // here we are processing the black mail.
      if(this.blackPath.equalsIgnoreCase("Empty path") == false){
             System.out.println("SONO DENTRO BLACKPATH");
         File f2 = new File(this.blackPath);
        String[] files2 = f2.list();
        pf.setMax(files2.length);
        pf.setVisible(true);
        for (int i2 = 0; i2 < files2.length; i2++) {
            pf.setText("Processing: "+ files2[i2].toString() );
            pf.setProgress(i2+1);
            // we are making a black vector.
            Rule r = new Rule();
                r.setPattern(processMail(this.blackPath + "/"+ files2[i2].toString()).getAddress() );
                r.setSide("address");
                r.setPoint("11"); //address +11
             Rule r2 = new Rule();
                r2.setPattern(processMail(this.blackPath + "/"+ files2[i2].toString()).getSubject() );
                r2.setSide("subject");
                r2.setPoint("3"); // subject +3, because is most probable to match this field also in ham mail.

            Rule r3 = new Rule();
                r3.setPattern(processMail(this.blackPath + "/"+ files2[i2].toString()).getBody());
                r3.setSide("body");
                r3.setPoint("11");
                
                Rules.addElement(r);
                Rules.addElement(r2);
                Rules.addElement(r3);
        }
         
      }
        pf.setVisible(false);
        this.th.update_theory(Rules);
        
          
    }
    
    
    
    // processing mail, from a string file return a Mail object
    //in a mail object you could ask which is its address, its body, its subject
    private Mail processMail(String file){
        
        Mail m ;
        try{
        File inFile = new File(file);
        FileInputStream fis  = new FileInputStream(inFile);
        BufferedReader in = new BufferedReader(new InputStreamReader(fis));
        String mail = ""; 
        String thisLine = "";
            while ((thisLine = in.readLine()) != null) {
                    mail = mail + thisLine + "\n";
            }
         m = new Mail(mail);
        }catch(Exception e){System.out.println("Error :"+ e); return null;}
        
        return m;
    }
  /*
     * Get the extension from a file.
     */  
    public String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }   
    
    
}//class
