package com.example.demo.config;


import com.example.demo.common.ResultAjax;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一返回值的保底实现类
 */
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 返回是  true 的时候才会调用 beforeBodyWrite 方法
     *
     * @param returnType
     * @param converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }



    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        if(body instanceof ResultAjax) {//instanceof 是用来判断类型的
            return body;//已经包装好的对象
        }

        //对字符串进行判断和处理
        if(body instanceof String) {
            ResultAjax resultAjax = ResultAjax.success(body);
            try {
                return objectMapper.writeValueAsString(resultAjax);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return ResultAjax.success(body);  //如果返回的是一个String对象会报错
    }
}
