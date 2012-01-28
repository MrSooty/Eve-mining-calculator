import javax.swing.JComboBox;
import javax.swing.JTextField;


public class CalculateOreValue {

	double OreValue;
	int RefineLevel;
	double StationTax;
	
	public CalculateOreValue(JComboBox OreList, JTextField OreQuantity, int RefineIndex, double Tax)
	{
		int SelectedOre = OreList.getSelectedIndex();
		int SelectedQuantity = Integer.parseInt(OreQuantity.getText());
		RefineLevel = RefineIndex;
		StationTax = Tax;
		//Initialise the selected ore. 
		//TODO - Create singletons for initialisation so we only have 1 instance of each object.
		switch(SelectedOre){
			case 0:  
				Ore Veldspar = new Ore();
				Veldspar.setTritaniumConstant(3.28);
				Veldspar.setMarketValue(0.5);
				Veldspar.setQuantity(SelectedQuantity);
				
				Calculate(Veldspar);
				break;
				
			case 1: 
				Ore ConcentratedVeldspar = new Ore();
				ConcentratedVeldspar.setTritaniumConstant(3.28);
				ConcentratedVeldspar.setMarketValue(0.7);
				ConcentratedVeldspar.setQuantity(SelectedQuantity);
				
				Calculate(ConcentratedVeldspar);
				break;
		}
	}
	
	protected double GetOreValue(){
		return OreValue;
	}
	
	protected void SetOreValue(double d){
		OreValue = d;
	}
	
	/*
	 * Calculates the total value of the minerals from the given ore and quantity.
	 */
	public void Calculate(Ore ore){
		double Total;
		double LostOre;
		double Tax;
		double PreTaxMineral;
		double TritaniumAmount;
		
		
		double tritConstant = ore.getTritaniumConstant();
		double value = ore.getMarketValue();
		double quantity = ore.getQuantity();
		double refine = 0.1 + (RefineLevel * 0.01);
		double stationTax = StationTax;
		
		Total = quantity * tritConstant;
		LostOre = Total * (-refine);
		PreTaxMineral = Total + LostOre;
		Tax = PreTaxMineral * stationTax;
		TritaniumAmount = PreTaxMineral - Tax;
		
		OreValue = TritaniumAmount * value;
		
	}
}

	
