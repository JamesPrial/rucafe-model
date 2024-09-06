package library.Abstractions;

public class MenuItemPriceInterpretor {
    private static final double CAKE_PRICE = 1.59;
    private static final double HOLE_PRICE = 0.33;
    private static final double YEAST_PRICE = 1.39;
    public static MenuItemPriceInterpretor instance = null;
    private MenuItemPriceInterpretor(){
        
    }
    public static MenuItemPriceInterpretor getInstance(){
        if(instance == null){
            this.instance = new MenuItemPriceInterpretor();
        }
        return instance;
    }

    public double getPrice(MenuItemTemplate item){
        double price = 0;
        if(item instanceof Customizable){

        }

        return item.itemPrice();
    }
}
   
