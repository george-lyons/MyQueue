package mine;

/**
 * Created by georgelyons
 * <p>
 * Queue: line ordered by how items inserted
 * <p>
 * enQueue/deQueue O(1)
 * search/access O(N)
 * <p>
 * Queue: FIFO
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


    /*
    O(1)
    */
    public void enQueue(Integer value) {
        //resize if end is larger than previous
        if ((end + 1) >= data.length) {
            resizeDouble();
        }

        if (size() == 0) {
            front++;
            end++;
            data[end] = value;
        } else {
            end++;
            data[end] = value;
        }

    }

    /*
    O(1)
     */
    public Integer deQueue() {
        if (size() == 0) {
            //nothing in queue
            return null;
        }
        Integer val;
        if (front == end) {
            val = data[front];
            data[front] = null;
            //reset
            front = -1;
            end = -1;
        } else {
            val = data[front];
            data[front] = null;
            front++;
        }
        return val;
    }


    public int size() {
        if (end == -1 && front == -1) {
            return 0;
        } else {
            return end - front + 1;
        }
    }

    /*
    O(N)
    */
    public boolean contains(Integer val) {
        if(size() == 0) {
            return false;
        }
        for (int i = front; i <= end; i ++) {
            if(data[i].equals(val)) {
                return true;
            }
        }
        return false;
    }


    /*
    O(N)
     */
    public Integer access(int index) {
        if(index > size() || size() == 0) {
            return null;
        }
        int actualIndex = 0;
        for (int i = front; i <= end; i ++) {
            if(actualIndex == index) {
                return data[i];
            }
            actualIndex++;
        }
        return null;
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
