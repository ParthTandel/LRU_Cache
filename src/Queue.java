public class Queue 
{
	node head;
	node rear;
	
	public void insert(node page)
	{
		if(head == null)
		{
			head = page;
			rear = page;
		}
		else
		{
			head.previous = page;
			page.next = head;
			head = page;
			head.previous = null;
		}
	}
	
	public void print()
	{
		node current =head;
		while(current!=null)
		{
			System.out.print(current.data+" ");
			current = current.next;
		}
	}
	public node delete()
	{
		node n = rear;
		rear = n.previous;
		rear.next = null;
		
		return n;
		/*
		node current =head;
		while(current!=null && current.data != data)
			current = current.next;
		
		if(current.previous!=null && current.next!=null)
		{
			current.previous.next = current.next;
			current.next.previous = current.previous;
		}
		else if(current.previous == null)
		{
			head = head.next;
		}
		else
		{
			current.previous.next = current.next;
		}
		return current;
		*/
	}
	
	public node delete(node n)
	{
		
		if(n.previous!=null && n.next!=null)
		{
			n.previous.next = n.next;
			n.next.previous = n.previous;
			
		}
		else if(n.previous == null)
			head = head.next;
		else
			n.previous.next = n.next;
		
		if(n.next == null)
			rear = n.previous;
		return n;
	}
	
}
