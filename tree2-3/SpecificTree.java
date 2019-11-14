import java.util.ArrayList;

class SpecificTree<T, V>{
    class Node<T, V>{
        private ArrayList<Node<T, V>> childs =
                new ArrayList<Node<T, V>>(3);
        private V value;
        private T key;
        Node(){
            //garbage
        }
        Node(T key, V value){
            this.value = new V(value);
            this.key = new T(key);
        }
        int getChildAmount(){
            if(childs == null){
                return 0;
            }
            return childs.size();
        }
        V getValue(){
            return value;
        }

        T getKey(){
            return key;
        }

    }
}