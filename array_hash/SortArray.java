package array_hash;

public class SortArray {

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;      // left half pointer
        int j = mid + 1;   // right half pointer
        int k = 0;         // temp array pointer

        // merge two sorted halves
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        // remaining elements in left half
        while (i <= mid) temp[k++] = arr[i++];

        // remaining elements in right half
        while (j <= right) temp[k++] = arr[j++];

        // copy back to original array
        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }
    }

    public static void main(String[] args) {
        SortArray sa = new SortArray();

        int[] nums1 = {5, 2, 3, 1};
        int[] nums2 = {5, 1, 1, 2, 0, 0};

        System.out.println(java.util.Arrays.toString(sa.sortArray(nums1)));
        System.out.println(java.util.Arrays.toString(sa.sortArray(nums2)));
    }
}
