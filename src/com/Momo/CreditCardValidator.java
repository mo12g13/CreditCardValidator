package com.Momo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Momo Johnson on 3/31/2016.
 */
public class CreditCardValidator extends JFrame{
    private JTextField VisaCardNumber;//visaNumber variable textField
    private JButton validateButton;//The Validate button

    private JPanel rootPanel;// the rootPanel
    private JButton quitButton;//The exit button
    private JTextField cardValidOrNotValid;//Test field where message appear if credit card is valid or not valid
    //Constructor of the credit card validator
    CreditCardValidator(){
        super("Credit Card Validator");//Title of the window
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(400,175));//Size of the window
        cardValidOrNotValid.setPreferredSize(new Dimension(20, 40));//Size of the creditValidOrNotvalid button
        VisaCardNumber.setPreferredSize(new Dimension(100, 400));//Size of the visaCardNumber button
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        cardValidOrNotValid.setText("Your card is: ");//Text that is set in the cardalidOrNotValide. It is a default text
        //Action listner for the validate button
        validateButton.addActionListener(new ActionListener() {
            @Override
            //Action performed for the validateButton
            public void actionPerformed(ActionEvent e) {
                String cardText = VisaCardNumber.getText();
                boolean valid = isCreditCardVailid(cardText);

                if(valid){
                //If card is valid, display the Confirmation dialog box stating that card is vaild, title should be called Confirm
                    JOptionPane.showConfirmDialog(rootPanel, "Valid card", "Confirm ", JOptionPane.CLOSED_OPTION);
                }
                else {
                    //If card isn't valid, show and error dialog box asking the user to re-enter the number.
                    //Title of dialog box is error
                    JOptionPane.showMessageDialog(rootPanel, "Card is not Valid, re-enter number ", "error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        //Action listner for the quitbutton
        quitButton.addActionListener(new ActionListener() {
            @Override
            //Action performed for the quitButton. Action to performed is to end the window when clicked
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    //A method that checks to see if a visa card is valid or not valid
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


