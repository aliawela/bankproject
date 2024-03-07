package bankproject;

import java.io.Serializable;

public class Client implements Serializable {
    /*--------------------------DataField--------------------------*/
    private String name;
    private Integer ssn;
    private String phoneNb;
    private String address;
    /*--------------------------Constructor--------------------------*/
    public Client(String name, Integer ssn, String phoneNb, String address) {
        this.name = name;
        this.ssn = ssn;
        this.phoneNb = phoneNb;
        this.address = address;
        BankSystem.clients.add(this);
    }
    /*--------------------------Methods--------------------------*/
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getSsn() {
        return ssn;
    }
    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }
    public String getPhoneNb() {
        return phoneNb;
    }
    public void setPhoneNb(String phoneNb) {
        this.phoneNb = phoneNb;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Client:\n" + "-name : " + this.name + "\n-SSN : " + this.ssn + "\n-Phone Number : " + this.phoneNb + "\n-Address : " + this.address ;
    }

}
