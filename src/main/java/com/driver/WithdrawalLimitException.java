package com.driver;

public class WithdrawalLimitException extends Exception{
    WithdrawalLimitException(){
        System.out.println("Maximum Withdraw Limit Exceed");
    }
}
