
/**
 * This example doesn't create class objects, rather it just creates a number of Threads in the main method and runs them. 
 * 
 * @author Niall Campbell
 * @version 1/10/18
 */
public class RunnableExample2 implements Runnable
{
    /**
     * Required to be overwritten from the Runnable interface. 
     * 
     * Defines what the threads will do. 
     * 
     */
    @Override
    public void run()
    {
        try
        { 
            //Display the thread that is running 
            System.out.println ("Thread " + Thread.currentThread().getId() + " is running"); 
        } 
        catch (Exception e) 
        { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
    }
    
    //test the code
    public static void main()
    {
        int n = 8; // Number of threads 
        
        for(int i = 0; i < n; i++) 
        { 
            Thread object = new Thread(new RunnableExample2()); 
            object.start(); //start the thread. Will call the run() method above.  
        } 
    }
}
