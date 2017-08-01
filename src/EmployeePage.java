
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author malya
 */
public class EmployeePage extends javax.swing.JFrame {

    /**
     * Creates new form EmployeePage
     */
    Thread t;
    int x=300,left=40,y=40;
    ImageIcon icon=null;
    byte[] data_img=null;
    int photos;
    String username;
    java.awt.Color oldcolor=null;
    int i=1;
    DefaultTableModel model=null;
    
    public static EmployeePage ref=null;
    private EmployeePage(String username)
    {
        initComponents();
        this.username=username;
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int)d.getWidth(),(int)(d.getHeight()-40));
        
        
      /*  DefaultTableCellRenderer alignment=new DefaultTableCellRenderer();
        alignment.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumn("Sr No.").setCellRenderer(alignment);
        table.getColumn("Medicine Name").setCellRenderer(alignment);
        table.getColumn("Quantity").setCellRenderer(alignment);
        table.getColumn("Stock Date").setCellRenderer(alignment);
        */
        mainpandel.requestFocus();
        txtfname.setEnabled(true);
        txtname.setEnabled(true);
        txtmob.setEnabled(true);

        txtemail.setEnabled(true);
       
       
        //panelinfo.requestFocus();
        Connection cn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
         try
        {
            cn=Database.getConnection();
            String sql="select name,fname,mobileNo,whatsappNo,emailid,photo from user where username=?;";
            ps=cn.prepareStatement(sql);
            ps.setString(1, username);
            rs=ps.executeQuery();
            
            rs.next();
            txtname.setText(rs.getString(1));
            txtfname.setText(rs.getString(2));
            txtmob.setText(rs.getString(3));
            txtwhatsappno.setText(rs.getString(4));
            txtemail.setText(rs.getString(5));
            //byte[] imagedata=rs.getBytes(6);
            //BufferedImage buf_img=ImageIO.read(new ByteArrayInputStream(imagedata));
            
            //lblphoto.setIcon(new ImageIcon(buf_img));
           
          
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Access denied", "Login Error", JOptionPane.ERROR_MESSAGE);
            dispose();
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
                Logger.getLogger(EmployeePage.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
     
         
         
         //Code to fetch all data which are less than deadline
         
         Connection con=null;
         PreparedStatement ps1=null;
         ResultSet rs1=null;
         try
         {
            con=Database.getConnection();
            String sql="select mname,type,box,date from medicine where box<deadline";
            ps1=con.prepareStatement(sql);
            rs1=ps1.executeQuery();
            int srno=1;
            
            model=(DefaultTableModel)table.getModel();
            while(rs1.next())
            {
                
                model.addRow(new Object[]{(srno++),rs1.getString(1),rs1.getString(2),rs1.getString(3)+" Boxes",rs1.getString(4)});
            }
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Access denied","Login Error",JOptionPane.ERROR_MESSAGE);
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
                Logger.getLogger(EmployeePage.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
    }

    
    //Code to write a method which will return it's own reference;
    
    public static EmployeePage getObj(String username)
    {
        if(ref==null)
        {
            ref=new EmployeePage(username);
            return ref;
        }
        else
            return ref;
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpandel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        panelout = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        paneltoday = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        panelsale = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        panelother = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        panelrcpt = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        paneluser3 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtwhatsappno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblphoto = new javax.swing.JLabel();
        txtname1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtfname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtmob = new javax.swing.JTextField();
        cmdupdate = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MM COMPUTER");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainpandel.setBackground(new java.awt.Color(255, 255, 255));
        mainpandel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Eklektic", 1, 70)); // NOI18N
        jLabel13.setText("DIGITAL INDIA");
        mainpandel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 55, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.jpg"))); // NOI18N
        mainpandel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 180, 170));

        jLabel9.setText("jLabel4");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        mainpandel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 170, 1360, 1));

        jLabel11.setText("jLabel9");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        mainpandel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1095, 241, 1, 430));

        jLabel10.setText("jLabel9");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        mainpandel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 241, 1, 430));

        panelout.setBackground(new java.awt.Color(255, 126, 13));
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

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel23.setText("Sign Out");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        panelout.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 8, -1, 20));

        mainpandel.add(panelout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 68, 120, 38));

        jPanel5.setBackground(new java.awt.Color(255, 190, 19));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Benguiat Bk BT", 1, 30)); // NOI18N
        jLabel14.setText("Records");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        mainpandel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 180, 220, 55));

        jPanel8.setBackground(new java.awt.Color(255, 190, 19));

        jLabel21.setFont(new java.awt.Font("Benguiat Bk BT", 1, 30)); // NOI18N
        jLabel21.setText("User Profile");
        jPanel8.add(jLabel21);

        mainpandel.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 200, 55));

        jLabel15.setText("jLabel4");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        mainpandel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 1360, 1));

        table.setAutoCreateRowSorter(true);
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
                false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(51, 51, 51));
        table.setRowHeight(30);
        table.setSelectionBackground(new java.awt.Color(255, 255, 255));
        table.setSelectionForeground(new java.awt.Color(51, 51, 51));
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(100);
            table.getColumnModel().getColumn(0).setPreferredWidth(100);
            table.getColumnModel().getColumn(0).setMaxWidth(100);
            table.getColumnModel().getColumn(2).setMinWidth(150);
            table.getColumnModel().getColumn(2).setPreferredWidth(150);
            table.getColumnModel().getColumn(2).setMaxWidth(150);
            table.getColumnModel().getColumn(3).setMinWidth(130);
            table.getColumnModel().getColumn(3).setPreferredWidth(130);
            table.getColumnModel().getColumn(3).setMaxWidth(130);
            table.getColumnModel().getColumn(4).setMinWidth(170);
            table.getColumnModel().getColumn(4).setPreferredWidth(170);
            table.getColumnModel().getColumn(4).setMaxWidth(170);
        }

        mainpandel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 820, 370));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 0), 1, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paneltoday.setBackground(new java.awt.Color(51, 145, 178));
        paneltoday.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 202, 32), null, null));
        paneltoday.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                paneltodayMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                paneltodayMouseMoved(evt);
            }
        });
        paneltoday.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                paneltodayFocusLost(evt);
            }
        });
        paneltoday.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                paneltodayMouseWheelMoved(evt);
            }
        });
        paneltoday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneltodayMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paneltodayMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneltodayMouseExited(evt);
            }
        });
        paneltoday.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Benguiat Bk BT", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Today");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jLabel20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel20KeyPressed(evt);
            }
        });
        paneltoday.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 60, -1));

        jPanel1.add(paneltoday, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 180, 50));

        panelsale.setBackground(new java.awt.Color(51, 145, 178));
        panelsale.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 202, 32), null, null));
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

        jLabel26.setFont(new java.awt.Font("Benguiat Bk BT", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Sale");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        panelsale.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 10, 60, -1));

        jPanel1.add(panelsale, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 180, 50));

        panelother.setBackground(new java.awt.Color(51, 145, 178));
        panelother.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 202, 32), null, null));
        panelother.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelotherMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelotherMouseMoved(evt);
            }
        });
        panelother.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                panelotherFocusLost(evt);
            }
        });
        panelother.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                panelotherMouseWheelMoved(evt);
            }
        });
        panelother.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelotherMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelotherMouseExited(evt);
            }
        });
        panelother.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Benguiat Bk BT", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("New Feature");
        panelother.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 130, -1));

        jPanel1.add(panelother, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 180, 50));

        panelrcpt.setBackground(new java.awt.Color(51, 145, 178));
        panelrcpt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 202, 32), null, null));
        panelrcpt.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelrcptMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelrcptMouseMoved(evt);
            }
        });
        panelrcpt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                panelrcptFocusLost(evt);
            }
        });
        panelrcpt.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                panelrcptMouseWheelMoved(evt);
            }
        });
        panelrcpt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelrcptMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelrcptMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelrcptMouseExited(evt);
            }
        });
        panelrcpt.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Benguiat Bk BT", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Receipt");
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });
        panelrcpt.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 10, 80, -1));

        jPanel1.add(panelrcpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 180, 50));

        mainpandel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 171, 875, 70));

        jLabel16.setText("jLabel9");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        mainpandel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 1, 430));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ref.jpg"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 30, 30));

        mainpandel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 875, 430));

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
        jLabel28.setText("Medicine Details");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        paneluser3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 10, -1, -1));

        mainpandel.add(paneluser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 270, 220, 50));

        txtname.setEditable(false);
        txtname.setBackground(new java.awt.Color(255, 255, 255));
        txtname.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        txtname.setForeground(new java.awt.Color(102, 102, 102));
        txtname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtname.setBorder(null);
        txtname.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtname.setSelectionColor(new java.awt.Color(255, 255, 255));
        mainpandel.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 200, 25));

        jLabel17.setFont(new java.awt.Font("Benguiat Bk BT", 1, 15)); // NOI18N
        jLabel17.setText("+91-");
        mainpandel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 247, 40, 25));

        txtwhatsappno.setEditable(false);
        txtwhatsappno.setBackground(new java.awt.Color(255, 255, 255));
        txtwhatsappno.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        txtwhatsappno.setForeground(new java.awt.Color(51, 51, 51));
        txtwhatsappno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtwhatsappno.setBorder(null);
        txtwhatsappno.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtwhatsappno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtwhatsappnoKeyTyped(evt);
            }
        });
        mainpandel.add(txtwhatsappno, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 247, 110, 25));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whatsapp.png"))); // NOI18N
        mainpandel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 247, 30, 30));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 51));
        jLabel6.setText(" User Name :");
        mainpandel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, -1));

        lblphoto.setText("                Photo");
        lblphoto.setToolTipText("");
        lblphoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblphoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblphotoMouseClicked(evt);
            }
        });
        mainpandel.add(lblphoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 120, 120));

        txtname1.setEditable(false);
        txtname1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        txtname1.setForeground(new java.awt.Color(51, 51, 51));
        txtname1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtname1.setBorder(null);
        txtname1.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtname1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtname1KeyTyped(evt);
            }
        });
        mainpandel.add(txtname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 200, 25));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 51));
        jLabel2.setText("Father's Name :");
        mainpandel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 465, 110, -1));

        txtfname.setEditable(false);
        txtfname.setBackground(new java.awt.Color(255, 255, 255));
        txtfname.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        txtfname.setForeground(new java.awt.Color(51, 51, 51));
        txtfname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfname.setBorder(null);
        txtfname.setDisabledTextColor(new java.awt.Color(255, 255, 255));
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
        mainpandel.add(txtfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 485, 200, 25));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 51));
        jLabel3.setText("Email ID:");
        mainpandel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 525, 80, 25));

        txtemail.setEditable(false);
        txtemail.setBackground(new java.awt.Color(255, 255, 255));
        txtemail.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        txtemail.setForeground(new java.awt.Color(51, 51, 51));
        txtemail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtemail.setBorder(null);
        txtemail.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });
        mainpandel.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 545, 200, 25));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 51));
        jLabel5.setText("Mob No: ");
        mainpandel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 580, 70, -1));

        jLabel8.setFont(new java.awt.Font("Benguiat Bk BT", 1, 15)); // NOI18N
        jLabel8.setText("+91-");
        mainpandel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 595, 40, 25));

        txtmob.setEditable(false);
        txtmob.setBackground(new java.awt.Color(255, 255, 255));
        txtmob.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        txtmob.setForeground(new java.awt.Color(51, 51, 51));
        txtmob.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtmob.setBorder(null);
        txtmob.setDisabledTextColor(new java.awt.Color(255, 255, 255));
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
        mainpandel.add(txtmob, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 595, 130, 25));

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
        mainpandel.add(cmdupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 640, 90, 30));

        getContentPane().add(mainpandel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 685));

        jMenu1.setText("File");

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

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        MainForm.getObj().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel23MouseClicked

    private void paneloutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneloutMouseClicked
        MainForm.getObj().setVisible(true);
        dispose();
    }//GEN-LAST:event_paneloutMouseClicked

    private void paneltodayMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneltodayMouseDragged

    }//GEN-LAST:event_paneltodayMouseDragged

    private void paneltodayMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneltodayMouseMoved

    }//GEN-LAST:event_paneltodayMouseMoved

    private void paneltodayFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_paneltodayFocusLost

    }//GEN-LAST:event_paneltodayFocusLost

    private void paneltodayMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_paneltodayMouseWheelMoved

    }//GEN-LAST:event_paneltodayMouseWheelMoved

    private void paneltodayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneltodayMouseEntered
