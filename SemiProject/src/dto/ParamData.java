package dto;

public class ParamData {

	private int datano;
	private int postno;
	private String title;
	
	@Override
	public String toString() {
		return "ParamData [datano=" + datano + ", postno=" + postno + ", title=" + title + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
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
	
	

	
	
	
}
