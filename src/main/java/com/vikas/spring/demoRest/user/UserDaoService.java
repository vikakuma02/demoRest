package com.vikas.spring.demoRest.user;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static final Logger LOG = LoggerFactory.getLogger(UserDaoService.class);
    private static List<User> users= new CopyOnWriteArrayList<>();
    private static int userCount=3;

    static {
        users.add(new User(1,"Vikas",new Date()));
        users.add(new User(2,"Anjali",new Date()));
        users.add(new User(3,"Aashi",new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if (user.getId()==null){
            user.setId(++userCount);
        }

        users.add(user);
        return user;
    }

    public User findOne(int id){
        for (User user: users){
            if (user.getId()==id){
                LOG.info("ID found");
                return user;
            }
        }
        LOG.info("ID not found");
        return null;
    }

    public User delete(String name){
     for (User user: users){
         if (user.getName().equalsIgnoreCase(name)){
             LOG.info("Delete the user");
             users.remove(user);
         }
     }
        return null;
    }


    public User deleteById(int id){
        Iterator<User> iterator=users.iterator();
        while (iterator.hasNext()){
            User user=iterator.next();
            if (user.getId() == id){
                iterator.remove();

            }
        }

        return null;
    }
}
