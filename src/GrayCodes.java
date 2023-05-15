
public class GrayCodes {
    public static void main(String[] args) {

        String[] names = new String[5];
        names[0] = "Axel";
        names[1] = "Boxo";
        names[2] = "Crunchy";
        names[3] = "Doofus";
        names[4] = "Enzo";
        String[] graycodes = BRGC(5);
        System.out.println("Index | Gray Code | Name   | Action");
        for (int i = 0; i < graycodes.length; i++) {
            System.out.print(i + "     | " + graycodes[i] + " | ");

            names = new String[]{"Enzo", "Doofus", "Crunchy", "Boxo", "Axel"};
            for (int j = 0; j < 5; j++) {
                if (graycodes[i].charAt(j) == '1') {
                    System.out.print(" | " + names[j]);
                    if (graycodes[i - 1] != null && graycodes[i - 1].charAt(j) == '1' && graycodes[i].charAt(j) == '0') {
                        System.out.print(" leaves");
                    }
                    if (graycodes[i - 1] != null && graycodes[i - 1].charAt(j) == '0' && graycodes[i].charAt(j) == '1') {
                        System.out.print(" joins");
                    }
                }
            }
            System.out.println();
        }

        System.out.println("                         | Enzo Crashes");
    }
    private static int mergeSort(int[] input, int[] tempArray, int low, int high) {
        int invCount = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            invCount += mergeSort(input, tempArray, low, mid);
            invCount += mergeSort(input, tempArray, mid + 1, high);
            invCount += merge(input, tempArray, low, mid, high);
        }
        return invCount;
    }

    private static int merge(int[] input, int[] tempArray, int low, int mid, int high) {
        int i = low, j = mid + 1, k = low;
        int invCount = 0;
        while (i <= mid && j <= high) {
            if (input[i] <= input[j]) {
                tempArray[k++] = input[i++];
            } else {
                tempArray[k++] = input[j++];
                invCount += (mid - i + 1);
            }
        }
        while (i <= mid) {
            tempArray[k++] = input[i++];
        }
        while (j <= high) {
            tempArray[k++] = input[j++];
        }
        System.arraycopy(tempArray, low, input, low, high - low + 1);
        return invCount;
    }
    //return string array of gray codes with n bits
    public static String[] BRGC(int n) {
        String[] graycodes = new String[(int) Math.pow(2, n)];
        if (n == 1) {
            graycodes[0] = "0";
            graycodes[1] = "1";
            return graycodes;
        } else {
            String[] graycodes2 = BRGC(n - 1);
            for (int i = 0; i < graycodes2.length; i++) {
                graycodes[i] = "0" + graycodes2[i];
            }
            for (int i = graycodes2.length; i < graycodes.length; i++) {
                graycodes[i] = "1" + graycodes2[graycodes.length - i - 1];
            }
            return graycodes;
        }
    }
}



