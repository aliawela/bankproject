package bankproject;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Transaction implements Serializable {
    /*--------------------------DataField--------------------------*/
    private TransactionType type;
    private Double amount;
    private Integer transactionNumber;
    private static Integer transactionCount = 1;
    private String beneAccNum;
    private LocalDate date;
    /*--------------------------Constructor-------------------------*/
    public Transaction(TransactionType type, Double amount, String beneAccNum) {
        this.type = type;
        this.amount = amount;
        this.transactionNumber = transactionCount++;
        this.beneAccNum = beneAccNum;
        this.date = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
    }
    public Transaction(TransactionType type, Double amount) {
        this.type = type;
        this.amount = amount;
        this.transactionNumber = transactionCount++;
        this.date = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
    }

    public Transaction(TransactionType type, Double amount, LocalDate date, String beneAccNum) {
        this.type = type;
        this.amount = amount;
        this.beneAccNum = beneAccNum;
        this.date = date;
        this.transactionNumber = transactionCount++;
    }

    /*--------------------------Methods-------------------------*/
    public TransactionType getType() {
        return type;
    }
    public void setType(TransactionType type) {
        this.type = type;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public Integer getTransactionNumber() {
        return transactionNumber;
    }
    public void setTransactionNumber(Integer transactionNumber) {
        this.transactionNumber = transactionNumber;
    }
    public static Integer getTransactionCount() {
        return transactionCount;
    }
    public static void setTransactionCount(Integer transactionCount) {
        Transaction.transactionCount = transactionCount;
    }
    public String getBeneAccNum() {
        return beneAccNum;
    }
    public void setBeneAccNum(String beneAccNum) {
        this.beneAccNum = beneAccNum;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "--------------------Transaction--------------------\n" + "-Type : " + this.type
                + "\n-Amount : " + this.amount + "\n-Transaction number : " + this.transactionNumber
                +"\n-Account Number : " + this.beneAccNum + "\nDate : " + date.toString() +"\n";
    }
}
