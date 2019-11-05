package com.adantal.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.advantal.model.Influencer;

public class InfluencerSurveyVO {

	@XmlElement(name = "influencer_survey_id")
	private Long influencersurveyId;

	// What is your name?
	@XmlElement(name = "your_name")
	private String yourName;

	// What is your email?
	@XmlElement(name = "your_email")
	private String yourEmail;

	// What is your phone number?
	@XmlElement(name = "your_phone_number")
	private String yourPhoneNumber;

	// What is your age?
	@XmlElement(name = "your_birth_year")
	private String yourBirthYear;

	// What is your gender?
	@XmlElement(name = "your_gender")
	private String yourGender;

	// Which platforms do you use?
	@XmlElement(name = "platform_you_use")
	private String platformYouUse;

	// What topics do you post most about? Choose up to
	// three. Beauty Food Fashion Sports/Fitness Health/Wellness Kids Pets Travel Families 
	// Cars CPG Leisure Other
	@XmlElement(name = "topic_you_post")
	private List<String> topicYouPost;

	// Top 3 countries your followers are located in?
	@XmlElement(name = "countries_your_followers_located")
	private String countriesYourFollowersLocated;

	// Top 3 cities your followers are located in?
	@XmlElement(name = "cities_your_Followers_located")
	private List<String> citiesYourFollowersLocated;

	// Which age brackets are your followers in? Please select 2. Under
	// 20 20-30 30-40 Over 40
	@XmlElement(name = "your_followers_age_brackets")
	private List<String> yourFollowersAgeBrackets;

	// What percentage of your followers are Male vs. Female vs. Other.
	@XmlElement(name = "percentage_of_male_followers")
	private String percentageOfMaleFollowers;

	@XmlElement(name = "percentage_of_female_followers")
	private String percentageOfFemaleFollowers;

	@XmlElement(name = "percentage_of_other_followers")
	private String percentageOfOtherFollowers;

	// How many kids do you have that you would be willing to feature?
	@XmlElement(name = "number_of_kids")
	private String numberOfKids;

	// What are their ages? Please separate ages by commas. Leave empty if 0 kids.
	@XmlElement(name = "their_ages")
	private String theirAges;

	@XmlElement(name = "no_of_dogs_willing_to_feature")
	private String numberOfDogsWillingToFeature;

	@XmlElement(name = "no_of_cats_willing_to_feature")
	private String numberOfCatsWillingToFeature;

	@XmlElement(name = "no_of_other_animals_willing_to_feature")
	private String numberOfOtherAnimalsWillingToFeature;

	// Do you have a significant other that is willing to be featured on your
	// page? Yes No
	@XmlElement(name = "significant_other_willing_to_feature")
	private String significantOtherWillingToFeature;

	// What types of travel would you be interested in? Choose any many as
	// apply. Family 
	// Romance Adventure Solo Experiential
	@XmlElement(name = "type_of_travel")
	private String typeOfTravel;

	// What type of room do you prefer?
	// Double Queen King
	@XmlElement(name = "type_of_room")
	private String typeOfRoom;

	// What kind of food/drinks do you like? Choose any many as apply.
	@XmlElement(name = "type_of_food")
	private String typeOfFood;

	// Which brands would you be interested in working with?
	@XmlElement(name = "interested_in_working_with_brands")
	private String interestedInWorkingWithBrands;

	// Which brands would you never work with?
	@XmlElement(name = "you_never_work_with_brands")
	private String youNeverWorkWithBrands;

	// Please provide a short bio for brands.
	@XmlElement(name = "provide_short_bio_for_brands")
	private String provideShortBioForBrands;

	// What has been your favorite brand to work with so far and why?
	@XmlElement(name = "your_favorite_brand_to_work_with_so_for")
	private String yourFavoriteBrandToWorkWithSoFor;

