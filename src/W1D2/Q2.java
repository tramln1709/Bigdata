package W1D2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q2 {
	
	 static int f(int x ) {
		
		if (x==3) return x;
		else if (x==4) return -1; 
			return 0;
	}
	
	static int g(int x, int y) {
		
	if (x>=0 && y>=0) return (x>=y)?x:y;
	else if (x<0) {
		  	if (y>0) return y;
		  	else return x;
		     }
	
		else {
			
			if (y<0) {
				if (x>0) return x;
			  	else return y;
			}
			
		}
		
	return 0;
	}
	
	public static void main(String[] args) {
		
		
		int[] a = {1, 6, 2, 8, 2, 9};
		
		
		int x = 0;
		
	
		
	List<Integer> list = IntStream.of(a)
						.map(y->f(y))
						.boxed()
						.collect(Collectors.toList());


	list.forEach(System.out::println);	
		
		
	for (int i = 0 ;i<list.size();i++) {
		
		x= g(x,list.get(i));
			
	}
	
		if (x>=0)System.out.println("Nice");
		else
			System.out.println("Not Nice");
		
	}

}
