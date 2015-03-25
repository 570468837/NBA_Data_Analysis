package com.kmno4.presentation.table;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;
import com.kmno4.presentation.button.BorderLabel;

/**
 * 
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class SlideTable extends JPanel {
	private JLabel
	    left,
	    right;
	private SmallTable table;
	private SlideThread slideThread;
	
	public SlideTable(String[] headStr, String[][] bodyString) {
		this(headStr, bodyString, 0, 0, TABLE_UNIT_WIDTH * headStr.length, TABLE_HEIGHT);
	}
	private static final int TABLE_HEIGHT = 50;
	private static final int TABLE_UNIT_WIDTH = 66;
	
	
	public SlideTable(String[] headStr, String[][] bodyString, int x, int y, int width, int height) {
		super();
		max_address = Config.PLAYER_DETAIL_UI_WIDTH / TABLE_UNIT_WIDTH - headStr.length;
		setLayout(null);
		table = new SmallTable(headStr, bodyString);
		table.setLocation(x, y);
		table.setSize(width, height);
		add(table);
		
		left = new BorderLabel("←", JLabel.CENTER);
		left.setBounds(x, table.getHeight() + y, FLIG_LABEL_WIDTH, (int)(height * FLIG_LABEL_HEIGHT_RATE));
		left.setEnabled(false);
		left.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if(!left.isEnabled()) return;
				moving = MOVING_LEFT; 
			}
			public void mouseExited(MouseEvent e) {
				if(!left.isEnabled()) return;
				moving = MOVING_NONE; 
			}
		});
		add(left);
		
		right = new BorderLabel("→", JLabel.CENTER);
		right.setBounds(x + left.getWidth(), left.getY(), FLIG_LABEL_WIDTH, (int)(height * FLIG_LABEL_HEIGHT_RATE));
		right.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if(!right.isEnabled()) return;
				moving = MOVING_RIGHT;
			}
			public void mouseExited(MouseEvent e) {
				if(!right.isEnabled()) return;
				moving = MOVING_NONE;
			}
		});
		add(right);
	}
	private static final int FLIG_LABEL_WIDTH = 50;
	private static final double FLIG_LABEL_HEIGHT_RATE = 0.3;
	
	private int current_address = 0;
	private final int max_address;
	private int moving = 0;
	private static final int
	    MOVING_LEFT = -1,
	    MOVING_NONE = 0,
	    MOVING_RIGHT = 1,
	    MOVING_DIE = 2;
	
	
	
	
	
	
	public void setFont(Font headFont, Font bodyFont, Font labelFont) {
		table.setFont(headFont, bodyFont);
		if(labelFont != null) {
			left.setFont(labelFont);
			right.setFont(labelFont);
		}
	}
	public void setForeground(Color headColor, Color bodyColor, Color labelColor) {
		table.setForeground(headColor, bodyColor);
		if(labelColor != null) {
			left.setForeground(labelColor);
			right.setForeground(labelColor);
		}
	}
	public void setBackground(Color headbg, Color bodybg, Color labelbg, Color bg) {
		super.setBackground(bg);
		table.setBackground(headbg, bodybg);
		if(labelbg != null) {
			left.setBackground(labelbg);
			right.setBackground(labelbg);
		}
	}
	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		if(!aFlag) { moving = MOVING_DIE; }
		else {
			if(slideThread != null && slideThread.isAlive()) return;
			moving = MOVING_NONE;
			slideThread = new SlideThread();
			slideThread.start();
		}
	}
	
	
	class SlideThread extends Thread {
		public void run() {
			while(moving != MOVING_DIE) {
				 
			}
		}
	}
}

