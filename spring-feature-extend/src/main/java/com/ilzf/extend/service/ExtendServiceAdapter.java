package com.ilzf.extend.service;

import com.ilzf.extend.entity.ExtendEntity;

/**
 * 转为该业务而生，所以不用泛型
 */
public interface ExtendServiceAdapter {
    public <T extends ExtendEntity> Object adapterGet(T entity);

    public Boolean adapterSave();

    public Boolean adapterUpdate();

    public Boolean adapterList();
}
