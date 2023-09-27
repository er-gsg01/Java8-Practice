import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Occurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    String str="Hello";
  
	String st[]= str.split(str );
	
	
	 System.err.println(Arrays.stream(st).collect(Collectors.groupingBy(s->s))); 
	  
	}

}
