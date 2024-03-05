import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<MyThread> callable = new ArrayList<>(Arrays.asList(new MyThread(3), new MyThread(2)));
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<Integer>> futureList = executor.invokeAll(callable);
        System.out.println("Количество строк " + futureList.stream().mapToInt(i -> {
            try {
                return i.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).sum());
        executor.shutdown();
    }
}
