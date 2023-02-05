
package question;

import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
	// Main method is for you to test your code
	// You will not get any points here
	public static void main(String[] args) {
		
		Polynomial p1 = new Polynomial("3x^2-4x^4-8");
		p1.setDeltaX(0.00001);
		
		System.out.println(p1.computeIntegral(2,8));
		
		Polynomial p2 = new Polynomial("x^2+x^3+x-65");
		p2.setDeltaX(0.0001);
		
		System.out.println(p2.computeIntegral(3, 9));
		
		Polynomial p3 = new Polynomial("60");
		p3.setDeltaX(0.0001);
		System.out.println(p3.computeIntegral(4, 7));
		
		
		
	}

}

