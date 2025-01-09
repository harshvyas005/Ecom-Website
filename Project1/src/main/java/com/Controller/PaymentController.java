package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Bean.PaymentBean;
import com.Service.EmailService;
import com.Service.PaymentService;

import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;


@Controller
public class PaymentController 
{
	@Autowired
	EmailService emailservice;
	
	@Autowired
	PaymentService paymentService;
	
	@GetMapping("/checkout")
	public String checkout()
	{
		return "Checkout"; 
	}
	@GetMapping("/inputemail")
	public String inputEmail()
	{
		return "InputEmail";
	}
	@PostMapping("/sendmail")
	public String sendMail(@RequestParam("email") String email) 
	{
		System.out.println(email);
		emailservice.sendDemoMail(email, "hi payment success");
		
		return "Success";
		
	}
	@PostMapping("/processPayment")
	public String processPayment(@RequestParam("amount") String amount,
	                             PaymentBean paymentBean, Model model) {

	    ANetApiResponse apiResponse = paymentService.run(paymentBean);

	    // Check if the payment was successful
	    if (apiResponse != null && apiResponse.getMessages().getResultCode() == MessageTypeEnum.OK) {
	        model.addAttribute("result", "success");
	    } else {
	        String errorMessage = (apiResponse != null && apiResponse.getMessages().getMessage() != null)
	                ? apiResponse.getMessages().getMessage().get(0).getText()
	                : "Unknown error occurred.";
	        model.addAttribute("result", "failure: " + errorMessage);
	    }

	    return "PaymentResult";
	}

	

}
