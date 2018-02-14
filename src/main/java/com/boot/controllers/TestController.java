
package com.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.KeyFactory;

@RestController
@RequestMapping(value = "/test")
public class TestController {
	
	@Autowired
	Datastore datastore;
    
    @RequestMapping("")
    public String ping() {
        return "Welcome to Test Controller of Boot App";
    }
    
    @RequestMapping("/create")
    public Long create() {
    	KeyFactory keyFactory = datastore.newKeyFactory().setKind("Book");
    	IncompleteKey key = keyFactory.newKey();
    	FullEntity<IncompleteKey> incBookEntity = Entity.newBuilder(key).set("name", "Shubham").build();
    	Entity bookEntity = datastore.add(incBookEntity);
    	return bookEntity.getKey().getId();	
    }
    
    @RequestMapping("/get")
    public String get() {
    	KeyFactory keyFactory = datastore.newKeyFactory().setKind("Book");
    	Entity bookEntity = datastore.get(keyFactory.newKey(5649391675244544l));
    	return bookEntity.getString("name");	
    }

}
