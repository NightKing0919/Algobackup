package Stack;

public class Stack {
    int top;
    int MAX = 1000;
    int[] a = new int[MAX];

    public Stack() {
        top = -1;
    }

    public void push(int s) {
        if (top >= (MAX - 1)) {
            System.out.println("Stack Full");
        } else {
            a[++top] = s;
            System.out.println("Pushed into Stack!");
        }
    }

    public int pop() {

        if (top < 0) {
            System.out.println("Stack Empty!");
            return 0;
        }
        int t = a[top--];
        return t;
    }

    public int peek() {
        if (top < 0) {
            System.out.println("Stack Empty!");
            return 0;
        } else {
            return a[top];
        }
    }

    public boolean isEmpty() {
        return top < 0;
    }
}
