import java.util.HashMap;
import java.util.Map;

public class People {
	public String name;
	public float accout;
	private float getpacket;
	public float getallpaket;
	private int getLuckiestCount;
	private Map<String, Integer>distributionMap= new HashMap<>(); 
	public Map<String, Integer> getDistributionMap() {
		return distributionMap;
	}
	public void setDistributionMap(Map<String, Integer> distributionMap) {
		this.distributionMap = distributionMap;
	}
	public People(String name, float accout) {
	
		this.name = name;
		this.accout = accout;
		this.getLuckiestCount=0;
	}
	public float getGetpacket() {
		return getpacket;
	}
	public void setGetpacket(float getpacket) {
		getallpaket+=getpacket;
		this.getpacket = getpacket;
		if (distributionMap.containsKey(Float.toString(MyUntils.Keep1ecimal(getpacket)))) {
			int count=distributionMap.get(Float.toString(MyUntils.Keep1ecimal(getpacket)));
			distributionMap.put(Float.toString(MyUntils.Keep1ecimal(getpacket)),count+1);
		}else {
			distributionMap.put(Float.toString(MyUntils.Keep1ecimal(getpacket)), 1);
		}
	}
	public int getGetLuckiestCount() {
		return getLuckiestCount;
	}
	public void setGetLuckiestCount(int getLuckiestCount) {
		this.getLuckiestCount = getLuckiestCount;
	}
	
}
