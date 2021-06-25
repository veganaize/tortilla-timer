import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class TortillaTimer {
    static int mSeconds = -1;
    static int mMinutes = -1;
    static int mHours;
    static String mName = "";

    public static void main(String[] args) {

        // Process command line arguments
        for (int i = args.length-1; i >= 0; i--) {
            try {
                int n = Integer.parseInt(args[i]);

                if (mMinutes > -1) mHours = n;
                else if (mSeconds > -1) mMinutes = n;
                else mSeconds = n;

            } catch (NumberFormatException e) {
                mName += args[i] +" ";
            }
        }

        // Decrement and display timer
        new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (--mSeconds < 0) {
                    if (--mMinutes < 0) {
                        if (--mHours < 0) {
                            System.out.print("\b\b\b\b\b\b\b\b\b         \b\b\b\b\b\b\b\b\b");
                            System.out.println("DONE!");
                            System.exit(0);
                        }
                        mMinutes = 59;
                    }
                    mSeconds = 59;
                }

                System.out.print("\b\b\b\b\b\b\b\b\b         \b\b\b\b\b\b\b\b\b");
                System.out.print(mHours +":");
                System.out.print(mMinutes > 9 ? mMinutes : "0"+mMinutes);
                System.out.print(":");
                System.out.print(mSeconds > 9 ? mSeconds : "0"+mSeconds);
            }
        }).start();

        // Initialize any uninitialized values
        if (mMinutes == -1) mMinutes = 0;
        if (mSeconds == -1) mSeconds = 0;

        // Display timer name and loop until finished
        if (mName.length() > 0) System.out.println(mName);
        while (true) {}
    }
}
