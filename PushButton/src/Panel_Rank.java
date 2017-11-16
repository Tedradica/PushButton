import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel_Rank implements MouseListener  {
	
	JPanel mainPanel;
	JFrame main_frame;
	CardLayout card;
	JPanel panel_Rank;
	JLabel rank_Text;
	
	public Panel_Rank (JPanel mainPanel, JFrame main_frame, CardLayout card){
		
		this.mainPanel = mainPanel;
		this.main_frame = main_frame;
		this.card = card;
		
		//랭킹 패널 생성
		panel_Rank = new JPanel();
		panel_Rank.setLayout(null);
		panel_Rank.setSize(500, 600);
		panel_Rank.setBackground(Color.white);
		panel_Rank.setName("panel_Rank");
		mainPanel.add("rank", panel_Rank);
				
		//랭킹 타이틀 라벨 생성
		JLabel rank_title = new JLabel();
		rank_title.setBounds(85, 20, 313, 80);
		rank_title.setIcon(new ImageIcon("img/랭킹.jpg"));
		panel_Rank.add(rank_title);
		
		//랭킹박스 라벨 생성
		JLabel rank_Box = new JLabel();
		rank_Box.setBounds(25, 125, 425, 340);
		rank_Box.setIcon(new ImageIcon("img/랭킹내용.jpg"));
		rank_Box.setName("rank_Box");
		panel_Rank.add(rank_Box);

		//랭킹내용 라벨 생성
		rank_Text = new JLabel("랭킹보기는 구현을 하지 못했습니다.");
		rank_Text.setBounds(15, 15, 410, 325);
		rank_Text.setFont(new Font(null, 1, 24));
		rank_Box.add(rank_Text);
		
		//돌아가기
		JLabel come_back_btn = new JLabel();
		come_back_btn.setBounds(290, 490, 173, 55);
		come_back_btn.addMouseListener(this);
		come_back_btn.setIcon(new ImageIcon("img/돌아가기.jpg"));
		come_back_btn.setName("come_back");
		panel_Rank.add(come_back_btn);
		
		
		
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		if (arg0.getComponent().getName() == "come_back"){
			
			main_frame.setSize(500, 600);
			card.show(mainPanel, "menu");
				
		}		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		JLabel btn;
		
		if (arg0.getComponent().getName() == "come_back"){
			
			btn = (JLabel)arg0.getComponent();
			btn.setIcon(new ImageIcon("img/돌아가기2.jpg"));
		
		}
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		JLabel btn;
		
		if (arg0.getComponent().getName() == "come_back"){
			
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
