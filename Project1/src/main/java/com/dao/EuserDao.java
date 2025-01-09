package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Bean.EuserBean;

@Repository
public class EuserDao 
{
	@Autowired
	JdbcTemplate stmt;
	
	
	public void insertUser(EuserBean userBean)
	{
		stmt.update("insert into user(name,email,password,profilePicPath,phoneNo) values(?,?,?,?,?)",userBean.getName(),userBean.getEmail(),userBean.getPassword(),userBean.getProfilePicPath(),userBean.getPhoneNo());
	}
	public EuserBean authenticate(String email,String password)
	{
		try
		{
			EuserBean userBean=stmt.queryForObject("select*from user where email=? and password=?", new BeanPropertyRowMapper<>(EuserBean.class),new Object[] {email,password});
			return userBean;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			
		}
		return null;
	}
	  public Optional<EuserBean> findByEmail(String email) {
	        String sql = "SELECT * FROM user WHERE email = ?";
	        EuserBean user = stmt.queryForObject(sql, new Object[]{email}, new UserRowMapper());
	        return Optional.ofNullable(user);	    
	        }

	    // Update the user's OTP by their email address
	    public void updateOtpByEmail(String email, String otp) {
	        String sql = "UPDATE user SET otp = ? WHERE email = ?";
	        stmt.update(sql, otp, email);
	    }

	    // Update the user's password by their email address
	    public void updatePasswordByEmail(String email, String password) {
	        String sql = "UPDATE user SET password = ? WHERE email = ?";
	        stmt.update(sql, password, email);
	    }

	    // RowMapper to map SQL result to a User object
	    private static class UserRowMapper implements RowMapper<EuserBean> 
	    {
	        @Override
	        public EuserBean mapRow(ResultSet rs, int rowNum) throws SQLException 
	        {
	            EuserBean user = new EuserBean();
	            user.setId((int) rs.getLong("id"));
	            user.setEmail(rs.getString("email"));
	            user.setPhoneNo(rs.getString("phoneNo"));
	            user.setPassword(rs.getString("password"));
	            user.setOtp(rs.getString("otp"));
	            return user;
	        }
	    }
	    
	    public void updateuser(EuserBean userBean)
	    {
	    	String sql="UPDATE user SET name = ?, email = ?, phoneNo = ?, password = ?, profilePicPath = ? WHERE id = ?";
	    	 stmt.update(sql, 
	    	            userBean.getName(), 
	    	            userBean.getEmail(), 
	    	            userBean.getPhoneNo(), 
	    	            userBean.getPassword(), 
	    	            userBean.getProfilePicPath(),
	    	            userBean.getId());
	    }

}
