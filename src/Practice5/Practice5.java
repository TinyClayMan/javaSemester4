package Practice5;

final class Singleton {

    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return INSTANCE;
    }
}

final class SingletonLazy {
    private static volatile SingletonLazy instance = null;

    private SingletonLazy() {}

    public static SingletonLazy getInstance() {
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
}

enum SingletonEnum {
    INST;
    public SingletonEnum getInstance() {
        return INST;
    }
}

public class Practice5 {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        SingletonLazy singleton2 = SingletonLazy.getInstance();
        SingletonEnum singleton3 = SingletonEnum.INST.getInstance();
        Singleton singleton1n = Singleton.getInstance();
        SingletonLazy singleton2n = SingletonLazy.getInstance();
        SingletonEnum singleton3n = SingletonEnum.INST.getInstance();
        System.out.println(singleton1);
        System.out.println(singleton1n);
        System.out.println(singleton2);
        System.out.println(singleton2n);
        System.out.println(singleton3);
        System.out.println(singleton3n);
    }
}
