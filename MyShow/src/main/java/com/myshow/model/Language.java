package com.myshow.model;

/**
 * @author BhargavRajJinka
 *
 */
public enum Language {
	TEL("TELUGU"),
	HIN("HINDI"),
	ENG("ENGLISH"),
	TAM("TAMIL"),
	KAN("KANNADA"),
	MAL("MALAYALAM");
	
	
	public String type;

	/**
	 * @param type
	 */
	private Language(String type) {
		this.type = type;
	}
	



}

