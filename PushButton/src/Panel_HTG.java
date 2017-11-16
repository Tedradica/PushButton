import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel_HTG implements MouseListener  {
	
	JPanel mainPanel;
	JPanel panel_HTG;
	JFrame main_frame;
	CardLayout card;
	
	public Panel_HTG (JPanel mainPanel, JFrame main_frame, CardLayout card){
		
		this.mainPanel = mainPanel;
		this.main_frame = main_frame;
		this.card = card;
		
		
		//게임설명 패널 생성
		panel_HTG = new JPanel();
		panel_HTG.setLayout(null);
		panel_HTG.setSize(600, 600);
		panel_HTG.setBackground(Color.white);
		mainPanel.add("HTG", panel_HTG);
		
		//게임설명 타이틀 라벨 생성
		JLabel titleLabel = new JLabel();
		titleLabel.setBounds(120, 50, 319, 72);
		titleLabel.setIcon(new ImageIcon("img/how_to_play.jpg"));
		panel_HTG.add(titleLabel);
		
		
		//게임 버튼 설명 라벨 생성	
		JLabel how_to_button = new JLabel();
		how_to_button.setBounds(20, 150, 241, 304);
		how_to_button.setIcon(new ImageIcon("img/게임설명.jpg"));
		panel_HTG.add(how_to_button);
		
		//게임 점수 설명 라벨 생성
		JLabel how_to_score = new JLabel();
		how_to_score.setBounds(270, 300, 293, 154);
		how_to_score.setIcon(new ImageIcon("img/게임설명2.jpg"));
		panel_HTG.add(how_to_score);
		
		//컴백버튼 생성
		JLabel come_back_btn = new JLabel();
		come_back_btn.addMouseListener(this);
		come_back_btn.setIcon(new ImageIcon("img/돌아가기.jpg"));
		come_back_btn.setName("come_back");
		come_back_btn.setBounds(370, 480, 173, 55);
		panel_HTG.add(come_back_btn);
		
		
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getComponent().getName() == "come_back") {
			
			main_frame.setSize(500, 600);
			card.show(mainPanel, "menu");
			
		} 
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		JLabel btn;
		
		if(arg0.getComponent().getName() == "come_back") {
			
			btn = (JLabel)arg0.getComponent();
			btn.setIcon(new ImageIcon("img/돌아가기2.jpg"));
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		JLabel btn;
		
		if(arg0.getComponent().getName() == "come_back") {
			
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
