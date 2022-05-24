package conflict;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Single {

	private static int trueStock;
	private static int orderA;
	private static int orderB;

	public static void main(String[] args) {
		Shop shop = new Shop();
		Scanner scan = new Scanner(System.in);

		try {
			//	System.out.println("鉛筆の在庫を入力：");
			//	int stock = scan.nextInt();
			int stock = 100;
			System.out.println("鉛筆の在庫は" + stock + "本");
			shop.setPencil(stock);

			System.out.println("Aの注文数を入力：");
			orderA = scan.nextInt();
			System.out.println("Bの注文数を入力：");
			orderB = scan.nextInt();

		} catch (InputMismatchException e) {
			System.out.println("半角数字を入力してください");
			System.exit(1);
		}

		trueStock = shop.getPencil();
		trueStock -= orderA + orderB;

		ECSite ecSite = new ECSite();
		Customer customer1 = new Customer("A", orderA, shop, ecSite);
		Customer customer2 = new Customer("B", orderB, shop, ecSite);

		long start = System.currentTimeMillis();
		
		customer1.updateStock();
		customer2.updateStock();

		System.out.println("-----------------");
		System.out.println("鉛筆の在庫は" + shop.getPencil() + "本になった");
		System.out.println("正しい鉛筆の在庫は" + trueStock + "本");

		long end = System.currentTimeMillis();
		
		System.out.println("処理時間："
				+ "" + ((end - start) / 1000) + "秒");

	}

}
