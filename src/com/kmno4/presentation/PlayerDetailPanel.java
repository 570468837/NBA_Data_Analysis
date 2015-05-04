package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.kmno4.common.Config;
import com.kmno4.presentation.table.TableFactory;
import com.kmno4.presentation.table.TableGroup;

import PO.MatchPO;
import PO.PlayerPO;
import PO.TeamListPO;
import PO.TeamPO;

@SuppressWarnings("serial")
public class PlayerDetailPanel extends JPanel {
	private PlayerDetailPanel playerDetailPanel;
	private PlayerDetailFrame playerDetailFrame;
	private DataPanel dataPanel;
	private TableGroup seasonAvgData, seasonSumData, recentData;
	private JLabel seasonLabel, avgLabel, sumLabel, recentLabel;
	private PlayerPO playerPO;
	
	private static final int PADDING = 5;
	private static final int 
	    DATA_PANEL_HEIGHT = 240,
	    SEASON_AVG_DATA_TABLE_HEIGHT = 120,
	    SEASON_SUM_DATA_TABLE_HEIGHT = SEASON_AVG_DATA_TABLE_HEIGHT,
	    RECENT_DATA_TABLE_HEIGHT = 160,
	    SEASON_LABEL_HEIGHT = 30,
	    AVG_LABEL_HEIGHT = 15,
	    SUM_LABEL_HEIGHT = AVG_LABEL_HEIGHT,
	    RECENT_LABEL_HEIGHT = 30;
	
	public PlayerDetailPanel(PlayerPO p, PlayerDetailFrame f) {
		playerPO = p;
		playerDetailFrame = f;
		playerDetailPanel = this;
		setBounds(0, 0, playerDetailFrame.getWidth(), playerDetailFrame.getHeight());
		setLayout(null);
		setOpaque(true);
		setBackground(Color.white);
		
		dataPanel = new DataPanel(playerPO);
		dataPanel.setBounds(PADDING, PADDING, Config.UI_WIDTH - PADDING * 2, DATA_PANEL_HEIGHT);
		add(dataPanel);
		
		seasonLabel = new JLabel("赛季数据", JLabel.LEFT);
		seasonLabel.setOpaque(true);
		seasonLabel.setFont(new Font("default", 0, 13));
		seasonLabel.setBackground(Color.black);
		seasonLabel.setForeground(Color.white);
		seasonLabel.setBounds(
				PADDING, dataPanel.getY() + dataPanel.getHeight() + PADDING,
				Config.UI_WIDTH - PADDING * 2, SEASON_LABEL_HEIGHT);
		add(seasonLabel);
		
		avgLabel = new JLabel("赛季场均", JLabel.LEFT);
		avgLabel.setOpaque(true);
		avgLabel.setFont(new Font("default", 0, 11));
		avgLabel.setBackground(Color.gray);
		avgLabel.setForeground(Color.white);
		avgLabel.setBounds(
				PADDING, seasonLabel.getY() + seasonLabel.getHeight(), 
				Config.UI_WIDTH - PADDING * 2, AVG_LABEL_HEIGHT);
		add(avgLabel);
		
		seasonAvgData = new TableGroup();
		TableFactory.createTable(
				seasonAvgData, playerDetailFrame,
				TableContentTransfer.transferPlayerAvgInfo(playerPO),
				Config.UI_WIDTH - PADDING * 2, SEASON_AVG_DATA_TABLE_HEIGHT,
				PADDING, avgLabel.getY() + avgLabel.getHeight());
		paintTable(seasonAvgData.table);
		seasonAvgData.table.setForeground(Color.WHITE);
		
		sumLabel = new JLabel("赛季总计", JLabel.LEFT);
		sumLabel.setOpaque(true);
		sumLabel.setFont(new Font("default", 0, 11));
		sumLabel.setBackground(Color.gray);
		sumLabel.setForeground(Color.white);
		sumLabel.setBounds(
				PADDING, seasonAvgData.jsp.getY() + seasonAvgData.jsp.getHeight(), 
				Config.UI_WIDTH - PADDING * 2, SUM_LABEL_HEIGHT);
		add(sumLabel);
		
		seasonSumData = new TableGroup();
		TableFactory.createTable(
				seasonSumData, playerDetailFrame,
				TableContentTransfer.transferPlayerTotalInfo(playerPO),
				Config.UI_WIDTH - PADDING * 2, SEASON_SUM_DATA_TABLE_HEIGHT,
				PADDING, sumLabel.getY() + sumLabel.getHeight());
		paintTable(seasonSumData.table);
		seasonSumData.table.setForeground(Color.WHITE);
		
		recentLabel= new JLabel("最近五场比赛", JLabel.LEFT);
		recentLabel.setFont(new Font("default", 0, 13));
		recentLabel.setBackground(Color.BLACK);
		recentLabel.setForeground(Color.white);
		recentLabel.setOpaque(true);
		recentLabel.setBounds(
				PADDING, seasonSumData.jsp.getY() + seasonSumData.jsp.getHeight() + PADDING,
				Config.UI_WIDTH - PADDING * 2, RECENT_LABEL_HEIGHT);
		add(recentLabel);
		
		recentData = new TableGroup();
		TableFactory.createTable(
				recentData, playerDetailFrame,
				TableContentTransfer.transferPlayerRecentGameInfo(playerPO),
				Config.UI_WIDTH - PADDING * 2, RECENT_DATA_TABLE_HEIGHT,
				PADDING, recentLabel.getY() + recentLabel.getHeight());
		paintTable(recentData.table);
		recentData.table.setForeground(Color.white);
		addLinks();
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(Config.getPlayers().get(8).getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
	/**
	 * 添加链接
	 */
	private void addLinks() {
		dataPanel.teamLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TeamDetailFrame(TeamListPO.findTeamByShortName(playerPO.getTeam(Config.LASTEST_SEASON)));
			}
		});
		
