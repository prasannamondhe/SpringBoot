package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Prasanna.Mondhe on 12/24/2018.
 */

@Component
public class UserService {

    public static ArrayList<HelloBean> users = new ArrayList<>();
    public int count;

    static {
        users.add(new HelloBean(1,"Don",1211));
        users.add(new HelloBean(2,"Gon",1212));
        users.add(new HelloBean(3,"Bon",1213));
    }

    public List<HelloBean> getAllUser(){
        return users;
    }

    public HelloBean findOne(int id){
        for(HelloBean helloBean:users){
            if(helloBean.getNumber() == id){
                return helloBean;
            }
        }
        return null;
    }

    public HelloBean save(HelloBean helloBean){
        if(helloBean.getNumber() == null){
            helloBean.setNumber(++count);
        }
        users.add(helloBean);
        return helloBean;
    }

    public HelloBean deleteOne(Integer id){
        Iterator<HelloBean> helloBeanIterator = users.iterator();
        while (helloBeanIterator.hasNext()){
            HelloBean helloBean = helloBeanIterator.next();
            if (helloBean.getNumber() == id){
                helloBeanIterator.remove();
                return helloBean;
            }
        }
        return null;
    }

}
