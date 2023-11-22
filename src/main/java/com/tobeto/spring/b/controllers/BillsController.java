package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.entities.Bill;
import com.tobeto.spring.b.repositories.BillRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bills")
public class BillsController {
    private final BillRepository billRepository;
    public BillsController(BillRepository billRepository){
        this.billRepository = billRepository;
    }


    @GetMapping
    public List<Bill> getAll(){
        return billRepository.findAll();
    }

    @GetMapping({"id"})
    public Bill getById(@PathVariable int id){
        return billRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@RequestBody Bill bill){
        billRepository.save(bill);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Bill bill){
        Bill billToUpdate = billRepository.findById(id).orElseThrow();
        billToUpdate.setId(bill.getId());
        billToUpdate.setDate(bill.getDate());
        billToUpdate.setTimeRent(bill.getTimeRent());
        billToUpdate.setPrice(bill.getPrice());
        billRepository.save(billToUpdate);
    }

    @DeleteMapping({"id"})
    public void delete(@PathVariable int id){
        Bill billToDelete = billRepository.findById(id).orElseThrow();
        billRepository.delete(billToDelete);
    }
}
