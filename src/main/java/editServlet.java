import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "editServlet", value = "/edit")
public class editServlet extends HttpServlet {
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
                    updateProfile(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
    }
    private void updateProfile(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String birthDate = request.getParameter("birthdate");
        String telephone = request.getParameter("phone");
        String email = request.getParameter("email");

        Profile newProfile = new Profile(id,name, lastName, birthDate,telephone,email);
        profileDao.updateProfile(newProfile);
        response.sendRedirect("list");
    }
}