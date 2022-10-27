public class PatientVitals {
    private int height;
    private int weight;
    private int bodyTemp;
    private int bloodPress;

    public PatientVitals(int height, int weight, int bodyTemp, int bloodPress) {
        this.height = height;
        this.weight = weight;
        this.bodyTemp = bodyTemp;
        this.bloodPress = bloodPress;
    }

    @Override
    public String toString() {
        return "Patient Vitals:\n" +
                "height:" + height +
                ", weight: " + weight +
                ", body temperature: " + bodyTemp +
                ", blood pressure: " + bloodPress + "\n";
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setBodyTemp(int bodyTemp) {
        this.bodyTemp = bodyTemp;
    }

    public int getBodyTemp() {
        return bodyTemp;
    }

    public void setBloodP(int bloodP) {
        this.bloodPress = bloodP;
    }

    public int getBloodPress() {
        return bloodPress;
    }
}
