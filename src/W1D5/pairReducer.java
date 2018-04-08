package W1D5;

import java.util.ArrayList;
import java.util.List;



public class pairReducer<K extends Comparable , V> {
	
	private K key ;
	private List<V> list = new ArrayList<V>(); 
	
	
	public pairReducer (K key , V value) {
		
		this.key = key ;
		this.list.add(value);
		
	}
	
	public void addValue(V value) {
		
		this.list.add(value);
	}
	
	public K getKey() {
		
		return this.key;
	}
	
	
public static List<pairReducer> addList(List<pairMapper> keyvalue){
		
		List<pairReducer> result = new ArrayList<>();
		
		for (int i = 0 ; i < keyvalue.size();i++) {
			
			int sizeResult =  result.size();
			if (sizeResult ==0) {
				pairReducer temp = new pairReducer(keyvalue.get(i).getKey(),keyvalue.get(i).getValue());  
				result.add(temp);
				
			}
			
			else {
			
			
				// check key already exist
				Pair k1 = (Pair)keyvalue.get(i).getKey();
				Pair k2 = (Pair)result.get(sizeResult-1).getKey();
			  
			  if (k1.equals(k2)) {
				  
				  pairReducer temp = result.get(sizeResult-1);
				  temp.addValue(keyvalue.get(i).getValue());
				  result.set(sizeResult-1,temp);
				  
			  } 
			  
			  else {
			  
			  // add List when key not yet exist
			  
				  
				  pairReducer temp = new pairReducer(keyvalue.get(i).getKey(),keyvalue.get(i).getValue());
				  
				  result.add(temp);
			  }
			  
			  }
			 	  

		}	
		
		return result;
	
}
	
	
	public String toString() {
		return "<" +key.toString() + ", " + list.toString()+">";
	}

	public String toStringSum() {
		
		//return "<" + key.toString() + ", " + list.stream().mapToLong(x->(Long)x).sum() + ">";
		
		return "<" + key.toString() + ", " + list.stream().count() + ">";
		
		


	}
	

}
