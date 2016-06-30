/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.control;

import byui.cit260.hiddenMickeys.exceptions.MapControlException;
import byui.cit260.hiddenMickeys.model.Game;
import byui.cit260.hiddenMickeys.model.Land;
import byui.cit260.hiddenMickeys.model.Location;
import byui.cit260.hiddenMickeys.model.Map;
import byui.cit260.hiddenMickeys.model.Scene;
import byui.cit260.hiddenMickeys.model.SceneType;
import hiddenmickeys.HiddenMickeys;


public class MapControl {

    public static Map createMap() {
       //create the map
        Map map = new Map(5,7);

        //create the scenes for the game
        Scene[] scenes = createScenes();

        //assign scenes to locations
        assignScenesToLocations(map, scenes);

        return map;
}
    

    public static void initStartingPosition(Map map) {
       
    }

    private static Scene[] createScenes() {
        Scene[] scenes = new Scene[SceneType.values().length];
        
            Scene startingScene = new Scene();
            startingScene.setName("Main Gate");
            startingScene.setDescription("");
            startingScene.setMapSymbol("-");
            startingScene.setLocationType("O");
            startingScene.setMickeyPresent(false);
            scenes[SceneType.main_gate.ordinal()] = startingScene;

            
            Scene piratesCaribbean = new Scene();
            piratesCaribbean.setName("Pirates of the Caribbean");
            piratesCaribbean.setDescription("Board your boat and take a lovely"
                    + "stroll through the Bayou, when all of the sudden you're caught"
                    + "in the middle of fight with Pirates.  Be sure to duck as the "
                    + "cannon balls fly over your head and you continue through the"
                    + "village.  The Pirates have taken over and are celebrating"
                    + "their victory");
            piratesCaribbean.setLocationType("R");
            piratesCaribbean.setMapSymbol(">");
            piratesCaribbean.setMickeyPresent(true);
            piratesCaribbean.setMickeyLocation("lily pads");
            piratesCaribbean.setWaitTime(45);
            scenes[SceneType.pirates_caribbean.ordinal()] = piratesCaribbean;
            
            Scene fast_pass = new Scene();
            fast_pass.setName("Fast Pass Machine");
            fast_pass.setDescription("");
            fast_pass.setMapSymbol("*");
            fast_pass.setLocationType("P");
            fast_pass.setMickeyPresent(false);
            scenes[SceneType.fast_pass.ordinal()] = fast_pass;

            Scene pieces_eight = new Scene();
            pieces_eight.setName("Pieces of Eight");
            pieces_eight.setDescription("Want to connect with your inner Pirate?  This is"
                    + "the place to buy your Pirate Gear.");
            pieces_eight.setMapSymbol("$");
            pieces_eight.setLocationType("S");
            pieces_eight.setItemName("Pirate Sword");
            pieces_eight.setItemPrice(3.50);
            pieces_eight.setDescription("");
            pieces_eight.setMickeyPresent(false);
            pieces_eight.setMickeyLocation("");
            scenes[SceneType.pieces_eight.ordinal()] = pieces_eight;


            Scene emporium = new Scene();
            emporium.setName("Emporium Souvenirs");
            emporium.setDescription("Wow!  There is so much to see.  This is the place"
                    + "to pick up souvenirs for the family back home, buy your Mouse Ears or "
                    + "a Disney shirt or two...");
            emporium.setMapSymbol("$");
            emporium.setLocationType("S");
            emporium.setItemName("Mickey T-shirt");
            emporium.setItemPrice(12);
            emporium.setDescription("");
            emporium.setMickeyPresent(false);
            emporium.setMickeyLocation("");
            scenes[SceneType.emporium.ordinal()] = emporium;


            Scene magic_shop = new Scene();
            magic_shop.setName("Main Street Magic Shop");
            magic_shop.setDescription("Ready for your next career as a magician?  Stroll through"
                    + "this fabulous store to find fun magic tricks to add to your act.");
            magic_shop.setMapSymbol("$");
            magic_shop.setLocationType("S");
            magic_shop.setItemName("Magic Tricks and Toys");
            magic_shop.setItemPrice(15);
            magic_shop.setDescription("");
            magic_shop.setMickeyPresent(false);
            magic_shop.setMickeyLocation("");
            scenes[SceneType.magic_shop.ordinal()] = magic_shop;


            Scene beignet = new Scene();
            beignet.setName("Mickey Beignet Shop");
            beignet.setDescription("You've been walking all over the park.  Surely you've burned"
                    + "enough calories to indulge in a Mickey Shaped Beignet.  Be careful not to "
                    + "breathe in too quick when you take a bite... you could end up snorting up some "
                    + "powdered sugar!  You may want to wash down that beignet with a delicious Mint Julep.");
            beignet.setMapSymbol("+");
            beignet.setLocationType("F");
            beignet.setItemName("Beignets");
            beignet.setItemPrice(5);
            beignet.setMickeyPresent(false);
            scenes[SceneType.beignet.ordinal()] = beignet;

            Scene village_haus = new Scene();
            village_haus.setName("Village Haus Restaurant");
            village_haus.setDescription("Wow!  Did you just travel to Germany?  This is a great place"
                    + "to relax and eat some lunch or dinner. The Pastrami Burger is delicious.  Keep"
                    + "your eye out for Pinnochio!");
            village_haus.setMapSymbol("+");
            village_haus.setLocationType("F");
            village_haus.setItemName("Flatbread pizzas and salad");
            village_haus.setItemPrice(10);
            village_haus.setMickeyPresent(false);
            scenes[SceneType.village_haus.ordinal()] = village_haus;


            Scene hungry_bear = new Scene();
            hungry_bear.setName("Hungry Bear Restaurant");
            hungry_bear.setDescription("Welcome to the Hungry Bear Restaurant!  If you're"
                    + "hungry, this is the place to be.  You can fill up on a Burger, or two..."
                    + "or try our famous Fried Green Tomato sandwich.  Yummmm");
            hungry_bear.setMapSymbol("+");
            hungry_bear.setLocationType("F");
            hungry_bear.setItemName("Burgers");
            hungry_bear.setItemPrice(10);
            hungry_bear.setMickeyPresent(false);
            scenes[SceneType.hungry_bear.ordinal()] = hungry_bear;

            Scene dole_whip = new Scene();
            dole_whip.setName("Dole Whip");
            dole_whip.setDescription("Ah, no trip to Disneyland is complete without a little Dole Whip!"
                    + "You can enjoy yours in a cup or a float.  Perfect for a Hot Day!");
            dole_whip.setMapSymbol("+");
            dole_whip.setLocationType("F");
            dole_whip.setItemName("Dole Whip");
            dole_whip.setItemPrice(5);
            dole_whip.setMickeyPresent(false);
            scenes[SceneType.dole_whip.ordinal()] = dole_whip;

            Scene carnation = new Scene();
            carnation.setName("Carnation Cafe");
            carnation.setDescription("The Carnation Cafe started out as an indoor ice cream parlor"
                    + "and has grown to be a full-service cafe.  As a special treat for your Disneyland"
                    + "experience the cafe is serving Ice Cream today.");
            carnation.setMapSymbol("+");
            carnation.setLocationType("F");
            carnation.setItemName("Ice Cream");
            carnation.setItemPrice(5);
            carnation.setMickeyPresent(false);
            scenes[SceneType.carnation.ordinal()] = carnation;

            Scene pizza_port = new Scene();
            pizza_port.setName("Pizza Port");
            pizza_port.setDescription("As you orbit Tomorrowland you take a moment to"
                    + "land at Pizza Port where they serve Pizza and Star Wars themed"
                    + "treats like Chewbacca Cheesecake.");
            pizza_port.setMapSymbol("+");
            pizza_port.setLocationType("F");
            pizza_port.setItemName("Pizza");
            pizza_port.setItemPrice(10);
            pizza_port.setMickeyPresent(false);
            scenes[SceneType.pizza_port.ordinal()] = pizza_port;

            Scene thunder_food = new Scene();
            thunder_food.setName("Big Thunder Ranch Food");
            thunder_food.setDescription("Come on down to the ranch and enjoy some fabulous home-stlye"
                    + "bbq.  All meals are served are all-you-can-eat and served family style.  Enjoy"
                    + "this soon because it only exists in our memories now...as the new Star Wars"
                    + "land is being built on this location.");
            thunder_food.setMapSymbol("+");
            thunder_food.setLocationType("F");
            thunder_food.setItemName("Barbeque");
            thunder_food.setItemPrice(15);
            thunder_food.setMickeyPresent(false);
            scenes[SceneType.thunder_food.ordinal()] = thunder_food;

            Scene bench = new Scene();
            bench.setName("Park Bench");
            bench.setDescription("Ahh... rest your weary feet and wait for the parade to go by on"
                    + "the park bench.");
            bench.setLocationType("T");
            bench.setMapSymbol("^");
            bench.setMickeyPresent(false);
            scenes[SceneType.bench.ordinal()] = bench;

            Scene tiki_room = new Scene();
            tiki_room.setName("Enchanted Tiki Room");
            tiki_room.setDescription("Welcome to the Tiki, Tiki, Tiki, Tiki room.  It's a great"
                    + "escape when the weather is rough or you need a little break.  Sit back and"
                    + "relax as you enjoy the songs of the many birds.");
            tiki_room.setLocationType("T");
            tiki_room.setMapSymbol("^");
            tiki_room.setMickeyPresent(false);
            scenes[SceneType.tiki_room.ordinal()] = tiki_room;

            Scene main_cinema = new Scene();
            main_cinema.setName("Main Street Cinema");
            main_cinema.setDescription("Take a step back in time as you watch the cartoons that"
                    + "started it all.");
            main_cinema.setLocationType("T");
            main_cinema.setMapSymbol("^");
            main_cinema.setMickeyPresent(false);
            scenes[SceneType.main_cinema.ordinal()] = main_cinema;

            Scene mark_twain = new Scene();
            mark_twain.setName("Mark Twain Riverboat");
            mark_twain.setDescription("Climb aboard and cruise around America and get a look at"
                    + "what like was like over a hundred years ago.... ");
            mark_twain.setLocationType("T");
            mark_twain.setMapSymbol("^");
            mark_twain.setMickeyPresent(false);
            scenes[SceneType.mark_twain.ordinal()] = mark_twain;

            Scene columbia = new Scene();
            columbia.setName("Sailing Ship Columbia");
            columbia.setDescription("Sail the seas of Disneyland aboard the full-size replica sailing ship.");
            columbia.setLocationType("T");
            columbia.setMapSymbol("^");
            columbia.setMickeyPresent(false);
            scenes[SceneType.columbia.ordinal()] = columbia;            
            
            
            Scene haunted_mansion = new Scene();
            haunted_mansion.setName("Haunted Mansion");
            haunted_mansion.setDescription("You escaped the incredible stretching room, but how will you get out?"
                    + "Climb aboard the buggy and wind your way through the house.  Keep your eyes on the "
                    + "frolicking ghosts!  They have been known to hitch a ride home with you.");
            haunted_mansion.setLocationType("R");
            haunted_mansion.setMapSymbol(">");
            haunted_mansion.setMickeyPresent(true);
            haunted_mansion.setMickeyLocation("place setting");
            haunted_mansion.setWaitTime(60);
            scenes[SceneType.haunted_mansion.ordinal()] = haunted_mansion;


            Scene winnie_pooh = new Scene();
            winnie_pooh.setName("Winnie the Pooh");
            winnie_pooh.setDescription("Climb aboard the beehive and travel through a hundred acre wood"
                    + "with Winnie the Pooh and friends.");
            winnie_pooh.setLocationType("R");
            winnie_pooh.setMapSymbol(">");
            winnie_pooh.setMickeyPresent(true);
            winnie_pooh.setMickeyLocation("place setting");
            winnie_pooh.setWaitTime(5);
            scenes[SceneType.winnie_pooh.ordinal()] = winnie_pooh;


            Scene indiana_jones = new Scene();
            indiana_jones.setName("Indiana Jones");
            indiana_jones.setDescription("Adventure time!  Climb aboard the jeep and enter the cursed "
                    + "Temple of the Forbidden Eye.  Beware of falling bolders that may block your way out.");
            indiana_jones.setLocationType("R");
            indiana_jones.setMapSymbol(">");
            indiana_jones.setMickeyPresent(true);
            indiana_jones.setMickeyLocation("place setting");
            indiana_jones.setWaitTime(90);
            scenes[SceneType.indiana_jones.ordinal()] = indiana_jones;

            Scene jungle_cruise = new Scene();
            jungle_cruise.setName("Jungle Cruise");
            jungle_cruise.setDescription("Take a journey through the jungle with your wise-cracking skipper."
                    + "Avoid the hippos and cannibals and you might make it out alive...");
            jungle_cruise.setLocationType("R");
            jungle_cruise.setMapSymbol(">");
            jungle_cruise.setMickeyPresent(true);
            jungle_cruise.setMickeyLocation("");
            jungle_cruise.setWaitTime(30);
            scenes[SceneType.jungle_cruise.ordinal()] = jungle_cruise;


            Scene tarzan_treehouse = new Scene();
            tarzan_treehouse.setName("Tarzan's Treehouse");
            tarzan_treehouse.setDescription("");
            tarzan_treehouse.setLocationType("R");
            tarzan_treehouse.setMapSymbol(">");
            tarzan_treehouse.setMickeyPresent(true);
            tarzan_treehouse.setMickeyLocation("");
            tarzan_treehouse.setWaitTime(5);
            scenes[SceneType.tarzan_treehouse.ordinal()] = tarzan_treehouse;


            Scene small_world = new Scene();
            small_world.setName("It's a Small World");
            small_world.setDescription("");
            small_world.setLocationType("R");
            small_world.setMapSymbol(">");
            small_world.setMickeyPresent(true);
            small_world.setMickeyLocation("");
            small_world.setWaitTime(45);
            scenes[SceneType.small_world.ordinal()] = small_world;

            Scene matterhorn = new Scene();
            matterhorn.setName("The Matterhorn");
            matterhorn.setDescription("");
            matterhorn.setLocationType("R");
            matterhorn.setMapSymbol(">");
            matterhorn.setMickeyPresent(true);
            matterhorn.setMickeyLocation("");
            matterhorn.setWaitTime(45);
            scenes[SceneType.matterhorn.ordinal()] = matterhorn;

            Scene peter_pan = new Scene();
            peter_pan.setName("Peter Pan's Flight");
            peter_pan.setDescription("");
            peter_pan.setLocationType("R");
            peter_pan.setMapSymbol(">");
            peter_pan.setMickeyPresent(true);
            peter_pan.setMickeyLocation("");
            peter_pan.setWaitTime(30);
            scenes[SceneType.peter_pan.ordinal()] = peter_pan;

            Scene alice_wonderland = new Scene();
            alice_wonderland.setName("Alice in Wonderland");
            alice_wonderland.setDescription("");
            alice_wonderland.setLocationType("R");
            alice_wonderland.setMapSymbol(">");
            alice_wonderland.setMickeyPresent(true);
            alice_wonderland.setMickeyLocation("");
            alice_wonderland.setWaitTime(10);
            scenes[SceneType.alice_wonderland.ordinal()] = alice_wonderland;

            Scene space_mountain = new Scene();
            space_mountain.setName("Space Mountain");
            space_mountain.setDescription("");
            space_mountain.setLocationType("R");
            space_mountain.setMapSymbol(">");
            space_mountain.setMickeyPresent(true);
            space_mountain.setMickeyLocation("");
            space_mountain.setWaitTime(120);
            scenes[SceneType.space_mountain.ordinal()] = space_mountain;
            
                        
            Scene starTours = new Scene();	
            starTours.setName("Star Tours");
            starTours.setDescription("dawn");
            starTours.setLocationType("R");
            starTours.setMapSymbol(">");
            starTours.setMickeyPresent(true);
            starTours.setMickeyLocation("dawn");
            starTours.setWaitTime(50);
            scenes[SceneType.star_tours.ordinal()] = starTours;

            
            Scene astroBlasters = new Scene();
            astroBlasters.setName("Buzz Lightyear Astro Blasters");
            astroBlasters.setDescription("dawn");
            astroBlasters.setLocationType("R");
            astroBlasters.setMapSymbol(">");
            astroBlasters.setMickeyPresent(true);
            astroBlasters.setMickeyLocation("dawn");
            astroBlasters.setWaitTime(40);
            scenes[SceneType.astro_blasters.ordinal()] = astroBlasters;


            Scene thunderMountain = new Scene();
            thunderMountain.setName("Big Thunder Mtn RailRoad");
            thunderMountain.setDescription("dawn");
            thunderMountain.setLocationType("R");
            thunderMountain.setMapSymbol(">");
            thunderMountain.setMickeyPresent(true);
            thunderMountain.setMickeyLocation("dawn");
            thunderMountain.setWaitTime(30);
            scenes[SceneType.thunder_mountain.ordinal()] = thunderMountain;
            
            Scene splashMountain = new Scene();
            splashMountain.setName("Splash Mountain");
            splashMountain.setDescription("dawn");
            splashMountain.setLocationType("R");
            splashMountain.setMapSymbol(">");
            splashMountain.setMickeyPresent(true);
            splashMountain.setMickeyLocation("dawn");
            splashMountain.setWaitTime(40);
            scenes[SceneType.splash_mountain.ordinal()] = splashMountain;

            
            Scene sawyerIsland = new Scene();
            sawyerIsland.setName("Tom Sawyer Island");
            sawyerIsland.setDescription("");
            sawyerIsland.setLocationType("R");
            sawyerIsland.setMapSymbol(">");
            sawyerIsland.setMickeyPresent(true);
            sawyerIsland.setMickeyLocation("dawn");
            sawyerIsland.setWaitTime(5);
            scenes[SceneType.sawyer_island.ordinal()] = sawyerIsland;
            
            return scenes;
         }

