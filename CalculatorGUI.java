import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CalculatorGUI extends JFrame implements ActionListener {

	/*
	 * Setting up the main window
	 */
	private JPanel titlePanel = new JPanel();
	private JFrame MainFrame = new JFrame();
	private JMenuBar MainMenuBar = new JMenuBar();
	private JMenu File = new JMenu("File");
	private JMenu Calculators = new JMenu("Calculators");
	private JMenuItem RefineryMarket = new JMenuItem("Refinery Market");
	private JMenuItem MoneyPerHour = new JMenuItem("ISK per Hour");
	private JMenuItem Quit = new JMenuItem("Quit");
	
	/*
	 * Labels to be used in conjunction with text fields and lists
	 */
	private JLabel MainPageTitle = new JLabel("Mr Sooty's Refinery Factory");
	private JLabel OreTitle = new JLabel("Ore Selection:");
	private JLabel QuantityTitle = new JLabel("Ore Quantity:");
	private JLabel MineralTitle = new JLabel("Refines into:");
	private JLabel RefineTitle = new JLabel("Refinery Level:");
	private JLabel StationTaxTitle = new JLabel("Station Tax:");
	private JLabel TritaniumTitle = new JLabel("Tritanium:");
	private JLabel PyeriteTitle = new JLabel("Pyerite:");
	private JLabel OreValueTitle = new JLabel("Ore Value:");
	private JLabel MineralValueTitle = new JLabel("Mineral Total Value:");
	private JLabel DifferenceTitle = new JLabel("Price difference");
	
	/*
	 * Text Fields to be used
	 */
	private JTextField OreQuantity = new JTextField(null);
	private JTextField CalculatedTritanium = new JTextField(null);
	private JTextField CalculatedPyerite = new JTextField(null);
	private JTextField StationTaxTextField = new JTextField(null);
	private JTextField OreValueTextField = new JTextField(null);
	private JTextField MineralValue = new JTextField(null);
	private JTextField PriceDifference = new JTextField(null);

	/*
	 * Ore List dropdown menu/list
	 */
	String [] OresList = {"Veldspar","Concentrated Veldspar","Dense Veldspar","Scordite","Condensed Scordite","Massive Scordite"};
	JComboBox OreList = new JComboBox(OresList); //creates new JList with the OresList array

	
	/*
	 * Refine level dropdown menu/list
	 */
	String [] Refine = {"0","1","2","3","4","5"};
	JComboBox RefineryLevel = new JComboBox(Refine); //creates new JList with the OresList array
	
	public CalculatorGUI()
	{
		
		this.setTitle("MrSooty's EvE Mining Calculators v0.01");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * Build the menu
		 */
		this.setJMenuBar(MainMenuBar);
		
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(500,300));
		setVisible(true);
		
		/*
		 * File
		 *  |-> Calculators
		 *  		|-> Refinery Market
		 *  		|-> Money Per Hour
		 *  
		 * TODO: add actionlisteners for buttons. 
		 */
		MainMenuBar.add(File);
		File.add(Calculators);
		File.addSeparator();
		File.add(Quit);
		Calculators.add(RefineryMarket);
		Calculators.add(MoneyPerHour);
		
		//Start layout
		add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new GridLayout(1,1));
		titlePanel.add(MainPageTitle);
		
		JPanel mainPanel = new JPanel();
		add(mainPanel, BorderLayout.NORTH);
		mainPanel.setLayout(new GridLayout(2,4));
		mainPanel.add(OreTitle);
		mainPanel.add(OreList);
		mainPanel.add(RefineTitle);
		mainPanel.add(RefineryLevel);
		mainPanel.add(QuantityTitle);
		mainPanel.add(OreQuantity);
		mainPanel.add(StationTaxTitle);
		mainPanel.add(StationTaxTextField);
		
		JPanel refinePanel = new JPanel();
		add(refinePanel, BorderLayout.CENTER);
		refinePanel.setLayout(new GridLayout(5,2));
		refinePanel.add(TritaniumTitle);
		refinePanel.add(CalculatedTritanium);
		refinePanel.add(PyeriteTitle);
		refinePanel.add(CalculatedPyerite);
		refinePanel.add(OreValueTitle);
		refinePanel.add(OreValueTextField);
		refinePanel.add(MineralValueTitle);
		refinePanel.add(MineralValue);
		refinePanel.add(DifferenceTitle);
		refinePanel.add(PriceDifference);
		
		JPanel buttonPanel = new JPanel();
		JButton submitButton = new JButton("Calculate");
		add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.add(submitButton);
		submitButton.addActionListener(this);
		//End layour
					
		/*
			private JLabel OreValueTitle = new JLabel("Ore Value:");
			private JTextField OreValueTextField = new JTextField(null);
			
			private JLabel MineralValueTitle = new JLabel("Mineral Total Value:");
			private JTextField mineralValue = new JTextField(null);
			
			private JLabel DifferenceTitle = new JLabel("Difference between Ore and Mineral price:");
			private JTextField PriceDifference = new JTextField(null);
		 */
		
		pack();
		setVisible(true);
		
		/*
		 * add the action listeners
		 * 
		 * optionMenu.add(quit);
		 * quit.addActionListener(this);
		 */
		
	}//end CalculatorGUI
		
	public void actionPerformed(ActionEvent arg0) {
		//TODO - Perform validity checks...
		//TODO - Perform checks on which button was pressed
		CalculateOreValue c = new CalculateOreValue(OreList, OreQuantity, GetRefineryLevel(), GetStationTax());
		double a = c.GetOreValue();
		OreValueTextField.setText(Double.toString(a));
	}
	
	protected int GetRefineryLevel(){
		return RefineryLevel.getSelectedIndex();
	}
	
	protected double GetStationTax(){
		return Double.valueOf(StationTaxTextField.getText()).doubleValue();
	}	
		
		
		
}//end Class
