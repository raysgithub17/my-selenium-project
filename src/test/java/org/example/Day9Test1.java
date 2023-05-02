package org.example;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day9Test1 {
    @Test(dataProvider = "dp")
    public void add(Integer n, Integer m) {
        System.out.println(n+m);
        if(n==10 && m==2) {
            Assert.assertEquals(12, n + m);
            System.out.println("Success");
        }
        else if(n==9 && m==3){
            Assert.assertEquals(12,n+m);
            System.out.println("Success");  
        }
    }

    @Test(dataProvider = "dp")
    public void sub(Integer n, Integer m) {
        System.out.println(n-m);
        if(n==10 && m==2) {
            Assert.assertEquals(8, n - m);
            System.out.println("Success");
        }
        else if(n==9 && m==3){
            Assert.assertEquals(6,n-m);
            System.out.println("Success");
        }
        
    }

    @Test(dataProvider = "dp")
    public void mul(Integer n, Integer m) {
        System.out.println(n*m);
        if(n==10 && m==2) {
            Assert.assertEquals(20, n * m);
            System.out.println("Success");
        }
        else if(n==9 && m==3){
            Assert.assertEquals(27,n*m);
            System.out.println("Success");
        }

    }

    @Test(dataProvider = "dp")
    public void div(Integer n, Integer m) {
        System.out.println(n/m);
        if(n==10 && m==2) {
            Assert.assertEquals(5, n / m);
            System.out.println("Success");
        }
        else if(n==9 && m==3){
            Assert.assertEquals(3,n/m);
            System.out.println("Success");
        }
    }
    @DataProvider
    public Object[][] dp() {
        return new Object[][] {
                new Object[] {10,2},
                new Object[] {9,3},
        };
    }
}
