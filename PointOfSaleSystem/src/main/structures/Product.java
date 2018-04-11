/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.structures;

public class Product
{
    public String category_array[] =
    {
        "SHORTSLEEVE", "LONGSLEEVE", "BEANIE", "HAT",
        "CREWNECK", "HOODIE", "PANTS"
    };
    
    public String size_array[] =
    {
        "XSMALL", "SMALL", "MEDIUM", "LARGE", "XLARGE",
        "M28","M29","M30","M31","M32","M33","M34","M36","M38","M40",
        "W00","W0","W2","W4","W6","W8","W10","W12","W14"
    };
    
    private String product_id;
    private String product_name;
    private String description;
    private String category;
    private String size;
    private double price;
    private int quantity;

    /**
     * 
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
    public String getCategory()
    {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category)
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
    
        /**
     * @return the quantity
     */
    public String getSize()
    {
        return size;
    }

    /**
     * @param size the quantity to set
     */
    public void setSize(String size)
    {
        this.size = size;
    }
}
