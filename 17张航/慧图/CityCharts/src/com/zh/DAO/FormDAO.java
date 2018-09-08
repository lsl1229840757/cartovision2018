package com.zh.DAO;

import com.zh.Domain.Form;

public abstract class FormDAO {
	//通过表单类型查找对象
	public abstract Form findByCategory(String category);
	//通过表单id查找对象
	public abstract Form findById(int id);
	
	
	
}
