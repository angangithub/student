package com.zto.onecard.common.utils;


import lombok.Data;

import java.io.Serializable;


/**
 * 结果
 * @author run
 * @date 2022/08/04
 */
@Data
public class Result implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 返回代码 0成功 500失败
	 */
	private Integer code = 200;

	/**
	 * 返回数据对象 data
	 */
	private Object data;

	/**
	 * 返回处理消息
	 */
	private String message = "操作成功!";
	
	/**
	 * 时间戳
	 */
	private long timestamp = System.currentTimeMillis();

	public Result() {
		
	}
	
	public Result success(String message) {
		this.message = message;
		return this;
	}

	public static Result ok() {
		return new Result();
	}

	public static Result ok(Object data) {
		Result r = new Result();
		r.setCode(200);
		r.setData(data);
		return r;
	}

	public static Result ok(String msg, Object data) {
		Result r = new Result();
		r.setCode(200);
		r.setData(data);
		r.setMessage(msg);
		return r;
	}
	
	public static Result error(String msg) {
		String message = msg == null ? "服务器错误" : msg;
		return error(500, message);
	}
	
	public static Result error(int code, String msg) {
		Result r = new Result();
		r.setCode(code);
		r.setMessage(msg);
		return r;
	}

	/**
	 * 无权限访问返回结果
	 */
	public static Result noauth(String msg) {
		return error(401, msg);
	}

}