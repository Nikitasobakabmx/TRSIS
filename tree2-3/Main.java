import java.util.ArrayList;
import java.lang.Integer;

class Main{
    public static void main(String args[]){
        ArrayList<Integer> tmp = new ArrayList<Integer>(10);
        System.out.println(tmp.size());
        tmp.add(new Integer(10));
        //tmp.get(0);
        System.out.println(tmp.get(0));
        // System.out.println(tmp.size());
    }
}