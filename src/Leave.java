
public class Leave extends BaseVO {

	public Leave(Join join) {
		setSrc(join.getSrc());
		setType(TYPE.LEAVE);

	}

}
