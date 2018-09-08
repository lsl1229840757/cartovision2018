package com.zh.Domain;

public class GDPDetail {
	// 城市id
	private int cityId;
	// 数据年份（2012-2016）
	private int myYear;
	// 第一产业增长量
	private double PrIn;
	// 第二产业增长量
	private double SeIn;
	// 第三产业增长量
	private double TeIn;
	// GDP总量
	private double total;
	// 城市名称
	private String cityName;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getMyYear() {
		return myYear;
	}

	public void setMyYear(int myYear) {
		this.myYear = myYear;
	}

	public double getPrIn() {
		return PrIn;
	}

	public void setPrIn(double prIn) {
		PrIn = prIn;
	}

	public double getSeIn() {
		return SeIn;
	}

	public void setSeIn(double seIn) {
		SeIn = seIn;
	}

	public double getTeIn() {
		return TeIn;
	}

	public void setTeIn(double teIn) {
		TeIn = teIn;
	}

}
