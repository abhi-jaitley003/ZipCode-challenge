package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Driver class to process the input and call the appropriate function
 * 
 * @author abhishekjaitley
 *
 */
public class Driver {

	/**
	 * Input one zipcode range per line with the start and end seperated by a
	 * single space.To terminate enter a single 0 in the last line. The input
	 * [94133,94133] [94200,94299] [94600,94699] will be entered by the user as:
	 * 
	 * 94133 94133 
	 * 94200 94299 
	 * 94600 94699 
	 * 0
	 *
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<ZipCodeRange> ranges = new ArrayList<>();
		System.out.println("Enter a zip code range in a new line separated by space " + "\nEnter zero to end input");
		String line = sc.nextLine();
		while (!line.equals("0")) {
			String[] data = line.split(" ");
			int currStart = Integer.parseInt(data[0]);
			int currEnd = Integer.parseInt(data[1]);
			ZipCodeRange currRange = new ZipCodeRange(currStart, currEnd);
			ranges.add(currRange);
			line = sc.nextLine();
		}
		MinZipCodeRanges test = new MinZipCodeRanges();
		System.out.println("The minimum ranges required are: " + test.calculateMinRange(ranges));
	}
}
