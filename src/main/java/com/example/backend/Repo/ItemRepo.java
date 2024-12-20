package com.example.backend.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.backend.Model.Item;

public interface ItemRepo extends MongoRepository<Item,String>{
    
}
