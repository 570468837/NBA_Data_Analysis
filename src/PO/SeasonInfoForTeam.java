package PO;

import java.util.ArrayList;

public class SeasonInfoForTeam {
	String shortName;
	TeamDataPO totalTeamData = new TeamDataPO();
	TeamDataPO averageTeamData = new TeamDataPO() ;
	
	DataForFinalCalculationPO dataOfOtherTeams = new DataForFinalCalculationPO() ;
	
	int numberOfMatches;
	int numberOfWinning;
	double percentageOfWinning ; //ʤ��
	
	ArrayList<PlayerPO> players = new ArrayList<PlayerPO>() ;//��Ա����
	ArrayList<MatchPO> matches = new ArrayList<MatchPO>();  //��������

	public void addPlayer(PlayerPO onePlayer){
		if(ifContainThePlayer(onePlayer)){
			;
		}else{
			players.add(onePlayer) ;
		}
	}
	public void addMatch(MatchPO oneMatch){
		matches.add(oneMatch) ;
		numberOfMatches++;
		if(oneMatch.getNameOfWinner().equals(shortName))
			numberOfWinning++;
	}
	
	boolean ifContainThePlayer(PlayerPO onePlayer){
		for(PlayerPO thePlayer:players){
			if(thePlayer.getName().equals(onePlayer.getName())){
				return true ;
			}
		}
		return false ;
	}
	
	public void calculateTeamDataInOneSeason(){
		percentageOfWinning = numberOfWinning / matches.size() ;
		totalTeamData.calculateTeamTotalDataInOneSeason(matches, shortName);
		averageTeamData.calculateTeamAverageDataInOneSeason(totalTeamData, matches.size(),dataOfOtherTeams);
	}
	
	public void updateOtherTeamData(double score){
		dataOfOtherTeams.update(score) ;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public TeamDataPO getTotalTeamData() {
		return totalTeamData;
	}
	public void setTotalTeamData(TeamDataPO totalTeamData) {
		this.totalTeamData = totalTeamData;
	}
	public TeamDataPO getAverageTeamData() {
		return averageTeamData;
	}
	public void setAverageTeamData(TeamDataPO averageTeamData) {
		this.averageTeamData = averageTeamData;
	}
	public DataForFinalCalculationPO getDataOfOtherTeams() {
		return dataOfOtherTeams;
	}
	public void setDataOfOtherTeams(DataForFinalCalculationPO dataOfOtherTeams) {
		this.dataOfOtherTeams = dataOfOtherTeams;
	}
	public int getNumberOfMatches() {
		return numberOfMatches;
	}
	public void setNumberOfMatches(int numberOfMatches) {
		this.numberOfMatches = numberOfMatches;
	}
	public int getNumberOfWinning() {
		return numberOfWinning;
	}
	public void setNumberOfWinning(int numberOfWinning) {
		this.numberOfWinning = numberOfWinning;
	}
	public double getPercentageOfWinning() {
		return percentageOfWinning;
	}
	public void setPercentageOfWinning(double percentageOfWinning) {
		this.percentageOfWinning = percentageOfWinning;
	}
	public ArrayList<PlayerPO> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<PlayerPO> players) {
		this.players = players;
	}
	public ArrayList<MatchPO> getMatches() {
		return matches;
	}
	public void setMatches(ArrayList<MatchPO> matches) {
		this.matches = matches;
	}
	
	
}
