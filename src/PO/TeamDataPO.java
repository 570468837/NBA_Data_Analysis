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
	//double percentageOfWinning ;
	double roundOfAttack ;//�����غ�
	double efficiencyOfAttack ;//������Ч�ʣ�
	double roundOfDefense ;//���ػغ�
	double efficiencyOfDefense ;//����Ч�ʣ�
	double efficiencyOfRebound ;//����Ч�ʣ�
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
		}   //end the loop
		
		percentageOfShooting = (double)numberOfShooting / (double)numberOfShotAttempt;
		percentageOf3_point = (double)numberOf3_point / (double) numberOf3_pointAttempt;
		percentageOfFreeThrow = (double) numberOfFreeThrow / (double) numberOfFreeThrowAttempt;
		
	}
	
	public void calculateTeamDataOfOneMatchUsingTheOther(TeamDataPO dataOfTheOther){
		roundOfAttack = numberOfShotAttempt + 0.4 * numberOfFreeThrowAttempt
				- 1.07 * (numberOfAttackRebound / (numberOfAttackRebound + 
						dataOfTheOther.numberOfDefenseRebound) * (numberOfShotAttempt -numberOfShooting))
						+ 1.07 * numberOfFault ;
		
		dataOfTheOther.setRoundOfDefense(roundOfAttack);//���ö��ֵķ��ػغ�
		
		efficiencyOfAttack = (double)score/roundOfAttack*100;
		
		dataOfTheOther.setEfficiencyOfDefense(efficiencyOfAttack);//���ö��ֵķ���Ч��
		
		efficiencyOfRebound = (double)(numberOfAttackRebound + numberOfDefenseRebound) / (double)
				(numberOfAttackRebound + numberOfDefenseRebound + dataOfTheOther.numberOfAttackRebound 
						+ dataOfTheOther.numberOfDefenseRebound) ;
		
		dataOfTheOther.setEfficiencyOfSteal(dataOfTheOther.getNumberOfSteal()/(double)roundOfAttack*100);//���öԷ�������Ч��
		
		efficiencyOfAssist = numberOfAssist/(double)roundOfAttack*100 ;
		
	}

	public int getNumberOfShooting() {
		return numberOfShooting;
	}

	public void setNumberOfShooting(int numberOfShooting) {
		this.numberOfShooting = numberOfShooting;
	}

	public int getNumberOfShotAttempt() {
		return numberOfShotAttempt;
	}

	public void setNumberOfShotAttempt(int numberOfShotAttempt) {
		this.numberOfShotAttempt = numberOfShotAttempt;
	}

	public int getNumberOf3_point() {
		return numberOf3_point;
	}

	public void setNumberOf3_point(int numberOf3_point) {
		this.numberOf3_point = numberOf3_point;
	}

	public int getNumberOf3_pointAttempt() {
		return numberOf3_pointAttempt;
	}

	public void setNumberOf3_pointAttempt(int numberOf3_pointAttempt) {
		this.numberOf3_pointAttempt = numberOf3_pointAttempt;
	}

	public int getNumberOfFreeThrow() {
		return numberOfFreeThrow;
	}

	public void setNumberOfFreeThrow(int numberOfFreeThrow) {
		this.numberOfFreeThrow = numberOfFreeThrow;
	}

	public int getNumberOfFreeThrowAttempt() {
		return numberOfFreeThrowAttempt;
	}

	public void setNumberOfFreeThrowAttempt(int numberOfFreeThrowAttempt) {
		this.numberOfFreeThrowAttempt = numberOfFreeThrowAttempt;
	}

	public int getNumberOfAttackRebound() {
		return numberOfAttackRebound;
	}

	public void setNumberOfAttackRebound(int numberOfAttackRebound) {
		this.numberOfAttackRebound = numberOfAttackRebound;
	}

	public int getNumberOfDefenseRebound() {
		return numberOfDefenseRebound;
	}

	public void setNumberOfDefenseRebound(int numberOfDefenseRebound) {
		this.numberOfDefenseRebound = numberOfDefenseRebound;
	}

	public int getNumberOfRebound() {
		return numberOfRebound;
	}

	public void setNumberOfRebound(int numberOfRebound) {
		this.numberOfRebound = numberOfRebound;
	}

	public int getNumberOfAssist() {
		return numberOfAssist;
	}

	public void setNumberOfAssist(int numberOfAssist) {
		this.numberOfAssist = numberOfAssist;
	}

	public int getNumberOfSteal() {
		return numberOfSteal;
	}

	public void setNumberOfSteal(int numberOfSteal) {
		this.numberOfSteal = numberOfSteal;
	}

	public int getNumberOfBlock() {
		return numberOfBlock;
	}

	public void setNumberOfBlock(int numberOfBlock) {
		this.numberOfBlock = numberOfBlock;
	}

	public int getNumberOfFault() {
		return numberOfFault;
	}

	public void setNumberOfFault(int numberOfFault) {
		this.numberOfFault = numberOfFault;
	}

	public int getNumberOfFoul() {
		return numberOfFoul;
	}

	public void setNumberOfFoul(int numberOfFoul) {
		this.numberOfFoul = numberOfFoul;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public double getPercentageOfShooting() {
		return percentageOfShooting;
	}

	public void setPercentageOfShooting(double percentageOfShooting) {
		this.percentageOfShooting = percentageOfShooting;
	}

	public double getPercentageOf3_point() {
		return percentageOf3_point;
	}

	public void setPercentageOf3_point(double percentageOf3_point) {
		this.percentageOf3_point = percentageOf3_point;
	}

	public double getPercentageOfFreeThrow() {
		return percentageOfFreeThrow;
	}

	public void setPercentageOfFreeThrow(double percentageOfFreeThrow) {
		this.percentageOfFreeThrow = percentageOfFreeThrow;
	}

	public double getRoundOfAttack() {
		return roundOfAttack;
	}

	public void setRoundOfAttack(double roundOfAttack) {
		this.roundOfAttack = roundOfAttack;
	}

	public double getEfficiencyOfAttack() {
		return efficiencyOfAttack;
	}

	public void setEfficiencyOfAttack(double efficiencyOfAttack) {
		this.efficiencyOfAttack = efficiencyOfAttack;
	}

	public double getRoundOfDefense() {
		return roundOfDefense;
	}

	public void setRoundOfDefense(double roundOfDefense) {
		this.roundOfDefense = roundOfDefense;
	}

	public double getEfficiencyOfDefense() {
		return efficiencyOfDefense;
	}

	public void setEfficiencyOfDefense(double efficiencyOfDefense) {
		this.efficiencyOfDefense = efficiencyOfDefense;
	}

	public double getEfficiencyOfRebound() {
		return efficiencyOfRebound;
	}

	public void setEfficiencyOfRebound(double efficiencyOfRebound) {
		this.efficiencyOfRebound = efficiencyOfRebound;
	}

	public double getEfficiencyOfSteal() {
		return efficiencyOfSteal;
	}

	public void setEfficiencyOfSteal(double efficiencyOfSteal) {
		this.efficiencyOfSteal = efficiencyOfSteal;
	}

	public double getEfficiencyOfAssist() {
		return efficiencyOfAssist;
	}

	public void setEfficiencyOfAssist(double efficiencyOfAssist) {
		this.efficiencyOfAssist = efficiencyOfAssist;
	}
	
	
}
