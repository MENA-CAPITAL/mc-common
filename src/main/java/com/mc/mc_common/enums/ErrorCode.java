package com.mc.mc_common.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    // ================= COMMON =================
    INTERNAL_SERVER_ERROR("COMMON_500", "Internal server error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_REQUEST("COMMON_400", "Invalid request", HttpStatus.BAD_REQUEST),
    VALIDATION_FAILED("COMMON_422", "Validation failed", HttpStatus.BAD_REQUEST),
    RESOURCE_NOT_FOUND("COMMON_404", "Resource not found", HttpStatus.NOT_FOUND),
    SERVICE_UNAVAILABLE("COMMON_503", "Service unavailable", HttpStatus.SERVICE_UNAVAILABLE),
    DATABASE_ERROR("COMMON_501", "Database error", HttpStatus.INTERNAL_SERVER_ERROR),

    // ================= AUTH / USER =================
    INVALID_CREDENTIALS("AUTH_401", "Invalid credentials", HttpStatus.UNAUTHORIZED),
    TOKEN_EXPIRED("AUTH_402", "Token expired", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED_ACCESS("AUTH_403", "Unauthorized access", HttpStatus.UNAUTHORIZED),
    FORBIDDEN_ACCESS("AUTH_404", "Forbidden access", HttpStatus.FORBIDDEN),
    INVALID_ROLE("AUTH_405", "Invalid role", HttpStatus.BAD_REQUEST),

    USER_NOT_FOUND("USER_404", "User not found", HttpStatus.NOT_FOUND),
    USER_ALREADY_EXISTS("USER_409", "User already exists", HttpStatus.CONFLICT),
    INVALID_USER_STATUS("USER_400", "Invalid user status", HttpStatus.BAD_REQUEST),
    EMAIL_ALREADY_EXISTS("USER_409_EMAIL", "Email already exists", HttpStatus.CONFLICT),

    INVALID_PASSWORD("USER_PWD_400", "Invalid password", HttpStatus.BAD_REQUEST),
    CURRENT_PASSWORD_INVALID("USER_PWD_401", "Current password is incorrect", HttpStatus.BAD_REQUEST),
    PASSWORD_MISMATCH("USER_PWD_402", "Password mismatch", HttpStatus.BAD_REQUEST),
    NEW_PASSWORD_SAME_AS_OLD_PASSWORD("USER_PWD_403", "New password cannot be same as old password", HttpStatus.BAD_REQUEST),

    COMPANY_NAME_REQUIRED("USER_BIZ_400", "Company name is required", HttpStatus.BAD_REQUEST),

    // ================= KYC - GENERAL =================
    KYC_NOT_FOUND("KYC_404", "KYC record not found", HttpStatus.NOT_FOUND),
    KYC_NOT_SUBMITTED("KYC_400", "KYC not submitted", HttpStatus.BAD_REQUEST),
    KYC_ALREADY_VERIFIED("KYC_409", "KYC already verified", HttpStatus.CONFLICT),
    INVALID_KYC_DOCUMENT("KYC_401", "Invalid KYC document", HttpStatus.BAD_REQUEST),

    // ================= KYC - PERSONAL =================
    ADDRESS_REQUIRED("KYC_PERSONAL_400", "Address is required", HttpStatus.BAD_REQUEST),
    DOB_REQUIRED("KYC_PERSONAL_401", "Date of birth is required", HttpStatus.BAD_REQUEST),

    // ================= KYC - FINANCIAL =================
    FINANCIAL_KYC_NOT_FOUND("KYC_FIN_404", "Financial KYC not found", HttpStatus.NOT_FOUND),
    EMPLOYMENT_STATUS_REQUIRED("KYC_FIN_400", "Employment status is required", HttpStatus.BAD_REQUEST),
    SOURCE_OF_FUNDS_REQUIRED("KYC_FIN_401", "Source of funds is required", HttpStatus.BAD_REQUEST),

    // ================= KYC - DECLARATION / COMPANY =================
    UBO_IDENTIFIED_REQUIRED("KYC_DECL_400", "UBO identification is required", HttpStatus.BAD_REQUEST),
    UBO_PEP_DETAILS_REQUIRED("KYC_DECL_401", "UBO PEP details are required", HttpStatus.BAD_REQUEST),

    // ================= WALLET / TRANSACTION =================
    WALLET_NOT_FOUND("TXN_404_WALLET", "Wallet not found", HttpStatus.NOT_FOUND),
    INSUFFICIENT_BALANCE("TXN_400_BAL", "Insufficient balance", HttpStatus.BAD_REQUEST),
    INVALID_TRANSACTION("TXN_400", "Invalid transaction", HttpStatus.BAD_REQUEST),
    TRANSACTION_FAILED("TXN_500", "Transaction failed", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_DEPOSIT_AMOUNT("TXN_401", "Invalid deposit amount", HttpStatus.BAD_REQUEST),

    // ================= TRADING =================
    TRADING_ACCOUNT_NOT_FOUND("TRADING_404", "Trading account not found", HttpStatus.NOT_FOUND),
    MT5_ACCOUNT_CREATION_FAILED("TRADING_500", "MT5 account creation failed", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_ACCOUNT_TYPE("TRADING_400", "Invalid account type", HttpStatus.BAD_REQUEST);

    private final String code;
    private final String defaultMessage;
    private final HttpStatus httpStatus;

    ErrorCode(String code, String defaultMessage, HttpStatus httpStatus) {
        this.code = code;
        this.defaultMessage = defaultMessage;
        this.httpStatus = httpStatus;
    }
}