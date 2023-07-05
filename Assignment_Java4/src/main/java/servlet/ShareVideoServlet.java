package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShareDAO;
import model.Share;
import model.User;
import model.Video;
import utils.EmailUtils;
import utils.SessionUtils;

@WebServlet("/ShareVideo")
public class ShareVideoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String videoId = req.getParameter("videoId");
        if (videoId == null) {
            resp.sendRedirect("Home");
            return;
        }
        req.setAttribute("videoId", videoId);
        req.getRequestDispatcher("/views/user/share.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sendMail(req, resp);
        req.getRequestDispatcher("/views/user/share.jsp").forward(req, resp);
    }

    protected void sendMail(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String emailAddress = req.getParameter("email");
            String videoId = req.getParameter("videoId");

            if (videoId == null) {
                req.setAttribute("error", "VideoId not found!");
            } else {
                EmailUtils.sendMail(emailAddress, "SHARE VIDEO | Java 4", "Link: " + videoId);
                ShareDAO shareDAO = new ShareDAO();
                Share share = new Share();
                share.setEmails(emailAddress);
                share.setShareDate(new Date());

                String userId = SessionUtils.getLoginUsername(req);
                User user = new User();
                user.setUserId(userId);
                share.setUser(user);

                Video video = new Video();
                video.setVideoId(videoId);
                share.setVideo(video);

                shareDAO.insert(share);
                req.setAttribute("message", "Video link had been sent!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", e.getMessage());
        }
    }
}
