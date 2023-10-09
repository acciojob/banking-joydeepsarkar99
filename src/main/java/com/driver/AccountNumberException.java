package com.driver;

public class AccountNumberException extends Exception{
    AccountNumberException(){
        System.out.println("Account Number can not be generated");
    }
}
