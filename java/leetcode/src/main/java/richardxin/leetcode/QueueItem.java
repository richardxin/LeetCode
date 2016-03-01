package richardxin.leetcode;

public class QueueItem implements Comparable<QueueItem>{
	private String data;
	private int priority;
	
	public QueueItem(String data, int priority){
		this.data = data;
		this.priority = priority;
	}
	public String getData(){
		return this.data;
	}
	public int getPriority(){
		return this.priority;
	}

	@Override
	public int compareTo(QueueItem o) {		
		return this.priority - o.priority;
	}
	
	@Override
	public String toString(){
		return data;
	}
}
