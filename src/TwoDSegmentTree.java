public class TwoDSegmentTree {

    int tree[][];
    int input[][];
    public TwoDSegmentTree(int input[][]) {
        this.input = input;
        int sizeX = input.length;
        int sizeY = input[0].length;
        int sx = nextPowerOf2(sizeX);
        int sy = nextPowerOf2(sizeY);
        tree = new int[2*sx-1][2*sy-1];
        constructX(0,0,input[0].length-1);
    }

    private void constructX(int lx,int vx,int hx){
        if(lx>hx) return ;
        if(lx!=hx) {
            int mid = lx+(hx-lx)/2;
            constructX(lx,2*vx+1,mid);
            constructX(mid+1,2*vx+2,hx);
        }
        constructY(lx,vx,hx,0,0,input.length-1);
    }

    private void constructY(int lx,int vx,int hx,int ly,int vy,int hy){
        if(ly>hy) return ;
        if(ly==hy){
            if(lx==hx) tree[vx][vy] = input[lx][hy];
            else tree[vx][vy] = tree[vx*2+1][vy]+tree[vx*2+2][vy];
            return;
        }
        int mid = ly+(hy-ly)/2;
        constructY(lx,vx,hx,ly,vy*2+1,mid);
        constructY(lx,vx,hx,mid+1,vy*2+2,hy);
        tree[vx][vy] = tree[vx][2*vy+1]+tree[vx][2*vy+2];
    }

    private void updateX(int lx,int vx,int hx,int x,int y,int val) {
        if(lx>hx) return ;
        if(lx!=hx){
            int mid = lx+(hx-lx)/2;
            if(x<=mid)
                updateX(lx,2*vx+1,mid,x,y,val);
            else
                updateX(mid+1,2*vx+2,hx,x,y,val);
        }
        updateY(lx,vx,hx,0,0,input.length-1,x,y,val);
    }

    private void updateY(int lx,int vx,int hx,int ly,int vy,int hy,int x,int y,int val){
        if(ly>hy) return ;
        if (ly==hy) {
            if (lx==hx) tree[vx][vy] = val;
            else tree[vx][vy] = tree[2*vx+1][vy]+tree[2*vx+2][vy];
            return;
        }
        int mid = ly+(hy-ly)/2;
        if(mid>=y) updateY(lx,vx,hx,ly,2*vy+1,mid,x,y,val);
        else updateY(lx,vx,hx,ly,2*vy+2,hy,x,y,val);
        tree[vx][vy] = tree[vx][2*vy+1]+tree[vx][2*vy+2];
    }

    private int sumX(int lx,int vx,int hx,int tlx,int thx,int tly,int thy) {
        if(lx>hx) return 0;
        if(lx==tlx&&hx==thx) return sumY(vx,0,0,input.length-1,tly,thy);
        int tmx = tlx+(thx-tlx)/2;
        return sumX(lx,vx*2+1,Math.min(tmx,hx),tlx,tmx,tly,thy)+
                sumX(lx,vx*2+2,Math.max(lx,tmx+1),tmx+1,thx,tly,thy);
    }

    private int sumY(int vx,int ly,int vy,int hy,int tly,int thy) {
        if(ly>hy) return 0;
        if(ly==tly&&hy==thy) return tree[vx][vy];
        int mid = tly+(thy-tly)/2;
        return sumY(vx,ly,2*vy+1,Math.min(hy,mid),tly,mid)
                +sumY(vx,Math.max(ly,mid+1),vy*2+2,hy,mid+1,thy);
    }

    private int nextPowerOf2(int n) {
        n--;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        n++;
        return n;
    }
}
