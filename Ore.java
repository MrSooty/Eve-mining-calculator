
public class Ore {

	private double TritaniumConstant = 0.00;
	private double MarketValue = 0.00;
	private double Quantity = 0;
	
	protected double getTritaniumConstant(){
		return TritaniumConstant;
	}
	
	protected void setTritaniumConstant(double n){
		this.TritaniumConstant = n;
	}
	
	protected double getMarketValue(){
		return MarketValue;
	}
	
	protected void setMarketValue(double n){
		this.MarketValue = n;
	}
	
	protected double getQuantity(){
		return Quantity;
	}
	
	protected void setQuantity(int i){
		this.Quantity = i;
	}
}

