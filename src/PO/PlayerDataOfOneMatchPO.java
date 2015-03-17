package PO;

import java.util.ArrayList;

public class PlayerDataOfOneMatchPO {
	//ĳ�������е�����
	String name ;//����
	String position ;//λ��
	String presentTimeOfOneMatch ;//�ڳ�ʱ��
	int numberOfShooting ;//Ͷ��������
	int numberOfShotAttempt ; // Ͷ����������
	int numberOf3_point ;//������������
	int numberOf3_pointAttempt ;//���ֳ�������
	int numberOfFreeThrow ;//������������
	int numberOfFreeThrowAttempt ;//�����������
	int numberOfAttackRebound ;//������ǰ����������
	int numberOfDefenseRebound ;//���أ��󳡣�������
	int numberOfReboundOfOneMatch ;//��������
	int numberOfAssistOfOneMatch ;//��������
	int numberOfSteal;  //������
	int numberOfBlockOfOneMatch ;//��ñ����
	int numberOfFaultOfOneMatch ;//ʧ������
	
	int numberOfFoulOfOneMatch ;//��������
	int scoreOfOneMatch ;//���˵÷�
	
	
	
	double percentageOfShooting ;//Ͷ��������
	double percentageOf3_Point ;//����������
	double percentageOffreeThrow ;//����������
	
	int numberOfAttack ;//������
	int numberOfDefense ;//������
	int efficiency ;//Ч�ʣ�
	
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
	
	
	public PlayerDataOfOneMatchPO(){
		
	}
	public PlayerDataOfOneMatchPO(String[] splitString){
	   	this.setName(splitString[0]);//����
    	this.setPosition(splitString[1]);//λ��
		this.setPresentTimeOfOneMatch(splitString[2]);
		this.setNumberOfShooting(Integer.parseInt(splitString[3]));
		this.setNumberOfShotAttempt(Integer.parseInt(splitString[4]));
		this.setNumberOf3_point(Integer.parseInt(splitString[5]));
		this.setNumberOf3_pointAttempt(Integer.parseInt(splitString[6]));
		this.setNumberOfFreeThrow(Integer.parseInt(splitString[7])) ;
		this.setNumberOfFreeThrowAttempt(Integer.parseInt(splitString[8]));
		this.setNumberOfAttackRebound(Integer.parseInt(splitString[9]));
		this.setNumberOfDefenseRebound(Integer.parseInt(splitString[10]));
		this.setNumberOfReboundOfOneMatch(Integer.parseInt(splitString[11]));
		this.setNumberOfAssistOfOneMatch(Integer.parseInt(splitString[12]));
		this.setNumberOfSteal(Integer.parseInt(splitString[13]));
		this.setNumberOfBlockOfOneMatch(Integer.parseInt(splitString[14]));
		this.setNumberOfFaultOfOneMatch(Integer.parseInt(splitString[15]));
		this.setNumberOfFoulOfOneMatch(Integer.parseInt(splitString[16]));
		if(splitString[17].equals("null"))  // Invalid data
			this.setScoreOfOneMatch(this.getNumberOfFreeThrow() + 
					2 * (this.getNumberOfShooting() - this. getNumberOf3_point()) +
					3 * this.getNumberOf3_point()   );      //calculate by other data of him
		else
			this.setScoreOfOneMatch(Integer.parseInt(splitString[17]));
	}
	
