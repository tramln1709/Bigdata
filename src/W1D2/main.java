package W1D2;
import java.util.List;

import W1D1.Keyvalue;
import W1D2.GroupByPair;
public class main {
	
	
	public static void main (String[] args) {
	List<Keyvalue> resultMap = Keyvalue.extract("testDataForW1D1.txt");
	
	System.out.println("-------MAP------");
    for (Keyvalue pair: resultMap){
        System.out.println(pair);
    }
    
    System.out.println("------REDUCER INPUT-----");
    
    List<GroupByPair> listReducerInput = GroupByPair.addList(resultMap);
    
    for (GroupByPair byPair : listReducerInput)
    	 System.out.println(byPair.toString());
    
   System.out.println("------REDUCER OutPut-----");
    
    for (GroupByPair byPair : listReducerInput)
   	 System.out.println(byPair.toStringSum());
}	
	
}	


