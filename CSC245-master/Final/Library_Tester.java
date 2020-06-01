

import java.util.*;

public class Library_Tester {
	static ArrayList<Book> Library = new ArrayList<>();
	static ArrayList<Novel> NovelList = new ArrayList<>();
	static ArrayList<CD> CDList = new ArrayList<>();
	static ArrayList<Ebook> EbookList = new ArrayList<>();
	static ArrayList<Multimedia> MultimediaList = new ArrayList<>();
	static ArrayList<String> Authors = new ArrayList<>();
	static boolean loop = true;

	public static void main(String[] args) {
		// Initializing The Lists
		Novel N1 = new Novel(new Info(111, 1988, "The Alchemist", "Paulo Coelho", 15.0), true);
		Novel N2 = new Novel(new Info(222, 2010, "Where She Went", "Gayle Forman", 13.5), true);
		Novel N3 = new Novel(new Info(333, 2008, "Paper Towns", "John Green", 20), false);
		CD CD1 = new CD(new Info(11, 2007, "13 Reasons Why", "Jay Asher", 18.25), true, 8);
		CD CD2 = new CD(new Info(12, 2019, "The Silent Patient", "Alex Michaelides", 17.75), true, 7);
		CD CD3 = new CD(new Info(13, 2006, "The Secret", "Rhonda Byrne", 25.5), false, 5);
		Ebook EB1 = new Ebook(new Info(21, 2019, "The Truth About Magic", "Atticus", 23), true,
				"thetruthaboutmagic.com");
		Ebook EB2 = new Ebook(new Info(22, 2014, "You", "Caroline Kepnes", 12), false, "darkplace.com");
		Ebook EB3 = new Ebook(new Info(23, 2009, "I Am Number Four", "Pittacus Lore", 10), true, "iamnumberfour.com");

		Authors.add("Paulo Coelho");
		Authors.add("Gayle Forman");
		Authors.add("John Green");
		Authors.add("Jay Asher");
		Authors.add("Alex Michaelides");
		Authors.add("Rhonda Byrne");
		Authors.add("Atticus");
		Authors.add("Caroline Kepnes");
		Authors.add("Pittacus Lore");

		NovelList.add(N1);
		NovelList.add(N2);
		NovelList.add(N3);

		CDList.add(CD1);
		CDList.add(CD2);
		CDList.add(CD3);

		EbookList.add(EB1);
		EbookList.add(EB2);
		EbookList.add(EB3);

		MultimediaList.add(CDList.get(0));
		MultimediaList.add(CDList.get(1));
		MultimediaList.add(CDList.get(2));
		MultimediaList.add(EbookList.get(0));
		MultimediaList.add(EbookList.get(1));
		MultimediaList.add(EbookList.get(2));

		Library.add(NovelList.get(0));
		Library.add(NovelList.get(1));
		Library.add(NovelList.get(2));
		Library.add(MultimediaList.get(0));
		Library.add(MultimediaList.get(1));
		Library.add(MultimediaList.get(2));
		Library.add(MultimediaList.get(3));
		Library.add(MultimediaList.get(4));
		Library.add(MultimediaList.get(5));

		Scanner scan = new Scanner(System.in);

		System.out.println("Hello!");
		System.out.println("Please press C for Client or M for Manager: ");
		String user;

		do {
			user = scan.next();
			if (user.equalsIgnoreCase("C")) {
				do {
					try {
						System.out.println("New User? Let's Create an Account!");
						System.out.println("Enter Name: ");
						String name = scan.next();
						System.out.println("Enter Adress: ");
						String address = scan.next();
						System.out.println("Enter Age: ");
						int age = scan.nextInt();
						Client C1 = new Client(name, address, age);
						ClientMenu(C1);
					} catch (InputMismatchException e) {
						System.err.println("Wrong Input :(");
						scan.next();
					}
				} while (loop);

			}
			if (user.equalsIgnoreCase("M")) {
				do {
					try {
						System.out.println("Hello, Let's sign you up!");
						System.out.println("Enter Name: ");
						String name = scan.next();
						System.out.println("Enter ID: ");
						int ID = scan.nextInt();
						Manager M1 = new Manager(Library, name, ID);
						MangMenu(M1);
					} catch (InputMismatchException e) {
						System.err.println("Wrong Input :(");
						scan.next();
					}
				} while (loop);
			}

			if (!user.equalsIgnoreCase("C") && !user.equalsIgnoreCase("M")) {
				System.err.println("Please make sure to input C for Client & M for Manager...");
			}
		} while (!user.equalsIgnoreCase("C") && !user.equalsIgnoreCase("M"));

	}

