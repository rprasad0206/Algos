//mergesort O(nlogn)
public class fastinversioncount {
    public static int countInversions(int[] A) {
        return mergeSort(A, 0, A.length - 1);
    }
    public static void main(String[] args) {
        int[] A = {3,2,1};
        int inversions = countInversions(A);
        System.out.println("Number of inversions: " + inversions);
    }

    public static int mergeSort(int[] A, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = (left + right) / 2; // middle avg index
            count += mergeSort(A, left, mid); // count inversions in left half
            count += mergeSort(A, mid + 1, right); // count inversions in right half
            count += merge(A, left, mid, right); // count all split inversions
        }
        return count;
    }

    public static int merge(int[] A, int left, int mid, int right) {
        int count = 0;
        int[] tempList = new int[right - left + 1]; //temporary sorted array
        //pointers for sub and temporary arrays
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (A[i] <= A[j]) {
                tempList[k++] = A[i++];   //copy from left to temporary array
            } else {
                tempList[k++] = A[j++]; //copy from right to temporary array
                count += mid - i + 1; // count inversions in split pair
            }
        }
        //copy remaining elements from left sub array to temporary array
        while (i <= mid) {
            tempList[k++] = A[i++];
        }
        //copy remaining elements from right sub array to temporary array
        while (j <= right) {
            tempList[k++] = A[j++];
        }
        //copies sorted elements from the temporary array back to original array
        for (int m = 0; m < tempList.length; m++) {
            A[left + m] = tempList[m];
        }

        return count;
    }

}
