package uk.me.berndporr.iirj;

public class CompareResult
{
	private final String       name;
	private final DoubleSignal scipyResult;
	private final DoubleSignal iirjResult;

	public CompareResult(String name, DoubleSignal scipyResult, DoubleSignal iirjResult) {
		this.name = name;
		this.scipyResult = scipyResult;
		this.iirjResult = iirjResult;
	}

	public String getName() {
		return name;
	}

	public DoubleSignal getScipyResult() {
		return scipyResult;
	}

	public DoubleSignal getIirjResult() {
		return iirjResult;
	}

	public boolean isEqual() {
		int size = scipyResult.getSize();
		if (iirjResult.getSize() != size) {
			return false;
		}

		for (int index = 0; index < size; index++) {
			double scipyResultValue = scipyResult.getValue(index);
			double iirjResultValue = iirjResult.getValue(index);
			if (Double.compare(scipyResultValue, iirjResultValue) != 0) {
				return false;
			}
		}
		return true;
	}
}
