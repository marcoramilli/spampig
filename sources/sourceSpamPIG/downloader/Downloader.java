/*
 * Downloader.java
 *
 * Created on 2 febbraio 2006, 17.50
 *
 * This class is able to download a file from network. 
 *
 *
 */

package downloader;
import java.io.*;
import java.net.*;
import spampiGUI.*;

/**
 *
 * @author marcoramilli
 */
public class Downloader {
    private URL u,u2;
    private InputStream is = null;
    private InputStream is2 = null;
    private  DataInputStream dis,dis2;
    private String s;
    private  URLConnection conn;
    private progressFrame pf = new progressFrame() ;
    /** Creates a new instance of Downloader */
    public Downloader() {
        System.out.println("Downloader is Ready to work !");
        
    }
    public void download (String UrlToDownload) {

      try {

         u = new URL(UrlToDownload);
         is = u.openStream(); 
         conn = u.openConnection();
         
         pf.setTitle("Downloader !!");
         pf.setText("I'm Downloading from BlackList");
         pf.setVisible(false);
        
         
         //outputFile
          File outFile = new File("blacklist.temp");
          FileOutputStream fos = new FileOutputStream(outFile);
          PrintWriter out = new PrintWriter(fos); 
         dis = new DataInputStream(new BufferedInputStream(is));
         System.out.println("OK, I have seen the file. Now i tkae it !");
         
         //to know the size
         int counter = 0;
         while ((s = dis.readLine()) != null) {
            counter++;
            System.out.println(counter);
         }
          //is.close();dis.close();
          
          pf.setMax(counter);
          pf.setVisible(true);
          u2 = new URL(UrlToDownload);
          is2 = u2.openStream(); 
          dis2 = new DataInputStream(new BufferedInputStream(is2));
         
         counter = 0;
         while ((s = dis2.readLine()) != null) {
            out.println(s);
            pf.setProgress(counter++);
         }
         is2.close();dis2.close();
         
        pf.setVisible(false);
        pf.dispose();

      } catch (MalformedURLException e) {

         System.out.println("Error"+e);
         e.printStackTrace();

      } catch (IOException ioe) {

         System.out.println("Oops- an IOException happened.");
         ioe.printStackTrace();
         System.exit(1);

      } finally {

         try {
            is.close();
         } catch (IOException ioe) {}

      } // end of 'finally' clause

   }  // end of main
}
