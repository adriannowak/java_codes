import javax.websocket.Session;


public class HtmlContent extends BaseVO {

	private String url;
	private String content;
	
	public HtmlContent() {
		setType(TYPE.HTMLCONTENT);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	
	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	
	

}
