package Talangthang.com.project;

public class Feedback {
    private String email;
    private String feedback;

    public Feedback(String email, String feedback) {
        this.email = email;
        this.feedback = feedback;
    }

    public Feedback() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "email='" + email + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
