import java.util.Stack;

class validParentheses {

    //2ms beat 87.76% -> use stacks if need to find matching pair in certain order
    /*public boolean isValid(String s) {
        if(s.length()%2 == 1){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char peek;

        for(char c : s.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
                continue;
            }

            if(stack.isEmpty()) return false;
            peek=stack.peek();

            if((peek=='(' && c==')') || (peek=='{' && c=='}' || (peek=='[' && c==']'))){
                stack.pop();
                continue;
            }
            return false;
        }
        return stack.isEmpty();

    }*/

    //1ms beat 98.94%
    //basically treats an array as a stack to avoid the added runtime
    public static boolean isValid(String s) {
        int first=0,second=0,third=0; //(,[,{
        int counter=0;
        if(s.length()%2==1) return false;

        char[] arr = new char[s.length()];

        for(char c : s.toCharArray()) {
            if(counter == 0 && (c==')' || c=='}' || c==']')) return false;

            if(c=='('){
                first++;
                arr[counter++]=c;
            } else if(c==')'){
                if(arr[counter-1]=='('){
                    first--;
                    counter--;
                }else{
                    return false;
                }
            }

            if(c=='['){
                second++;
                arr[counter++]=c;
            }else if(c==']'){
                if(arr[counter-1]=='['){
                    second--;
                    counter--;
                }else{
                    return false;
                }
            }

            if(c=='{'){
                third++;
                arr[counter++]=c;
            }else if(c=='}'){
                if(arr[counter-1]=='{'){
                    third--;
                    counter--;
                }else{
                    return false;
                }
            }
        }

        if(first==0 && second==0 && third==0) return true;
        return false;
    }

    public static void main(String[] args) {
        String s="()";
        System.out.println(isValid(s));
    }
}