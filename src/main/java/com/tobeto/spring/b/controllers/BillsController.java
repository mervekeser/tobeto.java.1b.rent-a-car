package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.dtos.requests.bill.AddBillRequest;
import com.tobeto.spring.b.dtos.requests.bill.UpdateBillRequest;
import com.tobeto.spring.b.dtos.responses.bill.GetBillListResponse;
import com.tobeto.spring.b.dtos.responses.bill.GetBillResponse;
import com.tobeto.spring.b.entities.Bill;
import com.tobeto.spring.b.repositories.BillRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/bills")
public class BillsController {
    private final BillRepository billRepository;
    public BillsController(BillRepository billRepository){
        this.billRepository = billRepository;
    }


    @GetMapping
    public List<GetBillListResponse> getAll(){
        List<Bill> billList = billRepository.findAll();
        List<GetBillListResponse> billListResponses = new ArrayList<GetBillListResponse>();
        for (Bill bill : billList){
            GetBillListResponse billListResponse = new GetBillListResponse();
            billListResponse.setDate(bill.getDate());
            billListResponse.setPrice(bill.getPrice());
            billListResponse.setTimeRent(bill.getTimeRent());

            billListResponses.add(billListResponse);
        }
        return billListResponses;
    }

    @GetMapping({"id"})
    public GetBillResponse getById(@PathVariable int id){
        Bill bill = billRepository.findById(id).orElseThrow();

        GetBillResponse dto = new GetBillResponse();
        dto.setDate(bill.getDate());
        dto.setPrice(bill.getPrice());
        dto.setTimeRent(bill.getTimeRent());

        return dto;
    }
    @PostMapping
    public void add(@RequestBody AddBillRequest addBillRequest){
        Bill bill = new Bill();

        bill.setDate(addBillRequest.getDate());
        bill.setPrice(addBillRequest.getPrice());
        bill.setTimeRent(addBillRequest.getTimeRent());

        billRepository.save(bill);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateBillRequest updateBillRequest){
        Bill billToUpdate = billRepository.findById(id).orElseThrow();

        billToUpdate.setDate(updateBillRequest.getDate());
        billToUpdate.setTimeRent(updateBillRequest.getTimeRent());
        billToUpdate.setPrice(updateBillRequest.getPrice());

        billRepository.save(billToUpdate);
    }

    @DeleteMapping({"id"})
    public void delete(@PathVariable int id){
        Bill billToDelete = billRepository.findById(id).orElseThrow();

        billRepository.delete(billToDelete);
    }
}
