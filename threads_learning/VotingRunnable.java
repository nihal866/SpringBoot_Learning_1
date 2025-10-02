public class VotingRunnable implements Runnable {

    private Design design;

    public VotingRunnable(Design design) {
        this.design = design;
    }

    @Override
    public void run() {
        System.out.println("Voting for design: " + design.getName());
        design.getVotes().add(1);
    }

}
