package com.example.demo;

import Database.DatabaseConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {

     List<Question> questions = new ArrayList<Question>();
    Connection connect = DatabaseConn.connectToControl();

    private static QuestionDao instance = null;

    public static QuestionDao getInstance(){
        if (instance == null)
            instance = new QuestionDao();
        return instance;
    }

    public  List<Question> getQuestions() {

            List<Question> questions = new ArrayList<>();
            String query = "SELECT * FROM questions"; // Thay đổi tên bảng và cột tương ứng trong cơ sở dữ liệu của bạn

            try {
                Statement s = connect.createStatement();

                ResultSet resultSet = s.executeQuery(query);

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String question = resultSet.getString("question");
                    String quesA = resultSet.getString("quesA");
                    String quesB = resultSet.getString("quesB");
                    String quesC = resultSet.getString("quesC");
                    String quesD = resultSet.getString("quesD");
                    String status = resultSet.getString("status");
                    String image = resultSet.getString("image");
                    Question q = new Question(id,question,quesA,quesB,quesC,quesD,status,image);
                    questions.add(q);
                }
            } catch (SQLException e) {
                e.printStackTrace(); // hoặc xử lý ngoại lệ theo ý muốn
            }

            System.out.println("GetQuestions");
        return questions;
    }

    public  Question findQuest(String quest){
        for (Question q: questions) {
            if(q.getQuestion().equals(quest)) return  q;
        }
        return null;
    }


}
