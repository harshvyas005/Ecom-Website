package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Bean.EproductBean;

@Repository
public class EproductDao 
{
	@Autowired
	JdbcTemplate stmt;
	public void addProduct(EproductBean productBean)
	{
		stmt.update("insert into products(productName,category,price,qty) values(?,?,?,?)",productBean.getProductName(),
				productBean.getCategory(),productBean.getPrice(),productBean.getQty());
	}
	public List<EproductBean> getAllProducts()
	{
		List<EproductBean> list=stmt.query("select*from products",new BeanPropertyRowMapper<>(EproductBean.class));
		return list;
	}
	public void deleteProduct(Integer productId)
	{
		stmt.update("delete from products where productId=?",productId);
	}
	public void deleteIdByName(String productName)
	{
		stmt.update("delete from products where productName=?",productName);
	}
	public EproductBean getProductById(Integer productId)
	{
		EproductBean bean=stmt.queryForObject("select productName,price,category,productImagePath from products where productId=?", new BeanPropertyRowMapper<>(EproductBean.class),new Object[] {productId});
		return bean;
	}
	public List<EproductBean> searchproduct(String sName) 
	{
		List<EproductBean> product=stmt.query("select*from products where productName like?", new BeanPropertyRowMapper<>(EproductBean.class),new Object[] {sName+"%"});
		return product;
	}
	

}
