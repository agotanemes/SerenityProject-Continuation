package test;


import org.testng.annotations.Test;

public class FirstTestCase {
    //daca nu le pun prioritate si le execut pe toate,se executa in ordine alfabetica
    @Test(priority = 1)
    void setup(){
        System.out.println("opening browser");
    }
    @Test(priority = 2)
    void login(){
        System.out.println("Login test");
    }
    @Test(priority = 3)
    void teardown(){
        System.out.println("closing the browser");
    }
}
