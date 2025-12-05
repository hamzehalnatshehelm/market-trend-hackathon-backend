package elm.hackathon.markettrands.user_management.general.exception.enums;


import lombok.Getter;

@Getter
public enum ErrorCode {

    // Not Found
    NOT_FOUND_SMS("not.found.sms"),
    NOT_FOUND_USER("not.found.user"),
    NOT_FOUND_CITY("not.found.city"),
    NOT_FOUND_RENTER("not.found.renter"),
    NOT_FOUND_TENANT("not.found.tenant"),
    NOT_FOUND_POLICY("not.found.policy"),
    NOT_FOUND_PERSON("not.found.person"),
    NOT_FOUND_REGION("not.found.region"),
    NOT_FOUND_ACTION("not.found.action"),
    NOT_FOUND_MARKET("not.found.market"),
    NOT_FOUND_PAYMENT("not.found.payment"),
    NOT_FOUND_CONTRACT("not.found.contract"),
    NOT_FOUND_DISTRICT("not.found.district"),
    NOT_FOUND_ATTACHMENT("not.found.attachment"),
    NOT_FOUND_USER_MARKET("not.found.user.market"),
    NOT_FOUND_NATIONALITY("not.found.nationality"),
    NOT_FOUND_MARKET_UNIT("not.found.market.unit"),
    NOT_FOUND_OPERATION_TYPE("not.found.operation.type"),
    NOT_FOUND_ACCOUNT_ID_NUMBER("not.found.account.id.number"),
    NOT_FOUND_ATTACHMENT_CONFIG("not.found.attachment.config"),
    NOT_FOUND_RENTAL_MARKET_UNIT("not.found.rental.market.unit"),
    NOT_FOUND_SYSTEM_NOTIFICATION("not.found.system.notification"),
    NOT_FOUND_AUTHORIZED_DOCUMENT("not.found.authorized.document"),
    NOT_FOUND_COMMERCIAL_REGISTER("not.found.commercial.register"),
    NOT_FOUND_AGRI_SERV_INVOICE_PDF("not.found.agri.serv.invoice.pdf"),
    NOT_FOUND_AGRICULTURAL_REGISTER("not.found.agricultural.register"),
    NOT_FOUND_QUICK_TIK_INVESTOR_INFO("not.found.quick.tik.investor.info"),
    NOT_FOUND_RENTAL_MARKET_UNIT_PAYMENT("not.found.rental.market.unit.payment"),
    NOT_FOUND_RENTAL_MARKET_UNIT_AND_INVOICE_ID("not.found.rental.market.unit.and.invoice.id"),
    NOT_FOUND_ATTACHMENT_AT_LEAST_ONE_ATTACHMENT("not.found.attachment.at.least.one.attachment"),
    NOT_FOUND_COMMERCIAL_REGISTER_AND_AGRICULTURAL_REGISTER("not.found.commercial.register.and.agricultural.register"),

