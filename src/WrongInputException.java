public class WrongInputException extends RuntimeException {
    public WrongInputException() {
        super("The input is wrong");
    }

    public WrongInputException(String message) {
        super(message);
    }
}
