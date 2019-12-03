package com.adantal.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.adantal.vo.InfluencerSurveyVO;
import com.advantal.model.Influencer;
import com.advantal.model.InfluencerSurvey;
import com.advantal.repository.InfluencerRepository;
import com.advantal.repository.InfluencerSurveyRepository;
import com.advantal.service.InfluencerSurveyService;
import com.advantal.util.IConstant;

@Service
public class InfluencerSurveyImpl implements InfluencerSurveyService {

	@Autowired
	private InfluencerSurveyRepository influencerSurveyRepository;

	@Autowired
	private InfluencerRepository influencerRepository;

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public InfluencerSurvey saveSurveyDetail(InfluencerSurvey influencerSurvey) {

		influencerSurvey.setAverageRating(0.0);
		influencerSurvey.setTotalRating(0);
		InfluencerSurvey infsave = influencerSurveyRepository.save(influencerSurvey);

		if (infsave != null) {
			Influencer infl = influencerRepository.findByInfluencerId(infsave.getInfl().getInfluencerId());
			infl.setSurveyCompleted(true);
			influencerRepository.save(infl);
		}
		return infsave;
	}

	@Override
	public Map<Object, Object> searchByInfluencerSurveyCriteria(InfluencerSurveyVO influencerSurveyVO) {
		Map<Object, Object> influencerSurveyMap = new HashMap<Object, Object>();
		List<InfluencerSurvey> influencerSurveyList = new ArrayList<InfluencerSurvey>();
		Long countOfinfluencerSurveyField = 0l;
		String sqlQuery = IConstant.sqlQuery;

		List<InfluencerSurvey> listOfInfluencerSurvey = new ArrayList<InfluencerSurvey>();

		List<Map<String, Object>> templateResult = new ArrayList<Map<String, Object>>();

		try {

			if (influencerSurveyVO.getCitiesYourFollowersLocated().isEmpty()
					&& influencerSurveyVO.getTwitterFollowers() == null
					&& influencerSurveyVO.getYoutubeFollowers() == null && influencerSurveyVO.getBlogFollowers() == null
					&& influencerSurveyVO.getFacebookFollowers() == null
					&& influencerSurveyVO.getInstagramFollowers() == null
					&& influencerSurveyVO.getYourFollowersAgeBrackets().isEmpty()
					&& influencerSurveyVO.getTopicYouPost().isEmpty()
					&& influencerSurveyVO.getSearchByCityOrName() == null
					&& influencerSurveyVO.getAverageRating() == null

			) {

				System.out.println("for Default search... ");
				// influencerSurveyList = influencerSurveyRepository.findAll();
				influencerSurveyList = influencerSurveyRepository.findAll();
				countOfinfluencerSurveyField = influencerSurveyRepository.count();

				System.out.println("listOfInfluencerSurvey =" + listOfInfluencerSurvey);
				System.out.println("countOfinfluencerSurveyField =" + countOfinfluencerSurveyField);

			}

			/** 1 influencerSurvey Search for overall Single key search **/

			else if (influencerSurveyVO.getCitiesYourFollowersLocated().isEmpty()
					&& influencerSurveyVO.getTwitterFollowers() == null
					&& influencerSurveyVO.getYoutubeFollowers() == null && influencerSurveyVO.getBlogFollowers() == null
					&& influencerSurveyVO.getFacebookFollowers() == null
					&& influencerSurveyVO.getInstagramFollowers() == null
					&& influencerSurveyVO.getInstagramFollowers() == null
					&& influencerSurveyVO.getYourFollowersAgeBrackets().isEmpty()
					&& influencerSurveyVO.getTopicYouPost().isEmpty()
					&& influencerSurveyVO.getSearchByCityOrName() != null
					&& influencerSurveyVO.getAverageRating() == null) {
				System.out.println("for Single key search  .... ");

				if (influencerSurveyVO.getSearchByCityOrName() != null) {

					sqlQuery = sqlQuery + IConstant.cities_Followers + " LIKE '%"
							+ influencerSurveyVO.getSearchByCityOrName() + "%'" + " OR " + IConstant.your_name
							+ " LIKE '%" + influencerSurveyVO.getSearchByCityOrName() + "%'";

					jdbcTemplate = new JdbcTemplate(dataSource);
					templateResult = jdbcTemplate.queryForList(sqlQuery);
					sqlQuery = sqlQuery.substring(12);

					System.out.println("templateResult =" + templateResult);
					String sqlQuerycountforDefault = IConstant.sqlQuerycountforDefault + sqlQuery;
					Integer totalCount = jdbcTemplate.queryForObject(sqlQuerycountforDefault, Integer.class);

					countOfinfluencerSurveyField = new Long(totalCount);

					System.out.println("sqlQuery=" + sqlQuery);

				}

			}

			/** influencerSurvey Search based on criteria. **/
			else if (!influencerSurveyVO.getYourFollowersAgeBrackets().isEmpty()
					|| influencerSurveyVO.getTwitterFollowers() != null
					|| influencerSurveyVO.getYoutubeFollowers() != null || influencerSurveyVO.getBlogFollowers() != null
					|| influencerSurveyVO.getFacebookFollowers() != null
					|| influencerSurveyVO.getInstagramFollowers() != null
					|| influencerSurveyVO.getYourFollowersAgeBrackets() != null
					|| influencerSurveyVO.getAverageRating() != null) {

				System.out.println("for dynamic custom search with city or name .... ");

				/** update source for Average Ratings. **/
				if (influencerSurveyVO.getAverageRating() != null) {
				    int startPoint =Integer.parseInt(Double.toString(influencerSurveyVO.getAverageRating()).substring(0, 1));
					int endPoint = startPoint - 1;
					if (startPoint==1) {
						sqlQuery = sqlQuery + IConstant.AVERAGE_RATINGS + " BETWEEN " + endPoint + " AND " + startPoint
								+ " AND ";
					}else {
						Double endvalue=endPoint+0.1;
						sqlQuery = sqlQuery + IConstant.AVERAGE_RATINGS + " BETWEEN " + endvalue + " AND " + startPoint
								+ " AND ";
					}
					
				}

				/** For your_followers_age_brackets **/

				int defaultSearch = 0;

				if (!influencerSurveyVO.getCitiesYourFollowersLocated().isEmpty()) {

					int size = 0;
					defaultSearch++;

					if (!influencerSurveyVO.getCitiesYourFollowersLocated().isEmpty()
							&& influencerSurveyVO.getSearchByCityOrName() != null) {
						sqlQuery = sqlQuery + "((";
					} else
						sqlQuery = sqlQuery + "(";

					for (String s1 : influencerSurveyVO.getCitiesYourFollowersLocated()) {

						if (size != 0) {
							sqlQuery = sqlQuery + " OR    ";

						}
						size++;

						sqlQuery = sqlQuery + IConstant.cities_Followers + " LIKE '%" + s1 + "%'     ";
					}

					sqlQuery = sqlQuery + ")";
					sqlQuery = sqlQuery + " AND ";

				}

				if (influencerSurveyVO.getSearchByCityOrName() != null) {
					defaultSearch++;

					if (defaultSearch == 2) {

						sqlQuery = sqlQuery.substring(0, sqlQuery.length() - 1);
						sqlQuery = sqlQuery.substring(0, sqlQuery.length() - 1);
						sqlQuery = sqlQuery.substring(0, sqlQuery.length() - 1);
						sqlQuery = sqlQuery.substring(0, sqlQuery.length() - 1);

						sqlQuery = sqlQuery + " OR   ";

						if (!influencerSurveyVO.getCitiesYourFollowersLocated().isEmpty()
								&& influencerSurveyVO.getSearchByCityOrName() != null) {

							sqlQuery = sqlQuery + " ( " + IConstant.cities_Followers + " LIKE '%"
									+ influencerSurveyVO.getSearchByCityOrName() + "%'  ) ) AND ";

						} else
							sqlQuery = sqlQuery + " ( " + IConstant.cities_Followers + " LIKE '%"
									+ influencerSurveyVO.getSearchByCityOrName() + "%'  ) AND ";

					}

				}

				if (!influencerSurveyVO.getYourFollowersAgeBrackets().isEmpty()) {

					int size = 0;

					sqlQuery = sqlQuery + "(";

					for (String s1 : influencerSurveyVO.getYourFollowersAgeBrackets()) {

						if (size != 0) {
							sqlQuery = sqlQuery + " OR    ";

						}
						size++;

						sqlQuery = sqlQuery + IConstant.your_followers_age_brackets + " LIKE '%" + s1 + "%'     ";
					}

					sqlQuery = sqlQuery + ")";
					sqlQuery = sqlQuery + " AND ";

				}

				if (!influencerSurveyVO.getTopicYouPost().isEmpty()) {

					int size = 0;

					sqlQuery = sqlQuery + "(";

					for (String s1 : influencerSurveyVO.getTopicYouPost()) {

						if (size != 0) {
							sqlQuery = sqlQuery + " OR    ";

						}
						size++;

						sqlQuery = sqlQuery + IConstant.topic_you_post + " LIKE '%" + s1 + "%'     ";
					}

					sqlQuery = sqlQuery + ")   ";
					sqlQuery = sqlQuery + " AND ";

				}

				
				if (influencerSurveyVO.getTwitterFollowers() != null) {

					sqlQuery = sqlQuery + IConstant.twitter_followers + " = '"
							+ influencerSurveyVO.getTwitterFollowers() + "' " + " AND ";
				}
				if (influencerSurveyVO.getYoutubeFollowers() != null) {

					sqlQuery = sqlQuery + IConstant.youtube_followers + " = '"
							+ influencerSurveyVO.getYoutubeFollowers() + "' " + " AND ";
				}
				if (influencerSurveyVO.getBlogFollowers() != null) {

					sqlQuery = sqlQuery + IConstant.blog_followers + " = '" + influencerSurveyVO.getBlogFollowers()
							+ "' " + " AND ";

				}
				if (influencerSurveyVO.getFacebookFollowers() != null) {

					sqlQuery = sqlQuery + IConstant.facebook_followers + " = '"
							+ influencerSurveyVO.getFacebookFollowers() + "' " + " AND ";

				}
				if (influencerSurveyVO.getInstagramFollowers() != null) {

					sqlQuery = sqlQuery + IConstant.instagram_followers + " = '"
							+ influencerSurveyVO.getInstagramFollowers() + "' " + " AND ";

				}

				sqlQuery = sqlQuery.substring(0, sqlQuery.length() - 1);
				sqlQuery = sqlQuery.substring(0, sqlQuery.length() - 1);
				sqlQuery = sqlQuery.substring(0, sqlQuery.length() - 1);
				sqlQuery = sqlQuery.substring(0, sqlQuery.length() - 1);

				System.out.println("sqlQuery = " + sqlQuery);

				jdbcTemplate = new JdbcTemplate(dataSource);
				templateResult = jdbcTemplate.queryForList(sqlQuery);
				sqlQuery = sqlQuery.substring(12);
				String sqlCountQuery = IConstant.sqlCountQuery;

				sqlCountQuery = sqlCountQuery + sqlQuery;
				Integer totalCount = jdbcTemplate.queryForObject(sqlCountQuery, Integer.class);

				countOfinfluencerSurveyField = new Long(totalCount);

			}

			/**
			 * ==== Chang Response to influencer List ======
			 **/

			if (!templateResult.isEmpty()) {
				List<Object> influencerSurveyIdList = new ArrayList<Object>();

				for (Map<String, Object> mapvalue : templateResult) {

					for (Map.Entry<String, Object> entry : mapvalue.entrySet()) {

						if (entry.getKey().equals("influencer_survey_id")) {

							System.out.println("entry.getKey() =" + entry.getKey());
							influencerSurveyIdList.add(entry.getValue());

						}

					}
				}

				listOfInfluencerSurvey = influencerSurveyRepository.byIdAllDatas(influencerSurveyIdList);

			}

			/** Ending for check list **/

			System.out.println("listOfInfluencerSurvey = " + listOfInfluencerSurvey);
			System.out.println("influencerSurveyList =" + influencerSurveyList);

			if (!influencerSurveyList.isEmpty() || !templateResult.isEmpty()) {

				influencerSurveyMap.put(IConstant.RESPONSE, IConstant.SUCCESS);
				influencerSurveyMap.put(IConstant.MESSAGE, "Search successfully...");
				influencerSurveyMap.put("Total Numbers of Records Founds ", countOfinfluencerSurveyField);

				if (!influencerSurveyList.isEmpty())
					influencerSurveyMap.put(IConstant.OBJECT, influencerSurveyList);
				else
					influencerSurveyMap.put(IConstant.OBJECT, listOfInfluencerSurvey);

			} else {
				influencerSurveyMap.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
				influencerSurveyMap.put(IConstant.MESSAGE, "No any Records exist. ");
				influencerSurveyMap.put("Total Numbers of Records Founds ", 0);
				influencerSurveyMap.put(IConstant.OBJECT, influencerSurveyList);

			}

		} catch (Exception e) {
			e.getMessage();
		}

		return influencerSurveyMap;

	}

