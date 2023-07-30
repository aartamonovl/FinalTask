package Model;

public class Counter implements AutoCloseable{
    static int count;
    {
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        Counter.count = count;
    }

    public void add(){
        count++;
    }

    @Override
    public void close() {
        System.out.println("Счетчик закрыт.");
    }
}
