import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel_Game implements MouseListener {

	public JPanel mainPanel;
	public JPanel panel_Game;
	public CardLayout card;
	public JFrame main_frame;
	public JLabel score_text;
	public JLabel[] btn = new JLabel[9];
	public int score;
	PopManager gameManager;
	
	public Panel_Game(JPanel mainPanel, JFrame main_frame, CardLayout card) {
		
		this.mainPanel = mainPanel;
		this.card = card;
		this.main_frame = main_frame;
		
		//게임패널 생성
		panel_Game = new JPanel();
		panel_Game.setLayout(null);
		panel_Game.setSize(400, 600);
		panel_Game.setBackground(Color.white);
		mainPanel.add("game", panel_Game);
		
		//스코어박스 생성
		JLabel score_label = new JLabel();
		score_label.setBounds(60, 50, 266, 80);
		score_label.setIcon(new ImageIcon("img/스코어칸.jpg"));
		score_label.setName("scoreBox");
		panel_Game.add(score_label);
		
		//스코어텍스트 생성
		score_text = new JLabel("0", JLabel.RIGHT);
		Font score_text_Font = new Font(null, 1, 25);
		score_text.setBounds(15, 15, 236, 50);
		score_text.setForeground(Color.BLUE);
		score_text.setFont(score_text_Font);
		score_label.add(score_text);
		
		//버튼라벨 생성
		int grow_width = 55;
		int grow_height = 170;
		
		for(int count = 0 ; count < 9 ; count++ ){
				
			btn[count] = new JLabel();
			
			btn[count].setBounds(grow_width, grow_height, 80, 80);
			btn[count].setIcon(new ImageIcon("img/빈버튼.jpg"));
			grow_width += 100;
			
			if( (count+1)  % 3 == 0 ){
				grow_width = 55;
				grow_height += 100;
			}
			
			panel_Game.add(btn[count]);	
			
		}
		
		//게임시작 버튼 생성
		JLabel gameStartBtn = new JLabel();
		gameStartBtn.setBounds(20, 489, 163, 58);
		gameStartBtn.setIcon(new ImageIcon("img/Start.jpg"));
		gameStartBtn.addMouseListener(this);
		gameStartBtn.setName("gameStartBtn");
		panel_Game.add(gameStartBtn);
		
		//돌아가기 버튼 생성
		JLabel come_back_btn = new JLabel();
		come_back_btn.setBounds(193, 490, 173, 55);
		come_back_btn.addMouseListener(this);
		come_back_btn.setIcon(new ImageIcon("img/돌아가기.jpg"));
		come_back_btn.setName("come_back");
		panel_Game.add(come_back_btn);
		
		
	}
	
	
	public void setScore(int getScore) {
		
		score_text.setText(score + getScore + "");
	}
	
	public void resetScore() {
		
		score = 0;
		score_text.setText("");
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
		if (arg0.getComponent().getName() == "gameStartBtn") {
			
			gameManager = new PopManager(btn, panel_Game);
				
		} else if (arg0.getComponent().getName() == "come_back") {
			
			if(gameManager != null) {
			
				gameManager.stopGame();
			}

			main_frame.setSize(500, 600);
			card.show(mainPanel, "menu");
				
		}
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		JLabel btn;
		
		if (arg0.getComponent().getName() == "gameStartBtn"){
			
			btn = (JLabel)arg0.getComponent();
			btn.setIcon(new ImageIcon("img/Start2.jpg"));
		
		} else if (arg0.getComponent().getName() == "come_back"){
			
			btn = (JLabel)arg0.getComponent();
			btn.setIcon(new ImageIcon("img/돌아가기2.jpg"));
		
		}
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		JLabel btn;
		
		if (arg0.getComponent().getName() == "gameStartBtn"){
			
			btn = (JLabel)arg0.getComponent();
			btn.setIcon(new ImageIcon("img/Start.jpg"));
		
		} else if (arg0.getComponent().getName() == "come_back"){
			
			btn = (JLabel)arg0.getComponent();
			btn.setIcon(new ImageIcon("img/돌아가기.jpg"));
		
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
