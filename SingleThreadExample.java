import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 3; i++) { // 3 tasks
            executor.execute(new SimpleTask());
        }

        executor.shutdown();
    }
}
