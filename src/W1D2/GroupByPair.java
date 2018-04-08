package W1D2;

import java.util.ArrayList;
import java.util.List;

import W1D1.Keyvalue;


public class GroupByPair <K,V> {
	
	private K key ;
	private List<V> list = new ArrayList<V>(); 
	
	public GroupByPair (K key , V value) {
		
		this.key = key ;
		this.list.add(value);
		
	}
	
	public void addValue(V value) {
		
		this.list.add(value);
	}
	
	public K getKey() {
		
		return this.key;
	}
	
	public static List<GroupByPair> addList(List<Keyvalue> keyvalue){
		
		List<GroupByPair> result = new ArrayList<>();
		
		for (int i = 0 ; i < keyvalue.size();i++) {
			
			int sizeResult =  result.size();
			if (sizeResult ==0) {
				GroupByPair temp = new GroupByPair(keyvalue.get(i).getKey(),keyvalue.get(i).getValue());  
				result.add(temp);
				
			}
			
			else {
			
			
				// check key already exist
				String k1 = (String)keyvalue.get(i).getKey();
				String k2 = (String)result.get(sizeResult-1).getKey();
			  
			  if (k1.equals(k2)) {
				  
				  GroupByPair temp = result.get(sizeResult-1);
				  temp.addValue(keyvalue.get(i).getValue());
				  result.set(sizeResult-1,temp);
				  
			  } 
			  
			  else {
			  
			  // add List when key not yet exist
			  
				  
				  GroupByPair temp = new GroupByPair(keyvalue.get(i).getKey(),keyvalue.get(i).getValue());
				  
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
		
		return "<" + key.toString() + ", " + list.stream().mapToLong(x->(Long)x).sum() + ">";
		
		
		


	}
	
}
