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
    EMAIL_NOT_VERIFIED("AUTH_403_002", "Email verification pending",HttpStatus.FORBIDDEN),

    USER_NOT_FOUND("USER_404", "User not found", HttpStatus.NOT_FOUND),
    USER_ALREADY_EXISTS("USER_409", "User already exists", HttpStatus.CONFLICT),
    INVALID_USER_STATUS("USER_400", "Invalid user status", HttpStatus.BAD_REQUEST),
    EMAIL_ALREADY_EXISTS("USER_409_EMAIL", "Email already exists", HttpStatus.CONFLICT),

    INVALID_PASSWORD("USER_PWD_400", "Invalid password", HttpStatus.BAD_REQUEST),
    CURRENT_PASSWORD_INVALID("USER_PWD_401", "Current password is incorrect", HttpStatus.BAD_REQUEST),
    PASSWORD_MISMATCH("USER_PWD_402", "Password mismatch", HttpStatus.BAD_REQUEST),
    NEW_PASSWORD_SAME_AS_OLD_PASSWORD("USER_PWD_403", "New password cannot be same as old password", HttpStatus.BAD_REQUEST),
    INVALID_STAGE("USER_STAGE_400", "Invalid client stage", HttpStatus.BAD_REQUEST),
    INVALID_MANUAL_STAGE_UPDATE("USER_STAGE_401", "Manual stage update is not allowed", HttpStatus.BAD_REQUEST),
    INVALID_STATUS("USER_STATUS_400", "Invalid account status", HttpStatus.BAD_REQUEST),
    SALES_USER_REQUIRED("USER_REQUIRED_400", "Sales User is not found",HttpStatus.BAD_REQUEST),
    FEATURE_NOT_IMPLEMENTED("FEATURE_NOT_IMPLEMENTED_400", "feature need to be implemented", HttpStatus.BAD_REQUEST),

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
    FAMILY_NAME_REQUIRED("KYC_PERSONAL_410", "Family name is required", HttpStatus.BAD_REQUEST),
    ARABIC_NAME_REQUIRED("KYC_PERSONAL_411", "Arabic name is required", HttpStatus.BAD_REQUEST),
    NATIONALITY_REQUIRED("KYC_PERSONAL_412", "Nationality is required", HttpStatus.BAD_REQUEST),
    COUNTRY_OF_RESIDENCE_REQUIRED("KYC_PERSONAL_413", "Country of residence is required", HttpStatus.BAD_REQUEST),
    COUNTRY_OF_BIRTH_REQUIRED("KYC_PERSONAL_414", "Country of birth is required", HttpStatus.BAD_REQUEST),
    NATIONAL_ID_REQUIRED("KYC_PERSONAL_415", "National ID is required", HttpStatus.BAD_REQUEST),
    NATIONAL_ID_EXPIRY_REQUIRED("KYC_PERSONAL_416", "National ID expiry is required", HttpStatus.BAD_REQUEST),
    PASSPORT_NUMBER_REQUIRED("KYC_PERSONAL_417", "Passport number is required", HttpStatus.BAD_REQUEST),
    PASSPORT_EXPIRY_REQUIRED("KYC_PERSONAL_418", "Passport expiry is required", HttpStatus.BAD_REQUEST),
    PASSPORT_ISSUED_COUNTRY_REQUIRED("KYC_PERSONAL_419", "Passport issued country is required", HttpStatus.BAD_REQUEST),
    REGION_REQUIRED("KYC_PERSONAL_420", "Region is required", HttpStatus.BAD_REQUEST),


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

    // ================= BANK CONFIGURATION =================
    BANK_NOT_FOUND("BANK_404", "Bank not found", HttpStatus.NOT_FOUND),
    BANK_ALREADY_EXISTS("BANK_409", "Bank already exists", HttpStatus.CONFLICT),
    BANK_INACTIVE("BANK_400", "Bank is inactive", HttpStatus.BAD_REQUEST),

    BANK_ACCOUNT_NOT_FOUND("BANK_ACC_404", "Bank account not found", HttpStatus.NOT_FOUND),
    BANK_ACCOUNT_ALREADY_EXISTS("BANK_ACC_409", "Bank account already exists", HttpStatus.CONFLICT),
    BANK_ACCOUNT_INACTIVE("BANK_ACC_400", "Bank account is inactive", HttpStatus.BAD_REQUEST),
    INVALID_BANK_CURRENCY("BANK_ACC_400_CUR", "Invalid currency for selected bank", HttpStatus.BAD_REQUEST),


    // ================= DEPOSIT =================
    DEPOSIT_TICKET_NOT_FOUND("DEP_404", "Deposit request not found", HttpStatus.NOT_FOUND),
    INVALID_DEPOSIT_METHOD("DEP_400_METHOD", "Invalid deposit method", HttpStatus.BAD_REQUEST),
    BANK_DETAILS_REQUIRED("DEP_400_BANK", "Bank details must be added before deposit", HttpStatus.BAD_REQUEST),
    INVALID_DEPOSIT_REQUEST("DEP_400_REQ", "Invalid deposit request", HttpStatus.BAD_REQUEST),
    DEPOSIT_ALREADY_PROCESSED("DEP_409", "Deposit already processed", HttpStatus.CONFLICT),
    DEPOSIT_LIMIT_EXCEEDED("TXN_400_LIMIT", "Deposit exceeds allowed limit", HttpStatus.BAD_REQUEST),
    INVALID_DEPOSIT_RULE("TXN_400_RULE", "Invalid deposit rule configuration", HttpStatus.BAD_REQUEST),


    // ================= WITHDRAWAL =================
    WITHDRAWAL_TICKET_NOT_FOUND("WDR_404", "Withdrawal request not found", HttpStatus.NOT_FOUND),
    INVALID_WITHDRAWAL_AMOUNT("WDR_400_AMT", "Invalid withdrawal amount", HttpStatus.BAD_REQUEST),
    WITHDRAWAL_ALREADY_PROCESSED("WDR_409", "Withdrawal already processed", HttpStatus.CONFLICT),
    WITHDRAWAL_NOT_ALLOWED("WDR_403", "Withdrawal not allowed", HttpStatus.FORBIDDEN),


    // ================= TRANSACTION EXTENSIONS =================
    INVALID_BANK_ACCOUNT_TYPE("TXN_400_ACC", "Invalid account type", HttpStatus.BAD_REQUEST),
    MT5_OPERATION_FAILED("TXN_502_MT5", "MT5 operation failed", HttpStatus.BAD_GATEWAY),
    CONCURRENT_TRANSACTION("TXN_409_CONFLICT", "Concurrent transaction detected", HttpStatus.CONFLICT),
    INVALID_PAYMENT_ACCOUNT("TXN_400_PAYMENT", "Invalid payment account", HttpStatus.BAD_REQUEST),
    INSUFFICIENT_MT5_BALANCE("TXN_400_MT5_BAL", "Insufficient MT5 balance", HttpStatus.BAD_REQUEST),
    INVALID_AMOUNT("TXN_400_INV_AMT","Invalid amount provided",HttpStatus.BAD_REQUEST),
    DEPOSITS_DISABLED("TXN_400_DPST_DISABLED","Deposit is disabled for this user",HttpStatus.BAD_REQUEST),
    WITHDRAWALS_DISABLED("TXN_400_WDRL_DISABLED","Withdrawal is disabled for this user",HttpStatus.BAD_REQUEST),
    WALLET_TO_MT5_DISABLED("TXN_400_WLT_TO_MT5_DISABLED","Wallet to MT5 is disabled for this user",HttpStatus.BAD_REQUEST),
    MT5_TO_WALLET_DISABLED("TXN_400_MT5_TO_WALT_DISABLED","MT5 to Wallet is disabled for this user",HttpStatus.BAD_REQUEST),


    // ================= REPORTS =================
    REPORT_DATA_NOT_FOUND("RPT_404", "Report data not found", HttpStatus.NOT_FOUND),
    INVALID_REPORT_FILTER("RPT_400_FILTER", "Invalid report filter", HttpStatus.BAD_REQUEST),
    EXPORT_FAILED("RPT_500_EXPORT", "Report export failed", HttpStatus.INTERNAL_SERVER_ERROR),
    EMAIL_FAILED("RPT_500_EMAIL", "Failed to send report email", HttpStatus.INTERNAL_SERVER_ERROR),

    // ================= FILE UPLOAD =================
    FILE_UPLOAD_FAILED("FILE_500", "File upload failed", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_FILE_TYPE("FILE_400_TYPE", "Invalid file type", HttpStatus.BAD_REQUEST),
    FILE_TOO_LARGE("FILE_400_SIZE", "File size exceeds limit", HttpStatus.BAD_REQUEST),
    FILE_NOT_FOUND("FILE_404", "File not found", HttpStatus.NOT_FOUND),


    // ================= GENERAL =================
    DATA_NOT_FOUND("GEN_404", "Requested data not found", HttpStatus.NOT_FOUND),
    OPERATION_NOT_ALLOWED("GEN_403", "Operation not allowed", HttpStatus.FORBIDDEN),

    // ================= Ticket =================
    SUPPORT_ROUTING_NOT_ALLOWED("SUPPORT_001","Support routing is not allowed.",HttpStatus.FORBIDDEN),

    SUPPORT_SOURCE_ROLE_REQUIRED("SUPPORT_002","Source role is required.",HttpStatus.BAD_REQUEST),

    SUPPORT_TARGET_ROLE_REQUIRED("SUPPORT_003","Target role is required.",HttpStatus.BAD_REQUEST),

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

    INVALID_RESPONSE("TA-14", "Provided invalid data",HttpStatus.BAD_REQUEST),

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