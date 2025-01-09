package com.Service;

import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class TwilioService {

	public static final String ACCOUNT_SID = ;
    public static final String AUTH_TOKEN = ;
    public static final String TWILIO_NUMBER =; // Make sure this is in E.164 format

    
  
    
    public void sendOtp(String toPhoneNumber, String otp) {
    	
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        try
        {
        	
            String formattedToPhoneNumber = formatPhoneNumber(toPhoneNumber);

        
        		Message message = Message.creator(
                new PhoneNumber(formattedToPhoneNumber),
                new PhoneNumber(TWILIO_NUMBER),
                "Your OTP is: " + otp
        ).create();
        System.out.println("OTP sent: " + message.getSid());
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    }
        private String formatPhoneNumber(String phoneNumber) {
        	 // Remove any non-numeric characters except for "+"
            phoneNumber = phoneNumber.replaceAll("[^+\\d]", "");

            // Check if the phone number already starts with "+91"
            if (!phoneNumber.startsWith("+91")) {
                phoneNumber = "+91" + phoneNumber;
            }

            return phoneNumber;

        }
}




	