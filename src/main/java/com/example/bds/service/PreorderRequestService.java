package com.example.bds.service;

import com.example.bds.Request.PreorderRequestRequest.CreatePreorderRequestRequest;
import com.example.bds.Response.PreorderRequestResponse.CreatePreorderRequestResponse;
import com.example.bds.Response.PreorderRequestResponse.DeletePreorderRequestResponse;
import com.example.bds.Response.PreorderRequestResponse.FindPreorderRequestResponse;
import com.example.bds.Response.PreorderRequestResponse.ListPreorderRequestResponse;
import org.springframework.http.ResponseEntity;

public interface PreorderRequestService {

    ResponseEntity<CreatePreorderRequestResponse> createPreorderRequest(CreatePreorderRequestRequest request);

    ResponseEntity<CreatePreorderRequestResponse> updatePreorderRequest(int preorderRequestId, CreatePreorderRequestRequest request);

    ResponseEntity<DeletePreorderRequestResponse> deletePreorderRequest(int preorderRequestId);

    ResponseEntity<FindPreorderRequestResponse> findPreorderRequestById(int preorderRequestId);

    ResponseEntity<ListPreorderRequestResponse> findAllPreorderRequests();


}