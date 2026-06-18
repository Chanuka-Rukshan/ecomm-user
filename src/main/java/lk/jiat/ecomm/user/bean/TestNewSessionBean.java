package lk.jiat.ecomm.user.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.PostActivate;
import jakarta.ejb.PrePassivate;
import jakarta.ejb.Remove;
import jakarta.ejb.Stateful;
import lk.jiat.ecomm.user.remote.TestRemote;

@Stateful
public class TestNewSessionBean implements TestRemote {

    int i;

    @PostConstruct
    public void init(){
        System.out.println("TestSessionBean init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("TestSessionBean destroy");
    }

    @PostActivate
    public void postActive(){
        System.out.println("TestSessionBean postActive");
    }

    @PrePassivate
    public void preActivate(){
        System.out.println("TestSessionBean preActivate");
    }

    @Remove
    public void remove(){
        System.out.println("TestSessionBean removed...");
    }

    @Override
    public String test() {

        i++;
        System.out.println("TestSessionBean test...");

        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        return "TestSessionBean: test"+i;
    }
}