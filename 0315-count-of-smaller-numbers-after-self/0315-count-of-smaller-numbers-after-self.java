class Solution {

    class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    int[] count;
    Pair[] temp;

    public List<Integer> countSmaller(int[] nums) {

        int n = nums.length;

        count = new int[n];
        temp = new Pair[n];

        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        mergeSort(arr, 0, n - 1);

        List<Integer> ans = new ArrayList<>();

        for (int x : count)
            ans.add(x);

        return ans;
    }

    private void mergeSort(Pair[] arr, int left, int right) {

        if (left >= right)
            return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private void merge(Pair[] arr, int left, int mid, int right) {

        int i = left;
        int j = mid + 1;
        int k = left;

        int rightCount = 0;

        while (i <= mid && j <= right) {

            if (arr[j].value < arr[i].value) {
                temp[k++] = arr[j++];
                rightCount++;
            } else {
                count[arr[i].index] += rightCount;
                temp[k++] = arr[i++];
            }
        }

        while (i <= mid) {
            count[arr[i].index] += rightCount;
            temp[k++] = arr[i++];
        }

        while (j <= right)
            temp[k++] = arr[j++];

        for (int p = left; p <= right; p++)
            arr[p] = temp[p];
    }
}