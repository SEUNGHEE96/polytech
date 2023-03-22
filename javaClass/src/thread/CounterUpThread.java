package thread;

public class CounterUpThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 51; i++) {
			System.out.println(i);
		}
	}

	public static void main(String args[]) {
		CounterUpThread cut1 = new CounterUpThread();
		cut1.start();
		CounterUpThread cut2 = new CounterUpThread();
		cut2.start();
		CounterUpThread cut3 = new CounterUpThread();
		cut3.start();
	}
}