public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("group");

        System.out.println("Создаю потоки...");
        Thread thread1 = new MyThread(group, "Поток-1");
        Thread thread2 = new MyThread(group, "Поток-2");
        Thread thread3 = new MyThread(group, "Поток-3");
        Thread thread4 = new MyThread(group, "Поток-4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        Thread.sleep(10000);
        System.out.println("Завершаю все потоки.");
        group.interrupt();
    }
}
