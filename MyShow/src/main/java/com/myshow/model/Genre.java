package com.myshow.model;

/**
 * @author BhargavRajJinka
 *
 */
public enum Genre {
	ACTION("ACTION"),
	ROMANCE("ROMANCE"),
	THRILLER("THRILLER"),
	DRAMA("DRAMA"),
	HORROR("HORROR"),
	SCIENCE("SCIENCE FICTION"),
	ADVENTURE("ADVENTURE"),
	ANIM("ANIMATION");
	
	public String type;

	/**
	 * @param type
	 */
	private Genre(String type) {
		this.type = type;
	}
	



}

