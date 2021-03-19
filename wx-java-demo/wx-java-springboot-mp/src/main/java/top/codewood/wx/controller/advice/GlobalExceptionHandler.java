package top.codewood.wx.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public Map<String, Object> runtimeException(RuntimeException exception) {
        String message = exception.getMessage();

        Map<String, Object> map = new HashMap<>();
        map.put("code", 500);
        map.put("message", message);
        return map;
    }

}
