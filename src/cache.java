import java.util.*;
public class cache {
	
	int size = 0;
	int fault = 0;
	Queue q = new Queue();
	HashMap<Integer , node> hm =  new HashMap<Integer , node>();
	
	public void insert(int page)
	{
		
		if(hm.get(page)!=null)
		{
			q.delete(hm.get(page));
			q.insert(hm.get(page));
		}
		else
		{
			if(size>=4)
			{
				node n = q.delete();
				hm.remove(n.data,n);
				size--;
			}
			node n = new node(page);
			hm.put(page,n);
			q.insert(n);
			fault++;
			size++;	
		}
	}
	
	public void display()
	{
		q.print();
	}
	
	
	public static void main(String ags[])
	{
		Scanner scan = new Scanner(System.in);
		int arr [] = {2,6,3,7,6,8,4,7,3,1}; 
		cache n = new cache();
		for(int i = 0 ;i<arr.length ;i++)
		{
			n.insert(arr[i]);
			n.display();
			System.out.println();
			
		}
		
		System.out.println(n.fault);
		scan.close();
	}
}
