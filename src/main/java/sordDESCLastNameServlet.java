import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "sordDESCLastNameServlet", value = "/sordDESCLastNameServlet")
public class sordDESCLastNameServlet extends HttpServlet {
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
            sortNameDESC(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void sortNameDESC(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Profile> listProfile = profileDao.listDESCNameProfiles();

        request.setAttribute("listProfile", listProfile);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}