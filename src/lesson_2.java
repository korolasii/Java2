import java.util.ArrayList;
import java.util.Arrays;

public class lesson_2 {
    public static void main(){
        //1
        int[] array = {2,123,323,454111,1,2,3,0};
        int min = MinMeaning.min(array);
        System.out.println(min);
        //2
        int[] arrayForBouble = {2,123,323,454111,1,2,3,0};
        int[] sortArray = Sort.bouble(arrayForBouble);
        for (int i: sortArray){
            System.out.print(i + " ");
        }
        //3
        int num = 4;
        int factorial = Calculate.factorial(num);
        System.out.println(factorial);
        //4
        int[] array2 = {2,123,323,454111,1,2,3,4};
        int sum = Calculate.sumPairedNumbers(array2);
        System.out.println(sum);
        //5
        int number = 13;
        System.out.println(number + " " + CheckNumber.primeNumber(number));
        //6
        String str = "Доброго дня";
        int specificLatter = Calculate.specificLatter(str);
        System.out.println(specificLatter);
        //7
        int[] array3 = {2,123,323,454111,1,2,3,4};
        double mid = Calculate.midNumber(array3);
        System.out.println(mid);
        //9
        int[] array4 = {13, 26};
        int maxDivisor = Calculate.maxCommonDivisor(array4);
        System.out.println(maxDivisor);
        //10
        int numberFib = 144;
        int fib;
        for (int i = 0; i < numberFib; i++) {
            fib =Calculate.numbersFib(i);
            if(fib == numberFib){
                System.out.print(Calculate.numbersFib(i) + " ");
                break;
            }else{
                System.out.print(Calculate.numbersFib(i) + " ");
            }

        }
        System.out.println();
        //11
        int[] array5 = {1,4};
        int n = 5;
        ArrayList<Integer> arrayPassNubers = new ArrayList<>();
        arrayPassNubers = Calculate.passNumbers(array5, n);
        System.out.println(arrayPassNubers);
        //12
        String str2 = "121";
        boolean isPalindrome = WorkWithStr.palindrome(str2);
        System.out.println(isPalindrome);
        //15
        String str3 = "клоун";
        String str4 = "уклон";
        Boolean isAnagrams = WorkWithStr.anagrams(str3, str4);
        System.out.println(isAnagrams);
        //18
        int[] array6 = {1,2,5,4,5};
        int numberMaxDifferencNumbersNear = Calculate.maxDifferencNumbersNear(array6);
        System.out.println(numberMaxDifferencNumbersNear);
        //19
        int[] array7 = {0,2,5,6,5};
        int numberMaxDifferencNumbers = Calculate.maxDifferencNumbers(array7);
        System.out.println(numberMaxDifferencNumbers);
        //20
        int[] array8 = {3,6,8,1,7,9};
        int numberPeakBetweenTwoDigits = Calculate.peakBetweenTwoDigits(array8);
        System.out.println(numberPeakBetweenTwoDigits);
        //21
        int[] array9 = {1,2,4,5,6,7,8,0};
        int[] array10 = {1,2,3,9};
        ArrayList<Integer> ourArray = Calculate.sameNumbers(array9, array10);
        System.out.println(ourArray);
    }
}

class MinMeaning {
    public static int min(int[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("Array null");
        }
        int min = array[0];
        for (int i = 1; i<array.length; i++){
            if (min>array[i]){
                min = array[i];
            }
        }
        return min;
    }
}


class Sort{
    public static int[] bouble (int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }

}

class Calculate{
    public static int factorial(int number) {
        int factorial = 1;
        for (int i = 1; i>=number; i++){
            factorial = factorial * i;
        }
        return factorial;
    }

    public static int sumPairedNumbers(int[] array){
        int sum = 0;
        for (int i = 0; i< array.length; i++ ){
            if (array[i]%2 == 0){
                sum = sum + array[i];
            }
        }
        return sum;
    }

    public static int specificLatter(String str){
        String symbol = "";
        int letter = 0;
        for(int i = 0; i<str.length(); i++){
            symbol = String.valueOf(str.charAt(i));
            if (symbol.equalsIgnoreCase("і") ||symbol.equalsIgnoreCase("у") ||symbol.equalsIgnoreCase("о") ||symbol.equalsIgnoreCase("е") ||symbol.equalsIgnoreCase("а")){
                letter++;
            }
        }
        return letter;
    }

