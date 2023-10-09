package com.driver;

public class ValidLicenseException extends Exception{
    ValidLicenseException(){
        System.out.println("Valid License can not be generated");
    }
}
