package xyz.hcworld.hcwblog.commont.lang;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: Result
 * @Author: 张红尘
 * @Date: 2020/9/7 11:07
 * @Version： 1.0
 */
@Data
public class Result implements Serializable {
    /**
     * 0成功，-1失败
     */
    private int status;
    /**
     * 消息
     */
    private String msg;
    /**
     * 数据域
     */
    private Object data;
    /**
     * 跳转链接
     */
    private String action;

    /**
     * 成功（默认msg+无data）
     * @return
     */
    public static Result success() {
        return Result.success("操作成功", null);
    }
    /**
     * 成功（默认msg+自定义data）
     * @param data 数据域
     * @return
     */
    public static Result success(Object data) {
        return Result.success("操作成功", data);
    }

    /**
     * 成功（自定义msg+自定义data）
     * @param msg 消息
     * @param data 数据域
     * @return
     */
    public static Result success(String msg, Object data) {
        Result result = new Result();
        result.status = 0;
        result.msg = msg;
        result.data = data;
        return result;
    }

    /**
     * 失败
     * @param msg 消息
     * @return
     */
    public static Result fail(String msg) {
        Result result = new Result();
        result.status = -1;
        result.msg = msg;
        result.data = null;
        return result;
    }


    public Result action(String action){
        this.action=action;
        return this;
    }

}
