/*
 * Rule.java
 *
 * Created on 26 gennaio 2006, 17.57
 *
 * This class represent the possible rule to adopt during the conversation
 */

package core;

/**
 *
 * @author marcoramilli
 */
public class Rule {
    private String pattern;
    private String side;
    private String point;
    /** Creates a new instance of Rule */
    public Rule() {
    }
    
    
    public void setPattern(String pattern){
        this.pattern = censure(pattern);
    }
    public void setSide(String side){
        this.side = side;
    }
    public void setPoint(String point){
     this.point = point;
    }


    public String getPattern(){
        return this.pattern;
    }
    public String getSide(){
         return this.side;
    }
    public String getPoint(){
        return this.point;
    }
    public int getPointInt(){
        return Integer.parseInt(this.point);
    }
    
    private String censure(String toCensure){
        return(toCensure.replaceAll("\\[", " ").replaceAll("\\]"," ").replaceAll("\\{"," ").replaceAll("\\}"," ").replaceAll(",", " ").replaceAll(";"," ").replaceAll("\\|", " ").replaceAll("'"," ").replaceAll("\\*"," ").replaceAll("!"," ").replaceAll("\\?"," ").replaceAll("\""," ") );
    }

}
