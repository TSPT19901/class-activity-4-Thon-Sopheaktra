import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Integer> {
    private int[] numbers;
    private int start, end;

    public SumTask(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 2) { // base case
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += numbers[i];
                System.out.println(Thread.currentThread().getName() + " processing index " + i);
            }
            return sum;
        } else { // split task
            int mid = (start + end) / 2;
            SumTask left = new SumTask(numbers, start, mid);
            SumTask right = new SumTask(numbers, mid, end);
            left.fork(); // run left asynchronously
            int rightResult = right.compute(); // run right in current thread
            int leftResult = left.join(); // wait for left
            return leftResult + rightResult;
        }
    }
}
