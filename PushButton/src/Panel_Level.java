import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel_Level implements MouseListener {
	
	public JPanel mainPanel;
	public JPanel panel_Level;
	public CardLayout card;
	public JFrame main_frame;
	public JPanel gamePanel;
	
	public Panel_Level(JPanel mainPanel, JFrame main_frame, CardLayout card, JPanel gamePanel) {
		
		this.mainPanel = mainPanel;
		this.card = card;
		this.main_frame = main_frame;
		this.gamePanel = gamePanel;
		
		//레벨패널 생성
		panel_Level = new JPanel();
		panel_Level.setSize(500, 500);
		panel_Level.setLayout(null);
		panel_Level.setBackground(Color.white);
		mainPanel.add("level", panel_Level);
		
		//레벨박스라벨 생성
		JLabel label_Level_Box = new JLabel();
		label_Level_Box.setIcon(new ImageIcon("img/랭킹내용.jpg"));
		label_Level_Box.setBounds(30, 50, 425, 340);
		panel_Level.add(label_Level_Box);
		
		//레벨타이틀라벨 생성	
		JLabel label_Level_Title = new JLabel();
		label_Level_Title.setIcon(new ImageIcon("img/레벨선택.jpg"));
		label_Level_Title.setBounds(40, 40, 345, 84);
		label_Level_Box.add(label_Level_Title);
		
		//초급버튼 생성
		JLabel low_level = new JLabel();
		low_level.addMouseListener(this);
		low_level.setIcon(new ImageIcon("img/초급.jpg"));
		low_level.setName("low_Level");
		low_level.setBounds(15, 170, 131, 81);
		label_Level_Box.add(low_level);
		
		//중급버튼 생성
		JLabel mid_level = new JLabel();
		mid_level.addMouseListener(this);
		mid_level.setIcon(new ImageIcon("img/중급.jpg"));
		mid_level.setName("mid_Level");
		mid_level.setBounds(146, 170, 131, 81);
		label_Level_Box.add(mid_level);
		
		//고급버튼 생성
		JLabel high_level = new JLabel();
		high_level.addMouseListener(this);
		high_level.setIcon(new ImageIcon("img/고급.jpg"));
		high_level.setName("high_Level");
		high_level.setBounds(277, 170, 131, 81);
		label_Level_Box.add(high_level);
		
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getComponent().getName() == "low_Level"){
			
			card.show(mainPanel, "game");
			main_frame.setSize(400, 600);
			gamePanel.setName("low_Level");
		}
		
		else if(arg0.getComponent().getName() == "mid_Level"){
			
			card.show(mainPanel, "game");
			main_frame.setSize(400, 600);
			gamePanel.setName("mid_Level");
		}
		
		else if(arg0.getComponent().getName() == "high_Level"){
			
			card.show(mainPanel, "game");
			main_frame.setSize(400, 600);
			gamePanel.setName("high_Level");
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		JLabel btn;
		
		if(arg0.getComponent().getName() == "low_Level") {
			
			btn = (JLabel)arg0.getComponent();
			btn.setIcon(new ImageIcon("img/초급2.jpg"));
			
		} else if (arg0.getComponent().getName() == "mid_Level") {
			
			btn = (JLabel)arg0.getComponent();
			btn.setIcon(new ImageIcon("img/중급2.jpg"));
			
		} else if (arg0.getComponent().getName() == "high_Level") {
			
			btn = (JLabel)arg0.getComponent();
			btn.setIcon(new ImageIcon("img/고급2.jpg"));
		
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel btn;
		
		if(arg0.getComponent().getName() == "low_Level") {
			
			btn = (JLabel)arg0.getComponent();
			btn.setIcon(new ImageIcon("img/초급.jpg"));
			
		} else if (arg0.getComponent().getName() == "mid_Level") {
			
			btn = (JLabel)arg0.getComponent();
			btn.setIcon(new ImageIcon("img/중급.jpg"));
			
		} else if (arg0.getComponent().getName() == "high_Level") {
			
			btn = (JLabel)arg0.getComponent();
			btn.setIcon(new ImageIcon("img/고급.jpg"));
		
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
