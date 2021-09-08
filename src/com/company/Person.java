package com.company;

abstract public class Person {
    static  protected String name;
    static protected String password;
    static protected String contactInformation;

    public Person(String name, String password, String contactInformation) {
        this.name = name;
        this.password = password;
        this.contactInformation = contactInformation;
    }

    static public String getName() {
        return name;
    }

     public void setName(String name) {
        this.name = name;
    }

    static public String getPassword() {
        return password;
    }

     public void setPassword(String password) {
        this.password = password;
    }

    static public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }
}
