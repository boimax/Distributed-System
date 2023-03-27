public class NewThread extends Thread {
	int n = 0;
	public NewThread(int n) {
		this.n = n;
	}
	public void run() {
		System.out.println("New Thread " + n + " executing!");
		for (int i = 0; i<10; i++) {
			System.out.println("Thread " + n + " : " + i );
		}
		
	}
	public static void main(String[] args) {
		Thread t1 = new NewThread(1);
		t1.start();
		Thread t2 = new NewThread(2);
		t2.start();
	}
}
