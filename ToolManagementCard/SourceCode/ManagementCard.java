/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoX;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 *
 * @author Administrator
 */
public class ManagementCard extends javax.swing.JFrame {

    ArrayList<CardZing> list20 = new ArrayList<>();
    ArrayList<CardZing> list50 = new ArrayList<>();
    ArrayList<CardZing> list100 = new ArrayList<>();
    ArrayList<CardZing> list200 = new ArrayList<>();
    ArrayList<CardZing> list500 = new ArrayList<>();
    String s;

    /**
     * Creates new form Card
     */
    public ManagementCard() {
        initComponents();
        setLocation(500, 200);
        JPopupMenu popup1 = new JPopupMenu();
        JPopupMenu popup2 = new JPopupMenu();
        JPopupMenu popup3 = new JPopupMenu();
        JPopupMenu popup4 = new JPopupMenu();
        JMenuItem copy1 = new JMenuItem("Copy");
        JMenuItem copy2 = new JMenuItem("Copy");
        JMenuItem copy3 = new JMenuItem("Copy");
        JMenuItem copy4 = new JMenuItem("Copy");
        JMenuItem paste1 = new JMenuItem("Paste");
        JMenuItem paste2 = new JMenuItem("Paste");
        JMenuItem paste3 = new JMenuItem("Paste");
        JMenuItem paste4 = new JMenuItem("Paste");
        popup1.add(copy1);
        popup1.add(paste1);
        popup2.add(copy2);
        popup2.add(paste2);
        popup3.add(copy3);
        popup3.add(paste3);
        popup4.add(copy4);
        popup4.add(paste4);
        txfInCode.setComponentPopupMenu(popup2);
        txfInSeri.setComponentPopupMenu(popup1);
        txfOutCode.setComponentPopupMenu(popup4);
        txfOutSeri.setComponentPopupMenu(popup3);

        copy1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s = txfInSeri.getSelectedText();
                StringSelection sselection = new StringSelection(s);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(sselection, null);
            }
        });

        copy2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s = txfInCode.getSelectedText();
                StringSelection sselection = new StringSelection(s);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(sselection, null);
            }
        });

        copy3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s = txfOutSeri.getSelectedText();
                StringSelection sselection = new StringSelection(s);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(sselection, null);
            }
        });

        copy4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s = txfOutCode.getSelectedText();
                StringSelection sselection = new StringSelection(s);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(sselection, null);
            }
        });

        paste1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Lay du lieu tu` clipboard cho vao   s
                String s = "";
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                Transferable contents = clipboard.getContents(null);
                try {
                    s = (String) contents.getTransferData(DataFlavor.stringFlavor);
                } catch (UnsupportedFlavorException ex) {
                    Logger.getLogger(ManagementCard.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ManagementCard.class.getName()).log(Level.SEVERE, null, ex);
                }

                txfInSeri.setText(s);
            }
        });

        paste2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Lay du lieu tu` clipboard cho vao   s
                String s = "";
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                Transferable contents = clipboard.getContents(null);
                try {
                    s = (String) contents.getTransferData(DataFlavor.stringFlavor);
                } catch (UnsupportedFlavorException ex) {
                    Logger.getLogger(ManagementCard.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ManagementCard.class.getName()).log(Level.SEVERE, null, ex);
                }

                txfInCode.setText(s);
            }
        });

        paste3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Lay du lieu tu` clipboard cho vao   s
                String s = "";
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                Transferable contents = clipboard.getContents(null);
                try {
                    s = (String) contents.getTransferData(DataFlavor.stringFlavor);
                } catch (UnsupportedFlavorException ex) {
                    Logger.getLogger(ManagementCard.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ManagementCard.class.getName()).log(Level.SEVERE, null, ex);
                }

                txfOutSeri.setText(s);
            }
        });

        paste4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Lay du lieu tu` clipboard cho vao   s
                String s = "";
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                Transferable contents = clipboard.getContents(null);
                try {
                    s = (String) contents.getTransferData(DataFlavor.stringFlavor);
                } catch (UnsupportedFlavorException ex) {
                    Logger.getLogger(ManagementCard.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ManagementCard.class.getName()).log(Level.SEVERE, null, ex);
                }

                txfOutCode.setText(s);
            }
        });
    }

    public PageFormat getPageFormat(PrinterJob pj) {

        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();

        double width = (6 * 0.393600787 * 72d);  //6*0.3936 de covert qua inch, *72d la cai` dat moi inch co gia tri la` 72ppi

        double height = (10) * 0.3936 * 72d;

        paper.setSize(width, height);// set kich co giay in dai` , rong de nhu tren
        //paper.setImageableArea(0,10,width,height - (1*0.393600787* 72d)); // chua biet tac dung vi k thay khac biet

        //pf.setOrientation(PageFormat.PORTRAIT);// chua biet tac dung
        pf.setPaper(paper);

        return pf;
    }

    public class PrintBillCard implements Printable {

        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
            int result = NO_SUCH_PAGE;
            if (pageIndex == 0) {

                Graphics2D g2d = (Graphics2D) graphics;
                double width = pageFormat.getImageableWidth();
                g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

                try {
                    int x=0;
                    int y = 10;
                    String s = "";
                    if (comboboxOut.getSelectedIndex() == 1) {
                        s = "20.000";
                    }
                    if (comboboxOut.getSelectedIndex() == 2) {
                        s = "50.000";
                    }
                    if (comboboxOut.getSelectedIndex() == 3) {
                        s = "100.000";
                    }
                    if (comboboxOut.getSelectedIndex() == 4) {
                        s = "200.000";
                    }
                    if (comboboxOut.getSelectedIndex() == 5) {
                        s = "500.000";
                    }
                    // O tren set chieu` rong giay' la` 6cm thi` o day x co' toa do den' khoang 120
                    g2d.setFont(new Font("ahihi", Font.PLAIN, 11));//PLAIN: la` font in, 9 : la` co chu de in
                    g2d.drawString("--------------------------------------------------", x, y);y += 10;         // x la` toa do bat dau` in tren chieu` ngang
                    g2d.drawString("          ZING " + s + "                                               ", 0, y);y += 10;         // y la` toa do bat dau` in tren chieu` rong, do do'       
                    g2d.drawString("--------------------------------------------------", 0, y);y += 10;      // sau moi drawString thi` phai + y them de den' toa do can`   
                    g2d.drawString(" Seri: " + txfOutSeri.getText() + "                  ", 0, y);y += 10;      //in tiep theo
                    g2d.drawString(" Code card: " + txfOutCode.getText() + "   ", 0, y);y += 10;
                    g2d.drawString("                                                                                    ", 0, y);y += 10;
                    g2d.drawString("--------------------------------------------------", 0, y);y += 10;
                    g2d.drawString("       Thanks for visit !                                           ", 0, y);y += 10;
                    g2d.drawString("     See you again ^.^!                                         ", 0, y);y += 60;   // y+=60 de in khoang trang' cuoi' trang  dai` ra 
                    g2d.drawString(".                                                                                  .", 0, y);y += 10;


                } catch (Exception r) {
                    r.printStackTrace();
                }

                result = PAGE_EXISTS;
            }
            return result;
        }
    }

    public void write(String fileName) {
        ///////////////////////////////////The  20
        if (comboboxIn.getSelectedIndex() == 1) {
            if (JOptionPane.showConfirmDialog(rootPane, new text().banmuonthemthe) == 0) {
                ArrayList<CardZing> list20 = new ArrayList<>();
                try (Scanner sc = new Scanner(new File(fileName))) {

                    while (sc.hasNext()) {
                        String s = sc.nextLine();
                        String[] arr = new String[2];
                        arr = s.split("\\s+");
                        list20.add(new CardZing(arr[0], arr[1]));
                    }

                } catch (Exception e) {
                }

                this.list20 = list20;

                this.list20.add(new CardZing(txfInSeri.getText() + "", txfInCode.getText() + ""));
                try (PrintWriter pw = new PrintWriter(new FileWriter(new File(fileName)))) {// O day ma` de FileRiter(new.. , true) thi` se bi lap lan lon khi addCard
                    for (CardZing cz : this.list20) // Vi` the phai them doan code tren, de luu du lieu vao` 1 list khac,   
                    {
                        pw.println(cz.show());                                                                                                      // sau do 
                    }
                } catch (Exception e) {
                }
            }
        }
        ///////////////////////////////// The 50
        if (comboboxIn.getSelectedIndex() == 2) {
            if (JOptionPane.showConfirmDialog(rootPane, new text().banmuonthemthe) == 0) {
                ArrayList<CardZing> list50 = new ArrayList<>();
                try (Scanner sc = new Scanner(new File(fileName))) {

                    while (sc.hasNext()) {
                        String s = sc.nextLine();
                        String[] arr = new String[2];
                        arr = s.split("\\s+");
                        list50.add(new CardZing(arr[0], arr[1]));
                    }

                } catch (Exception e) {
                }

                this.list50 = list50;

                this.list50.add(new CardZing(txfInSeri.getText() + "", txfInCode.getText() + ""));
                try (PrintWriter pw = new PrintWriter(new FileWriter(new File(fileName)))) {// O day ma` de FileRiter(new.. , true) thi` se bi lap lan lon khi addCard
                    for (CardZing cz : this.list50) // Vi` the phai them doan code tren, de luu du lieu vao` 1 list khac,   
                    {
                        pw.println(cz.show());                                                                                                      // sau do 
                    }
                } catch (Exception e) {
                }
            }
        }
        //////////////////////////// The 100
        if (comboboxIn.getSelectedIndex() == 3) {
            if (JOptionPane.showConfirmDialog(rootPane, new text().banmuonthemthe) == 0) {
                ArrayList<CardZing> list100 = new ArrayList<>();
                try (Scanner sc = new Scanner(new File(fileName))) {

                    while (sc.hasNext()) {
                        String s = sc.nextLine();
                        String[] arr = new String[2];
                        arr = s.split("\\s+");
                        list100.add(new CardZing(arr[0], arr[1]));
                    }

                } catch (Exception e) {
                }

                this.list100 = list100;

                this.list100.add(new CardZing(txfInSeri.getText() + "", txfInCode.getText() + ""));
                try (PrintWriter pw = new PrintWriter(new FileWriter(new File(fileName)))) {// O day ma` de FileRiter(new.. , true) thi` se bi lap lan lon khi addCard
                    for (CardZing cz : this.list100) // Vi` the phai them doan code tren, de luu du lieu vao` 1 list khac,   
                    {
                        pw.println(cz.show());                                                                                                      // sau do 
                    }
                } catch (Exception e) {
                }
            }
        }
        //////////////////////////////The 200
        if (comboboxIn.getSelectedIndex() == 4) {
            if (JOptionPane.showConfirmDialog(rootPane, new text().banmuonthemthe) == 0) {
                ArrayList<CardZing> list200 = new ArrayList<>();
                try (Scanner sc = new Scanner(new File(fileName))) {

                    while (sc.hasNext()) {
                        String s = sc.nextLine();
                        String[] arr = new String[2];
                        arr = s.split("\\s+");
                        list200.add(new CardZing(arr[0], arr[1]));
                    }

                } catch (Exception e) {
                }

                this.list200 = list200;

                this.list200.add(new CardZing(txfInSeri.getText() + "", txfInCode.getText() + ""));
                try (PrintWriter pw = new PrintWriter(new FileWriter(new File(fileName)))) {// O day ma` de FileRiter(new.. , true) thi` se bi lap lan lon khi addCard
                    for (CardZing cz : this.list200) // Vi` the phai them doan code tren, de luu du lieu vao` 1 list khac,   
                    {
                        pw.println(cz.show());                                                                                                      // sau do 
                    }
                } catch (Exception e) {
                }
            }
        }
        ///////////////////////////////The 500
        if (comboboxIn.getSelectedIndex() == 5) {
            if (JOptionPane.showConfirmDialog(rootPane, new text().banmuonthemthe) == 0) {
                ArrayList<CardZing> list500 = new ArrayList<>();
                try (Scanner sc = new Scanner(new File(fileName))) {

                    while (sc.hasNext()) {
                        String s = sc.nextLine();
                        String[] arr = new String[2];
                        arr = s.split("\\s+");
                        list500.add(new CardZing(arr[0], arr[1]));
                    }

                } catch (Exception e) {
                }

                this.list500 = list500;

                this.list500.add(new CardZing(txfInSeri.getText() + "", txfInCode.getText() + ""));
                try (PrintWriter pw = new PrintWriter(new FileWriter(new File(fileName)))) {// O day ma` de FileRiter(new.. , true) thi` se bi lap lan lon khi addCard
                    for (CardZing cz : this.list500) // Vi` the phai them doan code tren, de luu du lieu vao` 1 list khac,   
                    {
                        pw.println(cz.show());                                                                                                      // sau do 
                    }
                } catch (Exception e) {
                }
            }

        }
    }

    SimpleDateFormat fm = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
    SimpleDateFormat fm1 = new SimpleDateFormat("dd.MM.yyyy");

    public void read(String fileName) {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (comboboxOut.getSelectedIndex() == 1) {
            if (new File(fileName).length() == (long) 0) {
                JOptionPane.showMessageDialog(rootPane, new text().hetThe);
            } else {
                ArrayList<CardZing> list = new ArrayList<>();
                try (Scanner sc = new Scanner(new File(fileName))) {

                    while (sc.hasNext()) {
                        String s = sc.nextLine();
                        String[] arr = new String[2];
                        arr = s.split("\\s+");
                        list.add(new CardZing(arr[0], arr[1]));
                    }

                } catch (Exception e) {
                }

                txfOutSeri.setText(list.get(0).getSeri());
                txfOutCode.setText(list.get(0).getCode());
                list.remove(0);

                try (PrintWriter pw = new PrintWriter(new FileWriter(new File(fileName)))) {
                    for (CardZing cz : list) {
                        pw.println(cz.show());
                    }
                } catch (Exception e) {
                }

                try (PrintWriter pw = new PrintWriter(new FileWriter(new File("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\History\\History" + fm1.format(new Date()) + ".his"), true))) {
                    pw.println(fm.format(new Date()));
                    pw.println("Zing 20.000: ");
                    pw.println("Seri: " + txfOutSeri.getText());
                    pw.println("Ma nap: " + txfOutCode.getText());
                    pw.println("    ");
                } catch (Exception e) {
                }

                try (PrintWriter pw = new PrintWriter(new FileWriter(new File("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\Sum\\Sum" + fm1.format(new Date()) + ".sum"), true))) {
                    pw.println("20");
                } catch (Exception e) {
                }
            }
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (comboboxOut.getSelectedIndex() == 2) {
            if (new File(fileName).length() == (long) 0) {
                JOptionPane.showMessageDialog(rootPane, new text().hetThe);
            } else {
                ArrayList<CardZing> list = new ArrayList<>();
                try (Scanner sc = new Scanner(new File(fileName))) {

                    while (sc.hasNext()) {
                        String s = sc.nextLine();
                        String[] arr = new String[2];
                        arr = s.split("\\s+");
                        list.add(new CardZing(arr[0], arr[1]));
                    }

                } catch (Exception e) {
                }

                txfOutSeri.setText(list.get(0).getSeri());
                txfOutCode.setText(list.get(0).getCode());
                list.remove(0);

                try (PrintWriter pw = new PrintWriter(new FileWriter(new File(fileName)))) {
                    for (CardZing cz : list) {
                        pw.println(cz.show());
                    }
                } catch (Exception e) {
                }

                try (PrintWriter pw = new PrintWriter(new FileWriter(new File("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\History\\History" + fm1.format(new Date()) + ".his"), true))) {
                    pw.println(fm.format(new Date()));
                    pw.println("Zing 50.000: ");
                    pw.println("Seri: " + txfOutSeri.getText());
                    pw.println("Ma nap: " + txfOutCode.getText());
                    pw.println("    ");
                } catch (Exception e) {
                }

                try (PrintWriter pw = new PrintWriter(new FileWriter(new File("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\Sum\\Sum" + fm1.format(new Date()) + ".sum"), true))) {
                    pw.println("50");
                } catch (Exception e) {
                }
            }
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (comboboxOut.getSelectedIndex() == 3) {
            if (new File(fileName).length() == (long) 0) {
                JOptionPane.showMessageDialog(rootPane, new text().hetThe);
            } else {
                ArrayList<CardZing> list = new ArrayList<>();
                try (Scanner sc = new Scanner(new File(fileName))) {

                    while (sc.hasNext()) {
                        String s = sc.nextLine();
                        String[] arr = new String[2];
                        arr = s.split("\\s+");
                        list.add(new CardZing(arr[0], arr[1]));
                    }

                } catch (Exception e) {
                }

                txfOutSeri.setText(list.get(0).getSeri());
                txfOutCode.setText(list.get(0).getCode());
                list.remove(0);

                try (PrintWriter pw = new PrintWriter(new FileWriter(new File(fileName)))) {
                    for (CardZing cz : list) {
                        pw.println(cz.show());
                    }
                } catch (Exception e) {
                }

                try (PrintWriter pw = new PrintWriter(new FileWriter(new File("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\History\\History" + fm1.format(new Date()) + ".his"), true))) {
                    pw.println(fm.format(new Date()));
                    pw.println("Zing 100.000: ");
                    pw.println("Seri: " + txfOutSeri.getText());
                    pw.println("Ma nap: " + txfOutCode.getText());
                    pw.println("    ");
                } catch (Exception e) {
                }

                try (PrintWriter pw = new PrintWriter(new FileWriter(new File("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\Sum\\Sum" + fm1.format(new Date()) + ".sum"), true))) {
                    pw.println("100");
                } catch (Exception e) {
                }
            }
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (comboboxOut.getSelectedIndex() == 4) {
            if (new File(fileName).length() == (long) 0) {
                JOptionPane.showMessageDialog(rootPane, new text().hetThe);
            } else {
                ArrayList<CardZing> list = new ArrayList<>();
                try (Scanner sc = new Scanner(new File(fileName))) {

                    while (sc.hasNext()) {
                        String s = sc.nextLine();
                        String[] arr = new String[2];
                        arr = s.split("\\s+");
                        list.add(new CardZing(arr[0], arr[1]));
                    }

                } catch (Exception e) {
                }

                txfOutSeri.setText(list.get(0).getSeri());
                txfOutCode.setText(list.get(0).getCode());
                list.remove(0);

                try (PrintWriter pw = new PrintWriter(new FileWriter(new File(fileName)))) {
                    for (CardZing cz : list) {
                        pw.println(cz.show());
                    }
                } catch (Exception e) {
                }

                try (PrintWriter pw = new PrintWriter(new FileWriter(new File("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\History\\History" + fm1.format(new Date()) + ".his"), true))) {
                    pw.println(fm.format(new Date()));
                    pw.println("Zing 200.000: ");
                    pw.println("Seri: " + txfOutSeri.getText());
                    pw.println("Ma nap: " + txfOutCode.getText());
                    pw.println("    ");
                } catch (Exception e) {
                }

                try (PrintWriter pw = new PrintWriter(new FileWriter(new File("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\Sum\\Sum" + fm1.format(new Date()) + ".sum"), true))) {
                    pw.println("200");
                } catch (Exception e) {
                }
            }
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (comboboxOut.getSelectedIndex() == 5) {
            if (new File(fileName).length() == (long) 0) {
                JOptionPane.showMessageDialog(rootPane, new text().hetThe);
            } else {
                ArrayList<CardZing> list = new ArrayList<>();
                try (Scanner sc = new Scanner(new File(fileName))) {

                    while (sc.hasNext()) {
                        String s = sc.nextLine();
                        String[] arr = new String[2];
                        arr = s.split("\\s+");
                        list.add(new CardZing(arr[0], arr[1]));
                    }

                } catch (Exception e) {
                }

                txfOutSeri.setText(list.get(0).getSeri());
                txfOutCode.setText(list.get(0).getCode());
                list.remove(0);

                try (PrintWriter pw = new PrintWriter(new FileWriter(new File(fileName)))) {
                    for (CardZing cz : list) {
                        pw.println(cz.show());
                    }
                } catch (Exception e) {
                }

                try (PrintWriter pw = new PrintWriter(new FileWriter(new File("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\History\\History" + fm1.format(new Date()) + ".his"), true))) {
                    pw.println(fm.format(new Date()));
                    pw.println("Zing 500.000: ");
                    pw.println("Seri: " + txfOutSeri.getText());
                    pw.println("Ma nap: " + txfOutCode.getText());
                    pw.println("    ");
                } catch (Exception e) {
                }

                try (PrintWriter pw = new PrintWriter(new FileWriter(new File("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\Sum\\Sum" + fm1.format(new Date()) + ".sum"), true))) {
                    pw.println("500");
                } catch (Exception e) {
                }
            }
        }

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
        txArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txfInSeri = new javax.swing.JTextField();
        txfInCode = new javax.swing.JTextField();
        comboboxIn = new javax.swing.JComboBox<>();
        buutonAdd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        comboboxOut = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txfOutSeri = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txfOutCode = new javax.swing.JTextField();
        buttonTakeOut = new javax.swing.JButton();
        buttonHistory = new javax.swing.JButton();
        buttonChangePassWord = new javax.swing.JButton();
        buttonCheckCard = new javax.swing.JButton();
        buttonprint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Zing! <Design by Vllenin>");
        setResizable(false);

        txArea.setColumns(20);
        txArea.setRows(5);
        jScrollPane1.setViewportView(txArea);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("THÊM THẺ VÀO HỆ THỐNG");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Số Seri");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Mã số thẻ");

        txfInSeri.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txfInCode.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        comboboxIn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        comboboxIn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "                                 CHỌN THẺ", "                                    20.000", "                                    50.000", "                                   100.000", "                                   200.000", "                                   500.000" }));

        buutonAdd.setText("THÊM");
        buutonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buutonAddActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("LẤY THẺ KHỎI HỆ THỐNG");

        comboboxOut.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        comboboxOut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "                                 CHỌN THẺ", "                                    20.000", "                                    50.000", "                                   100.000", "                                   200.000", "                                   500.000" }));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Số Seri");

        txfOutSeri.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Mã số thẻ");

        txfOutCode.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        buttonTakeOut.setText("LẤY");
        buttonTakeOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTakeOutActionPerformed(evt);
            }
        });

        buttonHistory.setText("LỊCH SỬ");
        buttonHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHistoryActionPerformed(evt);
            }
        });

        buttonChangePassWord.setText("Đổi mật khẩu");
        buttonChangePassWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangePassWordActionPerformed(evt);
            }
        });

        buttonCheckCard.setText("Kiểm tra thẻ");
        buttonCheckCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCheckCardActionPerformed(evt);
            }
        });

        buttonprint.setText("In thẻ");
        buttonprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonprintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(80, 80, 80)
                                    .addComponent(jLabel1))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txfInSeri, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txfInCode, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(comboboxIn, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(buutonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(80, 80, 80)
                                    .addComponent(jLabel4))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(comboboxOut, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txfOutSeri, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txfOutCode, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonTakeOut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonHistory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonChangePassWord, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonCheckCard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonprint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(112, 112, 112)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(comboboxIn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfInSeri, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfInCode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(buutonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(comboboxOut, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(buttonTakeOut, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfOutSeri, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfOutCode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonprint, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonChangePassWord, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCheckCard, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addComponent(jScrollPane1))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buutonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buutonAddActionPerformed
        if (comboboxIn.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, new text().chuaChonLoaiThe.getText());
        }

        if (comboboxIn.getSelectedIndex() == 1) {
            if ("".equals(txfInCode.getText()) || "".equals(txfInSeri.getText()) || " ".equals(txfInCode.getText()) || " ".equals(txfInSeri.getText())) {
                JOptionPane.showMessageDialog(rootPane, new text().chuanhapthe);
            } else {
                write("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\Card\\Card20.card");
            }
        }

        if (comboboxIn.getSelectedIndex() == 2) {
            if ("".equals(txfInCode.getText()) || "".equals(txfInSeri.getText()) || " ".equals(txfInCode.getText()) || " ".equals(txfInSeri.getText())) {
                JOptionPane.showMessageDialog(rootPane, new text().chuanhapthe);
            } else {
                write("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\Card\\Card50.card");
            }
        }

        if (comboboxIn.getSelectedIndex() == 3) {
            if ("".equals(txfInCode.getText()) || "".equals(txfInSeri.getText()) || " ".equals(txfInCode.getText()) || " ".equals(txfInSeri.getText())) {
                JOptionPane.showMessageDialog(rootPane, new text().chuanhapthe);
            } else {
                write("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\Card\\Card100.card");
            }
        }

        if (comboboxIn.getSelectedIndex() == 4) {
            if ("".equals(txfInCode.getText()) || "".equals(txfInSeri.getText()) || " ".equals(txfInCode.getText()) || " ".equals(txfInSeri.getText())) {
                JOptionPane.showMessageDialog(rootPane, new text().chuanhapthe);
            } else {
                write("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\Card\\Card200.card");
            }
        }

        if (comboboxIn.getSelectedIndex() == 5) {
            if ("".equals(txfInCode.getText()) || "".equals(txfInSeri.getText()) || " ".equals(txfInCode.getText()) || " ".equals(txfInSeri.getText())) {
                JOptionPane.showMessageDialog(rootPane, new text().chuanhapthe);
            } else {
                write("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\Card\\Card500.card");
            }
        }

    }//GEN-LAST:event_buutonAddActionPerformed

    private void buttonTakeOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTakeOutActionPerformed
        if (comboboxOut.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, new text().chuaChonLoaiThe.getText());
        }

        if (comboboxOut.getSelectedIndex() == 1) {
            if (JOptionPane.showConfirmDialog(rootPane, new text().banmuonlaythe) == 0) {
                read("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\Card\\Card20.card");

            }
        }

        if (comboboxOut.getSelectedIndex() == 2) {
            if (JOptionPane.showConfirmDialog(rootPane, new text().banmuonlaythe) == 0) {
                read("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\Card\\Card50.card");

            }
        }

        if (comboboxOut.getSelectedIndex() == 3) {
            if (JOptionPane.showConfirmDialog(rootPane, new text().banmuonlaythe) == 0) {
                read("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\Card\\Card100.card");

            }
        }

        if (comboboxOut.getSelectedIndex() == 4) {
            if (JOptionPane.showConfirmDialog(rootPane, new text().banmuonlaythe) == 0) {
                read("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\Card\\Card200.card");

            }
        }

        if (comboboxOut.getSelectedIndex() == 5) {
            if (JOptionPane.showConfirmDialog(rootPane, new text().banmuonlaythe) == 0) {
                read("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\Card\\Card500.card");

            }
        }
    }//GEN-LAST:event_buttonTakeOutActionPerformed

    private void buttonHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHistoryActionPerformed
        String day = JOptionPane.showInputDialog(new text().nhapngay);
        txArea.setText("");
        int sum = 0;
        if ((new File("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\History\\History" + day + ".his")).exists()) {

            try (Scanner sc = new Scanner(new File("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\History\\History" + day + ".his"))) {
                while (sc.hasNext()) {
                    txArea.append(sc.nextLine() + "\n");
                }
            } catch (Exception e) {
            }

            try (Scanner sc1 = new Scanner(new File("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\Sum\\Sum" + fm1.format(new Date()) + ".sum"))) {
                while (sc1.hasNext()) {
                    sum += new Integer(sc1.nextLine());
                }
            } catch (Exception e) {
            }

            txArea.append("\nSome of Money:  " + sum + ".000");
        } else {
            JOptionPane.showMessageDialog(rootPane, new text().khongkhadung);
        }
    }//GEN-LAST:event_buttonHistoryActionPerformed

    private void buttonChangePassWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChangePassWordActionPerformed
        new ChangePassWord().setVisible(true);
    }//GEN-LAST:event_buttonChangePassWordActionPerformed

    private void buttonCheckCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCheckCardActionPerformed
        int count20 = 0, count50 = 0, count100 = 0, count200 = 0, count500 = 0;
        try (Scanner sc = new Scanner(new File("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\Card\\Card20.card"))) {
            count20 = 0;
            while (sc.hasNext()) {
                sc.nextLine();
                count20++;
            }
        } catch (Exception e) {
        }

        try (Scanner sc = new Scanner(new File("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\Card\\Card50.card"))) {
            count50 = 0;
            while (sc.hasNext()) {
                sc.nextLine();
                count50++;
            }
        } catch (Exception e) {
        }

        try (Scanner sc = new Scanner(new File("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\Card\\Card100.card"))) {
            count100 = 0;
            while (sc.hasNext()) {
                sc.nextLine();
                count100++;
            }
        } catch (Exception e) {
        }

        try (Scanner sc = new Scanner(new File("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\Card\\Card200.card"))) {
            count200 = 0;
            while (sc.hasNext()) {
                sc.nextLine();
                count200++;
            }
        } catch (Exception e) {
        }

        try (Scanner sc = new Scanner(new File("C:\\Users\\Administrator\\Desktop\\ToolManagementZingCard\\Data\\Card\\Card500.card"))) {
            count500 = 0;
            while (sc.hasNext()) {
                sc.nextLine();
                count500++;
            }
        } catch (Exception e) {
        }

        JOptionPane.showMessageDialog(rootPane, " Zing 20.000:     " + count20 + "\n" + " Zing 50.000:     " + count50 + "\n" + " Zing 100.000:   " + count100 + "\n" + " Zing 200.000:   " + count200 + "\n" + " Zing 500.000:   " + count500 + "\n");
    }//GEN-LAST:event_buttonCheckCardActionPerformed

    private void buttonprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonprintActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane, new text().banmuonin)==0){
            PrinterJob pj = PrinterJob.getPrinterJob();
            pj.setPrintable(new PrintBillCard(), getPageFormat(pj));
            try {
                pj.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_buttonprintActionPerformed

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
            java.util.logging.Logger.getLogger(ManagementCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagementCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagementCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagementCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagementCard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonChangePassWord;
    private javax.swing.JButton buttonCheckCard;
    private javax.swing.JButton buttonHistory;
    private javax.swing.JButton buttonTakeOut;
    private javax.swing.JButton buttonprint;
    private javax.swing.JButton buutonAdd;
    private javax.swing.JComboBox<String> comboboxIn;
    private javax.swing.JComboBox<String> comboboxOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txArea;
    private javax.swing.JTextField txfInCode;
    private javax.swing.JTextField txfInSeri;
    protected javax.swing.JTextField txfOutCode;
    protected javax.swing.JTextField txfOutSeri;
    // End of variables declaration//GEN-END:variables
}
