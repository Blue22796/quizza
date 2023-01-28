package PACKAGE_NAME;
import java.util.Random;
public class RateCalculator {
	public static float getNextProblemRate(float mean, float SD) {
		Random rand = new Random();
		float rate = (float)rand.nextGaussian();
		rate*=SD;
		rate+=mean;
		return rate;
		
	}
}
