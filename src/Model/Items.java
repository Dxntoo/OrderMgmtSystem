package Model;

/**
 *
 * @author Kai Wen
 */

public class Items {
    protected Items item;
    protected String ItemID;
    protected String ItemName;
    protected String Size;
    protected double ItemPrice;
    protected int ItemQuantity;
    protected static final String FILENAME = "Items.txt";

    public Items(String ItemID, String ItemName, String Size, double ItemPrice, int ItemQuantity){
        this.ItemID = ItemID;
        this.ItemName = ItemName;
        this.Size = Size;
        this.ItemPrice = ItemPrice;
        this.ItemQuantity = ItemQuantity;
    }
//    
//    public Items(Items item, int quantity){
//        this.item = item;
//        this.ItemQuantity = quantity;
//    }
    
    public Items(Items item){
        this.item = item;
    }
  
    public double getItemPrice() {
        return ItemPrice;
    }
    
    public String getItemName() {
        return ItemName;
    }
    
    public String getItemID() {
        return ItemID;
    }
    
    public int getItemQuantity(){
        return ItemQuantity;
    }
    
    public String getSize(){
        return Size;
    }
    
    public void changeQuantity(int quantity) {
        if ((this.ItemQuantity + quantity)>= 0 ) {
            this.ItemQuantity += quantity;
        }
    }

    //abstract Double getCharge();

    //abstract Double getTotalPrice();
}
