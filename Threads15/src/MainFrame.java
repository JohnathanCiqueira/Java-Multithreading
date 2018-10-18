import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

public class MainFrame extends JFrame {

	private JLabel countLabel1 = new JLabel("0");
	private JLabel statusLabel1 = new JLabel("Task not completed.");
	private JButton startButton = new JButton("Start");

	public MainFrame(String title) {
		super(title);

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();
		
		Font font = new Font("Calibri", Font.PLAIN, 36);

		gc.fill = GridBagConstraints.NONE;

		

		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		countLabel1.setFont(font);
		add(countLabel1, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		statusLabel1.setFont(font);
		add(statusLabel1, gc);

		gc.gridx = 0;
		gc.gridy = 2;
		gc.weightx = 1;
		gc.weighty = 1;
		startButton.setFont(font);
		add(startButton, gc);

		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		
		setSize(600, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	private void start() {
		SwingWorker<Boolean, Integer> worker = new SwingWorker<Boolean, Integer>() {

			@Override
			protected Boolean doInBackground() throws Exception {

				for (int i = 0; i < 30; i++) {
					Thread.sleep(100);
					System.out.println("Hello: " + i);
					
					publish(i);
				}

				return true;
			}
			
			@Override
			protected void process(List<Integer> chunks) {
				Integer value = chunks.get(chunks.size() - 1);
				
				countLabel1.setText("Current value: " + value);
			}

			@Override
			protected void done() {
				try {
					Boolean status = get();
					statusLabel1.setText("Completed with status: " + status);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}

		};

		worker.execute();

	}

}
