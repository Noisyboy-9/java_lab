public class ClockDisplay {
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private NumberDisplay seconds;
    private String displayString;

    /**
     * Constructor for ClockDisplay objects. This constructor creates a new clock
     * set at 00:00.
     */
    public ClockDisplay() {
        this.hours = new NumberDisplay(24);
        this.minutes = new NumberDisplay(60);
        this.seconds = new NumberDisplay(60);

        this.updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor creates a new clock
     * set at the time specified by the parameters.
     * 
     * @param int hour
     * @param int minute
     * @param int second
     */
    public ClockDisplay(int hour, int minute, int second) {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        this.setTime(hour, minute, second);
    }

    /**
     * This method should get called once every minute - it makes the clock display
     * go one minute forward.
     */
    public void timeTick() {
        seconds.increment();
        if (seconds.getValue() == 0) {
            // a minute has been passed by
            minutes.increment();
            if (minutes.getValue() == 0) {
                // an hour has been passed by
                hours.increment();
            }
        }
        this.updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and minute.
     */
    public void setTime(int hour, int minute, int second) {
        this.hours.setValue(hour);
        this.minutes.setValue(minute);
        this.seconds.setValue(second);

        this.updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime() {
        return this.displayString;
    }

    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay() {
        displayString = this.hours.getDisplayValue() + ":" + this.minutes.getDisplayValue() + ":"
                + this.seconds.getDisplayValue();
    }
}
