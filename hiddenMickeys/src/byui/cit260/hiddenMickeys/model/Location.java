
package byui.cit260.hiddenMickeys.model;

import java.io.Serializable;


public class Location implements Serializable{
    //class instance variables
    private int column;
    private int row;
    private boolean visited;
    private boolean mickeyCollected;
    private int locationNo;
    private Scene scene;

    public Location(){
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isMickeyCollected() {
        return mickeyCollected;
    }

    public void setMickeyCollected(boolean mickeyCollected) {
        this.mickeyCollected = mickeyCollected;
    }

    public int getLocationNo() {
        return locationNo;
    }

    public void setLocationNo(int locationNo) {
        this.locationNo = locationNo;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

   

   
    

/*    
pirates_caribbean("Pirates of the Caribbean",1,1,1,true,"ride"),	
fast_pass_1("Fast Pass Station",2,2,1,false,"fp"),			
pieces_eight("Pieces of Eight",3,3,1,false,"shop"),	        
haunted_mansion("Haunted Mansion",4,4,1,true,"ride"),			
beignet("Mickey Beignet Shop",5 ,5,1,true,"food"),			
bench("Park Bench",6,1,2,false,"rest"),		
hungry_bear("Hungry Bear Restaurant (food)",7,2,2,false,"food" ),			
winnie_pooh("Winnie the Pooh" ,8,3,2,true,"ride" ),      		        
fast_pass_2("Fast Pass",9,4,2,false,"fp"),
splash_mountain("Splash Mountain",10,5,2,true,"ride"),
indiana_jones("Indiana Jones Adventure",11,1,3,true,"ride"),		
tiki_room("Enchanted Tiki Room (rest)",12,2,3, false,"rest" ),        	
jungle_cruise("Jungle Cruise",13,3,3,false,"ride"),			
tarzan_treehouse("Tarzan’s Treehouse (ride)",14,4,3,true,"ride"),
dole_whip("Dole Whip (food)",15,5,3,false,"food"),
main_gate("Main Gate(START)",16,1,4,false,"start"),
main_cinema("Main Street Cinema (rest)",17,2,4,false,"rest"),
emporium("Emporium Souvenirs",18,3,4,true,"shop"),
carnation("Carnation Ice-cream Shop",19,4,4,false,"food"),
magic_shop("Main Street Magic Shop",20,5,4,true,"shop"),
small_world("It’s a Small World	",21,1,5,true,"ride"),
village_haus("Village Haus Restaurant (food)",22,2,5,false,"ride"),
matterhorn("Matterhorn Bob Sleds",23,3,5,true,"ride"),
peter_pan("Peter Pan’s Flight",24,4,5,true,"ride"),
alice_wonderland("Alice In Wonderland",25,5,5,true,"ride"),
space_mountain("Space Mountain",26,1,6,true,"ride"),
star_tours("Star Tours",27,2,6,true,"ride"),
fast_pass_3("Fast Pass",28,3,6,false,"fp"),
astro_blasters("Buzz Lightyear Astro Blasters",29,4,6,true,"ride"),
pizza_port("Pizza Port (food)",30,5,6,false,"food"),
thunder_food("Big Thunder Ranch Food",31,1,7,false,"food"),
mark_twain("Mark Twain Riverboat",32,2,7,true,"rest"),
thunder_mountain("Big Thunder Mountain RR",33,3,7,true,"ride"),
columbia("Sailing Ship Columbia (rest)",34,4,7,false,"ride"),
sawyer_island("Tom Sawyer Island ",35,5,7,true,"ride");
*/
    


   
    
    
    
}
