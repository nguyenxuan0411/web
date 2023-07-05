package servlet;

import dao.FavoriteDAO;
import model.Favorite;
import model.User;
import model.Video;
import utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/UnlikeVideo")
public class UnlikeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");
		String videoId = req.getParameter("videoId");

		if (videoId == null) {
			resp.sendRedirect("Home");
			return;
		}
		try {
			FavoriteDAO dao = new FavoriteDAO();
			String userId = SessionUtils.getLoginUsername(req);
			List<Favorite> lstFavorite = dao.findFavoriteByVideoIdAndUserId(userId, videoId);
			System.out.println("UserID: " + userId);
			System.out.println("VideoID: " + videoId);
			System.out.println("List size: " + lstFavorite.size());
			for (Favorite favorite : lstFavorite) {
				dao.delete(favorite.getFavoriteId());
			}
			req.setAttribute("message", "Video is removed from favorite!");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		req.setAttribute("videoId", videoId);
		req.getRequestDispatcher("/Favorite").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("Home");
	}
}
