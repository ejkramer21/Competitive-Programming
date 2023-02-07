import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;


class Worker implements  Comparable<Worker>{
    long initial;
    long increase;
    long next;

    public Worker(long initial, long increase, long next){
        this.increase=increase;
        this.initial=initial;
        this.next = next;
    }

    public int compareTo(Worker worker2) {
        if (next == worker2.next) {
            return 0;
        } else if (next > worker2.next){
            return 1;
        } else {
            return -1;
        }
    }
}

public class annoyedcoworkers {

    public static void main(String[] args) {
        Solution();
    }

    /*
     * linearly increasing annoyance
     *
     * Input:
     * h c --> num times to ask for help | num of workers
     * c lines of a d --> initial annoyance | increase in annoyance
     *
     * Output:
     * annoyance of most annoyed coworker at end of optimal strategy
     *
     * Nt. goal is to decrease annoyance of most annoyed coworker
     */
    public static void Solution(){

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int i=0,j;
        long temp1,temp2,temp3;
        int numHelps = in.nextInt();
        int numWorkers = in.nextInt();
        long initial[] = new long[numWorkers];
        long increase[] = new long[numWorkers];
        Worker workers[] = new Worker[numWorkers];


        for(;i<numWorkers;i++){
            initial[i] = in.nextInt();
            increase[i] = in.nextInt();
            workers[i] = new Worker(initial[i],increase[i],initial[i]+increase[i]);
        }

        PriorityQueue<Worker> minHeap = new PriorityQueue<>();

        for (i=0;i<numWorkers;i++) {
            minHeap.add(workers[i]);
        }

        Worker removed = null;

        int helpReceived=0;
        while (helpReceived<numHelps) {
            removed = minHeap.remove();
            removed.initial= removed.next;;
            removed.next=removed.initial+ removed.increase;
            minHeap.add(removed);
            helpReceived++;
        }

        int size = minHeap.size();
        long max = minHeap.remove().initial;

        for (i=0;i<size-1;i++) {
            removed = minHeap.remove();
            if (removed.initial>max){
                max=removed.initial;
            }
        }

        System.out.println(max);

    }
}