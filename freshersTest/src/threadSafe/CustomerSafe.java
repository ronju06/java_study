package threadSafe;

import conflict.Shop;

public class CustomerSafe extends Thread {

	private String name;
	private int order;
	private Shop shop;
	private ECSiteSafe ecSite;

	public CustomerSafe(String name, int order, Shop shop, ECSiteSafe ecSite) {
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

}
