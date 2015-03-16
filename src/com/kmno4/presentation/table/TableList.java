package com.kmno4.presentation.table;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 单个列表行
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class TableList extends JPanel {
	public JLabel[] elements;
	
	
	public TableList(String[] ele, int type) {
		super();
		setLayout(new FlowLayout());
		
		elements = new JLabel[ele.length];
		switch(type) {
		case HEAD : 
			setBackground(HEAD_COLOR);
			break;
		case SING : 
			setBackground(SING_COLOR);
			break;
		case DOUB : 
			setBackground(DOUB_COLOR);
			break;
		default :
		}
		
		for(int i = 0; i < ele.length; i ++) {
			elements[i] = new JLabel(ele[i]);
			if(type != HEAD) elements[i].setFont(BODY_FONT);
			else elements[i].setFont(HEAD_FONT);
			add(elements[i]);
		}
	}
	
	
	public static final int 
        HEAD = -1,
        SING = 0,
        DOUB = 1;
	private static final Color
	    HEAD_COLOR = new Color(255, 200, 0, 200),
	    SING_COLOR = new Color(192, 192, 192, 200),
	    DOUB_COLOR = new Color(255, 255, 255, 200);
	private static final Font
	    HEAD_FONT = new Font("Arial", Font.BOLD, 25),
	    BODY_FONT = new Font("Arial", Font.PLAIN, 20);
	
	
}