import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Database {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Nurse> nurses;

    public Account loggedOn;

    public Database() {
        this.patients = new LinkedList<Patient>();
        this.doctors = new LinkedList<Doctor>();
        this.nurses = new LinkedList<Nurse>();
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
    }

    public void addNurse(Nurse nurse) {
        this.nurses.add(nurse);
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public Patient findPatient(String username) {
        for (Patient patient : this.patients) {
            if (patient.getUsername().equals(username))
                return patient;
        }
        return null;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public void authenticate(String username, String password) {
        // search through patients
        for (Patient patient : this.patients) {
            if (patient.getUsername().equals(username) && patient.getPassword().equals(password)) {
                this.loggedOn = patient;
            }
        }
        // search through doctors
        for (Doctor doctor : this.doctors) {
            if (doctor.getUsername().equals(username) && doctor.getPassword().equals(password)) {
                this.loggedOn = doctor;
            }
        }
        // search through nurses
        for (Nurse nurse : this.nurses) {
            if (nurse.getUsername().equals(username) && nurse.getPassword().equals(password)) {
                this.loggedOn = nurse;
            }
        }
    }

    public void logOut() {
        loggedOn = null;
    }

    public void patientsFromFile() {
        String line;

        try (BufferedReader br = Files.newBufferedReader(Paths.get("src/main/data/patients.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] patientData = line.split(",");

                String firstName = patientData[0];
                String lastName = patientData[1];
                String birthDate = patientData[2];
                String username = patientData[3];
                String password = patientData[4];
                String email = patientData[5];
                String phoneNumber = patientData[6];
                String address = patientData[7];
                String insuranceProvider = patientData[8];
                String pharmacy = patientData[9];
                String immunizationRecord = patientData[10];
                String healthIssues = patientData[11];

                Patient newPatient = new Patient(firstName, lastName, birthDate, username, password, email, phoneNumber);
                this.addPatient(newPatient);
                newPatient.setAddress(address);
                newPatient.setInsuranceProvider(insuranceProvider);
                newPatient.setPharmacy(pharmacy);
                newPatient.setImmunizations(immunizationRecord);
                newPatient.setIssues(healthIssues);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (BufferedReader br = Files.newBufferedReader(Paths.get("src/main/data/visits.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] patientData = line.split(",");

                String username = patientData[0];
                int prescriptionAmount = Integer.parseInt(patientData[1]);
                String prescriptionDrug = patientData[2];
                String prescriptionNotes = patientData[3];
                int height = Integer.parseInt(patientData[4]);
                int weight = Integer.parseInt(patientData[5]);
                int bodyTemp = Integer.parseInt(patientData[6]);
                int bloodP = Integer.parseInt(patientData[7]);
                String healthConcerns = patientData[8];
                String recommendations = patientData[9];
                String date = patientData[10];

                Prescription prescription = new Prescription(prescriptionDrug, prescriptionAmount, prescriptionNotes);
                PatientVitals vitals = new PatientVitals(height, weight, bodyTemp, bloodP);
                VisitSummary summary = new VisitSummary(prescription, vitals, healthConcerns, recommendations, date);
                this.findPatient(username).getHistory().add(summary);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void patientsToFile() {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("src/main/data/patients.csv"))) {
            for (Patient patient : this.patients) {
                bw.write(patient.getFirstName() + ",");
                bw.write(patient.getLastName() + ",");
                bw.write(patient.getBirthDate() + ",");
                bw.write(patient.getUsername() + ",");
                bw.write(patient.getPassword() + ",");
                bw.write(patient.getEmail() + ",");
                bw.write(patient.getPhoneNumber() + ",");
                bw.write(patient.getAddress() + ",");
                bw.write(patient.getInsuranceProvider() + ",");
                bw.write(patient.getPharmacy() + ",");
                bw.write(patient.getImmunizations() + ",");
                bw.write(patient.getIssues() + ",");
                bw.write("\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("src/main/data/visits.csv"))) {
            for (Patient patient : this.patients) {
                for (VisitSummary summary : patient.getHistory()) {
                    bw.write(patient.getUsername() + ",");
                    bw.write(summary.getPrescription().getAmount() + ",");
                    bw.write(summary.getPrescription().getDrug() + ",");
                    bw.write(summary.getPrescription().getNotes() + ",");
                    bw.write(summary.getVitals().getHeight() + ",");
                    bw.write(summary.getVitals().getWeight() + ",");
                    bw.write(summary.getVitals().getBodyTemp() + ",");
                    bw.write(summary.getVitals().getBloodPress() + ",");
                    bw.write(summary.getHealthConcerns() + ",");
                    bw.write(summary.getRecommendations() + ",");
                    bw.write(summary.getDate() + ",");
                    bw.write("\n");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
