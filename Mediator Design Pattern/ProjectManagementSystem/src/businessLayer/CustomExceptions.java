package businessLayer;

public class CustomExceptions {

    public static class ProjectNotFoundException extends Exception{
        public ProjectNotFoundException(String message, Throwable cause){
            super(message, cause);
        }
    }

    public static class EmptyFieldNotAllowedException extends Exception{
        public EmptyFieldNotAllowedException(String message, Throwable cause){
            super(message, cause);
        }
    }
    public static class NotAcceptedDateFormat extends Exception{
        public NotAcceptedDateFormat(String message, Throwable cause){
            super(message, cause);
        }
    }
    public static class NotAcceptableData extends Exception{
        public NotAcceptableData(String message, Throwable cause){
            super(message, cause);
        }
    }
}