	private static void MangMenu(Manager M1) {
		int user_choice = 0;
		Scanner scan = new Scanner(System.in);

		try {
			System.out.println();
			System.out.println("----Menu----\n");
			System.out.println("1. Sort All By Author");
			System.out.println("2. Get All in Library");
			System.out.println("3. Add Novel");
			System.out.println("4. Delete Book");
			System.out.println("5. Get All Novels in the Library");
			System.out.println("6. Get All Multimedia in the Library");
			System.out.println("7. Get All Ebooks in the Library");
			System.out.println("8. Get All CDs in the Library");
			System.out.println("9. Get Book by ID");
			System.out.println("10. Check if the Library contains this Book");
			System.out.println("11. Find Novel ID By Title");
			System.out.println("12. Find Multimedia ID By AudioTime");
			System.out.println("13. Exit");
			System.out.println("------------");
			System.out.println("Welcome!");
			System.out.println("\nHow may I Help You? \n   Enter Choice [1-13]: ");

			user_choice = scan.nextInt();

			switch (user_choice) {

			case 1:
				try {
					System.out.println("\nSorting by Author");
					System.out.println("After:");
					M1.sortByAuthor();
					M1.printAll();
					MangMenu(M1);
					break;
				} catch (InputMismatchException e) {
					System.err.println("Wrong Input :(");
					MangMenu(M1);
				}
			case 2:
				try {
					System.out.println("All in Library:");
					M1.printAll();
					MangMenu(M1);
					break;
				} catch (InputMismatchException e) {
					System.err.println("Wrong Input :(");
					MangMenu(M1);
				}
			case 3:
				try {
					System.out.println("Enter new ID: ");
					int ID = scan.nextInt();
					System.out.println("Enter year of publication: ");
					int year = scan.nextInt();
					System.out.println("Enter title of Novel: ");
					scan.nextLine();
					String title = scan.nextLine();
					System.out.println("Enter Author: ");
					String author = scan.nextLine();
					System.out.println("Enter Price: ");
					double price = scan.nextDouble();
					Novel add = new Novel(new Info(ID, year, title, author, price), true);
					M1.addBook(add);
					MangMenu(M1);
					break;
				} catch (InputMismatchException e) {
					System.err.println("Wrong Input :(");
					MangMenu(M1);
				}

			case 4:
				try {
					System.out.println("Enter Name of the Book");
					scan.nextLine();
					String name = scan.nextLine();
					boolean deleted = M1.deleteBook(name);
					if (deleted) {
						System.out.println(name + " is deleted");
					} else {
						System.out.println(name + " could not be found");
					}
					MangMenu(M1);
					break;
				} catch (InputMismatchException e) {
					System.err.println("Wrong Input :(");
					MangMenu(M1);
				}

			case 5:
				try {
					System.out.println("All Novels:");
					System.out.println(M1.getAllNovel());
					MangMenu(M1);
					break;
				} catch (InputMismatchException e) {
					System.err.println("Wrong Input :(");
					MangMenu(M1);
				}

			case 6:
				try {
					System.out.println("All Multimedia:");
					System.out.println(M1.getAllMultimedia());
					MangMenu(M1);
					break;
				} catch (InputMismatchException e) {
					System.err.println("Wrong Input :(");
					MangMenu(M1);
				}

			case 7:
				try {
					System.out.println("All EBook:");
					System.out.println(M1.getAllEbook());
					MangMenu(M1);
					break;
				} catch (InputMismatchException e) {
					System.err.println("Wrong Input :(");
					MangMenu(M1);
				}

			case 8:
				try {
					System.out.println("All CDs:");
					System.out.println(M1.getAllCD());
					MangMenu(M1);
					break;
				} catch (InputMismatchException e) {
					System.err.println("Wrong Input :(");
					MangMenu(M1);
				}

			case 9:
				try {
					System.out.println("Enter ID: ");
					int id = scan.nextInt();
					if (M1.getBookByID(id) != null)
						System.out.println(M1.getBookByID(id));
					MangMenu(M1);
					break;
				} catch (InputMismatchException e) {
					System.err.println("Wrong Input :(");

					MangMenu(M1);
				}
			case 10:
				try {
					System.out.println("Enter Name of Book");
					scan.nextLine();
					String name = scan.nextLine();
					System.out.println(M1.hasBook(name));
					MangMenu(M1);
					break;
				} catch (InputMismatchException e) {
					System.err.println("Wrong Input :(");
					MangMenu(M1);
				}

			case 11:
				try {
					System.out.println("Searching Novels by Title");
					System.out.println("Enter Novel Title: ");
					scan.nextLine();
					String title = scan.nextLine();
					System.out.println("The novel \'" + title + "\' has ID: " + M1.searchNovelByTitle(title));
					if (M1.searchNovelByTitle(title) != -1)
						System.out.println("Order Now!\n");
					if (M1.searchNovelByTitle(title) == -1)
						System.out.println("Thus it is not present as a \'Novel\'. We will make sure to have it soon!");
					MangMenu(M1);
					break;
				} catch (InputMismatchException e) {
					System.err.println("Wrong Input :(");
					MangMenu(M1);
				}

			case 12:
				try {
					System.out.println("Searching Multimedia by Audio Time");
					System.out.println("Enter Audio Time: ");
					double AudioTime = scan.nextDouble();
					System.out.println("The Multimedia with Audio Time: \'" + AudioTime + "\' hours has ID: "
							+ M1.searchMultimediaByAudioTime(AudioTime));
					if (M1.searchMultimediaByAudioTime(AudioTime) != -1)
						System.out.println("Order Now!\n");
					if (M1.searchMultimediaByAudioTime(AudioTime) == -1)
						System.out.println("Thus it is not present as CD. We will make sure to have it soon!");
					MangMenu(M1);
					break;
				} catch (InputMismatchException e) {
					System.err.println("Wrong Input :(");
					MangMenu(M1);
				}

			case 13:
				System.out.println("\nThank you, Good-Bye!");
				loop = false;
				break;

			default:
				System.err.println("No such value, Try Again!");
				MangMenu(M1);
			}

		} catch (InputMismatchException e) {
			System.err.println("You didn't enter an integer :(");
			MangMenu(M1);
		}

	}

