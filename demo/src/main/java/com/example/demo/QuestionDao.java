package com.example.demo;

import Database.DatabaseConn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            String query = "SELECT * FROM question"; // Thay đổi tên bảng và cột tương ứng trong cơ sở dữ liệu của bạn

            try {
                Statement s = connect.createStatement();

                ResultSet resultSet = s.executeQuery(query);

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String question = resultSet.getString("question");
                    String answerA = resultSet.getString("answerA");
                    String answerB = resultSet.getString("answerB");
                    String answerC = resultSet.getString("answerC");
                    String answerD = resultSet.getString("answerD");
                    String idQuestions = resultSet.getString("idQuestions");
                    String image = resultSet.getString("image");
                    String answerCorrect = resultSet.getString("answerCorrect");

                    Question q = new Question(id,idQuestions,question,answerA,answerB,answerC,answerD,answerCorrect,image);
                    System.out.println(q);
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
