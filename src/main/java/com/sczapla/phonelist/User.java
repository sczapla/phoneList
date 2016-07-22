/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sczapla.phonelist;

public class User {
    private String name;
    private String phone;

    public User(String line) {
        String[] splitLine = line.split(",");
        this.name = splitLine[0];
        this.phone = splitLine[1];
    }

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
