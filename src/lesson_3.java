import java.util.HashMap;

public class lesson_3 {
    public static void main(){
        //1
        int[] array = {2,7,11,15};
        int target = 9;
        int[] outTarget = Solution.twoSum(array, target);
        for(int i: outTarget){
            System.out.print(i + " ");
        }
        System.out.println();
        //2
        int number = -121;
        boolean numberIsPolindrom =Solution.isPalindrome(number);
        System.out.println(numberIsPolindrom);
        //3
        String str = "X";
        int result = Solution.romanToInt(str);
        System.out.println(result);
    }
}

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
    public static boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        String str2 = reversStr(str);
        if (str.equalsIgnoreCase(str2)){
            return true;
        }
        return false;
    }
    public static String reversStr(String str){
        String newStr = "";
        for (int i = str.length()-1; i>=0; i--){
            newStr = newStr+str.charAt(i);
        }
        return newStr;
    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> romanValues = new HashMap<>();
        int backValue = 0;
        int result = 0;
        int currentValue;
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
        for(int i = s.length()-1; i>=0; i--){
            currentValue = romanValues.get(s.charAt(i));
            if (backValue>currentValue){
                result -= currentValue;
            }else{
                result += currentValue;
            }
            backValue = currentValue;
        }
        return result;
    }

}
