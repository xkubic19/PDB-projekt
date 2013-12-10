package cz.vutbr.fit.pdb.gui;

import cz.vutbr.fit.pdb.utils.DatePicker;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Doma
 */
public class Sluzby extends javax.swing.JPanel {

    /**
     * Creates new form Sluzby
     */
    public Sluzby() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_sluzby = new javax.swing.JPanel();
        wrapper = new javax.swing.JPanel();
        nazev_skuzby = new javax.swing.JLabel();
        den_label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detail_dne_table = new javax.swing.JTable();
        date_field = new cz.vutbr.fit.pdb.utils.ObservingTextField();
        kalendar = new javax.swing.JLabel();

        panel_sluzby.setBorder(javax.swing.BorderFactory.createTitledBorder("Vyberte službu"));

        javax.swing.GroupLayout panel_sluzbyLayout = new javax.swing.GroupLayout(panel_sluzby);
        panel_sluzby.setLayout(panel_sluzbyLayout);
        panel_sluzbyLayout.setHorizontalGroup(
            panel_sluzbyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        panel_sluzbyLayout.setVerticalGroup(
            panel_sluzbyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 611, Short.MAX_VALUE)
        );

        nazev_skuzby.setText("Nazev sluzby");

        den_label.setText("Den:");

        detail_dne_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(detail_dne_table);

        date_field.setText("dd/mm/yy");
        date_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date_fieldActionPerformed(evt);
            }
        });

        kalendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Calender Month.png"))); // NOI18N
        kalendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kalendarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout wrapperLayout = new javax.swing.GroupLayout(wrapper);
        wrapper.setLayout(wrapperLayout);
        wrapperLayout.setHorizontalGroup(
            wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wrapperLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nazev_skuzby, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(wrapperLayout.createSequentialGroup()
                        .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(wrapperLayout.createSequentialGroup()
                                .addComponent(den_label)
                                .addGap(1, 1, 1)
                                .addComponent(date_field, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(kalendar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        wrapperLayout.setVerticalGroup(
            wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wrapperLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nazev_skuzby)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(date_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(den_label))
                    .addComponent(kalendar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_sluzby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_sluzby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void kalendarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kalendarMouseClicked
        String lang = null;
        final Locale locale = getLocale(lang);
        DatePicker dp = new DatePicker(date_field, locale);
        // previously selected date
        Date selectedDate = dp.parseDate(date_field.getText());
        dp.setSelectedDate(selectedDate);
        dp.start(date_field);
    }//GEN-LAST:event_kalendarMouseClicked

    private void date_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_date_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_date_fieldActionPerformed

     private Locale getLocale(String loc) {
        if (loc != null && loc.length() > 0) {
            return new Locale(loc);
        } else {
            return Locale.US;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cz.vutbr.fit.pdb.utils.ObservingTextField date_field;
    private javax.swing.JLabel den_label;
    private javax.swing.JTable detail_dne_table;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kalendar;
    private javax.swing.JLabel nazev_skuzby;
    private javax.swing.JPanel panel_sluzby;
    private javax.swing.JPanel wrapper;
    // End of variables declaration//GEN-END:variables
}
