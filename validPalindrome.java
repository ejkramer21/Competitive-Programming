public class validPalindrome {

    //1ms beat 100%, O(n/2) using two pointer appraoch, ignore anything invalid or alter at same rotation
    public static boolean isPalindrome(String s) {
        int left = 0, right=s.length()-1;
        boolean pal=true;
        char leftChar, rightChar;
        while (left<right){

            leftChar=s.charAt(left);
            rightChar=s.charAt(right);

            if (!(48<=leftChar && leftChar<=57)) {
                if (!(97 <= leftChar && leftChar <= 122)) {
                    if (65 <= leftChar && leftChar <= 90) {
                        leftChar += 32;
                    } else {
                        left++;
                        continue;
                    }
                }
            }

            if (!(48<=rightChar && rightChar<=57)) {
                if (!(97 <= rightChar && rightChar <= 122)) {
                    if (65 <= rightChar && rightChar <= 90) {
                        rightChar += 32;
                    } else {
                        right--;
                        continue;
                    }
                }
            }

            if (leftChar != rightChar){
                pal=false;
                break;
            }
            left++;
            right--;
        }
        return pal;
    }

    public static void main(String[] args) {
        String s = "0P";

        boolean ret = isPalindrome(s);
        System.out.println(ret);
    }
}
