import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProfileDao {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public ProfileDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertProfile(Profile profile) throws SQLException {
        String sql = "INSERT INTO profile (name, lastName, telephone, email,birthDate) VALUES (?, ?, ?,?,?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, profile.getFirstName());
        statement.setString(2, profile.getLastName());
        statement.setString(3, profile.getTelephone());
        statement.setString(4, profile.getEmail());
        statement.setString(5, profile.getBirthDate());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Profile> listAllProfiles() throws SQLException {
        List<Profile> listProfile = new ArrayList<>();
        String sql = "SELECT * FROM profile";
        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String lastName = resultSet.getString("lastName");
            String telephone = resultSet.getString("telephone");
            String email = resultSet.getString("email");
            String birthdate = resultSet.getString("birthDate");

            Profile profile = new Profile(id, name, lastName,birthdate, telephone,email);
            listProfile.add(profile);
        }

        resultSet.close();
        statement.close();

        disconnect();
        return listProfile;
    }

    public List<Profile> searchProfiles(String term) throws SQLException {
        List<Profile> listProfile = new ArrayList<>();

        String sql = "SELECT * FROM profile WHERE name= ? OR lastName= ? OR telephone= ? OR email= ? OR birthDate= ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, term);
        statement.setString(2, term);
        statement.setString(3, term);
        statement.setString(4, term);
        statement.setString(5, term);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String lastName = resultSet.getString("lastName");
            String telephone = resultSet.getString("telephone");
            String email = resultSet.getString("email");
            String birthdate = resultSet.getString("birthDate");

            Profile profile = new Profile(id, name, lastName,birthdate, telephone,email);
            listProfile.add(profile);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listProfile;
    }

    public List<Profile> listASCBirthdate() throws SQLException {
        List<Profile> listProfile = new ArrayList<>();

        String sql = "SELECT * FROM profile ORDER BY birthDate";
        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String lastName = resultSet.getString("lastName");
            String telephone = resultSet.getString("telephone");
            String email = resultSet.getString("email");
            String birthdate = resultSet.getString("birthDate");

            Profile profile = new Profile(id, name, lastName,birthdate, telephone,email);
            listProfile.add(profile);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listProfile;
    }

    public List<Profile> listDESCBirthDate() throws SQLException {
        List<Profile> listProfile = new ArrayList<>();

        String sql = "SELECT * FROM profile ORDER BY birthDate DESC";
        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String lastName = resultSet.getString("lastName");
            String telephone = resultSet.getString("telephone");
            String email = resultSet.getString("email");
            String birthdate = resultSet.getString("birthDate");

            Profile profile = new Profile(id, name, lastName,birthdate, telephone,email);
            listProfile.add(profile);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listProfile;
    }

    public List<Profile> listASCNameProfiles() throws SQLException {
        List<Profile> listProfile = new ArrayList<>();

        String sql = "SELECT * FROM profile ORDER BY lastName";
        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String lastName = resultSet.getString("lastName");
            String telephone = resultSet.getString("telephone");
            String email = resultSet.getString("email");
            String birthdate = resultSet.getString("birthDate");

            Profile profile = new Profile(id, name, lastName,birthdate, telephone,email);
            listProfile.add(profile);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listProfile;
    }

    public List<Profile> listDESCNameProfiles() throws SQLException {
        List<Profile> listProfile = new ArrayList<>();

        String sql = "SELECT * FROM profile ORDER BY lastName DESC";
        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String lastName = resultSet.getString("lastName");
            String telephone = resultSet.getString("telephone");
            String email = resultSet.getString("email");
            String birthdate = resultSet.getString("birthDate");

            Profile profile = new Profile(id, name, lastName,birthdate, telephone,email);
            listProfile.add(profile);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listProfile;
    }


    public boolean deleteProfile(Profile profile) throws SQLException {
        String sql = "DELETE FROM profile where id = ?";

        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, profile.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean updateProfile(Profile profile) throws SQLException {

        String sql = "UPDATE profile SET name = ?, lastName = ?, telephone = ?, email = ?, birthDate = ? WHERE id = ?";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);

        statement.setString(1, profile.getFirstName());
        statement.setString(2, profile.getLastName());
        statement.setString(3, profile.getTelephone());
        statement.setString(4, profile.getEmail());
        statement.setString(5, profile.getBirthDate());
        statement.setInt(6, profile.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    public Profile getProfile(int id) throws SQLException {
        Profile profile = null;
        String sql = "SELECT * FROM profile WHERE id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String lastName = resultSet.getString("lastName");
            String telephone = resultSet.getString("telephone");
            String email = resultSet.getString("email");
            String birthdate = resultSet.getString("birthDate");

            profile = new Profile(id, name, lastName,birthdate, telephone, email);
        }

        resultSet.close();
        statement.close();

        return profile;
    }
}
