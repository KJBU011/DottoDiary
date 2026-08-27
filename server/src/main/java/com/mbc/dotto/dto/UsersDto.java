package com.mbc.dotto.dto;

public class UsersDto {
	private String id;
	private String pw;
	private String name;
	private String nick;	// 별명
	private String hp;
	private int enGr;		// 가입된 그룹 갯수
	private int auth;		// 탈퇴 유저 -1, 관리자 1, 일반 유저 2
	
	public UsersDto() {
	}

	public UsersDto(String id, String pw, String name, String nick, int enGr, int auth) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.nick = nick;
		this.hp = hp;
		this.enGr = enGr;
		this.auth = auth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getHP() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}	

	public int getEnGr() {
		return enGr;
	}

	public void setEnGr(int enGr) {
		this.enGr = enGr;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "UsersDto [id=" + id + ", pw=" + pw + ", name=" + name + ", nick=" + nick + ", hp=" + hp + ", enGr="
				+ enGr + ", auth=" + auth + "]";
	}

}
