import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class InventoryItem {
    private String name;
    private int quantity;

    public InventoryItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

public class InventoryManagementSystem extends JFrame {
    private DefaultTableModel tableModel;
    private JTextField nameField;
    private JTextField quantityField;
    private JTable inventoryTable;

    public InventoryManagementSystem() {
        setTitle("Inventory Management System");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tableModel = new DefaultTableModel(new Object[]{"Item Name", "Quantity"}, 0);
        inventoryTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(inventoryTable);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Item Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        panel.add(quantityField);

        JButton addButton = new JButton("Add Item");
        JButton updateButton = new JButton("Update Item");
        JButton deleteButton = new JButton("Delete Item");

        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateItem();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteItem();
            }
        });
    }

    private void addItem() {
        String name = nameField.getText();
        String quantityText = quantityField.getText();
        if (!name.isEmpty() && !quantityText.isEmpty()) {
            try {
                int quantity = Integer.parseInt(quantityText);
                tableModel.addRow(new Object[]{name, quantity});
                nameField.setText("");
                quantityField.setText("");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Quantity must be a number.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in both fields.");
        }
    }

    private void updateItem() {
        int selectedRow = inventoryTable.getSelectedRow();
        if (selectedRow != -1) {
            String name = nameField.getText();
            String quantityText = quantityField.getText();
            if (!name.isEmpty() && !quantityText.isEmpty()) {
                try {
                    int quantity = Integer.parseInt(quantityText);
                    tableModel.setValueAt(name, selectedRow, 0);
                    tableModel.setValueAt(quantity, selectedRow, 1);
                    nameField.setText("");
                    quantityField.setText("");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Quantity must be a number.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in both fields.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select an item to update.");
        }
    }

    private void deleteItem() {
        int selectedRow = inventoryTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
            nameField.setText("");
            quantityField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Select an item to delete.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InventoryManagementSystem ims = new InventoryManagementSystem();
            ims.setVisible(true);
        });
    }
}
