/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.kanan.batterystat;

import az.kanan.batterystat.frame.MainFrame;
import az.kanan.batterystat.task.RunInBackground;

/**
 *
 * @author Kanan
 */
public class main {

    public static void main(String[] args) {
        Thread t = new Thread(new RunInBackground());
        t.start();

        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }

}
