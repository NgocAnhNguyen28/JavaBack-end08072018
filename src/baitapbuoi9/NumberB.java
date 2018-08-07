/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapbuoi9;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NgocAnh
 */
public class NumberB extends Thread{
    
    private int b;

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            try {
                Random soNgauNhien = new Random();
                this.b =soNgauNhien.nextInt(50);
                System.out.println("b:"+ this.b+"\t");
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(NumberB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
