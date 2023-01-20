package com.crm.qa.testdata;

public class StarWarsAPI {
	
	/**Returns the path for name property from the response**/
	public static String namePath() {
		return "results[2].name";
	}
	
	/**Returns the path for skin_color property from the response**/
	public static String skinColorPath() {
		return "results[2].skin_color";
	}
	
	/**
	 * Returns the heroes for name
	 **/
	public static String heroName() {
		return "R2-D2";
	}
	
	/**
	 * Returns the heroes for skin color
	 **/
	public static String heroSkinColor() {
		return "white, blue";
	}
	
	/**
	 * People resource
	 **/
	public static String peopleEndpoint() {
	return "/people/";
	}
	
	

}
