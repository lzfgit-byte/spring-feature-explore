package com.ilzf.extend.service;

/**
 * 转为该业务而生，所以不用泛型
 */
public interface ExtendServiceAdapter {
    public Object adapterGet();

    public Boolean adapterSave();

    public Boolean adapterUpdate();

    public Boolean adapterList();
}
