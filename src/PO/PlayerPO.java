package PO;

import java.util.ArrayList;

public class PlayerPO {
	String name;
	String position;  //λ��
	
	int number;       //���º���
	String height;    //���(Ӣ��-Ӣ��)
	int weight;       //����(��)
	String birth;     //����(��/��/��)
	int age;
	int exp;         //����
	String school;    //��ҵѧУ
	
	String portraitURL;    //ͷ��ĵ�ַ
	String actionURL;      //������Ƭ�ĵ�ַ
	
	ArrayList<PlayerDataOfOneMatchPO> datas;
	PlayerDataPO playerData;
	
	String team ; //������ӣ�����nameȥfind TeamPO��
	
}
