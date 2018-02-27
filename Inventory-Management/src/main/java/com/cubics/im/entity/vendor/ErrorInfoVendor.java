package com.cubics.im.entity.vendor;

public class ErrorInfoVendor {

	private String errCode;
	private String errDesc;

	public ErrorInfoVendor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorInfoVendor(String errCode, String errDesc) {
		super();
		this.errCode = errCode;
		this.errDesc = errDesc;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrDesc() {
		return errDesc;
	}

	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}

	@Override
	public String toString() {
		return "ErrorInfoVendor [errCode=" + errCode + ", errDesc=" + errDesc + "]";
	}

}
