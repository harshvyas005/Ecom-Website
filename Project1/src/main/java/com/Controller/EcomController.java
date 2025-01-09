package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Bean.EuserBean;
import com.Service.FileUploadService;
import com.Service.ForgetPasswordService;
import com.dao.EuserDao;

import jakarta.servlet.http.HttpSession;

@Controller
public class EcomController 
{
	@Autowired
	EuserDao userDao;
	
	@Autowired
	FileUploadService fileuploadservice;
	
	 @Autowired
	 private ForgetPasswordService forgetPasswordService;
	 
	 @Autowired
	 FileUploadService fileUploadService;
	
	
	@GetMapping({"/","elogin"})
	public String welcome()
	{
		return "EcomLogin";
	}
	@PostMapping("/elogin")
	public String login(EuserBean userBean,Model model,HttpSession session)
	{
		EuserBean userDb=userDao.authenticate(userBean.getEmail(), userBean.getPassword());
		if(userDb==null)
		{
			model.addAttribute("error","Invalid credentials");
			return "EcomLogin";	
		}
		else
		{
			session.setAttribute("user", userDb);
			model.addAttribute("profilePicPath",userDb.getProfilePicPath());
			model.addAttribute("name",userDb.getName());
			return "EcomHome";
		}
	}
	
	
	@GetMapping("/esignup")
	public String signup()
	{
		return "EcomSignup";
		
	}
	@PostMapping("/esignup1")
	public String  signupPost(EuserBean userBean)
	{
		fileuploadservice.uploadUserImage(userBean.getProfilePic(), userBean.getEmail());
		userBean.setProfilePicPath("Images\\ProfilePics\\"+userBean.getEmail()+"\\"+userBean.getProfilePic().getOriginalFilename());
		userDao.insertUser(userBean);
		return "EcomLogin";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/elogin";
	}
	@GetMapping("/forgetpassword")
	public String forgetPassword()
	{
	
		return "ForgetPassword";
	}
	@PostMapping("/fgpassword")
	public String fgPassword(@RequestParam("email") String email,Model model)
	{
		forgetPasswordService.processForgetPassword(email);

		model.addAttribute("email",email);
		return "VerifyOtp";
	}
	@PostMapping("/verifyotp")
	public String verifyOtp(@RequestParam("email") String email,
							@RequestParam("otp") String otp,Model model)
	{
		if(forgetPasswordService.verifyOtp(email, otp))
		{
			model.addAttribute("email", email);
			return "ResetPassword";
		}
		else
		{
			model.addAttribute("error","invalid otp");
			return "VerifyOtp";

		}
	}
	@PostMapping("resetpassword")
	public String resetPassword(@RequestParam("email") String email,
								@RequestParam("newPassword") String newPassword)
	{
		forgetPasswordService.updatePassword(email, newPassword);
		return "redirect:/elogin?resetSuccess";
		
	}
	@GetMapping("/editprofile")
	public String updateProfile(HttpSession session,Model model)
	{
		EuserBean user=(EuserBean)session.getAttribute("user");
		model.addAttribute("user",user);
		return "updateProfile";
	}
	@PostMapping("/updateProfile")
	public String updateProfile(
	        @ModelAttribute EuserBean userBean,
	        @RequestParam("profilePic") MultipartFile profilePic,
	        HttpSession session) {

	    // Get the current user from the session
	    EuserBean sessionUser = (EuserBean) session.getAttribute("user");

	    // Handle the profile picture upload
	    if (profilePic != null && !profilePic.isEmpty()) {
	        try {
	            // Use the FileUploadService to upload the profile picture
	            fileUploadService.uploadUserImage(profilePic, sessionUser.getEmail());

	            // Update the profilePicPath in the userBean
	            String uploadedFilePath = "/Images/ProfilePics/" + sessionUser.getEmail() + "/" + profilePic.getOriginalFilename();
	            userBean.setProfilePicPath(uploadedFilePath);
	        } catch (Exception e) {
	            e.printStackTrace();
	            // Retain the existing profile picture path in case of an error
	            userBean.setProfilePicPath(sessionUser.getProfilePicPath());
	        }
	    } else {
	        // Retain the existing profile picture path if no new picture is uploaded
	        userBean.setProfilePicPath(sessionUser.getProfilePicPath());
	    }

	    // Update the user details in the database
	    userDao.updateuser(userBean);

	    // Update the session with the modified user object
	    session.setAttribute("user", userBean);

	    return "redirect:/ehome";
	}

}