		recentData.table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = recentData.table.rowAtPoint(e.getPoint());
				if(row == 0) return;
				MatchPO m = MainFrame.mainFrame.bl.findMatch(
						TableContentTransfer.getSeasonByString(recentData.table.getValueAt(row, 0).toString()),
						recentData.table.getValueAt(row, 1).toString(),
						recentData.table.getValueAt(row, 2).toString().replace('@', '-'));
				new MatchInfoDetailFrame(m);
			}
		});
		
	}
	
	/**
	 * 画table格样式
	 * @param table
	 */
	public static void paintTable(JTable table) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				if(row == 0) setBackground(new Color(255, 255, 255, 90)); 
				else if(row % 2 != 0) setBackground(new Color(255, 255, 255, 40)); 
				else setBackground(new Color(255, 255, 255, 0)); 
				
				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			}
			
		};
		
		table.setDefaultRenderer(Object.class, dtcr);
	}
	
	private static final String PLAYER_DETAIL_TOP_BG = "images/player_detail_bg.png";
	/**
	 * 包括头像以及一些基础信息的一个panel,位于布局最上方
	 * @author hutao
	 *
	 */
	class DataPanel extends JPanel {
		public JLabel bgLabel;
		public JLabel headLabel, teamLabel;
		public JLabel 
		    ballNum,
		    name;
		public JLabel
		    info1, info2, info3, info4, info5, info6;
		
		
		public DataPanel(PlayerPO p) {
			setLayout(null);
			setBackground(Color.white);
			
			headLabel = new JLabel();
			headLabel.setBounds(20, 45, 230, 185);
			fillLabel(p.getPortraitURL(), headLabel, headLabel.getWidth(), headLabel.getHeight());
			
			
			add(headLabel);
			

			teamLabel = new JLabel();
			TeamPO tp = TeamListPO.findTeamByShortName(playerPO.getTeam(Config.LASTEST_SEASON));
			teamLabel.setBounds(450, 80, 80, 80);
			fillLabel(tp.getTeamLogoURL(), teamLabel, teamLabel.getWidth(), teamLabel.getHeight());
			add(teamLabel);
			
			ballNum = new JLabel(p.getNumber(), JLabel.RIGHT);
			ballNum.setBounds(350, 15, 80, 80);
			ballNum.setFont(new Font("default", 0, 50));
			add(ballNum);
			name = new JLabel(p.getName()); 
			name.setFont(new Font("default", 0, 25));
			name.setBounds(450, 40, 200, 50);
			add(name);
			
			int delta = 30;
			info1 = new JLabel("身高/体重 : " + p.getHeight() + "(英尺-英寸)/" + p.getWeight() + "(磅)");
			info1.setFont(new Font("default", 2, 20));
			info1.setBounds(650, 50, 400, delta);
			add(info1);
			info2 = new JLabel("生日 : " + p.getBirth());
			info2.setFont(new Font("default", 2, 20));
			info2.setBounds(650, info1.getY() + delta, 400, delta);
			add(info2);
			info3 = new JLabel("所在地 : " + p.getPosition());
			info3.setFont(new Font("default", 2, 20));
			info3.setBounds(650, info2.getY() + delta, 400, delta);
			add(info3);
			info4 = new JLabel("球龄 : " + p.getExp() + "年");
			info4.setFont(new Font("default", 2, 20));
			info4.setBounds(650, info3.getY() + delta, 400, delta);
			add(info4);

			bgLabel = new JLabel();
			PlayerDetailPanel.fillLabel(PLAYER_DETAIL_TOP_BG, bgLabel, Config.UI_WIDTH - PADDING * 2, DATA_PANEL_HEIGHT);
			bgLabel.setBounds(0, 0, Config.UI_WIDTH - PADDING * 2, DATA_PANEL_HEIGHT);
			add(bgLabel);
		}
		
	}
	
	/**
	 * 将图片改变大小后填充进jlabel
	 * @param url
	 * @param label
	 * @param width
	 * @param height
	 */
	public static void fillLabel(String url, JLabel label, int width, int height) {
		Image i = null;
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		try {
			i = ImageIO.read(new File(url));
		} catch(IOException e) {
			e.printStackTrace();
		}
		bi.getGraphics().drawImage(i, 0, 0, width, height, null);
		label.setIcon(new ImageIcon((Image)bi));
	}
	
	
}
