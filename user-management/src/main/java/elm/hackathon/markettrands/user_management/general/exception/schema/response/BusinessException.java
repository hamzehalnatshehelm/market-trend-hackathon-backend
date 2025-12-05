package elm.hackathon.markettrands.user_management.general.exception.schema.response;

public class BusinessException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public BusinessException(String message) {
        super(message);
    }
}
