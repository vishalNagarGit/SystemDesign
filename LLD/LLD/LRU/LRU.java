package LLD.LRU;
import java.util.HashMap;
public class LRU{
    Node head;Node tail;
    HashMap<Integer, Node> map; 
    int capacity;
    public LRU(int capacity){
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            removeNode(map.get(key));
            addFront(node);
            return node.value;
        }
        else{
            System.out.println("Key not found");
            return -1;
        }
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            Node node = map.get(key);
            removeNode(node);
            node.value = value;
            addFront(node);
        }else{
            Node newNode = new Node(key, value);
            addFront(newNode);
            map.put(key, newNode);
            if(map.size() > capacity){
                map.remove(tail.prev.key);
                removeNode(tail.prev);
            }
        }
    }

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
    node.prev = null;
    }

    public void addFront(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;

    }
    
}