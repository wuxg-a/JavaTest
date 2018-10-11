package com.wxg.serialize;

import java.io.Serializable;

/**
 * Created by wuxg-a on 2018/10/11.
 */
public class SerializeObject implements Serializable{

    private String name;

    private transient String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SerializeObject(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getAddress() {
        return address;

    }

    public void setAddress(String address) {
        this.address = address;
    }
}