//        oldcolor=paneltoday.getBackground();
  //      paneltoday.setBackground(java.awt.Color.blue);
    }//GEN-LAST:event_paneltodayMouseEntered

    private void paneltodayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneltodayMouseExited
        //paneltoday.setBackground(oldcolor);
    }//GEN-LAST:event_paneltodayMouseExited

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        Search.getObj().setVisible(true);
    }//GEN-LAST:event_jLabel28MouseClicked

    private void panelsaleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelsaleMouseDragged
        // TODO add your handling code here:
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
    }//GEN-LAST:event_panelsaleMouseEntered

    private void panelsaleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelsaleMouseExited

    }//GEN-LAST:event_panelsaleMouseExited

    private void panelotherMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelotherMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_panelotherMouseDragged

    private void panelotherMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelotherMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_panelotherMouseMoved

    private void panelotherFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelotherFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_panelotherFocusLost

    private void panelotherMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_panelotherMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_panelotherMouseWheelMoved

    private void panelotherMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelotherMouseEntered
    //    oldcolor=panelother.getBackground();
      //  panelother.setBackground(java.awt.Color.blue);
    }//GEN-LAST:event_panelotherMouseEntered

    private void panelotherMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelotherMouseExited
        //panelother.setBackground(oldcolor);
    }//GEN-LAST:event_panelotherMouseExited

    private void panelrcptMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelrcptMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_panelrcptMouseDragged

    private void panelrcptMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelrcptMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_panelrcptMouseMoved

    private void panelrcptFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelrcptFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_panelrcptFocusLost

    private void panelrcptMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_panelrcptMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_panelrcptMouseWheelMoved

    private void panelrcptMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelrcptMouseEntered
