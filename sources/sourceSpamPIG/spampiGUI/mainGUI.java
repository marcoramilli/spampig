/*
 * mainGUI.java
 *
 * Created on 30 gennaio 2006, 17.53
 */

package spampiGUI;
import javax.swing.*;
import java.io.*;
import rcm.awt.Constrain;
import rcm.awt.PopupDialog;
import java.awt.*;
import core.*;
import blackList.*;
import thread.*;
import websphinx.*;
import websphinx.workbench.*;
import tools.*;

/**
 *
 * @author  Stefano
 */
public class mainGUI extends javax.swing.JFrame {
    private aboutFrame a;
    private mailViewer mv;
    private optionGUI og;
        private Filter filter;
        private Theory_Interface th;
    /** Creates new form mainGUI */
    public mainGUI() {
        filter = new Filter(); // filter for the mail box
        Theory_Interface th = new Theory_Interface(); // theory interface
        og = new optionGUI();
        
        //this.setDefaultLookAndFeelDecorated(false);
        //this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        //this.setWindowDecorationStyle(JRootPane.FRAME);
        a = new aboutFrame();
        mv = new mailViewer(a);
        this.setSize(500,400);
        initComponents();
        jTextArea1.setText("Welcome to SpamPI 0.1\n");
        jTextArea1.append("-------------------------\n");
        
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jProgressBar2 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Select Mails for auto-knowledge"),BorderFactory.createEmptyBorder(5,5,5,5)));
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        Menu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        MailViewerItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        ExitItem = new javax.swing.JMenuItem();
        OptionMenu = new javax.swing.JMenu();
        optionMenuItem = new javax.swing.JMenuItem();
        AboutMenu = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SpamPIG");
        jPanel1.setLayout(new java.awt.GridLayout(2, 3, 2, 6));

        jLabel1.setText("<html><b><font color=\"blue\">Ham Mails</b></html>");
        jPanel1.add(jLabel1);

        jTextField1.setText("Empty path");
        jPanel1.add(jTextField1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spampiGUI/search.gif")));
        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.add(jButton1);

        jLabel2.setText("<html><b><font color=\"red\">Spam Mails</b></html>");
        jPanel1.add(jLabel2);

        jTextField2.setText("Empty path");
        jPanel1.add(jTextField2);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spampiGUI/search.gif")));
        jButton2.setText("Browse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.add(jButton2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("SpamPI Event Log"));
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Courier", 0, 12));
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spampiGUI/refresh.gif")));
        jButton3.setText("Refresh Auto Knowledge");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spampiGUI/processmail.gif")));
        jButton4.setText("Process Mail Server");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jToolBar1.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spampiGUI/btn_dns_bg.gif")));
        jButton5.setText("Update Blacklist Server Theory");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jToolBar1.add(jButton5);

        jPanel3.add(jToolBar1, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        Menu.setText("Menu");
        Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuActionPerformed(evt);
            }
        });

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spampiGUI/theory.gif")));
        jMenuItem1.setText("View Theory");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });

        Menu.add(jMenuItem1);

        MailViewerItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spampiGUI/note_edit.gif")));
        MailViewerItem.setText("Open Mail Viewer");
        MailViewerItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MailViewerItemActionPerformed(evt);
            }
        });

        Menu.add(MailViewerItem);

        Menu.add(jSeparator1);

        ExitItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spampiGUI/nav_logout.gif")));
        ExitItem.setText("Exit");
        ExitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitItemActionPerformed(evt);
            }
        });

        Menu.add(ExitItem);

        jMenuBar2.add(Menu);

        OptionMenu.setText("Options");
        optionMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spampiGUI/option.gif")));
        optionMenuItem.setText("Change Options");
        optionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionMenuItemActionPerformed(evt);
            }
        });

        OptionMenu.add(optionMenuItem);

        jMenuBar2.add(OptionMenu);

        AboutMenu.setText("About");
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spampiGUI/nav_help.gif")));
        jMenuItem2.setText("About SpamPI");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });

        AboutMenu.add(jMenuItem2);

        jMenuBar2.add(AboutMenu);

        jMenu1.setText("Tools");
        jMenuItem3.setText("WebSpider");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem3MouseClicked(evt);
            }
        });

        jMenu1.add(jMenuItem3);

        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-600)/2, (screenSize.height-366)/2, 600, 366);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
// TODO add your handling code here: 
      
       new Thread(new WebSpiderThread()).start() ;
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MouseClicked
// TODO add your handling code here:
     
    }//GEN-LAST:event_jMenuItem3MouseClicked

    private void optionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionMenuItemActionPerformed
// TODO add your handling code here:
        og.setVisible(true);
    }//GEN-LAST:event_optionMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
       //new viewTheoryGUI().setVisible(true); 
       new Thread(new thread.ViewTheoryThread()).start();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_MenuActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
// TODO add your handling code here:
        // from online blackList it makes the firs general theory.
        //black.setTheoryInterface(this.th);
        new thread.DownloadAndMakeTheoryFromBlack();
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
        // SpamPiG is processing your pop mail.
        new ControlMailThread(new Theory_Interface(),this );

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
        //filter.setBlackPath(jTextField2.getText());
        //filter.sethamPath(jTextField1.getText());
        //filter.setTheoryInterface(th);
        
       // from ham and black mail folder to prolog theory
        if(jTextField1.getText().equals("") == true)
            new thread.AutoAckThread("Empty path",jTextField1.getText() );
        else if (jTextField2.getText().equals("") == true)
            new thread.AutoAckThread(jTextField2.getText(),"Empty path" );
        else if (jTextField1.getText().equals("") == true && jTextField2.getText().equals("") == true )
            new thread.AutoAckThread("Empty path","Empty path" );
        else
            new thread.AutoAckThread(jTextField2.getText(),jTextField1.getText() );
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void MailViewerItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MailViewerItemActionPerformed
// TODO add your handling code here:
        mv.setVisible(true);
    }//GEN-LAST:event_MailViewerItemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
// TODO add your handling code here:
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void ExitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitItemActionPerformed
// TODO add your handling code here:
        this.setVisible(false);
        //this.hide();
        //this.dispose();
        System.exit(0);
    }//GEN-LAST:event_ExitItemActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
        final JFileChooser fc=new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setBackground(new java.awt.Color(255,255,0));
        int returnVal = fc.showOpenDialog(new JDialog());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            jTextField2.setText(file.getAbsoluteFile().getPath());
            this.setText("Directory \""+file.getAbsoluteFile().getPath()+"\"\n selected for BlackList Knowledge.\n");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        final JFileChooser fc=new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setBackground(new java.awt.Color(255,255,0));
        int returnVal = fc.showOpenDialog(new JDialog());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            jTextField1.setText(file.getAbsoluteFile().getPath());
            this.setText("Directory \""+file.getAbsoluteFile().getPath()+"\"\n selected for Ham Knowledge.\n");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
 
    public void setText(String text) {
        jTextArea1.append(text);
    }
    public void cleanText() {
        jTextArea1.setText("");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainGUI().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AboutMenu;
    private javax.swing.JMenuItem ExitItem;
    private javax.swing.JMenuItem MailViewerItem;
    private javax.swing.JMenu Menu;
    private javax.swing.JMenu OptionMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem optionMenuItem;
    // End of variables declaration//GEN-END:variables
    
}
