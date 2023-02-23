package com.craftdemo.contentauthoringtool.controller;

import com.craftdemo.contentauthoringtool.cache.ICacheAccessor;
import com.craftdemo.contentauthoringtool.exception.BadRequestException;
import com.craftdemo.contentauthoringtool.exception.ResourceNotFoundException;
import com.craftdemo.contentauthoringtool.model.FAQ;
import com.craftdemo.contentauthoringtool.model.FormPayload;
import com.craftdemo.contentauthoringtool.service.SchemaService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;

@RestController
@RequestMapping("/schema")
@CrossOrigin
public class SchemaController {
    @Autowired
    private SchemaService schemaService;

    @Autowired
    private ICacheAccessor<String,FormPayload> cache;

    @GetMapping("{id}/get")
    public FormPayload getSchema(@PathVariable int id) throws ResourceNotFoundException {
        FormPayload payload = schemaService.getSchemaById(id);
        if(payload== null) throw new ResourceNotFoundException("Please provide a valid schema id");
        return payload;
    }

    @GetMapping("/refresh")
    public void refresh() {
        schemaService.refreshCacheWithSchema();
    }

    @GetMapping("/get/{type}")
    public FormPayload getSchemaByType(@PathVariable String type) throws ResourceNotFoundException {
        FormPayload payload = schemaService.getSchemaByType(type);
        if(payload== null) throw new ResourceNotFoundException("Please provide a valid schema type");
        return payload;
    }
    @PutMapping("/update")
    public String update(@RequestBody FormPayload formPayload){

        FormPayload updateFaqPayload = null;
        try{
            updateFaqPayload = schemaService.updatePayload(formPayload.type,formPayload);
        }catch(Exception e){
            throw new BadRequestException(e.getMessage(), e);
        }
        return "Schema updated in the DB";
    }
}
