public class Profile {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String birthDate;
    protected String telephone;
    protected String email;

    public Profile(){
    }

    public Profile(int id){
        this.id = id;
    }

    public Profile(int id, String firstName, String lastName, String birthDate,String telephone,String email) {
        this(firstName, lastName, birthDate,telephone,email);
        this.id = id;
    }

    public Profile(String firstName, String lastName, String birthDate,String telephone,String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.telephone = telephone;
        this.email = email;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
