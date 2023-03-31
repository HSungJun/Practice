package Manager;

import java.util.ArrayList;

import Classes.Member;

public class Manager {
	
	private ArrayList<Member> members = new ArrayList<Member>();
	
	
	public void insert(Member members) {
		this.members.add(members);
	}
	public ArrayList getMembers () {
		return members;
	}
//	public int getIndex() {
//		return (((String)members.get(getIndex())).length());
//	}
	
	
	
}