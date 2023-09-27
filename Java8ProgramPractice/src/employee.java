import java.util.Objects;

public class employee {

	String name;
	Integer Id;
	String city;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(city);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		employee other = (employee) obj;
		return Objects.equals(city, other.city);
	}

	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getCity() {
		return city;
	}
 
	public void setCity(String city) {
		this.city = city;
	}
	
	
	public employee(String name, Integer id, String city) {
		 
		this.name = name;
		Id = id;
		this.city = city;
	}

	@Override
	public String toString() {
		return "employee [name=" + name + ", Id=" + Id + ", city=" + city + "]";
	}

  
}
