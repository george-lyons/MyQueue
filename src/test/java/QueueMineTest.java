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

        Assert.assertTrue(queue.contains(one));
        Assert.assertTrue(queue.contains(two));

        Integer deQueue = queue.deQueue();
        Assert.assertEquals(one, deQueue);

        Integer deQueue2 = queue.deQueue();
        Assert.assertEquals(two, deQueue2);
    }

    @Test
    public void queueAndResize() {
        QueueMine queue = new QueueMine(10);
        for (int i = 0; i < 10000; i++) {
            queue.enQueue(i);
        }

        //check the access
        Assert.assertEquals(10, queue.access(10), 0.0001);
        Assert.assertEquals(999, queue.access(999), 0.0001);

        for (int i = 0; i < 10000; i++) {
            Assert.assertEquals(i, queue.deQueue(), 0.0001);
        }

    }
}
