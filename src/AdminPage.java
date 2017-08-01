
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import net.coobird.thumbnailator.Thumbnails;
//import sun.swing.table.DefaultTableCellHeaderRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author malya
 */
public class AdminPage extends javax.swing.JFrame {

    /**
     * Creates new form EmployeePage
     */
    private static AdminPage ref = null;
    int photos;
    ImageIcon icon = null;
    byte[] data_img = null;

    String username;
    Thread t;
    int x = 300, left = 40, y = 40;
    int status = 0;
    java.awt.Color oldcolor = null;
    int i=0;
    DefaultTableModel model = null;

    private AdminPage(String username) {
        initComponents();
        
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) d.getWidth(), (int) (d.getHeight() - 40));
/*        //JOptionPane.showMessageDialog(this, "Jhis");
        DefaultTableCellRenderer alignment = new DefaultTableCellRenderer();
        alignment.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumn("Sr No.").setCellRenderer(alignment);
        table.getColumn("Medicine Name").setCellRenderer(alignment);
        table.getColumn("Type").setCellRenderer(alignment);
        table.getColumn("Quantity").setCellRenderer(alignment);
        table.getColumn("Stock Date").setCellRenderer(alignment);
*/
        //Code to fetch the medicine which are below the deadline.
        
        Connection cn =null;
        PreparedStatement ps =null;
        ResultSet rs =null;
        try {
            cn = Database.getConnection();
            String sql = "select mname,type,box,date from medicine where box<deadline";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            int srno = 1;

            model = (DefaultTableModel) table.getModel();
            while (rs.next()) {
                model.addRow(new Object[]{(srno++), rs.getString(1), rs.getString(2), rs.getString(3) + " Boxes", rs.getString(4)});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Administrator Access denied", "Error", JOptionPane.ERROR_MESSAGE);
        }
        finally
        {
            try {
                if(cn!=null)
                    cn.close();
                if(ps!=null)
                    ps.close();
                if(rs!=null)
                    rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.username = username;
        txtfname.setEnabled(true);
        txtname.setEnabled(true);
        txtmob.setEnabled(true);

        txtemail.setEnabled(true);
        

        //panelmain.requestFocus();
        
        
        Connection con=null;
        PreparedStatement ps1 =null;
        ResultSet rs1 =null;
        try {
            con = Database.getConnection();
            String sql = "select name,fname,mobileNo,whatsappNo,emailid,photo from admin where username=?;";
            ps1 = con.prepareStatement(sql);
            ps1.setString(1, username);
            rs1= ps1.executeQuery();
            
            rs1.next();
            
            txtname.setText(rs1.getString(1));
            txtfname.setText(rs1.getString(2));
            txtmob.setText(rs1.getString(3));
            txtwhatsappno.setText( rs1.getString(4));
            txtemail.setText(rs1.getString(5));
            
            byte[] imagedata=rs1.getBytes(6);
            
            if(imagedata.length>4)
            {
                BufferedImage buf_img=ImageIO.read(new ByteArrayInputStream(imagedata));
                lblphoto.setIcon(new ImageIcon(buf_img));
            }
            
            
        }
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(this, "Administrator Access denied", "Login Error", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
         finally
        {
            try {
                if(con!=null)
                    con.close();
                if(ps1!=null)
                    ps1.close();
                if(rs1!=null)
                    rs1.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }
    //Creating the method as static which will return the object of this class.

    public static AdminPage getObj(String username) {
        if (ref == null) {
            ref = new AdminPage(username);
            return ref;
        } else {
            return ref;
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

        cmdtoday = new java.awt.Button();
        cmdmonth = new java.awt.Button();
        cmdyear = new java.awt.Button();
        cmdall = new java.awt.Button();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        panelout = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        lblphoto = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtfname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtmob = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        lblsave = new javax.swing.JLabel();
        lblchangephoto = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtwhatsappno = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        paneladd = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelrecpt = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        panelsale = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        panelinfo = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        paneluser3 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        paneluser4 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        paneluser5 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelreg = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        paneluser2 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmdupdate = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        cmdtoday.setBackground(new java.awt.Color(255, 171, 169));
        cmdtoday.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        cmdtoday.setLabel("Today");
        cmdtoday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdtodayActionPerformed(evt);
            }
        });

        cmdmonth.setBackground(new java.awt.Color(255, 174, 160));
        cmdmonth.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        cmdmonth.setLabel("Monthly");
        cmdmonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdmonthActionPerformed(evt);
            }
        });

        cmdyear.setBackground(new java.awt.Color(255, 170, 163));
        cmdyear.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        cmdyear.setLabel("Yearly");
        cmdyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdyearActionPerformed(evt);
            }
        });

        cmdall.setBackground(new java.awt.Color(255, 168, 175));
        cmdall.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        cmdall.setLabel("All Record");
        cmdall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdallActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MM COMPUTER");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("jLabel9");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 1, 450));

        jLabel11.setText("jLabel9");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 230, 1, 450));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.jpg"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 180, 170));

        jLabel13.setFont(new java.awt.Font("Eklektic-Normal", 1, 70)); // NOI18N
        jLabel13.setText("DIGITAL INDIA");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 53, 660, -1));

        jPanel2.setBackground(new java.awt.Color(255, 150, 34));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Benguiat Bk BT", 1, 24)); // NOI18N
        jLabel14.setText("Admin Profile");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 200, 60));

        panelout.setBackground(new java.awt.Color(255, 102, 102));
        panelout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 131, 26), null, null));
        panelout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneloutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paneloutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneloutMouseExited(evt);
            }
        });
        panelout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel23.setText("Sign Out");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        panelout.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, 70, 20));

        jPanel1.add(panelout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 70, 110, 40));

        lblphoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sa.jpg"))); // NOI18N
        lblphoto.setText("                Photo");
        lblphoto.setToolTipText("");
        lblphoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblphoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblphotoMouseClicked(evt);
            }
        });
        jPanel1.add(lblphoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 120, 120));

        txtname.setEditable(false);
        txtname.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        txtname.setForeground(new java.awt.Color(51, 51, 51));
        txtname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtname.setBorder(null);
        txtname.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtname.setNextFocusableComponent(txtfname);
        txtname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnameKeyTyped(evt);
            }
        });
        jPanel1.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 200, 25));

        txtfname.setEditable(false);
        txtfname.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        txtfname.setForeground(new java.awt.Color(51, 51, 51));
        txtfname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfname.setBorder(null);
        txtfname.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtfname.setNextFocusableComponent(txtemail);
        txtfname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfnameActionPerformed(evt);
            }
        });
        txtfname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfnameKeyTyped(evt);
            }
        });
        jPanel1.add(txtfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 485, 200, 25));

        jLabel8.setFont(new java.awt.Font("Benguiat Bk BT", 1, 15)); // NOI18N
        jLabel8.setText("+91-");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 595, 40, 25));

        txtmob.setEditable(false);
        txtmob.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        txtmob.setForeground(new java.awt.Color(51, 51, 51));
        txtmob.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtmob.setBorder(null);
        txtmob.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtmob.setNextFocusableComponent(cmdupdate);
        txtmob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmobActionPerformed(evt);
            }
        });
        txtmob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmobKeyTyped(evt);
            }
        });
        jPanel1.add(txtmob, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 595, 130, 25));

        txtemail.setEditable(false);
        txtemail.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        txtemail.setForeground(new java.awt.Color(51, 51, 51));
        txtemail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtemail.setBorder(null);
        txtemail.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtemail.setNextFocusableComponent(txtmob);
        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });
        jPanel1.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 545, 200, 25));

        lblsave.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        lblsave.setForeground(new java.awt.Color(51, 51, 51));
        lblsave.setToolTipText("Click to save");
        lblsave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblsaveMouseClicked(evt);
            }
        });
        jPanel1.add(lblsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblchangephoto.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        lblchangephoto.setForeground(new java.awt.Color(51, 51, 51));
        lblchangephoto.setToolTipText("Click To change picture");
        lblchangephoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblchangephotoMouseClicked(evt);
            }
        });
        jPanel1.add(lblchangephoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel17.setFont(new java.awt.Font("Benguiat Bk BT", 1, 15)); // NOI18N
        jLabel17.setText("+91-");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 40, 25));

        txtwhatsappno.setEditable(false);
        txtwhatsappno.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        txtwhatsappno.setForeground(new java.awt.Color(51, 51, 51));
        txtwhatsappno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtwhatsappno.setBorder(null);
        txtwhatsappno.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtwhatsappno.setNextFocusableComponent(txtname);
        txtwhatsappno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtwhatsappnoKeyTyped(evt);
            }
        });
        jPanel1.add(txtwhatsappno, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 240, 110, 25));

        jLabel25.setText("jLabel4");
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 1370, 1));

        jPanel11.setBackground(new java.awt.Color(255, 255, 204));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 0), 1, true));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paneladd.setBackground(new java.awt.Color(51, 145, 178));
        paneladd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 202, 32), null, null));
        paneladd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                paneladdFocusGained(evt);
            }
        });
        paneladd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneladdMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paneladdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneladdMouseExited(evt);
            }
        });
        paneladd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Benguiat Bk BT", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Medicine");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        paneladd.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 7, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 153, 102));
        jLabel3.setFont(new java.awt.Font("AC", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NEW");
        paneladd.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 10, -1, 20));

        jPanel11.add(paneladd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 140, 40));

        panelrecpt.setBackground(new java.awt.Color(51, 145, 178));
        panelrecpt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 202, 32), null, null));
        panelrecpt.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelrecptMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelrecptMouseMoved(evt);
            }
        });
        panelrecpt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                panelrecptFocusLost(evt);
            }
        });
        panelrecpt.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                panelrecptMouseWheelMoved(evt);
            }
        });
        panelrecpt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelrecptMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelrecptMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelrecptMouseExited(evt);
            }
        });
        panelrecpt.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Benguiat Bk BT", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Receipt");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        panelrecpt.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 8, 80, -1));

        jPanel11.add(panelrecpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 160, 40));

        panelsale.setBackground(new java.awt.Color(51, 145, 178));
        panelsale.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 202, 32), null, null));
        panelsale.setForeground(new java.awt.Color(255, 255, 255));
        panelsale.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelsaleMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelsaleMouseMoved(evt);
            }
        });
        panelsale.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                panelsaleFocusLost(evt);
            }
        });
        panelsale.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                panelsaleMouseWheelMoved(evt);
            }
        });
        panelsale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelsaleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelsaleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelsaleMouseExited(evt);
            }
        });
        panelsale.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Benguiat Bk BT", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Sale");
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });
        panelsale.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 8, 60, -1));

        jPanel11.add(panelsale, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 160, 40));

        panelinfo.setBackground(new java.awt.Color(51, 145, 178));
        panelinfo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 202, 32), null, null));
        panelinfo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelinfoMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelinfoMouseMoved(evt);
            }
        });
        panelinfo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                panelinfoFocusLost(evt);
            }
        });
        panelinfo.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                panelinfoMouseWheelMoved(evt);
            }
        });
        panelinfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelinfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelinfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelinfoMouseExited(evt);
            }
        });
        panelinfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Benguiat Bk BT", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("User Details");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        panelinfo.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 8, 120, -1));

        jPanel11.add(panelinfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 160, 40));

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 891, 61));

        jLabel10.setText("jLabel9");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 1, 450));

        jPanel4.setBackground(new java.awt.Color(255, 150, 34));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Benguiat Bk BT", 1, 24)); // NOI18N
        jLabel15.setText("Records");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 15, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 170, 230, 60));

        jLabel26.setText("jLabel4");
        jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 1370, 1));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 51));
        jLabel2.setText("Father's Name :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 465, 110, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setFont(new java.awt.Font("Benguiat Bk BT", 1, 15)); // NOI18N
        table.setForeground(new java.awt.Color(255, 51, 51));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr No.", "Medicine Name", "Type", "Quantity", "Stock Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(30);
        table.setRowSelectionAllowed(false);
        table.setSelectionBackground(new java.awt.Color(255, 255, 255));
        table.getTableHeader().setReorderingAllowed(false);
        table.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(100);
            table.getColumnModel().getColumn(0).setPreferredWidth(100);
            table.getColumnModel().getColumn(0).setMaxWidth(100);
            table.getColumnModel().getColumn(2).setMinWidth(200);
            table.getColumnModel().getColumn(2).setPreferredWidth(200);
            table.getColumnModel().getColumn(2).setMaxWidth(200);
            table.getColumnModel().getColumn(3).setMinWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setMaxWidth(100);
            table.getColumnModel().getColumn(4).setMinWidth(150);
            table.getColumnModel().getColumn(4).setPreferredWidth(150);
            table.getColumnModel().getColumn(4).setMaxWidth(150);
        }

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 27, 830, 410));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ref.jpg"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 30, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 890, 450));

        paneluser3.setBackground(new java.awt.Color(51, 145, 178));
        paneluser3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 202, 32), null, null));
        paneluser3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneluser3MouseClicked(evt);
            }
        });
        paneluser3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Benguiat Bk BT", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("MIS Report");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        paneluser3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 10, -1, -1));

        jPanel1.add(paneluser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 270, 230, 50));

        paneluser4.setBackground(new java.awt.Color(51, 145, 178));
        paneluser4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 202, 32), null, null));
        paneluser4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneluser4MouseClicked(evt);
            }
        });
        paneluser4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Benguiat Bk BT", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Medicine Details");
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });
        paneluser4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel1.add(paneluser4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 430, 230, 50));

        paneluser5.setBackground(new java.awt.Color(51, 145, 178));
        paneluser5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 202, 32), null, null));
        paneluser5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneluser5MouseClicked(evt);
            }
        });
        paneluser5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Benguiat Bk BT", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Supplier Details");
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });
        paneluser5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel1.add(paneluser5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 510, 230, 50));

        jLabel1.setFont(new java.awt.Font("Benguiat Bk BT", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 51));
        jLabel1.setText("Email ID:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 525, 80, 25));

        panelreg.setBackground(new java.awt.Color(51, 145, 178));
        panelreg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 202, 32), null, null));
        panelreg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelregMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelregMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelregMouseExited(evt);
            }
        });
        panelreg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Benguiat Bk BT", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("New User");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        panelreg.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jPanel1.add(panelreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 590, 230, 50));

        paneluser2.setBackground(new java.awt.Color(51, 145, 178));
        paneluser2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 202, 32), null, null));
        paneluser2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneluser2MouseClicked(evt);
            }
        });
        paneluser2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Benguiat Bk BT", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Update Medicine");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });
        paneluser2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 10, -1, -1));

        jPanel1.add(paneluser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 350, 230, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whatsapp.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 30, 30));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 51));
        jLabel5.setText("Mob No: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 580, 70, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 51));
        jLabel6.setText("Admin Name :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 100, -1));

        cmdupdate.setBackground(new java.awt.Color(255, 51, 51));
        cmdupdate.setFont(new java.awt.Font("Benguiat Bk BT", 1, 13)); // NOI18N
        cmdupdate.setForeground(new java.awt.Color(255, 255, 255));
        cmdupdate.setText("Update");
        cmdupdate.setBorder(null);
        cmdupdate.setEnabled(false);
        cmdupdate.setFocusable(false);
        cmdupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdupdateActionPerformed(evt);
            }
        });
        jPanel1.add(cmdupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 640, 90, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 680));

        jMenu1.setText("File");

        jMenuItem5.setText("Chage Password");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem1.setText("Edit Profile");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        txtwhatsappno.requestFocus();
        cmdupdate.setEnabled(true);
        cmdupdate.setFocusable(true);
        txtwhatsappno.setEditable(true);
        lblphoto.setToolTipText("SELECT TO UPLOAD IMAGE");
        txtwhatsappno.setBorder(new LineBorder(java.awt.Color.GRAY));
        txtname.setEditable(true);
        txtname.setBorder(new LineBorder(java.awt.Color.GRAY));
        txtfname.setEditable(true);
        txtfname.setBorder(new LineBorder(java.awt.Color.GRAY));
        txtemail.setEditable(true);
        txtemail.setBorder(new LineBorder(java.awt.Color.GRAY));
        txtmob.setEditable(true);
        txtmob.setBorder(new LineBorder(java.awt.Color.GRAY));
        lblphoto.setFocusable(true);
        i=1;

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void cmdallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdallActionPerformed

    }//GEN-LAST:event_cmdallActionPerformed

    private void cmdyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdyearActionPerformed


    }//GEN-LAST:event_cmdyearActionPerformed

    private void cmdmonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdmonthActionPerformed

        Calendar calendar = new GregorianCalendar();
        int mm = calendar.get(Calendar.MONTH);
        mm = mm + 1;
        String cdate = "0" + mm;
        //new Records(cdate).setVisible(true);
    }//GEN-LAST:event_cmdmonthActionPerformed

    private void cmdtodayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdtodayActionPerformed

        Calendar calendar = new GregorianCalendar();
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        int mm = calendar.get(Calendar.MONTH);
        int yy = calendar.get(Calendar.YEAR);
        mm = mm + 1;
        String cdate = "0" + dd + "/" + 0 + mm + "/" + yy;
        //new Records(cdate).setVisible(true);
    }//GEN-LAST:event_cmdtodayActionPerformed

    private void lblsaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsaveMouseClicked
        try {
            Connection cn = Database.getConnection();
            String sql = "update admin set name=?,fname=?,mobile=?,code=?,photo=? where username=?;";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, txtname.getText());
            ps.setString(2, txtfname.getText());
            ps.setString(3, txtmob.getText());
            ps.setString(5, username);
            ps.setBytes(6, data_img);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Updated Successfully!!", "Updated", JOptionPane.INFORMATION_MESSAGE);

            txtfname.setEnabled(false);
            txtname.setEnabled(false);
            txtmob.setEnabled(false);

            lblsave.setEnabled(false);
            lblchangephoto.setEnabled(false);
            lblsave.setText("");
            lblsave.setBorder(null);
            lblchangephoto.setText("");
            lblchangephoto.setBorder(null);

            cn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_lblsaveMouseClicked

    private void lblchangephotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblchangephotoMouseClicked
        JFileChooser jf = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Jpg Files", "jpg", "jpeg", "png");
        jf.setFileFilter(filter);
        if (jf.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File photo = jf.getSelectedFile();
            try {
                BufferedImage buf_img = ImageIO.read(photo);

                BufferedImage thumbal = Thumbnails.of(buf_img).size(170, 180).asBufferedImage();
                icon = new ImageIcon(thumbal);

                lblphoto.setIcon(icon);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ImageIO.write(thumbal, "jpeg", bos);
                InputStream is = new ByteArrayInputStream(bos.toByteArray());
                ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
                byte[] buff = new byte[1024];
                try {
                    for (int readNum; (readNum = is.read(buff)) != -1;) {
                        bos.write(buff, 0, readNum);

                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error in image Compression");
                }
                data_img = bos.toByteArray();
                photos = 1;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error in Image Selection");
            }
        }
    }//GEN-LAST:event_lblchangephotoMouseClicked

    private void txtmobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmobActionPerformed

    private void paneloutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneloutMouseClicked
        MainForm.getObj().setVisible(true);
        dispose();
    }//GEN-LAST:event_paneloutMouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        MainForm.getObj().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel23MouseClicked

    private void txtfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfnameActionPerformed

    private void panelregMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelregMouseClicked
        Registration.getObj().setVisible(true);
    }//GEN-LAST:event_panelregMouseClicked

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void panelrecptMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_panelrecptMouseWheelMoved

    }//GEN-LAST:event_panelrecptMouseWheelMoved

    private void panelrecptMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelrecptMouseMoved


    }//GEN-LAST:event_panelrecptMouseMoved

    private void panelrecptFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelrecptFocusLost

    }//GEN-LAST:event_panelrecptFocusLost

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        UpdateStock.getObj().setVisible(true);
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        MisReport.getObj().setVisible(true);
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        Search.getObj().setVisible(true);
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        Suppliers.getObj().setVisible(true);
    }//GEN-LAST:event_jLabel30MouseClicked

    private void panelrecptMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelrecptMouseDragged

    }//GEN-LAST:event_panelrecptMouseDragged

    private void paneladdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_paneladdFocusGained

    }//GEN-LAST:event_paneladdFocusGained

    private void paneladdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneladdMouseEntered
