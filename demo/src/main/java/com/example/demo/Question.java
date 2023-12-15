package com.example.demo;

public class Question {
    private int id;
    private String question;
    private String idQuestions;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String AnswerCorrect;
    private String image;

    public Question(int id, String question, String idQuestions, String answerA, String answerB, String answerC, String answerD, String answerCorrect, String image) {
        this.id = id;
        this.question = question;
        this.idQuestions = idQuestions;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.AnswerCorrect = answerCorrect;
        this.image = image;
    }

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

    public String getIdQuestions() {
        return idQuestions;
    }

    public void setIdQuestions(String idQuestions) {
        this.idQuestions = idQuestions;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getAnswerCorrect() {
        return AnswerCorrect;
    }

    public void setAnswerCorrect(String answerCorrect) {
        AnswerCorrect = answerCorrect;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", idQuestions='" + idQuestions + '\'' +
                ", answerA='" + answerA + '\'' +
                ", answerB='" + answerB + '\'' +
                ", answerC='" + answerC + '\'' +
                ", answerD='" + answerD + '\'' +
                ", AnswerCorrect='" + AnswerCorrect + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
