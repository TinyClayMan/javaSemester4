package Practice4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Practice4 {

    public static void main(String[] args){

        ExecutorService executor = Executors.newFixedThreadPool(10);

        executor.submit(() -> System.out.println("Test"));

        // Disable new tasks from being submitted
        executor.shutdown();
        executor.shutdownNow();
        try {
            // Wait a while for existing tasks to terminate
            if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                // Cancel currently executing tasks
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

    }

}