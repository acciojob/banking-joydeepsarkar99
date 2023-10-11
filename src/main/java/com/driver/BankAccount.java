package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if(digits * 9 < sum){
            throw new AccountNumberException("Account Number can not be generated");
        }
        StringBuilder accNo = new StringBuilder();
        int quo = sum / 9;
        int rem = sum % 9;

        while(quo--> 0){
            accNo.append("9");
        }
        if(rem > 0){
            accNo.append(rem);
        }
        if(digits - accNo.length() != 0){
            int times = digits - accNo.length();
            while(times--> 0){
                accNo.append("0");
            }
        }
        return accNo.toString();
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(balance - amount < minBalance){
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        else {
            balance -= amount;
        }
    }

}