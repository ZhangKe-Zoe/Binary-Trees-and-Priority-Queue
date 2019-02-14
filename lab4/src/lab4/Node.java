/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author myego
 */
public class Node<Word, Occurrences extends Comparable<Occurrences>> implements Comparable<Node> {

    Word word;
    Occurrences occrrences;

    public Node( Word word, Occurrences occrrences) {
        this.word = word;
        this.occrrences = occrrences;
        
    }

    @Override
    public int compareTo(Node compareNode) {
        if (this.occrrences.getClass().equals(compareNode.occrrences.getClass())) {
            return this.occrrences.compareTo((Occurrences) compareNode.occrrences);
        }
        return -255;
    }

    public Word getKey() {
        return word;
    }
    
    public Occurrences getOccrrences() {
        return occrrences;
    }
}

