package sort;

import java.util.Arrays;

public class SortDemo {

    public static void main(String[] args) {
        int[] nums = new int[10];
        for (int i = 0;i<nums.length;i++){
            nums[i] = (int) (Math.random()*1000);
        }
        SortDemo sortDemo = new SortDemo();
        sortDemo.mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 选择排序
     * 每次把最小值找出来
     * @param nums
     */
    public void selectSort(int[] nums){
        for (int i = 0;i<nums.length;i++){
            int pos = i;
            for (int j = i+1;j<nums.length;j++){
                if (nums[pos]>nums[j]){
                    pos = j;
                }
            }
            if (pos != i){
                int temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;
            }
        }
    }

    /**
     * 插入排序
     * 类比：抓牌
     * @param nums
     */
    public void insertSort(int[] nums){
        int insertNode = 0;
        for (int i=1;i<nums.length;i++){
            insertNode = nums[i];
            int j = i-1;
            while (j>=0 && insertNode<nums[j]){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = insertNode;
        }
    }

    /**
     * 快速排序
     * 双指针
     * @param nums
     */
    public void quickSort(int[] nums){
        sort(nums,0,nums.length-1);
    }

    private void sort(int[] nums, int start, int end) {
        if (start>=end)return;
        int pivot = nums[start];
        int left = start;
        int right = end;
        while (left<=right){
            while (left<=right && nums[left] < pivot){
                left++;
            }
            while (right>=left && nums[right] > pivot){
                right--;
            }
            if (left<=right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        sort(nums,start,right);
        sort(nums,left,end);
    }

    
    public void mergeSort(int[] nums){
        int[] temps = new int[nums.length];
        mergerSortImpl(nums,0,nums.length-1,temps);
    }

    private void mergerSortImpl(int[] nums, int start, int end, int[] temps) {
        if (start>=end)return;
        int mid = (start+end)/2;
        mergerSortImpl(nums,start,mid,temps);
        mergerSortImpl(nums,mid+1,end,temps);
        merge(nums,start,mid,end,temps);
    }

    private void merge(int[] nums, int start, int mid, int end, int[] temps) {
        int left = start;
        int right = mid+1;
        int index = start;
        while (left<=mid && right<=end){
            if (nums[left] < nums[right]){
                temps[index++] = nums[left++];
            }else{
                temps[index++] = nums[right++];
            }
        }
        while (left<=mid){
            temps[index++] = nums[left++];
        }
        while (right<=end){
            temps[index++] = nums[right++];
        }
        for (index=start;index<=end;index++){
            nums[index] = temps[index];
        }
    }

}
