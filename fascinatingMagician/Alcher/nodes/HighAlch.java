package fascinatingMagician.Alcher.nodes;

import java.awt.Point;
import java.awt.event.KeyEvent;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.input.Keyboard;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.node.Item;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

import fascinatingMagician.Variables;
import fascinatingMagician.Alcher.misc.*;

public class HighAlch extends Node{

	public static final int WIDGET_TEXT = 548;
	public static final int WIDGETCHILD_TEXT = 435;
	
	@Override
	public boolean activate() {
		
		if(Variables.HighAlch == true){
			return true;
		} 
		
		if(Variables.LowAlch == true){
			return true;
		}
		
		return !Methods.isSlotEmpty(0) && Inventory.contains(new int[] {Variables.NATURE_RUNE})
				&& (Variables.HighAlch || Variables.LowAlch) ;
	}

	@Override
	public void execute() {
		final WidgetChild widget = Widgets.get(WIDGET_TEXT,
				WIDGETCHILD_TEXT).getChild(0);
		
		final Item item = Inventory.getItem(Variables.idToAlch);
		if(item != null){
			Methods.s(String.format("Alching %s", item.getName()));
				
			Variables.status = "Alching " + item.getName();
			if(!Widgets.get(137).getChild(56).getText().contains("[Press Enter to Chat]")) {
				Keyboard.sendKey((char) KeyEvent.VK_ESCAPE);
	
		}	
			Mouse.setSpeed(Mouse.Speed.VERY_FAST);
			Keyboard.sendKey((char) KeyEvent.VK_2);
			Task.sleep(10, 20);
			Inventory.getItem(Variables.idToAlch).getWidgetChild().interact("Cast");
			
			Variables.alched++;
			Variables.expGained = Variables.alched * 65;
			Task.sleep(1800, 2000);
			
		
		if(Widgets.get(1179, 21).isOnScreen()){
			Variables.status = "Widget closing..";
			Mouse.setSpeed(Mouse.Speed.VERY_FAST);
			Widgets.get(1179, 29).click(true);
		}
		}	

		}
	
	}


