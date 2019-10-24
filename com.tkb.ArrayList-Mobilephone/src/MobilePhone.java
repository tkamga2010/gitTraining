import java.util.ArrayList;

public class MobilePhone {
	private String phonenumber;
	private ArrayList<Contacts> myContacts;
	public MobilePhone(String phonenumber) {

		this.phonenumber = phonenumber;
		this.myContacts = new ArrayList<>();
	}


	public void printContacts() {
		if(myContacts.isEmpty()) {
			System.out.println("There is not contact in the list");
		}
		
		for (int i = 0; i < myContacts.size(); i++) {
			System.out.println(i+1 +" name---> "+ myContacts.get(i).getName()
					+" Phone Number---> "+ myContacts.get(i).getPhoneNumber());
		}
	}


	public boolean addContact(Contacts contact) {
		int position = getPosition(contact) ;
		if(!myContacts.contains(contact)) {
			myContacts.add(contact);
			return true;
		}
		return false;
	}


	// private internal method to get the position of the contact
	private int getPosition(Contacts contact) {
		return myContacts.indexOf(contact);

	}
	private int getPosition(String name) {
		for (int i = 0; i < myContacts.size(); i++) {
			if(myContacts.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}


	public Contacts getContact(String oldName) {

		int position = getPosition(oldName);
		if(position>=0) {
			return myContacts.get(position);
		}
		return null;
	}
	public boolean searchContact(String oldName) {

		int position = getPosition(oldName);
		if(position>=0) {
			return true;
		}
		return false;
	}


	public boolean updateContact(Contacts oldContact, Contacts newContact) {
		int position = getPosition(oldContact);
		if(position>=0) {
			myContacts.set(position, newContact);
			return true;
		}
		
		return false;
	}


	public boolean deleteContact(Contacts contactToDelete) {
          int position= getPosition(contactToDelete);
        if(position>= 0) {
        	myContacts.remove(position);
        	return true;
        }
        
		return false;
	}


	public ArrayList<Contacts> getMyContacts() {
		return myContacts;
	}
	
}
