package cz.vutbr.fit.pdb.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.MouseInputListener;

/**
 * @author originál z http://thehow2tutorial.blogspot.cz/p/downloads.html
 * Upravy:
 * @author Paulík Miroslav
 * @author Mikulica Tomáš
 * @author Gajdoš Pavel
 */
public final class DatePicker extends Observable implements Runnable, WindowFocusListener {

    /**
     *
     */
    protected static Font plain = new Font("Arial", Font.PLAIN, 10);
    /**
     *
     */
    protected static Font bold = new Font("Arial", Font.BOLD, 10);

    /**
     *
     */
    public static class DayLabel extends JLabel implements MouseInputListener,
            MouseMotionListener {

        /**
         *
         */
        private static final long serialVersionUID = 1L;
        private DatePicker parent;

        /**
         *
         * @param parent
         * @param day
         */
        public DayLabel(DatePicker parent, int day) {
            super(Integer.toString(day));
            this.parent = parent;
            setHorizontalAlignment(SwingConstants.CENTER);
            setFont(plain);
            this.addMouseListener(this);
        }

        /**
         *
         */
        public void setCurrentDayStyle() {
            setFont(bold);
            setForeground(Color.RED);
        }

        /**
         *
         */
        public void setSelectedDayStyle() {
            setFont(plain);
            setForeground(Color.BLUE);
            setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }

        /**
         *
         */
        public void setWeekendStyle() {
            setFont(plain);
            setForeground(Color.GRAY);
        }

        /**
         *
         * @param e
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            // JOptionPane.showMessageDialog(this,getText());
            parent.dayPicked(Integer.parseInt(getText()));
        }

        /**
         *
         * @param e
         */
        @Override
        public void mousePressed(MouseEvent e) {
        }

        /**
         *
         * @param e
         */
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        private Border oldBorder;

        /**
         *
         * @param e
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            oldBorder = this.getBorder();
            Border b;
            //b = BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED);
            b = BorderFactory.createEtchedBorder();
            this.setBorder(b);
        }

        /**
         *
         * @param e
         */
        @Override
        public void mouseExited(MouseEvent e) {
            this.setBorder(oldBorder);
        }

        /**
         *
         * @param e
         */
        @Override
        public void mouseDragged(MouseEvent e) {
        }

        /**
         *
         * @param e
         */
        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    /**
     *
     */
    public static class MonthPanel extends JPanel {

        private static final long serialVersionUID = 1L;
        private DatePicker parent;

        /**
         *
         * @param parent
         * @param c
         */
        public MonthPanel(DatePicker parent, Calendar c) {
            this.parent = parent;
            GridLayout g = new GridLayout();
            g.setColumns(7);
            g.setRows(0);
            this.setLayout(g);

            for (int i = 0; i < 7; i++) {
                JLabel wd = new JLabel(parent.getString("week." + i, ""));
                wd.setHorizontalAlignment(SwingConstants.CENTER);
                if (i == 0) {
                    wd.setForeground(Color.RED);
                } else if (i == 6) {
                    wd.setForeground(Color.gray);
                }
                this.add(wd);
            }
            setDaysOfMonth(c);
            this.setPreferredSize(new Dimension(200, 120));

        }

        private void setDaysOfMonth(Calendar c) {
            Calendar curr = new GregorianCalendar();
            int currdate = curr.get(Calendar.DAY_OF_MONTH);
            int currmon = curr.get(Calendar.MONTH);
            int curryear = curr.get(Calendar.YEAR);

            int seldate = -1;
            int selmon = -1;
            int selyear = -1;
            if (parent.selectedDate != null) {
                seldate = parent.selectedDate.get(Calendar.DAY_OF_MONTH);
                selmon = parent.selectedDate.get(Calendar.MONTH);
                selyear = parent.selectedDate.get(Calendar.YEAR);
            }

            int date = c.get(Calendar.DAY_OF_MONTH);
            int mon = c.get(Calendar.MONTH);
            int year = c.get(Calendar.YEAR);
            int day = c.get(Calendar.DAY_OF_WEEK);
            int start = (7 - (date - day) % 7) % 7;
            int days = c.getActualMaximum(Calendar.DAY_OF_MONTH);

            for (int i = 0; i < start; i++) {
                JLabel lbl = new JLabel("");
                add(lbl);
            }
            int pos = start;
            for (int i = 1; i <= days; i++) {
                pos++;
                DayLabel lbl = new DayLabel(parent, i);
                if (seldate == i && selmon == mon && selyear == year) {
                    lbl.setSelectedDayStyle();
                }
                if (currdate == i && currmon == mon && curryear == year) {
                    lbl.setCurrentDayStyle();
                }
                if (pos % 7 == 0 || pos % 7 == 1) {
                    lbl.setWeekendStyle();
                }
                add(lbl);

            }
        }
    }

    /**
     *
     */
    public static final class NavigatePanel extends JPanel implements ActionListener {

        private static final long serialVersionUID = 1L;
        private DatePicker parent;
        private JButton premon;
        private JButton preyear;
        private JButton nextmon;
        private JButton nextyear;
        private JLabel lbl;

        private byte[] getImage(String fileName) {
            InputStream is = null;

            try {
                is = new BufferedInputStream(DatePicker.class.getClassLoader().getResourceAsStream(fileName));
                byte[] b = new byte[is.available()];
                is.read(b);
                return b;
            } catch (IOException e) {
                Logger.getLogger(DatePicker.class.getName()).log(Level.SEVERE, null, e);
                return null;
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                    }
                }
            }
        }

