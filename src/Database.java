
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Database 
{

    public static Connection getConnection() throws SQLException
    {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3310/chemist","root","scott");
        return cn;
    }
    
    //code to fetch data from receipt table  between two dates.
    
    public static ArrayList<ReceiptPrint> fetchReceipt(String sdate,String ldate)
    {
        ArrayList<ReceiptPrint> al=null;
        Connection cn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            
            cn=getConnection();
            String sql="select  receipt_no,mname,total_amount, str_quantity, date, customer_name, amount from receipt where (date=? or date=?)or date between ? and ?";
            ps=cn.prepareStatement(sql);
            ps.setString(1, sdate);
            ps.setString(2, ldate);
            ps.setString(3, sdate);
            ps.setString(4, ldate);
            rs=ps.executeQuery();
            al=new ArrayList<>();
            while(rs.next())
            {
                ReceiptPrint rp=new ReceiptPrint();
                rp.setReceipt_no(rs.getInt(1));
                rp.setMname(rs.getString(2));
                rp.setTotal_amount(rs.getString(3));
                rp.setStr_quantity(rs.getString(4));
                rp.setDate(rs.getString(5));
                rp.setCustomer_name(rs.getString(6));
                rp.setAmount(rs.getDouble(7));
                //rp.setType(rs.getString(8));
                
                al.add(rp);
                
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return al;
    }
    
    
    
    //Code for fetching the data from receipt table of current date to display the receipt data 
    
    
    public static ArrayList<ReceiptPrint> fetchReceipt(String date)
    {
        ArrayList<ReceiptPrint> al=null;
        Connection cn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            
            cn=getConnection();
            String sql="select  receipt_no,mname,total_amount, str_quantity, date, customer_name, amount from receipt where date=?";
            ps=cn.prepareStatement(sql);
            ps.setString(1, date);
            rs=ps.executeQuery();
            al=new ArrayList<>();
            while(rs.next())
            {
                ReceiptPrint rp=new ReceiptPrint();
                rp.setReceipt_no(rs.getInt(1));
                rp.setMname(rs.getString(2));
                rp.setTotal_amount(rs.getString(3));
                rp.setStr_quantity(rs.getString(4));
                rp.setDate(rs.getString(5));
                rp.setCustomer_name(rs.getString(6));
                rp.setAmount(rs.getDouble(7));
                //rp.setType(rs.getString(8));
                
                al.add(rp);
                
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return al;
    }
    
    
    //Code for fetching data from receipt table to display the receipt data.
    
    public static ArrayList<ReceiptPrint> fetchReceipt()
    {
        ArrayList<ReceiptPrint> al=null;
        Connection cn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            
            cn=getConnection();
            String sql="select  receipt_no,mname,total_amount, str_quantity, date, customer_name, amount from receipt";
            ps=cn.prepareStatement(sql);
            rs=ps.executeQuery();
            al=new ArrayList<>();
            while(rs.next())
            {
                ReceiptPrint rp=new ReceiptPrint();
                rp.setReceipt_no(rs.getInt(1));
                rp.setMname(rs.getString(2));
                rp.setTotal_amount(rs.getString(3));
                rp.setStr_quantity(rs.getString(4));
                rp.setDate(rs.getString(5));
                rp.setCustomer_name(rs.getString(6));
                rp.setAmount(rs.getDouble(7));
                //rp.setType(rs.getString(8));
                
                al.add(rp);
                
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return al;
    }
    
    
    //Code for fetching all data of medicine table
    
    
    public static ArrayList<Stocking> getMedicine2()
    {
        ArrayList<Stocking> ar=null;
        Connection cn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try
        {
            cn=getConnection();
            
            String sql="select mname,company_name,cost,mrp,deadline,box,package,totalquantity,date,type from medicine";
            ps=cn.prepareStatement(sql);
            rs=ps.executeQuery();
            ar=new ArrayList<>();
            
            while(rs.next())
            {
                Stocking st=new Stocking();
                st.setMname(rs.getString(1));
                st.setCompany_name(rs.getString(2));
                st.setCost(rs.getDouble(3));
                st.setMrp(rs.getDouble(4));
                st.setDeadline(rs.getInt(5));
                st.setBox(rs.getInt(6));
                st.setPkg(rs.getInt(7));
                st.setTotalquantity(rs.getInt(8));
                st.setDate(rs.getString(9));
                st.setType(rs.getString(10));
                
                ar.add(st);
            }
            rs.close();
            cn.close();
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            
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
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
       return ar;
    }
    // Code to fetch the data from medicine table of chemist database on the basis of given
    // String data
    public static HashMap<String,Double> getMedicine(String name)
    {
        HashMap<String,Double> m=null;
        Connection cn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try
        {
            cn=getConnection();
            
            String sql="select mname,mrp from medicine where mname LIKE '"+name+"%'order by mname";
            ps=cn.prepareStatement(sql);
            rs=ps.executeQuery();
            m=new HashMap<>();
            
            while(rs.next())
            {
                m.put(rs.getString(1), rs.getDouble(2));
            }
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       return m;
    }

    public static ArrayList<User> fetchallUser() 
    {
        ArrayList<User> m=null;
        Connection cn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try
        {
            cn=getConnection();
            String sql="select username,password from user";
            ps=cn.prepareStatement(sql);
            rs=ps.executeQuery();
            m=new ArrayList<>();
            while(rs.next())
            {
                User user=new User();
                user.setUsername(rs.getString(1));
                user.setPassword(rs.getString(2));
                
                m.add(user);
            }
         rs.close();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return m;
    }

    public static ArrayList<SuppliersDetails> fetchSuppliers()
    {
        ArrayList<SuppliersDetails> m=null;
        Connection cn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try
        {
            cn=getConnection();
            String sql="select name,mobileNo from suppliers";
            ps=cn.prepareStatement(sql);
            rs=ps.executeQuery();
            m=new ArrayList<>();
            while(rs.next())
            {
                SuppliersDetails s1=new SuppliersDetails();
                s1.setName(rs.getString(1));
                s1.setMobile(rs.getString(2));
                m.add(s1);
            }
            rs.close();
            
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return m;
    }

    
    
    
   
    
}       
   
    
