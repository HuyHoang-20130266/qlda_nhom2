package Game;

import com.example.demo.Question;
import com.example.demo.QuestionDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "answer", value = "/answer")
public class PlayGame extends HttpServlet {
    int diem = 0;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String selectedAnswer = request.getParameter("selectedAnswer");
        System.out.println(selectedAnswer);
        int id = Integer.parseInt(request.getParameter("id"));
        int score = Integer.parseInt(request.getParameter("score"));

        List<Question> questions = QuestionDao.getInstance().getQuestions();
        Question q = null;
        a:for (Question ques: questions) {
            if(ques.getId()==id){
                q = ques;
                System.out.println(q.getAnswerCorrect());
                break a;

            }
        }

//        System.out.println(q.getStatus()+"   here");
//        System.out.println(selectedAnswer.substring(0,1));
        session.setAttribute("number",id);

        boolean check = q.getAnswerCorrect().equals(selectedAnswer.substring(0,1).trim());
        if(q.getAnswerCorrect().equals(selectedAnswer.substring(0,1).trim())){

            response.setContentType("text/plain");



            diem +=10;
            System.out.println(diem);
            String jsonData = "{ \"flag\": " + true + ", \"value\": " + diem + " }";

            response.getWriter().write(jsonData);

//            response.sendRedirect("question");

        }else {
            System.out.println("Sai");
            response.setContentType("text/plain");
            String jsonData = "{ \"flag\": " + false + ", \"value\": " + score + " }";
            response.getWriter().write(jsonData);
//            response.sendRedirect("question");
        }
        session.setAttribute("score",diem);

        // Xử lý đáp án đã chọn (thực hiện thêm logic xử lý tại đây)


        // Gửi phản hồi về client (nếu cần)




    }
}
