package fascinatingMagician.Enchantment.nodes.Bracelet;

import java.awt.Point;

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
import fascinatingMagician.Alcher.misc.Methods;

public class onyBracelet extends Node{

	public static final int WIDGET_TEXT = 548;
	public static final int WIDGETCHILD_TEXT = 435;
	
	@Override
	public boolean activate() {
		if(!Variables.GUIFinished){
			return false;
		}
		
		return !Methods.isSlotEmpty(7);
	}
	@Override
	public void execute() {
	
		if(Variables.braceToEnchant == Variables.onyBracelet){
			
			final WidgetChild widget = Widgets.get(WIDGET_TEXT,
					WIDGETCHILD_TEXT).getChild(0);
			
			final Item sapItem = Inventory.getItem(Variables.onyBracelet);
			if(sapItem != null){
				if (widget.getText().contains("ast")) {
					Mouse.setSpeed(Mouse.Speed.VERY_FAST);
					final Point p = sapItem.getWidgetChild().getCentralPoint();
					if (Random.nextInt(0, 10) % 2 == 0) {
						Mouse.click(p.x + Random.nextInt(-7, 7),
								p.y + Random.nextInt(-7, 7), true);
					} else {
						Mouse.click(p, true);
					}
					Keyboard.sendText("7", false);
					Task.sleep(750, 1000);
				} else {
					Keyboard.sendText("7", false);
					Mouse.click(sapItem.getWidgetChild().getCentralPoint(), true);
					
					Keyboard.sendText("7", false);
					Task.sleep(750, 1000);
				}
			}
		}
		
	}

}
