package PO;

import java.util.ArrayList;

import Enum.Zone;

public class TeamPO {
	String fullName;    //ȫ��
	String shortName;   //��д��
	String city;        //���ڳ���
	Zone zone;          //������������������
	String district;     //���������ϲ����в���̫ƽ������ȣ�
	String homeCourt;     //����
	int timeOfEstablishment;   //�������
	
	String teamLogoURL;     //���Logo��ַ
	
	TeamDataPO teamData;
	
	ArrayList<PlayerPO> players ;//��Ա����
	ArrayList<MatchPO> matches;  //��������
	
}
