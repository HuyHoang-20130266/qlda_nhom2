package controll;

import dao.BoCauHoiDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "/ql_bocauhoi", value = "/ql_bocauhoi")
public class BoCauHoiServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public BoCauHoiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        BoCauHoiDAO bchDAO = new BoCauHoiDAO();

        request.setAttribute("ListBoCauHoi", bchDAO.getAllListBoCauHoi());
        request.getRequestDispatcher("ql_bocauhoi.jsp").forward(request, response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
