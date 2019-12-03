package com.adantal.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adantal.vo.BrandToInfluencerRatingVO;
import com.advantal.model.BrandToInfluencerRating;
import com.advantal.model.CompanySurvey;
import com.advantal.model.InfluencerSurvey;
import com.advantal.repository.BrandToInfluencerRatingRepository;
import com.advantal.repository.InfluencerSurveyRepository;
import com.advantal.service.BrandToInfluencerRatingService;
import com.advantal.util.IConstant;

@Service
public class BrandToInfluencerRatingServiceImpl implements BrandToInfluencerRatingService {

	@Autowired
	BrandToInfluencerRatingRepository brandToInfluencerRatingRepository;

	@Autowired
	private InfluencerSurveyRepository influencerSurveyRepository;

	@Override
	public Map<Object, Object> searchBrandToInfluencerRatingReview(BrandToInfluencerRating brandToInfluencerRating) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		try {

			brandToInfluencerRatingRepository.save(brandToInfluencerRating);

			BrandToInfluencerRatingVO brandToInfluencerRatingVO = new BrandToInfluencerRatingVO();
			List<BrandToInfluencerRating> listOfBrandToInfluencerRatings = brandToInfluencerRatingRepository
					.findByInfluencerEmail(brandToInfluencerRating.getInfluencerEmailId());

			if (!listOfBrandToInfluencerRatings.isEmpty()) {
				Double ratingCount = 0.0;
				for (BrandToInfluencerRating brandToInfluencerRatingObj : listOfBrandToInfluencerRatings) {

					ratingCount = ratingCount + brandToInfluencerRatingObj.getRating();

				}
				ratingCount =ratingCount / listOfBrandToInfluencerRatings.size();
				double ratingCount1 = Math.round(ratingCount * 10) / 10.0;
                System.out.println("data from ratingCount1 "+ ratingCount1);
				InfluencerSurvey influencerSurvey = influencerSurveyRepository
						.findInfuencerSurveyRecordbyMail(brandToInfluencerRating.getInfluencerEmailId());

				brandToInfluencerRatingVO.setReviewerEmailId(brandToInfluencerRating.getReviewerEmailId());
				brandToInfluencerRatingVO.setInfluencerEmailId(brandToInfluencerRating.getInfluencerEmailId());
				brandToInfluencerRatingVO.setAverageRating(ratingCount1);
				brandToInfluencerRatingVO.setTotalRating(listOfBrandToInfluencerRatings.size());

				influencerSurvey.setAverageRating(ratingCount1);
				influencerSurvey.setTotalRating(listOfBrandToInfluencerRatings.size());

				influencerSurveyRepository.save(influencerSurvey);

				map.put(IConstant.RESPONSE, IConstant.SUCCESS);
				map.put(IConstant.MESSAGE, IConstant.SUCCESS_MESSAGE);
				map.put(IConstant.OBJECT, brandToInfluencerRatingVO);

			} else {
				map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
				map.put(IConstant.MESSAGE, IConstant.NOT_SAVED);
			}

		} catch (Exception e) {
			//e.printStackTrace();

			map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
			map.put(IConstant.MESSAGE,
					"No any Records exist for particular " + brandToInfluencerRating.getInfluencerEmailId());

		}

		return map;
	}
	
	@Override
	public Map<Object, Object> getBrandToInfluencerRatingReviewRecordbyMail(String byEmail) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<BrandToInfluencerRating> brandToInfluencerRatingList = new ArrayList<BrandToInfluencerRating>();
		if (byEmail != null)
			brandToInfluencerRatingList = brandToInfluencerRatingRepository.findBrandToInfluencerRatingRecordsbyMail(byEmail);

		try {

			if (brandToInfluencerRatingList != null) {
				map.put(IConstant.RESPONSE, IConstant.SUCCESS);
				map.put(IConstant.RESPONSE_LIST, brandToInfluencerRatingList);
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
