package xyz.dongguo.lesson;
public class Dongguo {

  public static void main(String[] args) {
    System.out.printf("%n%s%n", "Java Final Practical");

    // Question 1
    System.out.printf("%n%s%n", "1_ Occurrences of each number:");
    int[] arrayQuestion1 = {1, 2, 3, 2, 1, 6, 3, 4, 5, 2};
    printOccurrencesOfEachNumber(arrayQuestion1);

    // Question 2
    int[] arrayQuestion2 = {1, 2, 3, 2, 1, 6, 3, 4, 5, 2};
    System.out.printf("%n%s%d%n", "2_ Second largest element: ", findSecondLargest(arrayQuestion2));

    // Question 3
    int[] arrayQuestion3 = {1, 2, 3, 2, 1, 6, 3, 4, 5, 2};
    System.out.printf("%n%s%b%n", "3_ Array equal: ", equals(arrayQuestion3, arrayQuestion3));

    // Question 4
    double[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    int columnIndex = 2;
    System.out.printf("%n4_ The sum in column %d is: %.0f%n", columnIndex, sumColumn(matrix, columnIndex));

  }

  // Question 1
  public static void printOccurrencesOfEachNumber(int[] numbers) {
    sort(numbers);

    int preItem = numbers[0];
    int occurrences = 1;
    String outputFormatter = "%d : %d%n";
    // exclude the last item
    for (int i = 1; i < numbers.length - 1; i++) {
      if (numbers[i] == preItem) {
        occurrences++;
      } else {
        System.out.printf(outputFormatter, preItem, occurrences);
        preItem = numbers[i];
        occurrences = 1;
      }
    }

    // the last one
    int lastItem = numbers[numbers.length - 1];
    if(lastItem == preItem) {
      occurrences++;
      System.out.printf(outputFormatter, preItem, occurrences);
    }else{
      System.out.printf(outputFormatter, preItem, occurrences);
      System.out.printf(outputFormatter, lastItem, 1);
    }
  }

  private static void sort(int[] nums) {
    int size = nums.length;
    for (int i = 0; i < size - 1; i++) {
      for (int j = i + 1; j < size; j++) {
        if (nums[i] > nums[j]) {
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
        }
      }
    }
  }

  // Question 2
  public static int findSecondLargest(int[] numberArray) {
    int largest = findLargestExclude(numberArray, Integer.MIN_VALUE);
    return findLargestExclude(numberArray, largest);
  }

  private static int findLargestExclude(int[] nums, int excludeValue) {
    int largest = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > largest && nums[i] != excludeValue) {
        largest = nums[i];
      }
    }
    return largest;
  }

  // Question 3
  public static boolean equals(int[] list1, int[] list2) {
    int size = list1.length;
    if (size > list2.length) {
      return false;
    }

    for (int i = 0; i < size; i++) {
      if (list1[i] != list2[i]) {
        return false;
      }
    }
    return true;
  }

  // Question 4
  public static double sumColumn(double[][] matrix, int columnIndex) {
    double sumOfColumn = 0;
    for (double[] element : matrix) {
      sumOfColumn += element[columnIndex];
    }
    return sumOfColumn;
  }

}
