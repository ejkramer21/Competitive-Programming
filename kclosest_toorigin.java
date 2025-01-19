class Closest_to_Origin {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];

        PriorityQueue<Dist> pq = new PriorityQueue<>(Collections.reverseOrder());



        //nlogk
        for(int[] pt : points) {
            if(pq.size()<k) {
                pq.add(new Dist(calc(pt),pt)); //logk
            } else {
                double dist=calc(pt);
                if(pq.peek().dist>dist){
                    pq.poll();
                    pq.add(new Dist(dist,pt));
                }
            }
        }

        int i=0;
        //k
        while(!pq.isEmpty()){
            ans[i++]=pq.poll().pt;
        }

        return ans;
    }

    public double calc(int[] pt){
        return Math.pow(Math.pow(pt[0],2)+Math.pow(pt[1],2),0.5);
    }
}
class Dist implements Comparable<Dist>{
    double dist;
    int[] pt;

    Dist(double dist, int[] pt) {
        this.dist=dist;
        this.pt=pt;
    }

    public int compareTo(Dist a) {
        if(a.dist<this.dist) return 1;
        else if(a.dist>this.dist) return -1;
        return 0;
    }
}