    // Not Allowed
    NOT_ALLOWED_ROLE("not.allowed.role"),
    NOT_ALLOWED_ACTION("not.allowed.action"),
    NOT_ALLOWED_EMPTY_FILE("not.allowed.empty.file"),
    NOT_ALLOWED_SAVE_DRAFT("not.allowed.save.draft"),
    NOT_ALLOWED_MEDIA_TYPE("not.allowed.media.type"),
    NOT_ALLOWED_REJECT_USER("not.allowed.reject.user"),
    NOT_ALLOWED_APPROVE_USER("not.allowed.approve.user"),
    NOT_ALLOWED_STATUS_CHANGE("not.allowed.status.change"),
    NOT_ALLOWED_UPDATE_POLICY("not.allowed.update.policy"),
    NOT_ALLOWED_CREATE_CONTRACT("not.allowed.create.contract"),
    NOT_ALLOWED_TO_RENEW_CONTRACT("not.allowed.renew.contract"),
    NOT_ALLOWED_TO_DOWNLOAD_CONTENT("not.allowed.download.content"),
    NOT_ALLOWED_UPDATE_REJECT_USER("not.allowed.update.reject.user"),
    NOT_ALLOWED_TO_DELETE_RENTAL_UNIT("not.allowed.delete.rental.unit"),
    NOT_ALLOWED_POLICY_FOR_UNIT_TYPE("not.allowed.policy.for.unit.type"),
    NOT_ALLOWED_CREATE_MARKET_UNIT_FOR_RENT("not.allowed.unit.for.rent"),
    NOT_ALLOWED_RENEW_REQUEST_EXISTS("not.allowed.renew.request.exists"),
    NOT_ALLOWED_CANCEL_REQUEST_EXISTS("not.allowed.cancel.request.exists"),
    NOT_ALLOWED_AMOUNT_UNDER_NINE_SAR("not.allowed.amount.under.nine.sar"),
    NOT_ALLOWED_RENT_UNIT_CANCELED("not.allowed.rent.unit.already.cancelled"),
    NOT_ALLOWED_REGISTRATION_STEP_CHANGE("not.allowed.registration.step.change"),
    NOT_ALLOWED_START_DATE_AFTER_END_DATE("not.allowed.start.date.after.end.date"),
    NOT_ALLOWED_CONTRACT_ALREADY_CANCELED("not.allowed.contract.already.canceled"),
    NOT_ALLOWED_DELETE_POLICY_ACTIVE_UNIT("not.allowed.delete.policy.active.units"),
    NOT_ALLOWED_ENABLE_DISABLE_SUPER_ADMIN("not.allowed.enable.disable.super.admin"),
    NOT_ALLOWED_REGISTER_USER_ALREADY_PENDING("not.allowed.register.user.same.pending"),
    NOT_ALLOWED_ENABLE_DISABLE_REJECTED_USER("not.allowed.enable.disable.rejected.user"),
    NOT_ALLOWED_AMOUNT_UNDER_TWENTY_FIVE_SAR("not.allowed.amount.under.twenty.five.sar"),
    NOT_ALLOWED_START_DATE_BEFORE_PARENT_END_DATE("not.allowed.start.date.after.end.date"),
    NOT_ALLOWED_TO_CREATE_RENTAL_WITH_NO_POLICY("not.allowed.create.rental.with.no.policy"),
    NOT_ALLOWED_REGISTER_USER_SAME_MARKET_AND_ROLE("not.allowed.register.user.same.market.role"),
    NOT_ALLOWED_DELETE_MARKET_WITH_APPROVED_UNIT("not.allowed.delete.market.with.approved.unit"),
    NOT_ALLOWED_PAYMENT_LESS_THAN_TWENTY_FIVE_SAR("not.allowed.payment.less.than.twenty.five.sar"),
    NOT_ALLOWED_SAVE_RENTAL_CASE_UNIT_SAVED_BEFORE("not.allowed.save.rental.case.unit.saved.before"),
    NOT_ALLOWED_RENT_UNIT_USER_HAS_ADMIN_MANAGER_ROLE("not.allowed.rent.unit.user.has.admin.manager"),
    NOT_ALLOWED_RENT_UNIT_USER_HAS_ADMIN_MANAGER_ROLE_CR("not.allowed.rent.unit.user.has.admin.manager.cr"),
    NOT_ALLOWED_DELETE_MARKET_UNIT_WITH_RENTAL_REQUEST("not.allowed.delete.market.unit.with.rental.requests"),
    NOT_ALLOWED_ADD_RENTAL_WITH_UNIT_ACTIVITY_TYPE_NULL("not.allowed.add.rental.with.unit.activity.type.null"),
    NOT_ALLOWED_RENTAL_END_DATE_AFTER_INVESTMENT_CONTRACT_END_DATE("not.allowed.rental.end.date.after.investment.contract.end.date"),

    // Invalid
    INVALID_OTP("invalid.otp"),
    INVALID_TOKEN("invalid.token"),
    INVALID_DATE_FORMAT("invalid.date.format"),
    INVALID_IBAN_NUMBER("invalid.iban.number"),
    INVALID_CONVERT_NUMBER("invalid.convert.number"),
    INVALID_TOKEN_SIGNATURE("invalid.token.signature"),
    INVALID_COMMERCIAL_REGISTER_NUMBER("invalid.commercial.register.number"),
    INVALID_AGRICULTURAL_REGISTER_NUMBER("invalid.agricultural.register.number"),

    // Exception
    EXCEPTION_SYSTEM("exception.system"),
    EXCEPTION_JSON_PROCESSING("exception.json.processing"),
    EXCEPTION_UNEXPECTED_TYPE("exception.unexpected.type"),
    EXCEPTION_NO_HANDLER_FOUND("exception.no.handler.found"),
    EXCEPTION_SERVICE_NOT_AVAILABLE("exception.service.not.available"),
    EXCEPTION_DATA_INTEGRITY_VIOLATION("exception.data.integrity.violation"),
    EXCEPTION_HTTP_MESSAGE_NOT_READABLE("exception.http.message.not.readable"),
    EXCEPTION_METHOD_ARGUMENT_NOT_VALID("exception.method.argument.not.valid"),

    // Exist
    EXIST_USER("exist.user"),
    EXIST_PERMIT("exist.permit"),
    EXISTS_LICENSE_NUMBER("exists.license.number"),
    EXISTS_INVESTMENT_CONTRACT_ID("exists.investment.contract.id"),
    EXISTS_UNIT_ID_NUMBER_IN_SAME_MARKET("exists.unit.id.number.in.same.market"),

