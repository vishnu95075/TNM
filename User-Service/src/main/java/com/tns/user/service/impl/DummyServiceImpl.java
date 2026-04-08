package com.tns.user.service.impl;

import com.tns.user.entity.Dummy;
import com.tns.user.repository.DummyRepository;
import com.tns.user.service.IDummyService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class DummyServiceImpl implements IDummyService {

    private  final  DummyRepository dummyRepository;

    public DummyServiceImpl(DummyRepository dummyRepository) {
        this.dummyRepository = dummyRepository;
    }

    @Override
    public Dummy createDummy(Dummy dummy) {
       return this.dummyRepository.save(dummy);
    }

    @Override
    public Dummy getDummy(Integer id) {
        return dummyRepository.findById(id).orElse(null);
    }

    @Override
    public List<Dummy> getAllDummy() {
        return dummyRepository.findAll();
    }
}
