package fascinatingFleshCrawler.traverse.inDungeon;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.GroundItems;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.node.GroundItem;
import org.powerbot.game.api.wrappers.node.SceneObject;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

import fascinatingFleshCrawler.Variables;
import fascinatingFleshCrawler.traverse.Misc;

public class WalkingThroughMaze extends Node{

	@Override
	public boolean activate() {
		
		return Inventory.contains(Variables.food_monk)
				&& !Misc.varrock.contains(Players.getLocal().getLocation());
	}

	@Override
	public void execute() {
		//First Door & Second Door
		
		
		 final Tile door1 = new Tile(2044, 5239, 0);
		final Tile door2 = new Tile(2044, 5237, 0);
		 final Tile door3 = new Tile(2036, 5203, 0);
		 final Tile door4 = new Tile(2036, 5201, 0);
		 final Tile door5 = new Tile(2045, 5197, 0);
		 final Tile door6 = new Tile(2045, 5195, 0);
		 
		 
		  final Area F2LadderUpArea = new Area(
				   new Tile(2039, 5246, 0), new Tile(2047, 5246, 0),
				   new Tile(2046, 5240, 0), new Tile(2039, 5240, 0)
				);
		  
		  final Area F2d1d2Area = new Area(
				   new Tile(2043, 5240, 0), new Tile(2046, 5240, 0),
				   new Tile(2046, 5237, 0), new Tile(2043, 5237, 0)
				);
		  
		   final Area F2d2d3Area = new Area(
				   new Tile(2047, 5237, 0), new Tile(2047, 5211, 0),
				   new Tile(2039, 5211, 0), new Tile(2039, 5204, 0),
				   new Tile(2035, 5204, 0), new Tile(2035, 5237, 0)
				);
		   
		   final Area firstLevelArea = new Area(new Tile[] {new Tile(1858, 5245, 0), new Tile(1865, 5245, 0),
				   new Tile(1865, 5239, 0), new Tile(1858, 5239, 0)});	

				 final Area F2d3d4Area = new Area(
				   new Tile(2035, 5204, 0), new Tile(2038, 5204, 0),
				   new Tile(2038, 5201, 0), new Tile(2035, 5201, 0)
				);
				 
				 final Area Floor1LadderDown = new Area(
						   new Tile(1900, 5231, 0), new Tile(1916, 5231, 0),
						   new Tile(1916, 5210, 0), new Tile(1900, 5210, 0)
						);

				 final Area F2d4d5Area = new Area(
				   new Tile(2035, 5200, 0), new Tile(2035, 5198, 0),
				   new Tile(2047, 5198, 0), new Tile(2047, 5208, 0),
				   new Tile(2039, 5208, 0), new Tile(2039, 5200, 0)
				   
				);

				 final Area F2d5d6Area = new Area(
				   new Tile(2044, 5198, 0), new Tile(2046, 5198, 0),
				   new Tile(2046, 5195, 0), new Tile(2044, 5195, 0)
				);

				 final Area fleshcrawlersArea = new Area(
				   new Tile(2047, 5195, 0), new Tile(2046, 5184, 0),
				   new Tile(2036, 5184, 0), new Tile(2036, 5192, 0),
				   new Tile(2034, 5192, 0), new Tile(2034, 5195, 0)
				);
		 
		if(F2LadderUpArea.contains(Players.getLocal().getLocation())){
			SceneObject door = SceneEntities.getAt(door1);
			if(door != null){
				if (!door.isOnScreen()) {
					  Camera.turnTo(door);
					  Task.sleep(Random.nextInt(400, 600));
					 }
					 if (door.isOnScreen()) {
					  door.interact("Open");
					  Task.sleep(Random.nextInt(2000, 2500));
					 }
			}
		}
		
		if (F2d1d2Area.contains(Players.getLocal().getLocation())) {
		   
		    SceneObject door = SceneEntities.getAt(door2);
		    if (door != null) {
			 if (!door.isOnScreen()) {
			  Camera.turnTo(door);
			  Task.sleep(Random.nextInt(400, 600));
			 }
			 if (door.isOnScreen()) {
			  door.interact("Open");
			  Task.sleep(Random.nextInt(1200, 1500));
			 }
		    }
		   }
		
		if (F2d2d3Area.contains(Players.getLocal().getLocation())) {
		    
		    SceneObject door = SceneEntities.getAt(door3);
		    if (door != null) {
			 if (!door.isOnScreen()) {
				 Camera.turnTo(door);
			  Walking.walk(door);
			  Task.sleep(Random.nextInt(1000, 1500));
			  while (Calculations
			    .distance(door.getLocation(), Players.getLocal().getLocation()) > 4
			    && Players.getLocal().isMoving())
			   Task.sleep(50);
			 }
			
			 if (door.isOnScreen()) {
			  door.interact("Open");
			  Task.sleep(Random.nextInt(2000, 2500));
			 }
		    }
		   }
		   if (F2d3d4Area.contains(Players.getLocal().getLocation())) {
		    
		    SceneObject door = SceneEntities.getAt(door4);
		    if (door != null) {
			 if (!door.isOnScreen()) {
			  Camera.turnTo(door);
			  Task.sleep(Random.nextInt(400, 600));
			 }
			 if (door.isOnScreen()) {
			  door.interact("Open");
			  Task.sleep(Random.nextInt(1200, 1500));
			 }
		    }
		   }
		   if (!F2LadderUpArea.contains(Players.getLocal().getLocation())
				   && !F2d1d2Area.contains(Players.getLocal().getLocation())
				   && !F2d2d3Area.contains(Players.getLocal().getLocation())
				   && !F2d3d4Area.contains(Players.getLocal().getLocation())
				   && !F2d5d6Area.contains(Players.getLocal().getLocation())
				   && !fleshcrawlersArea.contains(Players.getLocal().getLocation())) {
		    
		    SceneObject door = SceneEntities.getAt(door5);
		    if (door != null) {
			 if (!door.isOnScreen()) {
			  Walking.walk(door);
			  Camera.turnTo(door);
			  Task.sleep(Random.nextInt(1000, 1500));
			  while (Calculations
			    .distance(door.getLocation(), Players.getLocal().getLocation()) > 4
			    && Players.getLocal().isMoving())
			   Task.sleep(50);
			 }
			 if (door.isOnScreen()) {
			  door.interact("Open");
			  Task.sleep(Random.nextInt(2500, 3000));
			 }
		    }
		   }
		  if (F2d5d6Area.contains(Players.getLocal().getLocation())) {
		   
		    SceneObject door = SceneEntities.getAt(door6);
		    if (door != null) {
			 if (!door.isOnScreen()) {
			  Camera.turnTo(door);
			  Walking.walk(door);
			  Task.sleep(Random.nextInt(400, 600));
			  while(Calculations.distance(door.getLocation(), Players.getLocal().getLocation()) > 4
					  && Players.getLocal().isMoving()){
				  Task.sleep(50);
			  }
			 }
			 if (door.isOnScreen()) {
			  
			  door.interact("Open");
			  Task.sleep(Random.nextInt(2500, 3000));
			 }
		    }
		    GroundItem Loots = GroundItems.getNearest(Variables.loots);
		    if(Loots == null){
		    Walking.walk(new Tile(2040, 5190, 0)); // go to center of room
		    Camera.setPitch(85);
		    }
		    
		   }
		 
		 
			  SceneObject portal = SceneEntities.getNearest(16150);
			    if (portal != null) {
				 if (!portal.isOnScreen()) {
				  Walking.walk(portal);
				  Task.sleep(Random.nextInt(300, 400));
				  while (Calculations.distance(portal.getLocation(),
				    Players.getLocal().getLocation()) > 3 && Players.getLocal().isMoving())
				   Task.sleep(50);
				 }
				 if (portal.isOnScreen()) {
				  portal.interact("Enter");
				  Task.sleep(300);
				  while (Players.getLocal().isMoving())
				   Task.sleep(100);
				 }
		  }
		   
		 
	
		  
		  if(Floor1LadderDown.contains(Players.getLocal().getLocation())){
			  SceneObject ladder = SceneEntities.getNearest(16149);
			    WidgetChild warning = Widgets.get(579, 15);
			    if (ladder != null && !warning.isOnScreen()) {
				 if (!ladder.isOnScreen()) {
				  Walking.walk(ladder);
				  Task.sleep(Random.nextInt(300, 400));
				  while (Calculations.distance(ladder.getLocation(),
				    Players.getLocal().getLocation()) > 5 && Players.getLocal().isMoving())
				   Task.sleep(50);
				 }
				 if (ladder.isOnScreen()) {
				  ladder.interact("Climb-down");
				  Task.sleep(300);
				  while (Players.getLocal().isMoving())
				   Task.sleep(100);
				 }
		  }
}
}
}
