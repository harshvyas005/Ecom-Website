package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Bean.EproductBean;
import com.Service.FileUploadService;
import com.dao.EproductDao;

@Controller
public class EproductController 
{
	@Autowired
	EproductDao productDao;
	
	@Autowired
	FileUploadService fileuploadservice;
	
	@GetMapping("/newproduct")
	public String newProduct()
	{
		return "EcomProduct";
	}
	@PostMapping("/saveproduct")
	public String saveProduct(EproductBean productBean,@RequestParam("masterImage") MultipartFile masterImage)
	{
		
		fileuploadservice.uploadProductImage(masterImage);
		productDao.addProduct(productBean);
		return "redirect:/products";
	}
	@GetMapping("/products")
	public String listProducts(Model model)
	{
		List<EproductBean> products = productDao.getAllProducts();// return type
		model.addAttribute("products", products);
		return "EcomListProducts";
	}
	@GetMapping("/deleteproduct")
	public String deleteProduct(@RequestParam("productId") Integer productId)
	{
		System.out.println("deleteProduct()=>"+productId);
		productDao.deleteProduct(productId);
		return "redirect:/products";
			
	}
	@GetMapping("/deletebyname")
	public String deleteByName()
	{
		return "DeleteByName";	
	}
	@PostMapping("/deleteidbyname")
	public String deleteIdByName(@RequestParam("productName") String name)
	{
		productDao.deleteIdByName(name);
		return "redirect:/products";
	}
	@GetMapping("viewproduct")
	public String viewProduct(@RequestParam("productId") Integer productId,Model model)
	{
		EproductBean productBean=productDao.getProductById(productId);
		model.addAttribute("product", productBean);
		return "viewProduct";
	}
	@GetMapping("/searchproduct")
	public String searchProduct()
	{
		return "SearchUser";
	}
	@PostMapping("/seacrhuser")
	public String scUser(@RequestParam("sName") String sName,Model model)
	{
		List<EproductBean> p=productDao.searchproduct(sName);
		model.addAttribute("p",p);
		return "ScProd";
	}
	@GetMapping("/viewProductImage")
	public String viewProductImage(@RequestParam("productId") Integer productId,Model model,EproductBean eproductBean)
	{
	    EproductBean product = productDao.getProductById(productId);
		String path=product.getProductImagePath();
		model.addAttribute("path", path);
		return "viewProductImage";
	}
	
}
