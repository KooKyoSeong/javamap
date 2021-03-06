import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame{
	
	
	//private List<Marker> markers = new ArrayList<Marker>();
	private JTextField textField=new JTextField(30);
	private JButton button=new JButton("검색");
	private JPanel panel=new JPanel();
	private GoogleAPI googleAPI=new GoogleAPI();
	private JLabel googleMap=new JLabel();

	public class Event implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			setMap(textField.getText());
		}

		
		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
		

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}
	
	}
	
	public void setMap(String location) {		
		googleAPI.downloadMap(location);
		googleMap.setIcon(googleAPI.getMap(location));
		googleAPI.fileDelete(location);
		add(BorderLayout.NORTH,googleMap);
		pack();
	}
			
	public  Main() {
	
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(400,200); //숫자 바꾸면 생성위치 변경
		setResizable(true);  //지도 확대 축소(마우스로 확대)
		setTitle("together Maps");
		setVisible(true);
				
		setLocation(0,0); //숫자 바꾸면 생성위치 변경
		panel.add(textField);
		panel.add(button); 
		button.addMouseListener(new Event());	
		add(BorderLayout.NORTH,panel);
		pack();
	}

}
