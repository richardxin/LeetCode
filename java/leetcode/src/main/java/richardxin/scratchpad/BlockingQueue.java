package richardxin.scratchpad;

import java.util.LinkedList;

public class BlockingQueue <T> {
	private LinkedList<T> queue = new LinkedList<>();
	private int limit = 20;
	
	public BlockingQueue(int limit){
		this.limit = limit;
	}
	
	public synchronized void enqueue(T item) throws InterruptedException{
		while (this.queue.size() == this.limit){
			wait();
		}
		if (this.queue.size() == 0){
			notifyAll();
		}
		this.queue.add(item);
	}
	
	public T dequeue() throws InterruptedException{
		while (this.queue.size() == 0){
			wait();
		}
		if (this.queue.size() == this.limit){
			notifyAll();
		}
		return this.queue.remove(0);
	}
}
