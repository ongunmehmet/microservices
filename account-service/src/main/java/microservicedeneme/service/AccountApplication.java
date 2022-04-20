package microservicedeneme.service;


import com.microserviceapp.client.contract.AccountDto;
import lombok.RequiredArgsConstructor;
import microservicedeneme.entity.Account;
import microservicedeneme.repository.AccountRepository;
import microservicedeneme.service.exception.AccountAlreadyExistException;
import microservicedeneme.service.exception.AccountNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountApplication implements AccountService {
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public AccountDto save(AccountDto account) {

         var addedAccount= modelMapper.map(account ,Account.class);
        accountRepository.save(addedAccount);
        account.setId(addedAccount.getId());
        return account;



    }

    @Override
    @Transactional
    public AccountDto update(AccountDto account) {
        if(accountRepository.findById(account.getId())==null){

            var updatedAccount=accountRepository.findById(account.getId()).orElseThrow(()->new IllegalArgumentException());
            updatedAccount.setFullName(account.getFullName());
            updatedAccount.setEmail(account.getEmail());
            updatedAccount.setDateOfBirth(account.getDateOfBirth());

            accountRepository.save(updatedAccount);
            return modelMapper.map(updatedAccount,AccountDto.class);
               }
        else
            throw new AccountAlreadyExistException();
    }

    @Override
    public AccountDto getById(String id) {
        var lookingAccount=accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException());
        return modelMapper.map(lookingAccount,AccountDto.class);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        if(accountRepository.findById(id)==null)
        {throw new AccountNotFoundException();}

        else
            accountRepository.deleteById(id);


    }

    @Override
    public List<AccountDto> getAll() {
        List<Account> accounts=accountRepository.findAll();

        return accounts.stream().map(account -> modelMapper.map(account,AccountDto.class)).toList();
    }
}
