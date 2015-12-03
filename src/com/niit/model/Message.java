package com.niit.model;

public class Message {
	public int res;
	public String msg;
	public String data;
	
	

	public Message(int res, String msg, String data) {
		super();
		this.res = res;
		this.msg = msg;
		this.data = data;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
