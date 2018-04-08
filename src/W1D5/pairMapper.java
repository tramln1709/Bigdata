package W1D5;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;



public class pairMapper<K extends Comparable , V> implements Comparable {
	
	private K key ;
	private V value ;
	
	
	public K getKey() {
		return this.key;
	}
	
	public V getValue() {
		return this.value;
	}
	
	public void setKey(K key) {
		
		this.key = key;
	}
	
	public void setValue(V value) {
		
		this.value = value;
	}
	
	public pairMapper(K key , V value) {
		
		this.key = key;
		this.value = value;
	}

	@Override
	public int compareTo(Object o) {
		
		return this.key.compareTo(((pairMapper)o).getKey());
	}
	
	public String toString() {
		
		return "(" + this.key + ", " + this.value + ")"; 
	}
	
	
	public List<pairMapper> mapper(String doc){
		
		List<pairMapper> result = new ArrayList<pairMapper>();
		
		String[] source ;
		
		source = doc.split("\\s+");
		
		for (int i=0;i<source.length;i++) {
			int j = i+1;
			while ((source[j]!=source[i]) && j<source.length) {
				Pair pair = new Pair((String)source[i],(String)source[j]);
				pairMapper pairvalue = new pairMapper<Pair, Integer>((Pair)pair,1);
				result.add(pairvalue);
			}
		}
		
		
		result.sort(Comparator.comparing(pairMapper::getKey));
		
		
		return result;
		
		
	}
	

}