	@Override
	public Map<Object, Object> getInfluencerSurveyRecordbyMail(String byEmail) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<InfluencerSurvey> influencerSurveyList = new ArrayList<InfluencerSurvey>();
		if (byEmail != null)
			influencerSurveyList = influencerSurveyRepository.findInfuencerSurveyRecordsbyMail(byEmail);

		try {

			if (influencerSurveyList != null) {
				map.put(IConstant.RESPONSE, IConstant.SUCCESS);
				map.put(IConstant.RESPONSE_LIST, influencerSurveyList);
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

	@Override
	public Map<Object, Object> editInfluencerSurveyRecord(InfluencerSurvey influencerSurvey) {

		Map<Object, Object> map = new HashMap<Object, Object>();

		try {

			InfluencerSurvey inflSurvey = new InfluencerSurvey();

			if (influencerSurvey.getYourEmail() != null) {

				inflSurvey = influencerSurveyRepository
						.findInfuencerSurveyRecordbyMail(influencerSurvey.getYourEmail());
			}

			if (inflSurvey != null) {

				inflSurvey.setBlogFollowers(influencerSurvey.getBlogFollowers());
				inflSurvey.setCitiesYourFollowersLocated(influencerSurvey.getCitiesYourFollowersLocated());
				inflSurvey.setCountriesYourFollowersLocated(influencerSurvey.getCountriesYourFollowersLocated());
				inflSurvey.setFacebookFollowers(influencerSurvey.getFacebookFollowers());
				inflSurvey.setInfl(influencerSurvey.getInfl());
				inflSurvey.setInstagramFollowers(influencerSurvey.getInstagramFollowers());
				inflSurvey.setInterestedInWorkingWithBrands(influencerSurvey.getInterestedInWorkingWithBrands());
				inflSurvey.setNumberOfCatsWillingToFeature(influencerSurvey.getNumberOfCatsWillingToFeature());
				inflSurvey.setNumberOfDogsWillingToFeature(influencerSurvey.getNumberOfDogsWillingToFeature());
				inflSurvey.setNumberOfKids(influencerSurvey.getNumberOfKids());
				inflSurvey.setNumberOfOtherAnimalsWillingToFeature(
						influencerSurvey.getNumberOfOtherAnimalsWillingToFeature());
				inflSurvey.setPercentageOfFemaleFollowers(influencerSurvey.getPercentageOfFemaleFollowers());
				inflSurvey.setPercentageOfMaleFollowers(influencerSurvey.getPercentageOfMaleFollowers());
				inflSurvey.setPercentageOfOtherFollowers(influencerSurvey.getPercentageOfOtherFollowers());
				inflSurvey.setPlatformYouUse(influencerSurvey.getPlatformYouUse());
				inflSurvey.setProvideShortBioForBrands(influencerSurvey.getProvideShortBioForBrands());
				inflSurvey.setSignificantOtherWillingToFeature(influencerSurvey.getSignificantOtherWillingToFeature());
				inflSurvey.setTheirAges(influencerSurvey.getTheirAges());
				inflSurvey.setTopicYouPost(influencerSurvey.getTopicYouPost());
				inflSurvey.setTwitterFollowers(influencerSurvey.getTwitterFollowers());
				inflSurvey.setTypeOfFood(influencerSurvey.getTypeOfFood());
				inflSurvey.setTypeOfRoom(influencerSurvey.getTypeOfRoom());
				inflSurvey.setTypeOfTravel(influencerSurvey.getTypeOfTravel());
				inflSurvey.setYouNeverWorkWithBrands(influencerSurvey.getYouNeverWorkWithBrands());
				inflSurvey.setYourBirthYear(influencerSurvey.getYourBirthYear());
				inflSurvey.setYourFavoriteBrandToWorkWithSoFor(influencerSurvey.getYourFavoriteBrandToWorkWithSoFor());
				inflSurvey.setYourFollowersAgeBrackets(influencerSurvey.getYourFollowersAgeBrackets());
				inflSurvey.setYourGender(influencerSurvey.getYourGender());
				inflSurvey.setYourName(influencerSurvey.getYourName());
				inflSurvey.setYourPhoneNumber(influencerSurvey.getYourPhoneNumber());
				inflSurvey.setYoutubeFollowers(influencerSurvey.getYoutubeFollowers());
				inflSurvey.setFacebookPriceRange(influencerSurvey.getFacebookPriceRange());
				inflSurvey.setInstagramPriceRange(influencerSurvey.getInstagramPriceRange());
				inflSurvey.setTwitterPriceRange(influencerSurvey.getTwitterPriceRange());
				inflSurvey.setYoutubePriceRange(influencerSurvey.getYoutubePriceRange());
				inflSurvey.setBlogPriceRange(influencerSurvey.getBlogPriceRange());
				inflSurvey = influencerSurveyRepository.save(inflSurvey);
				if (inflSurvey != null) {
					map.put(IConstant.RESPONSE, IConstant.SUCCESS);
					map.put(IConstant.RESPONSE_LIST, inflSurvey);
				}

			} else {
				map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
				map.put(IConstant.MESSAGE, "No such Record found by particular " + influencerSurvey.getYourEmail());

			}

		} catch (Exception e) {
			map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
			map.put(IConstant.MESSAGE, "Failed Edit ");
			//e.printStackTrace();
		}
		return map;
	}

}
