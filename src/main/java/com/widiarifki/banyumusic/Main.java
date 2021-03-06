package com.widiarifki.banyumusic;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.util.List;
import java.util.ArrayList;
import java.util.EventListener;
import java.awt.ItemSelectable;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import org.springframework.web.client.RestTemplate;

public class Main extends javax.swing.JFrame {

    private Main mainFr = this;
    private Integer idUser = 0;
    private String namaUser;
    /**
     * Creates new form Main
     */
    public Main() {
        setTitle("Banyumusic");
        setExtendedState(MAXIMIZED_BOTH); 
        initComponents();
        this.helloLabel.setVisible(false);
        this.playlistBtn.setVisible(false);
    }

    public void afterLogin(String namaUser, Integer idUser){
        this.idUser = idUser;
        this.namaUser = namaUser;
        this.helloLabel.setText("Hi "+namaUser+" !");
        this.helloLabel.setVisible(true);
        this.playlistBtn.setVisible(true);
        this.regBtn.setVisible(false);
        this.loginBtn.setVisible(false);
    }

    public Integer getIdUser(){
        return this.idUser;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        RestTemplate client = new RestTemplate();

        /*HTTP Request*/
        List<Lagu> laguData = new ArrayList<>();
        String url = "http://widiarifki.com/banyumusic/lagu_json.php";
        Lagu rows[] = client.getForObject(url, Lagu[].class);
        for (Lagu l : rows) {
            laguData.add(l);
        }
        LaguModel laguMdl = new LaguModel(laguData);
        /*end - HTTP Request*/
        laguTbl = new javax.swing.JTable(laguMdl){
            /* agar ImageIcon muncul di kolom pertama */
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };
        
        laguTbl.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent event)
            {
              if (event.getClickCount() == 2) {

                JTable table = (JTable) event.getSource();
                LaguModel model = (LaguModel)table.getModel();
                int row = table.convertRowIndexToModel(table.getSelectedRow());
                Lagu dataRow = model.getRowAt(row);

                LaguFrame laguFr = new LaguFrame(mainFr, dataRow.getId());
                laguFr.setTitle(dataRow.getTitle());
                laguFr.setVisible(true);

              }
            }
        });

        jPanel1 = new javax.swing.JPanel();
        /*HTTP Request*/
        String[] daftarGenre = new String[1];
        daftarGenre[0] = "Semua Genre";
        String urlG = "http://widiarifki.com/banyumusic/genre_json.php";
        Genre rowsG[] = client.getForObject(urlG, Genre[].class);
        for (Genre g : rowsG) {
            String[] daftarGenreOld = daftarGenre;
            Integer arrSize = daftarGenreOld.length+1;
            daftarGenre = new String[arrSize];
            System.arraycopy(daftarGenreOld, 0, daftarGenre, 0, daftarGenreOld.length);
            daftarGenre[daftarGenreOld.length] = g.getGenre();
        }
        /*end - HTTP Request*/
        genreComboBox = new javax.swing.JComboBox(daftarGenre);
        regBtn = new javax.swing.JButton();
        loginBtn = new javax.swing.JButton();
        playlistBtn = new javax.swing.JButton();
        helloLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setLocationByPlatform(true);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jScrollPane1.setViewportView(laguTbl);
        laguTbl.setRowHeight(150);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        genreComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                changeGenreAction(itemEvent);
            }
        });

        regBtn.setText("Daftar");
        regBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regBtnActionPerformed(evt);
            }
        });

        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        playlistBtn.setText("My Playlist");
        playlistBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playlistBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(genreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(helloLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loginBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(regBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playlistBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playlistBtn)
                    .addComponent(regBtn)
                    .addComponent(loginBtn)
                    .addComponent(helloLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regBtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
        RegFrame reg = new RegFrame(this);
        reg.setVisible(true);
        reg.setTitle("Daftar");
    }                                        

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        LoginFrame login = new LoginFrame(this);
        login.setVisible(true);
        login.setTitle("Login");
    }//GEN-LAST:event_loginBtnActionPerformed

    private void playlistBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        MyPlaylist myPlaylist = new MyPlaylist(this, this.idUser);
        myPlaylist.setVisible(true);
        myPlaylist.setTitle(this.namaUser+" Playlist");
    }//GEN-LAST:event_loginBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton regBtn;
    private javax.swing.JButton loginBtn;
    private javax.swing.JButton playlistBtn;
    private javax.swing.JComboBox genreComboBox;
    private javax.swing.JLabel helloLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable laguTbl;
    // End of variables declaration//GEN-END:variables

    private void changeGenreAction(ItemEvent itemEvent) {
        int state = itemEvent.getStateChange();
        ItemSelectable is = itemEvent.getItemSelectable();
        String selected = selectedString(is);

        RestTemplate client = new RestTemplate();
        String url = "http://widiarifki.com/banyumusic/lagu_json.php?genre="+selected;
        
        List<Lagu> laguData = new ArrayList<>();
        Lagu rows[] = client.getForObject(url, Lagu[].class);
        for (Lagu l : rows) {
            laguData.add(l);
        }
        LaguModel laguMdl = new LaguModel(laguData);
        laguTbl.setModel(laguMdl);
    }

    static private String selectedString(ItemSelectable is) {
        Object selected[] = is.getSelectedObjects();
        return ((selected.length == 0) ? "null" : (String) selected[0]);
    }

}