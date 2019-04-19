package thread.threadpool.example;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import thread.threadpool.example.thread.WorkerThreadPool;

/**
 * @author Junaid 
 * Main invoker class
 *
 */
public class InvokeConsumerJob {
	private static Logger logger = LoggerFactory.getLogger(InvokeConsumerJob.class);

	public static void main(String a[]) {
		logger.info("Starting worker thread pool at: {}", new Date());
		WorkerThreadPool pool = null;
		try {
			pool = WorkerThreadPool.getInstance();
			CountDownLatch latch = new CountDownLatch(2);
			pool.addTask(new TestThread(latch));
			pool.addTask(new TestThread(latch));
			latch.await(30, TimeUnit.SECONDS);
		} catch (Exception ex) {
			logger.error("Error while running thread pool", ex);
			// send notification before exiting JVM
			System.exit(1);
		} finally {
			if (pool != null) {
				pool.shutdown();

			}
		}
	}

}
