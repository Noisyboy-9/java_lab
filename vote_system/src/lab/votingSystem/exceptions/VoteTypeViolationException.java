package lab.votingSystem.exceptions;

public class VoteTypeViolationException extends Exception {
    public VoteTypeViolationException(String message) {
        super(message);
    }
}
