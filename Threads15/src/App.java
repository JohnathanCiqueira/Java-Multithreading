import javax.swing.SwingUtilities;

/**
 * Multithreading in swing with SwingWorker
 * 
 * @author jciqueira https://github.com/JohnathanCiqueira/
 *
 */
public class App {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new MainFrame("SwingWorker Demo");
			}
		});
	}

}