        /**
         *
         * @param parent
         */
        public NavigatePanel(DatePicker parent) {
            this.parent = parent;
            setLayout(new BorderLayout());
            Dimension d = new Dimension(20, 20);
            Box xbox;
            xbox = new Box(BoxLayout.X_AXIS);
            preyear = new JButton();
            preyear.setToolTipText(parent.getString("pre.year",
                    "Previous year."));
            ImageIcon icon = new ImageIcon(getImage("preyear.gif"), "<<");
            preyear.setIcon(icon);
            preyear.addActionListener(this);
            preyear.setPreferredSize(d);
            xbox.add(preyear);

            xbox.add(Box.createHorizontalStrut(3));

            premon = new JButton();
            premon
                    .setToolTipText(parent.getString("pre.mon",
                    "Previous Month"));
            icon = new ImageIcon(getImage("premon.gif"), "<");
            premon.setIcon(icon);
            premon.addActionListener(this);
            premon.setPreferredSize(d);
            xbox.add(premon);

            add(xbox, BorderLayout.WEST);

            xbox = new Box(BoxLayout.X_AXIS);
            nextmon = new JButton();
            nextmon.setToolTipText(parent.getString("next.mon", "Next month."));
            icon = new ImageIcon(getImage("nextmon.gif"), ">");
            nextmon.setIcon(icon);
            nextmon.setPreferredSize(d);
            nextmon.addActionListener(this);
            xbox.add(nextmon);

            xbox.add(Box.createHorizontalStrut(3));

            nextyear = new JButton();
            nextyear
                    .setToolTipText(parent.getString("next.year", "Next year."));
            icon = new ImageIcon(getImage("nextyear.gif"), ">>");
            nextyear.setIcon(icon);
            nextyear.setPreferredSize(d);
            nextyear.addActionListener(this);
            xbox.add(nextyear);

            add(xbox, BorderLayout.EAST);
            setCurrentMonth(parent.calendar);
            //setLabel(parent.calendar);
        }
        private JComboBox monthBox;
        private JComboBox yearBox;
        private String[] months;
        private Integer[] years;
        private Box box;
        final int height = 10;

        /**
         *
         * @param c
         */
        public void setCurrentMonth(Calendar c) {
            setMonthComboBox(c);
            setYearComboBox(c);

            if (box == null) {
                box = new Box(BoxLayout.X_AXIS);
                box.add(monthBox);
                box.add(yearBox);
                add(box, BorderLayout.CENTER);
            }

        }

        private void setMonthComboBox(Calendar c) {
            if (months == null) {
                months = new String[12];
                for (int i = 0; i < 12; i++) {
                    String m = parent.getString("month." + i, "");
                    months[i] = m;
                }
            }
            if (monthBox == null) {
                monthBox = new JComboBox();
                monthBox.addActionListener(this);
                monthBox.setFont(DatePicker.plain);
                monthBox.setSize(monthBox.getWidth(), height);
                monthBox.setPreferredSize(new Dimension(monthBox.getWidth(), height));
            }
            monthBox.setModel(new DefaultComboBoxModel(months));
            monthBox.setSelectedIndex(c.get(Calendar.MONTH));
        }