	public static void ClientMenu(Client C1) {
		int user_choice = 0;
		Scanner scan = new Scanner(System.in);

		try {
			System.out.println();
			System.out.println("----Menu----\n");
			System.out.println("1. Get All in Libray");
			System.out.println("2. Add a Novel to your cart");
			System.out.println("3. Add an EBook to your cart");
			System.out.println("4. Add a CD to your cart");
			System.out.println("5. Return a book to shelf");
			System.out.println("6. Print your reciept");
			System.out.println("7. Exit");
			System.out.println("------------");
			System.out.println("Welcome!");
			System.out.println("\nHow may I Help You? \n   Enter Choice [1-5]: ");

			user_choice = scan.nextInt();

			switch (user_choice) {
			case 1:
				try {
					System.out.println("All in Library:");
					C1.printAll();
					ClientMenu(C1);
					break;
				} catch (InputMismatchException e) {
					System.err.println("Wrong Input :(");
					ClientMenu(C1);
				}

			case 2:
				try {
					System.out.println("Enter Novel Title: ");
					scan.nextLine();
					String title = scan.nextLine();
					C1.addNovelByName(title);
					ClientMenu(C1);
					break;
				} catch (InputMismatchException e) {
					System.err.println("Wrong Input :(");
					ClientMenu(C1);
				}
			case 3:
				try {
					System.out.println("Enter EBook Title: ");
					scan.nextLine();
					String title = scan.nextLine();
					C1.addEbookByName(title);
					ClientMenu(C1);
					break;
				} catch (InputMismatchException e) {
					System.err.println("Wrong Input :(");
					ClientMenu(C1);
				}
			case 4:
				try {
					System.out.println("Enter CD Title: ");
					scan.nextLine();
					String title = scan.nextLine();
					C1.addCDByName(title);
					ClientMenu(C1);
					break;
				} catch (InputMismatchException e) {
					System.err.println("Wrong Input :(");
					ClientMenu(C1);
				}

			case 5:
				try {
					System.out.println("Book Name: ");
					scan.nextLine();
					String title = scan.nextLine();
					C1.returnToShelf(title);
					ClientMenu(C1);
					break;
				} catch (InputMismatchException e) {
					System.err.println("Wrong Input :(");
					ClientMenu(C1);
				}

			case 6:
				try {
					System.out.println(C1.Reciept());
					ClientMenu(C1);
					break;
				} catch (InputMismatchException e) {
					System.err.println("Wrong Input :(");
					ClientMenu(C1);
				}

			case 7:
				System.out.println("\nThank you, Good-Bye!");
				loop = false;
				break;

			default:
				System.err.println("No such value, Try Again!");
				ClientMenu(C1);
			}
		} catch (InputMismatchException e) {
			System.err.println("You didn't enter an integer :(");
			ClientMenu(C1);
		}

	}
}