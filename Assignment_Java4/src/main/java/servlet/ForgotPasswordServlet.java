package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;
import utils.EmailUtils;

@WebServlet("/ForgotPassword")
public class ForgotPasswordServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/user/forgotpassword.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		sendMail(req, resp);
		req.getRequestDispatcher("/views/user/forgotpassword.jsp").forward(req, resp);
	}

	protected void sendMail(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String emailAddress = req.getParameter("email");
			String userId = req.getParameter("userId");
			UserDAO userDAO = new UserDAO();
			User user = userDAO.findByUserIdAndEmail(userId, emailAddress);
			if (user == null) {
				req.setAttribute("error", "Username or email address is incorrect!!");
			} else {
				EmailUtils.sendMail(emailAddress, "Forgot Password | JAVA 4", "Your password is: " + user.getPassword());
				req.setAttribute("message", "Recovery email is sent, please check your inbox!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
	}
}
