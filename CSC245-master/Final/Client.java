

import java.util.ArrayList;

public class Client implements ShoppingCart {

	ArrayList<Book> cart = new ArrayList<Book>();
	String name, address;
	int age;

	public Client(String name, String address, int age) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String BooksBought() {
		String reciept = "Books In Cart: \n";

		for (Book i : cart) {
			reciept += i.getInfo() + "\n";
		}

		return reciept;
	}

	@Override
	public double CalcTotal() {
		double total = 0;
		for (Book i : cart) {
			total += i.getInfo().getPrice();
		}
		total = total + total * TaxRate;
		return total;
	}

	@Override
	public String Reciept() {
		String reciept = BooksBought();

		reciept += "Total Price: " + CalcTotal();
		return reciept;
	}

	@Override
	public void addNovelByName(String name) {
		for (int i = 0; i < Library_Tester.NovelList.size(); i++) {
			if (Library_Tester.NovelList.get(i).getInfo().getTitle().equalsIgnoreCase(name)
					&& Library_Tester.Library.get(i).isStatus()) {
				System.out.println("Done!");
				cart.add(Library_Tester.NovelList.get(i));
				return;
			}
			if (Library_Tester.NovelList.get(i).getInfo().getTitle().equalsIgnoreCase(name)
					&& !Library_Tester.Library.get(i).isStatus()) {
				System.out.println("We may have ran out of \'" + name + " \' Novel.\nWe'll order one soon.");
				return;
			}
		}
		System.out.println("Sorry, Novel not found!");
	}

	@Override
	public void addEbookByName(String name) {
		for (int i = 0; i < Library_Tester.EbookList.size(); i++) {
			if (Library_Tester.EbookList.get(i).getInfo().getTitle().equalsIgnoreCase(name)
					&& Library_Tester.Library.get(i + 6).isStatus()) {
				System.out.println("Done!");
				cart.add(Library_Tester.EbookList.get(i));
				return;
			}
			if (Library_Tester.EbookList.get(i).getInfo().getTitle().equalsIgnoreCase(name)
					&& !Library_Tester.Library.get(i).isStatus()) {
				System.out.println("We may have ran out of \'" + name + " \' EBook.\nWe'll order one soon.");
				return;
			}
		}
		System.out.println("Sorry, EBook not found!");
	}

	@Override
	public void addCDByName(String name) {
		for (int i = 0; i < Library_Tester.CDList.size(); i++) {
			if (Library_Tester.CDList.get(i).getInfo().getTitle().equalsIgnoreCase(name)
					&& Library_Tester.Library.get(i + 3).isStatus()) {
				System.out.println("Done!");
				cart.add(Library_Tester.CDList.get(i));
				return;
			}
			if (Library_Tester.CDList.get(i).getInfo().getTitle().equalsIgnoreCase(name)
					&& !Library_Tester.Library.get(i).isStatus()) {
				System.out.println("We may have ran out of \'" + name + " \' CD.\nWe'll order one soon.");
				return;
			}

		}
		System.out.println("Sorry, CD not found!");
	}

	@Override
	public void returnToShelf(String name) {
		for (int j = 0; j < cart.size(); j++) {
			if (cart.get(j).getInfo().getTitle().equalsIgnoreCase(name)) {
				cart.remove(j);
				return;
			}
		}
		System.out.println("Sorry, You don't have such a book in your cart!");
	}

	@Override
	public void printAll() {
		for (Book i : Library_Tester.Library) {
			System.out.println(i);
		}
	}

}