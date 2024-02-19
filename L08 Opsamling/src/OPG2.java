import java.util.Arrays;

public class OPG2 {
    public static void main(String[] args) {
        int[] permutationArray = new int[10];
        int[] secondArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int removedNum = 0;
        int remainingNumbers = 10;

        for (int i = 0; i < secondArray.length; i++) {
            int randomPosition = (int) ((remainingNumbers) * Math.random());
            removedNum = secondArray[randomPosition];
            permutationArray[i] = removedNum;

            for (int x = randomPosition; x < secondArray.length - 1; x++) {
                secondArray[x] = secondArray[x + 1];
            }
            
            secondArray[secondArray.length - 1] = 0;
            remainingNumbers--;
        }

        System.out.print("Permutation Array: ");
        System.out.println(Arrays.toString(permutationArray));
    }
}