    public static double midNumber(int[] array){
        double mid = 0.0;
        int sum = sumNumers(array);
        mid = sum/array.length;
        return mid;
    }

    public static int sumNumers(int[] array){
        int sum = 0;
        for (int i : array){
            sum = sum + i;
        }
        return sum;
    }

    public static int maxCommonDivisor(int[] array){
        int divisiorMax = 0;
        int minNumber;
        if (array[0]>array[1]){
            minNumber = array[1];
        }else{
            minNumber = array[0];
        }
        for (int i = minNumber; i>0; i--){
            if (array[0]%i == 0 && array[1]%i == 0){
                divisiorMax = i;
                break;
            }
        }
        return divisiorMax;
    }

    public static ArrayList<Integer> passNumbers(int[] array, int n){
        ArrayList<Integer> arrayPassNumbers = new ArrayList<>();
        ArrayList<Integer> allNubers = new ArrayList<>();
        for (int i = 1; i<=n; i++){
            allNubers.add(i);
        }
        for (int i: allNubers){
            if(Arrays.binarySearch(array, i)<0){
                arrayPassNumbers.add(i);
            }
        }
        return arrayPassNumbers;
    }
    public static int numbersFib(int numberEnd){
        if (numberEnd <= 1) {
            return numberEnd;
        } else {
            return numbersFib(numberEnd - 1) + numbersFib(numberEnd - 2);
        }
    }

    public static int maxDifferencNumbersNear(int[] array) {
        int numberMaxDifferencNumbers = 0;
        for(int i = 0; i< array.length-1; i++){
            if (array[i+1]-array[i]>numberMaxDifferencNumbers){
                numberMaxDifferencNumbers = array[i+1] - array[i];
            }
        }
        return numberMaxDifferencNumbers;
    }

    public static int maxDifferencNumbers(int[] array) {
        int numberMaxDifferencNumbers = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                if(Math.abs(array[i]-array[j])>numberMaxDifferencNumbers){
                    numberMaxDifferencNumbers = Math.abs(array[i]-array[j]);
                }
            }
        }
        return numberMaxDifferencNumbers;
    }

    public static int peakBetweenTwoDigits(int[] array) {
        int numberPeakBetweenTwoDigits = 0;
        for (int i = 1; i<array.length-1; i++){
            if (array[i]>array[i-1] && array[i]>array[i+1]){
                numberPeakBetweenTwoDigits = array[i];
                break;
            }
        }
        return numberPeakBetweenTwoDigits;
    }

    public static ArrayList<Integer> sameNumbers(int[] array1, int[] array2) {
        ArrayList<Integer> ourArray = new ArrayList<>();
        if (array1.length > array2.length){
            for (int i: array2){
                for (int j: array1){
                    if (i==j){
                        ourArray.add(i);
                        break;
                    }
                }
            }
        }else {
            for (int i: array1){
                for (int j: array2){
                    if (i==j){
                        ourArray.add(i);
                        break;
                    }
                }
            }
        }
        return ourArray;
    }
}

class CheckNumber{
    public static String primeNumber(int number) {
        if (number%2!=0 && number%3!=0 && number%4!=0 && number%5!=0 ){
            return "is prime";
        }
        return "is not prime";
    }
}

class WorkWithStr{
    public static boolean palindrome(String str){
        String newStr = reversStr(str);
        if (newStr.equalsIgnoreCase(str)){
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

    public static Boolean anagrams(String str3, String str4) {
        int charsEquls = 0;

        if (str3.length() == 0 || str4.length() == 0){
            return false;
        }
        if(str3.length()!=str4.length()){
            return false;
        }

        if (!str3.equalsIgnoreCase(str4)){
            for(int i = 0; i<str3.length(); i++){
                if (str4.indexOf(str3.charAt(i))>=0){
                    charsEquls++;
                }else{
                    return false;
                }
            }
        }
        if (charsEquls == str3.length()){
            return true;
        }
        return false;
    }
}