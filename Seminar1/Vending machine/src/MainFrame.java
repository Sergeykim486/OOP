import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import Domen.Product;
import vendingmachines.VendingMachine;
import Domen.Bottle;
import Domen.HotDrink;

public class MainFrame extends JFrame {

    final private static Font mainFont = new Font("Arial", Font.BOLD, 18);
    JTextField tfFirstName, tfLastName;

    JLabel lbWelcome;

    VendingMachine machine = new VendingMachine(100);
    static JLabel addlabel(String name) {
        JLabel label = new JLabel(name);
        label.setFont(mainFont);
        return label;
    }
    static JTextField addfield() {
        JTextField tfFirstName = new JTextField();
        tfFirstName.setFont(mainFont);
        return tfFirstName;
    }

    JTextArea ProductList;

    public void initialize() {

        JLabel LId = addlabel("Product id");
        JTextField TId = addfield();
        JLabel LName = addlabel("Product name");
        JTextField TName = addfield();
        JLabel LCategory = addlabel("Category");
        JTextField TCategory = addfield();
        JLabel LPrice = addlabel("Price");
        JTextField TPrice = addfield();
        JLabel LVol = addlabel("Volium");
        JTextField TVol = addfield();
        JLabel LTemp = addlabel("Temperature");
        JTextField TTemp = addfield();

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(8, 1, 5, 5));
        formPanel.add(LId);
        formPanel.add(TId);
        formPanel.add(LName);
        formPanel.add(TName);
        formPanel.add(LCategory);
        formPanel.add(TCategory);
        formPanel.add(LPrice);
        formPanel.add(TPrice);
        formPanel.add(LVol);
        formPanel.add(TVol);
        formPanel.add(LTemp);
        formPanel.add(TTemp);

        ProductList = new JTextArea();
        ProductList.setFont(mainFont);
        ProductList.setLineWrap(true);
        ProductList.setWrapStyleWord(true);

        JButton btnAdd = new JButton("Add product");
        btnAdd.setFont(mainFont);
        btnAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // geting values from fields and converting types
                ProductList.setText("");
                String idText = TId.getText();
                int ProductID = idText.isEmpty() ? 0 : Integer.parseInt(idText);

                String name = TName.getText();
                name = name.isEmpty() ? " " : name;

                String category = TCategory.getText();
                category = category.isEmpty() ? " " : category;

                String priceText = TPrice.getText();
                priceText = priceText.replace(',', '.'); // Замена запятой на точку (если присутствует)
                double price = priceText.isEmpty() ? 0.0 : Double.parseDouble(priceText);

                String volText = TVol.getText();
                int vol = volText.isEmpty() ? 0 : Integer.parseInt(volText);

                String tempText = TTemp.getText();
                int temp = tempText.isEmpty() ? 0 : Integer.parseInt(tempText);

                // inserting product in machine
                if (vol > 0) {
                    try {
                        Bottle prod = new Bottle(ProductID, name, category, price, vol);
                        machine.addProduct(prod);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                else if (temp > 0) {
                    try {
                        HotDrink prod = new HotDrink(ProductID, name, category, price, temp);
                        machine.addProduct(prod);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                else {
                    try {
                        Product prod = new Product(ProductID, name, category, price);
                        machine.addProduct(prod);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                for (Product prod: machine.getProducts()) {
                    ProductList.append(prod.toString() + "\n");
                }
                // clear the fields
                TId.setText("");
                TName.setText("");
                TCategory.setText("");
                TPrice.setText("");
                TVol.setText("");
                TTemp.setText("");
            }

        });

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                TId.setText("");
                TName.setText("");
                TCategory.setText("");
                TPrice.setText("");
                TVol.setText("");
                TTemp.setText("");

            }

        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5));
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnClear);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(200, 200, 200));

        mainPanel.add(formPanel, BorderLayout.NORTH);

        mainPanel.add(ProductList, BorderLayout.CENTER);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setOpaque(false);
        buttonPanel.setOpaque(false);

        setTitle("VendingMachines");
        setSize(500, 650);
        setMaximumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] arg) {
        MainFrame myFrame = new MainFrame();
        myFrame.initialize();
    }

}