

import java.io.InputStream;
import java.util.ArrayList;
import java.util.PriorityQueue;

// task number two

    class Point implements Comparable<Point>{

        // declare point information
        public String pointName;
        public int nr;
        double dist = Double.POSITIVE_INFINITY;
        int parent;

        public ArrayList<GraphRidge> graphRidges = new ArrayList<>();

        public Point(String var, int nr) {
            this.pointName = var;
            this.nr = nr;
        }
            // add to ArrayList
        public void addGraphRidge(GraphRidge graphRidge) {
            this.graphRidges.add(graphRidge);
        }
            // compare point to dist.point
        public int compareTo(Point point) {
            return Double.compare(dist, point.dist);
        }
    }

    class GraphRidge {

        public final double weight;
        public final int target;

        GraphRidge(int target, double weight) {
            this.target = target;
            this.weight = weight;
        }
    }
class Main {
    static  Point[] NAME;
    public static void main(String[] args) throws Exception {
        //declare variables, make instance of an object
        int cities = 0;
        FastReader in = FastReader.reader;
        int r, p;

        int numCases = in.nextInt();

        // input parameters

        while(numCases > 0){

            cities =  in.nextInt();

            NAME = new Point[cities+1];

            for(int i = 1; i <= cities; i++){

                String city = in.nextString();

                NAME[i] = new Point(city, i);

                p = in.nextInt();

                for(int j = 0; j < p; j++){

                    int a =  in.nextInt();
                    int b =  in.nextInt();
                    NAME[i].addGraphRidge(new GraphRidge(a, b));
                }
            }

            r =  in.nextInt(); // count ow waits

            for(int i = 0; i < r; i++) {

                String city1 = in.nextString();
                String city2 = in.nextString();

                    // find point of index

                Point a = find(city1, NAME);
                Point b = find(city2, NAME);

                // find optimal distantion
                Dijkstra(a, b);

                System.out.println((int)b.dist);

                for(int j=1; j<NAME.length; j++){
                    NAME[j].dist=Double.POSITIVE_INFINITY;
                    NAME[j].parent = -1;
                }
            }

            numCases--;
        }
    }


      public static Point find(String name, Point[] X){
            // find the point index
            for (int i = 1; i < X.length; i++){
                if(X[i].pointName.equals(name)){
                    return X[i];
                }
            }
            return null;
        }

        public static void Dijkstra(Point start, Point end){
            // in Dijstra algorithm start distantion for first point must be 0

            start.dist = 0;

            // make PriorityQueue type instance

            PriorityQueue<Point> queue = new PriorityQueue<>();

            queue.add(start);


            while(!queue.isEmpty()){

                //make point u, and remove this element from queue

                Point u =  queue.poll();

                for(GraphRidge point: u.graphRidges){

                    // make point n which == point.target

                    Point n = NAME[point.target];

                    // compare distantion and puting result to queue

                    if(n.dist > u.dist + point.weight){

                        queue.remove(n.dist);
                        n.dist = u.dist + point.weight;
                        n.parent = u.nr;
                        queue.add(n);
                    }
                }
            // break cycle
                if(u == end){
                    break;
                }
            }
        }
    }

    final class FastReader{

        public static final FastReader reader = new FastReader(System.in);
        private final InputStream in;
        private final byte[] buffer = new byte[16];
        private int pos, count;

        public FastReader(InputStream in) {
            this.in = in;
            pos = count = 0;
        }

        public int nextInt() {
            int c;
            while ((c = read()) < '0');
            int result = c - '0';
            while ((c = read() - '0') >= 0)
                result = 10*result + c;
            return result;
        }

        public String nextString(){
            StringBuilder s = new StringBuilder();
            int c;
            while ((c = read()) >= 'A')

                s.append((char)c);
            return s.toString();

        }
        private void fillBuffer() {
            try {
                count = in.read(buffer, pos = 0, buffer.length);
            } catch (Exception e){}
        }

        public int read() {
            if (pos == count)
                fillBuffer();
            return buffer[pos++];
        }
    }

