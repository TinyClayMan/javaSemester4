package Practice3;

import java.util.*;
import java.util.concurrent.Semaphore;

public class SemaphoreSet<E> implements Set<E> {

    private volatile List<E> obj = new ArrayList();
    private Semaphore semaphore = new Semaphore(1, true);

    @Override
    public int size() {
        int size;
        try {
            semaphore.acquire();
            size = obj.size();
        } catch (InterruptedException e) {
            size = 0;
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty = false;
        try {
            semaphore.acquire();
            isEmpty = obj.isEmpty();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return isEmpty;
    }

    @Override
    public boolean contains(Object o) {
        boolean contains = false;
        try {
            semaphore.acquire();
            contains = obj.contains(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return contains;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iter = null;
        try {
            semaphore.acquire();
            iter = obj.iterator();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return iter;
    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[]{};
        try {
            semaphore.acquire();
            objects = obj.toArray();
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
        return objects;
    }

    @Override
    public boolean add(E o) {
        boolean add = false;
        try {
            semaphore.acquire();
            add = obj.add(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return add;
    }

    @Override
    public boolean remove(Object o) {
        boolean remove = false;
        try {
            semaphore.acquire();
            remove = obj.remove(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return remove;
    }

    @Override
    public boolean addAll(Collection c) {
        boolean addAll = false;
        try {
            semaphore.acquire();
            addAll = obj.addAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return addAll;
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            obj.clear();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean removeAll = false;
        try {
            semaphore.acquire();
            removeAll = obj.removeAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return removeAll;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean retainAll = false;
        try {
            semaphore.acquire();
            retainAll = obj.retainAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return retainAll;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean containsAll = false;
        try {
            semaphore.acquire();
            containsAll = obj.containsAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return containsAll;
    }

    @Override
    public Object[] toArray(Object[] a) {
        Object[] ob = new Object[]{};
        try {
            semaphore.acquire();
            ob = obj.toArray();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return ob;
    }
}