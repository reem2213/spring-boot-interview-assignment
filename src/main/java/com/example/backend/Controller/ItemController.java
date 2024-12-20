package com.example.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.Model.Item;
import com.example.backend.Service.ItemServices;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
public class ItemController {


    @Autowired
    private ItemServices itemServices;



    @PostMapping(value = "/items")
    public String postItem(@Valid @RequestBody Item items) {
        itemServices.saveOrUpdate(items);
        return items.get_id();
    }


    @GetMapping(value ="/items")
    private Iterable<Item> getItems() {
        return itemServices.listAll();
    }

    @PutMapping( value = "/items/{id}")
    public Item update(@PathVariable (name = "id") String _id, @Valid @RequestBody Item item) {
        item.set_id(_id);
        itemServices.saveOrUpdate(item);        
        return item;
    }


    @DeleteMapping("/items/{id}")
    private void deleteItem(@PathVariable ("id")String _id){
        itemServices.deleteItem(_id);

    }

    @RequestMapping("/items/{id}")
    public Item getItems(@PathVariable(name = "id") String itemId) {
        return itemServices.getItemById(itemId);
    }
    
    
    

    
}
