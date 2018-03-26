/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.structures;

public class Product
{
    public enum Category
    {
        SHORTSLEEVE, LONGSLEEVE, BEANIE, HAT,
        CREWNECK, HOODIE
    }
    
    private String product_id;
    private String product_name;
    private String description;
    private Category category;
    private double price;
    private int quantity;

    public Product() 
    {
        product_id = "";
        product_name = "";
        description = "";
        category = Category.SHORTSLEEVE;
        price = 0.00;
        quantity = 0;
    }

    /**
     * @return the product_id
     */
    public String getProductId()
    {
        return product_id;
    }
  
        /**
     * @param product_id the product id to set
     */
    public void setProductId(String product_id)
    {
        this.product_id = product_id;
    }

    /**
     * @return the product_name
     */
    public String getProductName()
    {
        return product_name;
    }

    /**
     * @param product_name the product_name to set
     */
    public void setProductName(String product_name)
    {
        this.product_name = product_name;
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * @return the category
     */
    public Category getCategory()
    {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category)
    {
        this.category = category;
    }

    /**
     * @return the price
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price)
    {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
}
