package microservicedeneme.controller;

import com.microserviceapp.client.contract.AccountDto;
import microservicedeneme.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestScope
@RequestMapping("account")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> get(@PathVariable String id) {
        return  ResponseEntity.ok(accountService.getById(id));


    }
    @PostMapping("/save")
    public ResponseEntity<AccountDto> save(@RequestBody AccountDto account) {
        return  ResponseEntity.ok(accountService.save(account));
    }
    @PutMapping
    public ResponseEntity<AccountDto> update(@RequestBody AccountDto account) {
        return  ResponseEntity.ok(accountService.update(account));
    }

    public void delete(String id) {
        accountService.deleteById(id);

    }

    @GetMapping("/getall")
    public ResponseEntity<List<AccountDto>> getall(){
        return ResponseEntity.ok(accountService.getAll());
    }


}
