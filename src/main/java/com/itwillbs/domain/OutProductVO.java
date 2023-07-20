package com.itwillbs.domain;
import java.sql.Date;



public class OutProductVO {
	
	// out_product
    private String op_id;
    private String product_id;
    private String cont_id;
    private String op_process;
    private Date op_date;
    private int op_emp;
    private int tmp_qty;
    
    // product
    private String product_name;
    private String product_qty;
    
    // contract
    private Date due_date;
    private int cont_qty;
    private String cust_name;
    private String production_id;
    
    // employee
    private String emp_name;
    
    // pr_material
    private float use_qty;
    
    // material
    private String ma_id;
    private String ma_name;
    private int ma_qty;
    
    // 기간 조회 변수
    private String startDate;
    private String endDate;
    
    
    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ getter & setter ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	
    
    // out_product
	public String getCont_id() {
		return cont_id;
	}
	public void setCont_id(String cont_id) {
		this.cont_id = cont_id;
	}
    public String getOp_id() {
		return op_id;
	}
	public void setOp_id(String op_id) {
		this.op_id = op_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Date getOp_date() {
		return op_date;
	}
	public void setOp_date(Date op_date) {
		this.op_date = op_date;
	}
	public String getOp_process() {
		return op_process;
	}
	public void setOp_process(String op_process) {
		this.op_process = op_process;
	}
	public int getOp_emp() {
		return op_emp;
	}
	public void setOp_emp(int op_emp) {
		this.op_emp = op_emp;
	}
	public int getTmp_qty() {
		return tmp_qty;
	}
	public void setTmp_qty(int tmp_qty) {
		this.tmp_qty = tmp_qty;
	}
	
	
	// product
	public String getProduct_qty() {
		return product_qty;
	}
	public void setProduct_qty(String product_qty) {
		this.product_qty = product_qty;
	}
	

	// contract
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public int getCont_qty() {
		return cont_qty;
	}
	public void setCont_qty(int cont_qty) {
		this.cont_qty = cont_qty;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getProduction_id() {
		return production_id;
	}
	public void setProduction_id(String production_id) {
		this.production_id = production_id;
	}
	
	
	// employee
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	
	
	// pr_material
	public float getUse_qty() {
		return use_qty;
	}
	public void setUse_qty(float use_qty) {
		this.use_qty = use_qty;
	}
	
	
	// material
	public String getMa_id() {
		return ma_id;
	}
	public void setMa_id(String ma_id) {
		this.ma_id = ma_id;
	}
	public String getMa_name() {
		return ma_name;
	}
	public void setMa_name(String ma_name) {
		this.ma_name = ma_name;
	}
	public int getMa_qty() {
		return ma_qty;
	}
	public void setMa_qty(int ma_qty) {
		this.ma_qty = ma_qty;
	}
	
	
	// 기간 조회 변수
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
	// toString
	@Override
	public String toString() {
		return "OutProductVO [op_id=" + op_id + ", product_id=" + product_id + ", cont_id=" + cont_id + ", op_process="
				+ op_process + ", op_date=" + op_date + ", op_emp=" + op_emp + ", tmp_qty=" + tmp_qty
				+ ", product_name=" + product_name + ", product_qty=" + product_qty + ", due_date=" + due_date
				+ ", cont_qty=" + cont_qty + ", cust_name=" + cust_name + ", production_id=" + production_id
				+ ", emp_name=" + emp_name + ", use_qty=" + use_qty + ", ma_id=" + ma_id + ", ma_name=" + ma_name
				+ ", ma_qty=" + ma_qty + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
}
