

public class Multimedia extends Book{

	public Multimedia(Info info, boolean status) {
		super(info, status);
	}

	@Override
	public String toString() {
		String a = "";
		a += info + "\tAvailability: " + status;
		return a;
	}
}
