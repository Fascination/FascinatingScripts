package fascinatingDemonSlayer.Node;
import org.powerbot.game.client.CombatStatusData;
import org.powerbot.game.client.LinkedListNode;
import org.powerbot.game.client.RSCharacter;
import org.powerbot.game.client.LinkedList;
import org.powerbot.game.client.CombatStatus;

public class Percentages {

    public static CombatStatusData getAdrenalineBar(final RSCharacter accessor) {
       LinkedListNode sentinel = (LinkedListNode) ((LinkedList) accessor.getCombatStatusList()).getTail();
       LinkedListNode current = (LinkedListNode) sentinel.getNext();
       if (!sentinel.equals(current) && !sentinel.equals(current.getNext())) {
           sentinel = ((LinkedListNode) ((LinkedList) ((CombatStatus) current).getData()).getTail());
           if (!sentinel.equals(sentinel.getNext())) {
               final CombatStatusData adrenalineBar = (CombatStatusData) sentinel.getNext();
               if (adrenalineBar != null) {
                   return adrenalineBar;
               }
           }
       }
       return null;
   }

   public static CombatStatusData getHealthBar(final RSCharacter accessor) {
       LinkedListNode sentinel = (LinkedListNode) ((LinkedList) accessor.getCombatStatusList()).getTail();
       LinkedListNode current = (LinkedListNode) sentinel.getNext();
       if (!sentinel.equals(current)) {
           if (!sentinel.equals(current.getNext())) {
               current = (LinkedListNode) current.getNext();
           }
           sentinel = ((LinkedListNode) ((LinkedList) ((CombatStatus) current).getData()).getTail());
           if (!sentinel.equals(sentinel.getNext())) {
               final CombatStatusData healthBar = (CombatStatusData) sentinel.getNext();
               if (healthBar != null) {
                   return healthBar;
               }
           }
       }
       return null;
   }


   public static int getAdrenalinePercent(final RSCharacter accessor) {
       final CombatStatusData adrenalineBar = getAdrenalineBar(accessor);
       return adrenalineBar != null ? toPercent(adrenalineBar.getHPRatio()) : 0;
   }


   public static int getHealthPercent(final RSCharacter accessor) {
       final CombatStatusData healthBar = getHealthBar(accessor);
       return healthBar != null ? toPercent(healthBar.getHPRatio()) : 100;
   }

   public static int toPercent(final int ratio) {
       return (int) Math.ceil((ratio * 100) / 0xFF);
   }
	
}

