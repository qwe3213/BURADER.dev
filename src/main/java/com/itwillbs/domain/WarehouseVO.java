package com.itwillbs.domain;

public class WarehouseVO {

	// warehouse
	private String whs_id;
	private String whs_type;
	private String whs_tel;
	private String shelt_position;
	private String whs_emp;
	private int whs_status;
	private String whspr_id;
	
	// employee
	private String emp_name;
	// get & set

	
		
	
	

	public String getWhs_id() {
		return whs_id;
	}






	public String getWhs_type() {
		return whs_type;
	}






	public String getWhs_tel() {
		return whs_tel;
	}






	public String getShelt_position() {
		return shelt_position;
	}






	public String getWhs_emp() {
		return whs_emp;
	}






	public int getWhs_status() {
		return whs_status;
	}






	public String getWhspr_id() {
		return whspr_id;
	}






	public String getEmp_name() {
		return emp_name;
	}






	public void setWhs_id(String whs_id) {
		this.whs_id = whs_id;
	}






	public void setWhs_type(String whs_type) {
		this.whs_type = whs_type;
	}






	public void setWhs_tel(String whs_tel) {
		this.whs_tel = whs_tel;
	}






	public void setShelt_position(String shelt_position) {
		this.shelt_position = shelt_position;
	}






	public void setWhs_emp(String whs_emp) {
		this.whs_emp = whs_emp;
	}






	public void setWhs_status(int whs_status) {
		this.whs_status = whs_status;
	}






	public void setWhspr_id(String whspr_id) {
		this.whspr_id = whspr_id;
	}






	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	
	
	@Override
	public String toString() {
		return "WarehouseVO [whs_id=" + whs_id + ", whs_type=" + whs_type + ", whs_tel=" + whs_tel + ", shelt_position="
				+ shelt_position + ", whs_emp=" + whs_emp + ", whs_status=" + whs_status + ", whspr_id=" + whspr_id
				+ ", emp_name=" + emp_name + "]";
	}






	
}
