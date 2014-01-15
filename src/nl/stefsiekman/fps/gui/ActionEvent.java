package nl.stefsiekman.fps.gui;

public class ActionEvent {
	
	private Component source;
	
	public ActionEvent(Component source){
		this.source = source;
	}
	
	public Component getSource(){
		return source;
	}
}