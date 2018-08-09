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
public class SoNgauNhien1 extends Thread{
    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
    
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            try {
                //Random soNgauNhien = new Random();
                //this.a= soNgauNhien.nextInt(50);
                this.a = new Random().nextInt(50);
                System.out.println("a:"+ this.a +"\t");
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(SoNgauNhien1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
