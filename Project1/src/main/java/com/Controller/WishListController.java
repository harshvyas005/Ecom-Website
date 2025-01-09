package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Bean.EcartProductBean;
//import com.Bean.EcartBean;
import com.Bean.EuserBean;
import com.Bean.EwishListProductBean;
import com.Bean.WishListBean;
import com.dao.WishListdao;

//import jakarta.annotation.Generated;
import jakarta.servlet.http.HttpSession;

@Controller
public class WishListController 
{
	@Autowired
	WishListdao wishListDao;
	
	@GetMapping("/addtowishlist")
	public String wishlist(@RequestParam ("productId") Integer productId,HttpSession session)
	{
		EuserBean userBean=(EuserBean) session.getAttribute("user");
		Integer userId=userBean.getId();
		WishListBean wishListBean=new WishListBean();
		wishListBean.setProductId(productId);
		wishListBean.setUserId(userId);
		System.out.println(productId);
		
		
		wishListDao.addTowishlist(wishListBean);
		
		return "redirect:/userproducts";
	}
	
	@GetMapping("/wishlist")
	public String wishList(Model model,WishListBean wishList,HttpSession session)
	{
		
		EuserBean userBean=(EuserBean) session.getAttribute("user");
		Integer userId=userBean.getId();
		List<EwishListProductBean> products=wishListDao.myWishList(userId);
		model.addAttribute("products",products);
		return "MyWishList";
	}
	@GetMapping("/deletefromwishlist")
	public String deleteFromWishList(@RequestParam("productId") Integer productId,HttpSession session)
	{
		EuserBean userBean=(EuserBean) session.getAttribute("user");
		Integer userId=userBean.getId();
		wishListDao.deleteProductInWishList(productId,userId);
		return "redirect:/wishlist";
	}
	

}
