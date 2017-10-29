public class Year extends CalendarUnit {
	public Year(int pYear) {
		setYear(pYear);
	}

	public void setYear(int pYear) {
		setCurrentPos(pYear);
		if (!this.isValid()) {
			throw new IllegalArgumentException("Not a valid month");
		}
	}

	public int getYear() {
		return currentPos;
	}

	public boolean increment() {
		currentPos = currentPos + 1;
		if (currentPos == 0)
			currentPos = 1;
		return true;
	}

	public boolean isLeap() {
		if (currentPos >= 0
				&& (((currentPos % 4 == 0) && (currentPos % 100 != 0)) || (currentPos % 400 == 0)))
			return true;
		else if (currentPos < 0
				&& ((((currentPos * -1) % 4 == 1) && ((currentPos * -1) % 100 != 1)) || ((currentPos * -1) % 400 == 1)))
			return true;
		return false;
	}

	protected boolean isValid() {
		if (this.currentPos != 0)
			return true;
		return false;
	}

	public boolean equals(Object o) {
		if (o instanceof Year) {
			if (this.currentPos == ((Year) o).currentPos)
				return true;
		}
		return false;
	}
}
