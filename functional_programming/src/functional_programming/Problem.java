package functional_programming;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Problem {

	private int val;
	
	public void setVal(int i) {
		val = i;
	}
	
	public static void main(String[] args) {
		Map hashmap = new TreeMap();
		hashmap.put(10, "India");
		hashmap.put(2, "France");
		hashmap.put(2, "Germany");
		//hashmap.put(null, null);
		System.out.println(hashmap);
	}
}

