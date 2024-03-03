package com.ilzf.aspect.aspect;

import com.ilzf.util.LogUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Object handException(HttpServletRequest request, Exception e) throws Exception {
        LogUtil.log("报错了");
        Map<String, Object> map = new HashMap<>();
        map.put("msg", e.getMessage());
        return map;
    }

}
