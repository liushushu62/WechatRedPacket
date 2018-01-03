
/**
 * Created by liu2 on 2017/12/29.
 */
public class RedPacket{
    private float total;
    private int quantity;
    
    public float open(People people){
    	if (quantity==1) {
    		quantity--;
    		
    		//System.out.println(total);
    		float getRedPacket=(float)((int)(total*100+0.5))/100;
    		people.setGetpacket(getRedPacket);
    		people.accout+=getRedPacket;
    		System.out.println("  >"+people.name+"抢到了"+getRedPacket+"元红包");
    		total=total-total;
			return getRedPacket;
		}else {
			//(float)((int)(Math.random()*10*100))/100
			float myPacket=(float)((int)(Math.random()*2*(total/quantity)*100))/100;
			quantity--;
			total=total-myPacket;
			people.accout+=myPacket;
			people.setGetpacket(myPacket);
			System.out.println("  >"+people.name+"抢到了"+myPacket+"元红包");
			return myPacket;
		}
  
    }

    public RedPacket(float total, int quantity,People people) {
        this.total = total;
        this.quantity = quantity;
        people.accout=people.accout-total;
        System.out.println("  >"+people.name+" 发了一个"+total+"元红包");
    }

    public float getQuantity() {
        return quantity;
    }

    public float getTotal() {
        return total;
    }

    public static void main(String[] args) {
    	
    	
    	
    	
    	
    }
}
