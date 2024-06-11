package com.example.warehouse10b.Controller;

import com.example.warehouse10b.dto.ClientDto;
import com.example.warehouse10b.model.Client;
import com.example.warehouse10b.model.Result;
import com.example.warehouse10b.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public List<Client>getallClient(){
        List<Client>list=clientService.getallClient();
        return list;
    }

    @GetMapping("/{id}")
    public Client getByClient(@PathVariable Integer id){
        Client client=clientService.getClient(id);
        return client;
    }
    @PostMapping
    public Result add(@RequestBody ClientDto clientDto){
        Result result=clientService.createClient(clientDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id,@RequestBody ClientDto clientDto){
        Result result=clientService.updateClient(id,clientDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        Result result=clientService.deleteClient(id);
        return result;
    }
}
