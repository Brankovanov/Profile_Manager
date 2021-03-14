import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "insertServlet", value = "/insertServlet")
public class insertServlet extends HttpServlet {
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
                    insertProfile(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
    }

    private void insertProfile(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String birthDate = request.getParameter("birthdate");
        String telephone = request.getParameter("phone");
        String email = request.getParameter("email");
        Profile newProfile = new Profile(name, lastName, birthDate,telephone,email);
        profileDao.insertProfile(newProfile);
        response.sendRedirect("list");
    }
}