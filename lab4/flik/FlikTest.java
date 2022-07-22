package flik;

import org.junit.*;

public class FlikTest {

    @Test
    public void test1(){
        int a=2;
        int b=2;
        System.out.println(Flik.isSameNumber(a,b));
        Assert.assertTrue(Flik.isSameNumber(a,b));
    }
    @Test
    public void test2(){
        Integer a= 10;
        Integer b= 10;
        System.out.println(Flik.isSameNumber(a,b));
        Assert.assertTrue(Flik.isSameNumber(a,b));
    }
    @Test
    public void test3(){

        Assert.assertFalse(Flik.isSameNumber(10,null));
        Assert.assertFalse(Flik.isSameNumber(null,10));
        Assert.assertTrue(Flik.isSameNumber(null,null));
    }


}
