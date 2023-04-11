package InventoryManagement;

public class Equipment {
    private int iD;
    private String name;
    private int quantity;
    private double unitprice;
    private String latestRestock;
    public Equipment(int id, String name, int quan, double unit, String latest)
    {
        
        this.iD = id;
        this.name = name;
        this.quantity = quan;
        this.unitprice = unit;
        this.latestRestock = latest;
    }
    
    public int getID()
    {
        return this.iD;
    }

    public String getname()
    {
        return this.name;
    }

    public int getquantity()
    {
        return this.quantity;
    }

    public String getlatestRestock()
    {
        return this.latestRestock;
    }

    public Double getunit()
    {
        return this.unitprice;
    }


}
