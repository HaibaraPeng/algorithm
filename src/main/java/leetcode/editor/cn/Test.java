package leetcode.editor.cn;

import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayTask> delayQueue = new DelayQueue<>();
        delayQueue.add(new DelayTask(1000, () -> {
            System.out.println("Task 2," + System.currentTimeMillis());
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }));
        delayQueue.add(new DelayTask(1000, () -> System.out.println("Task 1," + System.currentTimeMillis())));
        delayQueue.add(new DelayTask(3000, () -> System.out.println("Task 3," + System.currentTimeMillis())));
        while (!delayQueue.isEmpty()) {
            delayQueue.take().execute();
        }
    }

    static class DelayTask implements Delayed {

        private long time;
        private Runnable task;

        public DelayTask(long delay, Runnable task) {
            this.time = System.currentTimeMillis() + delay;
            this.task = task;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(time - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return Long.compare(this.time, ((DelayTask) o).time);
        }

        public void execute() {
            task.run();
        }
    }


}