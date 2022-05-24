package conflict;

public class ECSite {
	public void updateStock(String name, int order, Shop shop) {
		int stock = shop.getPencil();
		System.out.println(name + "が購入する前の鉛筆の在庫は" + stock + "本"); // Aが購入する前の鉛筆の在庫は1000本
		System.out.println(name + "が鉛筆を" + order + "本注文"); // Aが鉛筆を500本注文
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		shop.setPencil(stock -= order);
	}
}
