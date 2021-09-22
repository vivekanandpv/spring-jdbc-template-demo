package com.example.demo.controllers;

import com.example.demo.services.interfaces.IAccountService;
import com.example.demo.viewmodels.AccountCreateViewModel;
import com.example.demo.viewmodels.AccountUpdateViewModel;
import com.example.demo.viewmodels.AccountViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {
    private final IAccountService accountService;

    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<AccountViewModel>> get() {
        return ResponseEntity.ok(accountService.get());
    }

    @GetMapping("{id}")
    public ResponseEntity<AccountViewModel> get(@PathVariable int id) {
        return ResponseEntity.ok(accountService.get(id));
    }

    @PostMapping
    public ResponseEntity<AccountViewModel> create(@RequestBody AccountCreateViewModel viewModel) {
        return ResponseEntity.ok(accountService.create(viewModel));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@RequestBody AccountUpdateViewModel viewModel, @PathVariable int id) {
        accountService.update(id, viewModel);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        accountService.delete(id);
        return ResponseEntity.ok().build();
    }
}
