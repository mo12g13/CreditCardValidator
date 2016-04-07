package com.Momo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Momo Johnson on 3/31/2016.
 */
public class CreditCardValidator extends JFrame{
    private JTextField VisaCardNumber;
    private JButton validateButton;
    //private JButton validOrNotValidButton;
    private JPanel rootPanel;
    private JButton quitButton;
    private JTextField cardValidOrNotValid;

    CreditCardValidator(){
        super("Credit Card Validator");
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(400,175));
        cardValidOrNotValid.setPreferredSize(new Dimension(20, 40));
        VisaCardNumber.setPreferredSize(new Dimension(100, 400));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        cardValidOrNotValid.setText("Your card is: ");
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cardText = VisaCardNumber.getText();
                boolean valid = isCreditCardVailid(cardText);

                if(valid){
                   //cardValidOrNotValid.setText("Credit Card is valid");
                    JOptionPane.showConfirmDialog(rootPanel, "Valid card", "Confirm ", JOptionPane.CLOSED_OPTION);
                }
                else {
                    JOptionPane.showMessageDialog(rootPanel, "Card is not Valid, re-enter number ", "error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    private boolean isCreditCardVailid(String txt){
        if (!txt.startsWith("4") || (txt.length() != 16)){
            System.out.println("Doesnt start with 4 or length wrong");
            return false;
        }

        int sum = 0;

        for (int i = 0; i < 16 ; i++ ) {
            int thisDigit = Integer.parseInt((txt.substring(i, i+1)));
            if (i % 2 == 1) {
                sum = sum + thisDigit;
            } else {
                int doubled = thisDigit * 2;
                if (doubled > 9 ) {
                    int toAdd = 1 + (doubled % 10);
                    sum = sum + toAdd;
                } else {
                    sum = sum + (thisDigit * 2);
                }
            }
        }

        if (sum % 10 == 0) {
            return true;
        }

        return false;

    }


}


