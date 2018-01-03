import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	private static int testTimes = 10;
	private static int gamecount = 50000;

	private static int[] luckeyCountFirst=new int[testTimes];
	private static int[] luckeyCountSec=new int[testTimes];
	private static int[] luckeyCountThird=new int[testTimes];
	public static void main(String[] arg) {
		// TODO Auto-generated constructor stub
		 Map<Integer, Integer> mapFirstCountAccout=new HashMap<>();
		 Map<Integer, Integer> mapSecondCountAccout=new HashMap<>();
		 Map<Integer, Integer> mapThirdCountAccout=new HashMap<>();
		
		for (int j = 0; j < testTimes; j++) {
			People[] people = new People[3];
			people[0] = new People("我", 100);
			people[1] = new People("范文龙", 100);
			people[2] = new People("晏士帅", 100);
			
			MyUntils.printAccout("初始金额： ", people);
			for (int k = 0; k < gamecount; k++) {
				System.out.println("第"+(k+1)+"轮");
				RedPacket packet = new RedPacket(10.0f, 3, MyUntils.findLuckiestPeople(people));
				for (int i = 0; i < people.length; i++) {
					packet.open(people[i]);
					// System.out.println(people[i].name+"现在有 "+people[i].accout+"元");
				}
				//FileUtils.print2File("redpaket.txt",(k+1)+" "+ people[0].getGetpacket()+" "+people[1].getGetpacket()+" "+people[2].getGetpacket());
				
				System.out.println(MyUntils.findLuckiestPeople(people).name + "是最幸运的人");
				MyUntils.findLuckiestPeople(people).setGetLuckiestCount(MyUntils.findLuckiestPeople(people).getGetLuckiestCount()+1);
				System.out.println();
			}
			luckeyCountFirst[j]=people[0].getGetLuckiestCount();
			luckeyCountSec[j]=people[1].getGetLuckiestCount();
			luckeyCountThird[j]=people[2].getGetLuckiestCount();
			MyUntils.printAccout("游戏结束：账户余额： ",people);
			countAccountDistr(mapFirstCountAccout, people[0].accout);
			countAccountDistr(mapSecondCountAccout, people[1].accout);
			countAccountDistr(mapThirdCountAccout, people[2].accout);
			//MyUntils.printAllPacket("一共获得的红包", people);
			//MyUntils.printDistribution("红包分配", people);
			//MyUntils.Distribut2File("distribut.txt", people);
		}
//		
//		System.out.println(mapFirstCountAccout);
//		MyUntils.AccountDistribut2File("accountdis.txt", mapFirstCountAccout);
//		System.out.println(mapSecondCountAccout);
//		MyUntils.AccountDistribut2File("accountdis.txt", mapSecondCountAccout);
//		System.out.println(mapThirdCountAccout);
//		MyUntils.AccountDistribut2File("accountdis.txt", mapThirdCountAccout);
		System.out.println(Arrays.toString(luckeyCountFirst));
		System.out.println(Arrays.toString(luckeyCountSec));
		System.out.println(Arrays.toString(luckeyCountThird));
		
	}

	public static void countAccountDistr(Map<Integer, Integer> map, float account) {
		int int_account = (int) (account + 0.5);

		if (map.containsKey(int_account)) {
			int count = map.get(int_account);
			map.put(int_account, count + 1);
		} else {
			map.put(int_account, 1);
		}
	}

}
