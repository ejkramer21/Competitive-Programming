class MintoRemValidParens {
    public String minRemoveToMakeValid(String s) {
        
        /*

        */

        Deque<Integer> stack=new ArrayDeque<>();
        Set<Integer> toRem=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);

            if(c=='(') stack.add(i);
            else if(c==')'){
                if (stack.isEmpty()){
                    toRem.add(i);
                }else {
                    stack.pop();
                }
            }

        }

        while(!stack.isEmpty()){
            toRem.add(stack.pop());
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(toRem.contains(i)) continue;
            sb.append(s.charAt(i));
        }

        return sb.toString();

        
    }
}