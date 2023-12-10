package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.services.abstracts.BillService;
import com.tobeto.spring.b.services.dtos.requests.bill.AddBillRequest;
import com.tobeto.spring.b.services.dtos.requests.bill.UpdateBillRequest;
import com.tobeto.spring.b.services.dtos.responses.bill.GetBillListResponse;
import com.tobeto.spring.b.services.dtos.responses.bill.GetBillResponse;
import com.tobeto.spring.b.entities.Bill;
import com.tobeto.spring.b.repositories.BillRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/bills")
@AllArgsConstructor
public class BillsController {
    private final BillService billService;

    @PostMapping
    public void add(@RequestBody AddBillRequest addBillRequest){
        this.billService.add(addBillRequest);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateBillRequest updateBillRequest){
        this.billService.update(updateBillRequest, id);
    }

    @DeleteMapping({"id"})
    public void delete(@PathVariable int id){
        this.billService.delete(id);
    }

    @GetMapping
    public List<GetBillListResponse> getAll(){
        return this.billService.getAll();
    }

    @GetMapping({"id"})
    public GetBillResponse getById(@PathVariable int id){
        return this.billService.getById(id);
    }

    @GetMapping({"price"})
    public List<GetBillListResponse> getByPriceLessThanEqual(double price){
        return this.billService.getByPriceLessThanEqual(price);
    }
}
