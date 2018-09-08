package com.zh.Domain;

public class CityForm {
	//表单城市id
	private int cityId;
	//表单类型id
	private int formId;
	// 数据中的最小年份
	private int minYear;
	// 数据中的最大年份
	private int maxYear;
	// 数据年份是否连续
	private int isSession;
	// 独立分布的年份
	private String[] years;
	
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getFormId() {
		return formId;
	}
	public void setFormId(int formId) {
		this.formId = formId;
	}
	public int getMinYear() {
		return minYear;
	}
	public void setMinYear(int minYear) {
		this.minYear = minYear;
	}
	public int getMaxYear() {
		return maxYear;
	}
	public void setMaxYear(int maxYear) {
		this.maxYear = maxYear;
	}
	public int getIsSession() {
		return isSession;
	}
	public void setIsSession(int isSession) {
		this.isSession = isSession;
	}
	public String[] getYears() {
		return years;
	}
	public void setYears(String[] years) {
		this.years = years;
	}
	
	
}
