
/**
 *  The second way to create a thread is to create a new class that extends Thread class using the following two simple steps.
 *  This approach provides more flexibility in handling multiple threads created using available methods in Thread class.
 *  
 *  Algorithm:
 *  
 *      Step 1:
 *      
 *      Override run() method available in Thread class. What you want the thread to do will be in this class. 
 *      
 *      Step 2:
 *      
 *      Once Thread object is created, you can start it by calling start() method, which executes a call to run( ) method.
 *  
 *  
 *  Example below is similar to the Runnable example 1. 
 * 
 * @author Niall Campbell
 * @version 1.0
 */
public class ThreadClassExample extends Thread
{
    private Thread t;
    private String threadName;
    
    //Constructor
    public ThreadClassExample(String name)
    {
        threadName = name;
        System.out.println("Creating: " +  threadName );
    }
    
    public void run()
    {
        System.out.println("Running: " +  threadName );
        
        if(threadName.equals("Thread 1"))
        {
            try 
            {
                 for(int i = 4; i > 0; i--)
                 {
                     System.out.println("Thread: " + threadName + ". Runtime: " + i);
                     // Let the thread sleep for a while.
                     Thread.sleep(50);
                 }
            }
            catch(InterruptedException e)
            {
                System.out.println("Thread " +  threadName + " interrupted.");
            }
        }
        else if(threadName.equals("Thread 2"))
        {
            try 
            {
                 for(int i = 1; i <= 4 ; i++)
                 {
                     System.out.println("Thread: " + threadName + ". Runtime: " + i);
                     // Let the thread sleep for a while.
                     Thread.sleep(50);
                 }
            }
            catch(InterruptedException e)
            {
                System.out.println("Thread " +  threadName + " interrupted.");
            }
        }
        
        System.out.println("Thread " +  threadName + " exiting.");
    }
    
    /**
     * This method is used to start the Thread associated with each individual ThreadClassExample object. 
     */
    public void startThread()
    {
        System.out.println("Starting: " +  threadName);
        
        if (t == null)
        {
             t = new Thread (this, threadName); //the this is the ThreadClassExample object that the method is being called on. 
             t.start(); //starts the Thread with the start() method from the Thread class library. 
        }
    }
    
    //Driver
    public static void main()
    {
        ThreadClassExample t1 = new ThreadClassExample("Thread 1");
        t1.startThread();
        
        ThreadClassExample t2 = new ThreadClassExample("Thread 2");
        t2.startThread();
    }
}