	public void calculatePlayerData(int totalTime,TeamDataPO teamData,TeamDataPO theOtherTeamData,ArrayList<PlayerDataOfOneMatchPO> playersData ){//������Ա�ڳ�ʱ��Ͷ���������
		percentageOfShooting = (double)numberOfShooting/numberOfShotAttempt ;//Ͷ��������
		percentageOf3_Point = (double)numberOf3_point/numberOf3_pointAttempt ;//����������
		percentageOffreeThrow = (double)numberOfFreeThrow/numberOfFreeThrowAttempt ;//����������
		efficiency = (scoreOfOneMatch+numberOfReboundOfOneMatch+numberOfAssistOfOneMatch+numberOfSteal+numberOfBlockOfOneMatch)
				-(numberOfShotAttempt - numberOfShooting)-(numberOfFreeThrowAttempt-numberOfFreeThrow)-numberOfFaultOfOneMatch ;
		
		efficiencyOfGmSc = scoreOfOneMatch + 0.4*numberOfShooting-0.7*numberOfShotAttempt-0.4*(numberOfFreeThrowAttempt-numberOfFreeThrow)
				+0.7*numberOfAttackRebound+0.3*numberOfDefenseRebound+numberOfSteal+0.7*numberOfAssistOfOneMatch+0.7*numberOfBlockOfOneMatch-0.4*numberOfFoulOfOneMatch-numberOfFaultOfOneMatch;
		percentageOfTrueShooting = scoreOfOneMatch/(2*(numberOfShotAttempt+0.44*numberOfFreeThrowAttempt)) ;
		efficiencyOfShooting = (numberOfShooting+0.5*numberOf3_point)/numberOfShotAttempt ;
		percentageOfRebound = numberOfReboundOfOneMatch*(totalTime/5.0)/transfromTime(presentTimeOfOneMatch,playersData,totalTime)/(teamData.getNumberOfRebound()+theOtherTeamData.getNumberOfRebound()) ;
		percentageOfAttackingRebound = numberOfAttackRebound*(totalTime/5.0)/transfromTime(presentTimeOfOneMatch,playersData,totalTime)/(teamData.getNumberOfAttackRebound()+theOtherTeamData.getNumberOfAttackRebound());
		percentageOfDefenseRebound = numberOfDefenseRebound*(totalTime/5.0)/transfromTime(presentTimeOfOneMatch,playersData,totalTime)/(teamData.getNumberOfDefenseRebound()+theOtherTeamData.getNumberOfDefenseRebound()) ;
		percentageOfAssist = numberOfAssistOfOneMatch/(transfromTime(presentTimeOfOneMatch,playersData,totalTime)/(totalTime/5.0)*teamData.getNumberOfShooting()-numberOfShooting) ;
		percentageOfSteal = numberOfSteal*(totalTime/5.0)/transfromTime(presentTimeOfOneMatch,playersData,totalTime)/theOtherTeamData.getRoundOfAttack() ;
		percentageOfBlock = numberOfBlockOfOneMatch*(totalTime/5.0)/transfromTime(presentTimeOfOneMatch,playersData,totalTime)/(theOtherTeamData.getNumberOfShotAttempt()-theOtherTeamData.getNumberOf3_pointAttempt()) ;
		percentageOfFault = numberOfFaultOfOneMatch/( (theOtherTeamData.getNumberOfShotAttempt()-theOtherTeamData.getNumberOf3_pointAttempt()) + 0.44*numberOfFreeThrowAttempt+numberOfFaultOfOneMatch) ;
		percentageOfUse = (numberOfShotAttempt+0.44*numberOfFreeThrowAttempt+numberOfFaultOfOneMatch)*(totalTime/5.0)/transfromTime(presentTimeOfOneMatch,playersData,totalTime)/(teamData.getNumberOfShotAttempt()+0.44*teamData.getNumberOfFreeThrowAttempt()+teamData.getNumberOfFault());
	}
	int transfromTime(String time,ArrayList<PlayerDataOfOneMatchPO> playersData,int totalTime){//ת��ʱ��Ϊ��������λ��
		int result = 0 ;
		if(time.equals("null")||time.equals("None")){
			result = totalTime *5;
			for(PlayerDataOfOneMatchPO onePlayer:playersData){
				if(!onePlayer.getName().equals(name)){
				   result =result - transfromTime(onePlayer.getPresentTimeOfOneMatch(), playersData, totalTime) ;
				}
			}
			if(result<0){
				result = 0;
			}
			presentTimeOfOneMatch = ""+result/60+":"+result%60 ;//����ȱʧ���ϳ�ʱ��
//			System.out.println(result+"  "+presentTimeOfOneMatch);
			return result ;
		}
		String[] strs = time.split(":");
		result = Integer.parseInt(strs[0])*60+Integer.parseInt(strs[1]) ;
		return result ;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setPresentTimeOfOneMatch(String presentTimeOfOneMatch) {
		this.presentTimeOfOneMatch = presentTimeOfOneMatch;
	}
	public void setNumberOfShooting(int numberOfShooting) {
		this.numberOfShooting = numberOfShooting;
	}
	public void setNumberOfShotAttempt(int numberOfShotAttempt) {
		this.numberOfShotAttempt = numberOfShotAttempt;
	}
	public void setNumberOf3_point(int numberOf3_point) {
		this.numberOf3_point = numberOf3_point;
	}
	public void setNumberOf3_pointAttempt(int numberOf3_pointAttempt) {
		this.numberOf3_pointAttempt = numberOf3_pointAttempt;
	}
	public void setNumberOfFreeThrow(int numbreOfFreeThrow) {
		this.numberOfFreeThrow = numbreOfFreeThrow;
	}
	public void setNumberOfFreeThrowAttempt(int numberOfFreeThrowAttempt) {
		this.numberOfFreeThrowAttempt = numberOfFreeThrowAttempt;
	}
	public void setNumberOfAttackRebound(int numberOfAttackRebound) {
		this.numberOfAttackRebound = numberOfAttackRebound;
	}
	public void setNumberOfDefenseRebound(int numberOfDefenseRebound) {
		this.numberOfDefenseRebound = numberOfDefenseRebound;
	}
	public void setNumberOfReboundOfOneMatch(int numberOfReboundOfOneMatch) {
		this.numberOfReboundOfOneMatch = numberOfReboundOfOneMatch;
	}
	public void setNumberOfAssistOfOneMatch(int numberOfAssistOfOneMatch) {
		this.numberOfAssistOfOneMatch = numberOfAssistOfOneMatch;
	}
	public void setNumberOfSteal(int numberOfSteal) {
		this.numberOfSteal = numberOfSteal;
	}
	public void setNumberOfBlockOfOneMatch(int numberOfBlockOfOneMatch) {
		this.numberOfBlockOfOneMatch = numberOfBlockOfOneMatch;
	}
	public void setNumberOfFaultOfOneMatch(int numberOfFaultOfOneMatch) {
		this.numberOfFaultOfOneMatch = numberOfFaultOfOneMatch;
	}
	public void setNumberOfFoulOfOneMatch(int numberOfFoulOfOneMatch) {
		this.numberOfFoulOfOneMatch = numberOfFoulOfOneMatch;
	}
	public void setScoreOfOneMatch(int scoreOfOneMatch) {
		this.scoreOfOneMatch = scoreOfOneMatch;
	}
	public String getPosition() {
		return position;
	}
	public String getPresentTimeOfOneMatch() {
		return presentTimeOfOneMatch;
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
	public double getPercentageOfShooting() {
		return percentageOfShooting;
	}
	public double getPercentageOf3_Point() {
		return percentageOf3_Point;
	}
	public double getPercentageOffreeThrow() {
		return percentageOffreeThrow;
	}
	public int getNumberOfAttack() {
		return numberOfAttack;
	}
	public int getNumberOfDefense() {
		return numberOfDefense;
	}
	public int getEfficiency() {
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
	public int getNumberOfReboundOfOneMatch() {
		return numberOfReboundOfOneMatch;
	}
	public int getNumberOfAssistOfOneMatch() {
		return numberOfAssistOfOneMatch;
	}
	public int getNumberOfSteal() {
		return numberOfSteal;
	}
	public int getNumberOfBlockOfOneMatch() {
		return numberOfBlockOfOneMatch;
	}
	public int getNumberOfFaultOfOneMatch() {
		return numberOfFaultOfOneMatch;
	}
	public int getNumberOfFoulOfOneMatch() {
		return numberOfFoulOfOneMatch;
	}
	public int getScoreOfOneMatch() {
		return scoreOfOneMatch;
	}
	
	
}
