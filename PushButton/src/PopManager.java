import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PopManager implements Runnable {

	JLabel[] btnList;
	JPanel gamePanel;
	boolean stop = false;
	
	public PopManager(JLabel[] btnList, JPanel gamePanel) {
		
		this.btnList = btnList;
		this.gamePanel = gamePanel;
		
		Thread t = new Thread(this);
		t.start();
	}
	
	public void setPop(JLabel Btn, JPanel gamePanel, int btnNum) {
		
		new PopBtn(Btn, gamePanel, btnNum);
	}
	
	public void stopGame() {
		
		stop = true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int ramdomNumOne;
		int ramdomNumTwo;
		int[] btnNum = {0, 1, 2, 3, 4, 5, 6, 7, 8};
		int temp;
		stop = false;
		
		for(int i = 0; i < 15; i++) {
			
			if(stop) {
				
				for(int j = 0; j < 9; j++) {
					
					btnList[j].setIcon(new ImageIcon("img/빈버튼.jpg"));
				}
				break;
			}
			
			for(int ran = 0; ran < (int)(Math.random() * 50) + 1; ran++) {
				
				ramdomNumOne = (int)(Math.random() * 9);
				ramdomNumTwo = (int)(Math.random() * 9);
				
				temp = btnNum[ramdomNumOne];
				btnNum[ramdomNumOne] = btnNum[ramdomNumTwo];
				btnNum[ramdomNumTwo] = temp;
			}
			
			for(int j = 0; j < (int)(Math.random() * 3) + 1; j++) {
			
				setPop(btnList[btnNum[j]], gamePanel, btnNum[j]);
			}
			
			
			try {
				
				if(gamePanel.getName() == "low_Level") {
				
					Thread.sleep(3000);
					
				} else if(gamePanel.getName() == "mid_Level") {
					
					Thread.sleep(2000);
					
				} else if(gamePanel.getName() == "high_Level") {
					
					Thread.sleep(1000);
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//점수저장
		if(!stop){
			
			int socre;
			
			for(int i = 0; i < gamePanel.getComponentCount(); i++) {
				
				if(gamePanel.getComponent(i).getName() == "scoreBox") {
					
					JLabel scoreLabel = (JLabel)gamePanel.getComponent(i);
					scoreLabel = (JLabel)scoreLabel.getComponent(0);
					socre = Integer.parseInt(scoreLabel.getText());

					System.out.println("Your Score is " + socre + "!");
				}
			}
		
		}
		
		//점수 초기화
		for(int i = 0; i < gamePanel.getComponentCount(); i++) {
			
			if(gamePanel.getComponent(i).getName() == "scoreBox") {
				
				JLabel scoreLabel = (JLabel)gamePanel.getComponent(i);
				scoreLabel = (JLabel)scoreLabel.getComponent(0);
				scoreLabel.setText("0");
			}
		}
		
	}
}
