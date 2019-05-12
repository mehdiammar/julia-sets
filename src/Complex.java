
public class Complex {

	private double r;
	private double i;

	public Complex(double r, double i) {
		this.r = r;
		this.i = i;
	}

	// Basic methods

	public double getReal() {
		return this.r;
	}

	public double getImaginary() {
		return this.i;
	}

	public double getMagnitude() {
		return (Math.sqrt((this.r) * (this.r) + (this.i) * (this.i)));
	}
	
	public void setReal(Double r) {
		this.r = r;
	}
	
	public void setImaginary(Double i) {
		this.i = i;
	}
	
//	public double getArgument() {
//		return Math.toDegrees(Math.atan(this.i / this.r));
//	}

	public String toString() {
		StringBuffer sb = new StringBuffer().append(r);
		if (i < 0)
			sb.append(" - " + Math.abs(i) + "i");
		else if (i > 0)
			sb.append(" + " + i + "i");
		return sb.toString();
	}

	public Boolean equals(Complex c) {
		return equals(this, c);
	}

	public Boolean equals(Complex a, Complex b) {
		if (a.r == b.r && a.i == b.i)
			return true;
		else
			return false;
	}

	// Addition

	public Complex add(Complex c) {
		return add(this, c);
	}
	
	public Complex add(Double n) {
		return new Complex(this.r + n, this.i);
	}

	public Complex add(Complex a, Complex b) {
		return new Complex(a.r + b.r, a.i + b.i);
	}

	// Subtract

	public Complex subtract(Complex c) {
		return subtract(this, c);
	}
	
	public Complex subtract(Double n) {
		return new Complex(this.r - n, this.i);
	}

	public Complex subtract(Complex a, Complex b) {
		return new Complex(a.r - b.r, a.i - b.i);
	}

	// Multiply

	public Complex multiply(Complex c) {
		return multiply(this, c);
	}

	public Complex multiply(double n) {
		return new Complex(n * this.r, n * this.i);
	}

	public Complex multiply(Complex a, Complex b) {
		return new Complex(a.r * b.r - (a.i * b.i), a.r * b.i + b.r * a.i);
	}
	
	// Powers
	
	public Complex power(Complex c, int p) {
		return power(this, c, p);

	}

	public Complex power(Complex complex, Complex c, int p) {
		return null;
	}
}
