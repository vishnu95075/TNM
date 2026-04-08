package com.tns.user.controller;

import com.tns.user.entity.Dummy;
import com.tns.user.service.IDummyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {

    private final IDummyService iDummyService;

    public DemoController(IDummyService iDummyService) {
        this.iDummyService = iDummyService;
    }

    @PostMapping("/dummy")
    public Dummy createDummy(@RequestBody Dummy dummy){
        return iDummyService.createDummy(dummy);
    }
    @GetMapping("/dummy")
    public List<Dummy> getAllDummy(){
        System.out.println("Dummy All");
        return iDummyService.getAllDummy();
    }

    @GetMapping("/dummy/{id}")
    public Dummy getDummy(@PathVariable Integer id){
        return iDummyService.getDummy(id);
    }


}
