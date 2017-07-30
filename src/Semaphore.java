public class Semaphore
{
    public Semaphore()
    {
        this(0);
    }

    public Semaphore(int i)
    {
        count = i;
    }

    public synchronized void down()
    {
        while(count == 0) 
            try
            {
                wait();
            }
            catch(InterruptedException _ex) { }
        count--;
    }

    public synchronized void up()
    {
        count++;
        notify();
    }

    protected int count;
}
