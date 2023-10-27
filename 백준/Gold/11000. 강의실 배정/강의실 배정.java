import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (n1, n2)-> {
            if(n1[0]==n2[0]) return n1[1] - n2[1];
            return n1[0] - n2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int res=1;

        for(int i=0; i<n; i++){
            pq.add(arr[i][1]);
            while(!pq.isEmpty() && pq.peek()<=arr[i][0]) pq.poll();
            if(res < pq.size()) res = pq.size();
        }

        System.out.print(res);
    }
}
