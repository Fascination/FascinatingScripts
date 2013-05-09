package fascinatingDemonSlayer.Node.traversalNode;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.node.SceneObject;

import fascinatingDemonSlayer.Variables;

public class PathToDung extends Node{

	@Override
	public boolean activate() {
		
		
		return Inventory.contains(new int[] {Variables.food_monk});
	}

	@Override
	public void execute() {
		SceneObject DungEntrance = SceneEntities.getNearest(Variables.dungEntrance);
		
		if(!Variables.dungEntranceArea.contains(Players.getLocal().getLocation())){
			Walking.newTilePath(Variables.pathToDungeon).traverse();
		} else {
			
			if(Camera.getYaw() != 7){
				Camera.setAngle(7);
			}
			
			if(Camera.getPitch() > 80){
				Camera.setPitch(45);
			}
			
			if(DungEntrance != null && DungEntrance.isOnScreen()){
				DungEntrance.interact("Climb-down");
			}
			
			
				
			
			
		}
		
		if(SceneEntities.getNearest(2082) != null && SceneEntities.getNearest(2082).isOnScreen()) { //2082 - Ship Plank (Interact#Crossplank)
					SceneEntities.getNearest(2082).interact("Cross");
				}
		
	}

}
