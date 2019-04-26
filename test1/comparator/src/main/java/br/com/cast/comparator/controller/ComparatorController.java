package br.com.cast.comparator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.comparator.helpers.JSONObject;
import br.com.cast.comparator.service.ComparatorService;
import br.com.cast.comparator.helpers.Util;

@RestController
@RequestMapping("/v1/diff/{id}")
public class ComparatorController {

    private static final String RIGHT = "RIGHT";
    private static final String LEFT  = "LEFT ";

    @Autowired
    private ComparatorService service;

    @PostMapping(value = "/left")
    public String left(@PathVariable Long id, @RequestBody JSONObject data) throws Exception {
        service.salvar(id, data.getData(), LEFT);
        return Util.buildJsonResponse("Document left save.");
    }

    @PostMapping(value = "/right")
    public String right(@PathVariable Long id, @RequestBody JSONObject data) throws Exception {
        service.salvar(id, data.getData(), RIGHT);
		return Util.buildJsonResponse("Document right save.");
	}
	
	@GetMapping
	public String diff(@PathVariable Long id) {
		return Util.buildJsonResponse(service.validadorBase64Dado(id));
	}
	
}
