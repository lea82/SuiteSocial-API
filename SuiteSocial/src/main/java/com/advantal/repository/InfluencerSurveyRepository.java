package com.advantal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.advantal.model.InfluencerSurvey;

public interface InfluencerSurveyRepository extends JpaRepository<InfluencerSurvey, Long> {

	/*
	 * @Query(value =
	 * "SELECT * FROM influencer_survey i WHERE i.interested_in_working_with_brands=?1 and i.their_ages=?2 and i.countries_your_followers_located=?3"
	 * , nativeQuery = true) InfluencerSurvey findByInfluencerSurvey(String
	 * interestedInWorkingWithBrands, String theirAges, String
	 * countriesYourFollowersLocated);
	 */
	/** 1 influencerSurvey Search by any Single Key **/
	@Query(value = " SELECT *FROM influencer_survey WHERE cities_your_followers_located IN(:searchterm)  OR interested_in_working_with_brands IN(:searchterm) OR their_ages IN(:searchterm)", nativeQuery = true)
	List<InfluencerSurvey> searchInfluencerSurveyByAnyField(@Param(value = "searchterm") List<String> searchterm);

	@Query(value = " SELECT COUNT(*) FROM influencer_survey WHERE cities_your_followers_located IN(:searchterm)  OR interested_in_working_with_brands IN(:searchterm) OR their_ages IN(:searchterm)", nativeQuery = true)
	Long countSearchInfluencerSurveyByAnyField(@Param(value = "searchterm") List<String> searchterm);

	/** no need to keep cases: **/
	/** Pass by list **/
	@Query(value = " SELECT *FROM influencer_survey WHERE cities_your_followers_located IN(:searchterm)", nativeQuery = true)
	List<InfluencerSurvey> findInfluencerSurveyByCitiesFollower(@Param(value = "searchterm") List<String> searchterm);

	@Query(value = " SELECT COUNT(*) FROM influencer_survey WHERE cities_your_followers_located IN(:searchterm) ", nativeQuery = true)
	Long countInfluencerSurveyByCitiesFollower(@Param(value = "searchterm") List<String> searchterm);

	@Query(value = " SELECT *FROM influencer_survey WHERE interested_in_working_with_brands = :interestedInWorkingWithBrands", nativeQuery = true)
	List<InfluencerSurvey> searchForInterestedInWorkingWithBrands(String interestedInWorkingWithBrands);

	@Query(value = " SELECT COUNT(*) FROM influencer_survey WHERE interested_in_working_with_brands = :interestedInWorkingWithBrands", nativeQuery = true)
	Long countForInterestedInWorkingWithBrands(String interestedInWorkingWithBrands);

	@Query(value = " SELECT *FROM influencer_survey WHERE their_ages = :theirAges", nativeQuery = true)
	List<InfluencerSurvey> searchForTheirAges(String theirAges);

	@Query(value = " SELECT COUNT(*) FROM influencer_survey WHERE their_ages = :theirAges", nativeQuery = true)
	Long countSearchForTheirAges(String theirAges);

	/*
	 * @Query(value =
	 * " SELECT *FROM influencer_survey WHERE cities_your_followers_located IN(:overAllDefaultSearch)  OR your_name  IN(:overAllDefaultSearch)"
	 * , nativeQuery = true) List<InfluencerSurvey>
	 * findByOverallSearchkey(List<String> overAllDefaultSearch);
	 */
	/*
	 * @Query(value =
	 * " SELECT COUNT(*) FROM influencer_survey WHERE cities_your_followers_located IN(:searchByCityOrName)  OR your_name  IN(:searchByCityOrName)"
	 * , nativeQuery = true) Long countSearchByOverallSearchkey(List<String>
	 * searchByCityOrName);
	 */

	@Query(value = " SELECT *FROM influencer_survey WHERE  cities_your_followers_located = :searchByCityOrName  OR your_name = :searchByCityOrName", nativeQuery = true)
	List<InfluencerSurvey> findByOverallSearchkey(String searchByCityOrName);

	@Query(value = " SELECT COUNT(*) FROM influencer_survey WHERE cities_your_followers_located = :searchByCityOrName  OR your_name = :searchByCityOrName", nativeQuery = true)
	Long countSearchByOverallSearchkey(String searchByCityOrName);

	@Query(value = " SELECT *FROM influencer_survey WHERE influencer_survey_id IN(:influencerSurveyIdList) ", nativeQuery = true)
	List<InfluencerSurvey> byIdAllDatas(List<Object> influencerSurveyIdList);
	
	@Query(value = " FROM InfluencerSurvey WHERE yourEmail= :byEmail   ")
	List<InfluencerSurvey> findInfuencerSurveyRecordsbyMail(String byEmail);

	@Query(value = " SELECT *FROM influencer_survey WHERE your_email = :byEmail ", nativeQuery = true)
	InfluencerSurvey findInfuencerSurveyRecordbyMail(String byEmail);


}
