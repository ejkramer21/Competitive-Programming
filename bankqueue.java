import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class bankqueue {

    public static void main(String[] args) {
        Solution();
    }


    /*
    * 1 person/min
    * No new people
    *
    * N = number of people in queue
    * T = time until bank closes
    * ci = cash person has
    * ti = minutes until person leaves
    *
    * Input:
    * N T
    * ci ti
    * ...
    *
    * Output:
    * max amount of money to bank before close
     */
    public static void Solution(){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int i,temp1,temp2;
        int N = in.nextInt(); //num ppl in q
        int T = in.nextInt(); //time to close
        int sum = 0; //amount able to go into bank
        int pay[] = new int[N]; //amount that will enter bank from person i
        int wait[] = new int[N]; //how much time person i will wait from start

        for (i=0;i<N;i++){
            pay[i] = in.nextInt();
            wait[i] = in.nextInt();
        }


        //order based on pay --> bigger in lower index
        int j;
        for (int gap=N/2;gap>0;gap/=2){
            for(i=gap;i<N;i++){
                temp1=wait[i];
                temp2=pay[i];

                for(j=i;j>=gap&&pay[j-gap]<temp2;j-=gap){
                    wait[j]=wait[j-gap];
                    pay[j]=pay[j-gap];
                }
                wait[j]=temp1;
                pay[j]=temp2;
            }
        }

        int queue[] = new int[T];

        i = 0;
        while (i<N) {
            while (wait[i] >= 0 && queue[wait[i]] != 0) {
                wait[i]-=1;
            }
            if (wait[i] >=0) {
                queue[wait[i]]=pay[i];
            }
            i++;
        }

        for (i=0;i<T;i++) {
            sum+=queue[i];
        }

        System.out.println(sum);
    }
}
