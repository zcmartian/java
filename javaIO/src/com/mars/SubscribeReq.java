package com.mars;

import java.io.Serializable;

/**
 * Created by marszhou on 16/8/24.
 */
public class SubscribeReq implements Serializable {
    private static final long serialVersionUID = -5123207808913796908L;

    private int subReqID;
    private String userName;
    private String productName;
    private String phoneName;
    private String address;

    @Override
    public String toString() {
        return "com.mars.SubscribeReq{" + "subReqID=" + subReqID + ", userName='" + userName + '\'' + ", productName='"
                + productName + '\'' + ", phoneName='" + phoneName + '\'' + ", address='" + address + '\'' + '}';
    }

    public int getSubReqID() {
        return subReqID;
    }

    public void setSubReqID(int subReqID) {
        this.subReqID = subReqID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
