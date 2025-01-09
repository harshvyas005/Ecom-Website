package com.Service;


import java.util.Optional;
import java.util.Random;

import org.apache.http.protocol.HttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bean.EuserBean;
import com.dao.EuserDao;
import com.twilio.Twilio;

@Service
public class ForgetPasswordService {

    @Autowired
    private EuserDao userDao;

    @Autowired
    private TwilioService twilioService;
    
    @Autowired 
    EuserDao euserDao;
    
    public void processForgetPassword(String email) {
        Optional<EuserBean> user = userDao.findByEmail(email);
        if (user != null) {
            EuserBean euserBean = user.get();

            String otp = generateOtp();
            euserBean.setOtp(otp);
            euserDao.updateOtpByEmail(email, otp);
            twilioService.sendOtp(euserBean.getPhoneNo(), otp);
        }
    }

    // Generate a 6-digit OTP
    public String generateOtp() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000));
    }

    // Send OTP to the user's registered phone number
    public boolean sendOtp(String email) {
        Optional<EuserBean> userOpt = userDao.findByEmail(email);
        if (userOpt.isPresent()) {
            EuserBean user = userOpt.get();
            String otp = generateOtp();
            user.setOtp(otp);
            userDao.updateOtpByEmail(user.getEmail(), otp);
            twilioService.sendOtp(user.getPhoneNo(), otp);
            return true;
        }
        return false;
    }

    // Verify if the provided OTP matches the one stored in the database
    public boolean verifyOtp(String email, String otp) {
        Optional<EuserBean> userOpt = userDao.findByEmail(email);
        if (userOpt.isPresent()) {
            EuserBean user = userOpt.get();
            return otp.equals(user.getOtp());
        }
        return false;
    }

    // Update the user's password
    public void updatePassword(String email, String newPassword) {
        Optional<EuserBean> userOpt = userDao.findByEmail(email);
        if (userOpt.isPresent()) {
            EuserBean user = userOpt.get();
            userDao.updatePasswordByEmail(user.getEmail(), newPassword);
        }
    }
}
