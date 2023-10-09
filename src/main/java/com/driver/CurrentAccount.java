package com.driver;

import java.util.HashMap;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId = tradeLicenseId;
        if(balance < 5000){
            throw new InsufficientBalanceException();
        }

    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        boolean isValid = true;
        for(int i=0;i<tradeLicenseId.length()-1;i++){
            if(tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i+1)){
                isValid = false;
            }
        }
        if(!isValid){
            HashMap<Character,Integer> map = new HashMap<>();
            for(char c : tradeLicenseId.toCharArray()){
                map.put(c,map.getOrDefault(c,0)+1);
            }
            int len = tradeLicenseId.length() % 2 == 0 ? tradeLicenseId.length() / 2 : (tradeLicenseId.length() / 2) + 1;
            for(int freq : map.values()){
                if(freq > len){
                    throw new ValidLicenseException();
                }
            }
        }

    }

}
