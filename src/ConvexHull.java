import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class ConvexHull {
    class Point implements Comparable<Point>{
        int x;
        int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point p){
            if(this.y!=p.y) return this.y-p.y;
            return p.x-this.x;
        }

        public void solve(Point[] p){
            Arrays.sort(p);
            Arrays.sort(p, (o1, o2) -> ccw(p[0],o1,o2));
            Stack<Point> stack = new Stack<>();
            stack.push(p[0]);
            stack.push(p[1]);
            for(int i=2;i<p.length;i++){
                Point t = stack.pop();
                while(ccw(stack.peek(),t,p[i])<=0){
                    t = stack.pop();
                }
                stack.push(t);
                stack.push(p[i]);
            }
        }

        public int ccw(Point a,Point b,Point c){
            double area = (b.x-a.x)*(c.y-a.y)-(b.y-a.y)*(c.y-a.y);
            if(area>0) return 1;
            else if(area==0) return 0;
            else return -1;
        }
    }
}