        private void setYearComboBox(Calendar c) {
            int y = c.get(Calendar.YEAR);
            years = new Integer[7];
            for (int i = y - 3, j = 0; i <= y + 3; i++, j++) {
                years[j] = new Integer(i);
            }
            if (yearBox == null) {
                yearBox = new JComboBox();
                yearBox.addActionListener(this);
                yearBox.setFont(DatePicker.plain);
                yearBox.setSize(yearBox.getWidth(), height);
                yearBox.setPreferredSize(new Dimension(yearBox.getWidth(), height));
            }
            yearBox.setModel(new DefaultComboBoxModel(years));
            yearBox.setSelectedItem(years[3]);
        }

        /**
         *
         * @param c
         */
        public void setLabel(Calendar c) {
            if (lbl != null) {
                remove(lbl);
            }
            lbl = new JLabel(parent.getString("month." + c.get(Calendar.MONTH),
                    "")
                    + ", " + c.get(Calendar.YEAR));
            lbl.setHorizontalAlignment(SwingConstants.CENTER);
            add(lbl, BorderLayout.CENTER);

        }

        /**
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Object src = e.getSource();
            Calendar c = new GregorianCalendar();
            c.setTime(parent.getCalendar().getTime());
            if (src instanceof JButton) {
                if (e.getSource() == premon) {
                    c.add(Calendar.MONTH, -1);
                } else if (e.getSource() == nextmon) {
                    c.add(Calendar.MONTH, 1);
                } else if (e.getSource() == nextyear) {
                    c.add(Calendar.YEAR, 1);
                }
                if (e.getSource() == preyear) {
                    c.add(Calendar.YEAR, -1);
                }
                // System.out.println(c.getTime());
                parent.updateScreen(c);
            } else if (src instanceof JComboBox) {
                JComboBox jcb = (JComboBox) src;
                if (src == monthBox) {
                    c.set(Calendar.MONTH, jcb.getSelectedIndex());
                } else if (e.getSource() == yearBox) {
                    c.set(Calendar.YEAR, years[jcb.getSelectedIndex()].intValue());
                    setYearComboBox(c);
                }
                parent.setMonthPanel(c);
                parent.screen.pack();
            }
        }
    }
    private MonthPanel monthPanel;
    private NavigatePanel navPanel;
    /**
     *
     */
    protected Calendar calendar;
    private Calendar selectedDate;
    private boolean closeOnSelect = true;
    private Locale locale = Locale.US;
    private DateFormat sdf;
    private JDialog screen;

    /**
     *
     * @param observer
     */
    public DatePicker(Observer observer) {
        this(observer, new Date());
    }

    /**
     *
     * @param observer
     * @param selecteddate
     */
    public DatePicker(Observer observer, Date selecteddate) {
        this(observer, selecteddate, Locale.US);
    }

    /**
     *
     * @param observer
     * @param locale
     */
    public DatePicker(Observer observer, Locale locale) {
        this(observer, new Date(), locale);
    }

    /**
     *
     * @param observer
     * @param selecteddate
     * @param locale
     */
    @SuppressWarnings("static-access")
    public DatePicker(Observer observer, Date selecteddate, Locale locale) {
        super();
        this.locale = locale;
        register(observer);
        screen = new JDialog();
        screen.addWindowFocusListener(this);
        screen.setSize(200, 200);
        screen.setResizable(false);
        screen.setModal(true);
        screen.setUndecorated(true);
        screen.setDefaultLookAndFeelDecorated(true);
        screen.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        screen.getContentPane().setLayout(new BorderLayout());
        //
        calendar = new GregorianCalendar();
        setSelectedDate(selecteddate);
        Calendar c = calendar;
        if (selectedDate != null) {
            c = selectedDate;
        }
        updateScreen(c);
        screen.getContentPane().add(navPanel, BorderLayout.NORTH);

        screen.setTitle(getString("program.title", "Date Picker"));
    }

    /**
     *
     * @param c
     */
    public void start(Component c) {
        if (c != null) {
            Component p = c.getParent();
            int x = c.getX() + c.getWidth(), y = c.getY() + c.getHeight();
            while (p != null) {
                x += p.getX();
                y += p.getY();
                p = p.getParent();
            }
            // System.out.println("x="+x+ " y="+y);
            screen.setLocation(x, y);
        } else {
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            screen.setLocation((int) (dim.getWidth() - screen.getWidth()) / 2,
                    (int) (dim.getHeight() - screen.getHeight()) / 2);
        }
        SwingUtilities.invokeLater(this);
    }

