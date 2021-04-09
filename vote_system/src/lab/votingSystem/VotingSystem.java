package lab.votingSystem;


import lab.votingSystem.enums.VotingTypeHandler;
import lab.votingSystem.exceptions.DuplicateVoterException;
import lab.votingSystem.exceptions.InvalidVotingException;
import lab.votingSystem.exceptions.InvalidVotingTypeException;
import lab.votingSystem.exceptions.VoteTypeViolationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * voting system that can have lot of votes.
 */
public class VotingSystem {
    private final int[] allowedVoteTypes = {VotingTypeHandler.MULTI_VOTE, VotingTypeHandler.SINGLE_VOTE};
    private ArrayList<Voting> votingList;

    /**
     * Instantiates a new Voting system.
     */
    public VotingSystem() {
        this.votingList = new ArrayList<Voting>();
    }

    /**
     * Create a voting.
     *
     * @param question    the question
     * @param type        the type
     * @param optionsList the options list
     * @return
     */
    public Voting createVoting(String question, int type, ArrayList<String> optionsList) throws InvalidVotingTypeException {
        HashSet<String> optionsSet = new HashSet<String>(optionsList);
        try {
            Voting voting = new Voting(type, question, optionsSet);
            this.votingList.add(voting);
            return voting;
        } catch (InvalidVotingTypeException exception) {
            throw exception;
        }
    }

    /**
     * Gets created voting list.
     *
     * @return the voting list
     */
    public ArrayList<Voting> getVotingList() {
        return votingList;
    }

    /**
     * Get voting by type.
     *
     * @param type the type
     * @return the voting by type
     * @throws InvalidVotingTypeException the invalid voting type exception
     */
    public ArrayList<Voting> getVotingByType(int type) throws InvalidVotingTypeException {
        if (!Arrays.asList(this.allowedVoteTypes).contains(type)) {
            throw new InvalidVotingTypeException("voting type is invalid");
        }

        ArrayList<Voting> votingWithSameType = new ArrayList<>();

        for (Voting voting : this.votingList) {
            if (voting.getType() == type) {
                votingWithSameType.add(voting);
            }
        }

        return votingWithSameType;
    }

    /**
     * Vote to some options when the voting type is multi-vote.
     *
     * @param voting          the voting
     * @param voter           the voter
     * @param selectedOptions the selected options
     * @throws VoteTypeViolationException the vote type violation exception
     */
    public void vote(Voting voting, Person voter, ArrayList<String> selectedOptions) throws VoteTypeViolationException, InvalidVotingException {
        if (!this.votingList.contains(voting)) {
            throw new InvalidVotingException("no voting has been created with specified attributes");
        }

        if (voting.getType() != VotingTypeHandler.MULTI_VOTE) {
            throw new VoteTypeViolationException("voting type is single-vote, can not pass a list of selectedOptions");
        }

        try {
            voting.vote(voter, selectedOptions);
        } catch (VoteTypeViolationException | DuplicateVoterException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * Vote to a single-option when the voting type is single-vote.
     *
     * @param voting         the voting
     * @param voter          the voter
     * @param selectedOption the selected option
     * @throws VoteTypeViolationException the vote type violation exception
     */
    public void vote(Voting voting, Person voter, String selectedOption) throws VoteTypeViolationException, InvalidVotingException {
        if (!this.votingList.contains(voting)) {
            throw new InvalidVotingException("no voting has been created with specified attributes");
        }

        if (voting.getType() != VotingTypeHandler.SINGLE_VOTE) {
            throw new VoteTypeViolationException("voting type is single-vote, can not pass a list of selectedOptions");
        }

        try {
            voting.vote(voter, selectedOption);
        } catch (VoteTypeViolationException | DuplicateVoterException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * print result of the voting
     *
     * @param voting the voting
     * @throws InvalidVotingException the invalid voting exception
     */
    public void printVotingResult(Voting voting) throws InvalidVotingException {
        if (!this.votingList.contains(voting)) {
            throw new InvalidVotingException("no voting has been created with specified attributes");
        }
        System.out.println(voting.getQuestion());
        voting.printResultsPerOption();
    }
}
