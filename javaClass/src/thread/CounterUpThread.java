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
		cut1.run();
		CounterUpThread cut2 = new CounterUpThread();
		cut2.run();
		CounterUpThread cut3 = new CounterUpThread();
		cut3.run();
	}
}