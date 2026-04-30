package rvt.todo.graphic;

import javax.swing.*;

public class MyGui{
	public static void main(String[] args) {
		JFrame frame = new JFrame("ToDo List UI"); // the frame, "the skeleton"
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // panel contains everything
		JPanel panel = new JPanel();
		panel.setLayout(null); // This does some magic for layout
		// intialize the buttons
		JButton buttonAdd = new JButton("Add a task");
		JButton buttonRemove = new JButton("Remove a task");
		JButton buttonList = new JButton("List the tasks");
		JButton buttonExit = new JButton("Exit the app");
		// give buttons sizes and colors
		buttonAdd.setBounds(50, 50, 200, 40); // x, y, width, height and so on
		buttonRemove.setBounds(50, 150, 200, 40);
		buttonList.setBounds(50, 250, 200, 40);
		buttonExit.setBounds(50, 350, 200, 40);
		// add them to the panel element to actually show them. Like in p5.js
		panel.add(buttonAdd);
		panel.add(buttonRemove);
		panel.add(buttonList);
		panel.add(buttonExit);
		// add PANEL to FRAME
		frame.add(panel);
		// set size and make visible
		frame.setSize(900, 480);	
		frame.setVisible(true);


	}
}