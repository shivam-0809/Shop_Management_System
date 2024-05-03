package com.qsp.shop.model;

public class Product {
	private int p_id;
	private String p_name;
	private int p_price;
	private int p_qauntity;
	private boolean p_availability;
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public int getP_qauntity() {
		return p_qauntity;
	}
	public void setP_qauntity(int p_qauntity) {
		this.p_qauntity = p_qauntity;
	}
	
	public void setP_availability(boolean i_p_availability) {
		this.p_availability = i_p_availability;
	}
	public boolean isP_availability() {
		return false;
	}
	public boolean next() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
