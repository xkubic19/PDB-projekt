package cz.vutbr.fit.pdb.application;

import java.util.Date;
import java.util.Locale;

/**
 *
 * @author castamir
 */
public class NewPanel extends java.awt.Panel {

    /**
     * Creates new form NewPanel
     */
    public NewPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        observingTextField1 = new cz.vutbr.fit.pdb.application.ObservingTextField();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        observingTextField1.setText("observingTextField1");
        observingTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                observingTextField1ActionPerformed(evt);
            }
        });
        add(observingTextField1, java.awt.BorderLayout.CENTER);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void observingTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_observingTextField1ActionPerformed

    }//GEN-LAST:event_observingTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String lang = null;
        final Locale locale = getLocale(lang);
        DatePicker dp = new DatePicker(observingTextField1, locale);
        // previously selected date
        Date selectedDate = dp.parseDate(observingTextField1.getText());
        dp.setSelectedDate(selectedDate);
        dp.start(observingTextField1);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private cz.vutbr.fit.pdb.application.ObservingTextField observingTextField1;
    // End of variables declaration//GEN-END:variables

    private Locale getLocale(String loc) {
        if (loc != null && loc.length() > 0) {
            return new Locale(loc);
        } else {
            return Locale.US;
        }
    }
}