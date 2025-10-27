package org.javacourse;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("ABC");
        customLinkedList.add("DEF");
        customLinkedList.add("GHI");
        customLinkedList.addFirst("aaaa");
        System.out.println(customLinkedList.get(3));
        System.out.println(customLinkedList.getLength());
        System.out.println(customLinkedList.getFirst());
        System.out.println(customLinkedList.getLast());
        customLinkedList.remove(2);
        System.out.println(customLinkedList.getLength());
        for (String str : customLinkedList) {
            System.out.println(str);
        }
    }
}