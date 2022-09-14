package exception;

public class MyException extends RuntimeException {

    private ErrorCode errorCode;

    private String desc;

    private Object[] objects;

    public MyException(ErrorCode errorCode, String desc, Object... objects) {
        this.desc = desc;
        this.errorCode = errorCode;
        this.objects = objects;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getDesc() {
        return desc;
    }

    public Object[] getObjects() {
        return objects;
    }
}
