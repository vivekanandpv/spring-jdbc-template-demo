package com.example.demo.services.implementations;

import com.example.demo.repositories.IAccountRepository;
import com.example.demo.services.interfaces.IAccountService;
import com.example.demo.viewmodels.AccountCreateViewModel;
import com.example.demo.viewmodels.AccountUpdateViewModel;
import com.example.demo.viewmodels.AccountViewModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountService implements IAccountService {
    private final IAccountRepository repository;

    public AccountService(IAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AccountViewModel> get() {
        return null;
    }

    @Override
    public AccountViewModel get(int id) {
        return null;
    }

    @Override
    public AccountViewModel create(AccountCreateViewModel viewModel) {
        return null;
    }

    @Override
    public void update(int id, AccountUpdateViewModel viewModel) {

    }

    @Override
    public void delete(int id) {

    }
}
