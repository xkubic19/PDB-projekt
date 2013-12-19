package cz.vutbr.fit.pdb.gui;

import cz.vutbr.fit.pdb.models.ObrazkyModel;
import java.awt.Color;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Zobrazi vysledky vyhledani
 *
 * @author Paulík Miroslav
 * @author Mikulica Tomáš
 * @author Gajdoš Pavel
 */
public class vyhledaniVysledky extends javax.swing.JPanel {

    /**
     * Creates new form vyhledaniVysledky
     *
     * @param id id obrazku
     */
    public vyhledaniVysledky(Integer id) {
        initComponents();
        setImageId(id);
        myInit();
    }

    /**
     * Nastavi id obrazku, pro ktery se provede vyhledani
     *
     * @param id id obrazku
     */
    public void setImageId(Integer id) {
        this.imageId = id;
    }

    /**
     * Inicializuje a zobrazí výsledky
     */
    public void myInit() {
        //label.setHorizontalAlignment(SwingConstants.LEFT);
        //FlowLayout layout = new FlowLayout();
        //layout.setAlignment(FlowLayout.LEFT);
        vysl_kontejner.setLayout(new BoxLayout(vysl_kontejner, BoxLayout.Y_AXIS));
        modelObr = new ObrazkyModel();
        Map<Integer, myIcon> result = null;
        try {
            //System.out.println("PRO ID: "+imageId);
            result = modelObr.getTheMostSimilar(imageId, 0.5, 0.5, 0.5, 0.1);
            //System.out.println("Nalezeno: "+result.size());
        } catch (SQLException ex) {
            Logger.getLogger(vyhledaniVysledky.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result != null && result.size() > 0) {
            for (Map.Entry<Integer, myIcon> entry : result.entrySet()) {
                myIcon value = entry.getValue();
                //JLabel tm = new JLabel(value.getMyIcon());
                //System.out.println("Score: " + value.getScore());
                value.setIcon(value.getMyIcon());
                value.setText(value.getScoreAsString());
                value.setToolTipText("Čím menší skóre, tím podobnější obrázek");
                vysl_kontejner.add(value);
            }
        } else if(result.size() <= 0){
            JLabel warn = new JLabel("Žádné podobné obrázky! V databázi se nachází pravděpodobně jediný obrázek");
            String path = "/icons/Info.png";
            ImageIcon i = new ImageIcon(getClass().getResource(path));
            warn.setIcon(i);
            warn.setBackground(Color.LIGHT_GRAY);
            vysl_kontejner.add(warn);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        vysl_kontejner = new javax.swing.JPanel();

        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(612, 600));

        jScrollPane1.setMaximumSize(new java.awt.Dimension(600, 600));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 600));

        vysl_kontejner.setToolTipText("Čím menší skóre, tím podobnější obrázek");

        javax.swing.GroupLayout vysl_kontejnerLayout = new javax.swing.GroupLayout(vysl_kontejner);
        vysl_kontejner.setLayout(vysl_kontejnerLayout);
        vysl_kontejnerLayout.setHorizontalGroup(
            vysl_kontejnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        vysl_kontejnerLayout.setVerticalGroup(
            vysl_kontejnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(vysl_kontejner);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    private Integer imageId;
    private ObrazkyModel modelObr;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel vysl_kontejner;
    // End of variables declaration//GEN-END:variables
}
