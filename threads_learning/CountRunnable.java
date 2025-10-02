public class CountRunnable implements Runnable {

    private Design design;

    public CountRunnable(Design design) {
        this.design = design;
    }

    @Override
    public void run() {
        System.out.println("Total votes for " + design.getName() + ": " + design.getVotes().size());
    }

}
