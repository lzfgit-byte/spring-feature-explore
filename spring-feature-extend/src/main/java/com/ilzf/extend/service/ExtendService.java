package com.ilzf.extend.service;

import com.ilzf.extend.entity.ExtendEntity;
import com.ilzf.util.ApplicationContextHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ExtendService {
    /**
     * 模拟数据库查询一个
     */
    public Object getOne(ExtendEntity extend) {
        ApplicationContext context = ApplicationContextHolder.getContext();
        ExtendServiceAdapter bean = context.getBean(ExtendServiceAdapter.class);
        return null;
    }

    /**
     * 模拟数据库存储
     */
    public boolean saveOne() {
        return true;
    }

    /**
     * 模拟数据库更新
     */
    public boolean updateOne() {
        return true;
    }

    /**
     * 模拟数据库遍历
     */
    public Object list() {
        return null;
    }

}
