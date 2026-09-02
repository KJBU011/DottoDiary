package com.mbc.dotto.dto;

public class GrouphomeDto {
	
	
	private int grNo;
	private String grName;
	private String grLeader; 
	private int grCount;
	private int grMax;
	private String grCode;
	private String grTree;
	private int grTier;
	
	public GrouphomeDto() {
		// TODO Auto-generated constructor stub
	}

	public GrouphomeDto(int grNo, String grName, String grLeader, int grCount, int grMax, String grCode, String grTree,
			int grTier) {
		super();
		this.grNo = grNo;
		this.grName = grName;
		this.grLeader = grLeader;
		this.grCount = grCount;
		this.grMax = grMax;
		this.grCode = grCode;
		this.grTree = grTree;
		this.grTier = grTier;
	}

	public int getGrNo() {
		return grNo;
	}

	public void setGrNo(int grNo) {
		this.grNo = grNo;
	}

	public String getGrName() {
		return grName;
	}

	public void setGrName(String grName) {
		this.grName = grName;
	}

	public String getGrLeader() {
		return grLeader;
	}

	public void setGrLeader(String grLeader) {
		this.grLeader = grLeader;
	}

	public int getGrCount() {
		return grCount;
	}

	public void setGrCount(int grCount) {
		this.grCount = grCount;
	}

	public int getGrMax() {
		return grMax;
	}

	public void setGrMax(int grMax) {
		this.grMax = grMax;
	}

	public String getGrCode() {
		return grCode;
	}

	public void setGrCode(String grCode) {
		this.grCode = grCode;
	}

	public String getGrTree() {
		return grTree;
	}

	public void setGrTree(String grTree) {
		this.grTree = grTree;
	}

	public int getGrTier() {
		return grTier;
	}

	public void setGrTier(int grTier) {
		this.grTier = grTier;
	}

	@Override
	public String toString() {
		return "GroupehomeDto [grNo=" + grNo + ", grName=" + grName + ", grLeader=" + grLeader + ", grCount=" + grCount
				+ ", grMax=" + grMax + ", grCode=" + grCode + ", grTree=" + grTree + ", grTier=" + grTier + "]";
	}
	

}
