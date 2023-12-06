package controll;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.BoCauHoiDAO;
import model.BoCauHoi;
import model.Question;

/**
 * Servlet implementation class CRUDServlet
 */
@MultipartConfig
@WebServlet("/crud")
public class CRUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String SAVE_DIR = "img";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	private String extractFileName(Part part) {

		String contentDisp = part.getHeader("content-disposition");

		String[] items = contentDisp.split(";");

		for (String s : items) {

			if (s.trim().startsWith("filename")) {

				return s.substring(s.indexOf("=") + 2, s.length() - 1);

			}

		}

		return "";

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		BoCauHoiDAO bchDAO = new BoCauHoiDAO();
		PrintWriter out = response.getWriter();

		String tensp, mau, img, mota, savePath, appPath, phanloaiStr, Path, fileName;
		File fileSaveDir;

		Part path;

		switch (action) {
		case "xoaBCH":
			String idstr = request.getParameter("idBCH");
			if (!idstr.equals("")) {
				Integer id = Integer.parseInt(idstr);
//				BoCauHoi bch = bchDAO.findBCHbyId(id);
//				bchDAO.xoaCauHoiByTenBCH(bch);
			
				bchDAO.deleteBCHById(id);
				
				
				
				response.sendRedirect(request.getContextPath() + "/ql_bocauhoi");
			} else {
				response.sendRedirect(request.getContextPath() + "/ql_bocauhoi");
			}

			break;
		case "themBCH":
			String tenBCH = request.getParameter("tenBCH");
			if (!tenBCH.equals("")) {
				BoCauHoi bch = new BoCauHoi(0, tenBCH, "");
				bchDAO.addBCH(bch);

				response.sendRedirect(request.getContextPath() + "/ql_bocauhoi");
			} else {
				response.sendRedirect(request.getContextPath() + "/ql_bocauhoi");
			}

			break;
		case "themCH":

			String tenbocauhoi = request.getParameter("tenBCH");
			String cauhoi = request.getParameter("cauhoi");
			String dapanA = request.getParameter("dapanA");
			String dapanB = request.getParameter("dapanB");
			String dapanC = request.getParameter("dapanC");
			String dapanD = request.getParameter("dapanD");
			int status = Integer.parseInt(request.getParameter("status"));
//			String dung = request.getParameter("status");
			String img_path = request.getParameter("file");

			appPath = request.getServletContext().getRealPath("");

			// constructs path of the directory to save uploaded file
			path = request.getPart("file");
			savePath = appPath + File.separator + SAVE_DIR + "/";
			Path = savePath + img_path;
			// creates the save directory if it does not exists

			fileSaveDir = new File(Path);
			path = request.getPart("file");
			savePath = appPath + File.separator + SAVE_DIR + "/";
			Path = savePath + extractFileName(path);
			// creates the save directory if it does not exists

			fileSaveDir = new File(Path);
			String imgPath = "";

			if (fileSaveDir.exists()) {
				System.out.print("ko up file");
				imgPath = extractFileName(path);
//				fileSaveDir.mkdir();

			} else {
				System.out.print("up file");
				imgPath = extractFileName(path);
				for (Part part : request.getParts()) {

					fileName = extractFileName(part);
					try {
						part.write(savePath + File.separator + fileName);
					} catch (Exception e) {
						// TODO: handle exception
					}

				}
			}
			Question q = new Question(0, tenbocauhoi, cauhoi, dapanA, dapanB, dapanC, dapanD, status, imgPath);
			bchDAO.addCauHoi(q);
			response.sendRedirect(request.getContextPath() + "/bocauhoi_detail?name=" + tenbocauhoi);
//			out.print(status);
			break;
		default:
			break;
		}
	}

}
