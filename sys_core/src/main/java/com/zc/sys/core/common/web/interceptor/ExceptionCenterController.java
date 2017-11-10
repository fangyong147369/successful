package com.zc.sys.core.common.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.zc.sys.common.exception.BussinessException;
import com.zc.sys.common.form.Result;
import com.zc.sys.common.util.WebUtils;

/**
 * 异常中心控制器
 */
@Controller
public class ExceptionCenterController implements HandlerExceptionResolver{
    
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception ex) {
    	if (ex instanceof BussinessException) {
    		WebUtils.responseJson(response, Result.error(ex.getMessage()));
    	}
		return null;
    }
    
}
