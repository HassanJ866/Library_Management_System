

public interface ShoppingCart {

	final double TaxRate = 0.1; // 10%

	public void printAll();

	public void addNovelByName(String name);

	public void addEbookByName(String name);

	public void addCDByName(String name);

	public void returnToShelf(String name);

	public String BooksBought(); // Returns the names of the books in a menu style

	public double CalcTotal(); // Return the Total Price of Books

	public String Reciept(); // Returns both names and receipt
}