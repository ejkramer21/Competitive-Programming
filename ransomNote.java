//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Stack;

public class ransomNote {

    //attempt 1 -> use arraylist for stack but has O(n^2) because of the remove is O(n) inside an O(n) loop
    /*
    public static boolean canConstruct(String ransomNote, String magazine) {
        ArrayList<Character> magList = new ArrayList<>();
        for(int i=0;i<magazine.length();i++){
            magList.add(magazine.charAt(i));
        }

        for(int i=0;i<ransomNote.length();i++){
            if(magList.contains(ransomNote.charAt(i))){
                int index = magList.indexOf(ransomNote.charAt(i));
                magList.remove(index);
//                magList.remove((char)ransomNote.charAt(i));
                continue;
            }
            return false;
        }
        return true;
    }

     */

    //attempt 2 -> 27 ms ....lol -> tried to use stacks instead but it was super inefficient and didn't make much sense
    /*
    public static boolean canConstruct(String ransomNote, String magazine) {
        Stack<Character> magList = new Stack<>();
        Stack<Character> tempList = new Stack<>();
        for(int i=0;i<magazine.length();i++){
            magList.push(magazine.charAt(i));
        }

        for(int i=0;i<ransomNote.length();i++) {
            if(magList.search(ransomNote.charAt(i))>0){
                while(magList.peek() != ransomNote.charAt(i)){
                    tempList.add(magList.pop());
                }
                magList.pop();
                while(!tempList.isEmpty()){
                    magList.push(tempList.pop());
                }
                tempList.clear();
            } else{
                return false;
            }
        }
        return true;
    }

     */

    //18ms -> used hashmap, not really sure why the runtime is still so high tho.  gonna try w arrays next
    /*
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magList = new HashMap<>();

        for(int i=0;i<magazine.length();i++){
            char mag = magazine.charAt(i);

            if(!magList.containsKey(mag)){
                magList.put(mag, 1);
            } else {
                int num = magList.get(mag);
                magList.put(mag,num+1);
            }

        }

        for(int i=0;i<ransomNote.length();i++){
            char rans=ransomNote.charAt(i);
            if(magList.containsKey(rans)){
                int num = magList.get(rans);
                if(num==1){
                    magList.remove(rans);
                } else {
                    magList.put(rans,num-1);
                }
            }else{
                return false;
            }
        }
        return true;
    }

     */

    //2ms just used a frequency array
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magList = new int[27];
        for(char ch : magazine.toCharArray()){
            magList[ch-'a']+=1;
        }

        for(char ch : ransomNote.toCharArray()){
            if(magList[ch-'a']==0){
                return false;
            } else{
                magList[ch-'a']-=1;
            }
        }
        return true;
    }
}