//        oldcolor=paneladd.getBackground();
//        paneladd.setBackground(java.awt.Color.WHITE);


    }//GEN-LAST:event_paneladdMouseEntered

    private void paneladdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneladdMouseExited
//       paneladd.setBackground(oldcolor);
    }//GEN-LAST:event_paneladdMouseExited

    private void paneloutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneloutMouseEntered
        //oldcolor = panelout.getBackground();
        //panelout.setBackground(java.awt.Color.blue);

    }//GEN-LAST:event_paneloutMouseEntered

    private void paneloutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneloutMouseExited
        //panelout.setBackground(oldcolor);
    }//GEN-LAST:event_paneloutMouseExited

    private void panelregMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelregMouseEntered
      //  oldcolor = panelreg.getBackground();
        //panelreg.setBackground(java.awt.Color.ORANGE);
    }//GEN-LAST:event_panelregMouseEntered

    private void panelregMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelregMouseExited
        //panelreg.setBackground(oldcolor);
    }//GEN-LAST:event_panelregMouseExited

    private void panelrecptMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelrecptMouseEntered
//        oldcolor = panelrecpt.getBackground();
  //      panelrecpt.setBackground(java.awt.Color.blue);
    }//GEN-LAST:event_panelrecptMouseEntered

    private void panelrecptMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelrecptMouseExited
    //    panelrecpt.setBackground(oldcolor);
    }//GEN-LAST:event_panelrecptMouseExited

    private void panelsaleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelsaleMouseDragged

    }//GEN-LAST:event_panelsaleMouseDragged

    private void panelsaleMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelsaleMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_panelsaleMouseMoved

    private void panelsaleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelsaleFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_panelsaleFocusLost

    private void panelsaleMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_panelsaleMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_panelsaleMouseWheelMoved

    private void panelsaleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelsaleMouseEntered
