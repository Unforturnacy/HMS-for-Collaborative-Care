package InventoryManagement;
import javax.lang.model.util.ElementScanner14;
import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.TableHeaderUI;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicPanelUI;
import javax.swing.plaf.metal.MetalBorders.TableHeaderBorder;
import PatientManagement.FilterController;
import PatientManagement.PatientAdmissionUI;
import Storage.DatabaseContrroller;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.AttributeSet.ColorAttribute;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;


import users.*;
import java.awt.*;

import security.*;
import java.lang.Object;
import java.lang.ModuleLayer.Controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.awt.font.*;
import java.sql.*;
import java.util.logging.*;

import javax.lang.model.util.ElementScanner14;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.font.TextAttribute;

public class InventoryUI extends JPanel{
    public JPanel recepPanel;
    static Point mouseDownCompCoords;
    public JPanel upperbutton;
    public JTable table3;
    public DefaultListCellRenderer listRenderer;
    protected  JTextField iDinput;
    protected JTextField nameinput;
    protected JTextField contactinput;
    protected JComboBox genderinput;
    protected JTextField phoneinput; 
    protected JTextField symptomsinput;
    protected  JComboBox valueinput5;
    protected JTextField occinput;
    protected JComboBox groupinput;
    protected JTextField relinput ;
    protected JComboBox consinput;
    public JTextField quantity;
    public JTextField itemName;
    protected JTextField priceinput;
    protected JTextField dateinput;
    protected JDatePickerImpl datePicker;
    protected JLabel titleinfo;
    protected JTable table;
    protected JComboBox valueinput3;
    public JTextField valueinput;
    protected DefaultTableModel model;
    protected DefaultTableModel model2;
    protected int please;
    public InventoryController controller;
    protected JPanel listPanel;
    protected boolean onmain = true;
    protected JLabel contact;
    //public addEquipmentUI equi;



