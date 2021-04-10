package lab.votingSystem;

import ir.huri.jcal.JalaliCalendar;

import java.util.Date;
import java.util.Objects;

/**
 * A vote that is made when a person makes a vote.
 * Immutable
 */
public final class Vote {
    private final Person voter;
    private final JalaliCalendar date;

    /**
     * Instantiates a new Vote.
     *
     * @param voter the voter
     * @param date  the date
     */
    public Vote(Person voter, JalaliCalendar date) {
        this.voter = voter;
        this.date = date;
    }

    /**
     * Gets person voter.
     *
     * @return the voter
     */
    public Person getVoter() {
        return voter;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public JalaliCalendar getDate() {
        return date;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Vote vote = (Vote) object;
        return voter.equals(vote.voter) && date.equals(vote.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voter, date);
    }
}
