public class MainApplication {
    public static void main(String[] args) {
        Design design1 = new Design("Narendra Modi", 1);
        VotingRunnable voting1 = new VotingRunnable(design1);
        CountRunnable counting1 = new CountRunnable(design1);
        Thread votingThread1 = new Thread(voting1);
        Thread countingThread1 = new Thread(counting1);
        votingThread1.start();
        countingThread1.start();

        Design design2 = new Design("Rahul Gandhi", 2);
        VotingRunnable voting2 = new VotingRunnable(design2);
        CountRunnable counting2 = new CountRunnable(design2);
        Thread votingThread2 = new Thread(voting2);
        Thread countingThread2 = new Thread(counting2);
        votingThread2.start();
        countingThread2.start();

        Design design3 = new Design("Mamta Banerjee", 3);
        VotingRunnable voting3 = new VotingRunnable(design3);
        CountRunnable counting3 = new CountRunnable(design3);
        Thread votingThread3 = new Thread(voting3);
        Thread countingThread3 = new Thread(counting3);
        votingThread3.start();
        countingThread3.start();
    }
}
