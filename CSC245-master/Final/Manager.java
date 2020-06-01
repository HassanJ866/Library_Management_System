

import java.util.*;

public class Manager {

	private String name;
	private int ID;

	public Manager(ArrayList<Book> libraryBooks, String name, int iD) {
		super();
		Library_Tester.Library = libraryBooks;
		this.name = name;
		ID = iD;
	}

	public ArrayList<Book> getLibraryBooks() {
		return Library_Tester.Library;
	}

	public void setLibraryBooks(ArrayList<Book> libraryBooks) {
		Library_Tester.Library = libraryBooks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void addBook(Book book) {
		Library_Tester.Library.add(book);
		Library_Tester.Authors.add(book.getInfo().getAuthor());
		Library_Tester.NovelList.add((Novel) book);
	}

	public boolean deleteBook(String name) {
		for (int i = 0; i < Library_Tester.Library.size(); i++) {

			for (int j = 0; j < Library_Tester.EbookList.size(); j++) {
				if (Library_Tester.EbookList.get(j).getInfo().getTitle().equalsIgnoreCase(name)) {
					Library_Tester.EbookList.remove(j);
					return true;
				}
			}

			for (int j = 0; j < Library_Tester.CDList.size(); j++) {
				if (Library_Tester.CDList.get(j).getInfo().getTitle().equalsIgnoreCase(name)) {
					Library_Tester.CDList.remove(j);
					return true;
				}
			}

			for (int j = 0; j < Library_Tester.NovelList.size(); j++) {
				if (Library_Tester.NovelList.get(j).getInfo().getTitle().equalsIgnoreCase(name)) {
					Library_Tester.NovelList.remove(j);
					return true;
				}
			}

			for (int j = 0; j < Library_Tester.Library.size(); j++) {
				if (Library_Tester.Library.get(i).getInfo().getTitle().equalsIgnoreCase(name)) {
					Library_Tester.Library.remove(i);
					return true;
				}
			}

		}
		return false;

	}

	public ArrayList<Novel> getAllNovel() {
		ArrayList<Novel> al = new ArrayList<Novel>();
		for (Novel i : Library_Tester.NovelList) {
			al.add(i);
		}

		return al;
	}

	public ArrayList<Multimedia> getAllMultimedia() {
		ArrayList<Multimedia> al = new ArrayList<Multimedia>();
		for (Multimedia i : Library_Tester.MultimediaList) {
			al.add(i);
		}

		return al;
	}

	public ArrayList<Ebook> getAllEbook() {
		ArrayList<Ebook> al = new ArrayList<Ebook>();
		for (Ebook i : Library_Tester.EbookList) {
			al.add(i);
		}

		return al;
	}

	public ArrayList<CD> getAllCD() {
		ArrayList<CD> al = new ArrayList<CD>();
		for (CD i : Library_Tester.CDList) {
			al.add(i);
		}

		return al;
	}

	public Info getBookByID(int ID) {
		for (int i = 0; i < Library_Tester.Library.size(); i++) {
			if (Library_Tester.Library.get(i).getInfo().getiD() == ID)
				return Library_Tester.Library.get(i).getInfo();
		}
		System.out.println("This ID can't be found");
		return null;
	}

	public boolean hasBook(String name) {
		for (int i = 0; i < Library_Tester.Library.size(); i++) {
			if (Library_Tester.Library.get(i).isStatus()
					&& Library_Tester.Library.get(i).getInfo().getTitle().equalsIgnoreCase(name)) {
				System.out.println("Present");
				return true;
			}

			if (!Library_Tester.Library.get(i).isStatus()
					&& Library_Tester.Library.get(i).getInfo().getTitle().equalsIgnoreCase(name)) {
				System.out.println("We used to have this Book...:(");
				return false;
			}
		}
		return false;
	}

	public void sortByAuthor() {
		ArrayList<Book> sorted = new ArrayList<>();
		Collections.sort(Library_Tester.Authors);
		for (int i = 0; i < Library_Tester.Authors.size(); i++) {
			for (int j = 0; j < Library_Tester.Library.size(); j++) {
				if (Library_Tester.Authors.get(i)
						.equalsIgnoreCase(Library_Tester.Library.get(j).getInfo().getAuthor())) {
					sorted.add(Library_Tester.Library.get(j));
				}
			}
		}
		Library_Tester.Library = sorted;
	}

	public ArrayList<Novel> sortNovelByID() {
		ArrayList<Novel> al = new ArrayList<Novel>();

		for (Book i : Library_Tester.Library) {
			al.add((Novel) i);
		}

		for (int i = 0; i < al.size(); i++)
			for (int j = 1; j < al.size() - i; j++)
				if (al.get(j - 1).getInfo().getiD() > al.get(j).getInfo().getiD()) {
					Novel temp = al.get(j);
					al.set(j, al.get(j - 1));
					al.set(j - 1, temp);
				}

		return al;
	}

	public int searchNovelByTitle(String title) {
		for (int i = 0; i < Library_Tester.NovelList.size(); i++) {
			if (Library_Tester.NovelList.get(i).getInfo().getTitle().equalsIgnoreCase(title)) {
				return Library_Tester.NovelList.get(i).getInfo().getiD();
			}
		}

		return -1;
	}

	public int searchMultimediaByAudioTime(double at) {
		for (int i = 0; i < Library_Tester.CDList.size(); i++) {
			if (Library_Tester.CDList.get(i).getAudioTime() == at) {
				return Library_Tester.CDList.get(i).getInfo().getiD();
			}
		}

		return -1;

	}

	public void printAll() {
		for (Book i : Library_Tester.Library) {
			System.out.println(i);
		}

	}

}