package com.driver;

public class InsufficientBalanceException extends Exception{
    InsufficientBalanceException(){
        System.out.println("Insufficient Balance");
    }
}
