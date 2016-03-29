import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main extends Applet implements Runnable
{
	public static final Dimension SCREEN_SIZE = new Dimension(1000, 800);
	public static boolean isRunning = true;
	/*sample data starts here*/
	public static String airports[] =
		 { "YVR", "PEK",
		 "ICN", "BOM", "PVG" };
	public static String[] columnNames = {"ac_name",
			"flightNumber",
            "departureTime",
            "arrivalTime",
            "modelNumber",
            "departureAirport",
            "arrivalAirport"};

	public static Object[][] data;
//	= {
//			{"Kathy", "Smith",
//				"Snowboarding", new Integer(5), new Boolean(false)},
//			{"John", "Doe",
//					"Rowing", new Integer(3), new Boolean(true)},
//			{"Sue", "Black",
//						"Knitting", new Integer(2), new Boolean(false)},
//			{"Jane", "White",
//							"Speed reading", new Integer(20), new Boolean(true)},
//			{"Joe", "Brown",
//								"Pool", new Integer(10), new Boolean(false)}
//	};
	/*sample data ends*/
	
	public static JFrame frame = new JFrame("CPSC304 Airport DatatBase Application");
	public static JFrame loginframe = new JFrame("CPSC304 Airport DatatBase Application");
	/*components in login frame*/
	public static JPanel loginpanel1 = new JPanel();
	public static JPanel loginpanel2 = new JPanel();
	public static JPanel loginpanel3 = new JPanel();
	public static JLabel loginlabel1 = new JLabel("Username:");
	public static JLabel loginlabel2 = new JLabel("Password:");
	public static JLabel loginlabel3 = new JLabel("Username and Password do not match");
	public static JTextField textfield1 = new JTextField("",20);
	public static JTextField textfield2 = new JTextField("",20);
	public static JButton loginbtn1 = new JButton("Login");
	
	/*components in frame*/
	public static JPanel panel1 = new JPanel();
	public static JPanel panel2 = new JPanel();
	public static JLabel label = new JLabel("Please Select Airport");
	public static JButton refreshbtn = new JButton("Refresh");
	public static JButton confirmbtn = new JButton("Confirm");
	public static JComboBox airportsel = new JComboBox( airports );
	
	public static void main(String[] args)
	{
	/*loginframe setup*/
		loginframe.setSize(SCREEN_SIZE);
		loginframe.setLayout(new GridLayout(3,4));
		loginpanel1.setLayout(new FlowLayout(FlowLayout.CENTER,2,0));
		loginpanel2.setLayout(new FlowLayout(FlowLayout.CENTER,2,0));
		loginpanel1.add(loginlabel1);
		loginpanel1.add(textfield1);
		loginpanel2.add(loginlabel2);
		loginpanel2.add(textfield2);
		loginpanel3.add(loginbtn1);
		loginbtn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		loginframe.add(loginpanel1);
		loginframe.add(loginpanel2);
		loginframe.add(loginpanel3);
		loginframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		loginframe.pack();
		loginframe.setVisible(false);
		
   /*frame setup*/
		frame.setSize(SCREEN_SIZE);
		frame.setLayout(new BorderLayout());
		/*panel setup*/
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER,4,3));
		panel1.add(label);
		panel1.add(airportsel);
		panel1.add(refreshbtn);
		panel1.add(confirmbtn);
		/*Events hook up*/
		confirmbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Object[] temp;
				int i = 0;
			    for (Airliner a : Database.getAirlinersByPassportNumber(950474950)) {
			    	temp = null;
			    	temp.add(a.ac_name);
			    	temp.add(a.flightNumber);
			    	temp.add(a.departureTime);
			    	temp.add(a.arrivalTime);
			    	temp.add(a.modelNumber);
			    	temp.add(a.departureAirport);
			    	temp.add(a.arrivalAirport);
			    	data[i] = temp;
			    }
				JTable table = new JTable(data, columnNames);
				table.setPreferredScrollableViewportSize(new Dimension(500, 200));
		        table.setFillsViewportHeight(true);
				JScrollPane scrollPane = new JScrollPane(table);
				panel2.add(scrollPane);
				frame.add(panel2, BorderLayout.CENTER);
			}
		});
		/*table setup*/
        /*add components into fram*/
		frame.add(panel1, BorderLayout.NORTH);
//		frame.add(panel2, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	





	public Main()
	{
		setPreferredSize(SCREEN_SIZE);
		frame = new JFrame();
	}
	public void init()
	{
		
	}
	public void tick()
	{
	
	}
	public void render()
	{
	
	}
	public void run()
	{
		init();
		while(isRunning)
		{
			tick();
			render();
			try{ Thread.sleep(50);}
			catch(InterruptedException ie){} 
		}
	}
	public void stop()
	{
		isRunning = false;
	}
	
}