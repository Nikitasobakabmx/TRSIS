package com.laba.two.restfull.service;

import com.laba.two.restfull.model.ClientEntity;
import com.laba.two.restfull.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class ClientServiceImpl implements ClientSrvice {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Iterable<ClientEntity> findAll() {
        return clientRepository.findAll();
    }

//    @Override
//    public void delete(ClientEntity user) {
//        clientRepository.delete(user);
//    }
//
//    @Override
//    public void update(ClientEntity user) {
//        clientRepository.save(user);
//    }
//
//    @Override
//    public void append(ClientEntity user) {
//        clientRepository.save(user);
//    }
}
