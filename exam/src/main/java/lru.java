import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/10/13 20:34
 * @Description:
 */

public class lru {
    static class Node{
        Node next;
        int data;
        public Node(int data , Node node){
            this.data = data;
            this.next = node;
        }
        public Node(){

        }
    }
   static public int cap = 3;
    static public Node head;
    static public int length = 0;
    public lru(){
        head = new Node();
        length = 0 ;
        cap = 3;
    }
    public static void main(String []args){
        lru l = new lru();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            System.out.print("lru中为：");
            MyLru(in.nextInt());
            print();
        }
    }
   static public void MyLru(int data){
        Node node = find(data);
        if(node!=null){
            deleteNext(node);
            insertHead(data);
        }
        else{
            if(length>=cap){
                deleteEnd();
            }
            insertHead(data);
        }

    }

    static public void deleteEnd(){
        Node node =head;
        if(node.next==null){
            return;
        }
        while(node.next.next !=null){
            node = node.next;
        }
        Node end = node.next;
        node.next = null;
        end = null;
        length--;
    }
    static public void insertHead(int data){
        Node node = head.next;
        Node cur = new Node(data,node);
        head.next = cur;
        length++;
    }

    //前一个节点
    static public Node find(int data){
        Node node = head;
        while(node.next!=null){
            if(node.next.data ==data){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    //删除下一个
    static public void deleteNext(Node node){
        if(node!=null){
            Node temp = node.next;
            node.next = temp.next;
            temp.next = null;
            length--;
        }
    }
    static public void print(){
        Node node = head.next;
        while(node!=null){
            System.out.print(node.data+"  ");
            node = node.next;
        }
        System.out.println();
    }
}
