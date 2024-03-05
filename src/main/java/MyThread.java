import java.util.concurrent.Callable;

public class MyThread implements Callable<Integer> {
    private int n;

    public MyThread(int n) {
        this.n = n;
    }
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < n; ++i) {
            System.out.println("Я " + Thread.currentThread().getName());
        }
        return n;
    }
}
