import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class QuickSort {

	static Pattern pattern;
	
	public void quickSort(ArrayList<String> alist,int p, int r)
	{
		int q;
		
		if(p<r)
		{
			q = partition(alist,p,r);
			quickSort(alist,p,q-1);
			//if(q>1)
			quickSort(alist,q,r);
		}
		
	}
	public int compare(String o1, String o2) {
	//	BinaryFileBuffer b1 = (BinaryFileBuffer)o1;
	//	BinaryFileBuffer b2 = (BinaryFileBuffer)o2;
	//	String a = (String)b1.peek();
	//	String b = (String)b2.peek();
		String a =o1;
		String b = o2;
	//	System.out.println(a+"     "+b);
		pattern = Pattern.compile("[a-zA-Z]");
		Matcher match;
		//	System.out.println("Value of a is :     "+a+"  "+"value of b is      :"+b);
		int a_first = (int)a.charAt(0);
		int b_first = (int)b.charAt(0);
		String sa_1;
		String sa_2;
		String sb_1;
		String sb_2;
		int count;
	//	System.out.println(a_first);
		if(48<=a_first && a_first<=57)
		{
		//	System.out.println("inside ascii");
			sa_1="";
			sa_2 = a;
		}
		else
		{
		//	System.out.println("Value of a:"+ a+"Lenghth"+a.length());
			match = pattern.matcher(a);
			count=0;
			while(match.find()) {
				count++;
			}

			sa_1 = a.substring(0, count);
			sa_2 = a.substring(count);

		}

		if(48<=b_first && b_first<=57)
		{
		//	System.out.println("inside ascii");
			sb_1="";
			sb_2 = b;
		}
		else

		{
		//	System.out.println("Value of b:"+ b+"Lenghth"+b.length());
			match = pattern.matcher(b);
			count = 0;
			while(match.find()) {
				count++;
			}
			sb_1 = b.substring(0, count);
			sb_2 = b.substring(count);	
		}

		int val = 0 ;
		if(a.compareTo(b)==0)
		{
		//	System.out.println("Value of a is :  "+a+" SAME VALUE  "+"value of b is    :"+b);
			val = 0;
		}
		else
		{
			if(sa_1!=null && sb_1!=null)
			{
				if(sa_1.compareTo(sb_1) < 0) {
			//		System.out.println("sa_1 less than sb_1");
					val = -1;
		//			System.out.println("Value of a is :     "+a+" IS LESS  "+"value of b is      :"+b);

				} else if (sa_1.compareTo(sb_1) > 0) {
			//		System.out.println("sa_1 greater than sb_1");
					val = 1;
		//			System.out.println("Value of a is :     "+a+" IS GREATER "+"value of b is      :"+b);
				}

				else {
			//		System.out.println("sa_2 value"+sa_2+"    "+"Value of sb_2"+sb_2);
					if(!sa_2.equals("") && !sb_2.equals(""))
					{
						int sa_int = Integer.parseInt(sa_2);
						int sb_int = Integer.parseInt(sb_2);

						if(sa_int < sb_int) {
				//			System.out.println("Comparing integers sa_int less that sb_int");
							val = -1;	
			//				System.out.println("Value of a is :     "+a+"IS LESS  "+"value of b is      :"+b);
						} 
						else {
				//			System.out.println("sa_int is greater that sb_int");
							val = 1;
				//			System.out.println("Value of a is :     "+a+" IS GREATER "+"value of b is      :"+b);
						}

					}
					else
					{
						if(sa_2.equals(""))
						{
							//	int sb_int = Integer.parseInt(sb_2);
					//		System.out.println("Value of a is :     "+a+" IS LESS "+"value of b is      :"+b);
							val = -1;
						}
						else
						{
					//		System.out.println("a is greater");
							val=1;
					//		System.out.println("Value of a is :     "+a+" IS GREATER "+"value of b is      :"+b);
						}
					}	
				}
				}		

		}
		return val;
	}

	
	public int partition(ArrayList<String>alist, int p, int r)
	{
		String pivot = alist.get(r);
		int j=r;
		int i =p;
		String tmp;
		int a=compare(alist.get(j),pivot);
		while(true)
		{
			
			while(compare(alist.get(j),pivot)>=1)
			{
				j=j-1;
			}
			while(compare(alist.get(i),pivot)==-1)
			{
				i=i+1;
			}
			
			if(i<j)
			{
				tmp = alist.get(i);
				alist.set(i, alist.get(j));
				alist.set(j,tmp);
			}
			else
			{
			return j;
			}
		}	
	}
	
}
