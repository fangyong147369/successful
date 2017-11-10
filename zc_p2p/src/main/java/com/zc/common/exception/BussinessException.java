package com.zc.common.exception;
/**
 * 异常处理
 * 
 * @author zp
 * @version 0.0.1
 * @since 2017年6月28日
 */
public class BussinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public static final int TYPE_JSON = 1;
	public static final int TYPE_CLOSE = 2;
	protected String url;
	protected int type;
	protected String buttonName;

	public BussinessException(String msg, RuntimeException ex) {
		super(msg, ex);
	}

	public BussinessException() {
		super();
	}

	public BussinessException(String message) {
		super(message);
	}

	public BussinessException(String message, String url) {
		super(message);
		this.url = url;
	}

	public BussinessException(String message, String url,String buttonName) {
		super(message);
		this.url = url;
		this.buttonName = buttonName;
	}
	
	public BussinessException(String message, int type) {
		super(message);
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public String getButtonName() {
		return buttonName;
	}

	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
