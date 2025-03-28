package listexamples;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListIterationDifferentWays {

    public static void main(String[] args) {

        List<Player> players = SeedDataUtil.loadPlayers();

        // Using for loop
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).getName());
        }
        System.out.println("Using for each loop to print player name");
        // Using for each loop
        for (Player player : players) {
            System.out.println(player.getName());
        }

        // Using streams
        System.out.println("Using streams to print player name");
        players.forEach(player -> System.out.println(player.getName()));

        // Using Iterator
        System.out.println("Using Iterator to print player name");
        Iterator<Player> iterator = players.iterator();
        while (iterator.hasNext()) {
            Player player = iterator.next();
            System.out.println(player.getName());
            if(player.getName().equals("Dhoni")){
                iterator.remove();
            }
        }

        // Using ListIterator

        ListIterator<Player> listItr = players.listIterator();
        while(listItr.hasNext()){
            Player player = listItr.next();
            System.out.println(player.getName());
            if(player.getName().equals("Rohit")){
               listItr.remove();
            }
        }

        while(listItr.hasPrevious()){
            Player player = listItr.previous();
            System.out.println(player.getName());
        }



    }
}
