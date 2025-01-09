package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Bean.EcartBean;
import com.Bean.EwishListProductBean;
import com.Bean.WishListBean;

@Repository
public class WishListdao 
{
	@Autowired
	JdbcTemplate stmt;
	
	public void addTowishlist(WishListBean wishListBean)
	{
		stmt.update("insert into wishList(productId,userId) values(?,?)",wishListBean.getProductId(),wishListBean.getUserId());

	}
	public List<EwishListProductBean> myWishList(Integer userId)
	{
		List<EwishListProductBean> products=stmt.query(" select w.*,p.productId,p.productName,p.productImagePath,p.price from products p join wishlist w using(productId) where userId=?;",new BeanPropertyRowMapper<>(EwishListProductBean.class),new Object[] {userId});
		return products;
	}
	public void deleteProductInWishList(Integer productId, Integer userId) 
	{
        //WishListBean wishListBean = stmt.queryForObject("select * from wishlist where productId = ? and userId = ?",new BeanPropertyRowMapper<>(WishListBean.class), productId, userId);
        
        try
        {
        	 stmt.update("DELETE FROM wishlist WHERE productId = ? and userId = ?",
                     productId, userId);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
		
	}


}
