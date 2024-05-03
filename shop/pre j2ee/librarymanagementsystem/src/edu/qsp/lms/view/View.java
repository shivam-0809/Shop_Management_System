package edu.qsp.lms.view;

import java.util.Scanner;
import edu.qsp.lms.controller.LibraryController;
import edu.qsp.lms.model.Book;
import edu.qsp.lms.model.Library;

public class View {
	static Scanner myInput = new Scanner(System.in);
	static LibraryController controller = new LibraryController();
	static Library library = new Library();
	static {
		System.out.println("--------------WELCOME TO LIBRARY MANAGEMENT SYSTEM--------------------");
		//
		System.out.println("Enter name of library: ");
		String libraryName = myInput.nextLine();
		library.setLibraryName(libraryName);
		System.out.println("Enter the address of libray: ");
		String libraryAddress = myInput.nextLine();
		library.setLibraryAddress(libraryAddress);
		System.out.println("Enter the pincode: ");
		int libraryPincode = myInput.nextInt();
		myInput.nextLine();
		library.setLibraryPincode(libraryPincode);

	}

	public static void main(String[] args) {
		do {
			System.out.println("Select operation to perform: ");
			System.out.println(
					"1.Add book\n2.Remmove book\n3.Update book\n4.Get book by book name\n5.Get all books\0.Exit");
			System.out.println("Enter digit respective to desired options: ");
			int userChoice = myInput.nextInt();
			myInput.nextLine();
			switch (userChoice) {
			case 0:
				myInput.close();
				System.out.println("-------EXITED--------");
				System.exit(0);
				break;
			case 1:
				Book book1 =new Book();
				System.out.println("Enter the book name: ");
				book1.setBookName(myInput.nextLine());
				System.out.println("Enter Author name: ");
				book1.setBookAuthor(myInput.nextLine());
				System.out.println("Enter price of book: ");
				book1.setPrice(myInput.nextDouble());
				System.out.println("Enter publication: ");
				myInput.nextLine();
				book1.setPublication(myInput.nextLine());
				//
				controller.addBook(book1);

				break;
			case 2:
                System.out.println("Enter name of the book to be remove: ");
                String bookToBeRemoved= myInput.nextLine();
                boolean verify=controller.removeBookByBookName(bookToBeRemoved);
                if (verify) {
					System.out.println(" Book removed from library");
				}else {
					System.out.println("Book does not exists in library");
				}
				break;
			case 3:
				Book book3 =new Book();
				System.out.println("Enter the name of book to update: ");
				String bookToUpdate= myInput.nextLine();
				book3.setBookName(bookToUpdate);
				System.out.println("Enter price to update: ");
				double newPrice= myInput.nextDouble();
				book3.setPrice(newPrice);
				//
				boolean verifyUpdate=controller.updateBookPriceBookName(book3);
				if (verifyUpdate) {
					System.out.println("Price updated");
				} else {
					System.out.println("Mention book does not exists int the library");
				}
				
				break;
			case 4:
				System.out.println("Enter the name of book: ");
				 String bookToGet= myInput.nextLine();
				 //
				  Book book4 =controller.searchBook(bookToGet);
				  if (book4!=null) {
					System.out.println(book4);
				} else {
					System.out.println("Book not found.");

				}
				 
				break;
			case 5:
				System.out.println(controller.getAllBooks());

				break;

			default:
				System.out.println("------------INVALID SELECTION------------");
				break;
			}
		} while (true);
	}

}
