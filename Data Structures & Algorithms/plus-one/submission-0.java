class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry=1;
        for(int i=len-1;i>=0;i--) {
            if(digits[i]+carry>9) {
                carry=1;
                digits[i] =0;
            } else {
                digits[i]+=1;
                return digits;
            }
        }
        if(carry==1) {
            int ans[] = new int[len+1];
            ans[0]=1;
            return ans;
        }
        return digits;
    }
}
