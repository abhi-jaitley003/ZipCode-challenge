package main;

import java.util.Objects;

/**
 * This class defines a range of 5 digit zipcodes. The end of a zipcode range is
 * always greater than or equal to the start
 * 
 * @author abhishekjaitley
 *
 */
public class ZipCodeRange {
	int start;
	int end;

	public ZipCodeRange(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public String toString() {
		return "[" + this.start + "," + this.end + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof ZipCodeRange)) {
			return false;
		}// two zipcode ranges are equal if the start and end are the same
		ZipCodeRange range = (ZipCodeRange) o;
		return start == range.start && end == range.end;
	}

	@Override
	public int hashCode() {
		return Objects.hash(start, end);
	}
}
