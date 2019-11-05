package com.advantal.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ConvertImage {
	public static List<String> saveImages(MultipartFile[] files, Long long1) {
		String fileName = null;
		String url ="https://localhost:8080/";
		List<String> imageList = new ArrayList<String>();
		if (files != null && files.length > IConstant.ZERO) {
			for (int i = 0; i < files.length; i++) {
				try {
					if (files[i].getSize() > IConstant.ZERO) {
						fileName = files[i].getOriginalFilename();
						byte[] bytes = files[i].getBytes();
						if (i == 0) {
							BufferedOutputStream buffStream = new BufferedOutputStream(
									new FileOutputStream(new File(IConstant.POSTCAMPAIGN_FILE_PATH +url+long1+"_"+fileName)));
							buffStream.write(bytes);
							buffStream.close();
							imageList.add(long1+"_"+fileName);
						}
							else if (i == 1) {
							BufferedOutputStream buffStream = new BufferedOutputStream(
									new FileOutputStream(new File(IConstant.POSTCAMPAIGN_FILE_PATH +url+long1+"_"+fileName)));
							buffStream.write(bytes);
							buffStream.close();
							imageList.add(long1+"_"+fileName);
						} else if (i == 2) {
							BufferedOutputStream buffStream = new BufferedOutputStream(
									new FileOutputStream(new File(IConstant.POSTCAMPAIGN_FILE_PATH +url+ long1+"_"+fileName)));
							buffStream.write(bytes);
							buffStream.close();
							imageList.add(long1+"_"+fileName);
						} else if (i == 3) {
							BufferedOutputStream buffStream = new BufferedOutputStream(
									new FileOutputStream(new File(IConstant.POSTCAMPAIGN_FILE_PATH +url+ long1+"_"+fileName)));
							buffStream.write(bytes);
							buffStream.close();
							imageList.add(long1+"_"+fileName);
						} else if (i == 4) {
							BufferedOutputStream buffStream = new BufferedOutputStream(
									new FileOutputStream(new File(IConstant.POSTCAMPAIGN_FILE_PATH +url+ long1+"_"+fileName)));
							buffStream.write(bytes);
							buffStream.close();
							imageList.add(url+long1+"_"+fileName);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return imageList;
	}

}
