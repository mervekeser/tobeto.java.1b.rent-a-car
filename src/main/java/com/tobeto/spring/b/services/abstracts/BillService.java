package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.requests.bill.AddBillRequest;
import com.tobeto.spring.b.services.dtos.requests.bill.UpdateBillRequest;
import com.tobeto.spring.b.services.dtos.responses.bill.GetBillListResponse;
import com.tobeto.spring.b.services.dtos.responses.bill.GetBillResponse;

import java.util.List;

public interface BillService {
    void add(AddBillRequest addBillRequest);
    List<GetBillListResponse> getAll();
    GetBillResponse getById(int id);
    void update(UpdateBillRequest updateBillRequest, int id);
    void delete(int id);
}
