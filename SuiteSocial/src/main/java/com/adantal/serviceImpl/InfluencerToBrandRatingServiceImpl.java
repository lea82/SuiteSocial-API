package com.adantal.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adantal.vo.InfluencerToBrandRatingVO;
import com.advantal.model.BrandToInfluencerRating;
import com.advantal.model.CompanySurvey;
import com.advantal.model.InfluencerToBrandRating;
import com.advantal.repository.CompanySurveyRepository;
import com.advantal.repository.InfluencerToBrandRatingRepository;
import com.advantal.service.InfluencerToBrandRatingService;
import com.advantal.util.IConstant;
@Service
public class InfluencerToBrandRatingServiceImpl implements InfluencerToBrandRatingService{

	@Autowired
	InfluencerToBrandRatingRepository influencerToBrandRatingRepository;
	
	@Autowired
	private CompanySurveyRepository companySurveyRepository;
	
	@Override
	public InfluencerToBrandRating saveRatingDetail(InfluencerToBrandRating influencerToBrandRating) {
		InfluencerToBrandRating influencerToBrandRatingDetail=new InfluencerToBrandRating();
		try {
			influencerToBrandRatingDetail=influencerToBrandRatingRepository.save(influencerToBrandRating);
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
		return influencerToBrandRatingDetail;
	}

	@Override
	public Map<Object, Object> searchInfluencerToBrandRatingReview(InfluencerToBrandRating influencerToBrandRating) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		try {
			
			influencerToBrandRatingRepository.save(influencerToBrandRating);
			
			InfluencerToBrandRatingVO influencerToBrandRatingVO = new InfluencerToBrandRatingVO();
			List<InfluencerToBrandRating> listOfInfluencerToBrandRatings = influencerToBrandRatingRepository
					.findByBrandEmail(influencerToBrandRating.getBrandEmailId());

			if (!listOfInfluencerToBrandRatings.isEmpty()) {
				Double ratingCount = 0.0;
				for (InfluencerToBrandRating influencerToBrandRatingObj : listOfInfluencerToBrandRatings) {

					ratingCount = ratingCount + influencerToBrandRatingObj.getRating();

				}

				
				ratingCount =ratingCount / listOfInfluencerToBrandRatings.size();
				double ratingCount1 = Math.round(ratingCount * 10) / 10.0;
                CompanySurvey companySurvey=companySurveyRepository.findCompanySurveyRecordbyMail(influencerToBrandRating.getBrandEmailId());
                		
                		
				influencerToBrandRatingVO.setReviewerEmailId(influencerToBrandRating.getReviewerEmailId());
				influencerToBrandRatingVO.setBrandEmailId(influencerToBrandRating.getBrandEmailId());
				influencerToBrandRatingVO.setAverageRating(ratingCount1);
				influencerToBrandRatingVO.setTotalRating(listOfInfluencerToBrandRatings.size());
				
				companySurvey.setAverageRating(ratingCount1);
				companySurvey.setTotalRating(listOfInfluencerToBrandRatings.size());
				
				companySurveyRepository.save(companySurvey);

				map.put(IConstant.RESPONSE, IConstant.SUCCESS);
				map.put(IConstant.MESSAGE, IConstant.SUCCESS_MESSAGE);
				map.put(IConstant.OBJECT, influencerToBrandRatingVO);

			} else {
				map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
				map.put(IConstant.MESSAGE, IConstant.NOT_SAVED);
			}

		} catch (Exception e) {
			//e.printStackTrace();

			map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
			map.put(IConstant.MESSAGE,
					"Exception occered for Email " + influencerToBrandRating.getBrandEmailId());

		}

		return map;
	}
	
	@Override
	public Map<Object, Object> getInfluencerToBrandRatingReviewRecordbyMail(String byEmail) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<InfluencerToBrandRating> influencerToBrandRatingList = new ArrayList<InfluencerToBrandRating>();
		if (byEmail != null)
			influencerToBrandRatingList = influencerToBrandRatingRepository.findInfluencerToBrandRatingRecordsbyMail(byEmail);

		try {

			if (influencerToBrandRatingList != null) {
				map.put(IConstant.RESPONSE, IConstant.SUCCESS);
				map.put(IConstant.RESPONSE_LIST, influencerToBrandRatingList);
			} else {
				map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
				map.put(IConstant.MESSAGE, "No such record found for perticular " + byEmail);
			}
		} catch (Exception e) {
			map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
			map.put(IConstant.MESSAGE, IConstant.EMPTY_LIST_MESSAGE);
		}

		return map;
	}
}
