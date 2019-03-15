package main.java.company.model;

public class CreditInformation {
    private User user;
    private String creditId;
    private String bankName;
    private double money;

    public CreditInformation(User user, String creditId, String bankName, double money) {
        this.user = user;
        this.creditId = creditId;
        this.bankName = bankName;
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}

