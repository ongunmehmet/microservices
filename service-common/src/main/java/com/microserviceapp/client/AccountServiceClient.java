package com.microserviceapp.client;

import com.microserviceapp.client.contract.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("account-service")
public interface AccountServiceClient {
    @GetMapping("/account/{id}")
    public ResponseEntity<AccountDto> get(@PathVariable String id);





}