    // Not Match
    NOT_MATCH_PASSWORDS("not.match.passwords"),

    // Required
    REQUIRED_UNIT_TYPE("required.unit.type"),
    REQUIRED_MARKET_TYPE("required.market.type"),
    REQUIRED_FLOORS_COUNT("required.floors.count"),
    REQUIRED_REJECT_REASON("required.reject.reason"),
    REQUIRED_USER_DIRECTION("required.user.direction"),
    REQUIRED_ELEVATORS_COUNT("required.elevators.count"),
    REQUIRED_ACCOUNT_ID_NUMBER("required.account.id.number"),
    REQUIRED_TAX_CARD_ID_NUMBER("required.tax.card.id.number"),
    REQUIRED_MARKET_INVESTOR_IDS("required.market.investor.ids"),
    REQUIRED_COMMERCIAL_REGISTER("required.commercial.register"),
    REQUIRED_PARKING_SPACE_COUNT("required.parking.space.count"),
    REQUIRED_TECHNICAL_SUPPORT_LEVEL("required.technical.support.level"),
    REQUIRED_USER_MARKET_OPERATION_TYPE("required.user.market.operation.type"),

    // Same
    SAME_EMAIL("same.email"),
    SAME_PASSWORD("same.password"),
    SAME_TAX_NUMBER("same.tax.number"),
    SAME_MOBILE_NUMBER("same.mobile.number"),

    // Expired
    EXPIRED_OTP("expired.otp"),
    EXPIRED_AUTH_TOKEN("expired.auth.token"),
    EXPIRED_PERSON_ID_NUMBER("expired.person.id.number"),
    EXPIRED_AGRICULTURAL_REGISTER("expired.agricultural.register"),
    EXPIRED_NAFATH_REQUEST_STATUS("expired.nafath.request.status"),

    // Auth,
    AUTH_USER_DISABLED("auth.user.disabled"),
    AUTH_WRONG_USER_NAME("auth.wrong.user.name"),
    AUTH_TOKEN_UNSUPPORTED("auth.token.unsupported"),
    AUTH_USER_UNAUTHORIZED("auth.user.unauthorized"),
    AUTH_WRONG_CREDENTIALS("auth.wrong.credentials"),
    AUTH_LOGIN_NOT_COMPLETED("auth.login.not.completed"),
    AUTH_WRONG_USER_PASSWORD("auth.wrong.user.password"),
    AUTH_USER_OTP_UNAUTHORIZED("auth.user.otp.unauthorized"),
    AUTH_TOKEN_HAS_EMPTY_CLAIMS("auth.token.has.empty.claims"),
    AUTH_USER_ALREADY_LOGGED_IN("auth.user.already.logged.id"),
    AUTH_TOKEN_CAN_NOT_BE_TRUSTED("auth.token.can.not.be.trusted"),
    AUTH_TENANT_ALREADY_REGISTERED_INDIVIDUAL("auth.user.already.registered.individual"),
    AUTH_TENANT_ALREADY_REGISTERED_COMPANY_WITH_SAME_CR("auth.user.already.registered.company.with.same.cr"),

    // Other
    ACCESS_DENIED("access.denied"),
    REASON_REQUIRED("reason.required"),
    INACTIVE_TENANT("tenant.account.inactive"),
    FILE_EXCEEDS_MAX_SIZE("file.exceeds.max.size"),
    CANCEL_REASON_REQUIRED("cancel.reason.required"),
    SELECT_AT_LEAST_ONE_UNIT("select.least.one.unit"),
    NOT_SUPPORTED_MEDIA_TYPE("not.supported.media.type"),
    EXPORT_TO_EXCEL_DATA_EMPTY("export.excel.data.empty"),
    FILES_EXCEEDS_ALLOWED_NUMBER("files.exceeds.allowed.number"),
    NOT_ACTIVE_COMMERCIAL_REGISTER("not.active.commercial.register"),
    REJECTED_NAFATH_REQUEST_STATUS("rejected.nafath.request.status"),
    NOT_AVAILABLE_MARKET_UNIT_FOR_RENT("not.available.market.unit.for.rent"),
    INACTIVE_AGRICULTURAL_REGISTER_NUMBER("inactive.agricultural.register.number"),
    NOT_LINKED_UNIFIED_NATIONAL_NUMBER_TO_YOU("not.linked.unified.national.number.to.you"),
    NOT_LINKED_COMMERCIAL_REGISTER_TO_ACCOUNT_NUMBER("not.linked.commercial.register.to.account.number");

    private final String messageCode;

    ErrorCode(String messageCode) {
        this.messageCode = messageCode;
    }

}
