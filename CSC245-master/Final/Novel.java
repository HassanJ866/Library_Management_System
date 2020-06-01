

public class Novel extends Book {

	public Novel(Info info, boolean status) {
		super(info, status);
	}

	public String toString() {
		String a = "Type: Novel\t";
		a += info + "\tAvailability: " + status;
		return a;
	}

}