package medium;

import java.util.Objects;

public class num_622 {
    /**
     * 用数组实现循环队列
     */
    static class MyCircularQueue {
        private Object[] elementData;
        int front;
        int rear;
        int size;
        public MyCircularQueue(int k) {
            elementData = new Object[k];
            front=0;
            rear=0;
            size = k;
        }

        public boolean enQueue(int value) {
            // 如果队列不满 入队
            if(isFull()){
               return false;
            }
            elementData[rear++] = value;
            rear = rear == size ? 0 : rear;
            return true;
        }

        public boolean deQueue() {
            //如果不空就出队列
            if (isEmpty()){
                return false;
            }
            elementData[front++] = null;
            front = front == size? 0 : front;
            return true;
        }

        public int Front() {
            if (isEmpty()){
                return -1;
            }
            return (int) elementData[front];
        }

        public int Rear() {
            if (isEmpty())
                return -1;
            return (int) elementData[(rear - 1 + size)%size];
        }

        public boolean isEmpty() {
            if (front == rear && elementData[rear] == null){
                return true;
            }
            return false;
        }

        public boolean isFull() {
            if (front == rear && elementData[front] != null){
                return true;
            }
            return false;
        }

        public static void main(String[] args) {
            MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3

            System.out.println(circularQueue.enQueue(1));;

            System.out.println(circularQueue.enQueue(2));// 返回 true

            System.out.println(circularQueue.enQueue(3)); // 返回 true

            System.out.println(circularQueue.enQueue(4)); // 返回 false，队列已满

            System.out.println(circularQueue.Rear()); // 返回 3

            System.out.println(circularQueue.isFull()); // 返回 true

            System.out.println(circularQueue.deQueue()); // 返回 true

            System.out.println(circularQueue.enQueue(4)); // 返回 true

            System.out.println(circularQueue.Rear()); // 返回 4

        }
    }
}
