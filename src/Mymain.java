public class Mymain {

    public static final int DELAY = 10;
    public static final int STEPS = 100;
    public static final double MAX_AMOUNT = 1000;

    public static void main(String[] args) {
//create bank. 4 accounts with 100000 each
        var bank = new Bank(4, 100000);
        // 1st runnable
        Runnable task = () ->
        {
            try
            {
                for (int i = 0; i < STEPS; i++)
                {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(0, 1, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // 2st runnable
        Runnable task2 = () ->
        {
            try
            {
                for (int i = 0; i < STEPS; i++)
                {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(2, 3, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(task, "1st").start();
        new Thread(task2, "2nd").start();

        //Same without threads

//        task.run();
//        task2.run();
//
    }
}
