package merge.sort;

import java.util.Arrays;

public class MergeSortTest {
	
	public static void main(String[] args) {
		
		test1();
	}

	static void test1() {
		
		Integer[] input = {31, 29, 44, 58};
		System.out.println(Arrays.toString(input));
		
		MergeSort sorter = new MergeSort(input);
		sorter.mergeSort();
		
		System.out.println(Arrays.toString(input));
	}
}
