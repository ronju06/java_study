package threadSafe;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import conflict.Shop;

public class MasterSafe {

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

		ECSiteSafe ecSite = new ECSiteSafe();
		CustomerSafe customer1 = new CustomerSafe("A", orderA, shop, ecSite);
		CustomerSafe customer2 = new CustomerSafe("B", orderB, shop, ecSite);

		// 処理の開始時間を取得
		Date start = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		String startStr = format.format(start);
		System.out.println(startStr);

		customer1.start();
		customer2.start();

		try {
			customer1.join();
			customer2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("-----------------");
		System.out.println("鉛筆の在庫は" + shop.getPencil() + "本になった");
		System.out.println("正しい鉛筆の在庫は" + trueStock + "本");

		// 処理の終了時間を取得
		Date end = new Date();
		String endStr = format.format(end);
		System.out.println(endStr);
	}

}
