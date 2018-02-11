import java.util.Arrays;
import java.util.Comparator;

public class ClosestPoints {

    private class Point{
        int x;
        int y;
    }
    class xComparator implements Comparator<Point>{

        @Override
        public int compare(Point p1, Point p2) {
            return p1.x-p2.x;
        }
    }

    class yComparator implements Comparator<Point>{
        @Override
        public int compare(Point p1,Point p2){
            return p1.y-p2.y;
        }
    }
    public double dist(Point p1,Point p2){
        return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
    }

    public double closest(Point points[]){
        Point pointsX[] = new Point[points.length];
        Point pointsY[] = new Point[points.length];
        for(int i=0;i<points.length;i++){
            pointsX[i] = points[i];
            pointsY[i] = points[i];
        }
        Arrays.sort(pointsX,new xComparator());
        Arrays.sort(pointsY,new yComparator());
        return closeUtil(pointsX,pointsY,points.length,0);
    }

    private double closeUtil(Point px[],Point py[],int n,int start){
        if(n<=3)
            return bruteForce(px,n,start);
        int mid = n/2;
        Point midPoint = px[start+mid];
        Point Pyl[] = new Point[mid+1];
        Point Pyr[] = new Point[n-mid-1];
        int li = 0,ri = 0;
        for(int i=0;i<n;i++){
            if(py[i].x<=mid)
                Pyl[li++] = py[i];
            else Pyr[ri++] = py[i];
        }
        double dl = closeUtil(px,Pyl,mid+1,start);
        double dr = closeUtil(px,Pyr,n-mid-1,start+mid+1);
        double d = Math.min(dl,dr);
        Point strip[] = new Point[n];
        int j=0;
        for(int i=0;i<n;i++){
            if(Math.abs(py[i].x-midPoint.x)<d)
                strip[j++] = py[i];
        }
        return Math.min(d,stripCloset(strip,j,d));
    }

    private double bruteForce(Point[] points,int n,int start){
        double distMin = Double.MAX_VALUE;
        for(int i=start;i<start+n-1;i++){
            for(int j=i+1;j<start+n;j++){
                distMin = Math.min(distMin,dist(points[i],points[j]));
            }
        }
        return distMin;
    }

    private double stripCloset(Point[] strip,int size,double d){
        double min = d;
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size && strip[j].y-strip[i].y<min;j++){
                min = Math.min(d,dist(strip[i],strip[j]));
            }
        }
        return min;
    }
}