	// <2k 2k – 5k 5k – 10k 10k – 20k 20k – 100k > 100k
	@XmlElement(name = "facebook_followers")
	private String facebookFollowers;

	// <2k 2k – 5k 5k – 10k 10k – 20k 20k – 100k > 100k
	@XmlElement(name = "instagram_followers")
	private String instagramFollowers;

	// <2k 2k – 5k 5k – 10k 10k – 20k 20k – 100k > 100k
	@XmlElement(name = "twitter_followers")
	private String twitterFollowers;

	// <2k 2k – 5k 5k – 10k 10k – 20k 20k – 100k > 100k
	@XmlElement(name = "youtube_followers")
	private String youtubeFollowers;

	// <2k 2k – 5k 5k – 10k 10k – 20k 20k – 100k > 100k
	@XmlElement(name = "blog_followers")
	private String blogFollowers;

	private Influencer infl;

	@XmlElement(name = "search_By_City_Or_Name")
	private String searchByCityOrName;

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

	public String getYourPhoneNumber() {
		return yourPhoneNumber;
	}

	public void setYourPhoneNumber(String yourPhoneNumber) {
		this.yourPhoneNumber = yourPhoneNumber;
	}

	public String getYourBirthYear() {
		return yourBirthYear;
	}

	public void setYourBirthYear(String yourBirthYear) {
		this.yourBirthYear = yourBirthYear;
	}

	public String getYourGender() {
		return yourGender;
	}

	public void setYourGender(String yourGender) {
		this.yourGender = yourGender;
	}

	public String getPlatformYouUse() {
		return platformYouUse;
	}

	public void setPlatformYouUse(String platformYouUse) {
		this.platformYouUse = platformYouUse;
	}

	public List<String> getTopicYouPost() {
		return topicYouPost;
	}

	public void setTopicYouPost(List<String> topicYouPost) {
		this.topicYouPost = topicYouPost;
	}

	public String getCountriesYourFollowersLocated() {
		return countriesYourFollowersLocated;
	}

	public void setCountriesYourFollowersLocated(String countriesYourFollowersLocated) {
		this.countriesYourFollowersLocated = countriesYourFollowersLocated;
	}

	public List<String> getCitiesYourFollowersLocated() {
		return citiesYourFollowersLocated;
	}

	public void setCitiesYourFollowersLocated(List<String> citiesYourFollowersLocated) {
		this.citiesYourFollowersLocated = citiesYourFollowersLocated;
	}

	public List<String> getYourFollowersAgeBrackets() {
		return yourFollowersAgeBrackets;
	}

	public void setYourFollowersAgeBrackets(List<String> yourFollowersAgeBrackets) {
		this.yourFollowersAgeBrackets = yourFollowersAgeBrackets;
	}

	public String getPercentageOfMaleFollowers() {
		return percentageOfMaleFollowers;
	}

	public void setPercentageOfMaleFollowers(String percentageOfMaleFollowers) {
		this.percentageOfMaleFollowers = percentageOfMaleFollowers;
	}

	public String getPercentageOfFemaleFollowers() {
		return percentageOfFemaleFollowers;
	}

	public void setPercentageOfFemaleFollowers(String percentageOfFemaleFollowers) {
		this.percentageOfFemaleFollowers = percentageOfFemaleFollowers;
	}

	public String getPercentageOfOtherFollowers() {
		return percentageOfOtherFollowers;
	}

	public void setPercentageOfOtherFollowers(String percentageOfOtherFollowers) {
		this.percentageOfOtherFollowers = percentageOfOtherFollowers;
	}

	public String getNumberOfKids() {
		return numberOfKids;
	}

	public void setNumberOfKids(String numberOfKids) {
		this.numberOfKids = numberOfKids;
	}

	public String getTheirAges() {
		return theirAges;
	}

	public void setTheirAges(String theirAges) {
		this.theirAges = theirAges;
	}

	public String getNumberOfDogsWillingToFeature() {
		return numberOfDogsWillingToFeature;
	}

