package PO;

import java.util.ArrayList;

public class TeamDataPO {
	int numberOfShooting ;//Ͷ��������
	int numberOfShotAttempt ;//��Ͷ����������
	int numberOf3_point ;//������������
	int numberOf3_pointAttempt ;//���ֳ�������
	int numberOfFreeThrow ;//������������
	int numberOfFreeThrowAttempt ;//�����������
	int numberOfAttackRebound ;//������������
	int numberOfDefenseRebound ;//������������
	int numberOfRebound ;//������
	int numberOfAssist ;//��������
	int numberOfSteal ;//��������
	int numberOfBlock ;//��ñ����
	int numberOfFault ;//ʧ������
	int numberOfFoul ;//��������
	int score ;//�����÷�
	
	double percentageOfShooting ;//Ͷ�������ʣ�
	double percentageOf3_point ;//���������ʣ�
	double percentageOfFreeThrow ;//���������ʣ�
	double percentageOfWinning ;//ʤ�ʣ�
	double roundOfAttack ;//�����غ�
	double efficiencyOfAttack ;//������Ч�ʣ�
	double efficiencyOfDefense ;//����Ч�ʣ�
	double efficiencyOfBlock ;//����Ч�ʣ�
	double efficiencyOfSteal ;//����Ч��
	double efficiencyOfAssist ;//�����ʡ�
	
	public void calculateTeamDataOfOneMatch(ArrayList<PlayerDataOfOneMatchPO> playerDatas){
		for(int i=0;i<playerDatas.size();i++){
			PlayerDataOfOneMatchPO tempData=playerDatas.get(i);
			
			numberOfShooting += tempData.getNumberOfShooting();
			numberOfShotAttempt += tempData.getNumberOfShotAttempt();
			numberOf3_point += tempData.getNumberOf3_point();
			numberOf3_pointAttempt += tempData.getNumberOf3_pointAttempt();
			numberOfFreeThrow += tempData.getNumberOfFreeThrow();
			numberOfFreeThrowAttempt += tempData.getNumberOfFreeThrowAttempt();
			numberOfAttackRebound += tempData.getNumberOfAttackRebound();
			numberOfDefenseRebound += tempData.getNumberOfDefenseRebound();
			numberOfRebound += tempData.getNumberOfReboundOfOneMatch();
			numberOfAssist += tempData.getNumberOfAssistOfOneMatch();
			numberOfSteal += tempData.getNumberOfSteal();
			numberOfBlock += tempData.getNumberOfBlockOfOneMatch();
			numberOfFault += tempData.getNumberOfFaultOfOneMatch();
			numberOfFoul += tempData.getNumberOfFoulOfOneMatch();
			score += tempData.getScoreOfOneMatch();
			
			
		}
	}
	
	
	public int getNumberOfShooting() {
		return numberOfShooting;
	}
	public int getNumberOfShotAttempt() {
		return numberOfShotAttempt;
	}
	public int getNumberOf3_point() {
		return numberOf3_point;
	}
	public int getNumberOf3_pointAttempt() {
		return numberOf3_pointAttempt;
	}
	public int getNumberOfFreeThrow() {
		return numberOfFreeThrow;
	}
	public int getNumberOfFreeThrowAttempt() {
		return numberOfFreeThrowAttempt;
	}
	public int getNumberOfAttackRebound() {
		return numberOfAttackRebound;
	}
	public int getNumberOfDefenseRebound() {
		return numberOfDefenseRebound;
	}
	public int getNumberOfRebound() {
		return numberOfRebound;
	}
	public int getNumberOfAssist() {
		return numberOfAssist;
	}
	public int getNumberOfSteal() {
		return numberOfSteal;
	}
	public int getNumberOfBlock() {
		return numberOfBlock;
	}
	public int getNumberOfFault() {
		return numberOfFault;
	}
	public int getNumberOfFoul() {
		return numberOfFoul;
	}
	public int getScore() {
		return score;
	}
	public double getPercentageOfShooting() {
		return percentageOfShooting;
	}
	public double getPercentageOf3_point() {
		return percentageOf3_point;
	}
	public double getPercentageOfFreeThrow() {
		return percentageOfFreeThrow;
	}
	public double getPercentageOfWinning() {
		return percentageOfWinning;
	}
	public double getRoundOfAttack() {
		return roundOfAttack;
	}
	public double getEfficiencyOfAttack() {
		return efficiencyOfAttack;
	}
	public double getEfficiencyOfDefense() {
		return efficiencyOfDefense;
	}
	public double getEfficiencyOfBlock() {
		return efficiencyOfBlock;
	}
	public double getEfficiencyOfSteal() {
		return efficiencyOfSteal;
	}
	public double getEfficiencyOfAssist() {
		return efficiencyOfAssist;
	}
	
	
	
}
