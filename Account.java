package bankproject;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

//this is an abstract class since it makes no sense for a client to have just an "account",it must be more specific in type!!!
public abstract class Account implements Serializable {
    /*--------------------------DataField--------------------------*/
    private Client client;
    private Double balance;
    private String accountNb;
    private Double maxWithdrawAmt;
    private static Integer accountCounter = 0;
    public ArrayList<Transaction> transactionList;
    /*--------------------------Constructor--------------------------*/
    public Account(Client client, Double balance,Double maxWithdrawAmt) {
        this.client = client;
        this.balance = balance;
        this.accountNb = String.valueOf(++accountCounter);
        this.maxWithdrawAmt = maxWithdrawAmt;
        this.transactionList = new ArrayList<Transaction>();
    }
    /*--------------------------Methods--------------------------*/
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public String getAccountNb() {
        return accountNb;
    }
    public void setAccountNb(String accountNb) {
        this.accountNb = accountNb;
    }
    public Double getMaxWithdrawAmt() {
        return maxWithdrawAmt;
    }
    public void setMaxWithdrawAmt(Double maxWithdrawAmt) {
        this.maxWithdrawAmt = maxWithdrawAmt;
    }
    public ArrayList<Transaction> getTransactionList() {
        return transactionList;
    }
    public void setTransactionList(ArrayList<Transaction> transactionList) {
        this.transactionList = transactionList;
    }



    public void Deposit(Double amount){
        if(amount>0){
            this.balance += amount;
            Transaction dep = new Transaction(TransactionType.DEPOSIT,amount,this.accountNb);
            transactionList.add(dep);
        }
        else{
            //trying to transaction negative amount to steal it? ain't happening while I am here!!!
            System.out.println("Are you trying to steal??");
        }
    }
    public void Withdraw(Double amount){
        if(amount > 0 && amount < this.balance && amount < this.maxWithdrawAmt){
            this.balance -= amount;
            System.out.println("successfully withdrawn " + amount +"$ from your account");
            Transaction withdraw = new Transaction(TransactionType.WITHDRAW,amount,this.getAccountNb());
            transactionList.add(withdraw);
        }
        else{
            System.out.println("Are you trying to scam the bank?");
        }
    }
    public void Transfer(Account a,Double amount){
        Double fee = 16.0;
        if(amount>150){
            fee+= amount*0.005;
        }

        if(amount > 0 && amount+fee < this.balance && amount < this.maxWithdrawAmt){
            a.balance += amount;
            this.balance -= (amount + fee);
            System.out.println("Successfully transferred " + amount);
            Transaction transf = new Transaction(TransactionType.TRANSFER,amount,a.getAccountNb());
            transactionList.add(transf);
        }
        else{
            //trying to transaction negative amount to steal it? ain't happening while I am here!!!
            System.out.println("Are you trying to steal??");
        }
    }
    public abstract void Pay(Double amount,Integer code,String CardNumber,Account benificialAccount,String originCountryCode);
    public void displayTransDates(LocalDate d1, LocalDate d2){
        BankSystem.transactions.clear();
        if(d1.compareTo(d2) > 0){
            System.out.println("test");
            LocalDate temp = d1;
            d1 = d2;
            d2 = temp;
        }
        for (Transaction transaction : transactionList) {
            LocalDate date = transaction.getDate();
            if (date.compareTo(d1) < 0) {
                continue;
            }
            if (date.compareTo(d2) > 0) {
                break;
            }
            BankSystem.transactions.add(transaction);
        }
    }

    }

