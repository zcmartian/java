package com.mars.union;

public interface UF {
    boolean isConnected(int p, int q);
    void unionElement(int p, int q);
    int getSize();
}
