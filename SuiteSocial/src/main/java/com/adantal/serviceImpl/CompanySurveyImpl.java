package com.adantal.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.adantal.vo.CompanySurveyVO;
import com.advantal.model.CompanySurvey;
import com.advantal.model.Organization;
import com.advantal.repository.CompanySurveyRepository;
import com.advantal.repository.OrganizationRepository;
import com.advantal.service.CompanySurveyService;
import com.advantal.util.IConstant;

@Service
public class CompanySurveyImpl implements CompanySurveyService {

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	private CompanySurveyRepository companySurveyRepository;
	
	@Autowired
	private OrganizationRepository organizationRepository;
	

	@Override
	public List<CompanySurvey> findAllCompanySurvey() {

		return companySurveyRepository.findAll();
	}

	@Override
	public CompanySurvey saveSurveyDetail(CompanySurvey companySurvey) {

		CompanySurvey companySurveySave = new CompanySurvey();

		companySurveySave = companySurveyRepository.save(companySurvey);

		if (companySurveySave != null) {
			Organization org = organizationRepository
					.findByOrganzationId(companySurveySave.getOrg().getOrganzationId());
			org.setSurveyCompleted(true);
			organizationRepository.save(org);
		}
		return companySurveySave;
	}

	@Override
	public Map<Object, Object> searchByCmnyCriteria(CompanySurveyVO companySurveyVO) {
		Map<Object, Object> companySurveyMap = new HashMap<Object, Object>();
		List<CompanySurvey> companySurveyList = new ArrayList<CompanySurvey>();
		List<Map<String, Object>> templateResult = new ArrayList<Map<String, Object>>();

		List<CompanySurvey> listOfCmnySurvey = new ArrayList<CompanySurvey>();

		String sqlQuery = IConstant.sqlQueryForcompanySurvey;
		Long countOfinfluencerSurveyField = 0l;

		try {

			/** Default call **/

			if (companySurveyVO.getProductCategory().isEmpty() && companySurveyVO.getYourcompanyName() == null
					&& companySurveyVO.getOverallBudget() == null) {
				System.out.println(" For default .... ");

				companySurveyList = companySurveyRepository.findAll();
				countOfinfluencerSurveyField = companySurveyRepository.count();

			}

			/** 1 companySurvey Search for Single key search for company name **/

			if (companySurveyVO.getProductCategory().isEmpty() && companySurveyVO.getYourcompanyName() != null
					&& companySurveyVO.getOverallBudget() == null) {
				System.out.println("for Single key search .... ");
				companySurveyList = companySurveyRepository
						.findByOverallSearchkey(companySurveyVO.getYourcompanyName());
				countOfinfluencerSurveyField = companySurveyRepository
						.countSearchByOverallSearchkey(companySurveyVO.getYourcompanyName());
			}

			if (!companySurveyVO.getProductCategory().isEmpty() || companySurveyVO.getOverallBudget() != null) {

				if (!companySurveyVO.getProductCategory().isEmpty()) {

					int size = 0;

					sqlQuery = sqlQuery + "(";

					for (String s1 : companySurveyVO.getProductCategory()) {

						if (size != 0) {
							sqlQuery = sqlQuery + " OR    ";

						}
						size++;

						sqlQuery = sqlQuery + IConstant.product_category + " LIKE '%" + s1 + "%'     ";
					}

					sqlQuery = sqlQuery + ")";
					sqlQuery = sqlQuery + " AND ";

				}

				if (companySurveyVO.getYourcompanyName() != null) {

					sqlQuery = sqlQuery + IConstant.your_company_name + " = '" + companySurveyVO.getYourcompanyName()
							+ "' " + " AND ";
				}

				if (companySurveyVO.getOverallBudget() != null) {
					System.out.println("exist getOverallBudget=");

					sqlQuery = sqlQuery + IConstant.over_all_budget + " BETWEEN 0 AND "
							+ companySurveyVO.getOverallBudget() + " AND ";
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

				System.out.println("templateResult = " + templateResult);

			}

			if (!templateResult.isEmpty()) {

				List<Object> cmySurveyIdsList = new ArrayList<Object>();

				for (Map<String, Object> mapvalue : templateResult) {

					for (Map.Entry<String, Object> entry : mapvalue.entrySet()) {

						if (entry.getKey().equals("company_survey_id")) {

							System.out.println("entry.getKey() =" + entry.getKey());
							cmySurveyIdsList.add(entry.getValue());

						}

					}
				}

				System.out.println("cmySurveyIdsList = " + cmySurveyIdsList);
				listOfCmnySurvey = companySurveyRepository.byIdAllDatas(cmySurveyIdsList);

			}

			if (!companySurveyList.isEmpty() || !templateResult.isEmpty()) {

				companySurveyMap.put(IConstant.RESPONSE, IConstant.SUCCESS);
				companySurveyMap.put(IConstant.MESSAGE, "Search successfully...");
				companySurveyMap.put("Total Numbers of Records Founds ", countOfinfluencerSurveyField);

				if (!companySurveyList.isEmpty())
					companySurveyMap.put(IConstant.OBJECT, companySurveyList);
				else
					companySurveyMap.put(IConstant.OBJECT, listOfCmnySurvey);

			} else {
				companySurveyMap.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
				companySurveyMap.put(IConstant.MESSAGE, "No any Records exist. ");
				companySurveyMap.put("Total Numbers of Records Founds ", 0);
				companySurveyMap.put(IConstant.OBJECT, companySurveyList);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return companySurveyMap;
	}

}
