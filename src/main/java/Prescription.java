public class Prescription {
    String drug;
    int amount;
    String notes;

    public Prescription(String drug, int amount, String notes) {
        this.drug = drug.replaceAll("[,\n]", "");
        this.amount = amount;
        this.notes = notes.replaceAll("[,\n]", "");
    }

    @Override
    public String toString() {
        return "Prescription:\n" +
                amount + " pills of " +
                drug + "; " +
                notes + '\n';
    }

    public void setDrug(String drug) {
        this.drug = drug.replaceAll("[,\n]", "");
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setNotes(String notes) {
        this.notes = notes.replaceAll("[,\n]", "");
    }

    public String getDrug() {
        return drug;
    }

    public int getAmount() {
        return amount;
    }

    public String getNotes() {
        return notes;
    }
}
