package Stack;

public class driver {
    public static void main(String[] args) {

        Queue q = new Queue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(4);
        while (!q.isEmpty(q)) System.out.println(q.dequeue());


        /* Stack stk=new Stack();
        for(int i=0;i<11;i++)stk.push(i);
        stk.pop();
        System.out.println(stk.peek());*/
    }
}
