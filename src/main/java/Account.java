import java.util.List;

public class Account {
    private final String firstName;
    private final String lastName;
    private final String birthDate;
    private final String username;
    private final String password;
    protected char type;


    public Account(String firstName, String lastName, String birthday, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthday;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public String getPharmacy() {
        return null;
    }

    public String getEmail() {
        return null;
    }

    public String getPhoneNumber() {
        return null;
    }

    public String getInsuranceProvider() {
        return null;
    }

    public String getAddress() {
        return null;
    }

    public void setEmail(String text) {
    }

    public void setPhoneNumber(String text) {
    }

    public void setAddress(String text) {
    }

    public void setInsuranceProvider(String text) {
    }

    public void setPharmacy(String text) {
    }



    public Patient getCurrentPatient() {
        return null;
    }

    public void setMessage(String text) {
    }

    public List<VisitSummary> getHistory() {
        return null;
    }

    public char getType() {
        return type;
    }
}
