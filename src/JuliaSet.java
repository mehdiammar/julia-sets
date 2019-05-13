import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JuliaSet extends JFrame {

	final static int XSIZE = 1680;
	final static int YSIZE = 1080;
	final static int menuWidth = 280;
	final static int X = 400;
	final static int Y = 200;
	final static double zoomStep = 0.05;

	static Complex c = new Complex(-0.12, 0.75);
	static int max = 100;
	static double maxRange = 2;
	static double minRange = -2;
	static double range = maxRange + Math.abs(minRange);

	static boolean stripColors = false;

	static BufferedImage im = new BufferedImage(XSIZE, YSIZE, BufferedImage.TYPE_INT_RGB);
	static JuliaSet jS = new JuliaSet();
	static colorHashMap chm = new colorHashMap(256, 120, 0);

	private JLabel mapF = new JLabel("z(n + 1) = z(n)^2 + " + "(" + c + ")");
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fileMenu = new JMenu("File");
	private JMenu newSubMenu = new JMenu("New");
	private JMenu moreMenu = new JMenu("More");
	private JMenuItem generate = new JMenuItem("Generate");
	private JMenuItem presets = new JMenuItem("Presets");
	private JMenuItem colors = new JMenuItem("Disable colors");
	private JMenuItem quit = new JMenuItem("Quit");
	private JMenuItem about = new JMenuItem("About");

	public JuliaSet() {
		Panel jSPanel = new Panel();
		mapF.setFont(new Font("Arial", Font.PLAIN, 26));
		mapF.setForeground(Color.white);
		add(mapF, BorderLayout.SOUTH);
		setBounds(X, Y, XSIZE, YSIZE);
		setVisible(true);
		setTitle("Julia Set Visualizer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(jSPanel);
		add(menuBar, BorderLayout.NORTH);
		menuBar.add(fileMenu);
		fileMenu.add(newSubMenu);
		fileMenu.add(colors);
		fileMenu.add(quit);
		newSubMenu.add(generate);
		newSubMenu.add(presets);
		menuBar.add(moreMenu);
		moreMenu.add(about);

		// Mouse listeners

		addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				if (e.getWheelRotation() < 0) {
					maxRange = maxRange - zoomStep;
					minRange = minRange + zoomStep;
					range = customMethods.calculateRange(minRange, maxRange);
					generateImage();
				} else {
					maxRange = maxRange + zoomStep;
					minRange = minRange - zoomStep;
					range = customMethods.calculateRange(minRange, maxRange);
					generateImage();
				}
			}
		});
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addMouseMotionListener(new MouseAdapter() {
			int previousY;

			@Override
			public void mousePressed(MouseEvent e) {
				previousY = e.getY();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				int y = e.getY();
				if (y < previousY) {
					minRange = customMethods.shift(minRange, -0.05);
					maxRange = customMethods.shift(maxRange, -0.05);
					range = customMethods.calculateRange(minRange, maxRange);
					generateImage();
				}
				if (y > previousY) {
					minRange = customMethods.shift(minRange, 0.05);
					maxRange = customMethods.shift(maxRange, 0.05);
					range = customMethods.calculateRange(minRange, maxRange);
					generateImage();
				}
				previousY = y;
			}
		});

		// Menu actions listeners

		generate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean isNum = false;
				double rd = 0, id = 0;
				String r = null, i = null;
				while (!isNum) {
					r = JOptionPane.showInputDialog("Please enter the real part of c:");
					try {
						if (r != null)
							rd = Double.parseDouble(r);
						isNum = true;
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Please enter a number.");
					}
				}
				if (r != null)
					isNum = false;
				while (!isNum) {
					i = JOptionPane.showInputDialog("Please enter the imaginary part of c:");
					try {
						if (i != null)
							id = Double.parseDouble(i);
						isNum = true;
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Please enter a number.");
					}
				}
				if (r != null && i != null) {
					maxRange = 2;
					minRange = -2;
					range = customMethods.calculateRange(minRange, maxRange);
					c.setReal(rd);
					c.setImaginary(id);
					customMethods.updateJLabel(mapF);
					generateImage();
				}
			}
		});
		presets.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Object[] presets = { "Douady's Rabbit", "Dendrite", "San Marco", "Siegel Disk" };
				String s = (String) JOptionPane.showInputDialog(null, "Select a preset:", "Presets",
						JOptionPane.PLAIN_MESSAGE, null, presets, "Douady's Rabbit");
				if (s != null) {
					if (s.equals("Douady's Rabbit")) {
						maxRange = 2;
						minRange = -2;
						range = customMethods.calculateRange(minRange, maxRange);
						c.setReal(-0.12);
						c.setImaginary(0.745);
						customMethods.updateJLabel(mapF);
						generateImage();
					}
					if (s.equals("Dendrite")) {
						maxRange = 2;
						minRange = -2;
						range = customMethods.calculateRange(minRange, maxRange);
						c.setReal(0.0);
						c.setImaginary(1.0);
						customMethods.updateJLabel(mapF);
						generateImage();
					}
					if (s.equals("San Marco")) {
						maxRange = 2;
						minRange = -2;
						range = customMethods.calculateRange(minRange, maxRange);
						c.setReal(-0.75);
						c.setImaginary(0.0);
						customMethods.updateJLabel(mapF);
						generateImage();
					}
					if (s.equals("Siegel Disk")) {
						maxRange = 2;
						minRange = -2;
						range = customMethods.calculateRange(minRange, maxRange);
						c.setReal(-0.390541);
						c.setImaginary(0.586788);
						customMethods.updateJLabel(mapF);
						generateImage();
					}
				}
			}
		});
		colors.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				stripColors ^= true;
				if (stripColors) {
					colors.setText("Enable colors");
					mapF.setForeground(Color.black);
				} else {
					colors.setText("Disable colors");
					mapF.setForeground(Color.white);
				}
				generateImage();
			}
		});
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						"Given a complex number \"c\" and a complex number \"z\", let z(n+1) = z(n)^2 + c. "
								+ "\nIf z(n) does not tend to infinity as n tends to infinity, then z(n) belongs to the filled-in Julia Set."
								+ "\nThese pseudofractals are generated in the [-2, 2] range with 100 calculations for each pixel."
								+ "\n\n The colors help indicate which numbers converge the fatest (which are closer to the black area)."
								+ "\n\n",
						"Julia sets", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

	// Main

	public static void main(String[] args) {
		generateImage();
	}

	public static void generateImage() {
		int i = 0;
		for (int y = 0; y < im.getHeight(); y++) {
			for (int x = 0; x < im.getWidth(); x++) {
				double c_r = (range / XSIZE) * x - Math.abs(minRange);
				double c_i = (range / YSIZE) * y - Math.abs(maxRange);
				Complex n = new Complex(c_r, c_i);
				Complex temp = n;
				i = 0;
				while ((n.getReal() * n.getReal() + n.getImaginary() * n.getImaginary()) <= (2 * 2) && i < max) {
					temp = (n.multiply(n)).add(c);
					n = temp;
					i++;
				}
				im.setRGB(x, y, chm.getColor(i).getR() - chm.getColor(i).getG() - chm.getColor(i).getB());
				if (stripColors) {
					if (i <= 64)
						im.setRGB(x, y, 0xffffff);
				}
				if (i > 64)
					im.setRGB(x, y, 0x000000);
				jS.repaint();
			}
		}
	}

	public static class Panel extends JPanel {

		JLabel imageIcon = new JLabel(new ImageIcon(im));

		public Panel() {

			setLayout(new BorderLayout());
			add(imageIcon, BorderLayout.CENTER);
		}
	}
}
