package com.mc.mc_common.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {

    // ================= GENERAL =================
    INTERNAL_SERVER_ERROR("5000", "Internal server error"),
    INVALID_REQUEST("4000", "Invalid request"),
    RESOURCE_NOT_FOUND("4004", "Resource not found"),
    VALIDATION_ERROR("4001", "Validation failed"),

    // ================= AUTH =================
    INVALID_CREDENTIALS("1001", "Invalid credentials"),
    TOKEN_EXPIRED("1002", "Token expired"),
    UNAUTHORIZED_ACCESS("1003", "Unauthorized access"),
    FORBIDDEN_ACCESS("1004", "Forbidden access"),
    INVALID_ROLE("1005", "Invalid role"),

    // ================= USER =================
    USER_NOT_FOUND("2001", "User not found"),
    USER_ALREADY_EXISTS("2002", "User already exists"),
    INVALID_USER_STATUS("2003", "Invalid user status"),
    EMAIL_ALREADY_EXISTS("2004", "Email already exists"),

    // ================= WALLET / TRANSACTION =================
    WALLET_NOT_FOUND("3001", "Wallet not found"),
    INSUFFICIENT_BALANCE("3002", "Insufficient balance"),
    INVALID_TRANSACTION("3003", "Invalid transaction"),
    TRANSACTION_FAILED("3004", "Transaction failed"),
    INVALID_DEPOSIT_AMOUNT("3005", "Invalid deposit amount"),

    // ================= KYC =================
    KYC_NOT_SUBMITTED("4001", "KYC not submitted"),
    KYC_ALREADY_VERIFIED("4002", "KYC already verified"),
    INVALID_KYC_DOCUMENT("4003", "Invalid KYC document"),

    // ================= TRADING =================
    TRADING_ACCOUNT_NOT_FOUND("5001", "Trading account not found"),
    MT5_ACCOUNT_CREATION_FAILED("5002", "MT5 account creation failed"),
    INVALID_ACCOUNT_TYPE("5003", "Invalid account type"),

    // ================= PASSWORD =================
    INVALID_PASSWORD("2101", "Invalid password"),
    CURRENT_PASSWORD_INVALID("2102", "Current password is incorrect"),
    PASSWORD_MISMATCH("2103", "Password mismatch"),
    NEW_PASSWORD_SAME_AS_OLD_PASSWORD("2104", "New password cannot be same as old password"),

    // ================= BUSINESS VALIDATION =================
    COMPANY_NAME_REQUIRED("2201", "Company name is required"),

    // ================= SYSTEM =================
    SERVICE_UNAVAILABLE("9001", "Service unavailable"),
    DATABASE_ERROR("9002", "Database error");


    private final String code;
    private final String defaultMessage;

    ErrorCode(String code, String defaultMessage) {
        this.code = code;
        this.defaultMessage = defaultMessage;
    }
}