package com.adantal.serviceImpl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.advantal.model.Organization;
import com.advantal.model.PostCampaign;
import com.advantal.repository.OrganizationRepository;
import com.advantal.repository.PostCampaignRepository;
import com.advantal.service.PostCampaignService;
import com.advantal.util.IConstant;


@Service
@EnableScheduling
public class PostCampaignServiceImpl implements PostCampaignService {

	@Autowired
	private PostCampaignRepository postCampaignRepository;
	
	

    @Autowired
    private OrganizationRepository organizationRepository;
	
	@Override
	public PostCampaign addPostCampaign(PostCampaign postCampaign, MultipartFile[] files) {
		PostCampaign postCampaignDetail = new PostCampaign();
		
		Date date = new Date();
		try {
			
			String images = "";
			if (postCampaignDetail != null) {
				
		     	for (MultipartFile multipartFile : files) {
					multipartFile.getOriginalFilename();
					byte[] bytes = multipartFile.getBytes();
					String contentType = multipartFile.getContentType();
                    String fileName=System.currentTimeMillis()+multipartFile.getOriginalFilename();

					BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(IConstant.POSTCAMPAIGN_FILE_PATH +fileName)));
					buffStream.write(bytes);
					buffStream.close();
					
					if(images=="") {
						images=IConstant.IMG+fileName;
					}
					else {
						images=images+","+IConstant.IMG+fileName;
					}
						
				}
				postCampaign.setImages(images);
				
				postCampaign.setActive(true);
				
			 
				Organization org=organizationRepository.findByEmailId(postCampaign.getOrganizationEmail());
				if (org!=null && org.getOrganizationEmail()!=null) {
					postCampaign.setOrganizationEmail(postCampaign.getOrganizationEmail());
				}else {
					return null;
				}
			
				postCampaignDetail = postCampaignRepository.save(postCampaign);
                System.out.println(postCampaignDetail);
                           
			}
		} catch (Exception e) {
			//e.printStackTrace();
			postCampaignDetail=null;
		}

		return postCampaignDetail;

	}
	
	
	
	@Scheduled(fixedDelay = 1000)
	public PostCampaign addCronJobPostCampaign() {
//	 System.out.println("fsdgsdgdfgsg");
//	 PostCampaign postCampaign=new PostCampaign();
//	 
//	 List<PostCampaign> listOfPostCampaign = new ArrayList<PostCampaign>();
//	 listOfPostCampaign= postCampaignRepository.findAll();
//	
//	 
////	 System.out.println("listOfPostCampaign=" + listOfPostCampaign);
//	 for (PostCampaign postCampaigndata : listOfPostCampaign) {
//		 
//		System.out.println("End date = "+ postCampaigndata.getEndDate()); 
//		Date currentDate = new Date();
//		System.out.println("currentDate="+ currentDate);
//		
//		if(currentDate.before(postCampaigndata.getEndDate()))		
//			System.out.println("No need to update status");		
//		else
//			postCampaign.setActive(false);
//			
//			
//		 
//		
//	}
////		if (!postCampaign.getEndDate().equals(postCampaign.getStartDate())) {
//			postCampaign.setActive(false);
//		}
//		 
		return null;

	}



	@Override
	public Map<Object, Object> getPostCampaignRecordbyMail(String byEmail) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<PostCampaign> postCampaignList = new ArrayList<PostCampaign>();
		if(byEmail !=null)
			postCampaignList = postCampaignRepository.findPostCampaignRecordbyMail(byEmail);
		
		try {
			
			if(postCampaignList !=null ) {			
			map.put(IConstant.RESPONSE, IConstant.SUCCESS);
			map.put(IConstant.RESPONSE_LIST, postCampaignList);
			}
			else
			{
				map.put(IConstant.RESPONSE,IConstant.NOT_AUTHORIZED);
				map.put(IConstant.MESSAGE, "No such record found for perticular "+byEmail);
			}
		} catch (Exception e) {
			map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
			map.put(IConstant.MESSAGE, IConstant.EMPTY_LIST_MESSAGE);
		}
		
		
		
		return map;
	}



	@Override
	public Map<Object, Object> getCountPostCampaignRecordbyMail(String byEmail) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<PostCampaign> postCampaignList = new ArrayList<PostCampaign>();
		if(byEmail !=null)
			postCampaignList = postCampaignRepository.findPostCampaignRecordbyMailCount(byEmail);
		
		try {
			
			if(postCampaignList !=null ) {			
			map.put(IConstant.RESPONSE, IConstant.SUCCESS);
			map.put(IConstant.RESPONSE_COUNT, postCampaignList.size());
			}
			else
			{
				map.put(IConstant.RESPONSE,IConstant.NOT_AUTHORIZED);
				map.put(IConstant.MESSAGE, "No such record found for perticular "+byEmail);
			}
		} catch (Exception e) {
			map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
			map.put(IConstant.MESSAGE, IConstant.EMPTY_LIST_MESSAGE);
		}
		
		
		
		return map;
		
	}

}
