package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BoCauHoi;
import model.Question;

public class BoCauHoiDAO {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;

	public List<BoCauHoi> getAllListBoCauHoi() {

		List<BoCauHoi> list = new ArrayList();

		String sql = "SELECT\r\n" + "    *\r\n" + "FROM\r\n" + "    `bocauhoi`";
		try {
			conn = ConnectionToSQL.createConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				BoCauHoi bch = new BoCauHoi(rs.getInt(1), rs.getString(2), rs.getString(3));
				list.add(bch);
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public List<Question> getAllQuesByTenBCH(String tenBCH) {
		List<Question> list = new ArrayList();
		String sql = "SELECT\r\n" + "    *\r\n" + "FROM\r\n" + "    `questions`\r\n" + "WHERE\r\n" + "    TenBoCauHoi='"
				+ tenBCH + "'";
		try {
			conn = ConnectionToSQL.createConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Question ques = new Question(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
				list.add(ques);
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public void deleteBCHById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "DELETE\r\n" + "FROM\r\n" + "    `bocauhoi`\r\n" + "\r\n" + "WHERE\r\n" + "    idBoCauHoi = " + id;
		try {
			conn = ConnectionToSQL.createConnection();
			ps = conn.prepareStatement(sql);
			int temp = ps.executeUpdate();
			if (temp > 0) {

			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		BoCauHoiDAO dao = new BoCauHoiDAO();

		List<Question> list = dao.getAllQuesByTenBCH("Chau a");

		for (Question question : list) {
			if (question.getCauhoi().equalsIgnoreCase("A"))
				System.out.println(question.getCauhoi());
		}
	}
	public BoCauHoi findBCHbyId(int id) {
		BoCauHoi bch = null;
		String sql="SELECT\r\n"
				+ "    *\r\n"
				+ "FROM\r\n"
				+ "    `questions`\r\n"
				+ "WHERE\r\n"
				+ "    id ="+id;
		try {
			conn = ConnectionToSQL.createConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				bch = new BoCauHoi(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bch;
	}
public void xoaCauHoiByTenBCH(BoCauHoi bch) {
	String sql="DELETE\r\n"
			+ "FROM\r\n"
			+ "    `questions`\r\n"
			+ "WHERE\r\n"
			+ "    TenBoCauHoi = '"+bch.getTenBoCauHoi()+"'";
	
	try {
		conn = ConnectionToSQL.createConnection();
		ps = conn.prepareStatement(sql);
		int temp = ps.executeUpdate();
		if (temp > 0) {

		}
		conn.close();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public void addCauHoi(Question ques) {
		String sql = "INSERT INTO `questions`(\r\n"
				+ "    `id`,\r\n"
				+ "    `TenBoCauHoi`,\r\n"
				+ "    `question`,\r\n"
				+ "    `quesA`,\r\n"
				+ "    `quesB`,\r\n"
				+ "    `quesC`,\r\n"
				+ "    `quesD`,\r\n"
				+ "    `status`,\r\n"
				+ "    `image`\r\n"
				+ ")\r\n"
				+ "VALUES(\r\n"
				+ "    '"+ques.getId()+"',\r\n"
				+ "    '"+ques.getTenBCH()+"',\r\n"
				+ "    '"+ques.getCauhoi()+"',\r\n"
				+ "    '"+ques.getQuesA()+"',\r\n"
				+ "    '"+ques.getQuesB()+"',\r\n"
				+ "    '"+ques.getQuesC()+"',\r\n"
				+ "    '"+ques.getQuesD()+"',\r\n"
				+ "    '"+ques.getStatus()+"',\r\n"
				+ "    '"+ques.getImg_ques()+"'\r\n"
				+ ")";
		try {
			conn = ConnectionToSQL.createConnection();
			ps = conn.prepareStatement(sql);
			int temp = ps.executeUpdate();
			if (temp > 0) {

			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addBCH(BoCauHoi bch) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `bocauhoi`(\r\n" + "    `idBoCauHoi`,\r\n" + "    `TenBoCauHoi`,\r\n"
				+ "    `img_bocauhoi`\r\n" + ")\r\n" + "VALUES(\r\n" + "    '" + bch.getId() + "',\r\n" + "    '"
				+ bch.getTenBoCauHoi() + "',\r\n" + "    '" + bch.getImg_bocauhoi() + "'\r\n" + ")";
		try {
			conn = ConnectionToSQL.createConnection();
			ps = conn.prepareStatement(sql);
			int temp = ps.executeUpdate();
			if (temp > 0) {

			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
