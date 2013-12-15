package cz.vutbr.fit.pdb.gui;

import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 *
 * @author Doma
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        myInit();
    }
    
    public void myInit(){
        //iconViewer1.setIconList(rezervace2.getIconList());
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        icon_kontejner.setLayout(layout);
        iconViewer iw = new iconViewer();
        //iw.setIconList(rezervace2.getIconList());
        iw.myInit();
        iw.setVisible(true);
        icon_kontejner.add(iw);
        //icon_kontejner.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        administrace1 = new cz.vutbr.fit.pdb.gui.Administrace();
        sluzby2 = new cz.vutbr.fit.pdb.gui.Sluzby();
        jScrollPane1 = new javax.swing.JScrollPane();
        rezervace2 = new cz.vutbr.fit.pdb.gui.Rezervace();
        hotelCompoundEditablePanel1 = new cz.vutbr.fit.pdb.gui.HotelCompoundEditablePanel();
        jPanel1 = new javax.swing.JPanel();
        icon_kontejner = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PDB projekt - Hotel");

        jTabbedPane1.addTab("Administrace", administrace1);
        jTabbedPane1.addTab("Služby", sluzby2);

        jScrollPane1.setViewportView(rezervace2);

        jTabbedPane1.addTab("TMP_Nova rezervace", jScrollPane1);
        jTabbedPane1.addTab("tab5", hotelCompoundEditablePanel1);

        javax.swing.GroupLayout icon_kontejnerLayout = new javax.swing.GroupLayout(icon_kontejner);
        icon_kontejner.setLayout(icon_kontejnerLayout);
        icon_kontejnerLayout.setHorizontalGroup(
            icon_kontejnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 923, Short.MAX_VALUE)
        );
        icon_kontejnerLayout.setVerticalGroup(
            icon_kontejnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icon_kontejner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(icon_kontejner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("icon_viewer", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cz.vutbr.fit.pdb.gui.Administrace administrace1;
    private cz.vutbr.fit.pdb.gui.HotelCompoundEditablePanel hotelCompoundEditablePanel1;
    private javax.swing.JPanel icon_kontejner;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private cz.vutbr.fit.pdb.gui.Rezervace rezervace2;
    private cz.vutbr.fit.pdb.gui.Sluzby sluzby2;
    // End of variables declaration//GEN-END:variables
}
