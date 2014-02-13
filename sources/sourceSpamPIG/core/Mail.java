/*
 * Mail.java
 *
 * Created on 28 gennaio 2006, 10.48
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package core;
import java.io.*;
import java.util.*;

/**
 *
 * @author marcoramilli
 */
public class Mail {
    protected String subject="";
    protected String body="";
    protected String address="";
    protected String ReplyTo="";
    protected String Date="";
    private int c = 0;
    


    
    private String MAIL;
    
    /** Creates a new instance of Mail */
    public Mail(String mail) {
        if (mail.endsWith(".eml")) {
            try {
                File file=new File(mail);
                FileInputStream fis=new FileInputStream(file);
                InputStreamReader isr=new InputStreamReader(fis);
                BufferedReader br=new BufferedReader(isr);
                String mailString="";
                String line="";
                while((line=br.readLine())!=null) {
                    mailString=mailString+line+"\n";
                }
                this.MAIL=mailString;
            }catch(Exception e){System.out.println("Error in OpenMail");}
        }
        else {
            this.MAIL = mail;
        }
        this.address = findString("From:");
        this.subject = findString("Subject:");
        this.body = findBody();
        this.ReplyTo= findString("Reply-To:");
        this.Date=findString("Date:");
    }
    
    private void generate(){
       
        
        
    }//generate
    
    private String findString(String pattern){
        int count = 0;
        boolean FirstOccurence = false;
        String result= "";
        while(count < MAIL.length() - pattern.length() ){
           if( MAIL.substring(count,count+pattern.length()).endsWith(pattern) && FirstOccurence == false ){   
               int c=count+pattern.length(); 
               while(MAIL.charAt(c) != '\n'){
                   result = result + MAIL.charAt(c);
                   c++;
               }
               FirstOccurence = true;
           }    
           count++;
        }//while
    return result;
    }
    
    //Now it WORKS
    private String findBody(){
        int count = 0;
        boolean FirstOccurence=false;
        String result= "";
        while(count < MAIL.length() - 4 ){ 
            if ( ((MAIL.charAt(count)=='\n')&&(MAIL.charAt(count+1)=='\n')&&(FirstOccurence==false)) || ((MAIL.charAt(count)=='\r')&&(MAIL.charAt(count+1)=='\n')&&(MAIL.charAt(count+2)=='\r')&&(MAIL.charAt(count+3)=='\n')&&(FirstOccurence==false) ) ) {
                System.out.println("THESE DIKS");
                int c = count;
                FirstOccurence=true;
                while(c < MAIL.length()){
                    result = result + MAIL.charAt(c);
                    c++;
                }//while
            }//if
            count++;
        }//while
        return result;
    }//findBody
    
    public String getSubject(){
        return this.subject;
    }
    public String getBody(){
        return this.body;//.replaceAll("<","").replaceAll(">","").replaceAll(".","").replaceAll("/","").replaceAll(":","").replaceAll(",","");
    }
    public String getDate(){
        return this.Date;
    }
    public String getAddress(){
        return MailAddress();
    }
    
    private String MailAddress(){
        String[] newAddress = this.address.split("<");
        if(newAddress.length > 1){
            return newAddress[1].replace('>',' ').toString().trim().toLowerCase();
        }else{
            return this.address;
        }
        
    } 
}//class
