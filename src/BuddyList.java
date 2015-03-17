import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class BuddyList extends BaseVO {

	private Set<String> buddyList = new HashSet<>();
	
	public BuddyList(Collection<Join> joins,String nick) {
		this.setSrc(nick);
		
		setType(TYPE.BUDDYLIST);
		for(Join join : joins) {
			System.err.println("User - "+join.getSrc());
			buddyList.add(join.getSrc());
		}
	}

}
