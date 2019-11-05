package com.adantal.serviceImpl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

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
	private PostCampaignRepository pcRepo;
	
	

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
						images=fileName;
					}
					else {
						images=images+","+fileName;
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
			//postCampaign.setOrg(organizationRepository.findByEmailId(organization.getOrganizationEmail()));
//				
				
				
				//System.out.println(postCampaign.isActive());
				
				postCampaignDetail = pcRepo.save(postCampaign);
                System.out.println(postCampaignDetail);
                           
			}
		} catch (Exception e) {
			e.printStackTrace();
			postCampaignDetail=null;
		}

		return postCampaignDetail;

	}
	
	
	
	@Scheduled(fixedDelay = 1000)
	public PostCampaign addCronJobPostCampaign() {
	 //System.out.println("fsdgsdgdfgsg");
	 PostCampaign postCampaign=new PostCampaign();

	 
//		if (!postCampaign.getEndDate().equals(postCampaign.getStartDate())) {
//			postCampaign.setActive(false);
//		}
//		 
		return null;

	}

}
