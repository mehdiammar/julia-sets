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
		char nsub = ((char) ('\u2099'));
		char psub = ((char) ('\u208A'));
		char osub = ((char) ('\u2081'));

		if (JuliaSet.c.getReal() < 0 && JuliaSet.c.getImaginary() > 0) {
			l.setText("z" + nsub + psub + osub + " = z" + nsub + sub + "- " + Math.abs(JuliaSet.c.getReal()) + " + "
					+ JuliaSet.c.getImaginary() + "i");
		}
		if (JuliaSet.c.getReal() > 0 && JuliaSet.c.getImaginary() > 0) {
			l.setText("z" + nsub + psub + osub + " = z" + nsub + sub + " + " + JuliaSet.c.getReal() + " + " + JuliaSet.c.getImaginary()
					+ "i");
		}
		if (JuliaSet.c.getReal() > 0 && JuliaSet.c.getImaginary() < 0) {
			l.setText("z" + nsub + psub + osub + " = z" + nsub + sub + " + " + JuliaSet.c.getReal() + " - "
					+ Math.abs(JuliaSet.c.getImaginary()) + "i");
		} else {
			l.setText("z" + nsub + psub + osub + " = z" + nsub + sub + " - " + Math.abs(JuliaSet.c.getReal()) + " - "
					+ Math.abs(JuliaSet.c.getImaginary()) + "i");
		}
	}
}
