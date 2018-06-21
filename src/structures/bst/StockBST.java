package structures.bst;

import java.util.List;
//import java.util.stream.Collectors;

import structures.loader.DataLoader;
import structures.loader.NasdaqDataLoader;
import structures.model.PublicStock;

public class StockBST {
	
	public static StockBSTNode root;
	static StockBST tree;
	
	public static void main(String [] args){
		tree = new StockBST();
		tree.loadTree();
		
		System.out.println( tree.get("IRDM") );
		System.out.println( tree.get("LMAT") );
		System.out.println( tree.get("UPLD") );
		System.out.println( tree.get("XCRA") );
		
		// inplace update
		tree.put("XCRA", "Xcerra Corp.");
		System.out.println( tree.get("XCRA") );
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
}