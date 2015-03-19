package BusinessLogic.PlayerBusinessLogic;

import java.util.ArrayList;

import Enum.Zone;
import PO.PlayerPO;

public interface PlayerBusinessLogic {
	public void init();
	public ArrayList<PlayerPO> pickUpPlayersByCondition(String position, Zone zone);  //������Ա��λ�ú��������ˣ���������ɸѡ
	public ArrayList<PlayerPO> sortPlayersByComprehension();   // ���ݵ÷�/����/��������
}
