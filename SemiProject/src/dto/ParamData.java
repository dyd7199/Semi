package dto;

public class ParamData {

	private int datano;
	private int postno;
	private String title;
	private String content;
	
	
	@Override
	public String toString() {
		return "ParamData [datano=" + datano + ", postno=" + postno + ", title=" + title + ", content=" + content + "]";
	}


	public int getDatano() {
		return datano;
	}


	public void setDatano(int datano) {
		this.datano = datano;
	}


	public int getPostno() {
		return postno;
	}


	public void setPostno(int postno) {
		this.postno = postno;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	

	
	
	
}
