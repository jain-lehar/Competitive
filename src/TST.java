public class TST {

    private Node root;
    private class Node{
        Integer value;
        private char c;
        private Node left,mid,right;
    }

    public void put(String s,Integer value){
        root = put(root,s,value,0);
    }

    private Node put(Node x,String s,Integer value,int d){
        char c = s.charAt(d);
        if(x==null){
            x = new Node();
            x.c = c;
        }
        else if(c<x.c) x.left = put(x.left,s,value,d);
        else if(c>x.c) x.right = put(x.right,s,value,d);
        else if(d<s.length()-1) x.mid = put(x.mid,s,value,d+1);
        else x.value = value;
        return x;
    }

    public boolean contains(String key){
        return get(key)!=null;
    }

    public Integer get(String key){
        Node x = get(root,key,0);
        if(x==null) return null;
        return x.value;
    }

    private Node get(Node x,String s,int d){
        char c = s.charAt(d);
        if(x==null){
            return null;
        }
        else if(c<x.c) return get(x.left,s,d);
        else if(c>x.c) return get(x.right,s,d);
        else if(d<s.length()-1) return get(x.mid,s,d+1);
        else return x;
    }
}
