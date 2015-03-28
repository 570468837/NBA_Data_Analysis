package com.kmno4.presentation;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import PO.PlayerListPO;
import PO.PlayerPO;
import PO.TeamListPO;
import PO.TeamPO;

import com.kmno4.common.Config;
import com.kmno4.presentation.button.ExitLabel;
import com.kmno4.presentation.table.Table;
import com.kmno4.presentation.table.TableList;

@SuppressWarnings("serial")
public class TopTabPanel extends JPanel implements MouseListener{
	
	public List<JLabel> tabs;
	
	private JLabel player;
	private JLabel match;
	private JLabel team;
	private JLabel help;
	private JLabel aboutus;
	private JLabel close;
	

	/**
	 * 用于引用当前显示的表格
	 */
	private Table tableBeShowing;


	/**
	 * Create the panel.
	 */
	public TopTabPanel() {
		
		this.setBounds(0, 0, Config.UI_WIDTH, Config.TOP_TAB_HEIGHT);
		this.setBackground(Color.GRAY);
		setLayout(null);
		
		
		close = new ExitLabel(MainFrame.mainFrame);
		add(close);
		
		
		player = new JLabel("球员");
		player.addMouseListener(this);
		player.setIcon(Config.TAB_PLAYER_UNPRESSED);
		team = new JLabel("球队");
		team.addMouseListener(this);
		team.setIcon(Config.TAB_TEAM_UNPRESSED);
		match = new JLabel("比赛");
		match.addMouseListener(this);
		match.setIcon(Config.TAB_MATCH_UNPRESSED);
		help = new JLabel("帮助");
		help.addMouseListener(this);
		help.setIcon(Config.TAB_HELP_UNPRESSED);
		aboutus = new JLabel("关于");
		aboutus.addMouseListener(this);
		aboutus.setIcon(Config.TAB_ABOUT_UNPRESSED);

		tabs=new ArrayList<JLabel>();
		
		tabs.add(player);
		tabs.add(team);
		tabs.add(match);
		tabs.add(help);
		tabs.add(aboutus);
		
		for(int i=0;i<tabs.size();i++){
			tabs.get(i).setBounds(Config.UI_WIDTH-(tabs.size()-i)*Config.TOP_TAB_LABLE_WIDTH, 
					Config.TOP_TAB_HEIGHT-Config.TOP_TAB_LABLE_HEIGHT, 
					Config.TOP_TAB_LABLE_WIDTH,
					Config.TOP_TAB_LABLE_HEIGHT);
			tabs.get(i).setBackground(Color.WHITE);
			this.add(tabs.get(i));
		}
		
		player.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//显示playerPanel，移开其他panel,所有PANEL统一隐藏在Frame左边
				MainFrame.mainFrame.playerSelectionPanel.setBounds(0, Config.TOP_TAB_HEIGHT+Config.INTRODUCTION_WHITE, 
						Config.UI_WIDTH, Config.SELECTION_HEIGHT);
				MainFrame.mainFrame.teamSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
				MainFrame.mainFrame.pageInfoPanel.refreshInfo(Pages.Player.toString());
				
				refreshPlayerTable(MainFrame.mainFrame.players);
				MainFrame.mainFrame.repaint();
			}

		});
		team.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//显示teamPanel，移开其他panel,所有PANEL统一隐藏在Frame左边
				MainFrame.mainFrame.playerSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.INTRODUCTION_WHITE, 
						Config.UI_WIDTH, Config.SELECTION_HEIGHT);
				MainFrame.mainFrame.teamSelectionPanel.setBounds(0, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
				MainFrame.mainFrame.pageInfoPanel.refreshInfo(Pages.Team.toString());
				
				refreshTeamTable(MainFrame.mainFrame.teams);
				MainFrame.mainFrame.repaint();
			}
		});
		match.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//显示matchPanel，移开其他panel,所有PANEL统一隐藏在Frame左边
				MainFrame.mainFrame.playerSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.INTRODUCTION_WHITE, 
						Config.UI_WIDTH, Config.SELECTION_HEIGHT);
				MainFrame.mainFrame.teamSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
				MainFrame.mainFrame.pageInfoPanel.refreshInfo(Pages.Match.toString());
				
				refreshMatchTable();
				MainFrame.mainFrame.repaint();
			}
		});
		
		refreshPlayerTable(MainFrame.mainFrame.players);
	}
	
	
	
	//画背景
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Config.TOP_TAB_BACKGROUND.getImage(), 0, 0,Config.UI_WIDTH,Config.TOP_TAB_HEIGHT,this);
	}
	
	/**
	 * 每次调用即刷新player列表
	 * @param players
	 */
	public void refreshPlayerTable(List<PlayerPO> players){
		if(tableBeShowing != null) {
			tableBeShowing.setVisible(false);
			MainFrame.mainFrame.remove(tableBeShowing);
		}
		tableBeShowing = new Table(
			Config.PLAYER_BASIC_INFO,
			TableContentTransfer.transferPlayerBasicInfo(Config.PLAYER_BASIC_INFO.length, players));
		setTableBounds();
		MainFrame.mainFrame.add(tableBeShowing);
		addPlayerLink();
	}
	/**
	 * 刷新team列表
	 * @param teams
	 */
	public void refreshTeamTable(ArrayList<TeamPO> teams) {
		if(tableBeShowing != null) {
			tableBeShowing.setVisible(false);
			MainFrame.mainFrame.remove(tableBeShowing);
		}
		tableBeShowing = new Table(
				Config.TEAM_BASIC_INFO, 
				TableContentTransfer.transferTeamBasicInfo(Config.TEAM_BASIC_INFO.length, teams));
		setTableBounds();
		MainFrame.mainFrame.add(tableBeShowing);
		addTeamLink();
	}
	/**
	 * 刷新match列表
	 */
	public void refreshMatchTable() {
		if(tableBeShowing != null) {
			tableBeShowing.setVisible(false);
			MainFrame.mainFrame.remove(tableBeShowing);
		}
		tableBeShowing = new Table(
				new String[]{"a", "b", "c", "d"}, 
				new String[][]{
						{"match1", "---", "---", "---"},
						{"match2", "---", "---", "---"}
				});
		setTableBounds();
		MainFrame.mainFrame.add(tableBeShowing);
	}
	
	private void setTableBounds() {
		int y = Config.TOP_TAB_HEIGHT + Config.INTRODUCTION_WHITE + Config.SELECTION_HEIGHT + 10;
		tableBeShowing.setBounds(
				0, 
				y,
				Config.UI_WIDTH,
				Config.UI_HEIGHT - y);
	}
	
	private static final int PLAYER_LINK = 0;
	private void addPlayerLink() {
		TableList[][] t = tableBeShowing.body;
		for(int i = 0; i < t.length; i ++) {
			for(int j = 0; j < t[0].length; j ++) {
				if(t[i][j].elements.length == 0) return;
			    final JLabel label = t[i][j].elements[PLAYER_LINK];
				label.addMouseListener(new MouseAdapter() {
					HeadIconFrame headIconFrame;
					@Override
					public void mouseClicked(MouseEvent e) {
						PlayerPO p = PlayerListPO.findPlayerByName(label.getText());
						if(p == null) return;
						new PlayerDetailFrame(p).setVisible(true);
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						/*
						headIconFrame = new HeadIconFrame(
								PlayerListPO.findPlayerByName(label.getText()),
								,
								);
						*/
					}
					@Override
					public void mouseExited(MouseEvent e) {
						//TODO
					}
				});
			}
		}
		
	}
	private static final int TEAM_LINK = 0;
	private static final int SHORT_NAME_LABEL = 1;
	private void addTeamLink() {
		TableList[][] t = tableBeShowing.body;
		for(int i = 0; i < t.length; i ++) {
			for(int j = 0; j < t[0].length; j ++) {
				if(t[i][j].elements.length == 0) return;
			    JLabel label = t[i][j].elements[TEAM_LINK];
			    final JLabel shortNameLabel = t[i][j].elements[SHORT_NAME_LABEL];
				label.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						TeamPO t = TeamListPO.findTeamByShortName(shortNameLabel.getText());
						if(t == null) return;
						new TeamDetailFrame(t).setVisible(true);
					}
				});
			}
		}
	}



	@Override
	public void mouseClicked(MouseEvent e) {
	}



	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource()==player){
			player.setIcon(Config.TAB_PLAYER_CLICKED);
		}if(e.getSource()==team){
			team.setIcon(Config.TAB_TEAM_CLICKED);
		}if(e.getSource()==match){
			match.setIcon(Config.TAB_MATCH_CLICKED);
		}if(e.getSource()==help){
			help.setIcon(Config.TAB_HELP_CLICKED);
		}if(e.getSource()==aboutus){
			aboutus.setIcon(Config.TAB_ABOUT_CLICKED);
		}
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource()==player){
			player.setIcon(Config.TAB_PLAYER_UNPRESSED);
		}if(e.getSource()==team){
			team.setIcon(Config.TAB_TEAM_UNPRESSED);
		}if(e.getSource()==match){
			match.setIcon(Config.TAB_MATCH_UNPRESSED);
		}if(e.getSource()==help){
			help.setIcon(Config.TAB_HELP_UNPRESSED);
		}if(e.getSource()==aboutus){
			aboutus.setIcon(Config.TAB_ABOUT_UNPRESSED);
		}
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==player){
			player.setIcon(Config.TAB_PLAYER_ENTERED);
		}if(e.getSource()==team){
			team.setIcon(Config.TAB_TEAM_ENTERED);
		}if(e.getSource()==match){
			match.setIcon(Config.TAB_MATCH_ENTERED);
		}if(e.getSource()==help){
			help.setIcon(Config.TAB_HELP_ENTERED);
		}if(e.getSource()==aboutus){
			aboutus.setIcon(Config.TAB_ABOUT_ENTERED);
		}
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==player){
			player.setIcon(Config.TAB_PLAYER_UNPRESSED);
		}if(e.getSource()==team){
			team.setIcon(Config.TAB_TEAM_UNPRESSED);
		}if(e.getSource()==match){
			match.setIcon(Config.TAB_MATCH_UNPRESSED);
		}if(e.getSource()==help){
			help.setIcon(Config.TAB_HELP_UNPRESSED);
		}if(e.getSource()==aboutus){
			aboutus.setIcon(Config.TAB_ABOUT_UNPRESSED);
		}
		
	}
	
}
