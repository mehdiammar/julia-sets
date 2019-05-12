import javax.swing.JLabel;

public class customMethods {

	public static double shift(double n, double shift) {
		n += shift;
		return n;
	}

	public static double calculateRange(double a, double b) {
		if (a == b)
			return 0;
		else if (a < 0 && b > 0)
			return Math.abs(a) + b;
		else if (a > 0 && b < 0)
			return Math.abs(b) + a;
		else if (a > 0 && b > 0 && (a < 0 && b < 0))
			return a - b;
		else
			return Math.abs(a - b);
	}
	
	public static void updateJLabel(JLabel l) {
		l.setText("z(n + 1) = z(n)^2 + " + "(" + JuliaSet.c + ")");
	}
}
