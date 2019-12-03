package com.advantal.util;

public class IConstant {

	public static final int OTP_VERIFIED = 2;
	public static final int PASSWORD_SAVED = 3;
	public static final String RESPONSE = "response";
	public static final String USER_CREATION_RESPONSE = "UserCreationResponse";
	public static final String MESSAGE = "message";
	public static final String MESSAGEE = "messagewwww";

	public static final String IMG = "https://shieldcrypt.com:7384/SuiteSocial_Img/";

	//public static final String POSTCAMPAIGN_FILE_PATH="/home/apache9/webapps/SuiteSocial_Img/";
	public static final String POSTCAMPAIGN_FILE_PATH = "F://picSocialSuite//";
	public static final String SUCCESS = "200";
	public static final String ORGANIZAION_CREATED_SUCCESS_MESSAGE = "Organization Created successfully";
	public static final String USER_CREATION_RESPONSE_CODE = "201";
	public static final String INTERNAL_SERVER_ERROR = "500";

	public static final String NOT_AUTHORIZED = "401";

	public static final String STATUS = "status";
	public static final String EMPTY_LIST_MESSAGE = "list empty";
	public static final String OBJECT = "object";
	public static final String LIST = "list empty";
	public static final String SUCCESS_MESSAGE = "Successfully saved.";
	public static final String COMPANYSURVEY_ERROR_MESSAGE = "Error in create CompanyServey";
	public static final String INFLUENCER_SURVEY_ERROR_MESSAGE = "Error in create InfluencerServey";
	public static final String INFLUENCER_CREATED_SUCCESS_MESSAGE = "Influencer Created successfully";
	public static final String INFLUENCER_ERROR_MESSAGE = "Error in create Influencer";
	public static final String INFLUENCER_SOCIAL_CREATED_SUCCESS_MESSAGE = "Social Influencer Created successfully";
	public static final String INFLUENCER_SOCIAL_ERROR_MESSAGE = "Error in creation Social Influencer";
	public static final String RESPONSE_LIST = "list";
	public static final String RESPONSE_COUNT = "count";
	public static final String EMPTY_LIST = "empty";
	public static final int ONE = 1;
	public static final String ORGANIZATION = "organization";
	public static final String NOT_REGISTERED = "This organization name not registered. Please register organization";
	public static final String ORGANIZATION_ERROR_MESSAGE = "Error in create orgnization";
	public static final String ORGANIZAION_VERIFY_MESSAGE = "This organization name already exist.";
	public static final int ZERO = 0;
	public static final String USER_LOGIN_SUCCESS_MESSAGE = "Welcome, You're successfully logged in";
	public static final String USER_LOGIN_ERROR_MESSAGE = "Sorry, Please check your email or password incorrect.";
	public static final String ORGANIZATION_EMAIL_ID = "organizationEmail";
	public static final String INFLUNCER_EMAIL_ID = "influncerEmail";
	public static final String ORGANIZATION_USER_ID = "userId";

	public static final String INFLUENCER_USERID = "influencerUserId";
	public static final String EMAIL_EXIST = "Email already exist";
	public static final String ERROR_MESSAGE = "errormessage";
	public static final String NOT_SAVED = "Record not saved";
	public static final String VERIFY_STATUS = "verifyStatus";
	public static final String LOCAL_HOST_URL = "http://localhost:8080";

	public static final String EMAIL_VERIFICATION_MESSAGE = "Your Verification Otp is";
	public static final String EMAIL_SUBJECT_MESSAGE = "Social Suite Verification";
	public static final String FORGOT_EMAIL_SUBJECT_MESSAGE = "Social Suite Forgot Password";

	public static final String EMAIL_OTP = "emailOtp";

	public static final String VERIFY_SUCCESS_MESSAGE = "Otp Verification Successfully";

	public static final String VERIFY_ERROR_MESSAGE = " please Enter Correct Otp ";
	public static final String OTP_SEND_SUCCESS_MESSAGE = "A one time unique code has been sent your registered email";
	public static final String OTP_SEND_ERROR_MESSAGE = "Please enter correct emailId";
	public static final String USER_TYPE = "userType";
	public static final String USERLOGIN_TYPE = "influencer";
	public static final Object FORGOT_PASSWORD_SUCCESS_MESSAGE = "Forgot Password link has been sent to the registered email Id";
	public static final Object FORGOT_PASSWORD_ERROR_MESSAGE = "Error in  forgot Password";

	public static final String PASSWORD_CHANGE_SUCCESS_MESSAGE = "Password changed successfully";
	public static final String PASSWORD_FARGOT_SUCCESS_MESSAGE = "Password reset successful";
	public static final String PASSWORD_CHANGE_ERROR_MESSAGE = "Please try again";
	public static final String PASSWORD_FARGOT_ERROR_MESSAGE = "Please try again";
	public static final String ORGANIZATION_ALREADY_MESSAGE = "Email Id already exist";
	public static final String INFLUENCER_ALREADY_MESSAGE = "Email Id already exist";
	public static final String SURVEY_VERIFIED = "isServeyCompleted";
	public static final String IS_OTP_VERIFIED = "isOtpVerified";
	public static final String USER_ERROR_MESSAGE = "Otp not verified";
	public static final String EMAIL_EXIST_ERROR_MESSAGE = "Email Id and Password does not exist";
	public static final String POSTCAMPAIGN_EXIST_MESSAGE = "Post Campaign Already exist message";
	public static final String POSTCAMPAIGN_CREATED_SUCCESS_MESSAGE = "Post Campaign Created successfully";
	public static final String POSTCAMPAIGN_ERROR_MESSAGE = "Error in create Post Campaign";
	public static final String ERROR_MESSAGEE = "Please try again";

	public static String sqlQuery = "SELECT *FROM influencer_survey WHERE ";

	public static String sqlCountQuery = "SELECT COUNT(*) FROM ";

	public static String sqlQuerycountforDefault = "SELECT COUNT(*) FROM ";

	/**
	 * cities_your_Followers_located, blog_followers,facebook_followers,
	 * instagram_followers , twitter_followers, youtube_followers
	 **/

	public static final String cities_Followers = "cities_your_Followers_located";
	public static final String interested_in_working_with_brands = "interested_in_working_with_brands";
	public static final String their_ages = "their_ages";
	public static final String blog_followers = "blog_followers";
	public static final String facebook_followers = "facebook_followers";
	public static final String instagram_followers = "instagram_followers";
	public static final String twitter_followers = "twitter_followers";
	public static final String youtube_followers = "youtube_followers";
	public static final String AVERAGE_RATINGS = "average_rating";
	
	
	

	public static String sqlQueryForcompanySurvey = "SELECT *FROM company_survey WHERE ";
	public static String countSQLQueryForCompanySurvey = "SELECT COUNT(*) FROM ";

	public static final String product_category = "product_category";
	public static final String your_company_name = "your_company_name";
	public static final String over_all_budget = "over_all_budget";

	public static final String your_followers_age_brackets = "your_followers_age_brackets";
	public static final String topic_you_post = "topic_you_post";

	public static final String cmpany_Survey = "company_survey";
	public static final String influencer_survey = "influencer_survey";

	public static final String your_name = "your_name";
	public static final String RECORED_fOUND_SUCCESSFULLY = "Record found successfully. ";
	public static final String RECORED_NOT_fOUND = "Record not found. ";
}