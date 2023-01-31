package PACKAGE_NAME;

import java.util.ArrayList;

public class QuizGenerator {
	float mean;
	float SD;
	int count;
	ArrayList<Problem> problems;
	public QuizGenerator(float mean, float SD, int count) {
		this.mean = mean;
		this.SD = SD;
		this.count = count;
		
		PDBC conc = PDBC.getInstance();
		this.problems=conc.getProblems();
	}
	
	
	public ArrayList<Problem> generateQuiz(){
		ArrayList<Problem> quiz = new ArrayList<Problem>();
		Boolean[] used = new Boolean[problems.size()];
		for(int i = 0;i<used.length;i++)
			used[i]=false;
		
		for(int i = 0; i<count;i++) {
			float rate = RateCalculator.getNextProblemRate(this.mean,this.SD);
			float dist = Float.MAX_VALUE;
			int bm = -1;
			
			for(int j = 0; j<problems.size();j++) {
				if(used[j]) continue;
				float d = problems.get(j).getRate()-rate;
				d*=d;
				if(d<dist) {
					bm=j;
					dist=d;
				}
				
				
			}
			quiz.add(problems.get(bm));
			used[bm]=true;
		}
		return quiz;
		
	}
	
	
}
