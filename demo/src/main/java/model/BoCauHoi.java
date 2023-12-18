package model;

public class BoCauHoi {
	private int id;
	private String tenBoCauHoi;

	public BoCauHoi(int id, String tenBoCauHoi) {
		super();
		this.id = id;
		this.tenBoCauHoi = tenBoCauHoi;
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


}
