package com.example.demo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "getQuestions", value = "/question")
public class QuestionSeverlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Gọi QuestionDAO để lấy danh sách câu hỏi từ cơ sở dữ liệu
        Object score = request.getAttribute("check");
        if(score == null){
            score = false;
        }
        boolean check = (boolean) score;

        response.setCharacterEncoding("UTF-8");
        List<Question> questions = QuestionDao.getInstance().getQuestions();

        // Đặt danh sách câu hỏi vào thuộc tính của request để truyền cho JSP
        request.setAttribute("questions", questions);

        // Chuyển hướng tới trang JSP để hiển thị câu hỏi
        request.getRequestDispatcher("maingame.jsp").forward(request,response);

    }

}
