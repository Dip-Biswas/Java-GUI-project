package NewSwing;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Activity  extends JFrame implements ActionListener{
	public static int count=0;
	public static String hourString;
	JLabel wlc=new JLabel("");
	JLabel nameJLabel= new JLabel();
	JLabel workh=new JLabel();
	
	Container container = getContentPane();
	JLabel bgImage = new JLabel(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Picture//blue1.jpg"));
	
	JButton back=new JButton("Back");
	
	public static String user;
	
	public Activity(String user) {

	
        this.user=user;
        this.setTitle("CONCENTRATION- Activity Log");
        this.setBounds(300, 60, 700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setResizable(false);
        this.setLayout(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Lenovo\\Desktop\\Picture//newlogo.jpg"));
        
        String path = "C:\\Users\\Lenovo\\Desktop\\Picture//workh.txt";
		try {
			FileReader reader = new FileReader( path );
            BufferedReader br = new BufferedReader(reader);
            String line,workuser,workhour;
            while((line=br.readLine())!=null) {
            	workuser=line.split(" ")[0];
            	workhour=line.split(" ")[1];
            	
            	if(workuser.equals(user)) {
            		hourString=workhour;
            	}
            	
            }
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("FILE NOT FOUND - WorkH");
		}
		
		
        Initialize();
        addActionEvent();
	
	}
	
	private void Initialize() {
		// TODO Auto-generated method stub
		wlc = new JLabel("Activity Log" );
		wlc.setBounds(170, 0, 350, 100);
		wlc.setForeground(Color.red);
		wlc.setFont(new Font("Dosis SemiBold",Font.BOLD,50));
		wlc.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(wlc);
		
		nameJLabel.setText(String.valueOf(user)+"'s Record ");
		nameJLabel.setBounds(260, 120, 400, 100);
		nameJLabel.setForeground(Color.black);
		nameJLabel.setFont(new Font("Dosis SemiBold",Font.BOLD,35));
		container.add(nameJLabel);
		
		workh.setText("Your total working time : " + String.valueOf(hourString)+" minutes");
		workh.setBounds(120, 230, 500, 100);
		workh.setForeground(Color.black);
		workh.setFont(new Font("Dosis SemiBold",Font.BOLD,25));
		container.add(workh);
		
		
		back.setBounds(305, 400, 78, 40);
		back.setBorderPainted(false);
		back.setBackground(Color.WHITE);
		back.setForeground(new Color(159,89,155));
		back.setFont(new Font("San Francisco", Font.BOLD, 14));
        container.add(back);
		
		bgImage.setBounds(0, 0,700, 600);
		bgImage.setOpaque(true);
		container.add(bgImage);
		
	}
	private void addActionEvent() {
		// TODO Auto-generated method stub
		back.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			this.setVisible(false);
			HomePage homePage=new HomePage(user);
			homePage.setVisible(true);
		}
	}


}
