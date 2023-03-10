package UserInteraction;
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
import ApplicationCore.*;
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

import ApplicationCore.FilterController;
import ApplicationCore.Querydetails;
import ApplicationCore.*;
import users.*;
import java.awt.*;
import UserInteraction.*;
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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.font.*;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.sql.*;
import java.util.logging.*;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.font.TextAttribute;

public class PatientListingUI extends JPanel{
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
    protected JTextField priceinput;
    protected JTextField dateinput;
    protected JDatePickerImpl datePicker;
    protected JLabel titleinfo;
    protected JTable table;
    protected JComboBox valueinput3;
    protected JTextField valueinput;
    protected DefaultTableModel model;
    protected DefaultTableModel model2;
    protected int please;
    protected JPanel listPanel;
    protected boolean onmain = true;
    protected JLabel contact;



    public JPanel patientinfo;
    public JPanel chart;
    public JPanel tbl2;
    public JPanel tbl;
    public JPanel listPanelmain;
    public UserLoginUI entry;
    public boolean update = false;
    PatientAdmissionUI rec;
    JFrame frame;
    public FilterController listcontrol;
    public PatientListingUI(UserLoginUI entry)
    {
        this.entry = entry;
        listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        listPanel = new JPanel();
        listPanel.setLayout(new BorderLayout());
        listPanel.setBounds(25, 115, 1450, 650);
        listPanel.setBackground(Color.white);

        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(null);
        filterPanel.setBounds(25, 0, 1450, 100);
        filterPanel.setBackground(Color.white);

        JLabel filterlabel = new JLabel("Filter:");
        filterlabel.setBounds(600, 40, 125, 40);
        filterlabel.setFont(new Font("Serif", Font.PLAIN, 40));
        filterPanel.add(filterlabel);

        JLabel baseLabel = new JLabel("Patient Database");
        baseLabel.setBounds(20, 10, 600, 40);
        baseLabel.setFont(new Font("Serif", Font.PLAIN, 50));
        filterPanel.add(baseLabel);
        

        JButton OK = new JButton("Search");
        OK.setBounds(1320, 40, 120, 35);
        OK.setBackground(Color.decode("#54aeef"));
        OK.setFont(new Font("Serif", Font.BOLD, 18));
        OK.setBorderPainted(false);
        OK.setFocusPainted(false);
        OK.setForeground(Color.WHITE);
        OK.setUI(new StyledButtonUI());
        OK.addActionListener(new filtListener());
        filterPanel.add(OK);

        JLabel valuee = new JLabel("Value");
        valuee.setBounds(1200, 5, 125, 40);
        valuee.setBackground(Color.BLUE);
        valuee.setFont(new Font("Serif", Font.PLAIN, 17));
        filterPanel.add(valuee);

      
        valueinput=new JTextField();
        valueinput.setBackground(Color.WHITE);
        valueinput.setBounds(1170, 50, 125, 25);
        filterPanel.add(valueinput);

   

        JLabel con = new JLabel("Condition");
        con.setBounds(1000, 5, 125, 40);
        con.setFont(new Font("Serif", Font.PLAIN, 17));
        con.setBackground(Color.BLUE);
        filterPanel.add(con);

        String group3[]={" ", "=", "<", ">"};        
        valueinput3=new JComboBox(group3);
        valueinput3.setRenderer(listRenderer); 
        valueinput3.setBackground(Color.WHITE);
        valueinput3.setBounds(970, 50, 125, 25);
        filterPanel.add(valueinput3);
        
  

     

        JLabel field = new JLabel("Field Name");
        field.setBounds(800, 5, 125, 40);
        field.setFont(new Font("Serif", Font.PLAIN, 17));
        field.setBackground(Color.BLUE);
        filterPanel.add(field);

        String group4[]={" ","Name","Doctor","Blood Group","Amount Paid","Gender"};        
        valueinput5=new JComboBox(group4);
        valueinput5.setRenderer(listRenderer); 
        valueinput5.setBackground(Color.WHITE);
        valueinput5.setBounds(770, 50, 125, 25);
        filterPanel.add(valueinput5);

    

       
        
    

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
        
           String[] coloumnNames = {"ID", "Name", "Doctor", "Blood Group", "Amount Paid","Gender", "Date"};
            model2 = new DefaultTableModel(coloumnNames, 0){

            @Override
            public boolean isCellEditable(int row, int column) {       
                return false; // or a condition at your choice with row and column
            }
         };
        table3 = new JTable(model2);

        table3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
               if (me.getClickCount() == 2) {     // to detect doble click events
                  JTable target = (JTable)me.getSource();
                  int row = target.getSelectedRow(); // select a row
                  //createChart(row);
               }
            }
         });

   
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
        JLabel totalLabel = new JLabel("Total:"+Integer.toString(entry.patients.size()+1));
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

       SwingUtilities.invokeLater(() -> {
        Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
        attributes.put(TextAttribute.TRACKING, 0.03);

        baseLabel.setFont(baseLabel.getFont().deriveFont(attributes));
        filterlabel.setFont(filterlabel.getFont().deriveFont(attributes));
        totalLabel.setFont(totalLabel.getFont().deriveFont(attributes));
        totalLabel.setFont(totalLabel.getFont().deriveFont(attributes));
    });

    listcontrol = new FilterController(model2, entry);
    entry.getPatients();

    

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









    //----------------------------------------------LOGIC-----------------------------------------------------------------------------
















    public class filtListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            
            //DO SOMETHING
            Querydetails qdetails = new Querydetails( (String)valueinput3.getSelectedItem(), (String)valueinput5.getSelectedItem(),valueinput.getText());
            listcontrol.filterResults(qdetails);
     
        }
    }

   

  
    
}
