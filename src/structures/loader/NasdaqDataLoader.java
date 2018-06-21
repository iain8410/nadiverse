package structures.loader;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

import structures.model.PublicStock;

public class NasdaqDataLoader implements DataLoader{

	public NasdaqDataLoader() {
		super();
	}
	
	@Override
	public List<PublicStock> load() {
		List<PublicStock> publicStocks = new ArrayList<PublicStock>();
		
		try {
			publicStocks = loadTree();
		}
		catch (IOException io){
			io.printStackTrace();
		}
		
		return publicStocks;
	}

	private List<PublicStock> loadTree() throws IOException {
		FileReader fileReader = new FileReader("/Users/iain/projects/stocks/public-stocks.txt");
		LineNumberReader lnr = new LineNumberReader(fileReader);
		String line = null;
		List<PublicStock> publicStocks = new ArrayList<PublicStock>();
		
		while ( (line = lnr.readLine()) != null){
			if (lnr.getLineNumber() == 1){
				continue;
			}
			
			String [] lineContents = line.split("\\|");
			publicStocks.add( new PublicStock(lineContents[0], lineContents[1]) );
		}
		
		lnr.close();
		fileReader.close();
		
		return publicStocks;
	}

	

}