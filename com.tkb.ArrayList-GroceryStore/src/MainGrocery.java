import java.util.Scanner;



public class MainGrocery {


	private static Scanner scan = new java.util.Scanner(System.in);
	private static GroceryStore groceryStore = new GroceryStore();
	public static void main(String[] args) {
		boolean quit = false;
		int choice;
		printInstructions();
		while(!quit) {
			System.out.println("Enter your choice");
			choice = scan.nextInt();
			scan.nextLine();
			switch(choice) {
			case 0:
				printInstructions();
				break;
			case 1:
				groceryStore.printItems();
				break;
			case 2:
				addItem();
				break;
			case 3:
				modifyItem();
				break;
			case 4:
				removeItem();
				break;
			case 5:
				searchItem();
				break;
			case 6:
				quit = true;
				break;
			}
		}
	}
	private static void addItem() {
		System.out.println(" Enter Item to be added");
		String item = scan.nextLine();
		if(groceryStore.addItem(item)) {
			System.out.println(item + " successfully added");
		}else {
			System.out.println(item +" Already in the list. Was not added");
		}
	}
	private static void searchItem() {
		System.out.println("Please enter Item to be searched");
		String itemToSearch = scan.nextLine();
		String foundItemString = groceryStore.searchItem(itemToSearch);
		if(foundItemString== null) {
			System.out.println(itemToSearch + " Was not found");
		}else {
			System.out.println(itemToSearch + " Found");

		}

	}
	private static void removeItem() {
		System.out.println("Please enter Item to be removed");
		String item = scan.nextLine();
		if(groceryStore.renoveItem(item)) {
			System.out.println(item + " sucessfully removed");
		}else {
			System.out.println(item + " not found");
		}

	}
	private static void modifyItem() {
		System.out.println("Please enter Item to be modified");
		String oldItem = scan.nextLine();
		System.out.println("Please enter new Item ");
		String newItem = scan.nextLine();
		if(groceryStore.modifyItem(oldItem, newItem)) {
			System.out.println(oldItem + " successfully replaced by "+ newItem);
		}else {
			System.out.println(oldItem + " Not found cannot be replaced ");
		}
	}


	private static void printInstructions() {
		System.out.println("\nAvailable options are:");
		System.out.println("0--> to print choice\n"
				+"1--> to print Items\n"
				+"2--> to add Items\n"
				+"3--> to modify Items\n"
				+"4--> to remove Items\n"
				+"5--> to search Items\n"
				+"6--> to quit application"
				);

	}
}