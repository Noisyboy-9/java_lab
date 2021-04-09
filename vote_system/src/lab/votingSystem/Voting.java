package lab.votingSystem;

import lab.votingSystem.enums.VotingTypeHandler;
import lab.votingSystem.exceptions.DuplicateVoterException;
import lab.votingSystem.exceptions.InvalidVotingTypeException;
import lab.votingSystem.exceptions.VoteTypeViolationException;

import java.util.*;

/**
 * A voting that has some options , question and voters.
 */
public class Voting {
    private final int[] allowedVoteTypes = {VotingTypeHandler.MULTI_VOTE, VotingTypeHandler.SINGLE_VOTE};
    private final int type;
    private final String question;
    private HashSet<String> options;
    private ArrayList<Person> voters;
    private HashMap<String, HashSet<Vote>> resultsPerOption;

    /**
     * Instantiates a new Voting.
     *
     * @param type     the type
     * @param question the question
     * @throws InvalidVotingTypeException the invalid voting type exception
     */
    public Voting(int type, String question) throws InvalidVotingTypeException {
        this(type, question, new HashSet<String>());

    }

    public Voting(int type, String question, HashSet<String> options) throws InvalidVotingTypeException {
        if (Collections.singletonList(this.allowedVoteTypes).contains(type)) {
            throw new InvalidVotingTypeException("invalid voting type");
        }

        this.type = type;
        this.question = question;
        this.options = options;

        this.voters = new ArrayList<Person>();
        this.resultsPerOption = new HashMap<String, HashSet<Vote>>();
    }

    /**
     * Gets voting type.
     *
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * Get voting question.
     *
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Add an option to the voting.
     *
     * @param option the option
     */
    public void addOption(String option) {
        this.options.add(option);
    }

    /**
     * vote for multiple of options if the voting type is multi-vote.
     *
     * @param voter           the voter
     * @param selectedOptions the votes
     * @throws VoteTypeViolationException the vote type violation exception
     * @throws DuplicateVoterException    the duplicate voter exception
     */
    public void vote(Person voter, ArrayList<String> selectedOptions) throws VoteTypeViolationException, DuplicateVoterException {
        if (this.type != VotingTypeHandler.MULTI_VOTE) {
            throw new VoteTypeViolationException("Voting type is single-vote, can not pass a ArrayList of strings");
        }

        if (this.voters.contains(voter)) {
            throw new DuplicateVoterException(voter.getName() + " has already voted!");
        }

        this.voters.add(voter);

        for (String selectedOption : selectedOptions) {
            if (!this.resultsPerOption.containsKey(selectedOption)) {
//                this is the first vote for this option
                HashSet<Vote> voteSet = new HashSet<Vote>();
                voteSet.add(new Vote(voter, new Date()));

                this.resultsPerOption.put(selectedOption, voteSet);
                continue;
            }

//            this isn't the first vote for this option
            HashSet<Vote> voteSet = this.resultsPerOption.get(selectedOption);
            voteSet.add(new Vote(voter, new Date()));

            this.resultsPerOption.put(selectedOption, voteSet);
        }
    }


    /**
     * vote for single option if vote type is single-vote.
     *
     * @param voter          the voter
     * @param selectedOption the selected option
     * @throws VoteTypeViolationException the vote type violation exception
     * @throws DuplicateVoterException    the duplicate voter exception
     */
    public void vote(Person voter, String selectedOption) throws VoteTypeViolationException, DuplicateVoterException {
        if (this.type != VotingTypeHandler.SINGLE_VOTE) {
            throw new VoteTypeViolationException("Voting type is multi-vote, can not pass a single vote string.");
        }

        if (this.voters.contains(voter)) {
            throw new DuplicateVoterException(voter.getName() + " has already voted!");
        }

        this.voters.add(voter);

        HashSet<Vote> voteSet = this.resultsPerOption.containsKey(selectedOption) ?
                this.resultsPerOption.get(selectedOption) :
                new HashSet<Vote>();

        voteSet.add(new Vote(voter, new Date()));

        this.resultsPerOption.put(selectedOption, voteSet);
    }


    /**
     * Gets voters.
     *
     * @return the voters
     */
    public ArrayList<Person> getVoters() {
        return voters;
    }

    /**
     * print count of votes for each option.
     */
    public void printResultsPerOption() {
        for (String option : this.options) {
            if (!this.resultsPerOption.containsKey(option)) {
//                no vote has been added for the option
                System.out.println(option + " : 0");
                continue;
            }

//            vote has been added for the option
            HashSet<Vote> votes = this.resultsPerOption.get(option);
            System.out.println(option + " : " + votes.size());
        }
    }

    /**
     * Gets options of the voting.
     *
     * @return the options
     */
    public HashSet<String> getOptions() {
        return options;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Voting voting = (Voting) obj;
        return type == voting.type && question.equals(voting.question) && Objects.equals(options, voting.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, question, options);
    }
}
