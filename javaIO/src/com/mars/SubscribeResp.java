package com.mars;

import java.io.Serializable;

/**
 * Created by marszhou on 16/8/24.
 */
public class SubscribeResp implements Serializable {
    private static final long serialVersionUID = -1037466795156963091L;
    private int subReqID;
    private int respCode;
    private String desc;

    @Override
    public String toString() {
        return "com.mars.SubscribeResp{" + "subReqID=" + subReqID + ", respCode=" + respCode + ", desc='" + desc + '\'' + '}';
    }

    public int getSubReqID() {
        return subReqID;
    }

    public void setSubReqID(int subReqID) {
        this.subReqID = subReqID;
    }

    public int getRespCode() {
        return respCode;
    }

    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
