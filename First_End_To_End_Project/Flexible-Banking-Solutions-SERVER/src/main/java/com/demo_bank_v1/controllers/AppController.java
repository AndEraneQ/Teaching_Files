package com.demo_bank_v1.controllers;

import com.demo_bank_v1.models.Account;
import com.demo_bank_v1.models.PaymentHistory;
import com.demo_bank_v1.models.TransactionHistory;
import com.demo_bank_v1.models.User;
import com.demo_bank_v1.repository.AccountRepository;
import com.demo_bank_v1.repository.PaymentHistoryRepository;
import com.demo_bank_v1.repository.TransactionHistoryRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/app")
public class AppController {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;
    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

    private User user;

    @GetMapping("/dashboard")
    public ModelAndView getDashboard(HttpSession session){
        ModelAndView getDashboardPage = new ModelAndView("dashboard");

        // Get the details of the logged user
        user = (User)session.getAttribute("user");

        // Get the accounts of the Logged user
        List<Account> getUserAccounts = accountRepository.getUserAccountsById(user.getUser_id());
        // Get Balance:
        BigDecimal totalAccountsBalance = accountRepository.getTotalBalance(user.getUser_id());

        // Set Objects:
        getDashboardPage.addObject("userAccounts",getUserAccounts);
        getDashboardPage.addObject("totalBalance",totalAccountsBalance);

        return getDashboardPage;
    }

    @GetMapping("/payment_history")
    public ModelAndView getPaymentHistory(HttpSession session){
        ModelAndView getPaymentHistoryPage = new ModelAndView("paymentHistory");

        // Get the user:
        user = (User)session.getAttribute("user");

        // Get Payment History:
        List<PaymentHistory> userPaymentHistory = paymentHistoryRepository.getPaymentRecordsById(user.getUser_id());

        getPaymentHistoryPage.addObject("payment_history",userPaymentHistory);

        return getPaymentHistoryPage;

    }

    @GetMapping("/transact_history")
    public ModelAndView getTransactHistory(HttpSession session){
        ModelAndView getTransactHistoryPage = new ModelAndView("transactHistory");

        // Get the user:
        user = (User)session.getAttribute("user");

        // Get Transaction History:
        List<TransactionHistory> userTransactionHistory = transactionHistoryRepository.getTransactionRecordsById(user.getUser_id());

        getTransactHistoryPage.addObject("transact_history",userTransactionHistory);

        return getTransactHistoryPage;

    }


}
