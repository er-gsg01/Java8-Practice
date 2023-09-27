
public class singleton {
	public static singleton singleton;

	private singleton() {
	}

	public static synchronized singleton getInstance() {
		if (singleton == null) {
			singleton = new singleton();
			return singleton;
		}
		return singleton;
		
		
	}

}
