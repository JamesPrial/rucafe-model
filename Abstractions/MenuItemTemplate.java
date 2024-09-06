package library.Abstractions;

import cs213.jpsr.CustomizableUtil.CustomizableList;

/**
 * A class defining the Menu Items of the store.
 * This class helps defining the basic functions which are
 * further populated in their respective extended classes.
 *
 * @author Swarnendu Roy
 * @author James Prial
 */

public abstract class MenuItemTemplate implements MenuItem{
	private double price;
	private int orderNum;
	private CustomizableList addIns;

	public MenuItemTemplate(){
		this.price = 0;
		this.orderNum = 0;
	}

	public MenuItemTemplate(double price){
		this.price = rounder(price);
		this.orderNum = 0;
	}

	public MenuItemTemplate(double price, int orderNum){
		this.price = rounder(price);
		this.orderNum = orderNum;
	}
	


	/**
	 * A public method that helps calculation
	 * of the item price, rounds to the nearest cent
	 *
	 * @return the price of the items in the order.
	 */
	public double itemPrice(){
		return this.price;
	}

	//rounds to the nearest 100th
	private double rounder(double toRound){
		double rounded = Math.round(100 * toRound);
		return rounded / 100;
	}

	public int getOrderNum(){
		return this.orderNum;
	}

	public CustomizableList getAddIns(){
		return addIns;
	}

	
	/**
	 * updates this.price based on current state
	 * @return this.price
	 */
	public double itemPrice(MenuItemPriceInterpretor priceInterpretor){
		double interpretedPrice = priceInterpretor.getPrice(this);
		if(this.price != interpretedPrice){
			this.price = interpretedPrice;
		}
		return this.price;
	}

	/**
	 * An abstract method that helps making a copy
	 * of an item on the menu.
	 *
	 * @return copy of a MenuItem object
	 */

	public abstract MenuItemTemplate copy();

	public abstract MenuItemTemplate createMenuItem();

	@Override
	public int compareTo(MenuItemTemplate obj){
		int priceComp = (int)(100*this.itemPrice()) - (int)(100*obj.itemPrice());
		int orderNumComp = this.getOrderNum() - obj.getOrderNum();
		return Math.abs(priceComp) + Math.abs(orderNumComp);
	}
	@Override
	public boolean equals(Object obj){
		if(obj instanceof MenuItemTemplate){
			MenuItemTemplate MenuItemObj = (MenuItemTemplate)obj;
			return (this.itemPrice() == MenuItemObj.itemPrice()) && (this.orderNum == MenuItemObj.getOrderNum()) && (this.addIns.equals(MenuItemObj.getAddIns()));
		}
		return false;
	}
}
