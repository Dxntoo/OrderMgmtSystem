package Model;

/**
 *
 * @author Kai Wen
 */
public class OrderedItems {
    
    private Items item;
    private int quantity;
    
    

    public OrderedItems(Items item, int quantity){
        this.item = item;
        this.quantity = quantity;
        
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public Items getItems() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
    
    
}