
/**
 * If a class is intended to be executed as a thread then you can achieve this by implementing a Runnable interface.
 * 
 * The Runnable interface should be implemented by any class whose instances are intended to be executed by a thread.
 * 
 * The class must define a method called run() which has no arguments.
 * 
 * This interface is designed to provide a common protocol for objects that wish to execute code while they are active. 
 * 
 * A thread is a thread of execution in a program. What the thread does is defined in the run() method. 
 * 
 * 
 * Algorithm:
 * 
 * Step 1:
 *  
 *  Firstly you need to implement a run() method provided by a Runnable interface. 
 *  This method provides an entry point for the thread and you will put your complete business logic inside this method. 
 *  What the thread does is defined in the run() method. 
 *  
 * Step 2: 
 *  
 *  In the start() method, instantiate a Thread object using the Thread() constructor.
 *  
 * Step 3:
 * 
 *  Once a Thread object is created, you can start it by calling the Thread library start() method, which executes a call to run() method.
 * 
 * @author Niall Campbell
 * @version 1/10/18
 */
public class RunnableExample implements Runnable
{
    private Thread t;
    private String threadName;
    
    /**
     * Constructor.
     * 
     * A RunnableExample object will have a Thread object and a String name.
     * 
     * The Thread object will be initialised in the start() method below. 
     * 
     */
    public RunnableExample(String name)
    {
        threadName = name;
        System.out.println("Creating " +  threadName);
    }
    
    /**
     * Method for running the thread.
     * 
     * The run() method is included in the Runnable interface so it has to be overwritten. 
     * 
     */
    @Override
    public void run()
    {
        System.out.println("Running " +  threadName); //print that the thread is running
        
        try
        {
            for(int i = 4; i > 0; i--)
            {
                System.out.println("Thread: " + threadName + ". Runtime: " + i);
                Thread.sleep(50); // Let the thread sleep for a while.
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        
        System.out.println("Thread: " +  threadName + " exiting."); //End of the thread running
    }
    
    /**
     * Method to start running the thread of a RunnableExample object. 
     * 
     * Will be used on a RunnableExample object. 
     * 
     * The method calls a different Thread library start() method on the thread object of the RunnableExample object.
     * This start() method calls the overwritten run() method above on this thread. 
     */
    public void start()
    {
        System.out.println("Starting " +  threadName);
        
        //The RunnableExample object should initially have a null Thread object. 
        if (t == null)
        {
            //here, 'this' is the RunnableExample object that the method is being called on in the main method. 
            t = new Thread(this, threadName); //create new Thread object for the RunnableExample object. 
            t.start(); //starts the Thread
                //this uses the Thread library start() method. It calls the run method on this thread.
        }
    }
    
    //Driver for the code. 
    public static void main()
    {
        RunnableExample r1 = new RunnableExample("Thread1");
        r1.start(); //calls the start() method on the RunnableExample object. 
        
        RunnableExample r2 = new RunnableExample("Thread2");
        r2.start(); //r2 is started while r1 is still running as it is multithreaded. 
    }
    
    /**
     * 
     * If the two objects above were just run one after the other traditionally the following would be the output:
     * 
     *      Creating Thread1
            Starting Thread1
            Running Thread1
            Thread: Thread1. Runtime: 4
            Thread: Thread1. Runtime: 3
            Thread: Thread1. Runtime: 2
            Thread: Thread1. Runtime: 1
            Thread: Thread1 exiting.
            Creating Thread2
            Starting Thread2
            Running Thread2
            Thread: Thread2. Runtime: 4
            Thread: Thread2. Runtime: 3
            Thread: Thread2. Runtime: 2
            Thread: Thread2. Runtime: 1
            Thread: Thread2 exiting.
     * 
     * 
     * However as the program is multithreaded, r1 and r2 can be run concurrently and the following is the output:
     * 
     *      Creating Thread1
            Starting Thread1
            Creating Thread2
            Starting Thread2
            Running Thread1
            Running Thread2
            Thread: Thread2. Runtime: 4
            Thread: Thread1. Runtime: 4
            Thread: Thread2. Runtime: 3
            Thread: Thread1. Runtime: 3
            Thread: Thread1. Runtime: 2
            Thread: Thread2. Runtime: 2
            Thread: Thread2. Runtime: 1
            Thread: Thread1. Runtime: 1
            Thread: Thread1 exiting.
            Thread: Thread2 exiting.


     * n.b. the order that they are executed in may vary when the threads are running. 
     * 
     * r2 does not wait for r1 to be finished before it starts running. 
     * 
     */
}
