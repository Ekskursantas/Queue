/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.algorithm.examples.queues;
import dk.cphbusiness.airport.template.Passenger;
import java.util.NoSuchElementException;

/**
 *
 * @author przyg
 */
public class SimplePriorityQueue implements PriorityQueue<Passenger>{

    private Passenger[] data; 
    private int size = 0;
    public SimplePriorityQueue(int capacity) {
        data = new Passenger[capacity];
    }
    private int childOf(int p){ return p/2;}
    private int leftOf(int p){return p*2;}
    private int rightOf(int p){return p*2+1;}
    @Override
    public void enqueue(Passenger item) {
        int p = ++size;
        while (true){
            data[p] = item;
            int pp = childOf(p);
            if(pp==0 || data[p].compareTo(data[pp])>0) return;
            data[0]=data[pp];
            data[pp]=data[p];
            data[p]=data[0];
            p = pp;
        }
    }

    @Override
    public Passenger dequeue() {
        if(size == 0) throw new NoSuchElementException();
        Passenger result = data[1];
        int p = 1;
        int l = leftOf(p);
        int r = rightOf(p);
        return data[1];
    }

    @Override
    public Passenger peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
