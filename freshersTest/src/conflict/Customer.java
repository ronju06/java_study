package conflict;

public class Customer extends Thread {

	private String name;
	private int order;
	private Shop shop;
	private ECSite ecSite;

	public Customer(String name, int order, Shop shop, ECSite ecSite) {
		this.name = name;
		this.order = order;
		this.shop = shop;
		this.ecSite = ecSite;
	}

	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ecSite.updateStock(name, order, shop);
	}

	public void updateStock() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ecSite.updateStock(name, order, shop);
	}
}
