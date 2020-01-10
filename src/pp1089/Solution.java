package pp1089;

class Solution {
    public void duplicateZeros(int[] arr) {
        int i, index;
        for (i = 0, index = 0; index < arr.length; i++) {
            if (arr[i] == 0) {
                index++;
            }
            index++;
        }
        if (index > arr.length) {
            arr[arr.length - 1] = arr[--i];
            index = arr.length - 1;
        }
        for (; index > 0; ) {
            if (arr[i - 1] == 0) {
                arr[--index] = 0;
                arr[--index] = 0;
                i--;
            } else {
                arr[--index] = arr[--i];
            }
        }
    }
}
