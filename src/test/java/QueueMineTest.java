import mine.QueueMine;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by georgelyons
 */
public class QueueMineTest {


    @Test
    public void queueAndDeque() {
        Integer one = 1;
        Integer two = 2;
        QueueMine queue = new QueueMine();
        queue.enQueue(one);
        queue.enQueue(two);

        Integer deQueue = queue.deQueue();
        Assert.assertEquals(one, deQueue);

        Integer deQueue2 = queue.deQueue();
        Assert.assertEquals(two, deQueue2);
    }

    @Test
    public void queueAndResize() {
        QueueMine queue = new QueueMine(10);
        for (int i = 0; i < 1000000; i++) {
            queue.enQueue(i);
        }

        for (int i = 0; i < 1000000; i++) {
            Assert.assertEquals(i, queue.deQueue(), 0.0001);
        }

    }
}
