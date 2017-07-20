import java.util.HashSet;

/**
 * Created by obi on 2017-04-30.
 */
public class PairForGivenSumChecker {

    public static void main(String[] args) {
        int[] data1 = {1, 2, 3, 9};
        int[] data2 = {1, 2, 4, 4};
        int[] data3 = {4, 2, 3, 1, 4, 9};
        int[] data4 = {-2, 9, 3, 5, 0, 4};
        int sum1 = 8;
        int sum2 = 1;
        int sum3 = 5;
        int sum4 = 3;
        boolean result = PairForGivenSumChecker.hasPairForGivenSum4(data2, sum2);
        System.out.println("result = " + result);
    }

    /**
     * Method/Solution 1: Uses 2 nested for...loop, which is inefficient - O(n^2)
     * e.g. data: [1, 2, 3, 9], sum: 8
     * @param numbers
     * @param sum
     * @return
     */
    private static boolean hasPairForGivenSum1(int[] numbers, int sum) {
        for(int i=0; i<numbers.length; i++) {
            for(int j=0; j<numbers.length; j++) {
                if(i != j) {
                    if(numbers[i] + numbers[j] == sum) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Method 2: Uses 1 for...loop, with a binary search done for each item. This is also inefficient - O(nlogn)
     * e.g. data: [1, 2, 3, 9], sum: 8
     * @param numbers
     * @param sum
     * @return
     */
    private static boolean hasPairForGivenSum2(int[] numbers, int sum) {
        // TODO
        return false;
    }

    /**
     * Method 3: Uses bidirectional moves, starting with pointers at first and last, and moving inwards until pointers criss-cross
     * This method assumes that the numbers are pre-sorted. Otherwise, it will need sorting first -> efficiency, O(nlogn)
     * e.g. data: [1, 2, 3, 9], sum: 8
     * @param numbers
     * @param sum
     * @return
     */
    private static boolean hasPairForGivenSum3(int[] numbers, int sum) {
        int start = 0;
        int end = numbers.length - 1;

        while(start < end) {
            int s = numbers[start] + numbers[end];
            if(s == sum)
            {
                return true;
            } else {
                if(s < sum) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return false;
    }

    /**
     * Method 4: Uses 1 for...loop, and for each item, simply lookup if it exist in a hashSet of previous stored complements, if exist. This is of efficiency - O(n), better than O(nlogn)
     * This method works even if numbers are not pre-sorted
     * e.g. data: [4, 2, 3, 1, 4, 9], sum: 5
     * @param numbers
     * @param sum
     * @return
     */
    private static boolean hasPairForGivenSum4(int[] numbers, int sum) {
        HashSet<Integer> comps = new HashSet<Integer>();
        for(int number : numbers) {
            if(comps.contains(number)) {
                return true;
            } else {
                int comp = sum - number;
                comps.add(comp);
            }
        }
        return false;
    }
}
