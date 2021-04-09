package lab.votingSystem;

import lab.votingSystem.enums.VotingTypeHandler;
import lab.votingSystem.exceptions.InvalidVotingException;
import lab.votingSystem.exceptions.InvalidVotingTypeException;
import lab.votingSystem.exceptions.VoteTypeViolationException;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InvalidVotingTypeException {
        VotingSystem system = new VotingSystem();
        ArrayList<String> voting1Options = new ArrayList<String>(Arrays.asList("yes", "no"));
        Voting voting1 = system.createVoting("Am I handsome ? 😃", VotingTypeHandler.SINGLE_VOTE, voting1Options);

        Person person1 = new Person("Jane Doe");
        Person person2 = new Person("John Doe");
        Person person3 = new Person("Jack Doe");

        System.out.println("-------------------");
        try {
            system.vote(voting1, person1, "yes");
            system.vote(voting1, person2, "no");
            system.vote(voting1, person3, "yes");
        } catch (VoteTypeViolationException | InvalidVotingException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            system.printVotingResult(voting1);
        } catch (InvalidVotingException exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println("-------------------");

        ArrayList<String> voting2Options = new ArrayList<String>(Arrays.asList("Yes, it is good", "No it is bad", "So So"));
        Voting voting2 = system.createVoting("Java is a good language? 🤔", VotingTypeHandler.MULTI_VOTE, voting2Options);

        ArrayList<String> person1SelectedOptions = new ArrayList<String>(Arrays.asList("Yes, it is good", "No it is bad"));
        ArrayList<String> person2SelectedOptions = new ArrayList<String>(Arrays.asList("No it is bad"));
        ArrayList<String> person3SelectedOptions = new ArrayList<String>(Arrays.asList("No it is bad", "Yes, it is good", "So So"));

        try {
            system.vote(voting2, person1, person1SelectedOptions);
            system.vote(voting2, person2, person2SelectedOptions);
            system.vote(voting2, person3, person3SelectedOptions);
        } catch (VoteTypeViolationException | InvalidVotingException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            system.printVotingResult(voting2);
        } catch (InvalidVotingException exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println("-------------------");
    }
}