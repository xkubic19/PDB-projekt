package cz.vutbr.fit.pdb.gui;

import cz.vutbr.fit.pdb.models.RezervaceModel;
import cz.vutbr.fit.pdb.utils.DatePicker;
import cz.vutbr.fit.pdb.utils.DateTime;
import cz.vutbr.fit.pdb.utils.ObservingTextField;
import java.awt.Container;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Doma
 */
public class PrehledRezervaci extends javax.swing.JPanel {

    private static final String VSECHNY_PKOKOJE = "Všechny pokoje";

    /**
     * Creates new form PrehledRezervaci
     */
    public PrehledRezervaci() {
        initComponents();
        myInit();
        initTable();
    }

    public void myInit() {
        modelRez = new RezervaceModel();
        try {
            vsechnyPokoje = modelRez.getPokoje();
        } catch (SQLException ex) {
            Logger.getLogger(PrehledRezervaci.class.getName()).log(Level.SEVERE, null, ex);
        }
        //List<String> seznamPokoju = new ArrayList<>();
        String[] comboboxItems = new String[vsechnyPokoje.size() + 1];
        for (Integer key : vsechnyPokoje.keySet()) {
            //seznamPokoju.add(vsechnyPokoje.get(key));
            //System.out.println(vsechnyPokoje.get(key)); //jedna dva tri (serazene podle klice)
        }

        rezervaceOd_field.setText(DateTime.now());
        rezervaceDo_field.setText(DateTime.now());

        modelRezervace = new RezervaceModel();
    }

    private Locale getLocale(String loc) {
        if (loc != null && loc.length() > 0) {
            return new Locale(loc);
        } else {
            return Locale.US;
        }
    }

    public void initTable() {
        updateTable();
    }

