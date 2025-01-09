package com.Service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Bean.EuserBean;

@Service
public class FileUploadService 
{
	public void uploadProductImage(MultipartFile masterImage)
	{
		System.out.println(masterImage.getOriginalFilename());
		
		String path="D:\\stsProjects\\Project1\\src\\main\\webapp\\Images\\Products";
		
		try {
			byte b[]=masterImage.getBytes();
			File file=new File(path,masterImage.getOriginalFilename());
			FileUtils.writeByteArrayToFile(file, b);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	public void uploadUserImage(MultipartFile masterImage,String email)
	{
		System.out.println(masterImage.getOriginalFilename());
		
		String path="D:\\stsProjects\\Project1\\src\\main\\webapp\\Images\\ProfilePics";
		File dir=new File(path,email);
		dir.mkdir();
		try {
			byte b[]=masterImage.getBytes();
			File file=new File(dir,masterImage.getOriginalFilename());
			FileUtils.writeByteArrayToFile(file, b);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}


