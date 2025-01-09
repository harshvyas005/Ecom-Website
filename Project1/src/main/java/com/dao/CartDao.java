package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Bean.EcartBean;
import com.Bean.EcartProductBean;
import com.Bean.EproductBean;

@Repository
public class CartDao 
{
	@Autowired
	JdbcTemplate stmt;
	
	EcartBean cart=null;

	public void addToCart(EcartBean cartBean) {
	    try {
	        // Fetch the existing cart item
	        cart = stmt.queryForObject("SELECT * FROM cart WHERE productId = ? AND userId = ?",
	                new BeanPropertyRowMapper<>(EcartBean.class),
	                new Object[] {cartBean.getProductId(), cartBean.getUserId()});
	    } catch (Exception e) {
	        cart = null;  // If no record found, cart will be null
	    }

	    // If the cart item does not exist, insert it
	    if (cart == null) {
	        stmt.update("INSERT INTO cart (productId, userId, qty) VALUES (?, ?, ?)", 
	                cartBean.getProductId(), cartBean.getUserId(), 1);
	    } else {
	        // If it exists, increment the quantity
	        stmt.update("UPDATE cart SET qty = qty + 1 WHERE productId = ? AND userId = ?",
	                cartBean.getProductId(), cartBean.getUserId());
	    }
	}

	public List<EcartProductBean> myCart(Integer userId)
	{
		List<EcartProductBean> products=stmt.query(" select c.*,p.productId,p.productName,p.productImagePath,p.price from products p join cart c using(productId) where userId=?;",new BeanPropertyRowMapper<>(EcartProductBean.class),new Object[] {userId});
		return products;
	}
    public void deleteProductInCart(Integer productId, Integer userId)
    {
        try
        {
            EcartBean cartBean = stmt.queryForObject("select * from cart where productId = ? and userId = ?",new BeanPropertyRowMapper<>(EcartBean.class), productId, userId);
            if (cartBean != null) 
            {
                if (cartBean.getQty()> 1) 
                {
                    stmt.update("update cart set qty = qty - 1 where productId = ? and userId = ?",
                                productId, userId);
                } else 
                {
                    stmt.update("DELETE FROM cart WHERE productId = ? and userId = ?",
                                productId, userId);
                }
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace(); // Consider using a logger instead of printStackTrace
        }
    }

}
