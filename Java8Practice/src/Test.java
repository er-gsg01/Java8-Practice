import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Test {

	public static void main(String arg[]) {

		   String s1 = "abc";
		    String s2 = new String("abc");
		    String s3 = new String("foo");
		    String s4 = s1.intern();
		    String s5 = s2.intern();
		    System.out.println(s3 == s4);
		    System.out.println(s1 == s5); 
  
		/*
		 * Integer array[]={3,2,1,4,6,5}; Integer tempArray; for(int i=0;
		 * i<array.length;i++) {
		 * 
		 * for(int j=i+1;j<array.length;j++) {
		 * 
		 * if(array[i]>array[j]) { tempArray= array[i]; array[i]=array[j];
		 * 
		 * } } } System.out.println();
		 */
		/*
		 * int m=2,n=3;
		 * 
		 * m=m+n; n=m-n; m=m-n;
		 * 
		 * System.out.println("number n "+n+ "number m "+ m);
		 */
		
		String element[]={"1","2","3","5","4","6"};
		
		for(int i=element.length-1; i>=0;i--)
		{

			System.out.print(element[i]);
			
		}
		
		// third Highest number
		 List<String> ls=  Arrays.asList(element);
		 ls.stream().sorted(Comparator.naturalOrder()).skip(2).limit(1).forEach(System.err::println);
		 
		 ls.stream().sorted((x,y)->y.compareTo(x)).skip(2).limit(1).forEach(System.err::println);
		 
		
	  }
}