    public JPanel patientinfo;
    public JPanel chart;
    public JPanel tbl2;
    public JPanel tbl;
    public JPanel listPanelmain;
    public UserLoginUI entry;
    public boolean update = false;
    private JLabel totalLabel ;
    PatientAdmissionUI rec;
    JFrame frame;
    public FilterController listcontrol;
    private DatabaseContrroller dbController = new DatabaseContrroller();
    private InventoryUI me;
    public int mostrecent = 1;
    public InventoryUI()
    {
        me = this;
       
        listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        listPanel = new JPanel();
        listPanel.setLayout(new BorderLayout());
        listPanel.setBounds(25, 115, 1450, 550);
        listPanel.setBackground(Color.white);

        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(null);
        filterPanel.setBounds(25, 0, 1450, 100);
        filterPanel.setBackground(Color.white);

        JLabel filterlabel = new JLabel("Add Equipment:");
        filterlabel.setBounds(550, 40, 250, 40);
        filterlabel.setFont(new Font("Serif", Font.PLAIN, 30));
        filterPanel.add(filterlabel);

        JLabel baseLabel = new JLabel("Inventory Listing");
        baseLabel.setBounds(20, 10, 620, 60);
        baseLabel.setFont(new Font("Serif", Font.PLAIN, 50));
        filterPanel.add(baseLabel);
        

        JButton OK = new JButton("Add");
        OK.setBounds(1320, 40, 120, 35);
        OK.setBackground(Color.decode("#54aeef"));
        OK.setFont(new Font("Serif", Font.BOLD, 18));
        OK.setBorderPainted(false);
        OK.setFocusPainted(false);
        OK.setForeground(Color.WHITE);
        OK.setUI(new StyledButtonUI());
        OK.addActionListener(new okListener());
        filterPanel.add(OK);

        JLabel valuee = new JLabel("Price");
        valuee.setBounds(1200, 5, 125, 40);
        valuee.setBackground(Color.BLUE);
        valuee.setFont(new Font("Serif", Font.PLAIN, 17));
        filterPanel.add(valuee);

      
        valueinput=new JTextField();
        valueinput.setBackground(Color.WHITE);
        valueinput.setBounds(1170, 50, 125, 25);
        filterPanel.add(valueinput);

   

        JLabel con = new JLabel("Quantity");
        con.setBounds(1000, 5, 125, 40);
        con.setFont(new Font("Serif", Font.PLAIN, 17));
        con.setBackground(Color.BLUE);
        filterPanel.add(con);

      

        quantity = new JTextField();
        quantity.setBackground(Color.WHITE);
        quantity.setBounds(970, 50, 125, 25);
        filterPanel.add(quantity);

        
  

     

        JLabel field = new JLabel("Item Name");
        field.setBounds(805, 5, 125, 40);
        field.setFont(new Font("Serif", Font.PLAIN, 17));
        field.setBackground(Color.BLUE);
        filterPanel.add(field);

 

        itemName = new JTextField();
        itemName.setBounds(770, 50, 125, 25);
        itemName.setBackground(Color.WHITE);
        filterPanel.add(itemName);
    

       
        
    

        JLabel operator = new JLabel("Operator");
        operator.setBounds(600, 5, 125, 40);
        operator.setFont(new Font("Serif", Font.PLAIN, 17));
        operator.setBackground(Color.BLUE);


    

        String group5[]={" ", "AND", "OR"}; 
        JComboBox valueinput7=new JComboBox(group5);
        valueinput7.setRenderer(listRenderer); 
        valueinput7.setBackground(Color.WHITE);

      
      
        valueinput7.setBounds(570, 50, 125, 25);
   




        
        setLayout(null);
       setBounds(15, 115, 1470, 845);
        
           String[] coloumnNames = {"Stock", "Item ID", "Item Name", "Quantity", "UnitPrice", "Latest Restock"};
            model2 = new DefaultTableModel(coloumnNames, 0){
      
                    @Override
                 public boolean isCellEditable(int row, int column) {    
                    if (column == 4 || column == 3 )
                    {
                        return true; // or a condition at your choice with row and column
                    }
                    return false;
                
                }

                public void setValueAt(Object value, int row, int col)
                {
                    if(col == 3)
                    {
                        int id = (int) getValueAt(row, 1);
                        String name = (String) getValueAt(row, 2);
                        String quant =  (String) value;
                        if(controller.validateDetails(quant, "0"))
                        {
                            Double pric = (Double) getValueAt(row, 4);
                            String price = Double.toString(pric);
                            controller.iD = id;
                            controller.itemName = name;
                            controller.quantit = quant;
                            controller.pric = price;
                            Equipment equipment = controller.createNewEquipment();
                            System.out.println(equipment);
                            controller.updateEquipment(equipment);
                            controller.updateTable(table);
                            updateTable();
                            updateSuccesful();
                        }
                        else
                        {
                            errorMessage();
                        }

        
                        
             
                    }
                    if(col == 4)
                    {
                        int id = (int) getValueAt(row, 1);
                        String name = (String) getValueAt(row, 2);
                        int quantity = (int) getValueAt(row, 3);
                        String quant = Integer.toString(quantity);
                        String pric = (String) value;
                        if(controller.validateDetails("0", pric))
                        {
                            controller.iD = id;
                            controller.itemName = name;
                            controller.quantit = quant;
                            controller.pric = pric;
                            Equipment equipment = controller.createNewEquipment();
                            System.out.println(equipment);
                            controller.updateEquipment(equipment);
                            controller.updateTable(table);
                            updateTable();
                            updateSuccesful();
                        }
                        else
                        {
                            errorMessage();
                        }
                        
                   
                    }
                }
            };

        

                 
        
           
          
      
        table3 = new JTable(model2);
       
       

    

   
         table3.setRowSelectionAllowed(false);


        JTableHeader header = table3.getTableHeader();
        header.setBorder(null);
        header.setFont(new Font("Serif", Font.BOLD, 20));
        header.setBackground(Color.decode("#54aeef"));
        header.setForeground(Color.WHITE);
       DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
       centerRenderer.setBorder(null);
       table3.setFont(new Font("Serif", Font.PLAIN, 16));
     
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for (int columnIndex = 0; columnIndex < table3.getColumnCount(); columnIndex++)
        {
            table3.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }
        

        table3.setShowVerticalLines(false);
        table3.getColumnModel().getColumn(0).setPreferredWidth(1);
        table3.getColumnModel().getColumn(0).setCellRenderer(new ImageRender());
        totalLabel = new JLabel("Total:"+Integer.toString(333));
        totalLabel.setBounds(100, 62, 100, 40);
        totalLabel.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
        filterPanel.add(totalLabel);
   
        table3.setRowHeight(37);
        table3.getTableHeader().setFont(new Font("Serif", Font.BOLD, 17));
        table3.getTableHeader().setPreferredSize(new Dimension(100, 35));
        table3.setPreferredScrollableViewportSize(new Dimension(1460, 250));
        table3.setFillsViewportHeight(true);
       JScrollPane scrollPane = new JScrollPane(table3);
       scrollPane.setBorder(new LineBorder(Color.WHITE, 5));
       
       listPanel.add(scrollPane);
       add(filterPanel);
       add(listPanel);
       controller = new InventoryController(this, model2);

       SwingUtilities.invokeLater(() -> {
        Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
        attributes.put(TextAttribute.TRACKING, 0.03);

        baseLabel.setFont(baseLabel.getFont().deriveFont(attributes));
        filterlabel.setFont(filterlabel.getFont().deriveFont(attributes));
        totalLabel.setFont(totalLabel.getFont().deriveFont(attributes));
        totalLabel.setFont(totalLabel.getFont().deriveFont(attributes));
    });

    //listcontrol = new FilterController(model2, entry);
    JPanel addupmod = new JPanel();
    addupmod.setLayout(null);
    addupmod.setBounds(25, 670, 1450, 100);
    addupmod.setBackground(Color.WHITE);
    JButton add = new JButton("Add");
    add.setBounds(870, 10, 105, 39);
    add.setBackground(Color.decode("#54aeef"));
    add.setFont(new Font("Serif", Font.BOLD, 18));
    add.setBorderPainted(false);
    add.setFocusPainted(false);
    add.setForeground(Color.WHITE);
    add.setUI(new StyledButtonUI());
    add.addActionListener(new addListener());
    add(addupmod);

    JButton upd = new JButton("Update");
    upd.setBounds(985, 10, 105, 39);
    upd.setBackground(Color.decode("#54aeef"));
    upd.setFont(new Font("Serif", Font.BOLD, 18));
    upd.setBorderPainted(false);
    upd.setFocusPainted(false);
    upd.setForeground(Color.WHITE);
    upd.setUI(new StyledButtonUI());

    JButton del = new JButton("Delete");
    del.setBounds(1100, 10, 105, 39);
    del.setBackground(Color.decode("#54aeef"));
    del.setFont(new Font("Serif", Font.BOLD, 18));
    del.setBorderPainted(false);
    del.setFocusPainted(false);
    del.setForeground(Color.WHITE);
    del.setUI(new StyledButtonUI());


    JPanel dec1 = new JPanel();
    dec1.setLayout(null);
    dec1.setBounds(820, 39, 420, 10);
    dec1.setBackground(Color.decode("#92cbf5"));
    addupmod.add(dec1);



    
    JPanel dec3 = new JPanel();
    dec3.setLayout(null);
    dec3.setBounds(0, 89, 1550, 10);
    dec3.setBackground(Color.decode("#54aeef"));
    addupmod.add(dec3);

    

    setVisible(true);


    }

