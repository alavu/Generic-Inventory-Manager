package chemicalinventorymanager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 *
 */
public class Transaction {
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    private String customerID, id;
    public Date date;
    public transactionMode mode;
    public Map<String, Integer> transactions;
    public Double creditAmount;
    
    //TODO: Add total money gotten
    
    public String getID() {return id;}
    public String getCustomerID() {return customerID;}
    public String getDate() {return df.format(date);}
    
    public String getMode() {
        if (mode == transactionMode.debit) return "debit";
        return "credit";
    }
    
    public Map<String, Integer> getTransactions() {return transactions;    }
    public Double getCreditAmount() {return creditAmount;}
    
    public Transaction(String id, String cid){
        this.id = id;
        customerID = cid;
    }
    
    
    public enum transactionMode{
        debit,
        credit
    }
    
    @Override
    public String toString(){
        return "Transaction Date: "+ date + "\tCustomer ID: " + customerID;
    }
    
    @Override
    public boolean equals(Object o) {
 
        if (o == this) {
            return true;
        }
 
        if (!(o instanceof Transaction)) {
            return false;
        }
         
        Transaction c = (Transaction) o;
         
        return id.equals(c.id);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
}
