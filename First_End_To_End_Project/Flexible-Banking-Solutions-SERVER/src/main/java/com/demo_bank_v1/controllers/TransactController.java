package com.demo_bank_v1.controllers;

import com.demo_bank_v1.models.User;
import com.demo_bank_v1.repository.AccountRepository;
import com.demo_bank_v1.repository.PaymentRepository;
import com.demo_bank_v1.repository.TransactionRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/transact")
public class TransactController {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    private User user;
    private double currentBalance;
    private double newBalance;
    private final LocalDateTime currentDateTime = LocalDateTime.now();

    @PostMapping("/deposit")
    public String deposit(@RequestParam("deposit_amount")String depositAmount,
                          @RequestParam("account_id")String accountID,
                          HttpSession session,
                          RedirectAttributes redirectAttributes){

        // TODO: CHECK FOR EMPTY STRINGS:
        if(depositAmount.isEmpty() || accountID.isEmpty()){
            redirectAttributes.addFlashAttribute("error","Deposit Amount or Account Depositing to Cannot Be Empty");
            return "redirect:/app/dashboard";
        }
        // TODO: GET LOGGED IN USER:
        user = (User)session.getAttribute("user");

        // TODO: GET CURRENT ACCOUNT BALANCE:
        int acc_id = Integer.parseInt(accountID);
        double depositAmountValue = Double.parseDouble(depositAmount);
        currentBalance = accountRepository.getAccountBalance(user.getUser_id(), acc_id);

        // TODO: CHECK IF DEPOSIT AMOUNT IS 0:

        if(depositAmountValue == 0){
            redirectAttributes.addFlashAttribute("error","Deposit Amount Cannot Be of 0 Value");
            return "redirect:/app/dashboard";
        }

        // TODO: UPDATE BALANCE:
        newBalance = currentBalance + depositAmountValue;
        accountRepository.changeAccountBalanceById(newBalance,acc_id);

        // TODO: LOG SUCCESSFULLY TRANSACTION:
        transactionRepository.logTransaction(acc_id,"deposit",depositAmountValue,
                "online","success","Deposit Transaction Successfully",currentDateTime);

        redirectAttributes.addFlashAttribute("success","Amount Deposited Successfully");
        return "redirect:/app/dashboard";

    }
    @PostMapping("/transfer")
    public String transfer(@RequestParam("transfer_from") String transfer_from,
                           @RequestParam("transfer_to") String transfer_to,
                           @RequestParam("transfer_amount") String transfer_amount,
                           HttpSession session,
                           RedirectAttributes redirectAttributes){

        // TODO: CHECK FOR EMPTY FIELDS:
        if(transfer_from.isEmpty() || transfer_to.isEmpty() || transfer_amount.isEmpty()){
            redirectAttributes.addFlashAttribute("error","You need to complete all fields!");
            return "redirect:/app/dashboard";
        }
        // TODO: CONVERT VARIABLES:
        int transferFromId = Integer.parseInt(transfer_from);
        int transferToId = Integer.parseInt(transfer_to);
        double transferAmount = Double.parseDouble(transfer_amount);

        //TODO: CHECK IF TRANSFERRING INTO THE SAME ACCOUNT:

        if(transferFromId == transferToId){
            redirectAttributes.addFlashAttribute("error","Cannot Transfer Into The Same Account!");
            return "redirect:/app/dashboard";
        }

        // TODO: CHECK FOR 0 VALUES:
        if(transferAmount == 0){
            redirectAttributes.addFlashAttribute("error","You Cannot Transfer Amount of 0 Value");
            return "redirect:/app/dashboard";
        }

        // TODO: GET CURRENT BALANCE
        double currentBalanceOfAccountTrasferringFrom = accountRepository.getAccountBalance(user.getUser_id(), transferFromId);
        double currentBalanceOfAccountTrasferringTo = accountRepository.getAccountBalance(user.getUser_id(), transferToId);

        // TODO: CHECK IF PAYMENT AMOUNT IS MORE THAM CURREMT BALANCE:
        if(currentBalanceOfAccountTrasferringFrom < transferAmount){
            redirectAttributes.addFlashAttribute("error","You have insufficient Funds to perform this payment");
            // log failed transaction
            transactionRepository.logTransaction(transferFromId,"transfer", transferAmount,
                    "online","failed","Insufficient Funds",currentDateTime);
            return "redirect:/app/dashboard";
        }

        //TODO: GET LOGGED IN USER:
        user = (User)session.getAttribute("user");

        // TODO: SET NEW BALANCE
        double newBalanceOfAccountTransferringFrom = currentBalanceOfAccountTrasferringFrom - transferAmount;
        double newBalanceOfAccountTransferringTo = currentBalanceOfAccountTrasferringTo + transferAmount;

        // Change The Balance Of The Account Transferring from
        accountRepository.changeAccountBalanceById(newBalanceOfAccountTransferringFrom,transferFromId);
        // Change The Balance Of The Account Transferring to
        accountRepository.changeAccountBalanceById(newBalanceOfAccountTransferringTo,transferToId);

        // TODO: LOG SUCCESSFULLY TRANSACTION:
        transactionRepository.logTransaction(transferFromId,"transfer",transferAmount,
                "online","success","Transfer Transaction Successfully",currentDateTime);

        redirectAttributes.addFlashAttribute("success","Amount Transferred Successfully!");
        return "redirect:/app/dashboard";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam("withdraw_amount")String withdraw_amount,
                           @RequestParam("account_id") String account_id,
                           HttpSession session,
                           RedirectAttributes redirectAttributes){

        // TODO: CHECK FOR EMPTY VALUES:
        if(withdraw_amount.isEmpty() || account_id.isEmpty()){
            redirectAttributes.addFlashAttribute("error","You need to complete all fields!");
            return "redirect:/app/dashboard";
        }
        // TODO: COVERT VARIABLES:
        double withdrawalAmount = Double.parseDouble(withdraw_amount);
        int accountID = Integer.parseInt(account_id);

        // TODO: CHECK FOR 0 VALUES:
        if(withdrawalAmount==0){
            redirectAttributes.addFlashAttribute("error","You Cannot Withdraw Amount of 0 Value");
            return "redirect:/app/dashboard";
        }

        // TODO: GET CURRENT BALANCE
        currentBalance = accountRepository.getAccountBalance(user.getUser_id(),accountID);

        // TODO: CHECK IF PAYMENT AMOUNT IS MORE THAM CURREMT BALANCE:
        if(currentBalance < withdrawalAmount){
            redirectAttributes.addFlashAttribute("error","You have insufficient Funds to perform this payment");
            // log failed transaction
            transactionRepository.logTransaction(accountID,"withdrawal", withdrawalAmount,
                    "online","failed","Insufficient Funds",currentDateTime);
            return "redirect:/app/dashboard";
        }

        // TODO: GET LOGGED IN USER
        user = (User) session.getAttribute("user");



        // TODO: SET NEW BALANCE;
        newBalance = currentBalance - withdrawalAmount;
        accountRepository.changeAccountBalanceById(newBalance,accountID);

        // TODO: LOG SUCCESSFULLY TRANSACTION:
        transactionRepository.logTransaction(accountID,"withdrawal",withdrawalAmount,
                "online","success","Withdrawal Successfully",currentDateTime);


        redirectAttributes.addFlashAttribute("success","Withdrawal Successfully!");
        return "redirect:/app/dashboard";
    }

