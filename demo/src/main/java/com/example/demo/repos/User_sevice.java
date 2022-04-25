package com.example.demo.repos;

import com.example.demo.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User_sevice
{
    @Autowired private DbRepo repo;

    public List<UserEntity> listall()
    {
        return(List<UserEntity>) repo.findAll();
    }
    public void add(UserEntity user)
    {
        repo.save(user);
    }
    public void delete(UserEntity user){
        repo.delete(user);
    }
    public UserEntity get_by_ID(int id)
    {
        UserEntity user=new UserEntity();
        List<UserEntity> users=listall();
        for (int i=0;i<users.size();i++)
        {
            if (users.get(i).getUserdId()==id)
            {
                user= users.get(i);
            }
        }
        return user;
    }
    public int get_ID(){
        int id=1;
        List<UserEntity> users=listall();
        for (int i=0;i<users.size();i++)
        {
            if (id<users.get(i).getUserdId())
            {
                id  = users.get(i).getUserdId();
            }
        }
        id=id+1;
        return id;
    }
}
