package com.Controller.Users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Bean.EproductBean;
import com.dao.EproductDao;

@Controller
public class UserProductController 
{
	@Autowired
	EproductDao productDao;
	
	@GetMapping("/userproducts")
	public String listProducts(Model model)
	{
		List<EproductBean> products = productDao.getAllProducts();// return type
		model.addAttribute("products", products);
		return "EcomListUserProducts";
	}
//	@GetMapping("/viewProductImage")
//	public String viewProductImage(@RequestParam("productId") Integer productId,EproductBean productBean,Model model)
//	{
//		
//		String img=productB
//		Integer protId=productId;
//		model.addAttribute("img", img);
//	    model.addAttribute("productId", productId);
//
//		
//		return "ViewProductImage";
//	}

}
