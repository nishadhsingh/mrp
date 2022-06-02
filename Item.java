
import java.util.Arrays;
public class Item{

	private String itemName;
	private int amountOnHand;
	private int itemRequired;
	public Item[] childComponents = null;
	private Boolean root;

	public Item(String itemName,int amountOnHand,int itemRequired,Item[] childComponents){
		this.itemName = itemName;
		this.amountOnHand = amountOnHand;
		this.itemRequired = itemRequired;
		this.childComponents = childComponents;
		this.root = false;
	}

	public String getitemName(){
		return itemName;
	}
	public void setitemName(String itemName){
		this.itemName = itemName;
	}
	public int getamountOnHand(){
		return amountOnHand;
	}
	public void setamountOnHand(int amountOnHand){
	       this.amountOnHand = amountOnHand;
	}
	
	public int getitemRequired(){
		return itemRequired;
	}
	public void setitemRequired(int itemRequired){
		this.itemRequired = itemRequired;
	}
	public Item[] getchildComponents(){
		return childComponents;
	}
	public int getchildComponentCount(){
	    return childComponents.length;
	   }
	public String toString(){
	    return Arrays.toString(childComponents)+":"+itemName+":"+amountOnHand;
	   }

}
