package com.example.demo.repos;

import com.example.demo.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface DbRepo extends CrudRepository<UserEntity,Long>
{

}
