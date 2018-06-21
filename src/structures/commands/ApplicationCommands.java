package structures.commands;

import java.util.List;

import structures.model.PublicStock;

public interface ApplicationCommands {

	public static final int MAX_TICKERS = 10;
	
	public List<PublicStock> getStocks(String ... tickers);
}
