public class Doctor extends Account{
    public Patient currentPatient;

    public Doctor(String firstName, String lastName, String birthday, String username, String password) {
        super(firstName, lastName, birthday, username, password);
        this.currentPatient = null;
        this.type = 'd';
    }

    public Patient getCurrentPatient() {
        return currentPatient;
    }
}
