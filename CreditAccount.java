package bankproject;

import java.io.Serializable;
import java.util.Objects;

public class CreditAccount extends Account implements Serializable {
    /*--------------------------DataField--------------------------*/
    private String ccNum;
    private String type;
    private Integer secretCode;
    private Double monthlyPayLim;
    private Double minPayback;
    /*--------------------------Constructor--------------------------*/
    public CreditAccount(Client client, Double balance, Double maxWithdrawAmt, String ccNum, String type, Integer secretCode, Double monthlyPayLim, Double minPayback) {
        super(client, balance, maxWithdrawAmt);
        this.ccNum = ccNum;
        this.type = type;
        this.secretCode = secretCode;
        this.monthlyPayLim = monthlyPayLim;
        this.minPayback = minPayback;
        BankSystem.accounts.add(this);
    }
    /*--------------------------methods--------------------------*/

    public String getCcNum() {
        return ccNum;
    }
    public void setCcNum(String ccNum) {
        this.ccNum = ccNum;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Integer getSecretCode() {
        return secretCode;
    }
    public void setSecretCode(Integer secretCode) {
        this.secretCode = secretCode;
    }
    public Double getMonthlyPayLim() {
        return monthlyPayLim;
    }
    public void setMonthlyPayLim(Double monthlyPayLim) {
        this.monthlyPayLim = monthlyPayLim;
    }
    public Double getMinPayback() {
        return minPayback;
    }
    public void setMinPayback(Double minPayback) {
        this.minPayback = minPayback;
    }
    @Override
    public void Pay(Double amount, Integer code, String cardNumber, Account benificialAccount, String originCountryCode) {
        if(this.getBalance() > amount && this.monthlyPayLim > amount){
            if(Objects.equals(this.ccNum, cardNumber) && Objects.equals(this.secretCode, code) /*&& useless ((DebitAccount)benificialAccount).getCountryCode().equals(originCountryCode)*/){
                System.out.println("Payment successful");
                this.setBalance(this.getBalance() - amount);
                benificialAccount.setBalance(benificialAccount.getBalance() + amount);
                Transaction pay = new Transaction(TransactionType.PAY,amount,benificialAccount.getAccountNb());
                this.transactionList.add(pay);
            }
        }
        else{
            System.out.println("Ain't happening on my watch!!");
        }


    }
    @Override
    public String toString() {
        return "CreditAccount{" +
                "ccNum='" + ccNum + '\'' +
                ", type='" + type + '\'' +
                ", secretCode=" + secretCode +
                ", monthlyPayLim=" + monthlyPayLim +
                ", minPayback=" + minPayback +
                '}';
    }
}
//wael ibrahim is one of the best computer sce

