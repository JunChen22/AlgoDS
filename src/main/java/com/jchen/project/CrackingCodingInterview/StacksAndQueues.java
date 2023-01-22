package com.jchen.project.CrackingCodingInterview;

import java.util.LinkedList;
import java.util.Stack;

public class StacksAndQueues {

    public void ThreeinOne() {

    }


    /*
        a stack with min stack as sub class.
     */
    public class StackMin extends Stack<Integer> {
        Stack<Integer> minStack;

        public StackMin() {
            minStack = new Stack<>();
        }

        // keep track of the minium one that is added.
        // it would add to min stack if it's smaller than the current min stack top.
        public void push(int value) {
            if (value <= min()) {
                minStack.push(value);
            }
            super.push(value);
        }

        public Integer pop() {
            int value = super.pop();
            if (value == min()) {
                minStack.pop();
            }
            return value;
        }

        private int min() {
            if (minStack.isEmpty()) {
                return Integer.MAX_VALUE;
            } else {
                return minStack.peek();
            }
        }
    }

    /*
        this is one not good with memory usage when we have large stack. waste a lot of space by keeping tack of the min
        for every single element.
     */
    public class StackMinWithNode extends Stack<NodeWithMin> {
        public void push(int value) {
            int newMin = Math.min(value, min());
            super.push(new NodeWithMin(value, newMin));
        }

        public int min() {
            if (this.isEmpty()) {
                return Integer.MAX_VALUE;
            } else {
                return peek().min;
            }
        }

    }

    public class NodeWithMin {
        public int value;
        public int min;

        public NodeWithMin(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }


    public void StackofPlates() {

    }



    public class QueueStack<T> {
        Stack<T> stackOldest, stackNewest;

        public QueueStack() {
            stackOldest = new Stack<T>();
            stackNewest = new Stack<T>();
        }

        public int size() {
            return stackNewest.size() + stackOldest.size();
        }

        public void add(T value) {
            stackNewest.push(value);
        }

        private void shiftStacks() {
            if (stackOldest.isEmpty()) {
                while (!stackNewest.isEmpty()) {
                    stackOldest.push(stackNewest.pop());
                }
            }
        }

        public T peek() {
            shiftStacks();
            return stackOldest.peek();
        }

        public T remove() {
            shiftStacks();
            return stackOldest.pop();
        }
    }

    public void SortStack() {

    }


    /*
        queue
     */
    public class AnimalShelter {
        LinkedList<Dog> dogs = new LinkedList<Dog>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        private int order = 0;

        public void enqueue(Animal a) {
            a.setOrder(order);
            order++;

            if (a instanceof Dog) dogs.addLast((Dog) a);
            else if (a instanceof Cat) cats.addLast((Cat) a);
        }

        public Animal dequeueAny() {

            if (dogs.size() == 0) {
                return dequeueCats();
            } else if (cats.size() == 0) {
                return dequeueDogs();
            }

            Dog dog = dogs.peek();
            Cat cat = cats.peek();

            if (dog.isOlderThan(cat)) {
                return dequeueDogs();
            } else {
                return dequeueCats();
            }
        }


        public Dog dequeueDogs() {
            return dogs.poll();
        }

        public Cat dequeueCats() {
            return cats.poll();
        }
    }

    abstract class Animal {
        private int order;
        protected String name;
        public Animal(String n) {
            name = n;
        }
        public void setOrder(int ord) {
            order = ord;
        }
        public int getOrder() {
            return order;
        }
        public boolean isOlderThan(Animal a) {
            return this.order < a.getOrder();
        }
    }

    public class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }
    }

    public class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }
    }
}
