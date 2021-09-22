package com.example.demo.services.interfaces;

import com.example.demo.viewmodels.AccountCreateViewModel;
import com.example.demo.viewmodels.AccountUpdateViewModel;
import com.example.demo.viewmodels.AccountViewModel;

import java.util.List;

public interface IAccountService {
    List<AccountViewModel> get();
    AccountViewModel get(int id);
    AccountViewModel create(AccountCreateViewModel viewModel);
    void update(int id, AccountUpdateViewModel viewModel);
    void delete(int id);
}
