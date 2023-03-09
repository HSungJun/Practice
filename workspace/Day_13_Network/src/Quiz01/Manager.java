package Quiz01;

import java.util.ArrayList;

public class Manager {
	private ArrayList<Contact> contact = new ArrayList<>();

	public void addContact(Contact contact) {
		this.contact.add(contact);
	}

	public int getContactSize() {
		return this.contact.size();
	}

	public ArrayList<Contact> getContact() {
		return this.contact;
	}

	public int removeContact(String name) {
		int index = this.getIndexByName(name);
		if (index == -1) {
			return index;
		} else {
			this.contact.remove(index);
			return 0;
		}
	}

	public int getIndexByName(String name) {
		for (int i = 0; i < contact.size(); i++) {
			if (contact.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	public ArrayList<Contact> listContact() {
		for (Contact list : this.contact) {
			String contact = (list.getId() + "\t" + list.getName() + "\t" + list.getPhone());
		}
		return contact;

	}

}
