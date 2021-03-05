package Practice3;

import java.util.Map;
import java.util.Set;

public class Practice3 {
    private static Map<Integer, String> syncMap = new MapSync<Integer, String>();
    private static Set<Integer> syncSet = new SemaphoreSet<Integer>();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i < 15; i++) {
                syncMap.put(i, "#" + i);
                syncSet.add(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 15; i < 31; i++) {
                syncMap.put(i, "#" + i);
                syncSet.add(i);
            }
        });

        thread1.start();
        thread2.start();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Synchronized map:");
        syncMap.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("Synchronized set:");
        syncSet.forEach(System.out::println);
    }
}
