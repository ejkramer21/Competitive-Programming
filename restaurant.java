import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class restaurant {

    /*
    * Number N
    * N number of lines
    *
    * lines are DROP m or TAKE m m is number of plates
     */
    public static void Solution(){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        long n = -1;
        int i = 0;
        String input;
        String command;
        long m;
        long inTwo = 0; //number of plates current in pile 2
        long inOne = 0;

        while ((n = in.nextLong()) != 0) {
            in.nextLine();
            inOne=0;
            inTwo=0;
            for(i=0;i<n;i++){
                input = in.nextLine();
                command = input.substring(0,4);
                m = Integer.parseInt(input.substring(5,input.length()));

                if (command.equals("DROP")){
                    System.out.println("DROP 2 "+m);
                    inTwo+=m;
                } else { //command is take

//                    if (inOne < m) {
//                        if((inOne+inTwo)>m && inOne!=0){
//                            System.out.println("TAKE 1 "+inOne);
//                            m-=inOne;
//                            inOne=0;
//                        }
//                        System.out.println("MOVE 2->1 " + inTwo);
//                        inOne += inTwo;
//                        inTwo = 0;
//                    }
//                        System.out.println("TAKE 1 " + m);
//                        inOne-=m;
                    if (inOne >= m) {
                        System.out.println("TAKE 1 "+m);
                        inOne-=m;
                    } else {
                        if (inOne != 0) {
//                            if ((inOne+inTwo) > m) {
                                System.out.println("TAKE 1 "+inOne);
                                m-=inOne;
                                inOne=0;
                                System.out.println("MOVE 2->1 "+inTwo);
                                inOne=inTwo;
                                inTwo=0;
                                System.out.println("TAKE 1 "+m);
                                inOne-=m;
//                            } else {
//                                System.out.println("MOVE 2->1 "+inTwo);
//                                inOne+=inTwo;
//                                inTwo=0;
//                                System.out.println("TAKE 1 "+m);
//                                inOne-=m;
//                            }
                        } else {
                            System.out.println("MOVE 2->1 "+inTwo);
                            inOne+=inTwo;
                            inTwo=0;
                            System.out.println("TAKE 1 "+m);
                            inOne-=m;
                        }
                    }

                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args){
        Solution();
    }
}
