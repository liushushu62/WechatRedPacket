import java.io.File;
import java.util.Map;

public class MyUntils {

	public static float Keep2ecimal(float num) {
		
		return (float)((int)(num*100+0.5))/100;
	}
	public static float Keep1ecimal(float num) {
		
		return (float)((int)(num*10+0.5))/10;
	}

	public static People findLuckiestPeople(People[] peoples){
		float max=0f;
		int index=0;
		for (int i=0;i<peoples.length;i++) {
			if (peoples[i].getGetpacket()>max) {
				max=peoples[i].getGetpacket();
				index=i;
			}
		}
		
		return peoples[index];
		
	}

	
	public static void printAccout(String tag,People[] people) {
		System.out.print(tag);
		for (People people2 : people) {
			System.out.print(people2.name+": "+Keep2ecimal(people2.accout)+"Ԫ ");
			
		}
		System.out.println();
	}
	public static void printAllPacket(String tag,People[] people) {
		System.out.print(tag);
		for (People people2 : people) {
			System.out.print(people2.name+": "+Keep2ecimal(people2.getallpaket)+"Ԫ ");
			
		}
		System.out.println();
	}
	public static void printDistribution(String tag,People[] people) {
		System.out.print(tag);
		for (People people2 : people) {
			for (Map.Entry<String, Integer> entry : people2.getDistributionMap().entrySet()) {
				System.out.println(people2.name+" "+entry.getKey()+" "+entry.getValue());
			}
		}
		System.out.println();
	}
	public static void Distribut2File(String fileName,People[] people) {
		
		for (People people2 : people) {
			FileUtils.print2File(fileName,people2.name);
			for (Map.Entry<String, Integer> entry : people2.getDistributionMap().entrySet()) {
				
				FileUtils.print2File(fileName, entry.getKey()+" "+entry.getValue());
			}
		}
		System.out.println();
	}
	public static void AccountDistribut2File(String fileName,Map<Integer, Integer> map) {
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			FileUtils.print2File(fileName, entry.getKey()+" "+entry.getValue());
		}
		FileUtils.print2File(fileName, "\n");
	}
}
