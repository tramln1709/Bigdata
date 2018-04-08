package W1D1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// author : Ngoc Tram Ly 985671
public class main {
	
	
	@SuppressWarnings("rawtypes")

	public static void main(String[] args) {
	
		
		List<Keyvalue> result = Keyvalue.extract("testDataForW1D1.txt");
	    for (Keyvalue pair: result){
            System.out.println(pair);
        }


}
	
}
