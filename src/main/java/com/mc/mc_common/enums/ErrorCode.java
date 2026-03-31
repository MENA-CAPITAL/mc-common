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
    TITLE_REQUIRED("KYC_PERSONAL_402", "Title is required", HttpStatus.BAD_REQUEST),
    ADDRESS_LINE1_REQUIRED("KYC_PERSONAL_403", "Address line 1 is required", HttpStatus.BAD_REQUEST),
    CITY_REQUIRED("KYC_PERSONAL_404", "City is required", HttpStatus.BAD_REQUEST),
    KYC_TYPE_REQUIRED("KYC_PERSONAL_405", "KYC type is required", HttpStatus.BAD_REQUEST),
    INVALID_KYC_TYPE("KYC_PERSONAL_406", "Invalid KYC type", HttpStatus.BAD_REQUEST),
    KYC_ALREADY_SUBMITTED("KYC_PERSONAL_409", "KYC already submitted", HttpStatus.CONFLICT),

    // ================= KYC - FINANCIAL =================
    FINANCIAL_KYC_NOT_FOUND("KYC_FIN_404", "Financial KYC not found", HttpStatus.NOT_FOUND),
    EMPLOYMENT_STATUS_REQUIRED("KYC_FIN_400", "Employment status is required", HttpStatus.BAD_REQUEST),
    SOURCE_OF_FUNDS_REQUIRED("KYC_FIN_401", "Source of funds is required", HttpStatus.BAD_REQUEST),
    FINANCIAL_ALREADY_SUBMITTED("KYC_FIN_409", "Financial KYC already submitted", HttpStatus.CONFLICT),
    INCOME_REQUIRED("KYC_FIN_402", "Annual income is required", HttpStatus.BAD_REQUEST),
    INVALID_EMPLOYMENT_STATUS("KYC_FIN_403", "Invalid employment status", HttpStatus.BAD_REQUEST),
    FINANCIAL_EXPERIENCE_REQUIRED("KYC_FIN_404", "Financial experience is required", HttpStatus.BAD_REQUEST),
    DERIVATIVES_SUITABILITY_REQUIRED("KYC_FIN_405", "Derivatives suitability is required", HttpStatus.BAD_REQUEST),

    // ================= KYC - DECLARATION / COMPANY =================
    UBO_IDENTIFIED_REQUIRED("KYC_DECL_400", "UBO identification is required", HttpStatus.BAD_REQUEST),
    UBO_PEP_DETAILS_REQUIRED("KYC_DECL_401", "UBO PEP details are required", HttpStatus.BAD_REQUEST),
    COMPANY_FINANCIAL_DATA_MISSING("KYC_DECL_402", "Company financial data is missing", HttpStatus.BAD_REQUEST),
    LEGAL_STRUCTURE_REQUIRED("KYC_DECL_403", "Legal structure is required", HttpStatus.BAD_REQUEST),
    NATURE_OF_BUSINESS_REQUIRED("KYC_DECL_404", "Nature of business is required", HttpStatus.BAD_REQUEST),
    COUNTRY_OF_INCORPORATION_REQUIRED("KYC_DECL_405", "Country of incorporation is required", HttpStatus.BAD_REQUEST),
    ANNUAL_INCOME_REQUIRED("KYC_DECL_406", "Annual income is required", HttpStatus.BAD_REQUEST),
    NET_ASSETS_REQUIRED("KYC_DECL_407", "Net assets value is required", HttpStatus.BAD_REQUEST),
    SOURCE_OF_WEALTH_REQUIRED("KYC_DECL_408", "Source of wealth is required", HttpStatus.BAD_REQUEST),
    INITIAL_DEPOSIT_REQUIRED("KYC_DECL_409", "Initial deposit range is required", HttpStatus.BAD_REQUEST),
    TRADING_VOLUME_REQUIRED("KYC_DECL_410", "Trading volume range is required", HttpStatus.BAD_REQUEST),
    ACCOUNT_PURPOSE_REQUIRED("KYC_DECL_411", "Account purpose is required", HttpStatus.BAD_REQUEST),
    UBO_PEP_REQUIRED("KYC_DECL_412", "UBO PEP selection is required", HttpStatus.BAD_REQUEST),
    DECLARATION_NOT_FOUND("KYC_DECL_413", "Declaration not found", HttpStatus.NOT_FOUND),
    DECLARATION_ALREADY_SUBMITTED("KYC_DECL_414", "Declaration already submitted", HttpStatus.CONFLICT),

    // ===================================== SUMSUB ======================================
    SUMSUB_REQUEST_FAILED("KYC_SUMSUB_500", "Sumsub request failed", HttpStatus.INTERNAL_SERVER_ERROR),
    SUMSUB_SIGN_FAILED("KYC_SUMSUB_501", "Sumsub signature generation failed", HttpStatus.INTERNAL_SERVER_ERROR),
    SUMSUB_APPLICANT_ID_MISSING("KYC_SUMSUB_400", "Sumsub applicant ID missing", HttpStatus.BAD_REQUEST),
    SUMSUB_CREATE_APPLICANT_FAILED("KYC_SUMSUB_401", "Failed to create Sumsub applicant", HttpStatus.INTERNAL_SERVER_ERROR),
    SUMSUB_APPLICANT_NOT_CREATED("KYC_SUMSUB_402", "Sumsub applicant not created", HttpStatus.BAD_REQUEST),
    SUMSUB_TOKEN_MISSING("KYC_SUMSUB_403", "Sumsub access token missing", HttpStatus.BAD_REQUEST),
    SUMSUB_TOKEN_FAILED("KYC_SUMSUB_404", "Failed to generate Sumsub token", HttpStatus.INTERNAL_SERVER_ERROR),
    KYC_NOT_STARTED("KYC_SUMSUB_405", "KYC process not started", HttpStatus.BAD_REQUEST),

    // ================= WALLET / TRANSACTION =================
    WALLET_NOT_FOUND("TXN_404_WALLET", "Wallet not found", HttpStatus.NOT_FOUND),
    INSUFFICIENT_BALANCE("TXN_400_BAL", "Insufficient balance", HttpStatus.BAD_REQUEST),
    INVALID_TRANSACTION("TXN_400", "Invalid transaction", HttpStatus.BAD_REQUEST),
    TRANSACTION_FAILED("TXN_500", "Transaction failed", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_DEPOSIT_AMOUNT("TXN_401", "Invalid deposit amount", HttpStatus.BAD_REQUEST),

    // ================= TRADING ACCOUNT =================
    ACCOUNT_NOT_FOUND("TA-001", "Trading account not found", HttpStatus.NOT_FOUND),

    ACCOUNT_ALREADY_EXISTS("TA-002", "Trading account already exists for this type", HttpStatus.CONFLICT),

    MT5_ACCOUNT_CREATION_FAILED("TA-003", "Failed to create MT5 trading account", HttpStatus.BAD_GATEWAY),

    MT5_ACCOUNT_FETCH_FAILED("TA-004", "Failed to fetch MT5 account data", HttpStatus.BAD_GATEWAY),

    MT5_PASSWORD_CHANGE_FAILED("TA-005", "Failed to change MT5 account password", HttpStatus.BAD_GATEWAY),

    ACCOUNT_DISABLED("TA-006", "Trading account is disabled", HttpStatus.BAD_REQUEST),

    ACCOUNT_CLOSED("TA-007", "Trading account is closed", HttpStatus.BAD_REQUEST),

    INVALID_ACCOUNT_STATUS("TA-008", "Invalid account status transition", HttpStatus.BAD_REQUEST),

    INVALID_ACCOUNT_TYPE("TA-009", "Invalid trading account type", HttpStatus.BAD_REQUEST),

    INVALID_LEVERAGE("TA-010", "Invalid leverage value", HttpStatus.BAD_REQUEST),

    DUPLICATE_MT5_LOGIN("TA-011", "MT5 login already mapped", HttpStatus.CONFLICT),

    AUDIT_LOG_FAILED("TA-012", "Failed to save audit log", HttpStatus.INTERNAL_SERVER_ERROR),

    MT5_SERVICE_UNAVAILABLE("TA-013", "MT5 worker service is unavailable", HttpStatus.BAD_GATEWAY);

    private final String code;
    private final String defaultMessage;
    private final HttpStatus httpStatus;

    ErrorCode(String code, String defaultMessage, HttpStatus httpStatus) {
        this.code = code;
        this.defaultMessage = defaultMessage;
        this.httpStatus = httpStatus;
    }
}