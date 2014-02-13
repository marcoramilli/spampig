/*
 * Theory_Interface.java
 *
 * Created on 26 gennaio 2006, 8.56
 *
 * This one is the most important class, this class is able to :
 *  from Vector rule update the current prolog theory
 *  from string addres, string body and string subject make a prolog query
 */

package core;

import alice.tuprolog.*;
import java.io.*;
import java.util.*;
import javax.imageio.stream.FileImageInputStream;
import spampiGUI.*;


/**
 *
 * @author marcoramilli
 */
public class Theory_Interface {
    private  Prolog engine;
    private String theory ="theory.pl";
    private progressFrame pf = new progressFrame();
   // private int SEGMENT = 10000;
    
    /** Creates a new instance of Theory_Interface */
    public Theory_Interface() {
        makeEngine();
    }
    
    /*
     * Update Prolog Theory
     */
    public boolean update_theory(Vector rule){
        int counter = 0;
        int stop = 0;
        String query_for_update = "";
        String segno;
            /** GUI **/
            pf.setMax(rule.size());
            pf.setTitle("MAKE A PROLOG THEORY !");
            pf.setVisible(true);
            
        while(counter < rule.size()){
            // to initialize the signal var.
            pf.setText("Process Progress: "+counter+" of:"+rule.size());
            pf.setProgress(counter+1);
            pf.repaint();
            segno = " ";
            
            if(((Rule)(rule.elementAt(counter))).getPointInt() > 0 )
                segno = "+ ";
                
            if( ((Rule)(rule.elementAt(counter))).getSide().equalsIgnoreCase("address") == true ){
                // address
                 query_for_update = query_for_update + " address(['"+((Rule)(rule.elementAt(counter))).getPattern()+"'|T],Punteggio):- address(T,P), Punteggio is P "+segno+((Rule)(rule.elementAt(counter))).getPoint()+". \n";
            }
            if( ((Rule)(rule.elementAt(counter))).getSide().equalsIgnoreCase("subject") == true ){
                // subject
                 query_for_update = query_for_update + " subject(['"+((Rule)(rule.elementAt(counter))).getPattern()+"'|T],Punteggio):- subject(T,P), Punteggio is P "+segno+((Rule)(rule.elementAt(counter))).getPoint()+". \n";
            }
            if( ((Rule)(rule.elementAt(counter))).getSide().equalsIgnoreCase("body") == true ){
                // body
                query_for_update = query_for_update + " body(['"+((Rule)(rule.elementAt(counter))).getPattern()+"'|T],Punteggio):- body(T,P), Punteggio is P "+segno+((Rule)(rule.elementAt(counter))).getPoint()+". \n";  
            }
            counter++;
           // stop++;
           // if (stop==SEGMENT){
                System.out.println("Aedadeadasd");
                this.append_up_file(query_for_update);
                stop = 0;
                query_for_update= "";
            //}
        }//while
        
        //in this case i updete all the world
        //this.append_up_file(query_for_update);
        pf.setVisible(false);
        pf.dispose();
        return true;
    }
    
    /*
     * Query Prolog Theory
    */
    public int query_theory(String add, String sub, String bod){
        
               String address = censure(add);
               String  subject = censure(sub);
               String  body = censure(bod);
               
        //set new theory to query
        refreshTheory();
        System.out.println("core as refreshed the theory !!");
       int point = 0;
       Vector subjectVector = null;
       Vector bodyVector = null;
       Vector addressVector = null;
       Mail mail = new Mail(body);
       String goal = "check(['" + mail.getAddress().trim() + "'],['" + mail.getSubject().trim() + "'],['" + mail.getBody().trim() + "'],X)."; 
 
       System.out.println(goal);
       
       /*
        int c = 0 ;
        while(c < address.split(" ").length ){
            if(c < address.split(" ").length - 1 )
                goal = goal + "'"+(address.split(" "))[c]+"',";
            else
                goal = goal + "'"+(address.split(" "))[c]+"'],";
        c = c + 1;
       }
       
        c = 0 ;
        goal = goal + "[";
        while(c < subject.split(" ").length ){
        if(c < subject.split(" ").length - 1 )
                goal = goal + "'"+(subject.split(" "))[c]+"',";
            else
                goal = goal + "'"+(subject.split(" "))[c]+"'],";
        c = c + 1;
       }
       
        c = 0 ;
        goal = goal + "[";
        while(c < body.split(" ").length ){
        if(c < body.split(" ").length - 1 )
                goal = goal + "'"+(body.split(" "))[c]+"',";
            else
                goal = goal + "'"+(body.split(" "))[c]+"']";
        c = c + 1;
       }
        goal = goal + ",X).";*/
        try{
            System.out.println("I'M SOLVING YOUR GOAL !!!!! it's very hard acc..");
            SolveInfo info = this.engine.solve(goal);
            point = Integer.parseInt(info.getTerm("X").toString());
            }catch(Exception ew){System.out.println("Error Query theory "+ ew);}
        
        
        // detach the theory..... for update.
        this.clearTheory();
        return point;
    }
    
    
    /*
     * Make Prolog Engine
     **/
    private void makeEngine(){
         this.engine = new Prolog();
    }
    
    /*
     *ste theory to prolog engine
     */
    public void refreshTheory(){
        try{
        this.engine.setTheory(new Theory ( new FileInputStream(theory)) );
        }catch(Exception error){System.out.println("Error in refreshTheory"+ error );}

    }
    
    /*
     * Clear all prolog theory
     **/
    public void clearTheory(){
        this.engine.clearTheory();
    }
    
    
    //append the String at firs line of a file !
    private void append_up_file(String s){
        
        try{
         
            System.out.println("I'm appending !!!!");
            
            // temp file
            File outFile = new File("temp.tmp");
            // input
            File inFile = new File(this.theory);
            FileInputStream fis  = new FileInputStream(inFile);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            
            // output         
            FileOutputStream fos = new FileOutputStream(outFile);
            PrintWriter out = new PrintWriter(fos);
            
            String thisLine = "";
            int i =1;
            while ((thisLine = in.readLine()) != null) {
                if(i == 1) out.println(s +" \n");
                    out.println(thisLine);
                    System.out.println(thisLine);
                i++;
            }
            out.flush();
            out.close();
            in.close();
    
            inFile.delete();
            outFile.renameTo(inFile);
                        
        }catch(Exception e){System.out.println(e);} 
    }
    
   private String censure(String toCensure){
               return(toCensure.replaceAll("\\[", " ").replaceAll("\\]"," ").replaceAll("\\{"," ").replaceAll("\\}"," ").replaceAll(",", " ").replaceAll(";"," ").replaceAll("\\|", " ").replaceAll("'"," ").replaceAll("\\*"," ").replaceAll("!"," ").replaceAll("\\?"," ").replaceAll("\""," ") );
    }

}
