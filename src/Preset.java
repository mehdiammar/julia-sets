
public class Preset {
	String name;
	int maxRange, minRange;
	double r, i;

	Preset(String name, double Real, double Imaginary, int minRange, int maxRange) {
		this.name = name;
		this.r = Real;
		this.i = Imaginary;
		this.minRange = minRange;
		this.maxRange = maxRange;
	}

	public String getName() {
		return this.name;
	}

	public int getMaxRange() {
		return this.maxRange;
	}

	public int getMinRange() {
		return this.minRange;
	}

	public double getReal() {
		return this.r;
	}

	public double getImaginary() {
		return this.i;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMaxRange(int max) {
		this.maxRange = max;
	}

	public void setMinRange(int min) {
		this.minRange = min;
	}

	public void setReal(double r) {
		this.r = r;
	}

	public void setImaginary(double i) {
		this.i = i;
	}

}
