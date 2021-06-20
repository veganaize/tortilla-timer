import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class TortillaTimer {
    static int mSeconds;
    static int mMinutes;
    static String mName;
    
	public static void main(String[] args) {
        for (int i = args.length-1; i >= 0; i--) {
            try {
                int n = Integer.parseInt(args[i]);
                if (mSeconds > 0) mMinutes = n;
                else mSeconds = n;
                
            } catch (NumberFormatException e) {
                mName = args[i];
            }
        }
        
        new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (--mSeconds < 0) {
                    if (--mMinutes < 0) {
                        System.out.println("\b\b\b\bDONE!");
                        System.exit(0);
                    }
                    mSeconds = 59;
                }
                    
                System.out.print("\b\b\b\b\b\b"+ mMinutes +":");
                System.out.print(mSeconds > 9 ? mSeconds : "0"+ mSeconds);
            }
        }).start();

        if (mName != null) System.out.println(mName);        
        while (true) {}
    }
}