    private static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();
        
        //assign scenes to each location
            locations[0][0].setScene(scenes[SceneType.pirates_caribbean.ordinal()]);
            locations[1][0].setScene(scenes[SceneType.fast_pass.ordinal()]);
            locations[2][0].setScene(scenes[SceneType.pieces_eight.ordinal()]);
            locations[3][0].setScene(scenes[SceneType.haunted_mansion.ordinal()]);
            locations[4][0].setScene(scenes[SceneType.beignet.ordinal()]);
            locations[0][1].setScene(scenes[SceneType.bench.ordinal()]);
            locations[1][1].setScene(scenes[SceneType.hungry_bear.ordinal()]);
            locations[2][1].setScene(scenes[SceneType.winnie_pooh.ordinal()]);
            locations[3][1].setScene(scenes[SceneType.fast_pass.ordinal()]);
            locations[4][1].setScene(scenes[SceneType.splash_mountain.ordinal()]);
            locations[0][2].setScene(scenes[SceneType.indiana_jones.ordinal()]);
            locations[1][2].setScene(scenes[SceneType.tiki_room.ordinal()]);
            locations[2][2].setScene(scenes[SceneType.jungle_cruise.ordinal()]);
            locations[3][2].setScene(scenes[SceneType.tarzan_treehouse.ordinal()]);
            locations[4][2].setScene(scenes[SceneType.dole_whip.ordinal()]);
            locations[0][3].setScene(scenes[SceneType.main_gate.ordinal()]);
            locations[1][3].setScene(scenes[SceneType.main_cinema.ordinal()]);
            locations[2][3].setScene(scenes[SceneType.emporium.ordinal()]);
            locations[3][3].setScene(scenes[SceneType.carnation.ordinal()]);
            locations[4][3].setScene(scenes[SceneType.magic_shop.ordinal()]);
            locations[0][4].setScene(scenes[SceneType.small_world.ordinal()]);
            locations[1][4].setScene(scenes[SceneType.village_haus.ordinal()]);
            locations[2][4].setScene(scenes[SceneType.matterhorn.ordinal()]);
            locations[3][4].setScene(scenes[SceneType.peter_pan.ordinal()]);
            locations[4][4].setScene(scenes[SceneType.alice_wonderland.ordinal()]);
            locations[0][5].setScene(scenes[SceneType.space_mountain.ordinal()]);
            locations[1][5].setScene(scenes[SceneType.star_tours.ordinal()]);
            locations[2][5].setScene(scenes[SceneType.fast_pass.ordinal()]);
            locations[3][5].setScene(scenes[SceneType.astro_blasters.ordinal()]);
            locations[4][5].setScene(scenes[SceneType.pizza_port.ordinal()]);
            locations[0][6].setScene(scenes[SceneType.thunder_food.ordinal()]);
            locations[1][6].setScene(scenes[SceneType.mark_twain.ordinal()]);
            locations[2][6].setScene(scenes[SceneType.thunder_mountain.ordinal()]);
            locations[3][6].setScene(scenes[SceneType.columbia.ordinal()]);
            locations[4][6].setScene(scenes[SceneType.sawyer_island.ordinal()]);


        
        
        
         }

    public static String[] getLocationList(Location[][] locations,int numLocations) {
       String[] tmpLocations = new String[numLocations];
         for( int row = 0; row < locations.length; row++){
                for( int column = 0; column < locations[row].length; column++){
                    tmpLocations[locations[row][column].getLocationNo() - 1] = (locations[row][column].getScene().getName());
                }
        }
         return tmpLocations;
    }

    public static int calcRowsPerColumn(int noLocations, int numColumns)
            throws MapControlException {
       //Calculate the number of locations per row
        int numRows;
        
        //test for boundary - must 6 or fewer columns
        if( numColumns > 6 ){
            throw new MapControlException("Number of columns entered is too high."); //number is too high
        }
        else if(numColumns<=1) {//there must be at least one column
            throw new MapControlException("There must be at least one column."); //number must be at least one
        }
        if(noLocations < 1){
            throw new MapControlException("There must be at least one location.");
            //invalid number of locations - there must be at least one
        }
        //if the answer has a remainder, add one to the num of rows
        if(noLocations % numColumns > 0){
            numRows = (noLocations / numColumns);
            numRows ++;
        //otherwise, just take the number of locations divided by the number of columns     
        }else {
            numRows = (noLocations / numColumns);
        }
        return numRows;
    }
    
    
    public int calcMoveTime(int curRow, int curCol, int newRow, int newCol)
        throws MapControlException {
        if (curRow < 0 || curCol < 0 || newRow < 0 || newCol < 0) {
            //check for negative inputs
            throw new MapControlException("Rows and columns must be positive.");
        }
        if (curRow > 5 || curCol > 7 || newRow > 5 || newCol > 7) {
            //check for out of range values
            throw new MapControlException("Number cannot be out of map range.");
        }
        if (curRow < 1 || curCol < 1 || newRow < 1 || newCol < 1) {
            //check for 0 values
            throw new MapControlException("Number cannot be zero.");
            
        }
        int rowChange = Math.abs(curRow - newRow);
        int colChange = Math.abs(curCol - newCol);
        int time = (rowChange * 3) +colChange;
        return time;
        
    }
    
   
}
