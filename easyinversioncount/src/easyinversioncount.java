public class easyinversioncount {

    public static void main(String[] args) {
        int[] A = {3,2,1};     // Array A - Inversions to be counted from array
        int inversions = numInversions(A);
        System.out.println("Number of inversions: " + inversions);
    }
    //double nested for loop checks all possible pairs for each number going left to right in the array
    public static int numInversions(int[] A) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    System.out.println("("+A[i]+ "," + A[j] + ")");
                    count++;
                }
            }
        }
        return count;
    }
}