    class StyledButtonUI extends BasicButtonUI  {

        @Override
        public void installUI (JComponent c) {
            super.installUI(c);
            AbstractButton button = (AbstractButton) c;
            button.setOpaque(false);
            button.setBorder(new EmptyBorder(5, 15, 5, 15));
        }
    
        @Override
        public void paint (Graphics g, JComponent c) {
            AbstractButton b = (AbstractButton) c;
            paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
            super.paint(g, c);
        }
    
        public void paintBackground (Graphics g, JComponent c, int yOffset) {
            Dimension size = c.getSize();
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(c.getBackground().darker());
            g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 1);
            g.setColor(c.getBackground());
            g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 2, 10, 1);
        }
        
    }


    private class ImageRender extends DefaultTableCellRenderer{

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            // TODO Auto-generated method stub
            String phtoname = value.toString();
            ImageIcon icon = new ImageIcon(
                new ImageIcon("images/" + phtoname).getImage()
            );

            return new JLabel(icon);
        }
        
    }

    






    //----------------------------------------------LOGIC-----------------------------------------------------------------------------










    public class addListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            
            //DO SOMETHING
            //equi = new addEquipmentUI(controller, me);
     
        }
    }

    public void updateTable()
    {
    
        ArrayList<Equipment> equipments = new ArrayList<Equipment>();
        equipments = dbController.getEquipments();
        totalLabel.setText("Total:"+Integer.toString(equipments.size()));
        controller.updateTable(table);
        for(Equipment eq : equipments)
        {
            controller.addToTable(eq);
            mostrecent = eq.getID() + 1;
        }


    }





    public class filtListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            
            //DO SOMETHING
            //controller.addToTable();
     
        }
    }



    public class okListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean yesselect = false;

            int selectedOption = JOptionPane.showConfirmDialog(null, 
                                  "Are you sure?", 
                                  "Choose", 
                                  JOptionPane.YES_NO_OPTION); 
            if (selectedOption == JOptionPane.YES_OPTION) {
                yesselect = true;}
            
            
            if (yesselect)
            {
                String name = itemName.getText();
                String quantit = quantity.getText();
                String pric = valueinput.getText();
            

                if(controller.validateDetails(quantit, pric))
                {
         
                    controller.iD = mostrecent;
                    controller.itemName = name;
                    controller.quantit = quantit;
                    controller.pric = pric;
                   Equipment equipment = controller.createNewEquipment();
                    mostrecent+=1;

                    controller.addToTable(equipment);
                    controller.saveEquipment(equipment);
                    saveSuccesful();
        
                    
                    

                }
                else
                {
                    errorMessage();
                }
            }
    

     
        }
    }

    public void errorMessage()
    {
        JFrame f = new JFrame();
        JOptionPane.showMessageDialog(f, "Incorrect input,Please try again!");

    }

    public void saveSuccesful()
    {
        JFrame f = new JFrame();
        JOptionPane.showMessageDialog(f, "Save Successful");

    }

    public void updateSuccesful()
    {
        JFrame f = new JFrame();
        JOptionPane.showMessageDialog(f, "Update Successful");

    }
   

  
    
}
