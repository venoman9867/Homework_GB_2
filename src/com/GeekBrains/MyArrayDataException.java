package com.GeekBrains;

public class MyArrayDataException extends Throwable {
    private int i;
    private int j;
    public MyArrayDataException(int i, int j) {
        this.i=i;
        this.j=j;
    }

    public void print() {System.out.println("Неверный формат данных! "+i+" "+j);}
}
