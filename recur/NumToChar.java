package recur;

public class NumToChar {
    public int numToChar(String str){
        if(str == null || str.length() == 0) {
            return 0;
        }
        return process(str.toCharArray(), 0);
    }

    public int process(char[] nums, int pos){
        int num = 0;
        boolean isEnd = (pos + 1) < nums.length;
        if(!isEnd){
            return 1;
        }else{
            char pos1 = nums[pos + 1];
            if(nums[pos] == '1' || nums[pos] == '2'){
                if(pos1 == '0'){
                    if((pos + 2) > nums.length){
                        return 1;
                    }else{
                        process(nums, pos + 2);
                    }
                }else{
                    if(nums[pos] == 1){
                        num += process(nums, pos + 1);
                        num += process(nums, pos + 2);
                    }else{
                        if(pos1 >= '0' && pos1 <= '6'){
                            num += process(nums, pos + 1);
                            num += process(nums, pos + 2);
                        }else{
                            num += process(nums, pos + 1);
                        }
                    }
                }
            }else {
                num += process(nums, pos + 1);
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String str = "123";
        NumToChar numToChar = new NumToChar();
        int result = numToChar.numToChar(str);
        System.out.println(result);
    }
}
