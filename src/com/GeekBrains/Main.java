package com.GeekBrains;

public class Main {
    /*1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
    при подаче массива другого размера необходимо бросить исключение MyArraySizeException.

    2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
    Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
    должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.

    3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException,
     и вывести результат расчета.*/

    public static void main(String[] args) {
        String[][] array = new String[][]{{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String[][] array2 = new String[][]{{"1", "2", "3", "4", "5"}, {"1", "2", "3", "4", "5"}, {"1", "2", "3", "4", "5"}, {"1", "2", "3", "4", "5"}};
        try {
            someMethod(array2);
        } catch (MyArraySizeException e) {
            e.print();
        }catch (MyArrayDataException c){
            c.print();
        }

    }

    public static void someMethod(String[][] array) throws MyArraySizeException,MyArrayDataException {
        int sum = 0;
        if (array.length==4) {
            for (String[] stringArray:array){
                if(stringArray.length!=4){
                    throw new MyArraySizeException();
                }
            }
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    try {
                        sum += Integer.parseInt(array[i][j]);
                    }catch (NumberFormatException c){
                        throw new MyArrayDataException(i,j);
                    }
                }
            }
        }else{
            throw new MyArraySizeException();
        }
        System.out.println("Результат расчета: "+ sum);
    }
}
