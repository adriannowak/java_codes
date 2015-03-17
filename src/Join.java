import com.google.gson.annotations.SerializedName;


public class Join extends BaseVO {
	private Long lastSeen;

	public Join() {
		setType(TYPE.JOIN);
	}
	public Long getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(Long lastSeen) {
		this.lastSeen = lastSeen;
	}
	
	
}
