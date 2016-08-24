package com.mars;

import com.google.protobuf.InvalidProtocolBufferException;
import netty.SubscribeReqProto;

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
        List<String> address = new ArrayList<String>();
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
        System.out.println("Assert equal : --> " + req2.equals(req));
    }
}
