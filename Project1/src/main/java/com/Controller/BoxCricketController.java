package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Bean.BoxCricketBean;

@Controller
public class BoxCricketController 
{
	@GetMapping("/bx")
	public String box()
	{
		return "BoxCricket";
	}
	@PostMapping("/boxcricket")
	public String Register(BoxCricketBean user1,Model model)
	{
		boolean isError=false;
		String regEx="[a-zA-Z\s]+";
		if(user1.getName()==null||user1.getName().trim().length()==0)
		{
			isError=true;
			model.addAttribute("nameError","please enter your name");
		}
		else if(user1.getName().matches(regEx)==false)
		{
			isError=true;
			model.addAttribute("nameError","please enter your valid name");

		}
		
		if(user1.getType()==null)
		{
			isError=true;
			model.addAttribute("typeError","please enter the type");
		}
		if(user1.getFood().equals("-1"))
		{
			isError=true;
			model.addAttribute("foodError","please enter type of food");
		}
		if(user1.getDrink()==null ||user1.getDrink().isEmpty())
		{
			isError=true;
			model.addAttribute("drinkError","please enter atleast 1 drink");
		}
		model.addAttribute("value",user1);
		if(isError==true)
		{
			return "BoxCricket";
		}
		else
		{
		
			model.addAttribute("name",user1);
			return "BoxCricketOutput";
		}
	}
}
