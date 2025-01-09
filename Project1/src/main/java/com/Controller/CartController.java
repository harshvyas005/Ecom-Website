package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Bean.EcartBean;
import com.Bean.EcartProductBean;
import com.Bean.EproductBean;
import com.Bean.EuserBean;
import com.dao.CartDao;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController 
{
	@Autowired
	CartDao cartdao;
	
	@GetMapping("/addtocart")
	public String addToCart(@RequestParam ("productId") Integer productId,HttpSession session)
	{
		System.out.println(productId);
		EuserBean userBean=(EuserBean) session.getAttribute("user");
		Integer userId=userBean.getId();
		EcartBean cartBean=new EcartBean();
		cartBean.setProductId(productId);
		cartBean.setUserId(userId);
		System.out.println(userId);
		
		
		cartdao.addToCart(cartBean);
		
		return "redirect:/userproducts";
		
	}
	@GetMapping("/mycart")
	public String myCart(HttpSession session,Model model)
	{
		EuserBean userBean=(EuserBean) session.getAttribute("user");
		Integer userId=userBean.getId();
		List<EcartProductBean> products=cartdao.myCart(userId);
		model.addAttribute("products",products);
		return "mycart";
		
	}
	@GetMapping("/deletefromcart")
	public String deleteFromCart(@RequestParam("productId") Integer productId,HttpSession session)
	{
		EuserBean userBean=(EuserBean) session.getAttribute("user");
		Integer userId=userBean.getId();
		cartdao.deleteProductInCart(productId,userId);
		return "redirect:/mycart";
	}
	

}
