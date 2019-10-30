package medium;

/**
 * 用 "数组”  实现的 循环双端队列
 */
public class num_641 {
    static class MyCircularDeque {
        private Object[] elementData;
        int front;
        int rear;
        int size;  //容量
        int count;  //已经有的个数

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            elementData = new Object[k];
            front = rear = 0;
            size = k;
            count = 0;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (isFull()){
                return false;
            }
            //front 往前移一下  插入该元素
            front =( front-1 + size) % size;
            elementData[front] = value;
            count++;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (isFull()){
                return false;
            }
            //elementData[rear++] = value;
            //rear = rear == size ? 0 : rear;
            elementData[rear] = value;
            rear = (rear+1+size)%size;
            count++;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (isEmpty()){
                return false;
            }
            //elementData[front]= null;
            front = (front+1)%size;
            count--;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (isEmpty())
                return false;
            //rear 往前移一下  删除最后一个元素
            rear = (rear -1 + size)%size;
            elementData[rear] = null;
            count--;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (isEmpty()){
                return -1;
            }
            return (int) elementData[front];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (isEmpty())
                return -1;
            return (int) elementData[(rear-1 + size)%size];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            if (count == 0){
                return true;
            }
            return false;

        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            if (count == size){
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {

        MyCircularDeque circularDeque = new MyCircularDeque(5);

        System.out.println(circularDeque.insertFront(5));
        System.out.println(circularDeque.insertFront(0));
        System.out.println(circularDeque.insertLast(5));

        System.out.println(circularDeque.deleteLast());

        System.out.println(circularDeque.insertLast(7));

        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.insertLast(7));

        System.out.println(circularDeque.getFront());

        System.out.println(circularDeque.deleteFront());

        System.out.println(circularDeque.insertLast(6));
        System.out.println(circularDeque.insertLast(1));


    }
}
