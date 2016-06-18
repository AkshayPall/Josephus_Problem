//Created by Akshay Pall
//June-18-2016

import java.io.*;
import java.util.*;

public class Solution
{

    //this is a solution to the Josephus problem
    //in which n people form a a circle a every kth
    //person is removed. The goal is to determine
    //who will be the last to be removed
    //
    //This implementation uses queues in linked lists

    static Person head = null;
    static Person tail = null;

    public static void main (String[] args)
    {
        Scanner in = new Scanner (System.in);
        int n = in.nextInt (); //size of circle
        int k = in.nextInt (); //every kth person to remove

        if (n < 1 || k < 1) {
		System.out.println("Positive integers only");
	} else {
		System.out.println (n + " People, remove every " + k + " steps");
        	solve (n, k);
	}

    }


    static void solve (int n, int k)
    {
        Person position; //current position

        for (int i = 1 ; i <= n ; i++)
        {
            Person.enqueue (i);
            //i represents each person
            //(to deermine the person
            //left in the circle)
        }

        tail.next = head;
        position = tail;

        while (position.next != position)
        {
            for (int j = 1 ; j < k ; j++)
            {
                //iterate positions through
                //the list
                position = position.next;
            }

            //skip over the next (kth) position
            //as though to remove that person
            //from the circle
            position.next = position.next.next;
        }

        System.out.println (position.value);
    }


    public static class Person
    {
        Person next = null;
        int value = 0;

        Person ()
        {
        }

        static void enqueue (int x)
        {
            //adding a pointer to the tail of
            //the queue

            Person curr = new Person ();
            curr.value = x;
            //curr.next is already set as null

            if (head == null)
            {
                head = curr;
            }
            else
            {
                tail.next = curr;
            }

            tail = curr;
        }

        static int dequeue ()
        {
            //removing the pointer from the
            //head of the queue

            Person curr = head;
            int x = curr.value;
            head = curr.next;
            if (head == null)
            {
                tail = null;
            }

            return x;
        }
    }
}



