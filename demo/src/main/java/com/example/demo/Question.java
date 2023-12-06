package com.example.demo;

public class Question {
    private int id;
    private String question;
    private String quesA;
    private String quesB;
    private String quesC;
    private String quesD;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String image;

    public Question(int id, String question, String quesA, String quesB, String quesC, String quesD, String status, String image){
        this.id = id;
        this.question = question;
        this.quesA = quesA;
        this.quesB = quesB;
        this.quesC = quesC;
        this.quesD = quesD;
        this.status = status;
        this.image = image;
    }


}
