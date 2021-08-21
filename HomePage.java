package NewSwing;


import javax.swing.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomePage extends JFrame implements ActionListener{
	Container container = getContentPane();
	JLabel bgImage = new JLabel(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Picture//homebg2.jfif"));
	
	
	JLabel wlc=new JLabel("");
	JLabel pr=new JLabel("PROMODORO");
	
	Icon act = new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Picture//act.png");
	JButton actbut = new JButton(act);
	
	Icon todo = new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Picture//todo.png");
	JButton todobut = new JButton(todo);
	
	Icon pomo = new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Picture//pomo.png");
	JButton pomobut = new JButton(pomo);
	
	Icon today = new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Picture//ex.jpg");
	JButton todaybut = new JButton(today);
	
	JButton backbut= new JButton("Back");
	JTextArea textArea = new JTextArea(
			"The Pomodoro Technique is a time management method developed by "
			+ "Francesco Cirillo in the late 1980s.The technique uses a timer to break down work "
			+ "into intervals, traditionally 25 minutes in length, separated by short "
			+ "breaks\n\n"
			+"There are six steps in the original technique:\r\n"
			+ "\r\n"
			+ "1. Decide on the task to be done.\r\n"
			+ "2. Set the pomodoro timer (traditionally to 25 minutes).\r\n"
			+ "3. Work on the task.\r\n"
			+ "4. End work when the timer rings and put a checkmark on a piece of paper.\r\n"
			+ "5. If you have fewer than four checkmarks, take a short break (3–5 minutes) and then return to step 2; otherwise continue to step 6.\r\n"
			+ "6. After four pomodoros, take a longer break (15–30 minutes), reset your checkmark count to zero, then go to step 1.");
			
		
	
	
	public static String user;
	
	public HomePage(String user)
	{
        this.user = user;
        this.setTitle("CONCENTRATION - HomePage");
        this.setBounds(300, 60, 700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setResizable(false);
        this.setLayout(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Lenovo\\Desktop\\Picture//newlogo.jpg"));
        
        Initialize();
        addActionEvent();
	}
	
	
	
	private void Initialize() {
		// TODO Auto-generated method stub
		wlc = new JLabel("Welcome "+user,SwingConstants.CENTER);
		
		wlc.setBounds(180, 0, 350, 100);
		wlc.setForeground(Color.cyan);
		wlc.setFont(new Font("Dosis SemiBold",Font.BOLD,40));
		wlc.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(wlc);
		
		pr.setBounds(380, 80, 350, 100);
		pr.setForeground(Color.yellow);
		pr.setFont(new Font("Sherif",Font.BOLD,20));
		pr.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(pr);
		
	
		textArea.setBounds(400, 150, 280, 330);
		textArea.setFont(new Font("Arial Black", Font.ITALIC, 10));
		textArea.setBackground(new Color(255,135,0));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		container.add(textArea);

	/*	userTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		userTextField.setBounds(400, 150, 300, 330);
		userTextField.setToolTipText("Details");
		userTextField.setFont(new Font("Arial Black", Font.ITALIC, 15));
        container.add(userTextField);
        userTextField.setSize(400,400);
		*/
		actbut.setBounds(50, 150, 300, 50);
		//actbut.setBorderPainted(false);
		container.add(actbut);
		
		todobut.setBounds(50, 240, 300, 50);
		container.add(todobut);
		
		pomobut.setBounds(50, 330, 300, 50);
		container.add(pomobut);
		
		todaybut.setBounds(50, 420, 300, 50);
		container.add(todaybut);
		
		 backbut.setBounds(315, 503, 95, 35);
		 backbut.setHorizontalTextPosition(SwingConstants.CENTER);
		 backbut.setVerticalTextPosition(SwingConstants.CENTER);
		 backbut.setFont(new Font("San Francisco", Font.BOLD, 17));
		 backbut.setBorderPainted(false);
		 backbut.setBackground(Color.white);
		 backbut.setForeground(new Color(159,89,155));
	     container.add(backbut);
		
		bgImage.setBounds(0, 0,700, 600);
		bgImage.setOpaque(true);
		container.add(bgImage);
	}

	private void addActionEvent() {
		actbut.addActionListener(this);
		todobut.addActionListener(this);
		pomobut.addActionListener(this);
		backbut.addActionListener(this);
		todaybut.addActionListener(this);
	}


	@Override
    public void actionPerformed(ActionEvent e) {
		if(e.getSource() == actbut) {
			this.setVisible(false);
			Activity a = new Activity(user);
			a.setVisible(true);
		}
		if(e.getSource() == todobut) {
			this.setVisible(false);
			ToDo t = new ToDo(user);
			t.setVisible(true);
			
		}
		if(e.getSource() == pomobut) {
			this.setVisible(false);
			PomoTimer tm = new PomoTimer(user);
			tm.setVisible(true);
			
		}
		if (e.getSource() == backbut) {
        	this.setVisible(false);
            LoginFrame s = new LoginFrame();
            s.setVisible(true);
		}
		if(e.getSource() == todaybut) {
			this.setVisible(true);
			 
			 JOptionPane.showMessageDialog(null, "For more Information Go to \nhttps://todoist.com/productivity-methods/pomodoro-technique\n ");
		}
			
			
		}
	}

