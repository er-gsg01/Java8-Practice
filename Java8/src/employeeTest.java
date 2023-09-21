import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class employeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		employee e = new employee("test1", 11, "Blr");
		employee e2 = new employee("test2", 12, "Blr");
		employee e3 = new employee("test3", 13, "delhi");
		employee e4 = new employee("test4", 14, "delhi"); 
		employee e5 = new employee("test5", 15, "delhi");
		employee e6 = new employee("test16", 16, "delhi");
		
		// First way adding the all objects to the list
		 List<employee> empList = Arrays.asList(e, e2, e3,e4,e5,e6); 
		
		// this is the Second way to add the multiple object 
		List<employee> empList2 = Stream.of(
				 new employee("test1", 11, "Blr"),
				 new employee("test2", 12, "Blr"),
				 new employee("test3", 13, "delhi"),
				 new employee("test4", 14, "delhi"),
				 new employee("test5", 15, "delhi"),
				 new employee("test16", 16, "delhi")
        ).collect(Collectors.toList());
		
		 
		Map<String, List<employee>> hmap = empList.stream().collect(Collectors.groupingBy(employee::getCity));
		System.err.println("grouping by city====>>>>"+hmap);
		
		System.err.println("printing only city with map====>>>>");
		empList.stream().map(employee::getCity).collect(Collectors.toList()).forEach(System.err::println);
		
		System.err.println("printing two or more fields city and name with flatmap====>>>>");
		empList.stream().flatMap(c->Stream.of(c.getCity(),c.getName(),c.getId())).collect(Collectors.toList()).forEach(System.out::println);

		System.err.println("only unique city====>>>>");
		empList.stream().map(employee::getCity).distinct().collect(Collectors.toList()).forEach(System.err::println);
		
		System.err.println("Duplicate city====>>>>");
		List<String> cityName=empList.stream().map(employee::getCity).collect(Collectors.toList());
		Set<String> uniquesName = new HashSet();
		List<String> duplicateName=cityName.stream().filter(name->!uniquesName.add(name)).collect(Collectors.toList());
		System.err.println("Duplicate city====>>>>"+duplicateName+ " unique city " + uniquesName);
		
		
		Map<String, Set<employee>> hasSet = empList.stream().collect(Collectors.groupingBy(employee::getCity,TreeMap::new,Collectors.toSet()));
		System.err.println("only unique city and sort and new set not map====>>>>"+ hasSet);
		
		System.err.println("2nd and 3rd large number ====>>>>");
		empList.stream().map(employee::getId).sorted().skip(1).limit(2).collect(Collectors.toList()).forEach(System.out::println);
		
		System.err.println("sort in DESC order ====>>>>");
		empList.stream().sorted((o1,o2)->o2.getId()-o1.getId()).skip(1).limit(2).collect(Collectors.toList()).forEach(System.out::println);
		
		IntSummaryStatistics sum = empList.stream().mapToInt(employee::getId).summaryStatistics();
		System.err.println("get Min, Max, averge ====>>>>" + sum.getMin()+ "===========>"+ sum.getMax()+ "===========>"+ sum.getAverage()+ "===========>"+sum.getCount()+ "===========>"+sum.getSum());

		
		List<String> empllst = empList.stream().map(employee::getName).collect(Collectors.toList());
         String cityname= empllst.stream().map(name->name.toUpperCase()).collect(Collectors.joining(", "));
		System.err.println(" City name serated by comma  ==>"+cityname);
		
		
		Map<String, Long> hmap2 = empList.stream().collect(Collectors.groupingBy(employee::getCity, Collectors.counting()));
		System.err.println("Counting by City ==>"+hmap2);
		
		
		
		Map<String, Double> hmap3=empList.stream().collect(Collectors.groupingBy(employee::getCity, Collectors.averagingInt(employee::getId)));
		System.err.println("Average of employee by ID===>>>> "+hmap3);
		
		
		String str= "Communication";  
		Map<String, Long> result = Arrays.stream(str.split("")).collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));  
		System.out.println(result);  
	 
		Map<String, Long> result2 =empList.stream().collect(Collectors.groupingBy(employee::getCity, LinkedHashMap::new, Collectors.counting()));  
		System.out.println(result2); 
	}

}
