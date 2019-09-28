package easy;

public class num_26 {

    public  static  int removeDuplicates(int[] nums) {
        if (nums.length == 0 ){
            return 0;
        }
        int x = 0;
        int k = nums[0] ;
        for (int i = 1; i <nums.length ; i++) {
            if (nums[i] == k){
                continue;
            }
            nums[++x] =nums[i];
            k = nums[i];
        }
        return x+1;
    }

    public  static  int removeDuplicates2(int[] nums) {
        if (nums.length == 0 ){
            return 0;
        }
        int i= 0;
        for (int j = 1; j < nums.length ; j++) {
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int n = removeDuplicates2(new int[] {0,0,1,1,1,2,2,3,3,4});
        System.out.println(n);
    }
}
