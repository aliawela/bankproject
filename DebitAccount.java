package bankproject;

import java.io.Serializable;
import java.util.Objects;

public class DebitAccount extends Account implements Serializable {
    /*--------------------------DataField--------------------------*/
    private String countryCode;
    private String debitCardNum;
    private Integer secretCode;
    private String type;
    private Double monthlyPayLim;
    /*--------------------------Constructor--------------------------*/
    public DebitAccount(Client client, Double balance, Double maxWithdrawAmt, String countryCode, String debitCardNum, Integer secretCode, String type, Double monthlyPayLim) {
        super(client, balance, maxWithdrawAmt);
        this.countryCode = countryCode;
        this.debitCardNum = debitCardNum;
        this.secretCode = secretCode;
        this.type = type;
        this.monthlyPayLim = monthlyPayLim;
        BankSystem.accounts.add(this);
    }
    /*--------------------------Methods--------------------------*/
    public String getDebitCardNum() {
        return debitCardNum;
    }
    public void setDebitCardNum(String debitCardNum) {
        this.debitCardNum = debitCardNum;
    }
    public Integer getSecretCode() {
        return secretCode;
    }
    public void setSecretCode(Integer secretCode) {
        this.secretCode = secretCode;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Double getMonthlyPayLim() {
        return monthlyPayLim;
    }
    public void setMonthlyPayLim(Double monthlyPayLim) {
        this.monthlyPayLim = monthlyPayLim;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    @Override
    public void Pay(Double amount, Integer code, String cardNumber, Account benificialAccount, String originCountryCode) {
        if(this.getBalance() > amount && this.monthlyPayLim > amount) {
            if (Objects.equals(this.debitCardNum, cardNumber) && Objects.equals(this.secretCode, code) && this.countryCode.equals(originCountryCode)) {
                System.out.println("Payment successful");
                this.setBalance(this.getBalance() - amount);
                benificialAccount.setBalance(benificialAccount.getBalance() + amount);
                Transaction pay = new Transaction(TransactionType.PAY,amount,benificialAccount.getAccountNb());
                this.transactionList.add(pay);
            }
        }
        else {
            System.out.println("Ain't happening on my watch!!");
        }
    }
    @Override
    public String toString() {
        return "DebitAccount{" +
                "countryCode='" + countryCode + '\'' +
                ", debitCardNum='" + debitCardNum + '\'' +
                ", secretCode=" + secretCode +
                ", type='" + type + '\'' +
                ", monthlyPayLim=" + monthlyPayLim +
                '}';
    }
}