    public void updateTable() {
        model = (DefaultTableModel) pokoje_table.getModel();
        model.getDataVector().removeAllElements();

        try {
            table_data = new LinkedHashMap<>();
            String cislo_pokoje = (String) pokoje_combobox.getSelectedItem();
            Map<Integer, Map<String, Object>> data;
            if (cislo_pokoje.equals(VSECHNY_PKOKOJE)) {
                data = modelRezervace.getRezervaceVObdobi(rezervaceOd_field.getText(), rezervaceDo_field.getText());
            } else {
                data = modelRezervace.getRezervaceVObdobi(rezervaceOd_field.getText(), rezervaceDo_field.getText(), Integer.parseInt(cislo_pokoje.substring(6)));
            }
            //Ziskani modelu tabulky
            int index = 0;
            for (Map.Entry<Integer, Map<String, Object>> entry : data.entrySet()) {
                Map<String, Object> value = entry.getValue();

                String zakaznik = value.get("zakaznik").toString();
                String pokoj = "Pokoj " + value.get("pokoj").toString();
                String rezervovano_od = value.get("od").toString();
                String rezervovano_do = value.get("do").toString();

                Object[] row = new Object[]{zakaznik, pokoj, rezervovano_od, rezervovano_do};
                model.addRow(row);

                table_data.put(index, entry.getKey());
                index++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Sluzby.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Sluzby.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.fireTableDataChanged();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        prehledRezervaci_kontejner = new javax.swing.JPanel();
        novaRezervace_button = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pokoje_combobox = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pokoje_table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        rezervaceOd_field = new cz.vutbr.fit.pdb.utils.ObservingTextField();
        kalendar_od = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        rezervaceDo_field = new cz.vutbr.fit.pdb.utils.ObservingTextField();
        kalendar_do = new javax.swing.JLabel();

        novaRezervace_button.setText("Vložit novou rezervaci");
        novaRezervace_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novaRezervace_buttonActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pokoje"));

        pokoje_combobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Všechny pokoje", "Pokoj 1", "Pokoj 2", "Pokoj 3", "Pokoj 4", "Pokoj 5", "Pokoj 6", "Pokoj 7", "Pokoj 8", "Pokoj 9", "Pokoj 10" }));
        pokoje_combobox.setToolTipText("");
        pokoje_combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokoje_comboboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pokoje_combobox, 0, 185, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pokoje_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Přehled rezervací zvoleného pokoje"));

        pokoje_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Host", "Pokoj", "Od", "Do"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(pokoje_table);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setText("Zrušit rezervaci");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Vyúčtování pobytu");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Období"));

        jLabel10.setText("Od");

        rezervaceOd_field.setText("observingTextField1");
        rezervaceOd_field.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                rezervaceOd_fieldCaretUpdate(evt);
            }
        });

        kalendar_od.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Calender Month.png"))); // NOI18N
        kalendar_od.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kalendar_odMouseClicked(evt);
            }
        });

        jLabel12.setText("Do");

        rezervaceDo_field.setText("observingTextField2");
        rezervaceDo_field.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                rezervaceDo_fieldCaretUpdate(evt);
            }
        });

        kalendar_do.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Calender Month.png"))); // NOI18N
        kalendar_do.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kalendar_doMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rezervaceOd_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kalendar_od)
                .addGap(26, 26, 26)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rezervaceDo_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kalendar_do)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(rezervaceOd_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(kalendar_od))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(rezervaceDo_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(kalendar_do)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout prehledRezervaci_kontejnerLayout = new javax.swing.GroupLayout(prehledRezervaci_kontejner);
        prehledRezervaci_kontejner.setLayout(prehledRezervaci_kontejnerLayout);
        prehledRezervaci_kontejnerLayout.setHorizontalGroup(
            prehledRezervaci_kontejnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prehledRezervaci_kontejnerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(prehledRezervaci_kontejnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(prehledRezervaci_kontejnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(novaRezervace_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(prehledRezervaci_kontejnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(prehledRezervaci_kontejnerLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        prehledRezervaci_kontejnerLayout.setVerticalGroup(
            prehledRezervaci_kontejnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prehledRezervaci_kontejnerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(prehledRezervaci_kontejnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(prehledRezervaci_kontejnerLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(novaRezervace_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(294, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(prehledRezervaci_kontejner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(prehledRezervaci_kontejner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void novaRezervace_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novaRezervace_buttonActionPerformed
        RezervaceFrame frame = new RezervaceFrame(this);
        Rezervace rez = new Rezervace();
        rez.setParentFrame(frame);
        Container con = frame.getContentPane();
        con.add(rez);
        frame.setPreferredSize(new Dimension(761, 550));
        //frame.dispose();
        frame.setVisible(true);
        frame.pack();
    }//GEN-LAST:event_novaRezervace_buttonActionPerformed

    private void pokoje_comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokoje_comboboxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String selectedValue = cb.getSelectedItem().toString();
        updateTable();
    }//GEN-LAST:event_pokoje_comboboxActionPerformed

    private void kalendar_odMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kalendar_odMouseClicked
        String lang = null;
        final Locale locale = getLocale(lang);
        DatePicker dp = new DatePicker(rezervaceOd_field, locale);
        // previously selected date
        Date selectedDate = dp.parseDate(rezervaceOd_field.getText());
        dp.setSelectedDate(selectedDate);
        dp.start(rezervaceOd_field);
        //updateCheckBoxes(rezervaceOd_field.getText(),rezervaceDo_field.getText());
    }//GEN-LAST:event_kalendar_odMouseClicked

    private void kalendar_doMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kalendar_doMouseClicked
        String lang = null;
        final Locale locale = getLocale(lang);
        DatePicker dp = new DatePicker(rezervaceDo_field, locale);
        // previously selected date
        Date selectedDate = dp.parseDate(rezervaceDo_field.getText());
        dp.setSelectedDate(selectedDate);
        dp.start(rezervaceDo_field);
        //updateCheckBoxes(rezervaceOd_field.getText(),rezervaceDo_field.getText());
    }//GEN-LAST:event_kalendar_doMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        model = (DefaultTableModel) pokoje_table.getModel();
        int rows[] = pokoje_table.getSelectedRows();
        for (int i : rows) {
            System.out.println("row: " + i + ", id: " + table_data.get(i));
            try {
                modelRez.smazatRezervaci(table_data.get(i));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(getParent(), "Nepodařilo se smazat rezervaci.", "Chyba při práci s databází", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(PrehledRezervaci.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        updateTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rezervaceDo_fieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_rezervaceDo_fieldCaretUpdate
        ObservingTextField di = (ObservingTextField) evt.getSource();
        if (!"".equals(di.getText())) {
            updateTable();
        }
    }//GEN-LAST:event_rezervaceDo_fieldCaretUpdate

    private void rezervaceOd_fieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_rezervaceOd_fieldCaretUpdate
        ObservingTextField di = (ObservingTextField) evt.getSource();
        if (!"".equals(di.getText())) {
            updateTable();
        }
    }//GEN-LAST:event_rezervaceOd_fieldCaretUpdate
    private RezervaceModel modelRez;
    private Map<Integer, String> vsechnyPokoje;
    private DefaultTableModel model;
    private RezervaceModel modelRezervace;
    private Map<Integer, Integer> table_data;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel kalendar_do;
    private javax.swing.JLabel kalendar_od;
    private javax.swing.JButton novaRezervace_button;
    private javax.swing.JComboBox pokoje_combobox;
    private javax.swing.JTable pokoje_table;
    private javax.swing.JPanel prehledRezervaci_kontejner;
    private cz.vutbr.fit.pdb.utils.ObservingTextField rezervaceDo_field;
    private cz.vutbr.fit.pdb.utils.ObservingTextField rezervaceOd_field;
    // End of variables declaration//GEN-END:variables
}
