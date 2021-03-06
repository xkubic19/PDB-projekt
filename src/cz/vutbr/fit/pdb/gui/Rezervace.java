package cz.vutbr.fit.pdb.gui;

import cz.vutbr.fit.pdb.models.ObrazkyModel;
import cz.vutbr.fit.pdb.models.ZakaznikModel;
import cz.vutbr.fit.pdb.models.RezervaceModel;
import cz.vutbr.fit.pdb.utils.DatePicker;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;

/**
 * Panel pro novou registraci 
 * @author Paulík Miroslav
 * @author Mikulica Tomáš
 * @author Gajdoš Pavel
 */
public class Rezervace extends javax.swing.JPanel {

    /**
     * Konstruktor
     */
    public Rezervace() {
        initComponents();
        myInit();
    }

    /**
     * Inicializace
     */
    public void myInit() {
        modelObr = new ObrazkyModel();
        modelZakaznik = new ZakaznikModel();
        modelRezervace = new RezervaceModel();
        checkBoxlist = new ArrayList<>();
        fc = new JFileChooser();
        fc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".jpg") || file.getName().endsWith(".jpeg")
                        || file.getName().endsWith(".png");
            }

            @Override
            public String getDescription() {
                return "Only jpeg & png files";
            }
        });
        iconList = new ArrayList<>();
        layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        defaultSearchDir = "src/icons/";
        kraj_combobox.setModel(new DefaultComboBoxModel(comboBoxItems));
        //System.out.println(new File(defaultSearchDir).getAbsolutePath());
        vozidla_kontejner.setLayout(layout);
        rezervaceDo_field.setText(now());
        rezervaceOd_field.setText(now());
        //LISTENERY
        dl = new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCheckBoxes(rezervaceOd_field.getText(), rezervaceDo_field.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent arg0) {
            }
        };
        rezervaceOd_field.getDocument().addDocumentListener(dl);
        rezervaceDo_field.getDocument().addDocumentListener(dl);
        ////////////////////////////////////////////////////////////////////////
        try {
            pokoje = modelRezervace.getPokoje();
        } catch (SQLException ex) {
            Logger.getLogger(Rezervace.class.getName()).log(Level.SEVERE, null, ex);
        }
        checkBoxlist.add(pokoj1_checkbox);
        checkBoxlist.add(pokoj2_checkbox);
        checkBoxlist.add(pokoj3_checkbox);
        checkBoxlist.add(pokoj4_checkbox);
        checkBoxlist.add(pokoj5_checkbox);
        checkBoxlist.add(pokoj6_checkbox);
        checkBoxlist.add(pokoj7_checkbox);
        checkBoxlist.add(pokoj8_checkbox);
        checkBoxlist.add(pokoj9_checkbox);
        checkBoxlist.add(pokoj10_checkbox);

        updateCheckBoxes(rezervaceOd_field.getText(), rezervaceDo_field.getText());
    }

    /**
     * Updatne checkboxy (napr. znemozni na ne klikat a odznaci je pokud je 
     * pokoj v danem odbobi obsazen) podle vybraneho datumu
     * @param _od datum od
     * @param _do datum do
     */
    public void updateCheckBoxes(String _od, String _do) {
        try {
            rezervovanePokoje = modelRezervace.rezervovanePokojeVObdobi(_od, _do);
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(Rezervace.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean allFree = true;
        for (Integer val : rezervovanePokoje) {
            for (int i = 0; i < checkBoxlist.size(); i++) {
                JCheckBox tmp = checkBoxlist.get(i);
                if (tmp.getText().equals(pokoje.get(val))) {
                    tmp.setEnabled(false);
                    allFree = false;
                    tmp.setSelected(false);
                }
            }
        }
        if (allFree) {
            //allFree = true;
            for (int i = 0; i < checkBoxlist.size(); i++) {
                checkBoxlist.get(i).setEnabled(true);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jmeno_field = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        prijmeni_field = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        adresa_field = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        mesto_field = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        psc_field = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        kraj_combobox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        telefon_field = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        email_field = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        pridatFotoAuta_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        vozidla_kontejner = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        rezervaceOd_field = new cz.vutbr.fit.pdb.utils.ObservingTextField();
        kalendar_od = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        rezervaceDo_field = new cz.vutbr.fit.pdb.utils.ObservingTextField();
        kalendar_do = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        pokoj1_checkbox = new javax.swing.JCheckBox();
        pokoj2_checkbox = new javax.swing.JCheckBox();
        pokoj3_checkbox = new javax.swing.JCheckBox();
        pokoj4_checkbox = new javax.swing.JCheckBox();
        pokoj5_checkbox = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        pokoj6_checkbox = new javax.swing.JCheckBox();
        pokoj7_checkbox = new javax.swing.JCheckBox();
        pokoj8_checkbox = new javax.swing.JCheckBox();
        pokoj9_checkbox = new javax.swing.JCheckBox();
        pokoj10_checkbox = new javax.swing.JCheckBox();
        vlozitRezervaci_button = new javax.swing.JButton();
        zpet = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Kontaktní údaje"));

        jLabel1.setText("Jméno");

        jmeno_field.setText("Pepa");

        jLabel2.setText("Přijmení");

        prijmeni_field.setText("Vozembouch");

        jLabel3.setText("Adresa");

        adresa_field.setText("Z depa, 46");

        jLabel4.setText("Město");

        mesto_field.setText("Depo");

        jLabel5.setText("PSČ");

        psc_field.setText("12345");

        jLabel6.setText("Zvolte kraj");

        kraj_combobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Telefon");

        telefon_field.setText("777666555");

        jLabel8.setText("E-mail");

        email_field.setText("pepa@zdepa.cz");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jmeno_field)
            .addComponent(prijmeni_field)
            .addComponent(adresa_field)
            .addComponent(mesto_field)
            .addComponent(psc_field)
            .addComponent(kraj_combobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(telefon_field)
            .addComponent(email_field, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jmeno_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prijmeni_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adresa_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mesto_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(psc_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kraj_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telefon_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Automobily"));

        pridatFotoAuta_button.setText("Přidej");
        pridatFotoAuta_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridatFotoAuta_buttonActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Fotografie"));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout vozidla_kontejnerLayout = new javax.swing.GroupLayout(vozidla_kontejner);
        vozidla_kontejner.setLayout(vozidla_kontejnerLayout);
        vozidla_kontejnerLayout.setHorizontalGroup(
            vozidla_kontejnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );
        vozidla_kontejnerLayout.setVerticalGroup(
            vozidla_kontejnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(vozidla_kontejner);

        jButton1.setText("Smaž");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pridatFotoAuta_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pridatFotoAuta_button)
                    .addComponent(jButton1))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Období"));

        jLabel10.setText("Od");

        rezervaceOd_field.setText("observingTextField1");

        kalendar_od.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Calender Month.png"))); // NOI18N
        kalendar_od.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kalendar_odMouseClicked(evt);
            }
        });

        jLabel12.setText("Do");

        rezervaceDo_field.setText("observingTextField2");

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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rezervaceDo_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kalendar_do))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rezervaceOd_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kalendar_od)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(rezervaceOd_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kalendar_od))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(rezervaceDo_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kalendar_do))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Pokoje"));

        pokoj1_checkbox.setText("Pokoj 1");

        pokoj2_checkbox.setText("Pokoj 2");

        pokoj3_checkbox.setText("Pokoj 3");

        pokoj4_checkbox.setText("Pokoj 4");

        pokoj5_checkbox.setText("Pokoj 5");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pokoj2_checkbox)
                    .addComponent(pokoj3_checkbox)
                    .addComponent(pokoj4_checkbox)
                    .addComponent(pokoj5_checkbox)
                    .addComponent(pokoj1_checkbox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pokoj1_checkbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pokoj2_checkbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pokoj3_checkbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                .addComponent(pokoj4_checkbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pokoj5_checkbox))
        );

        pokoj6_checkbox.setText("Pokoj 6");

        pokoj7_checkbox.setText("Pokoj 7");

        pokoj8_checkbox.setText("Pokoj 8");

        pokoj9_checkbox.setText("Pokoj 9");

        pokoj10_checkbox.setText("Pokoj 10");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pokoj6_checkbox)
                    .addComponent(pokoj8_checkbox)
                    .addComponent(pokoj9_checkbox)
                    .addComponent(pokoj7_checkbox)
                    .addComponent(pokoj10_checkbox))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pokoj6_checkbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pokoj7_checkbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pokoj8_checkbox)
                .addGap(3, 3, 3)
                .addComponent(pokoj9_checkbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pokoj10_checkbox))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        vlozitRezervaci_button.setText("Vložit rezervaci");
        vlozitRezervaci_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vlozitRezervaci_buttonActionPerformed(evt);
            }
        });

        zpet.setText("Zpět");
        zpet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zpetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(vlozitRezervaci_button)
                .addGap(18, 18, 18)
                .addComponent(zpet)
                .addGap(323, 323, 323))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vlozitRezervaci_button)
                    .addComponent(zpet))
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pridatFotoAuta_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridatFotoAuta_buttonActionPerformed
        fc.setCurrentDirectory(new File(defaultSearchDir));
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnVal = fc.showOpenDialog(fc);
        myIcon ic = null;
        boolean load = true;

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fc.getSelectedFile();
                //String path = "/icons/"+file.getName();
                System.out.println(file.getAbsoluteFile());
                try {
                    icon = new ImageIcon(file.getCanonicalPath().toString());
                } catch (IOException ex) {
                    Logger.getLogger(Rezervace.class.getName()).log(Level.SEVERE, null, ex);
                }
                ic = new myIcon();
                ic.setPreferredSize(new Dimension(60, 60));
                ic.setPath(file.getCanonicalPath().toString());
            } catch (IOException ex) {
                Logger.getLogger(Rezervace.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Cancelled by user.");
            load = false;
        }
        if (icon != null && load) {
            //Jen pro zobrazeni, stejne se do DB ulozi cely obrazek
            Image img = icon.getImage();
            Image scaledImg = img.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
            ic.setIcon(new ImageIcon(scaledImg));
            iconList.add(ic);
            vozidla_kontejner.add(iconList.get(iconList.size() - 1));
            vozidla_kontejner.revalidate();
        }
    }//GEN-LAST:event_pridatFotoAuta_buttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        it = iconList.listIterator();
        myIcon tmp;
        while (it.hasNext()) {
            tmp = it.next();
            if (tmp.isActive()) {
                tmp.setVisible(false);
                tmp.setIcon(null);
                it.remove();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Provede vlozeni zaznamu do DB
     */
    private void vlozitRezervaci_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vlozitRezervaci_buttonActionPerformed
        int zakaznik_id;
        boolean again = false;
        String jmeno = jmeno_field.getText();
        String prijmeni = prijmeni_field.getText();
        String adresa = adresa_field.getText();
        String mesto = mesto_field.getText();
        String psc = psc_field.getText();
        String kraj = (String) kraj_combobox.getSelectedItem();
        String telefon = telefon_field.getText();
        String email = email_field.getText();
        String rezervaceOd = rezervaceOd_field.getText();
        String rezervaceDo = rezervaceDo_field.getText();
        if (jmeno.equals("") || prijmeni.equals("") || adresa.equals("") || mesto.equals("")
                || psc.equals("") || kraj.equals("") || telefon.equals("") || email.equals("")) {
            JOptionPane.showMessageDialog(getParent(), "Všechna pole musí být vyplněna, prosím vyplňte je!", "Chyba", JOptionPane.ERROR_MESSAGE);
            again = true;
        } else {
            try {
                List<Integer> rezervace = new ArrayList<>();
                boolean roomChecked = false;
                for (int i = 0; i < checkBoxlist.size(); i++) {
                    JCheckBox ch = checkBoxlist.get(i);
                    if (ch.isSelected()) {
                        rezervace.add(i + 1);
                        roomChecked = true;
                    }
                }
                if (!roomChecked) {
                    JOptionPane.showMessageDialog(getParent(), "Není vybrán žádný pokoj!", "Chyba", JOptionPane.ERROR_MESSAGE);
                    again = true;
                } else {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date d_od = sdf.parse(rezervaceOd);
                    Date d_do = sdf.parse(rezervaceDo);

                    if (d_od.compareTo(d_do) > 0) {
                        throw new InvalidDateIntervalException("Datum konce rezervace musí předcházet datumu začátku.", 1);
                    }

                    Date today = new Date(sdf.parse(now()).getTime());
                    if (d_od.compareTo(today) < 0) {
                        throw new InvalidDateIntervalException("Nelze rezervovat pokoje v minulosti.", 1);
                    }

                    zakaznik_id = modelZakaznik.insert(jmeno, prijmeni, adresa, mesto, psc, kraj, telefon, email);
                    System.out.println("Pro zaakznika id: " + zakaznik_id);

                    modelRezervace.vytvoritRezervaci(zakaznik_id, rezervace, d_od, d_do);

                    updateCheckBoxes(rezervaceOd, rezervaceDo);
                    it = iconList.listIterator();
                    myIcon tmp;
                    while (it.hasNext()) {
                        tmp = it.next();
                        lastInsertedImgId = modelObr.insertImage(tmp.getPath(), zakaznik_id);
                        tmp.setIndex(lastInsertedImgId);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Rezervace.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(getParent(), "Datumy začátku nebo konce rezervace nejsou správně vyplněny", "Neplatné datum", JOptionPane.ERROR_MESSAGE);
                again = true;
            } catch (InvalidDateIntervalException ex) {
                JOptionPane.showMessageDialog(getParent(), ex.getMessage(), "Neplatný rozsah doby rezervace.", JOptionPane.ERROR_MESSAGE);
                again = true;
            }
        }
        if (!again) {
            getToolkit().getSystemEventQueue().postEvent(new WindowEvent(pFrame, WindowEvent.WINDOW_CLOSING));
        }
    }//GEN-LAST:event_vlozitRezervaci_buttonActionPerformed

    private void kalendar_odMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kalendar_odMouseClicked
        String lang = null;
        final Locale locale = getLocale(lang);
        DatePicker dp = new DatePicker(rezervaceOd_field, locale);
        // previously selected date
        Date selectedDate = dp.parseDate(rezervaceOd_field.getText());
        dp.setSelectedDate(selectedDate);
        dp.start(rezervaceOd_field);
    }//GEN-LAST:event_kalendar_odMouseClicked

    private void kalendar_doMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kalendar_doMouseClicked
        String lang = null;
        final Locale locale = getLocale(lang);
        DatePicker dp = new DatePicker(rezervaceDo_field, locale);
        // previously selected date
        Date selectedDate = dp.parseDate(rezervaceDo_field.getText());
        dp.setSelectedDate(selectedDate);
        dp.start(rezervaceDo_field);
    }//GEN-LAST:event_kalendar_doMouseClicked

    private void zpetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zpetActionPerformed
        pFrame.dispose();
    }//GEN-LAST:event_zpetActionPerformed

    private Locale getLocale(String loc) {
        if (loc != null && loc.length() > 0) {
            return new Locale(loc);
        } else {
            return Locale.US;
        }
    }

    /**
     * Vraci aktualni datum ve formatu yyyy-mm-dd
     * @return datum ve formatu yyyy-mm-dd
     */
    public static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    /**
     * Nastavi rodicovske okno
     * @param p rodicovske okno
     */
    public void setParentFrame(JFrame p) {
        pFrame = p;
    }
    private JFrame pFrame;
    private DocumentListener dl;
    private List<JCheckBox> checkBoxlist;
    private Map<Integer, String> pokoje;
    private List<Integer> rezervovanePokoje;
    private Integer lastInsertedImgId;
    private ObrazkyModel modelObr;
    private ZakaznikModel modelZakaznik;
    private RezervaceModel modelRezervace;
    private JFileChooser fc;
    private ImageIcon icon;
    private String defaultSearchDir;
    private FlowLayout layout;
    private List<myIcon> iconList;
    private ListIterator<myIcon> it;
    private final String comboBoxItems[] = {"Karlovarsky", "Ustecky", "Liberecky",
        "Kralovehradecky", "Pardubicky", "Olomoucky",
        "Ostravsky", "Zlinsky", "Brnensky",
        "Jihlavsky", "Budejovicky", "Plzensky",
        "Stredocesky", "Hl. m. Praha"};
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adresa_field;
    private javax.swing.JTextField email_field;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jmeno_field;
    private javax.swing.JLabel kalendar_do;
    private javax.swing.JLabel kalendar_od;
    private javax.swing.JComboBox kraj_combobox;
    private javax.swing.JTextField mesto_field;
    private javax.swing.JCheckBox pokoj10_checkbox;
    private javax.swing.JCheckBox pokoj1_checkbox;
    private javax.swing.JCheckBox pokoj2_checkbox;
    private javax.swing.JCheckBox pokoj3_checkbox;
    private javax.swing.JCheckBox pokoj4_checkbox;
    private javax.swing.JCheckBox pokoj5_checkbox;
    private javax.swing.JCheckBox pokoj6_checkbox;
    private javax.swing.JCheckBox pokoj7_checkbox;
    private javax.swing.JCheckBox pokoj8_checkbox;
    private javax.swing.JCheckBox pokoj9_checkbox;
    private javax.swing.JButton pridatFotoAuta_button;
    private javax.swing.JTextField prijmeni_field;
    private javax.swing.JTextField psc_field;
    private cz.vutbr.fit.pdb.utils.ObservingTextField rezervaceDo_field;
    private cz.vutbr.fit.pdb.utils.ObservingTextField rezervaceOd_field;
    private javax.swing.JTextField telefon_field;
    private javax.swing.JButton vlozitRezervaci_button;
    private javax.swing.JPanel vozidla_kontejner;
    private javax.swing.JButton zpet;
    // End of variables declaration//GEN-END:variables
}
