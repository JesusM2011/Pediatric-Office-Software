import java.time.LocalDate;

public class VisitSummary {
    private Prescription prescription;
    private PatientVitals vitals;
    private String healthConcerns;
    private String recommendations;
    private LocalDate date;

    public VisitSummary() {
        this.prescription = null;
        this.vitals = null;
        this.healthConcerns = null;
        this.recommendations = null;
        this.date = LocalDate.now();
    }

    public VisitSummary(Prescription prescription, PatientVitals vitals, String healthConcerns, String recommendations, String date) {
        this.prescription = prescription;
        this.vitals = vitals;
        this.healthConcerns = healthConcerns.replaceAll("[,\n]", "");
        this.recommendations = recommendations.replaceAll("[,\n]", "");
        this.setDate(date);
    }

    @Override
    public String toString() {
        return "Visit Summary " + date;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public PatientVitals getVitals() {
        return vitals;
    }

    public void setVitals(PatientVitals vitals) {
        this.vitals = vitals;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public String getHealthConcerns() {
        return healthConcerns;
    }

    public void setHealthConcerns(String concerns) {
        this.healthConcerns = concerns;
    }

    public String getDate() {
        return date.toString();
    }

    public void setDate(String date) {
        this.date = LocalDate.parse(date);
    }
}
