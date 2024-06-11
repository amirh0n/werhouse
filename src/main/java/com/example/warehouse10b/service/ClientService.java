package com.example.warehouse10b.service;

import com.example.warehouse10b.dto.ClientDto;
import com.example.warehouse10b.model.Client;
import com.example.warehouse10b.model.Result;
import com.example.warehouse10b.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> getallClient(){
        List<Client>clientList=clientRepository.findAll();
        return clientList;
    }
    public Client getClient(Integer id){
        Optional<Client>optionalClient=clientRepository.findById(id);
        return optionalClient.get();
    }

    public Result createClient(ClientDto clientDto){
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        clientRepository.save(client);
        return new Result(true,"Successfully");
    }
    public Result updateClient(Integer id,ClientDto clientDto){
        Optional<Client>optional=clientRepository.findById(id);
        if (optional.isPresent()){
            Client client=optional.get();
            client.setName(clientDto.getName());
            client.setPhoneNumber(clientDto.getPhoneNumber());
            clientRepository.save(client);
            return new Result(true,"Updated");
        }
        return new Result(false,"Client not found");
    }

    public Result deleteClient(Integer id){
        clientRepository.deleteById(id);
        return new Result(true,"Deleted");
    }
}
