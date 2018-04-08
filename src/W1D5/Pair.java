package W1D5;

public class Pair<V extends Comparable> implements Comparable  {

	private V left ;
	private V right ;


	public Pair(V left , V right) {
		
		this.left = left ;
		this.right = right;	
		
	}
	
	public V getLeft() {
		
		return this.left;
	}
	
	public V getRight() {
		
		return this.right;
	}
	
	public void setLeft(V left) {
		
		this.left = left;
	}
	
	public void setRight(V right) {
		
		this.right = right;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		
		int k = this.left.compareTo(((Pair)o).getLeft());
		
		if (k!=0) return k;
		else 
				
			return this.right.compareTo(((Pair)o).getRight());
		
	}
	
	public boolean equals(Object o) {
		
		if (o == null)return false;
		if(!(o instanceof Pair)) return false;
		Pair p = (Pair)o;
		boolean isEqual = this.getLeft().equals(p.getLeft()) && this.getRight().equals(p.getRight()) ;
		
		return isEqual;

			
			

			
	}
	
	public String toString() {
		
		return "(" + this.left + "," + this.right + ")" ; 
	}
	
	
	
}
