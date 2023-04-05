package Manager;

import Classes.Gold;
import Classes.Member;

public class Manager {
	private Member[] members = new Member[10];
	


	private int Index = 0;


	public void insert(Member members) {
		this.members[Index++] = members;
	}

	public Member[] getMembers() {
		return this.members;
	}


	public int  getIndex() {
		return Index;
	}

	





}