//        oldcolor = panelsale.getBackground();
  //      panelsale.setBackground(java.awt.Color.WHITE);
    }//GEN-LAST:event_panelsaleMouseEntered

    private void panelsaleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelsaleMouseExited
    //    panelsale.setBackground(oldcolor);
    }//GEN-LAST:event_panelsaleMouseExited

    private void panelinfoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelinfoMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_panelinfoMouseDragged

    private void panelinfoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelinfoMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_panelinfoMouseMoved

    private void panelinfoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelinfoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_panelinfoFocusLost

    private void panelinfoMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_panelinfoMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_panelinfoMouseWheelMoved

    private void panelinfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelinfoMouseEntered
//        oldcolor = panelinfo.getBackground();
  //      panelinfo.setBackground(java.awt.Color.blue);
    }//GEN-LAST:event_panelinfoMouseEntered

    private void panelinfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelinfoMouseExited
    //    panelinfo.setBackground(oldcolor);
    }//GEN-LAST:event_panelinfoMouseExited

    private void panelsaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelsaleMouseClicked
        SaleItem.getObj(username).setVisible(true);
    }//GEN-LAST:event_panelsaleMouseClicked

    private void panelrecptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelrecptMouseClicked
        ReceiptAfter.getObj(username).setVisible(true);
    }//GEN-LAST:event_panelrecptMouseClicked

    private void panelinfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelinfoMouseClicked

        AlluserInfo.getObj().setVisible(true);

    }//GEN-LAST:event_panelinfoMouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        AlluserInfo.getObj().setVisible(true);
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        Registration.getObj().setVisible(true);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        SaleItem.getObj(username).setVisible(true);
    }//GEN-LAST:event_jLabel31MouseClicked

    private void paneluser4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneluser4MouseClicked
        Search.getObj().setVisible(true);
    }//GEN-LAST:event_paneluser4MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        Stock.getObj(username).setVisible(true);
    }//GEN-LAST:event_jLabel21MouseClicked

    private void paneladdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneladdMouseClicked
        Stock.getObj(username).setVisible(true);
    }//GEN-LAST:event_paneladdMouseClicked

    private void paneluser5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneluser5MouseClicked
        Suppliers.getObj().setVisible(true);
    }//GEN-LAST:event_paneluser5MouseClicked

    private void paneluser2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneluser2MouseClicked
        UpdateStock.getObj().setVisible(true);
    }//GEN-LAST:event_paneluser2MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        try {

            if(table.getRowCount()>0)
            {
                for(int i=0;i<table.getRowCount();i++)
                {
                    model.removeRow(i);
                }
            }
            model.removeRow(0);
            int srno1 = 1;
            Connection cn = Database.getConnection();
            String sql = "select mname,type,box,date from medicine where box<deadline";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs1 = ps.executeQuery();

            //model=(DefaultTableModel)table.getModel();
            while (rs1.next()) {
                model.addRow(new Object[]{(srno1++), rs1.getString(1), rs1.getString(2)+ " Boxes", rs1.getString(3), rs1.getString(4)});
            }
            JOptionPane.showMessageDialog(this, "Records Updated successfully !", "Updation", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void tableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableFocusLost
        table.setFocusable(false);
    }//GEN-LAST:event_tableFocusLost

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        ReceiptAfter.getObj(username).setVisible(true);
    }//GEN-LAST:event_jLabel20MouseClicked

    private void paneluser3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneluser3MouseClicked
        MisReport.getObj().setVisible(true);
    }//GEN-LAST:event_paneluser3MouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       ref=null;
       dispose();
    }//GEN-LAST:event_formWindowClosed

    private void cmdupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdupdateActionPerformed
        i=0;
        cmdupdate.setEnabled(false);
        cmdupdate.setFocusable(false);
        txtwhatsappno.setEditable(false);
        txtwhatsappno.setBorder(null);
        txtname.setEditable(false);
        txtname.setBorder(null);
        txtfname.setEditable(false);
        txtfname.setBorder(null);
        txtemail.setEditable(false);
        txtemail.setBorder(null);
        txtmob.setEditable(false);
        txtmob.setBorder(null);
        lblphoto.setToolTipText("");
        
        try 
        {
            Connection cn=Database.getConnection();
            String sql="update admin set name=?,fname=?,mobileNo=?,whatsappNo=?,emailid=?,photo=? where username=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, txtname.getText());
            ps.setString(2, txtfname.getText());
            ps.setString(3, txtmob.getText());
            ps.setString(4, txtwhatsappno.getText());
            ps.setString(5, txtemail.getText());
            ps.setBytes(6, data_img);
            ps.setString(7, username);
            
            ps.executeUpdate();
            
            
            JOptionPane.showMessageDialog(this, "Data Updated!!!!");
        }
        catch (SQLException ex) {
            Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }//GEN-LAST:event_cmdupdateActionPerformed

    private void txtwhatsappnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtwhatsappnoKeyTyped
            
       char ch=evt.getKeyChar();
       String text=txtwhatsappno.getText().trim();
        if(!(Character.isDigit(ch)) || text.length()>=10)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtwhatsappnoKeyTyped

    private void txtmobKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmobKeyTyped
        char ch=evt.getKeyChar();
       String text=txtmob.getText().trim();
        if(!(Character.isDigit(ch)) || text.length()>=10)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtmobKeyTyped

    private void txtnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnameKeyTyped
                char ch=evt.getKeyChar();
        //String text=txtadminname.getText().trim();
        if(!(Character.isAlphabetic(ch)) && ch!=' ')
        {
            evt.consume();
        }

    }//GEN-LAST:event_txtnameKeyTyped

    private void txtfnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfnameKeyTyped
                char ch=evt.getKeyChar();
        //String text=txtadminname.getText().trim();
        if(!(Character.isAlphabetic(ch)) && ch!=' ')
        {
            evt.consume();
        }

    }//GEN-LAST:event_txtfnameKeyTyped

    private void lblphotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblphotoMouseClicked
        if(i!=0)
        {
            JFileChooser jf=new JFileChooser();
            FileNameExtensionFilter filter=new FileNameExtensionFilter("Jpg Files", "jpg","jpeg","png");
            jf.setFileFilter(filter);
            if(jf.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
            {
                File photo=jf.getSelectedFile();
                try
                {
                    BufferedImage buf_img=ImageIO.read(photo);
                
                    BufferedImage thumbal=Thumbnails.of(buf_img).size(120, 120).asBufferedImage();
                    icon=new ImageIcon(thumbal);
                
                    lblphoto.setIcon(icon);
                    ByteArrayOutputStream bos=new ByteArrayOutputStream();
                    ImageIO.write(thumbal,"jpeg", bos);
                    InputStream is=new ByteArrayInputStream(bos.toByteArray());
                    ByteArrayOutputStream bos2=new ByteArrayOutputStream();
                    byte[] buff=new byte[1024];
                    try
                    {
                        for(int readNum;(readNum=is.read(buff))!=-1;)
                        {
                             bos.write(buff,0,readNum);
                        
                        }
                    }
                
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(this, "Error in image Compression");
                }
                    data_img=bos.toByteArray();
                  
                    //Code to update the image...in user table.
                    Connection con=null;
                    PreparedStatement ps1=null;
                    try{
                    con=Database.getConnection();
                    String query="update user set photo=? where username=?";
                    ps1=con.prepareStatement(query);
                    ps1.setBytes(1, data_img);
                    ps1.setString(2, username);
                    ps1.executeUpdate();
                    }
                    catch(SQLException ex)
                    {
                        JOptionPane.showMessageDialog(this, "Unable to Update Image!!","Update Error",JOptionPane.ERROR_MESSAGE);
                    }
                    finally{
                        if(con!=null)
                            con.close();
                        if(ps1!=null)
                            ps1.close();
                        
                    }
           }
           catch(Exception e)
           {
               JOptionPane.showMessageDialog(this, "Error in Image Selection");
           }
            }
        }
        
    }//GEN-LAST:event_lblphotoMouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       ChangePassword.getObj(username).setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed
//    public static void main(String args[]) {
//
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                AdminPage.getObj("ssmalya").setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button cmdall;
    private java.awt.Button cmdmonth;
    private java.awt.Button cmdtoday;
    private javax.swing.JButton cmdupdate;
    private java.awt.Button cmdyear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblchangephoto;
    private javax.swing.JLabel lblphoto;
    private javax.swing.JLabel lblsave;
    private javax.swing.JPanel paneladd;
    private javax.swing.JPanel panelinfo;
    private javax.swing.JPanel panelout;
    private javax.swing.JPanel panelrecpt;
    private javax.swing.JPanel panelreg;
    private javax.swing.JPanel panelsale;
    private javax.swing.JPanel paneluser2;
    private javax.swing.JPanel paneluser3;
    private javax.swing.JPanel paneluser4;
    private javax.swing.JPanel paneluser5;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtmob;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtwhatsappno;
    // End of variables declaration//GEN-END:variables
}
