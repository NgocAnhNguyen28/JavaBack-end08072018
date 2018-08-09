/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Synchronous;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NgocAnh
 */
public class Synchronous {
    
     static SoNgauNhien soNgauNhien = new SoNgauNhien(); // 
     static AtomicInteger laCo = new AtomicInteger(0);//laCo la object chung vs 0 la songaunhiena chay 
    //1 la songaunhienb chay
    //2 la tong cua 2 so ngau nhien chay .

    public static void main(String args[]) {
        
       
        Thread thread1 = new Thread(new Runnable() { //khai báo biến mới trong class Thread 
             @Override
             public void run() { // cài đè hàm run trong lúc khai báo// vì chuyền vào 1 object của class Runnable
                 synchronized (laCo) {
                     for (int i = 0; i < 100;) {
                         try {
                             if (laCo.get() == 0) {
                                 soNgauNhien.setA( new Random().nextInt(50));
                                 System.out.println("a"+soNgauNhien.getA());
                                 Thread.sleep(20);
                                 i ++;
                                 //lam xong viec
                                 laCo.set(1);//chuyen co cho thang khac lam
                                 laCo.notifyAll();//danh thuc cac thread khac dang ngu do laCo.waitF
                             } else {
                                 laCo.wait();//obj chung bat thread dung lai
                             }
                         } catch (InterruptedException ex) {
                             Logger.getLogger(Synchronous.class.getName()).log(Level.SEVERE, null, ex);
                         }
                     }
                 }
             }
         });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (laCo) {
                    for (int i = 0; i < 100;) {
                        try {
                            if (laCo.get() == 1) {
                                soNgauNhien.setB(new Random().nextInt(50));
                                System.out.println("b"+ soNgauNhien.getB());
                                Thread.sleep(20);
                                i++;
                                //sau khi xong viec hien thi songaunhienb
                                laCo.set(2);//chuyen co voi gia tri khac de ham khac chay
                                laCo.notifyAll();//danh thuc cac thread khac dang ngu do laCo.waitF
                            } else {
                                laCo.wait();//obj chung bat thread dung lai
                            }
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Synchronous.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }                
                }
            }
        });
        
         Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (laCo) {
                    for (int i = 0; i < 100;) {
                        try {
                            if (laCo.get() == 2) {
                                System.out.println("c"+soNgauNhien.tinhTong());
                                Thread.sleep(20);
                                i++;
                                //lam xong viec
                                laCo.set(0);//chuyen co cho thang khac lam
                                laCo.notifyAll();
                            } else {
                                laCo.wait();
                            }
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Synchronous.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
       
                
                
    }
}



