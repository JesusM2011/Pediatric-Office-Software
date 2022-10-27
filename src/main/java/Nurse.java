public class Nurse extends Account{

    public Nurse(String firstName, String lastName, String birthday, String username, String password) {
        super(firstName, lastName, birthday, username, password);
        this.type = 'n';
    }
}