//        oldcolor=panelrcpt.getBackground();
  //      panelrcpt.setBackground(java.awt.Color.blue);
    }//GEN-LAST:event_panelrcptMouseEntered

    private void panelrcptMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelrcptMouseExited
//       panelrcpt.setBackground(oldcolor);
    }//GEN-LAST:event_panelrcptMouseExited

    private void paneloutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneloutMouseEntered
    }//GEN-LAST:event_paneloutMouseEntered

    private void paneloutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneloutMouseExited

    }//GEN-LAST:event_paneloutMouseExited

    private void panelsaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelsaleMouseClicked
        SaleItem.getObj(username).setVisible(true);
    }//GEN-LAST:event_panelsaleMouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        SaleItem.getObj(username).setVisible(true);
    }//GEN-LAST:event_jLabel26MouseClicked

    private void paneluser3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneluser3MouseClicked
       Search.getObj().setVisible(true);
    }//GEN-LAST:event_paneluser3MouseClicked

    private void panelrcptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelrcptMouseClicked
           ReceiptAfter.getObj(username).setVisible(true);
    }//GEN-LAST:event_panelrcptMouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        ReceiptAfter.getObj(username).setVisible(true);
    }//GEN-LAST:event_jLabel29MouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        dispose();
        ref=null;
    }//GEN-LAST:event_formWindowClosed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Connection cn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try
        {
            if(table.getRowCount()>0)
            {
                for(int i=0;i<table.getRowCount();i++)
                {
                    model.removeRow(i);
                }
            }
            model.removeRow(0);
            cn=Database.getConnection();
            String sql="select mname,type,box,date from medicine where box<deadline";
            ps=cn.prepareStatement(sql);
            rs=ps.executeQuery();
            int srno=1;
            
           // model=(DefaultTableModel)table.getModel();
            while(rs.next())
            {
                model.addRow(new Object[]{(srno++),rs.getString(1),rs.getString(2),rs.getString(3)+" Boxes",rs.getString(4)});
            }
            
            JOptionPane.showMessageDialog(this, "Records Updated","Updation",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Administrator Access denied","Error",JOptionPane.ERROR_MESSAGE);
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
                Logger.getLogger(EmployeePage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void paneltodayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneltodayMouseClicked
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String cur_date=dateFormat.format(date);
        MisReport.getObj(cur_date).setVisible(true);
    }//GEN-LAST:event_paneltodayMouseClicked

    private void jLabel20KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel20KeyPressed
       
    }//GEN-LAST:event_jLabel20KeyPressed

    private void txtwhatsappnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtwhatsappnoKeyTyped

        char ch=evt.getKeyChar();
        String text=txtwhatsappno.getText().trim();
        if(!(Character.isDigit(ch)) || text.length()>=10)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtwhatsappnoKeyTyped

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

    private void txtname1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtname1KeyTyped
        char ch=evt.getKeyChar();
        //String text=txtadminname.getText().trim();
        if(!(Character.isAlphabetic(ch)) && ch!=' ')
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtname1KeyTyped

    private void txtfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfnameActionPerformed

    private void txtfnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfnameKeyTyped
        char ch=evt.getKeyChar();
        //String text=txtadminname.getText().trim();
        if(!(Character.isAlphabetic(ch)) && ch!=' ')
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtfnameKeyTyped

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void txtmobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmobActionPerformed

    private void txtmobKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmobKeyTyped
        char ch=evt.getKeyChar();
        String text=txtmob.getText().trim();
        if(!(Character.isDigit(ch)) || text.length()>=10)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtmobKeyTyped

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

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String cur_date=dateFormat.format(date);
        MisReport.getObj(cur_date).setVisible(true);
    }//GEN-LAST:event_jLabel20MouseClicked

    
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdupdate;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblphoto;
    private javax.swing.JPanel mainpandel;
    private javax.swing.JPanel panelother;
    private javax.swing.JPanel panelout;
    private javax.swing.JPanel panelrcpt;
    private javax.swing.JPanel panelsale;
    private javax.swing.JPanel paneltoday;
    private javax.swing.JPanel paneluser3;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtmob;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtname1;
    private javax.swing.JTextField txtwhatsappno;
    // End of variables declaration//GEN-END:variables
}
