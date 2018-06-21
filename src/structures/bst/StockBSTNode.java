package structures.bst;

public class StockBSTNode {
	
	protected String key;
	protected String value;
	protected StockBSTNode left, right;
	
	public StockBSTNode(String key,String value){
		this.key = key;
		this.value = value;
	}
	
	/** Method will either update the left node, right node, or perform
	 * an in-place update
	 * 
	 * @param key String
	 * @param value String
	 */
	public void put (String key, String value){
		if (key.compareTo(this.key) < 0){
			if (left != null){
				left.put(key, value);
			}
			else {
				left = new StockBSTNode(key, value);
			}
		}
		else if (key.compareTo(this.key) > 0){
			if (right != null){
				right.put(key, value);
			}
			else {
				right = new StockBSTNode(key,value);
			}
		}
		else {
			this.value = value;
		}
	}
	
	public String get(String key){
		if (this.key.equals(key)){
			return value;
		}
		
		if (key.compareTo(this.key) < 0){
			return left == null ? null : left.get(key);
		}
		else {
			return right == null ? null : right.get(key);
		}
	}
}