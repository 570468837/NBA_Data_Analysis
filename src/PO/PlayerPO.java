package PO;

import java.util.ArrayList;

public class PlayerPO {
	String name;
	String position;  //λ��
	
	int number;       //���º���
	String height;    //���(Ӣ��-Ӣ��)
	double weight;       //����(��)
	String birth;     //����(��/��/��)
	int age;
	int exp;         //����
	String school;    //��ҵѧУ
	
	String portraitURL;    //ͷ��ĵ�ַ
	String actionURL;      //������Ƭ�ĵ�ַ
	
	ArrayList<PlayerDataOfOneMatchPO> datas;
	PlayerDataPO playerData;
	
	String team ; //������ӣ�����nameȥfind TeamPO��
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getPortraitURL() {
		return portraitURL;
	}

	public void setPortraitURL(String portraitURL) {
		this.portraitURL = portraitURL;
	}

	public String getActionURL() {
		return actionURL;
	}

	public void setActionURL(String actionURL) {
		this.actionURL = actionURL;
	}

	public ArrayList<PlayerDataOfOneMatchPO> getDatas() {
		return datas;
	}

	public void setDatas(ArrayList<PlayerDataOfOneMatchPO> datas) {
		this.datas = datas;
	}

	public PlayerDataPO getPlayerData() {
		return playerData;
	}

	public void setPlayerData(PlayerDataPO playerData) {
		this.playerData = playerData;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
	
	
}
