/**
 * 
 */
package thread.threadpool.example;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import thread.threadpool.example.thread.BaseThread;

/**
 * @author Junaid
 * 
 * Thread class
 *
 */

public class TestThread extends BaseThread {
	private static Logger logger = LoggerFactory.getLogger(TestThread.class);

	protected TestThread(CountDownLatch doneSignal) {
		super(doneSignal);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() throws Exception {		
		System.out.print("TestThread running..!!");
	}
	//test message

}
