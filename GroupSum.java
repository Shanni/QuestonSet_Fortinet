
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.*;


public class GroupSum {
	private boolean backtrack(List<Integer> list, int sum, int target, int total, boolean[] usd){
		if(total == list.size())
			return true;
		for(int i = 0; i < list.size(); i++){
			if(sum < list.get(i))
				return false;
			
			if(!usd[i]){
				sum -= list.get(i);
				usd[i] = true;
				total ++;
				if(backtrack(list, sum != 0? sum: target, target, total, usd))
					return true;
				total --;
				usd[i] = false;
				sum += list.get(i);
			}		
		}
		return false;
	}
	public boolean separate(List<Integer> list, int k){
		   // Your resolution 
		if(list == null || list.size() < k)
			return false;
		
		Collections.sort(list);
		int sum = 0;
		for(int num: list){
			sum += num;
		}
		
		if(sum % k != 0)
			return false;
		
		boolean[] usd = new boolean[list.size()];

		return backtrack(list, sum / k, sum / k, 0, usd);
		   // Time complexity:  O(n ^ n)
		   // Space complexity: O(N) -- all recursive function edit the same List<Integer> and boolean[]
		//			Recursive function stack at most O(Length of result)

	}
		  // JUnit test cases 
	@Test
	public void TestEmptyListSeperate(){
		GroupSum g = new GroupSum();
		
		Assert.assertFalse(g.separate(new ArrayList<>(), 3));
	}
	
	@Test
	public void TestSeperateFail(){
		GroupSum g = new GroupSum();
		Integer[] a = new Integer[]{3,4,5,6,7,8};
		List<Integer> arr = Arrays.asList(a);

		Assert.assertFalse(g.separate(arr, 4));
	}
	
	@Test
	public void TestSeperateFailKTooLarge(){
		GroupSum g = new GroupSum();
		Integer[] a = new Integer[]{3,4,5,8};
		List<Integer> arr = Arrays.asList(a);

		Assert.assertFalse(g.separate(arr, 5));
	}
	
	@Test
	public void TestSeperateSuccess(){
		GroupSum g = new GroupSum();
		Integer[] a = new Integer[]{3,4,5,6,7,8};
		List<Integer> arr = Arrays.asList(a);

		Assert.assertTrue(g.separate(arr, 3));
	}
}
