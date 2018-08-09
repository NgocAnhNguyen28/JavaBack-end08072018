/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapbuoi9;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NgocAnh
 */
public class MultiThreading {

    /**
     * @param args the command line arguments
     *  obj cua class Class BTVN: viet chuong trinh co 3 thread Thread A sinh ra 1 so
     * A ngau nhien Thread B sinh ra 1 so B ngau nhien Thread C tinh tong A+B neu có
     * the thì làm đồng bộ, ko thì làm như bình thường mỗi thread in 100 số
     */
    public static void main(String[] args) {
       SoNgauNhien1 numberA = new SoNgauNhien1();
       Thread thread1 = new Thread(numberA);
       thread1.start();
       SoNgauNhien2 numberB = new SoNgauNhien2();
       Thread thread2 = new Thread(numberB);
       thread2.start();
       Thread thread3 = new Thread(new Runnable() {
           @Override
           public void run() {
               for (int i = 0; i < 100; i++) {
                   try {
                       
                       int c = numberA.getA()+ numberB.getB();
                       System.out.print("c: " + c);
                       Thread.sleep(20);
                   }catch (InterruptedException ex) {
                       Logger.getLogger(MultiThreading.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
           }
       });
        thread3.start();
        

    }
       
       
    
    
}
