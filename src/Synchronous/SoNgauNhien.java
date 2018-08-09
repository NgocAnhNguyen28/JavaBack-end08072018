/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Synchronous;

/**
 *
 * @author NgocAnh
 */
class SoNgauNhien {
     private int a;
    private int b;
 
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int tinhTong(){
        int tinhTong = this.getA()+ this.getB();
        return tinhTong;
    }
}
