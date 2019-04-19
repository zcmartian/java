package com.mars.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marszhou on 16/8/24.
 */
public class TestSubscribeReqProto {
    private static byte[] encode(SubscribeReqProto.SubscribeReq req) {
        return req.toByteArray();
    }

    private static SubscribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException {
        return SubscribeReqProto.SubscribeReq.parseFrom(body);
    }

    private static SubscribeReqProto.SubscribeReq createSubscribeReq() throws InvalidProtocolBufferException {
        SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
        builder.setSubReqID(1);
        builder.setUserName("marszhou");
        builder.setProductName("Netty book");
        List<String> address = new ArrayList<>();
        address.add("Shanghai 安化路");
        address.add("Shanghai 长岛路");
        address.add("Shanghai 纳贤路");
        builder.addAllAddress(address);
        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SubscribeReqProto.SubscribeReq req = createSubscribeReq();
        System.out.println("Before encode : " + req.toString());
        SubscribeReqProto.SubscribeReq req2 = decode(encode(req));
        System.out.println("After decode : " + req2.toString());
        System.out.println("After decode subReqID : " + req2.getSubReqID());
        System.out.println("After decode userName : " + req2.getUserName());
        System.out.println("After decode productName : " + req2.getProductName());
        for (String address : req2.getAddressList()) {
            System.out.println("After decode address : " + address);
        }
        System.out.println("Assert equal : --> " + req2.equals(req));
    }
}
