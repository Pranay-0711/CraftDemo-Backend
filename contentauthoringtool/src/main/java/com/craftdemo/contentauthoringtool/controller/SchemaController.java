package com.craftdemo.contentauthoringtool.controller;

import com.craftdemo.contentauthoringtool.exception.ResourceNotFoundException;
import com.craftdemo.contentauthoringtool.model.FormPayload;
import com.craftdemo.contentauthoringtool.service.SchemaService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schema")
@CrossOrigin
public class SchemaController {
    @Autowired
    private SchemaService schemaService;

    @GetMapping("{id}/get")
    public FormPayload getSchema(@PathVariable int id) throws ResourceNotFoundException {
        FormPayload payload = schemaService.getSchemaById(id);
        if(payload== null) throw new ResourceNotFoundException("Please provide a valid schema id");
        return payload;
    }

    @GetMapping("/get/{type}")
    public FormPayload getSchemaByType(@PathVariable String type) throws ResourceNotFoundException {
        FormPayload payload = schemaService.getSchemaByType(type);
        if(payload== null) throw new ResourceNotFoundException("Please provide a valid schema type");
        return payload;
    }
}
