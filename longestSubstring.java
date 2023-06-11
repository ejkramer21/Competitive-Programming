import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;


public class longestSubstring {

    //first attempt (beat 22.5%)
/*
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] alpha = new int[127];
        int i=0;
        char c;
//        int offset=97; //ascii offset
        PriorityQueue<Integer> maxLen=new PriorityQueue<>(Collections.reverseOrder());
        int curLen=0;

        while (i<s.length()){
            c=s.charAt(i);

            if (alpha[c] == 0) {
                alpha[c]=i+1; //index where repeat occurs plus 1 bc 0 indexed
                curLen++;
                i++;
            } else {
                maxLen.add(curLen);
                i=alpha[c]; //start again after where first was
                alpha=new int[127]; //clear for next substring
                curLen=0;
            }
        }

        maxLen.add(curLen);

        return maxLen.remove();
    }

 */

    //2nd attempt --> sliding window and HashSet (beat 26.26%)
/*    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0){
            return 0;
        }
        int right=0,left=0;
        HashSet<Character> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int curLen=0;

        while (right<s.length()){
            if (!set.contains(s.charAt(right))){
                set.add(s.charAt(right++));
                curLen++;
            } else {
                pq.add(curLen);
                while (s.charAt(left) != s.charAt(right)){
                    set.remove(s.charAt(left++));
                    curLen--;
                }
                set.remove(s.charAt(left++));
                curLen--;
            }
        }

        pq.add(curLen);

        return pq.remove();
    }

 */

    //3rd attempt --> get ride of priority queue and track max with int
    //(beat 51.11%)
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0){
            return 0;
        }
        int right=0,left=0;
        HashSet<Character> set = new HashSet<>();
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int curLen=0, maxLen=0;

        while (right<s.length()){
            if (!set.contains(s.charAt(right))){
                set.add(s.charAt(right++));
                curLen++;
            } else {
//                pq.add(curLen);
                maxLen=Math.max(curLen,maxLen);
                while (s.charAt(left) != s.charAt(right)){
                    set.remove(s.charAt(left++));
                    curLen--;
                }
                set.remove(s.charAt(left++));
                curLen--;
            }
        }

//        pq.add(curLen);
        maxLen=Math.max(curLen,maxLen);

        return maxLen;

//        return pq.remove();
    }

    public static void main(String[] args) {

        String s = "pwwkew";
        int len = lengthOfLongestSubstring(s);
        System.out.println(len);

    }

}