	public void setNumberOfDogsWillingToFeature(String numberOfDogsWillingToFeature) {
		this.numberOfDogsWillingToFeature = numberOfDogsWillingToFeature;
	}

	public String getNumberOfCatsWillingToFeature() {
		return numberOfCatsWillingToFeature;
	}

	public void setNumberOfCatsWillingToFeature(String numberOfCatsWillingToFeature) {
		this.numberOfCatsWillingToFeature = numberOfCatsWillingToFeature;
	}

	public String getNumberOfOtherAnimalsWillingToFeature() {
		return numberOfOtherAnimalsWillingToFeature;
	}

	public void setNumberOfOtherAnimalsWillingToFeature(String numberOfOtherAnimalsWillingToFeature) {
		this.numberOfOtherAnimalsWillingToFeature = numberOfOtherAnimalsWillingToFeature;
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

	public String getTypeOfFood() {
		return typeOfFood;
	}

	public void setTypeOfFood(String typeOfFood) {
		this.typeOfFood = typeOfFood;
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

	public String getBlogFollowers() {
		return blogFollowers;
	}

	public void setBlogFollowers(String blogFollowers) {
		this.blogFollowers = blogFollowers;
	}

	public Influencer getInfl() {
		return infl;
	}

	public void setInfl(Influencer infl) {
		this.infl = infl;
	}

	public String getSearchByCityOrName() {
		return searchByCityOrName;
	}

	public void setSearchByCityOrName(String searchByCityOrName) {
		this.searchByCityOrName = searchByCityOrName;
	}

	@Override
	public String toString() {
		return "InfluencerSurveyVO [influencersurveyId=" + influencersurveyId + ", yourName=" + yourName
				+ ", yourEmail=" + yourEmail + ", yourPhoneNumber=" + yourPhoneNumber + ", yourBirthYear="
				+ yourBirthYear + ", yourGender=" + yourGender + ", platformYouUse=" + platformYouUse
				+ ", topicYouPost=" + topicYouPost + ", countriesYourFollowersLocated=" + countriesYourFollowersLocated
				+ ", citiesYourFollowersLocated=" + citiesYourFollowersLocated + ", yourFollowersAgeBrackets="
				+ yourFollowersAgeBrackets + ", percentageOfMaleFollowers=" + percentageOfMaleFollowers
				+ ", percentageOfFemaleFollowers=" + percentageOfFemaleFollowers + ", percentageOfOtherFollowers="
				+ percentageOfOtherFollowers + ", numberOfKids=" + numberOfKids + ", theirAges=" + theirAges
				+ ", numberOfDogsWillingToFeature=" + numberOfDogsWillingToFeature + ", numberOfCatsWillingToFeature="
				+ numberOfCatsWillingToFeature + ", numberOfOtherAnimalsWillingToFeature="
				+ numberOfOtherAnimalsWillingToFeature + ", significantOtherWillingToFeature="
				+ significantOtherWillingToFeature + ", typeOfTravel=" + typeOfTravel + ", typeOfRoom=" + typeOfRoom
				+ ", typeOfFood=" + typeOfFood + ", interestedInWorkingWithBrands=" + interestedInWorkingWithBrands
				+ ", youNeverWorkWithBrands=" + youNeverWorkWithBrands + ", provideShortBioForBrands="
				+ provideShortBioForBrands + ", yourFavoriteBrandToWorkWithSoFor=" + yourFavoriteBrandToWorkWithSoFor
				+ ", facebookFollowers=" + facebookFollowers + ", instagramFollowers=" + instagramFollowers
				+ ", twitterFollowers=" + twitterFollowers + ", youtubeFollowers=" + youtubeFollowers
				+ ", blogFollowers=" + blogFollowers + ", infl=" + infl + ", searchByCityOrName=" + searchByCityOrName
				+ "]";
	}

}
