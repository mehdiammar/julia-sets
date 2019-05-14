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
		char sub = ((char) ('\u00B2'));
		if (JuliaSet.c.getReal() < 0 && JuliaSet.c.getImaginary() > 0) {
			l.setText("z(n + 1) = z" + sub + "(n)" + "- " + Math.abs(JuliaSet.c.getReal()) + " + "
					+ JuliaSet.c.getImaginary() + "i");
		}
		if (JuliaSet.c.getReal() > 0 && JuliaSet.c.getImaginary() > 0) {
			l.setText("z(n + 1) = z" + sub + "(n) + " + JuliaSet.c.getReal() + " + " + JuliaSet.c.getImaginary() + "i");
		}
		if (JuliaSet.c.getReal() > 0 && JuliaSet.c.getImaginary() < 0) {
			l.setText("z(n + 1) = z" + sub + "(n) + " + JuliaSet.c.getReal() + " - "
					+ Math.abs(JuliaSet.c.getImaginary()) + "i");
		} else {
			l.setText("z(n + 1) = z" + sub + "(n) - " + Math.abs(JuliaSet.c.getReal()) + " - "
					+ Math.abs(JuliaSet.c.getImaginary()) + "i");
		}
	}
}
