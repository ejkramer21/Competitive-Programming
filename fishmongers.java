import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class fishmongers {

    public static void main(String[] args) {
        Solution();
    }


    /*
    * Input:
    *
    * n=num fish to sell
    * m=num of fishmongers
    *
    * wi = weight of each fish in kgs (n ints)
    * xj = num fish monger wants to buy
    * pj = how many monies to pay/kg
     */
    public static void Solution(){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int i,j;
        long temp1,temp2;
        long sum=0;

        int numFish = in.nextInt();
        int numMongers = in.nextInt();

        long weights[] = new long[numFish]; //weights of fish to sell
        long toBuy[] = new long[numMongers]; //num fish monger wants to buy
        long monies[] = new long[numMongers]; //num monies they will give you per kg

        //read and sort the weights so constant call time
        for (i = 0;i<numFish;i++) {
            weights[i] = in.nextInt();
        }

        weights = sort(weights);

        //read and sort in terms of monies/kg and have other arrays follow that order
        for (i=0;i<numMongers;i++){
            toBuy[i] = in.nextInt();
            monies[i] = in.nextInt();
        }

        for (int gap=numMongers/2;gap>0;gap/=2){
            for(i=gap;i<numMongers;i++){
                temp1=monies[i];
                temp2=toBuy[i];

                for(j=i;j>=gap&&monies[j-gap]>temp1;j-=gap){
                    monies[j]=monies[j-gap];
                    toBuy[j]=toBuy[j-gap];
                }
                monies[j]=temp1;
                toBuy[j]=temp2;
            }
        }


        //sell biggest and most to one for max monies

        int fishSold=0; //number of fish sold
        int currMonger=numMongers-1; //location in array of number of fish highest paying monger wants
        int currFish =numFish-1; //location in array of weight of current fish

        while (fishSold<numFish && toBuy[0]!=0){ //until we have either sold all our fish or no one to sell to
            while (fishSold<numFish && toBuy[currMonger] != 0) {
                sum += (weights[currFish] * monies[currMonger]);
                currFish--;
                fishSold++;
                toBuy[currMonger]-=1;
            }
            currMonger--;
        }

        System.out.println(sum);
        //work way down
    }

    public static long[] sort(long[] arr){
        int n = arr.length;

                for (int gap=n/2;gap>0;gap/=2){
                    for(int i=gap;i<n;i++){
                        long temp=arr[i];

                        int j;
                        for(j=i;j>=gap&&arr[j-gap]>temp;j-=gap){
                            arr[j]=arr[j-gap];
                        }
                        arr[j]=temp;
                    }
                }
                return arr;
    }
}
