package com.mbc.dotto.dto;

import java.sql.Timestamp;

public class DiariesDto {
	
	private String diNo;
	private String id;
	private Timestamp diDate; // sql로 import
	private String diWeather;
	private String diContent;
	private String diTitle;
	private int diPublic;
	private int grNo;
	
	public DiariesDto() {
		// TODO 종이생성(dto) 생성자
	}
	
	// using Fields 종이를 만들 때 값을 넣은 채로 만든다
	public DiariesDto(String diNo, String id, Timestamp diDate, String diWeather, String diContent, String diTitle,
			int diPublic, int grNo) {
		super();
		this.diNo = diNo;
		this.id = id;
		this.diDate = diDate;
		this.diWeather = diWeather;
		this.diContent = diContent;
		this.diTitle = diTitle;
		this.diPublic = diPublic;
		this.grNo = grNo;
	}
	
	// Getters 빌려줌 Setters 설정해줘 시킴. 변수들을 통제하기 편하기 위해서
	public String getDiNo() {
		return diNo;
	}

	public void setDiNo(String diNo) {
		this.diNo = diNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getDiDate() {
		return diDate;
	}

	public void setDiDate(Timestamp diDate) {
		this.diDate = diDate;
	}

	public String getDiWeather() {
		return diWeather;
	}

	public void setDiWeather(String diWeather) {
		this.diWeather = diWeather;
	}

	public String getDiContent() {
		return diContent;
	}

	public void setDiContent(String diContent) {
		this.diContent = diContent;
	}

	public String getDiTitle() {
		return diTitle;
	}

	public void setDiTitle(String diTitle) {
		this.diTitle = diTitle;
	}

	public int getDiPublic() {
		return diPublic;
	}

	public void setDiPublic(int diPublic) {
		this.diPublic = diPublic;
	}

	public int getGrNo() {
		return grNo;
	}

	public void setGrNo(int grNo) {
		this.grNo = grNo;
	}
	
	// toString @Override 상위
	@Override
	public String toString() {
		return "DiariesDto [diNo=" + diNo + ", id=" + id + ", diDate=" + diDate + ", diWeather=" + diWeather
				+ ", diContent=" + diContent + ", diTitle=" + diTitle + ", diPublic=" + diPublic + ", grNo=" + grNo
				+ "]";
	}
	
	
}