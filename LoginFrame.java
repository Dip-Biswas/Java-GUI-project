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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;







public class LoginFrame extends JFrame implements ActionListener {

	Container container = getContentPane();
	
	JLabel appLabel = new JLabel("CONCENTRATION");
	JLabel loglbl = new JLabel("LOGIN");
	JLabel Teamlbl = new JLabel("Created By Dip , Hridoy and Nihal");
	JLabel userlbl = new JLabel("Email ID :");
	JLabel passlbl = new JLabel("Passoword: ");
	JLabel newlbl = new JLabel("Didn't Sign up Yet? ");
	
	
	JLabel bgImage = new JLabel(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Picture//new1.jpg"));
	
	JTextField user = new JTextField();
	JPasswordField pass = new JPasswordField();
	
	JButton loginbut=new JButton("Log In");
	JButton signbut= new JButton("SignUp");
	
	public LoginFrame() {
		// TODO Auto-generated constructor stub
		
		this.setTitle("CONCENTRATION - LoginFrame");
		this.setBounds(300, 50, 700, 600);
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Lenovo\\Desktop\\Picture//newlogo.jpg"));
		
		initializepage();
		addActionEvent();
	
	}
	
	private void initializepage() {
		container.setLayout(null); 
		
		appLabel.setBounds(185, 0, 380, 120);
		appLabel.setForeground(new Color(255, 255, 9));
		appLabel.setFont(new Font("Arial Black",Font.BOLD,30));
		//appLabel.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(appLabel);
		

		
		
		loglbl.setBounds(305, 80, 280, 100);
		loglbl.setForeground(new Color(215,0,0));
		loglbl.setFont(new Font("Arial Black",Font.BOLD,25));
		container.add(loglbl);
		
		
		
		 userlbl.setBounds(170, 180, 200, 100); 
		 userlbl.setForeground(new Color(255, 255, 255));
		 userlbl.setFont(new Font("San Francisco",Font.BOLD,20));
		 container.add(userlbl);
		 
		 user.setBounds(290, 220, 180, 23);
		 user.setBackground(new Color(255,170, 170));
		 container.add(user);
        

		 passlbl.setBounds(170, 230, 200, 100); 
		 passlbl.setForeground(new Color(255, 255, 255));
		 passlbl.setFont(new Font("San Francisco",Font.BOLD,20));
		 container.add(passlbl);
		 
		 pass.setBounds(290, 268, 180, 23);
		 pass.setBackground(new Color(255,170, 170));
		 container.add(pass);
		 
		 loginbut.setBounds(300, 340, 97, 35);
		 loginbut.setHorizontalTextPosition(SwingConstants.CENTER);
		 loginbut.setVerticalTextPosition(SwingConstants.CENTER);
		 loginbut.setFont(new Font("San Francisco", Font.BOLD, 17));
		 loginbut.setBorderPainted(false);
		 loginbut.setBackground(new Color(159,89,155));
		 loginbut.setForeground(Color.WHITE);
	     container.add(loginbut);
		 
	     newlbl.setBounds(160, 430, 200, 100); 
	     newlbl.setForeground(new Color(255, 255, 255));
	     newlbl.setFont(new Font("San Francisco",Font.BOLD,15));
		 container.add(newlbl);
		 
		 signbut.setBounds(315, 463, 95, 35);
		 signbut.setHorizontalTextPosition(SwingConstants.CENTER);
		 signbut.setVerticalTextPosition(SwingConstants.CENTER);
		 signbut.setFont(new Font("San Francisco", Font.BOLD, 17));
		 signbut.setBorderPainted(false);
		 signbut.setBackground(Color.white);
		 signbut.setForeground(new Color(159,89,155));
	     container.add(signbut);
		 
	     Teamlbl.setBounds(155,480,380,120);
	     Teamlbl.setForeground(new Color(210, 220, 230));
	     Teamlbl.setFont(new Font("Arial Black",Font.ITALIC,20));
			container.add(Teamlbl);
		 
		 
		//bgImage
		
		 
		 bgImage.setBounds(0, 0, 700, 600);
		 bgImage.setHorizontalAlignment(SwingConstants.CENTER);
		 bgImage.setOpaque(true); 
		 container.add(bgImage);
		 
		
	}

	private void addActionEvent() {
		loginbut.addActionListener(this);
		signbut.addActionListener(this);
	}


	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == loginbut) {
			
			
			
            
        	String userText;
            String passText;
            
            userText = user.getText();
            passText = pass.getText();
            
			try {
				String path = "C:\\Users\\Lenovo\\Desktop\\Picture//UserInfo.txt";
				
				
				FileReader fr = new FileReader(path);
	            BufferedReader br = new BufferedReader(fr);
	            
	            boolean isLoginSuccess = false;
	            int u=0;
	            String line, fuserEmail, fpass, fuserID;
	            
	            
	            while((line = br.readLine()) != null)
	            {	
	            	fuserEmail = line.split(" ")[2];
	                fpass = line.split(" ")[3];
	               
	                fuserID = fuserEmail;
	              
   					
	                
	                if (fuserID.equals(userText)  && fpass.equals(passText)) {
	                	isLoginSuccess = true;
	                	System.out.println("SUCCESS");
	                	this.setVisible(false);
		                
	                	HomePage dashboard = new HomePage(fuserEmail.split("@")[0]);
		                dashboard.setVisible(true);
	    				
		                break;
	                }
	                else if(fuserID.equalsIgnoreCase(userText) || fuserEmail.equalsIgnoreCase(userText))
	                {
	                	u++;
	                }    
	            }
	            if(!isLoginSuccess)
	            {
	            	if(u>0)
	            	{
	            		JOptionPane.showMessageDialog(null, "Invalid Password!", "WARNING!!", JOptionPane.WARNING_MESSAGE);
	            	}
	            	else
	            	{
	            		JOptionPane.showMessageDialog(null, "Invalid User!", "WARNING!!", JOptionPane.WARNING_MESSAGE);
	            	}
	            }
	            
	            fr.close();
				
			}
			catch (Exception ep) {
				System.out.println("ERROR 404! File-Not-Found");
	           
	        }
        }
		
		if (e.getSource() == signbut) {
        	this.setVisible(false);
            SignUpFrame s = new SignUpFrame();
            s.setVisible(true);
        }
		
		
		
		
		
	}

	

}
