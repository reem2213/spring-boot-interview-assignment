package com.example.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.backend.Model.Item;
import com.example.backend.Repo.ItemRepo;

@Service
public class ItemServices {


    @Autowired


    private ItemRepo repo;


    public void saveOrUpdate(Item items){
        repo.save(items);
    }


    public Iterable<Item>listAll(){
        return repo.findAll();
    }
    

    public void deleteItem(String id){
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item having ID " + id + " not found");
        }
        repo.deleteById(id);
    }

    public Item getItemById(String itemId){
        if (!repo.existsById(itemId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item having ID " + itemId + " not found!");
        }
        return repo.findById(itemId).get();

    }
}


