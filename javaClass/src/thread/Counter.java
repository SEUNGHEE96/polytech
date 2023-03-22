package thread;

public class Counter {
	int num = 0;
	
	public static void main(String args[]) throws InterruptedException{
		Counter counter = new Counter();
		for (int i=0; i<1000; i++) {
			new Thread(() -> {
				try {
					Thread.sleep(10);
					counter.num ++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();
		}
		Thread.sleep(3000);
		System.out.println(counter.num);
	}

}
          