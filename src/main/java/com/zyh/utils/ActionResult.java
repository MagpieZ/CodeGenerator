package com.zyh.utils;

import com.zyh.enumerate.ReturnCodeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ActionResult<T> {

    private Integer code;
    private String massage;
    private T data;
    private long timestamp;

    private ActionResult() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ActionResult<T> success() {
        return custom(ReturnCodeEnum.RC200.getCode(), ReturnCodeEnum.RC200.getMessage(), null);
    }
    public static <T> ActionResult<T> success(String message) {
        return custom(ReturnCodeEnum.RC200.getCode(), ReturnCodeEnum.RC200.getMessage(), null);
    }
    public static <T> ActionResult<T> success(T data) {
        return custom(ReturnCodeEnum.RC200.getCode(), ReturnCodeEnum.RC200.getMessage(), data);
    }

    public static <T> ActionResult<T> fail(Integer code, String massage) {
        return custom(code, massage, null);
    }

    public static <T> ActionResult<T> fail() {
        return custom(ReturnCodeEnum.RC999.getCode(), ReturnCodeEnum.RC999.getMessage(), null);
    }

    public static <T> ActionResult<T> fail(String massage) {
        return custom(9999, massage, null);
    }


    public static <T> ActionResult<T> custom(Integer code, String massage, T data) {
        ActionResult<T> result = new ActionResult<>();
        result.setCode(code);
        result.setMassage(massage);
        result.setData(data);
        return result;
    }
}
