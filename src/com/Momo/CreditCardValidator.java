package com.Momo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Momo Johnson on 3/31/2016.
 */
public class CreditCardValidator extends JFrame{
    private JTextField VisaCardNumber;
    private JButton validateButton;
    private JButton validOrNotValidButton;
    private JPanel rootPanel;
    private JButton quitButton;

    CreditCardValidator(){
        super("Credit Card Validator");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cardText = VisaCardNumber.getText();
                boolean valid = isCreditCardVailid(cardText);
                if(valid){
                    validOrNotValidButton.setText("Credit Card is valid");
                }
                else {
                    validOrNotValidButton.setText("Credit card is not valid");
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


