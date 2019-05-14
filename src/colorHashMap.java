import java.util.HashMap;

public class colorHashMap {
	int i_r, i_g, i_b;
	HashMap<Integer, Color> hm;

	colorHashMap(int i_r, int i_g, int i_b) {
		hm = new HashMap<Integer, Color>();
		fillMap(i_r, i_g, i_b);

	}

	public int getSize() {
		return hm.size();
	}

	public void fillMap(int i_r, int i_g, int i_b) {
		int i = 0;
		for (int r = i_r; r < 256; r += 20) {
			for (int g = i_g; g < 256; g += 20) {
				for (int b = i_b; b < 256; b += 20) {
					hm.put(i, new Color(r, g, b));
					i++;
				}
			}
		}
	}

	public int setinitialR(int r) {
		this.i_r = r;
		return r;
	}

	public int setinitialG(int g) {
		this.i_g = g;
		return g;
	}

	public int setinitialB(int b) {
		this.i_b = b;
		return b;
	}

	public Color getColor(int i) {
		return hm.get(i);
	}

	class Color {
		int r, g, b;

		Color(int r, int g, int b) {
			this.r = r;
			this.g = g;
			this.b = b;
		}

		public int getR() {
			return this.r;
		}

		public int getG() {
			return this.g;
		}

		public int getB() {
			return this.b;
		}
	}
}
