

package W1D3;
import W1D1.Keyvalue;
import W1D2.GroupByPair;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q2 {
	
	final static int m =3;// numbers of Map
	final static int r=3 ; // number of Reducers

	
	
	public int getPartition(String key){
		if(key.compareTo("k")<0) return 0;
		else
			if(key.compareTo("r")>0) return 2;
		return 1;
	}
	
	public void count() {
		
		List<List<Keyvalue>> mapList = new ArrayList<List<Keyvalue>>(); // List of Map
		List<List<GroupByPair>> reducerList = new ArrayList<List<GroupByPair>>(); // list of Reducers
		List<List<Keyvalue>> mapTemp = new ArrayList<List<Keyvalue>>();
		List<List<Keyvalue>> mapTempx = new ArrayList<List<Keyvalue>>();
		// create mapping by extract data from input-splits
		
		for (int i = 0 ; i<m; i++) {
		List<Keyvalue> temp = new ArrayList<Keyvalue>();
		temp = Keyvalue.extract("inputQ2"+i+ ".txt");
		mapList.add(temp);
		// Mapper output
		System.out.println("Mapper ouput " + i );
		for(Keyvalue keyvalue :mapList.get(i) ) {
			
			System.out.println(keyvalue.toString());
		
		} // end create mapping
		
		}// Sending from mapper to reducer
		
		for (int i = 0 ; i<r ; i++) {
			
			mapTemp.add(new ArrayList());
			reducerList.add(new ArrayList());
			mapTempx.add(new ArrayList());
		}
		
		for(int i = 0 ; i< m ; i++) {
			for(Keyvalue k : mapList.get(i)) {
				int index = getPartition((String)k.getKey());
				mapTemp.get(index).add(k);
				mapTempx.get(index).add(k);
					
			}	
			
			for (int j = 0; j<mapTempx.size();j++) {
			System.out.println("Pairs send from Mapper " + i + " Reduce " + j);
			 for (int s = 0 ; s<mapTempx.get(j).size();s++) {
				 System.out.println(mapTempx.get(j).get(s));
			 }
			
			}
				
				mapTempx.clear();
			
			for (int z = 0 ; z<r ; z++) {
				mapTempx.add(new ArrayList());
			}
		}
		
		// create reducer input
		
		
		for (int i=0;i<mapTemp.size();i++ ) {
			
			mapTemp.get(i).sort(Comparator.comparing(Keyvalue::getKey));	
		   List<GroupByPair> e = GroupByPair.addList(mapTemp.get(i));
		   reducerList.get(i).addAll(e);
		
		}
		
		for (int i = 0; i<reducerList.size();i++) {
			System.out.println("=====Reducer " +i+ " Input===");
			for (int j = 0 ; j<reducerList.get(i).size();j++) {
				
				System.out.println(reducerList.get(i).get(j).toString());
			}
			
		}
		
		for (int i = 0; i<reducerList.size();i++) {
			System.out.println("=====Reducer " +i+ " Output===");
			for (int j = 0 ; j<reducerList.get(i).size();j++) {
				
				System.out.println(reducerList.get(i).get(j).toStringSum());
			}
			
		}
			
		
		
		
		
		
		
	}
	
	

	
	
	
}

