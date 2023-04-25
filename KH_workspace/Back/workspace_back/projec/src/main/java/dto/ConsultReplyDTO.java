package dto;

import java.sql.Timestamp;

public class ConsultReplyDTO {

	private int replyID;
	private String title;
	private String body;
	private int consultID;
	private int userID;
	private Timestamp writedate;

	public ConsultReplyDTO() {
		super();
	}

	public ConsultReplyDTO(int replyID, String title, String body, int consultID, int userID, Timestamp writedate) {
		super();
		this.replyID = replyID;
		this.title = title;
		this.body = body;
		this.consultID = consultID;
		this.userID = userID;
		this.writedate = writedate;
	}

	public int getReplyID() {
		return replyID;
	}

	public void setReplyID(int replyID) {
		this.replyID = replyID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getConsultID() {
		return consultID;
	}

	public void setConsultID(int consultID) {
		this.consultID = consultID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Timestamp getWritedate() {
		return writedate;
	}

	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}

}
