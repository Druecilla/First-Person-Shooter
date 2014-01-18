package nl.stefsiekman.fps.state;

import nl.stefsiekman.fps.Game;
import nl.stefsiekman.fps.gui.ActionEvent;
import nl.stefsiekman.fps.gui.ActionListener;
import nl.stefsiekman.fps.gui.Button;
import nl.stefsiekman.fps.gui.MenuScreen;
import nl.stefsiekman.fps.math.Vector2i;

public class StateMainMenu extends MenuScreen implements ActionListener {
	
	private Button singleplayer = new Button();
	private Button multiplayer = new Button();
	private Button options = new Button();
	private Button quit = new Button();
	
	public StateMainMenu(){
		singleplayer.setLocation(new Vector2i(Game.WIDTH / 2 - singleplayer.getWidth() / 2, 30));
		singleplayer.setText("Singleplayer");
		add(singleplayer);
		
		multiplayer.setLocation(new Vector2i(Game.WIDTH / 2 - multiplayer.getWidth() / 2, 70));
		multiplayer.setText("Multiplayer");
		add(multiplayer);
		
		options.setLocation(new Vector2i(Game.WIDTH / 2 - options.getWidth() / 2, 110));
		options.setText("Options");
		add(options);
		
		quit.setLocation(new Vector2i(Game.WIDTH / 2 - quit.getWidth() / 2, 150));
		quit.setText("Quit Game");
		add(quit);
		
		singleplayer.addActionListener(this);
		multiplayer.addActionListener(this);
		options.addActionListener(this);
		quit.addActionListener(this);
	}
	
	@Override
	public void ActionPerformed(ActionEvent e){
		if(e.getSource() == singleplayer){
			State.setState(State.States.SINGLEPLAYER_MENU);
		}
		
		if(e.getSource() == multiplayer){
			State.setState(State.States.MULTIPLAYER_MENU);
		}
		
		if(e.getSource() == options){
			State.setState(State.States.OPTIONS);
		}
		
		if(e.getSource() == quit){
			Game.getInstance().quit();
		}
	}
}