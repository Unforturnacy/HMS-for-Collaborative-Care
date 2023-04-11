package InventoryManagement;


import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Storage.DatabaseContrroller;

public class InventoryController {
    private InventoryUI hi;
  
                
             
              
    public String itemName;
    public String quantit;
    public String pric;
    public int iD;
    private DefaultTableModel model;
    private DatabaseContrroller dbController = new DatabaseContrroller();
    public InventoryController(InventoryUI hii, DefaultTableModel model)
    {
         this.hi = hii;
         this.model = model;
    }

    public void saveEquipment(Equipment equipment)
    {
        dbController.insert_equipment(equipment);
    }


    public void addToTable(Equipment equipment)
    {
        if (equipment.getquantity() > 0)
        {
            Object[] item={"stock.png", equipment.getID(), equipment.getname(), equipment.getquantity(), equipment.getunit(), equipment.getlatestRestock()};
            model.addRow(item); 
        }

        else
        {
            Object[] item={"out.png", equipment.getID(), equipment.getname(), equipment.getquantity(), equipment.getunit(), equipment.getlatestRestock()};
            model.addRow(item); 
        }

        
               

    }
    public void  updateTable(JTable table)
    {

        model.setRowCount(0);
           
    }

    public Equipment createNewEquipment()
    {
    
            

                String  date = java.time.LocalDate.now().toString();
                int quantity = Integer.parseInt(quantit);
                    double price = Double.parseDouble(pric);
                    Equipment equipment = new Equipment(iD, itemName, quantity, price, date);
                    return equipment;
        
    }

    public boolean validateDetails(String quantity, String price)
    {
        boolean valid = true;

        try
        {
            Integer.parseInt(quantity);
            Double.parseDouble(price);
        }
        catch (Exception exc)
        {
            valid = false;
        }

        return valid;


    }

    public void updateEquipment(Equipment equip)
    {
        dbController.updateEquipment(equip);

    }

    
}
