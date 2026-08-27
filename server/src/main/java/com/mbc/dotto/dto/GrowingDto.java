package com.mbc.dotto.dto;

import java.sql.Timestamp;

public class GrowingDto {
	
	//private 변수 생성 
	 private int gwNo; //그룹id 
	 private String id; //id
	 private Timestamp gwDate; //sql용 timestamp 
	 private String gwContent; //댓글
	 private int grNo; //그룹id 
	 private int gwTier; //나무 등급 
	 
	 public GrowingDto() {
		// TODO Auto-generated constructor stub
	}

	 public GrowingDto(int gwNo, String id, Timestamp gwDate, String gwContent, int grNo, int gwTier) {
		super();
		this.gwNo = gwNo;
		this.id = id;
		this.gwDate = gwDate;
		this.gwContent = gwContent;
		this.grNo = grNo;
		this.gwTier = gwTier;
	 }

	 public int getGwNo() {
		 return gwNo;
	 }

	 public void setGwNo(int gwNo) {
		 this.gwNo = gwNo;
	 }

	 public String getId() {
		 return id;
	 }

	 public void setId(String id) {
		 this.id = id;
	 }

	 public Timestamp getGwDate() {
		 return gwDate;
	 }

	 public void setGwDate(Timestamp gwDate) {
		 this.gwDate = gwDate;
	 }

	 public String getGwContent() {
		 return gwContent;
	 }

	 public void setGwContent(String gwContent) {
		 this.gwContent = gwContent;
	 }

	 public int getGrNo() {
		 return grNo;
	 }

	 public void setGrNo(int grNo) {
		 this.grNo = grNo;
	 }

	 public int getGwTier() {
		 return gwTier;
	 }

	 public void setGwTier(int gwTier) {
		 this.gwTier = gwTier;
	 }

	 @Override
	 public String toString() {
		return "GrowingDto [gwNo=" + gwNo + ", id=" + id + ", gwDate=" + gwDate + ", gwContent=" + gwContent + ", grNo="
				+ grNo + ", gwTier=" + gwTier + "]";
	 }
	 
	 
	 
	 
	
	 
	
}
