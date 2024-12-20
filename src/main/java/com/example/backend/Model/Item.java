package com.example.backend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;

@Document(collection = "items")
public class Item {

    @Id
    private String _id;

    @NotNull(message = "Name cannot be null")
    private String name;
    
    private String description;

    public Item(String _id, String name, String description) {
        this._id = _id;
        this.name = name;
        this.description = description;
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "Item [_id=" + _id + ", name=" + name + ", description=" + description + "]";
    }


    
    
}
