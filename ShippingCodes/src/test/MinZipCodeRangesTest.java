package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import main.MinZipCodeRanges;
import main.ZipCodeRange;

public class MinZipCodeRangesTest {
	MinZipCodeRanges minZipCode;

	/**
	 * For all non overlapping ranges the output should be the same as the input
	 */
	@Test
	public void nonOverLappingTest() {
		minZipCode = new MinZipCodeRanges();
		List<ZipCodeRange> input = new ArrayList<>();
		input.add(new ZipCodeRange(94133, 94133));
		input.add(new ZipCodeRange(94200, 94299));
		input.add(new ZipCodeRange(94301, 94399));
		List<ZipCodeRange> answer = minZipCode.calculateMinRange(input);
		List<ZipCodeRange> expected = Arrays.asList(new ZipCodeRange(94133, 94133), new ZipCodeRange(94200, 94299),
				new ZipCodeRange(94301, 94399));
		assertArrayEquals(answer.toArray(), expected.toArray());

	}

	/**
	 * For one or more overlapping ranges we should see a different output with
	 * lesser size in the output
	 */
	@Test
	public void overLappingTest() {
		minZipCode = new MinZipCodeRanges();
		List<ZipCodeRange> input = new ArrayList<>();
		input.add(new ZipCodeRange(94133, 94133));
		input.add(new ZipCodeRange(94200, 94299));
		input.add(new ZipCodeRange(94298, 94399));
		List<ZipCodeRange> answer = minZipCode.calculateMinRange(input);
		List<ZipCodeRange> expected = Arrays.asList(new ZipCodeRange(94133, 94133), new ZipCodeRange(94200, 94399));
		assertArrayEquals(answer.toArray(), expected.toArray());

	}

	/**
	 * An empty range list return an empty list
	 */
	@Test
	public void emptyRangeListTest() {
		minZipCode = new MinZipCodeRanges();
		List<ZipCodeRange> input = new ArrayList<>();
		List<ZipCodeRange> answer = minZipCode.calculateMinRange(input);
		List<ZipCodeRange> expected = new ArrayList<>();
		assertArrayEquals(answer.toArray(), expected.toArray());

	}

	/**
	 * A list containing a single zipcode range cannot be reduced so we must get
	 * the same list in the output
	 */
	@Test
	public void singleRangeTest() {
		minZipCode = new MinZipCodeRanges();
		List<ZipCodeRange> input = new ArrayList<>();
		input.add(new ZipCodeRange(94133, 94227));
		List<ZipCodeRange> answer = minZipCode.calculateMinRange(input);
		List<ZipCodeRange> expected = Arrays.asList(new ZipCodeRange(94133, 94227));
		assertArrayEquals(answer.toArray(), expected.toArray());

	}

	/**
	 * In a list with a duplicate range(same start and end point) we should get
	 * only one occurence of that range in the output
	 */
	@Test
	public void duplicateRangeTest() {
		minZipCode = new MinZipCodeRanges();
		List<ZipCodeRange> input = new ArrayList<>();
		input.add(new ZipCodeRange(94133, 94227));
		input.add(new ZipCodeRange(94133, 94227));
		List<ZipCodeRange> answer = minZipCode.calculateMinRange(input);
		List<ZipCodeRange> expected = Arrays.asList(new ZipCodeRange(94133, 94227));
		assertArrayEquals(answer.toArray(), expected.toArray());

	}

	/**
	 * Two ranges of the form (a,b) (b,c) where a < b < c should be merged to
	 * form (a,c)
	 */
	@Test
	public void adjacentRangeTest() {
		minZipCode = new MinZipCodeRanges();
		List<ZipCodeRange> input = new ArrayList<>();
		input.add(new ZipCodeRange(94133, 94227));
		input.add(new ZipCodeRange(94227, 94228));
		List<ZipCodeRange> answer = minZipCode.calculateMinRange(input);
		List<ZipCodeRange> expected = Arrays.asList(new ZipCodeRange(94133, 94228));
		assertArrayEquals(answer.toArray(), expected.toArray());

	}

	/**
	 * One large range covering all the other ranges should return that single
	 * range of zipcodes
	 */
	@Test
	public void singleOverlappingRangeTest() {
		minZipCode = new MinZipCodeRanges();
		List<ZipCodeRange> input = new ArrayList<>();
		input.add(new ZipCodeRange(94227, 94228));
		input.add(new ZipCodeRange(94330, 94554));
		input.add(new ZipCodeRange(94402, 94528));
		input.add(new ZipCodeRange(94133, 94999));
		List<ZipCodeRange> answer = minZipCode.calculateMinRange(input);
		List<ZipCodeRange> expected = Arrays.asList(new ZipCodeRange(94133, 94999));
		assertArrayEquals(answer.toArray(), expected.toArray());

	}

}
