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

	public int cv(String str) {
		int res = 0;

		switch (str) {
		case "A":
			res = 1;
			break;
		case "B":
			res = 2;
			break;
		case "C":
			res = 3;
			break;
		case "D":
			res = 4;
			break;

		default:
			break;
		}
		return res;
	}

	public List<BoCauHoi> getAllListBoCauHoi() {

		List<BoCauHoi> list = new ArrayList();

		String sql = "SELECT\r\n" + "    *\r\n" + "FROM\r\n" + "    `questions`\r\n" + "WHERE\r\n" + "    1";
		try {
			conn = ConnectionToSQL.createConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				BoCauHoi bch = new BoCauHoi(rs.getInt(1), rs.getString(2));
				list.add(bch);
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public List<Question> getAllQuesByIDBCH(int idBCH) {
		List<Question> list = new ArrayList<>();
		String sql = "SELECT\r\n" + "    *\r\n" + "FROM\r\n" + "    `question`\r\n" + "WHERE\r\n" + "    idQuestions="
				+ idBCH;
		try {
			conn = ConnectionToSQL.createConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Question ques = new Question(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
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
		String sql1 = "DELETE\r\n"
				+ "FROM\r\n"
				+ "    `question`\r\n"
				+ "WHERE\r\n"
				+ "    idQuestions='"+id+"'";
		String sql2 = "DELETE FROM `questions` WHERE idQuestion =" + id;
		

		try {
			conn = ConnectionToSQL.createConnection();

			ps = conn.prepareStatement(sql1);

			int temp = ps.executeUpdate();

			ps = conn.prepareStatement(sql2);
			temp = ps.executeUpdate();
			if (temp > 0) {
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BoCauHoi findBCHbyId(int id) {
		BoCauHoi bch = null;
		String sql = "SELECT\r\n" + "    *\r\n" + "FROM\r\n" + "    `questions`\r\n" + "WHERE\r\n" + "    id =" + id;
		try {
			conn = ConnectionToSQL.createConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				bch = new BoCauHoi(rs.getInt(1), rs.getString(2));
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bch;
	}

	public void xoaCauHoiByIDQuestion(Integer	id) {
		String sql = "DELETE\r\n"
				+ "FROM\r\n"
				+ "    `question`\r\n"
				+ "WHERE\r\n"
				+ "    id="+id;

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
		String sql = "INSERT INTO `question`(`id`, `question`, `idQuestions`, `answerA`, `answerB`, `answerC`, `answerD`, `answerCorrect`, `image`) VALUES ('"
				+ ques.getId() + "','" + ques.getCauhoi() + "','" + ques.getIdCauhoi() + "','" + ques.getQuesA() + "','"
				+ ques.getQuesB() + "','" + ques.getQuesC() + "','" + ques.getQuesD() + "','" + ques.getStatus() + "','"
				+ ques.getImg_ques() + "')";
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
		String sql = "INSERT INTO `questions`(`idQuestion`, `nameQuestion`)\r\n" + "VALUES('" + bch.getId() + "', '"
				+ bch.getTenBoCauHoi() + "')";
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

		List<Question> list = dao.getAllQuesByIDBCH(1);

		for (Question question : list) {

			System.out.print(question.getStatus() + "  " + dao.cv(question.getStatus().trim()));
//			System.out.println(question.getStatus().trim());
		}

	}

}
