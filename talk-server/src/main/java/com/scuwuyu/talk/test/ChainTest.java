package com.scuwuyu.talk.test;

/**
 * Created by wuyu on 2018/9/10.
 */
public class ChainTest {

    private static final User head = new User("head");
    private static final User tail = new User("tail");


    public static void main(String[] args) {
        head.next = tail;
        tail.prev = head;
        User user1 = new User("1");
        User user2 = new User("2");
        User user3 = new User("3");
        addLast(user1);
        addLast(user2);
        addLast(user3);

        /** 反转 */
        rovert();

        User user = head;

        do {
            System.out.println("user="+user);
            user = user.next;
        }
        while (user!=null);

    }

    private static void rovert() {
        User prev = head.prev;
        User current = head;
        User next = head.next;
        while (next !=null){
            current.prev = next;
            current.next = prev;

            current = next;
            prev = next.prev;
            next.prev = null;
            next = next.next;
        }
    }

    private static void addfast(User user1) {
        User next = head.next;
        user1.next = next;
        user1.prev = head;

        head.next = user1;
        next.prev = user1;
    }

    private static void addLast(User user1) {
        User prev = tail.prev;
        user1.next = tail;
        user1.prev = prev;

        tail.prev = user1;
        prev.next = user1;
    }
}
