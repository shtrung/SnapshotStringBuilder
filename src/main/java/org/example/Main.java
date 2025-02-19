package org.example;

/**
  Пример использования
 */
public class Main {
    public static void main(String[] args) {
       SnapshotStringBuilder builder = new SnapshotStringBuilder();

       System.out.printf("Добавляем строку: %s%n",builder.append("Hello "));
       System.out.printf("Добавляем строку: %s%n",builder.append("World"));
       System.out.printf("Делаем шаг назад: %s%n",builder.undo());
       System.out.printf("Добавляем строку: %s%n",builder.append("World"));
       System.out.printf("Удаляем строку: %s%n",builder.delete(0, builder.length()));
       System.out.printf("Делаем шаг назад: %s%n",builder.undo());
       System.out.printf("Разворачиваем строку: %s%n",builder.reverse());
       System.out.printf("Удаляем строку: %s%n",builder.delete(0, builder.length()));
       System.out.printf("Делаем 2 шага назад: %s%n",builder.undo(2));
    }
}