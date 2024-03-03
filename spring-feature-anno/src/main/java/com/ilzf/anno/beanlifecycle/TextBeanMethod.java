package com.ilzf.anno.beanlifecycle;

import com.ilzf.util.LogUtil;

public class TextBeanMethod {
    public String type;

    TextBeanMethod(String type) {
        this.type = type;
    }

    public void initMethod() {
        LogUtil.log("TextBeanMethod 创建了使用 @bean", this.type);
    }

    public void destroyMethod() {
        LogUtil.log("TextBeanMethod 销毁了使用 @bean", this.type);
    }
}
