import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "searchServlet", value = "/searchServlet")
public class searchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProfileDao profileDao;

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        profileDao = new ProfileDao(jdbcURL, jdbcUsername, jdbcPassword);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

                try {
                    searchProfiles(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
    }

    private void searchProfiles(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String term = request.getParameter("term");
        System.out.println( term);
        List<Profile> listProfile = profileDao.searchProfiles(term);

        request.setAttribute("listProfile", listProfile);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
