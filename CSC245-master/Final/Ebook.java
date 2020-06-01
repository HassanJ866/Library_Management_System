

public class Ebook extends Multimedia {

	private String link;

	public Ebook(Info info, boolean status, String link) {
		super(info, status);
		this.link = link;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		String a = "Type: EBook\t";
		a += info + "\tAvailability: " + status + "\tLink: " + link;
		return a;
	}
}
