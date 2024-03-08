package com.ilzf.extend.inject;

import com.ilzf.extend.entity.ExtendEntity;
import com.ilzf.extend.service.ExtendServiceAdapter;
import org.springframework.stereotype.Component;

@Component
public class ExtendServiceAdapterImpl implements ExtendServiceAdapter {
    @Override
    public <T extends ExtendEntity> Object adapterGet(T entity) {
        ExtendEntity extend = new ExtendEntity();
        extend.setName("代理姓名");
        extend.setPassword("代理秘密");
        return extend;
    }

    @Override
    public Boolean adapterSave() {
        return null;
    }

    @Override
    public Boolean adapterUpdate() {
        return null;
    }

    @Override
    public Boolean adapterList() {
        return null;
    }
}
