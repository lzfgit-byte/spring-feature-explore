package com.ilzf.extend.service;

import com.ilzf.extend.entity.ExtendEntity;
import com.ilzf.util.ApplicationContextHolder;
import com.ilzf.util.LogUtil;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ExtendService {
    /**
     * 模拟数据库查询一个
     */
    public <T extends ExtendEntity> Object getOne(T extend) {
        ApplicationContext context = ApplicationContextHolder.getContext();
        ExtendServiceAdapter bean = null;
        try {
            bean = context.getBean(ExtendServiceAdapter.class);
        } catch (NoSuchBeanDefinitionException e) {
            LogUtil.log("未有实现类");
        }
        if (bean != null) {
            LogUtil.log("存储被代理");
            return bean.adapterGet(extend);
        }
        LogUtil.log("平台数据存储");
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
