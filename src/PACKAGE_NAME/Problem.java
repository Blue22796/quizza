package PACKAGE_NAME;
public class Problem {
    private float rate;
    private String problemStatement;
    
    public Problem(float rate, String problemStatement) {
        this.rate = rate;
        this.problemStatement = problemStatement;
    }

    public Problem(String problemStatement) {
        this.problemStatement = problemStatement;
    }

    public Problem() {
        rate  =  5.0f;
        problemStatement = null;

    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getProblemStatement() {
        return problemStatement;
    }

    public void setProblemStatement(String problemStatement) {
        this.problemStatement = problemStatement;
    }
}
