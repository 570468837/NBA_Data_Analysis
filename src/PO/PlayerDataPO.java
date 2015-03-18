package PO;

import java.util.ArrayList;

public class PlayerDataPO {

	//����Ա����������
	int numberOfMatch ;//��������
	int numberOfStarting ;//�׷�����
	double numberOfRebound ;//������
	double numberOfAssist ;//������
	double presentTime ;//�ڳ�ʱ��
	
	double percentageOfShooting ;//Ͷ��������
	double percentageOf3_Point ;//����������
	double percentageOffreeThrow ;//����������
	
	double numberOfAttack ;//������
	double numberOfDefense ;//������
	double numberOfSteal ;//������
	double numberOfBlock ;//��ñ�� 
	double numberOfFault ;//ʧ����
	double numberOfFoul ;//��������
	double score ;//�÷֣�
	double efficiency ;//Ч�ʣ�
	
	double efficiencyOfGmSc ;//GmScЧ��ֵ��
	double percentageOfTrueShooting ;//��ʵ�����ʣ�
	double efficiencyOfShooting ;//Ͷ��Ч�ʣ�
	double percentageOfRebound ; //�����ʣ�
	double percentageOfAttackingRebound ;//���������ʣ�
	double percentageOfDefenseRebound ;//���������ʣ�
	double percentageOfAssist ;// �����ʣ�
	double percentageOfSteal ;//�����ʣ�
	double percentageOfBlock ;//��ñ�ʣ�
	double percentageOfFault ;//ʧ���ʣ�
	double percentageOfUse ;//ʹ����
	
	public void calculatePlayerTotalDataInOneSeason(ArrayList<PlayerDataOfOneMatchPO> datas){
		numberOfMatch = datas.size() ;
		numberOfStarting = datas.size() ;
		for(PlayerDataOfOneMatchPO oneMatch:datas){
			numberOfRebound += oneMatch.getNumberOfReboundOfOneMatch() ;
			numberOfAssist += oneMatch.getNumberOfAssistOfOneMatch() ;
			
		}
	}
	public void calculatePlayerAverageDataInOneSeason(){
		
	}
	int transportTime(String time){
		int result = 0;
		String[] strs = time.split(":") ;
		result = Integer.parseInt(strs[0])*60 + Integer.parseInt(strs[1]) ;
		return result ;
	}
	
	public int getNumberOfMatch() {
		return numberOfMatch;
	}
	public int getNumberOfStarting() {
		return numberOfStarting;
	}
	public double getNumberOfRebound() {
		return numberOfRebound;
	}
	public double getNumberOfAssist() {
		return numberOfAssist;
	}
	public double getPresentTime() {
		return presentTime;
	}
	public double getPercentageOfShooting() {
		return percentageOfShooting;
	}
	public double getPercentageOf3_Point() {
		return percentageOf3_Point;
	}
	public double getPercentageOffreeThrow() {
		return percentageOffreeThrow;
	}
	public double getNumberOfAttack() {
		return numberOfAttack;
	}
	public double getNumberOfDefense() {
		return numberOfDefense;
	}
	public double getNumberOfSteal() {
		return numberOfSteal;
	}
	public double getNumberOfBlock() {
		return numberOfBlock;
	}
	public double getNumberOfFault() {
		return numberOfFault;
	}
	public double getNumberOfFoul() {
		return numberOfFoul;
	}
	public double getScore() {
		return score;
	}
	public double getEfficiency() {
		return efficiency;
	}
	public double getEfficiencyOfGmSc() {
		return efficiencyOfGmSc;
	}
	public double getPercentageOfTrueShooting() {
		return percentageOfTrueShooting;
	}
	public double getEfficiencyOfShooting() {
		return efficiencyOfShooting;
	}
	public double getPercentageOfRebound() {
		return percentageOfRebound;
	}
	public double getPercentageOfAttackingRebound() {
		return percentageOfAttackingRebound;
	}
	public double getPercentageOfDefenseRebound() {
		return percentageOfDefenseRebound;
	}
	public double getPercentageOfAssist() {
		return percentageOfAssist;
	}
	public double getPercentageOfSteal() {
		return percentageOfSteal;
	}
	public double getPercentageOfBlock() {
		return percentageOfBlock;
	}
	public double getPercentageOfFault() {
		return percentageOfFault;
	}
	public double getPercentageOfUse() {
		return percentageOfUse;
	}
	
	
}
