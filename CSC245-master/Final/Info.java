

public class Info {
	private int iD, year;
	private String title, author;
	private double price;

	public Info(int iD, int year, String title, String author, double price) {
		super();
		this.iD = iD;
		this.year = year;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String toString() {
		String a = "";
		a += "ID: " + iD + "\tTitle: " + title + "\tAuthor: " + author + "\tYear: " + year + "\tPrice: " + price;
		return a;
	}
}
