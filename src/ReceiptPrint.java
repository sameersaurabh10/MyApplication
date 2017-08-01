
public class ReceiptPrint {
 
    private int receipt_no;
    private String mname,total_amount,str_quantity, date, customer_name,type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    private double amount;

    public int getReceipt_no() {
        return receipt_no;
    }

    public void setReceipt_no(int receipt_no) {
        this.receipt_no = receipt_no;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getStr_quantity() {
        return str_quantity;
    }

    public void setStr_quantity(String str_quantity) {
        this.str_quantity = str_quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
