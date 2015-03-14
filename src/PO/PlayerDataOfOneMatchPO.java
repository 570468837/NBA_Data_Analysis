package PO;

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
		if(splitString[17].equals("null"))
			this.setScoreOfOneMatch(this.getNumberOfFreeThrow() + 
					2 * (this.getNumberOfShooting() - this. getNumberOf3_point()) +
					3 * this.getNumberOf3_point()   );
		else
			this.setScoreOfOneMatch(Integer.parseInt(splitString[17]));
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
