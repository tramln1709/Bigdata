package W1D1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;



//author : Ngoc Tram Ly 985671

@SuppressWarnings("rawtypes")

public class Keyvalue<K extends Comparable , V > implements Comparable   {
	
	
	private K key ;
	private V value;
	

    public K getKey() {
    	
 
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Keyvalue(K key, V value){
        this.key = key;
        this.value = value;
    }

    public int compareTo(Object o) {
        return this.key.compareTo(((Keyvalue)o).getKey());
     
        
        
    }
    @Override
    public String toString(){
        return "(" + this.key+", "+this.value+")";
    }

    
    public static List<Keyvalue>extract(String filename){
    	
    	List<Keyvalue> result = new ArrayList<Keyvalue>();
    	Map<String, Long> maptemp = new HashMap();
    	 
    	
    	
    	
 
    	try {
    		
    	 maptemp= Files.lines(Paths.get(filename))
    			 				.map(line->line.split("\\s+"))
    			 				.flatMap(Arrays::stream)
    			 				.map(line -> line.split("[-,\"\']"))
    			 				.flatMap(Arrays::stream)
    			 				.filter(w -> w.matches("[a-zA-Z]+."))
    			 				.map(w->new Keyvalue<String,Integer>
    			 				 (w.toLowerCase().replace(".", "").replace("]", ""),1))
    			 				.sorted()
    			 				.collect(Collectors.groupingBy((x->(String)((Keyvalue)x).getKey()),Collectors.counting()));
    	
    			 
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    	
    	
    		 for (Entry<String, Long> entry : maptemp.entrySet()) {
          	  result.add(new Keyvalue(entry.getKey(), entry.getValue()));
           	
    	}
    			 
    	return result ;
    	
    	
    }



}
