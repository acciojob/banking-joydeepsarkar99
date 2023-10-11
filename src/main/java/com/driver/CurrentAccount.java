package com.driver;

import java.util.HashMap;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId = tradeLicenseId;
        if(balance < 5000){
            throw new InsufficientBalanceException("Insufficient Balance");
        }
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
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
            String newGeneratedTradeLicenseId = "";
            newGeneratedTradeLicenseId = rearrangeString(tradeLicenseId);
            if(newGeneratedTradeLicenseId == ""){
                throw new ValidLicenseException("Valid License can not be generated");
            }
            else{
                this.tradeLicenseId = newGeneratedTradeLicenseId;
            }
        }

    }

    public String rearrangeString(String tradeLicenseId){
        int len = tradeLicenseId.length();
        int[] freq = new int[26];

        int maxFreq = -1;
        char maxFreqChar = '#';

        for(int i=0;i<len;i++){
            char ch = tradeLicenseId.charAt(i);
            freq[ch - 'A']++;

            if(freq[ch - 'A'] > maxFreq){
                maxFreq = freq[ch - 'A'];
                maxFreqChar = ch;
            }
        }

        //checking if the max frequency char is greater than the allowed frequency
        int allowedFreq = len % 2 == 0 ? len/2 : len/2 + 1;
        if(maxFreq > allowedFreq){
            return "";
        }

        //placing the max freq char in the even position first
        char[] result = new char[len];
        int index = 0;
        while(freq[maxFreqChar - 'A'] > 0){
            result[index] = maxFreqChar;
            index += 2;
            freq[maxFreqChar - 'A']--;
        }

        //then iterating over the remaining char and placing them respectively
        for(int i=0;i<26;i++){
            int times = freq[i];
            while(times-- > 0) {
                if (index >= len) {
                    index = 1;
                }
                result[index] = (char)(i + 'A');
                index += 2;
            }
        }
        return result.toString();

    }

}
