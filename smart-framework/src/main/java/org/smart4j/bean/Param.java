package org.smart4j.bean;

import org.smart4j.util.CastUtil;

import java.util.Map;

/**
 * Created by marszhou on 15/12/20.
 */
public class Param {
    private Map<String, Object> paramMap;
    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }
    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }
    public Map<String, Object> getMap() {
        return paramMap;
    }
}
