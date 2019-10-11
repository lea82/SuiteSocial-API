package com.advantal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="influencer_survey")
public class InfluencerSurvey {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="influencer_survey_id")
	private Long influencersurveyId;
	
	//What is your name?
	@Column(name="your_name")
	private String yourName;
	
	//What is your email?
	@Column(name="your_email")
	private String yourEmail;
	
	//What is your age?
	@Column(name="your_age")
	private Integer yourAge;
	
	//What is your gender?
	@Column(name="your_gender")
	private String yourGender;
	
	//Which platforms do you use?
	@Column(name="which_platforms")
	private String whichPlatforms; 
	
	//What topics do you post most about? Choose up to three. Beauty Food Fashion Sports/Fitness Health/Wellness Kids Pets Travel Families 
	//Cars CPG Leisure Other
    @Column(name="topic_you_post")
	private String topicYouPost;
	
	//Top 3 countries your followers are located in?
	@Column(name="countries_your_followers_located")
	private String countriesyourFollowerslocated;
	
	//Top 3 cities your followers are located in?
	@Column(name="cities_your_Followers_located")
	private String citiesyourFollowerslocated;
	
	//Which age brackets are your followers in? Please select 2. Under 20 20-30 30-40 Over 40
	@Column(name="your_followers_age_brackets")
	private String yourFollowersAgeBrackets;
	
	//What percentage of your followers are Male vs. Female vs. Other.
	//Male
	//Female
	//Other
	@Column(name="percentage_of_your_followers")
	private String percentageOfYourFollowers;
	
	//How many kids do you have that you would be willing to feature?
	@Column(name="number_of_kids")
	private Integer numberOfKids;
	
	//What are their ages? Please separate ages by commas. Leave empty if 0 kids.
	@Column(name="their_ages")
	private Integer theirAges;
	
	//Do you have any pets that you would be willing to feature?
	//Number of dogs:
	//Number of cats:
	//Number of other animals:
	@Column(name="any_pets_willing_to_feature")
	private String anyPetsWillingToFeature;
	
	//Do you have a significant other that is willing to be featured on your page? Yes No
	@Column(name="significant_other_willing_to_feature")
	private String significantOtherWillingToFeature;
	
	//What types of travel would you be interested in? Choose any many as apply. Family 
	//Romance Adventure Solo Experiential
	@Column(name="type_of_travel")
	private String typeOfTravel;
	
	//What type of room do you prefer?
	//Double Queen King
	@Column(name="type_of_room")
	private String typeOfRoom;
	
	//Which brands would you be interested in working with?
	@Column(name="interested_in_working_with_brands")
	private String interestedInWorkingWithBrands;
	
	//Which brands would you never work with?
	@Column(name="you_never_work_with_brands")
	private String youNeverWorkWithBrands;
	
	//Please provide a short bio for brands.
	@Column(name="provide_short_bio_for_brands")
	private String provideShortBioForBrands;
	
	//What has been your favorite brand to work with so far and why?
	@Column(name="your_favorite_brand_to_work_with_so_for")
	private String yourFavoriteBrandToWorkWithSoFor;
    
	//less than 1k, 1k-2k, 2k-5k, 5k-10k, more than 10k
	@Column(name="facebook_followers")
	private String facebookFollowers;
	
	//less than 1k, 1k-2k, 2k-5k, 5k-10k, more than 10k
	@Column(name="instagram_followers")
	private String instagramFollowers;
	
	//less than 1k, 1k-2k, 2k-5k, 5k-10k, more than 10k
	@Column(name="twitter_followers")
	private String twitterFollowers;
	
	//less than 1k, 1k-2k, 2k-5k, 5k-10k, more than 10k
	@Column(name="youtube_followers")
	private String youtubeFollowers;
	
	//less than 1k, 1k-2k, 2k-5k, 5k-10k, more than 10k
	@Column(name="gmail_followers")
	private String gmailFollowers;
	
	@ManyToOne
	private Influencer infl;
	
	public InfluencerSurvey() {
		super();
	}

	


	public InfluencerSurvey(Long influencersurveyId, String yourName, String yourEmail, Integer yourAge,
			String yourGender, String whichPlatforms, String topicYouPost, String countriesyourFollowerslocated,
			String citiesyourFollowerslocated, String yourFollowersAgeBrackets, String percentageOfYourFollowers,
			Integer numberOfKids, Integer theirAges, String anyPetsWillingToFeature,
			String significantOtherWillingToFeature, String typeOfTravel, String typeOfRoom,
			String interestedInWorkingWithBrands, String youNeverWorkWithBrands, String provideShortBioForBrands,
			String yourFavoriteBrandToWorkWithSoFor, String facebookFollowers, String instagramFollowers,
			String twitterFollowers, String youtubeFollowers, String gmailFollowers) {
		super();
		this.influencersurveyId = influencersurveyId;
		this.yourName = yourName;
		this.yourEmail = yourEmail;
		this.yourAge = yourAge;
		this.yourGender = yourGender;
		this.whichPlatforms = whichPlatforms;
		this.topicYouPost = topicYouPost;
		this.countriesyourFollowerslocated = countriesyourFollowerslocated;
		this.citiesyourFollowerslocated = citiesyourFollowerslocated;
		this.yourFollowersAgeBrackets = yourFollowersAgeBrackets;
		this.percentageOfYourFollowers = percentageOfYourFollowers;
		this.numberOfKids = numberOfKids;
		this.theirAges = theirAges;
		this.anyPetsWillingToFeature = anyPetsWillingToFeature;
		this.significantOtherWillingToFeature = significantOtherWillingToFeature;
		this.typeOfTravel = typeOfTravel;
		this.typeOfRoom = typeOfRoom;
		this.interestedInWorkingWithBrands = interestedInWorkingWithBrands;
		this.youNeverWorkWithBrands = youNeverWorkWithBrands;
		this.provideShortBioForBrands = provideShortBioForBrands;
		this.yourFavoriteBrandToWorkWithSoFor = yourFavoriteBrandToWorkWithSoFor;
		this.facebookFollowers = facebookFollowers;
		this.instagramFollowers = instagramFollowers;
		this.twitterFollowers = twitterFollowers;
		this.youtubeFollowers = youtubeFollowers;
		this.gmailFollowers = gmailFollowers;
	}

    
	public Influencer getInfl() {
		return infl;
	}




	public void setInfl(Influencer infl) {
		this.infl = infl;
	}




	public Long getInfluencersurveyId() {
		return influencersurveyId;
	}

	public void setInfluencersurveyId(Long influencersurveyId) {
		this.influencersurveyId = influencersurveyId;
	}

	public String getYourName() {
		return yourName;
	}

	public void setYourName(String yourName) {
		this.yourName = yourName;
	}

	public String getYourEmail() {
		return yourEmail;
	}

	public void setYourEmail(String yourEmail) {
		this.yourEmail = yourEmail;
	}

	public Integer getYourAge() {
		return yourAge;
	}

	public void setYourAge(Integer yourAge) {
		this.yourAge = yourAge;
	}

	public String getYourGender() {
		return yourGender;
	}

	public void setYourGender(String yourGender) {
		this.yourGender = yourGender;
	}

	public String getWhichPlatforms() {
		return whichPlatforms;
	}

	public void setWhichPlatforms(String whichPlatforms) {
		this.whichPlatforms = whichPlatforms;
	}

	public String getTopicYouPost() {
		return topicYouPost;
	}

	public void setTopicYouPost(String topicYouPost) {
		this.topicYouPost = topicYouPost;
	}

	public String getCountriesyourFollowerslocated() {
		return countriesyourFollowerslocated;
	}

	public void setCountriesyourFollowerslocated(String countriesyourFollowerslocated) {
		this.countriesyourFollowerslocated = countriesyourFollowerslocated;
	}

	public String getCitiesyourFollowerslocated() {
		return citiesyourFollowerslocated;
	}

	public void setCitiesyourFollowerslocated(String citiesyourFollowerslocated) {
		this.citiesyourFollowerslocated = citiesyourFollowerslocated;
	}

	
	public String getYourFollowersAgeBrackets() {
		return yourFollowersAgeBrackets;
	}




	public void setYourFollowersAgeBrackets(String yourFollowersAgeBrackets) {
		this.yourFollowersAgeBrackets = yourFollowersAgeBrackets;
	}




	public String getFacebookFollowers() {
		return facebookFollowers;
	}




	public void setFacebookFollowers(String facebookFollowers) {
		this.facebookFollowers = facebookFollowers;
	}




	public String getInstagramFollowers() {
		return instagramFollowers;
	}




	public void setInstagramFollowers(String instagramFollowers) {
		this.instagramFollowers = instagramFollowers;
	}




	public String getTwitterFollowers() {
		return twitterFollowers;
	}




	public void setTwitterFollowers(String twitterFollowers) {
		this.twitterFollowers = twitterFollowers;
	}




	public String getYoutubeFollowers() {
		return youtubeFollowers;
	}




	public void setYoutubeFollowers(String youtubeFollowers) {
		this.youtubeFollowers = youtubeFollowers;
	}




	public String getGmailFollowers() {
		return gmailFollowers;
	}




	public void setGmailFollowers(String gmailFollowers) {
		this.gmailFollowers = gmailFollowers;
	}




	public String getPercentageOfYourFollowers() {
		return percentageOfYourFollowers;
	}

	public void setPercentageOfYourFollowers(String percentageOfYourFollowers) {
		this.percentageOfYourFollowers = percentageOfYourFollowers;
	}

	public Integer getNumberOfKids() {
		return numberOfKids;
	}

	public void setNumberOfKids(Integer numberOfKids) {
		this.numberOfKids = numberOfKids;
	}

	public Integer getTheirAges() {
		return theirAges;
	}

	public void setTheirAges(Integer theirAges) {
		this.theirAges = theirAges;
	}

	public String getAnyPetsWillingToFeature() {
		return anyPetsWillingToFeature;
	}

	public void setAnyPetsWillingToFeature(String anyPetsWillingToFeature) {
		this.anyPetsWillingToFeature = anyPetsWillingToFeature;
	}

	public String getSignificantOtherWillingToFeature() {
		return significantOtherWillingToFeature;
	}

	public void setSignificantOtherWillingToFeature(String significantOtherWillingToFeature) {
		this.significantOtherWillingToFeature = significantOtherWillingToFeature;
	}

	public String getTypeOfTravel() {
		return typeOfTravel;
	}

	public void setTypeOfTravel(String typeOfTravel) {
		this.typeOfTravel = typeOfTravel;
	}

	public String getTypeOfRoom() {
		return typeOfRoom;
	}

	public void setTypeOfRoom(String typeOfRoom) {
		this.typeOfRoom = typeOfRoom;
	}

	public String getInterestedInWorkingWithBrands() {
		return interestedInWorkingWithBrands;
	}

	public void setInterestedInWorkingWithBrands(String interestedInWorkingWithBrands) {
		this.interestedInWorkingWithBrands = interestedInWorkingWithBrands;
	}

	public String getYouNeverWorkWithBrands() {
		return youNeverWorkWithBrands;
	}

	public void setYouNeverWorkWithBrands(String youNeverWorkWithBrands) {
		this.youNeverWorkWithBrands = youNeverWorkWithBrands;
	}

	public String getProvideShortBioForBrands() {
		return provideShortBioForBrands;
	}

	public void setProvideShortBioForBrands(String provideShortBioForBrands) {
		this.provideShortBioForBrands = provideShortBioForBrands;
	}

	public String getYourFavoriteBrandToWorkWithSoFor() {
		return yourFavoriteBrandToWorkWithSoFor;
	}

	public void setYourFavoriteBrandToWorkWithSoFor(String yourFavoriteBrandToWorkWithSoFor) {
		this.yourFavoriteBrandToWorkWithSoFor = yourFavoriteBrandToWorkWithSoFor;
	}
	
}
