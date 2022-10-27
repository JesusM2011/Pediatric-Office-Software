import java.util.LinkedList;
import java.util.List;

public class Patient extends Account {
    private String email;
    private String phoneNumber;
    private String address;
    private String insuranceProvider;
    private String pharmacy;
    private String immunizations;
    private String issues;
    private List<VisitSummary> visitHistory;
    private VisitSummary currentVisit;

    int height;
    int weight;
    int bodyTemp;
    int bloodPress;

    public Patient(String firstName, String lastName, String birthday, String username, String password, String email, String phoneNumber) {
        super(firstName, lastName, birthday, username, password);
        this.type = 'p';
        this.immunizations = null;
        this.issues = null;
        this.visitHistory = new LinkedList<VisitSummary>();
        this.currentVisit = null;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = null;
        this.insuranceProvider = null;
        this.pharmacy = null;

    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.replaceAll("[,\n]", "");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber.replaceAll("[,\n]", "");
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address.replaceAll("[,\n]", "");
    }

    public String getInsuranceProvider() {
        return insuranceProvider;
    }

    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider.replaceAll("[,\n]", "");
    }

    public String getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(String pharmacy) {
        this.pharmacy = pharmacy.replaceAll("[,\n]", "");
    }

    public String getImmunizations() {
        return immunizations;
    }

    public void setImmunizations(String immunizations) {
        this.immunizations = immunizations.replaceAll("[,\n]", "");
    }

    public String getIssues(){
        return issues;
    }

    public void setIssues(String issues) {
        this.issues = issues.replaceAll("[,\n]", "");
    }

    public List<VisitSummary> getHistory() {
        return visitHistory;
    }

    public Prescription getCurrentPrescription() {
        if (currentVisit != null)
            return currentVisit.getPrescription();
        else return null;
    }

    public void setCurrentPrescription(String drug, int amount, String notes) {
        if (currentVisit == null) {
            currentVisit = new VisitSummary();
            visitHistory.add(currentVisit);
        }
        if (currentVisit.getPrescription() == null) {
            currentVisit.setPrescription(new Prescription(drug, amount, notes));
        }
        else {
            currentVisit.getPrescription().setDrug(drug);
            currentVisit.getPrescription().setAmount(amount);
            currentVisit.getPrescription().setNotes(notes);
        }
    }

    public PatientVitals getCurrentVitals() {
        if (currentVisit != null)
            return currentVisit.getVitals();
        else return null;
    }

    public void setCurrentVitals(int weight, int height, int bodyTemp, int bloodP) {
        if (currentVisit == null) {
            currentVisit = new VisitSummary();
            visitHistory.add(currentVisit);
        }
        if (currentVisit.getVitals() == null) {
            currentVisit.setVitals(new PatientVitals(weight, height, bodyTemp, bloodP));
        }
        else {
            currentVisit.getVitals().setWeight(weight);
            currentVisit.getVitals().setHeight(height);
            currentVisit.getVitals().setBodyTemp(bodyTemp);
            currentVisit.getVitals().setBloodP(bloodP);
        }
    }

    public String getCurrentHealthConcerns() {
        if (currentVisit != null)
            return currentVisit.getHealthConcerns();
        else return null;
    }

    public void setCurrentHealthConcerns(String concerns) {
        if (currentVisit == null) {
            currentVisit = new VisitSummary();
            visitHistory.add(currentVisit);
        }
        currentVisit.setHealthConcerns(concerns);
    }

    public String getCurrentRecommendations() {
        if (currentVisit != null)
            return currentVisit.getRecommendations();
        else return null;
    }

    public void setCurrentRecommendations(String recommendations) {
        if (currentVisit == null) {
            currentVisit = new VisitSummary();
            visitHistory.add(currentVisit);
        }
        currentVisit.setRecommendations(recommendations);
    }

    public boolean hasCurrentVisitSummary() {
        if (currentVisit != null) return true;
        else return false;
    }
}
