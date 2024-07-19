package com.demo_bank_v1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "v_payments_history")
public class PaymentHistory {

    @Id
    private int payment_id;
    private int account_id;
    private int user_id;
    private String beneficiary;
    private String beneficiary_account_number;
    private double amount;
    private String status_;
    private String reference_no;
    private String reason_code;
    private LocalDateTime created_at;

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getBeneficiary_account_number() {
        return beneficiary_account_number;
    }

    public void setBeneficiary_account_number(String beneficiary_account_number) {
        this.beneficiary_account_number = beneficiary_account_number;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus_() {
        return status_;
    }

    public void setStatus_(String status_) {
        this.status_ = status_;
    }

    public String getReference_no() {
        return reference_no;
    }

    public void setReference_no(String reference_no) {
        this.reference_no = reference_no;
    }

    public String getReason_code() {
        return reason_code;
    }

    public void setReason_code(String reason_code) {
        this.reason_code = reason_code;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
