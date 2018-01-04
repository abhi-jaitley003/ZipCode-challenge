package main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author abhishekjaitley
 *
 */
public class MinZipCodeRanges {

	/**
	 * 
	 * @param ranges
	 *            list of zipcode ranges
	 * @return minimum number of ranges required to represent the same
	 *         restrictions as the input
	 */
	public List<ZipCodeRange> calculateMinRange(List<ZipCodeRange> ranges) {
		if (ranges.size() <= 1) {
			return ranges;
		}
		// sort by starting zipcode of zipcode ranges
		ranges.sort(new Comparator<ZipCodeRange>() {
			@Override
			public int compare(ZipCodeRange zipRange1, ZipCodeRange zipRange2) {
				Integer a = zipRange1.start;
				Integer b = zipRange2.start;
				return a.compareTo(b);
			}
		});
		int i = 1;
		while (i < ranges.size() ) {
			// checks for overlapping ranges and removes the ones that can
			// be covered by the current range
			if (ranges.get(i).start <= ranges.get(i - 1).end) {
				ranges.get(i-1).end = Math.max(ranges.get(i).end, ranges.get(i - 1).end);
				ranges.remove(i);
			} else {
				i++;
			}
		}
		return ranges;
	}

}