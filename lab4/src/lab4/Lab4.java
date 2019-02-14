/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author apple
 */
public class Lab4 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //task 1.a put the speech of Cicero in a String array
        String path ="//Users//apple//Desktop//AD//labs//speech.txt";
        String delimiter = " ";
        String[] speech = TextReader.readFromFile(path, delimiter);

        //task 1.b put the keys and list of occurrences in the BST
        BST<String, List<Integer>> bstSpeech = new BST<String, List<Integer>>();
        for (int i = 0; i < speech.length; i++) {
            //Create a list of occurrences in the text as values
            List<Integer> occurrences = new ArrayList<Integer>();
            //Check if there exists a same key 
            if (bstSpeech.get(speech[i]) == null) {
                occurrences.add(i);
            } else {
                bstSpeech.get(speech[i]).add(i);
                occurrences = bstSpeech.get(speech[i]);
            }
            bstSpeech.put(speech[i], occurrences);
        }

        //task 1.c  put out the word index in an alphabetical order
        System.out.println("Cicero's first speech against Catiline - Index");

        String key;
        List<Integer> value;
        int occurrences = 0;
        Iterator iterator = bstSpeech.iterator();
        Stack<String> keys = new Stack<String>();
        Heap<Node<String, Integer>> priorityQueue = new Heap<>(105);

        while (iterator.hasNext()) {
            key = iterator.next().toString();
            keys.push(key);
            value = bstSpeech.get(key);
            occurrences = value.size();

            System.out.println(key + ":" + value);

            //task 2.b map words and the number of occurrences in a heap
            priorityQueue.insert(new Node<String, Integer>(key, occurrences));
        }

        //print out the number of keys and the depth of BST
        System.out.println("\nThe total number of keys in this BST: " + keys.size());
        System.out.println("The depth of this BST: " + bstSpeech.depth() + "\n");

        //task 2.c print out three most occuring words in order
        for (int i = 1; i < 4; i++) {
            Node max = priorityQueue.getMax();
            System.out.println("No " + i + ". '" + max.getKey() + "' Occurrences: " + max.getOccrrences());
        }
    }
}
