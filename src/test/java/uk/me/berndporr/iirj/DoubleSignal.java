package uk.me.berndporr.iirj;

public class DoubleSignal
{
	private final double[] xValues;
	private final double[] values;
	private final String name;

	public DoubleSignal(int length, String name) {
		xValues = new double[length];
		values = new double[length];
		this.name = name;
	}

	void setValue(int index, double time, double value) {
		xValues[index] = time;
		values[index] = value;
	}

	double getValue(int index) {
		return values[index];
	}

	double getXValue(int index) {
		return xValues[index];
	}

	public double[] getxValues() {
		return xValues;
	}

	public double[] getValues() {
		return values;
	}

	int getSize() {
		return values.length;
	}

	public String getName() {
		return this.name;
	}
}
