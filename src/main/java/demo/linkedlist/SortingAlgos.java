package demo.linkedlist;

import java.util.*;

public class SortingAlgos {

    public static void main(String[] args) {

        Random random = new Random();
        Set<Integer> uniqueNumbers = new HashSet<>();

        // Ensure we have exactly 20 unique numbers
        while (uniqueNumbers.size() < 20) {
            int num = random.nextInt(100); // Generate a random number between 0 and 99
            uniqueNumbers.add(num); // Add the number to the set
        }

        // Convert the set to an array
        ArrayList<Integer> randomArrayList = new ArrayList<>(uniqueNumbers);
        Collections.shuffle(randomArrayList); // Shuffle to ensure randomness

        int[] randomArray = new int[20];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = randomArrayList.get(i);
        }

        // Print the array
        System.out.print("Random array without repeats: ");
        for (int num : randomArray) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

//        bubbleSort(randomArray);
//        System.out.print("After sorting: ");
//        for (int num : randomArray) {
//            System.out.print(num + " ");
//        }
//        System.out.println("\n");


        quickSort(randomArray);
        System.out.print("After Quicksort sorting: ");
        for (int num : randomArray) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

    }

    public static int[] bubbleSort(int[] array) {
        int n = array.length;
        int temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

            }

        }
        return array;
    }

    public static void quickSort(int[] array) {
        quickSorting(array, 0, array.length - 1);
    }

    public static void quickSorting(int[] array, int lowindex, int highindex) {
        if (lowindex >= highindex) {
            return;
        }
        int pivot = array[highindex];
        int leftP = lowindex;
        int rightP = highindex;

        while (leftP < rightP) {

            while (array[leftP] <= pivot && leftP < rightP) {
                leftP++;
            }
            while (array[rightP] >= pivot && leftP < rightP) {
                rightP--;
            }

            swapNumbers(array, leftP, rightP);

        }
        swapNumbers(array, highindex, leftP);

        quickSorting(array, lowindex, leftP - 1);
        quickSorting(array, leftP + 1, highindex);
    }

    private static void swapNumbers(int[] array, int num1, int num2) {
        int temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;
    }


}
