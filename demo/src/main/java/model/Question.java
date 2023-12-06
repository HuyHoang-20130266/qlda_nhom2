package model;

public class Question {
	private int id;
	String tenBCH;
	String cauhoi;
	String quesA;
	String quesB;
	String quesC;
	String quesD;
	int status;
	String img_ques;

	public Question(int id, String tenBCH, String cauhoi, String quesA, String quesB, String quesC, String quesD,
			int status, String img_ques) {
		super();
		this.id = id;
		this.tenBCH = tenBCH;
		this.cauhoi = cauhoi;
		this.quesA = quesA;
		this.quesB = quesB;
		this.quesC = quesC;
		this.quesD = quesD;
		this.status = status;
		this.img_ques = img_ques;
	}

	public String getTenBCH() {
		return tenBCH;
	}

	public void setTenBCH(String tenBCH) {
		this.tenBCH = tenBCH;
	}

	public String getCauhoi() {
		return cauhoi;
	}

	public void setCauhoi(String cauhoi) {
		this.cauhoi = cauhoi;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getImg_ques() {
		return img_ques;
	}

	public void setImg_ques(String img_ques) {
		this.img_ques = img_ques;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", tenBCH=" + tenBCH + ", cauhoi=" + cauhoi + ", quesA=" + quesA + ", quesB="
				+ quesB + ", quesC=" + quesC + ", quesD=" + quesD + ", status=" + status + ", img_ques=" + img_ques
				+ "]";
	}

}
