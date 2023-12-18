package model;

public class Question {
	private int id;
	String cauhoi;
	String idCauhoi;
	String quesA;
	String quesB;
	String quesC;
	String quesD;
	String status;
	String img_ques;

	public Question(int id, String cauhoi, String idCauhoi, String quesA, String quesB, String quesC, String quesD,
			String status, String img_ques) {
		super();
		this.id = id;
		this.idCauhoi = idCauhoi;
		this.cauhoi = cauhoi;
		this.quesA = quesA;
		this.quesB = quesB;
		this.quesC = quesC;
		this.quesD = quesD;
		this.status = status;
		this.img_ques = img_ques;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCauhoi() {
		return cauhoi;
	}

	public void setCauhoi(String cauhoi) {
		this.cauhoi = cauhoi;
	}

	public String getIdCauhoi() {
		return idCauhoi;
	}

	public void setIdCauhoi(String idCauhoi) {
		this.idCauhoi = idCauhoi;
	}

	public String getQuesA() {
		return quesA;
	}

	public void setQuesA(String quesA) {
		this.quesA = quesA;
	}

	public String getQuesB() {
		return quesB;
	}

	public void setQuesB(String quesB) {
		this.quesB = quesB;
	}

	public String getQuesC() {
		return quesC;
	}

	public void setQuesC(String quesC) {
		this.quesC = quesC;
	}

	public String getQuesD() {
		return quesD;
	}

	public void setQuesD(String quesD) {
		this.quesD = quesD;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImg_ques() {
		return img_ques;
	}

	public void setImg_ques(String img_ques) {
		this.img_ques = img_ques;
	}

}
