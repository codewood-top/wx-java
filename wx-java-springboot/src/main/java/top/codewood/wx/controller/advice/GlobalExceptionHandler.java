package top.codewood.wx.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.codewood.wx.pay.v3.bean.error.WxPayError;
import top.codewood.wx.pay.v3.bean.error.WxPayErrorException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(WxPayErrorException.class)
    public WxPayError wxPayErrorException(WxPayErrorException exception) {
        return exception.getError();
    }

    @ExceptionHandler(RuntimeException.class)
    public Map<String, Object> runtimeException(RuntimeException exception) {
        String message = exception.getMessage();

        Map<String, Object> map = new HashMap<>();
        map.put("code", 500);
        map.put("message", message);
        return map;
    }

}
