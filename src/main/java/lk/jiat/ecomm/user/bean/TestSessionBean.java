package lk.jiat.ecomm.user.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.PostActivate;
import jakarta.ejb.PrePassivate;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import lk.jiat.ecomm.user.remote.TestRemote;

@Stateful
public class TestSessionBean implements TestRemote {

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

    @Override
    public String test() {

        i++;

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        return "TestSessionBean: test"+i;
    }
}