package NewSwing;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;






public class SignUpFrame extends JFrame implements ActionListener{

	
	String path = "C:\\Users\\Lenovo\\Desktop\\Picture//UserInfo.txt";
	
	Container sContainer = getContentPane();
	
	JLabel bgImage = new JLabel(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Picture//New.jpg"));
	
	JTextField fnTextField = new JTextField();
	JTextField lnTextField = new JTextField();
	JTextField idTextField = new JTextField();
	
	JLabel reg = new JLabel("Register");
	JLabel TextFieldlbl = new JLabel("First Name : ");
	JLabel LastName = new JLabel("Last Name : ");
	JLabel UserN =new JLabel("Email : ");
	JLabel Password = new JLabel("Password : ");
	JPasswordField passwordField = new JPasswordField();

	JButton regButton = new JButton("Create Account");
    JButton backButton = new JButton("Back");

    public SignUpFrame()
	{
		this.setTitle("CONCENTRATION - Sign Up");
        this.setBounds(300, 60, 700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Lenovo\\Desktop\\Picture//newlogo.png"));
	
		Initialize();
        addActionEvent();
	}
	
    public void Initialize()
	{
		sContainer.setLayout(null);
		
		reg.setBounds(225, 0, 280, 100);
		reg.setForeground(new Color(215,0,0));
		reg.setFont(new Font("Arial Black",Font.BOLD,40));
		reg.setHorizontalAlignment(SwingConstants.CENTER);
		sContainer.add(reg);

		
		fnTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		fnTextField.setBounds(398, 182, 270, 28);
        fnTextField.setToolTipText("First name");
        fnTextField.setFont(new Font("Arial Black", Font.PLAIN, 15));
        sContainer.add(fnTextField);
        
        TextFieldlbl.setBounds(280, 142, 200, 100); 
        TextFieldlbl.setForeground(new Color(255, 255, 255));
        TextFieldlbl.setFont(new Font("San Francisco",Font.BOLD,18));
        sContainer.add(TextFieldlbl);
        
        lnTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		lnTextField.setBounds(398, 242, 270, 28);
        lnTextField.setToolTipText("Last name");
        lnTextField.setFont(new Font("Arial Black", Font.PLAIN, 15));
        sContainer.add(lnTextField);
        
        LastName.setBounds(280, 202, 200, 100); 
        LastName.setForeground(new Color(255, 255, 255));
        LastName.setFont(new Font("San Francisco",Font.BOLD,18));
        sContainer.add(LastName);
        
        idTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        idTextField.setBounds(398, 302, 270, 28);
        idTextField.setToolTipText("User ID");
        idTextField.setFont(new Font("Arial Black", Font.PLAIN, 15));
        sContainer.add(idTextField);

      

        UserN.setBounds(310, 262, 200, 100); 
        UserN.setForeground(new Color(255, 255, 255));
        UserN.setFont(new Font("San Francisco",Font.BOLD,18));
        sContainer.add(UserN);
        
        passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        passwordField.setBounds(398, 362, 270, 28);
        passwordField.setToolTipText("Password");
        passwordField.setFont(new Font("Arial Black", Font.PLAIN, 15));
        sContainer.add(passwordField);
        
        Password.setBounds(285, 322, 200, 100); 
        Password.setForeground(new Color(255, 255, 255));
        Password.setFont(new Font("San Francisco",Font.BOLD,18));
        sContainer.add(Password);
        
        
        
        
        
        regButton.setBounds(397, 425, 200, 37);
        regButton.setBorderPainted(false);
        regButton.setBackground(new Color(159,89,155));
        regButton.setForeground(Color.WHITE);
        regButton.setFont(new Font("San Francisco", Font.BOLD, 15));
        sContainer.add(regButton);
        
        backButton.setBounds(397, 490, 78, 40);
        backButton.setBorderPainted(false);
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(new Color(159,89,155));
        backButton.setFont(new Font("San Francisco", Font.BOLD, 14));
        sContainer.add(backButton);
        
        bgImage.setBounds(0, 0, 800, 585);
		bgImage.setHorizontalAlignment(SwingConstants.CENTER);
		bgImage.setOpaque(true);
		sContainer.add(bgImage);
        
	}
	
	private void addActionEvent() {
		// TODO Auto-generated method stub
		backButton.addActionListener(this);
        regButton.addActionListener(this);
	}



	public boolean check(String email)
	{
		String line;
		try {
			FileReader fr = new FileReader(path);
	        BufferedReader br = new BufferedReader(fr);
	        
	        while ((line = br.readLine()) != null)
	        {
	        	if(email.split("@")[0].equalsIgnoreCase(line.split(" ")[2].split("@")[0]))
	        	{
	        		return true;
	        	}
	        }
		}
		catch (Exception ep) {
			System.out.println("ERROR 404! File-Not-Found");
            //ep.printStackTrace();
        }
		return false;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean done=false;
		if (e.getSource() == backButton) 
		{
			this.setVisible(false);
			LoginFrame l = new LoginFrame();
			l.setVisible(true);
		}
		if (e.getSource() == regButton) 
		{
			try
			{
			      if(!check(idTextField.getText()))
			      {
			    	  done=true;
			    	  FileWriter myWriter = new FileWriter(path,true);
			    	  myWriter.write(fnTextField.getText()+" "+lnTextField.getText()+" "+idTextField.getText()+" "+passwordField.getText()+"\n");
				      myWriter.close();
				      JOptionPane.showMessageDialog(null, "Successfully Registered! Please Login to continue...","Confirmation", JOptionPane.WARNING_MESSAGE);
			      }
			      else
			      {
			    	  JOptionPane.showMessageDialog(null, "Email already in use!","Confirmation", JOptionPane.WARNING_MESSAGE);
			      }
			 }
			catch (IOException ep) {
			      System.out.println("ERROR 404! File-Not-Found");
			      ep.printStackTrace();
			}
			
			
			if(done==true) {
		
				path = "C:\\Users\\Lenovo\\Desktop\\Picture//workh.txt";
				try {
					String email=idTextField.getText();
					System.out.println(email);
					FileWriter Writer = new FileWriter(path,true);
			    	Writer.write(email.split("@")[0]+ " " + 0 + "\n");
				    Writer.close();
				}
				catch (IOException epp) {
					// TODO: handle exception
				}
				
			}
			
			
		}
		
	}
	
}
