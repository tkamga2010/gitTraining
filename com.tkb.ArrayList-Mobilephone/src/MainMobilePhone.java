import java.util.Scanner;

public class MainMobilePhone {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("111-222-3333");
	public static void main(String[] args) {
		boolean quit = false;
		int choice = 0;
		printInstructions();
		while(!quit) {
			System.out.println("Enter your Option");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice) {
			case 0:
				printInstructions();
				break;
			case 1:
				mobilePhone.printContacts();
				break;
			case 2:
				addContact();
				break;
			case 3:
				updateContact();
				break;
			case 4:
				deleteContact();
				break;
			case 5:
				searchContact();
				break;
			case 6:
				quit = true;
				break;
			}
		}
		

	}
	private static void searchContact() {
		System.out.println(" Please enter the contact name you are searching: ");
		String name = scanner.nextLine();
		if(!mobilePhone.getMyContacts().isEmpty()) {
			Contacts contact = mobilePhone.getContact(name);
			if(!contact.getName().isEmpty()) {
				System.out.println("Name---> " + contact.getName()+ " Phone Number---> "+ contact.getPhoneNumber() );
			}else {
				System.out.println(contact.getName()+ " Was not found " );

			}
		}else {
			System.out.println("The List is Empty");
		}
		
	}
	private static void deleteContact() {
		System.out.println(" Please enter the name to be deleted: ");
		String oldName = scanner.nextLine();
		Contacts contactToDelete = mobilePhone.getContact(oldName);
		if (mobilePhone.deleteContact(contactToDelete)){
			System.out.println(oldName + " Sucessfully deleted");
		}else {
			System.out.println(oldName + " Not found");
		}
		
	}
	private static void updateContact() {
		System.out.println(" Please enter the name to be updated: ");
		String oldName = scanner.nextLine();
		if(mobilePhone.searchContact(oldName)) {
			Contacts oldContact = mobilePhone.getContact(oldName);
			
			System.out.println(" Please enter the new name : ");
			String newName = scanner.nextLine();
			System.out.println(" Please enter the new phone number ");
			String newphoneNumber = scanner.nextLine();
			Contacts newContact = Contacts.createContact(newName, newphoneNumber);
			if(mobilePhone.updateContact(oldContact, newContact)) {
				System.out.println(oldContact.getName() + " Successfully updated to \n"+ newContact.getName());
		
			}else {
				System.out.println(oldName + " Not found in the List");
			}
		}else {
			System.out.println(oldName + " is not in the List");
		}
		
		
	}
	private static void addContact() {
		System.out.println("Please enter the Contact name: ");
		String name = scanner.nextLine();
		
		if(!mobilePhone.searchContact(name)) {//only add a name if it is not already in the list
			System.out.println("Please enter the Phone number: ");
			String phoneNumber = scanner.nextLine();
			Contacts contact = Contacts.createContact(name, phoneNumber);
			if(mobilePhone.addContact(contact)) {
				System.out.println(name + " Sucessfully added");
			}else {
				System.out.println(name + " Already in the contact List");
			}
		}else {// name is already in the list
			System.out.println(name + " Already in the contact List");
		}
		
		
	}
	private static void printInstructions() {
		System.out.println("\nAvailable options are:");
		System.out.println("0--> to print Instructions\n"
				+"1--> to print all contacts\n"
				+"2--> to add a new contact\n"
				+"3--> to update a contact\n"
				+"4--> to remove a contact\n"
				+"5--> to search a contact\n"
				+"6--> to quit application"
				);

	}

}
