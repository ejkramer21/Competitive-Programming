import java.io.*;
import java.util.Scanner;

public class joinstrings {

    public static void main(String[] args) throws IOException{
        Solution();
    }

    public static void Solution() throws IOException {
        String word;
        int second,curr,numWords;
        int first = -1;
        Scanner in = new Scanner (new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter write = new BufferedWriter(new OutputStreamWriter(System.out));

        numWords = in.nextInt();
        in.nextLine();

        String words[] = new String[numWords];
        int pointers[] = new int[numWords];
        int headers[] = new int[numWords];

        for (int i = 0; i<numWords;i++) { //O(n)
            words[i] = in.nextLine();
            pointers[i] = -1;
            headers[i] = i;
        }

        for (int i =0; i < numWords-1;i++) { //n
            first = in.nextInt() - 1;
            second = in.nextInt() - 1;

            pointers[headers[first]] = second; //next
            headers[first] = headers[second]; //tail
            headers[second] = -1;

        }

        curr = first;
        if (numWords == 1) {
            curr = 0;
        }

        while (pointers[curr] != -1) {
            word = words[curr];
            write.write(word);
            curr = pointers[curr];
        }
        write.write(words[curr]);

        write.flush();

        write.close();
        in.close();
    }

}
