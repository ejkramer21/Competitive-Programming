import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class natjecanje {
    public static void main(String[] args) {
        Solution();
    }

    /*
    * NOTES
    *
    * Variables:
    * N = number of teams
    * S = number of teams with damaged kayaks
    * R = number of teams with reserved kayaks
    *
    * Input:
    * N S R
    * S numbers --> teams w damaged kayaks
    * R numbers --> teams w reserve kayaks
    *
    * Output:
    * 1 number --> min num of teams that can't start competition
     */
    public static void Solution(){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTeams, numDamaged, numReserves;
        int i;
        int team, noGo;

        numTeams = in.nextInt();
        numDamaged = in.nextInt();
        numReserves = in.nextInt();

        int  roster[] = new int[numTeams];

        for (i=0;i<numDamaged;i++) {
            team = in.nextInt() - 1;
            roster[team] = 1;
        }

        for (i=0;i<numReserves;i++){
            team = in.nextInt() - 1;
            if (roster[team] == 1){ //has a reserve and needs to use it
                roster[team]=0;
            } else { //has a reserve and doesn't need it
                roster[team] = 2;
            }
        }

        for (i=0;i<numTeams;i++){
            if (roster[i] == 2){
                if ((i-1)>=0 && roster[i-1]==1){
                    roster[i-1]=0;
                } else if ((i+1)<numTeams && roster[i+1]==1){
                    roster[i+1]=0;
                }
            }
        }

        noGo=0;
        for (i=0;i<numTeams;i++){
            if(roster[i]==1){
                noGo++;
            }
        }

        System.out.println(noGo);

    }
}
