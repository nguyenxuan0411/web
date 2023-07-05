package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VideoDAO;
import model.Video;

@WebServlet({"/","/Home"})
public class HomeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int page = 1, itemsPerPage = 2;
			if(req.getParameter("page") != null) page = Integer.parseInt(req.getParameter("page"));
			VideoDAO videoDAO = new VideoDAO();
			List<Video> list = videoDAO.findAll(false,(page-1) * itemsPerPage, itemsPerPage);
			int totalPage = (int) Math.ceil(videoDAO.count() / itemsPerPage);
			req.setAttribute("videos", list);
			req.setAttribute("totalPage", totalPage);
			req.setAttribute("currentPage", page);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		req.getRequestDispatcher("/views/user/home.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
