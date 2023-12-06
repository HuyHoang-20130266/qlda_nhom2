package Game;

import com.example.demo.Question;
import com.example.demo.QuestionDao;
import com.mysql.cj.xdevapi.JsonString;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import netscape.javascript.JSObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "answer", value = "/answer")
public class PlayGame extends HttpServlet {
    int diem = 0;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String selectedAnswer = request.getParameter("selectedAnswer");
        int id = Integer.parseInt(request.getParameter("id"));
        int score = Integer.parseInt(request.getParameter("score"));
        System.out.println("Score "+score);
        List<Question> questions = QuestionDao.getInstance().getQuestions();
        Question q = null;
        a:for (Question ques: questions) {
            if(ques.getId()==id){
                q = ques;
                break a;
            }
        }

//        System.out.println(q.getStatus()+"   here");
//        System.out.println(selectedAnswer.substring(0,1));
        session.setAttribute("number",id-1);
        System.out.println("Cau hoi:" + id);
        boolean check = q.getStatus().equals(selectedAnswer.substring(0,1).trim());
        if(q.getStatus().equals(selectedAnswer.substring(0,1).trim())){

            response.setContentType("text/plain");


            score +=10;
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
