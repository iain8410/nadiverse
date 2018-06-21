package structures;

import java.util.List;

import structures.model.PublicStock;

public interface TableStructure {
	
	public List<PublicStock> getAll();
	public PublicStock get(String key);
	public void load();
	public void update(String key, PublicStock publicStock);

}
