package Model;

import java.util.ArrayList;

public class Cart {
    private ArrayList<OrderedItems> cartItems = new ArrayList<>();
    private Items item;
   
    
    public void add(OrderedItems o){
        cartItems.add(o);
    }

    public void remove(OrderedItems o){
        cartItems.remove(o);
    }
    
    public void clearItems(){
        for(int i = cartItems.size()-1; i >=0 ; i--){
            cartItems.remove(i);
        }
    }
    public Items getItem(){
        return item;
    }

    public ArrayList<OrderedItems> getCartItems() {
        return cartItems;
       
    }
}
