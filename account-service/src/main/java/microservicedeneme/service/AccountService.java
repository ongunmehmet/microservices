package microservicedeneme.service;


import com.microserviceapp.client.contract.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto save(AccountDto account);

    AccountDto update(AccountDto account);

    AccountDto getById(String id);

    void deleteById(String id);

    List<AccountDto> getAll();
}
