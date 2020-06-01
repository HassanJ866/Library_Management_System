

public abstract class Book{

	Info info;
	boolean status;

	public Book(Info info, boolean status) {
		super();
		this.info = info;
		this.status = status;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String toString() {
		String a = "";
		a += info + "\tAvailability: " + status;
		return a;
	}

}
