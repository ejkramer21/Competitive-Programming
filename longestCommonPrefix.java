class longestCommonPrefix {
    public static String longestCommonPrefix(String[] strs){

        if (strs.length==0){
            return "";
        } else if(strs.length==1){
            return strs[0];
        }
        int shortest=0;
        int i;

        for (i=1;i<strs.length;i++){
            if (strs[i].length() < strs[shortest].length()){
                shortest=i;
            }
        }

        if (strs[shortest].length()==0){
            return "";
        }

        int letter=0;
        char[] prefix=new char[strs[shortest].length()];
        boolean broke=false;

        while(letter<strs[shortest].length()){

            char cur=strs[0].charAt(letter);

            for (i=1;i<strs.length;i++){
                if (strs[i].charAt(letter) != cur){
                    broke=true;
                    break;
                }
            }

            if (broke) {
                break;
            }

            prefix[letter]=cur;

            letter++;
        }

        if (prefix[0]=='\0'){
            return "";
        }

        char[] prefNew = new char[letter];

        for (i=0;i<letter;i++){
            prefNew[i]=prefix[i];
        }

        return String.valueOf(prefNew);
    }

    public static void main(String[] args) {
        String[] strs={"",""};
        String str = longestCommonPrefix(strs);
        System.out.println(str);
    }
}