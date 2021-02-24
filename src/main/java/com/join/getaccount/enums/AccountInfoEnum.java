package com.join.getaccount.enums;

public enum AccountInfoEnum {
    IP_ADDRESS("IP Address"),
    PASSWORD("Password"),
    METHOD("Method"),
    PORT("Port");

    private String addr;

    AccountInfoEnum(String addr) {
        this.addr = addr;
    }
    public String getAddr(){
        return addr;
    }
}
