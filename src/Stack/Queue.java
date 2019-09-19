package Stack;

public class Queue {
    int front, rear, size;
    int capacity;
    int[] array;

    public Queue(int cap) {
        this.capacity = cap;
        array = new int[cap];
        size = 0;
        front = 0;
        rear = cap - 1;
    }

    public boolean isFull(Queue q) {
        return q.size == q.capacity;
    }

    public boolean isEmpty(Queue q) {
        return this.size == 0;
    }

    public void enqueue(int item) {
        if (!isFull(this)) {
            this.rear = (this.rear + 1) % this.capacity;
            this.array[this.rear] = item;
            this.size++;
            System.out.println("Enqueued!!");
        } else {
            System.out.println("Queue is Full!!");
        }
    }

    public int dequeue() {
        if (!isEmpty(this)) {
            int item = this.array[this.front];
            this.front = (this.front + 1) % this.capacity;
            this.size--;
            return item;
        } else {
            System.out.println("Queue is Empty!!");
            return Integer.MIN_VALUE;
        }
    }

    public int front() {
        if (!isEmpty(this)) {
            return this.array[front];
        } else return Integer.MIN_VALUE;
    }

    public int rear() {
        if (!isEmpty(this)) {
            return this.array[rear];
        } else return Integer.MIN_VALUE;

    }
}
