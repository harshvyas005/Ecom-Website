package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Bean.FormBean;


@Controller
public class SessionController 
{
	@GetMapping("/welcome")
	public String Welcome()
	{
		return "Welcome";
		
	}
	@GetMapping("/signup")
	public String SignUp()
	{
		return "Signup";
	}
	@GetMapping("/Login")
	public String Login()
	{
		return "Login";
	}
	@GetMapping("/fp")
	public String ForgPass()
	{
		return "ForgetPassword";
	}
	@GetMapping("a")
	public String add()
	{
		return "Add";
	}
	@PostMapping("/aU")
	public String addUser(FormBean formbean,Model model) 
	{
		System.out.println("name:"+formbean.getName());
		System.out.println("email:"+formbean.getEmail());
		System.out.println("name:"+formbean.getPass());
		model.addAttribute("user", formbean);	
		return "Home" ;
	}
	
	@PostMapping("/add")
	public String AddNos(FormBean formbean,Model model)
	{
		System.out.println(formbean.getNo1());
		System.out.println(formbean.getNo2());
		model.addAttribute("user",formbean);
		return "AddAns";
	}
	
	

}
