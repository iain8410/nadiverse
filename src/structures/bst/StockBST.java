package structures.bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.util.stream.Collectors;

import structures.commands.ApplicationCommands;
import structures.loader.DataLoader;
import structures.loader.NasdaqDataLoader;
import structures.model.PublicStock;

public class StockBST {
	
	public static StockBSTNode root;
	static StockBST tree;
	
	public static void main(String [] args){
		tree = new StockBST();
		tree.loadTree();
		
		if (args[0].equalsIgnoreCase("getstock")){
			ApplicationCommands appCommand = tree.new GetStockList();
			List<PublicStock> filteredList = appCommand.getStocks("APPN", "LMAT", "XCRA", "AABA", "AAL", "AROW", "ARQL", "ASFI", "ASCMA", "ANY");
			filteredList.stream().forEach( f -> System.out.println(f.getTicker()) );
		}
		else {
			System.out.println( tree.get("IRDM") );
			System.out.println( tree.get("LMAT") );
			System.out.println( tree.get("UPLD") );
			System.out.println( tree.get("XCRA") );
			
			// inplace update
			tree.put("XCRA", "Xcerra Corp.");
			System.out.println( tree.get("XCRA") );
		}
	}
	
	public void put(String key, String value){
		if (root == null){
			root = new StockBSTNode(key,value);
		}
		else {
			root.put(key, value);
		}
	}
	
	public String get(String key){
		return root == null ? null : root.get(key);
	}
	
	private void loadTree(){
		DataLoader dataLoader = new NasdaqDataLoader();
		List<PublicStock> publicStocks = dataLoader.load();
		publicStocks.stream().forEach( p -> tree.put(p.getTicker(), p.getCompanyName()) );
	}
	
	private class GetStockList implements ApplicationCommands {

		@Override
		public List<PublicStock> getStocks(String... tickers) {
			if (tickers.length > ApplicationCommands.MAX_TICKERS){
				throw new IllegalArgumentException("Requested tickers exceeds max number");
			}
			
			List<PublicStock> stocks = new ArrayList<PublicStock>();
			List<String> symbols = Arrays.asList(tickers);
			symbols.stream().forEach( s -> stocks.add( new PublicStock(tree.get(s), null) ));
			
			return stocks;
		}
		
	}
}