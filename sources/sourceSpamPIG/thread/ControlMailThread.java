/*
 * AutoAckThread.java
 *
 * Created on 15 novembre 2005
 * @Author Dott. Ing. Marco Ramilli
 * @mail: marco.ramilli@studio.unibo.it
 *
 * This class, connecto to your pop3 server, thake the "from field", "subject" and the body for each mail
 * Make an new query (thanks Theory_Interface) and wait for the return of that query.
 * In front of the mail point ControlMailThread decides if it is a spam (save it into a particulary folder) or ham (nothink)
 * 
 * 
 */

package thread;

import java.io.*;
import popClient.*;
import core.*;
import java.util.*;
import spampiGUI.*;


/**
 *
 * @author marcoramilli
 */
public class ControlMailThread implements Runnable {
    
    private Thread thr;
    private Theory_Interface th;
    private PoP3 pop ;
    private Properties prop;
    private mainGUI stamp;
    private String absolutePath;
    
   
    public ControlMailThread(Theory_Interface th, mainGUI stamp) {
       this.stamp = stamp;
        this.pop = new PoP3();
        this.th = th;
        this.prop = new Properties();
        //lettura file properties per capire indirizzo mail, user, password and pop3
        try{
            FileInputStream in = new FileInputStream("SpamPIG.properties");
            prop.load(in);
            this.absolutePath = prop.getProperty("pop.path");
            in.close();
        }catch(Exception e){System.out.println(e);}
        
        thr = new Thread(this);
        thr.start();       
    }
  
    /**
     * Let's Run Thread !
     */
    public void run(){
        //connection to pop3
        stamp.setText("Try to Connect to: "+prop.getProperty("pop.server")+"\n");
        pop.connect(prop.getProperty("pop.server"),prop.getProperty("pop.user"), prop.getProperty("pop.passwd"));
        stamp.setText("Connected to:"+prop.getProperty("pop.server")+ " \n as:"+prop.getProperty("pop.user")+ "\n");
        int MessageNumber = pop.getMessageNumber();
        stamp.setText("Message number --> "+MessageNumber+"\n");
        int point = 0;
       
        //for each message ......
        while(MessageNumber > 0){
           //make a query and wait for point. The query maker want the From, subject and body mail field.
           point = th.query_theory(pop.getFrom_Mail(MessageNumber), pop.getSubject_Mail(MessageNumber), pop.getBody_Mail(MessageNumber) );
           stamp.setText("Actually POINT: "+point+" \n");
           if(point > 5){
               try{
                   //probably are spam save this mail in SpamPiG directory to be visioned
                    stamp.setText("Probably SPM: "+MessageNumber+" Point: "+point+"\n");
                    //String boundary = "From: "+pop.getFrom_Mail(MessageNumber)+"\n"+"Subject: "+pop.getSubject_Mail(MessageNumber)+"\n\n"+pop.getBody_Mail(MessageNumber);
                    // output 
                    //System.out.println(boundary);
                    FileOutputStream fos = new FileOutputStream(this.absolutePath+"SpamPIG"+MessageNumber+".eml");
                    PrintWriter out = new PrintWriter(fos);
                    out.println(pop.getBody_Mail(MessageNumber) );
                    out.flush(); out.close(); fos.close();
                    pop.deleteMessage(MessageNumber);
                }catch(Exception e){System.out.println("Error  :"+e);}
          }
           MessageNumber = MessageNumber -1;
        }
     pop.disconnect();
     stamp.setText("Disconnected \n");
    }
    
}//thread
