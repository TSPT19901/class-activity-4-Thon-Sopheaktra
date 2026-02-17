import java.util.concurrent.ForkJoinPool;

public class ForkJoinExample {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(); // create pool
        try {
            int[] numbers = {1, 2, 3, 4, 5, 6};
            int result = pool.invoke(new SumTask(numbers, 0, numbers.length));
            System.out.println("Total Sum: " + result);
        } finally {
            pool.shutdown(); // close the pool to avoid resource leak
        }
    }
}
