package controll;

import dao.BoCauHoiDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "/bocauhoi", value = "/bocauhoi_detail")
public class BoCauHoiDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public BoCauHoiDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("idBCH"));
        String tenBCH = request.getParameter("tenBCH");

        BoCauHoiDAO bchDAO = new BoCauHoiDAO();

        request.setAttribute("tenBCH", tenBCH);
        request.setAttribute("idBCH", id);
        request.setAttribute("bchDAO", bchDAO);

        request.setAttribute("ListQuestions", bchDAO.getAllQuesByIDBCH(id));

        request.getRequestDispatcher("bocauhoi_detail.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}