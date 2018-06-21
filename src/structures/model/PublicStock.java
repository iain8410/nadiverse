package structures.model;

public class PublicStock {

	private String ticker;
	private String companyName;
	
	public PublicStock(String ticker, String companyName) {
		super();
		this.ticker = ticker;
		this.companyName = companyName;
	}
	public String getTicker() {
		return ticker;
	}
	public String getCompanyName() {
		return companyName;
	}
	
	@Override
	public String toString() {
		return "PublicStock [ticker=" + ticker + ", companyName=" + companyName + "]";
	}
	
}
