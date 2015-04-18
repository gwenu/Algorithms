package ag.algorithms.hash;

// 'Standard' recipe for user-defined type
public class HashFunction {
	
	private int intValue;
	private String stringValue;
	private Integer intWrapperNullValue = null;
	private double[] array;
	
	public HashFunction() { }
	
	public HashFunction(int intValue, String stringValue, Integer intWrapperNullValue, double[] array) {
		this.intValue = intValue;
		this.stringValue = stringValue;
		this.intWrapperNullValue = intWrapperNullValue;
		this.array = array;
	}
	
	public int hashcode() {
		// Combine each significant fields using 31 * x + y rule
		int hash = 0;
		
		// If field is a primitive type, use wrapper type hashCode()
		hash += 31 * hash + Integer.valueOf(intValue).hashCode();
		
		// If field null return 0
		hash += 31 * hash + (intWrapperNullValue == null ? 0 : intWrapperNullValue.hashCode());
		
		// If field is reference type, use hashCode()
		hash += 31 * hash + (stringValue.isEmpty() ? 0 : stringValue.hashCode());
		
		// If field is an array, apply to each entry or Arrays.deepHashCode()
		int i = 0;
		while(i < array.length) {
			hash += 31 * hash + Double.valueOf(array[i]).hashCode();
			i++;
		}
		// or Arrays.deepHashCode(array.toObjectArray);
		
		return hash;
	}
}
