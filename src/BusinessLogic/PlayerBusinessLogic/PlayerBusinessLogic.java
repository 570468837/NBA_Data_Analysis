package BusinessLogic.PlayerBusinessLogic;

import java.util.ArrayList;

import PO.PlayerPO;

public interface PlayerBusinessLogic {
	public void init();
	public ArrayList<PlayerPO> pickUpPlayersByCondition(String position, String district);
	public ArrayList<PlayerPO> sortPlayersByComprehension();   // ���ݵ÷�/����/��������
}
