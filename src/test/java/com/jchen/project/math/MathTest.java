//package com.jchen.project.math;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.jchen.project.math.Prime;

public class MathTest {

    private int[] primeNumbers = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};

    @Before
    public void setUp(){
        for(int num: primeNumbers){
        }
    }

    @Test
    public void PrimeTest(){
        Prime prime = new Prime();
        /*
        boolean status ;
        int size = primeNumbers.length;

        status  = prime.isPrime(3);
        assertTrue(status);
        status  = prime.isPrime(3);
        assertFalse(status);

        int primeNum = prime.highPrime(primeNumbers[size]);
        assertEquals(primeNumbers[size],primeNum);
        primeNum = prime.highPrime(primeNumbers[size/2]);
        assertEquals(primeNumbers[size/2],primeNum);


        int[] primeArr = prime.getAllPrime(primeNumbers[0],primeNumbers[size]);
        assertArrayEquals(primeNumbers,primeArr);
        */
    }
}
