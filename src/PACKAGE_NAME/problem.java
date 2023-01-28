package PACKAGE_NAME;
public class problem {
    private float rate  ;
    private String problemStatement  ;
    private int id ;
    private static int number_problem = 0  ;
    public problem(float rate, String problemStatement) {
        this.rate = rate;
        this.problemStatement = problemStatement;

        this.id = ++number_problem ;
    }

    public problem(String problemStatement) {
        this.problemStatement = problemStatement;
        this.id = ++number_problem ;
    }

    public problem() {
        rate  =  5.0f;
        problemStatement = null ;
        id = ++number_problem ;

    }

    public float getRate(int id ) {
        // you will use the id to access the problem
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getProblemStatement() {
        // you will use the id to access the problem
        return problemStatement;
    }

    public void setProblemStatement(String problemStatement) {
        this.problemStatement = problemStatement;
    }

    public static int getNumber_problem() {
        return number_problem;
    }
}
