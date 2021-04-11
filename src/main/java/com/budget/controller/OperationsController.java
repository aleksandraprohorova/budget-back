package com.budget.controller;

import com.budget.dto.request.AddOperationRequest;
import com.budget.dto.response.AddOperationResponse;
import com.budget.dto.response.OperationsListResponse;
import com.budget.repository.OperationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operations")
@CrossOrigin
public class OperationsController {
    @GetMapping("test")
    public String test() {
        return "OK";
    }

    @Autowired
    OperationsRepository operationsRepository;

    @GetMapping
    OperationsListResponse getOperations()
    {
        //return new OperationsListResponse(operationsRepository.findAll(Sort()))
        return new OperationsListResponse(operationsRepository.findAllByOrderByIdDesc());
    }

    @GetMapping(value="balance")
    OperationsListResponse getOperationsOfBalance(@RequestParam("id") Long id) {
        //return new OperationsListResponse(operationsRepository.findAllByOrderByIdDesc());
        System.out.println("Getting operations of balance" + id);
        return new OperationsListResponse(operationsRepository.findOperationsByBalanceId(id));
    }

    @PostMapping
    AddOperationResponse addOperation(@RequestBody AddOperationRequest request) {
        System.out.println("Add operation: " + request.getOperation().getCreate_date().toString());
        System.out.println("debit: " + request.getOperation().getDebit() + ", credit: " + request.getOperation().getCredit());
        System.out.println("article: " + request.getOperation().getArticle().getName());

        return new AddOperationResponse(operationsRepository.save(request.getOperation()));
    }

    @DeleteMapping
    void deleteOperation(@RequestParam("id") Long id) {
        System.out.println("Delete operation " + id);
        operationsRepository.deleteById(id);
    }
}
