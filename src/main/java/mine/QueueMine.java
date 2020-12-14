package mine;

/**
 * Created by georgelyons
 *
 * Queue: line ordered by how items inserted
 *
 * enQueue/deQueue O(1)
 * search/access O(N)
 *
 * Queue: FIFO
 *
 */
public class QueueMine {
    private Integer[] data;
    private int front;
    private int end;
    private static final int DEFAULT_CAPACITY = 1000;

    public QueueMine() {
        this(DEFAULT_CAPACITY);
    }

    public QueueMine(int capacity) {
        this.data = new Integer[capacity];
        this.front = -1;
        this.end = -1;
        System.out.println("Created queue with capacity " + capacity);
    }


    public void enQueue(Integer value) {
        //resize if end is larger than previous
        if((end + 1) >= data.length) {
            resizeDouble();
        }

        if(size() == 0) {
            front++;
            end++;
            data[end] = value;
        } else {
            end++;
            data[end] = value;
        }

    }

    public Integer deQueue() {
        if(size() == 0) {
            //nothing in queue
            return null;
        }
        Integer val;
        if(front == end) {
            val = data[front];
            //reset
            front = -1;
            end = -1;
        } else {
            val = data[front];
            front++;
        }
        return val;
    }


    public int size() {
        if(end == -1 && front == -1) {
            return 0;
        } else {
            return end - front + 1;
        }
    }


    /*
    Doubles the array for resize - cost is O(N) - amortized
     */
    private void resizeDouble() {
        Integer[] temp = data;
        //resize

        data = new Integer[data.length * 2];
        if (temp.length >= 0) {
            System.arraycopy(temp, 0, data, 0, temp.length);
        }
        System.out.println("Resized queue as larger than array size double from " + temp.length + " to " + data.length);
    }




}
