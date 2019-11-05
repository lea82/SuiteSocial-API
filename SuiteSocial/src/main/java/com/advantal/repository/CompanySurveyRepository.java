package com.advantal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.advantal.model.CompanySurvey;

public interface CompanySurveyRepository extends JpaRepository<CompanySurvey, Long> {

	@Query(value = " SELECT *FROM company_survey WHERE `your_company_name`= :overAllDefaultSearch  OR over_all_budget =:overAllDefaultSearch OR `product_category` IN (:overAllDefaultSearch) ", nativeQuery = true)
	List<CompanySurvey> findByOverallSearchkey(String overAllDefaultSearch);

	@Query(value = " SELECT COUNT(*) FROM company_survey WHERE `your_company_name`= :overAllDefaultSearch  OR over_all_budget =:overAllDefaultSearch OR `product_category` IN (:overAllDefaultSearch) ", nativeQuery = true)
	Long countSearchByOverallSearchkey(String overAllDefaultSearch);

	@Query(value = " SELECT *FROM company_survey WHERE company_survey_id IN(:cmnySurveyIdsList) ", nativeQuery = true)
	List<CompanySurvey> byIdAllDatas(List<Object> cmnySurveyIdsList);

	

}
