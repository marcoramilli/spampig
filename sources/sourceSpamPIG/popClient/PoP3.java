/*
 * PoP3.java
 *
 * Created on 28 gennaio 2006, 12.59
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package popClient;
import biz.wisesoft.util.mail.*;

/**
 *
 * @author marcoramilli
 */
public class PoP3 {
    private PopClient pop;
    private EmailMessage em;
    
    /** Creates a new instance of PoP3 */
    public PoP3() {
         pop = new PopClient();
    }
    
    public void connect(String pop3,String user, String passwd){
        this.pop.connect(pop3, user, passwd);
    }
    public int getMessageNumber(){
        return pop.numberMessages ;
    }
    public String getFrom_Mail(int MailNumber){
        this.em = pop.retrieveMsg(MailNumber);
        return em.from;
    }
    
    public String getSubject_Mail(int MailNumber){
        this.em = pop.retrieveMsg(MailNumber);
        return em.subject;
    }
    public String getBody_Mail(int MailNumber){
        this.em = pop.retrieveMsg(MailNumber);
        return em.jMsg;
    }
    public void disconnect(){
         this.pop.disconnect();
    }
    public void deleteMessage(int MailNumber){
        this.pop.deleteMsg(MailNumber);

    }

}
