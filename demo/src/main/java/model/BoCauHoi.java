package model;

public class BoCauHoi {
	private int id;
	private String tenBoCauHoi;
	private String img_bocauhoi;

	public BoCauHoi(int id, String tenBoCauHoi, String img_bocauhoi) {
		super();
		this.id = id;
		this.tenBoCauHoi = tenBoCauHoi;
		this.img_bocauhoi = img_bocauhoi;
	}

	public int getId() {
		return id;
	}

	public String getTenBoCauHoi() {
		return tenBoCauHoi;
	}

	public void setTenBoCauHoi(String tenBoCauHoi) {
		this.tenBoCauHoi = tenBoCauHoi;
	}

	public String getImg_bocauhoi() {
		return img_bocauhoi;
	}

	public void setImg_bocauhoi(String img_bocauhoi) {
		this.img_bocauhoi = img_bocauhoi;
	}

	@Override
	public String toString() {
		return "BoCauHoi [id=" + id + ", tenBoCauHoi=" + tenBoCauHoi + ", img_bocauhoi=" + img_bocauhoi + "]";
	}

}
