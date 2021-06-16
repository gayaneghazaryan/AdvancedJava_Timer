public class MyTimer extends Thread {
    private int minutes;
    private int seconds;

    public MyTimer(int minutes, int seconds) {
        setMinutes(minutes);
        setSeconds(seconds);
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if(minutes < 0 || minutes > 59) {
            throw new WrongInputException();
        }
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        if(seconds < 0 || seconds > 59) {
            throw new WrongInputException();
        }
        this.seconds = seconds;
    }

    @Override
    public void run() {
        int time = (minutes * 60) + seconds;
        int changing_minutes = minutes;
        int changing_seconds = seconds;

        for (int i = 0; i <= time ; i++) {

            //printing format
            if(changing_minutes <= 9) {
                if(changing_seconds <= 9)
                    System.out.printf("0%d:0%d\n",changing_minutes,changing_seconds);
                else
                    System.out.printf("0%d:%d\n",changing_minutes,changing_seconds);
            } else {
                if(changing_seconds <= 9)
                    System.out.printf("%d:0%d\n",changing_minutes,changing_seconds);
                else
                    System.out.printf("%d:%d\n",changing_minutes,changing_seconds);
            }

            //decrement
            if(changing_seconds == 0) {
                changing_minutes--;
                changing_seconds = 59;
            } else
                changing_seconds--;

            //time
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
