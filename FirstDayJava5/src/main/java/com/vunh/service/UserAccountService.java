package com.vunh.service;

import com.vunh.entity.UserAccount;
import com.vunh.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountService {
    @Autowired
    private UserAccountRepository userAccountRepository;
    public UserAccountRepository getUserAccountRepository() {
        return this.userAccountRepository;
    }
    public List<UserAccount> getUserAccounts() {
        return this.userAccountRepository.findAll();
    }
}
