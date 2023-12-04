package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Bill;
import com.tobeto.spring.b.repositories.BillRepository;
import com.tobeto.spring.b.services.abstracts.BillService;
import com.tobeto.spring.b.services.dtos.requests.bill.AddBillRequest;
import com.tobeto.spring.b.services.dtos.requests.bill.UpdateBillRequest;
import com.tobeto.spring.b.services.dtos.responses.bill.GetBillListResponse;
import com.tobeto.spring.b.services.dtos.responses.bill.GetBillResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class BillManager implements BillService {
    private final BillRepository billRepository;

    @Override
    public void add(AddBillRequest addBillRequest) {
        Bill bill = new Bill();

        bill.setDate(addBillRequest.getDate());
        bill.setPrice(addBillRequest.getPrice());
        bill.setTimeRent(addBillRequest.getTimeRent());

        billRepository.save(bill);
    }

    @Override
    public List<GetBillListResponse> getAll() {
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

    @Override
    public GetBillResponse getById(int id) {
        Bill bill = billRepository.findById(id).orElseThrow();

        GetBillResponse getBillResponse = new GetBillResponse();
        getBillResponse.setDate(bill.getDate());
        getBillResponse.setPrice(bill.getPrice());
        getBillResponse.setTimeRent(bill.getTimeRent());

        return getBillResponse;
    }

    @Override
    public void update(UpdateBillRequest updateBillRequest, int id) {
        Bill billToUpdate = billRepository.findById(id).orElseThrow();

        billToUpdate.setDate(updateBillRequest.getDate());
        billToUpdate.setTimeRent(updateBillRequest.getTimeRent());
        billToUpdate.setPrice(updateBillRequest.getPrice());

        billRepository.save(billToUpdate);
    }

    @Override
    public void delete(int id) {
        billRepository.deleteById(id);
    }
}
