package dto;

public class AttachmentsFile {

	private int fileno;
	private int userno;
	private String file_data;
	private int reviewno;
	private int recipeno;
	private int faqno;
	
	@Override
	public String toString() {
		return "AttachmentsFile [fileno=" + fileno + ", userno=" + userno + ", file_data=" + file_data + ", reviewno="
				+ reviewno + ", recipeno=" + recipeno + ", faqno=" + faqno + "]";
	}
	public int getFileno() {
		return fileno;
	}
	public void setFileno(int fileno) {
		this.fileno = fileno;
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public String getFile_data() {
		return file_data;
	}
	public void setFile_data(String file_data) {
		this.file_data = file_data;
	}
	public int getReviewno() {
		return reviewno;
	}
	public void setReviewno(int reviewno) {
		this.reviewno = reviewno;
	}
	public int getRecipeno() {
		return recipeno;
	}
	public void setRecipeno(int recipeno) {
		this.recipeno = recipeno;
	}
	public int getFaqno() {
		return faqno;
	}
	public void setFaqno(int faqno) {
		this.faqno = faqno;
	}
	
	
}
