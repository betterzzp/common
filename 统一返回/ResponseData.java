package cn.zhouzhongping.skill.common;

import lombok.Data;

@Data
public class ResponseData<T> {
	private int code;
	private String message;
	private T data;
	
	private ResponseData(T data) {
		this.code = 200;
		this.message = "success";
		this.data = data;
	}
	private ResponseData(CodeMsg cm) {
		this.code = cm.getCode();
		this.message = cm.getMessage();
	}
	
	public static<T> ResponseData <T> success(T data){
		return new ResponseData<T>(data);
	}
	public static<T> ResponseData <T> error(CodeMsg cm){
		return new ResponseData<T>(cm);
	}
	
}
