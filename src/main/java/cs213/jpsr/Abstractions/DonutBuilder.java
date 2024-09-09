package Abstractions;

public class DonutBuilder implements MenuItemAbstractFactory {
    private final double CAKE_PRICE = 1.59;
    private final double HOLE_PRICE = 0.33;
    private final double YEAST_PRICE = 1.39;

    private double price;
    private DonutFlavors flavor;
    private DonutTypes type;

    public DonutBuilder(DonutFlavors flavor, DonutTypes type){
        this.flavor = flavor;
        this.type = type;
        switch (type) {
            case DonutTypes.YEAST:
                this.price = YEAST_PRICE;
                break;
            case DonutTypes.HOLE:
                this.price = HOLE_PRICE;
                break;
            case DonutTypes.CAKE:
                this.price = CAKE_PRICE;
                break;
            default:
                this.price = 0;
                break;
        }
    }
    public Donut createMenuItem(){
        return new Donut(price, flavor, type);
    }
}
