public class RWayTrie {

    private static final int R = 26;
    private Node root = new Node();

    public void put(String key,Integer value){
        root = put(root,key,value,0);
    }

    private Node put(Node x,String key,Integer value,int d){
        if(x==null) x = new Node();
        if(d==key.length()){
            x.value = value;
            return x;
        }
        char c = key.charAt(d);
        x.next[c-'a'] = put(x.next[c-'a'],key,value,d+1);
        return x;
    }

    private class Node{
        private Integer value;
        private Node next[] = new Node[R];
    }

    public boolean contains(String key){
        return get(key)!=null;
    }

    public Integer get(String key){
        Node x = get(root,key,0);
        if(x==null) return null;
        return x.value;
    }

    private Node get(Node x,String key,int d){
        if(x==null) return null;
        if(d==key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c-'a'],key,d+1);
    }
}