package pl.javakurselo;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            try{
                new LoginFrame();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
