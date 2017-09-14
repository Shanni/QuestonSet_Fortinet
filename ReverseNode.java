import org.junit.*;

public class ReverseNode{
	class Node{
		 Node next;
		 int value;
		 Node(int v){
			 value = v;
		 }
	}
		// Your resolution 
	public Node reverse(Node head){
		Node prev = null;
		while(head != null){
			Node next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
		// Time complexity:  O(N) 
		// Space complexity:  O(1)

		// JUnit test cases 
	@Test
	public void testReveseList(){
		Node n = new Node(1);
		n.next = new Node(2);
		
		Node res = reverse(n);
		
		Assert.assertEquals(2, res.value);
		Assert.assertEquals(1, res.next.value);
	}
	
	@Test
	public void testReveseNullList(){
		Node n = null;
		
		Node res = reverse(n);	
		Assert.assertEquals(null, res);
	}
}