    @PostMapping("/payment")
    public String payments(@RequestParam("beneficiary")String beneficiary,
                           @RequestParam("beneficiary_account_number")String beneficiary_account_number,
                           @RequestParam("account_id")String account_id,
                           @RequestParam("reference")String reference,
                           @RequestParam("payment_amount")String payment_amount,
                           HttpSession session,
                           RedirectAttributes redirectAttributes){

        // TODO: CHECK FOR EMPTY VALUES:
        if(beneficiary.isEmpty() || beneficiary_account_number.isEmpty() || account_id.isEmpty() || payment_amount.isEmpty()){
            redirectAttributes.addFlashAttribute("error","You need to complete all fields!");
            return "redirect:/app/dashboard";
        }
        // TODO: CONVERT VARIABLES:
        int accountID = Integer.parseInt(account_id);
        double paymentAmount = Double.parseDouble(payment_amount);

        // TODO: CHECK FOR 0 VALUES:
        if(paymentAmount == 0){
            redirectAttributes.addFlashAttribute("error","Payment Amount Cannot Be of 0 Value. ");
            return "redirect:/app/dashboard";
        }

        // TODO: GET LOGGED IN USER:
        user = (User)session.getAttribute("user");

        // TODO: GET CURRENT BALANCE:
        currentBalance = accountRepository.getAccountBalance(user.getUser_id(),accountID);

        // TODO: CHECK IF PAYMENT AMOUNT IS MORE THAM CURREMT BALANCE:
        if(currentBalance < paymentAmount){
            redirectAttributes.addFlashAttribute("error","You have insufficient Funds to perform this payment");
            String reasonCode = "Could not processed payment due to insufficient funds!";
            paymentRepository.makePayment(accountID,beneficiary,beneficiary_account_number,
                    paymentAmount,reference,"failed",reasonCode,currentDateTime);
            // log failed transaction
            transactionRepository.logTransaction(accountID,"payment", paymentAmount,
                    "online","failed","Insufficient Funds",currentDateTime);
            return "redirect:/app/dashboard";
        }

        // TODO: MAKE PAYMENT:
        String reasonCode = "Payment Processed Successfully";
        paymentRepository.makePayment(accountID,beneficiary,beneficiary_account_number,
                paymentAmount,reference,"success",reasonCode,currentDateTime);

        // TODO: LOG SUCCESSFULLY TRANSACTION:
        transactionRepository.logTransaction(accountID,"payment",paymentAmount,
                "online","success","Payment Transaction Successfully",currentDateTime);

        // TODO: SET NEW BALANCE FOR ACCOUNT PAYING FORM:
        newBalance = currentBalance-paymentAmount;
        accountRepository.changeAccountBalanceById(newBalance,accountID);



        redirectAttributes.addFlashAttribute("success",reasonCode);
        return "redirect:/app/dashboard";
    }
}
