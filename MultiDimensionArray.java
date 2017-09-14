import java.util.Stack;


class MultiDimensionArray {
    // This is a provided function, Assume it works
    public static Long getValue(int[] indexOfDimension) {
        //... 
    	long value = 0;
        return value;
    }
    // lengthOfDeminsion: each dimension's length, assume it is valid: lengthOfDeminsion[i]>0.
    public static Long sum(MultiDimensionArray mArray, int[] lengthOfDeminsion) { 
    	// Your resolution 
    	int dimension = lengthOfDeminsion.length;
    	int[] indexes = new int[dimension];
    	
    	int ind = 0;
    	long sum = 0;
    	boolean next = true;
    	while(ind != dimension){
    		if(next){
    			sum += getValue(indexes);
    		}
    		
    		if(++indexes[ind] == lengthOfDeminsion[ind]){
    			next = false;
    			ind ++;
    			
    		}else{
    			if(!next){
    				for(int i = 0; i < ind; i++){
    					indexes[i] = 0;
    				}
    				ind = 0;
    			}
    			next = true;
    		}
    	}
    	   // Time complexity:  O(n) - number of permutation
    	   // Space complexity: O(k) - length of permutation
    	return sum;
    }
   
}