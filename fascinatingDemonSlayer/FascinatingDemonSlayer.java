package fascinatingDemonSlayer;

import javax.swing.SwingUtilities;

import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.util.Random;

import fascinatingDemonSlayer.Node.bankNode.WithdrawFood;
import fascinatingDemonSlayer.Node.combatNode.AttackMonster;
import fascinatingDemonSlayer.Node.combatNode.UseAbility;
import fascinatingDemonSlayer.Node.combatNode.UseRegenerate;
import fascinatingDemonSlayer.Node.combatNode.UseThresholdAbility;
import fascinatingDemonSlayer.Node.healthNode.EatFood;
import fascinatingDemonSlayer.Node.traversalNode.PathToBank;
import fascinatingDemonSlayer.Node.traversalNode.PathToDownLessers;
import fascinatingDemonSlayer.Node.traversalNode.PathToDung;
import fascinatingDemonSlayer.Node.traversalNode.PathToShip;
import fascinatingDemonSlayer.Node.traversalNode.TeleportToDraynor;

@Manifest(authors = { "Fascination" }, name = "Fascinating Lesser Demon Killer", description = "Slays Lesser Demons | Bank Support | AIO Food" )
public class FascinatingDemonSlayer extends ActiveScript{

private final Node[] array = new Node[] {
		
		//traversalNode
		new PathToDung(), new PathToDownLessers(), new PathToBank(), new PathToShip(),
		
		//combatNode
		new AttackMonster(), new UseAbility(),//new UseRegenerate(), 
		
		//healthNode
		new EatFood(),
		
		//bankNode
		new WithdrawFood(),
		
}; //add classes here
	


	@Override
    public int loop() {

            for (final Node node : array) {
                    if (node.activate()) {
                            node.execute();
                    }
            }
            return Random.nextInt(10, 50);
    }
	


	

}