import java.util.List;

public class HealthIssues {
    List<String> issues;

    public HealthIssues() {
        this.issues = null;
    }

    public void addIssue(String issue) {
        issues.add(issue);
    }

    // MAKE READABLE BY setHealthIssuesFromString()
    @Override
    public String toString() {
        return "HealthIssues{" +
                issues + '}';
    }
}

