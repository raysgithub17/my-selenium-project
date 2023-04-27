package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;
public class Day7Test3 {
    Scanner sc = new Scanner(System.in);
    int a = 20;
    int b = 10;
    int c;
    @Test(priority = 1)
    public void add(){
        c=a+b;
        Assert.assertEquals(c,30);
    }
    @Test(priority = 2)
    public void sub(){
        c=a-b;
        Assert.assertEquals(c,10);
    }
    @Test(priority = 5)
    public void mul(){
        c=a*b;
        Assert.assertEquals(c,200);
    }
    @Test(priority = 4)
    public void div(){
        c=a/b;
        Assert.assertEquals(c,2);
    }
}
