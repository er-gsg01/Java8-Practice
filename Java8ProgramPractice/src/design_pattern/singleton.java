package design_pattern;

public class singleton {

	private singleton() {}
	
	private  static singleton singletn; 
	
	public static singleton getInstance()
	{
		
		if(singletn==null)
		{
			
			 synchronized (singleton.class) {
				 singletn= new singleton();
			}
			
		}
		return singletn;
		
	}
	
	
   public static void main(String[] args)
   {
	
	   singleton sng=    getInstance();
	   
	   singleton sng2= getInstance();
	   
	   System.err.println(sng==sng2);
	   
	   System.err.println(sng.hashCode());
     
	   
	   System.err.println(sng2.hashCode());
   
   }

}