    /**
     *
     */
    @Override
    public void run() {
        screen.pack();
        screen.setVisible(true);

    }

    /**
     *
     * @param date
     * @return
     */
    public Date parseDate(String date) {
        if (sdf == null) {
            sdf = SimpleDateFormat.getDateInstance(SimpleDateFormat.SHORT,
                    locale);
        }
        try {
            return sdf.parse(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     *
     * @param date
     * @return
     */
    public String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        if (sdf == null) {
            sdf = SimpleDateFormat.getDateInstance(SimpleDateFormat.SHORT,
                    locale);
        }
        return sdf.format(date);
    }

    /**
     *
     * @param date
     * @param pattern
     * @return
     */
    public String formatDate(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     *
     * @param date
     * @return
     */
    public String formatDate(Calendar date) {
        if (date == null) {
            return "";
        }
        return formatDate(date.getTime());
    }

    /**
     *
     * @param date
     * @param pattern
     * @return
     */
    public String formatDate(Calendar date, String pattern) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(pattern).format(date.getTime());
    }

    /**
     *
     * @param l
     */
    public void setLocale(Locale l) {
        this.locale = l;
    }

    /**
     *
     * @return
     */
    public Locale getLocale() {
        return this.locale == null ? Locale.US : locale;
    }

    /**
     *
     * @param observer
     */
    public final void register(Observer observer) {
        if (observer != null) {
            this.addObserver(observer);
        }
    }

    /**
     *
     * @param observer
     */
    public void unregister(Observer observer) {
        if (observer != null) {
            this.deleteObserver(observer);
        }
    }

    private Calendar getCalendar() {
        return calendar;
    }

    @SuppressWarnings("unused")
    private void setCalendar(Calendar c) {
        this.calendar = c;
    }

    /**
     *
     * @param d
     */
    public void setSelectedDate(Date d) {
        if (d != null) {
            if (selectedDate == null) {
                selectedDate = new GregorianCalendar();
            }
            this.selectedDate.setTime(d);
            updateScreen(selectedDate);
        }
    }

    /**
     *
     * @param c
     */
    protected void updateScreen(Calendar c) {
        if (navPanel == null) {
            navPanel = new NavigatePanel(this);
        }
        //navPanel.setLabel(c);
        navPanel.setCurrentMonth(c);
        setMonthPanel(c);
        screen.pack();
    }

    /**
     *
     * @param calendar
     */
    protected void setMonthPanel(Calendar calendar) {
        if (calendar != null) {
            this.calendar.setTime(calendar.getTime());
        }
        if (monthPanel != null) {
            screen.getContentPane().remove(monthPanel);
        }
        monthPanel = new MonthPanel(this, calendar);
        screen.getContentPane().add(monthPanel, BorderLayout.CENTER);
    }

    /**
     *
     * @param day
     */
    protected void dayPicked(int day) {
        // this.day = day;
        calendar.set(Calendar.DAY_OF_MONTH, day);
        setSelectedDate(calendar.getTime());
        this.setChanged();
        this.notifyObservers(selectedDate);
        // System.out.println("cnt="+observable.countObservers()+", day
        // picked="+calendar.getTime());
        if (closeOnSelect) {
            screen.dispose();
            screen.setVisible(false);
        }
    }
    private ResourceBundle i18n;

    /**
     *
     * @param key
     * @param dv
     * @return
     */
    public String getString(String key, String dv) {
        if (i18n == null || getLocale() != i18n.getLocale()) {
            i18n = ResourceBundle.getBundle("i18n", getLocale());
        }
        String val = i18n.getString(key);
        if (val == null) {
            return dv;
        } else {
            return val;
        }
    }

    /**
     *
     * @return
     */
    public boolean isCloseOnSelect() {
        return closeOnSelect;
    }

    /**
     *
     * @param e
     */
    @Override
    public void windowGainedFocus(WindowEvent e) {
    }

    /**
     *
     * @param e
     */
    @Override
    public void windowLostFocus(WindowEvent e) {
        screen.toFront();
    }

    /**
     *
     * @return
     */
    public JDialog getScreen() {
        return this.screen;
    }

    /**
     *
     * @param closeOnSelect
     */
    public void setCloseOnSelect(boolean closeOnSelect) {
        this.closeOnSelect = closeOnSelect;
    }

    /**
     *
     * @param argv
     */
    public static void main(String[] argv) {
        DatePicker dp = new DatePicker(null);

        dp.start(null);
    }
}
