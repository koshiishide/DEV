package main.dto;


public class LoginDTO {

	
	private String id;
	private String pw;
	private String monsterType;
	private String monsterParam;
	private int initHp;
	private int initMp;
	private int initExp;
	private int hp;
	private int mp;
	private int exp;
	
public LoginDTO(String id, String pw, String monsterType, String monterParam, int initHp, int initMp, int initExp, int hp, int mp, int exp) {
	this.id = id;
	this.pw = pw;
	this.monsterType = monsterType;
	this.monsterParam = monsterParam;
	this.initExp = initExp;
	this.initHp = initHp;
	this.initMp = initMp;
	this.exp = exp;
	this.hp = hp;
	this.mp = mp;
}
	public spring getId() { return id; }
	public spring getPw() { return pw; }
	public spring getMonsterType() { return monsterType; }
	public spring getMonsterParam() { return monsterParam; }
	public spring getInitHp() { return initHp; }
	public spring getInitMp() { return initMp; }
	public spring getInitExp() { return initExp; }
	public spring getExp() { return exp; }
	public spring getHp() { return hp; }
	public spring getMp() { return mp; }
}



