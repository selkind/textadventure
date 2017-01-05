import java.util.Scanner;
import java.util.ArrayList;

public class Game
{
int nose = 0;


    public SpaceType [][] location() //This method creates the map by assigning values, representing
    {                                //different types of spaces to a 2-D array.
      SpaceType [] [] map;
      map = new SpaceType [13][10];
      
      for( int c = 0; c < 13; c++)
      {
         for( int r = 0; r < 10; r++)
         {
         /* filling in perimeter with walls*/
         if( r == 0 || r == 9 || c == 0 || c == 12){
           map[c][r] = new SpaceType(0);
           }
        
         else if( r == 1 && (c == 6 || c == 9))
          {
          map[c][r] = new SpaceType(0);
          }
         
          else if( r == 2 && (c == 2 || c == 4 || c == 5 || c == 6 || c == 7 || c == 9 ))
          {
          map[c][r] = new SpaceType(0);
          }
          else if( r == 3 && (c == 9 || c == 10))
          {
          map[c][r] = new SpaceType(0);
          }
          else if( r == 4 && ((c < 6 && c > 0) || c == 7|| c == 9 ))
          {
          map[c][r] = new SpaceType(0);
          }
          else if( r == 5 && (c ==1 || c == 6 || c == 7 ))
          {
          map[c][r] = new SpaceType(0);
          }
          else if( r == 6 && (c == 1 || c == 3 || c == 5 || c == 10 || c == 11))
          {
          map[c][r] = new SpaceType(0);
          }
          else if( r == 7 && (c == 1 || c == 3 || c == 6 || c == 7 || c == 8 || c == 10 || c == 11 ))
          {
          map[c][r] = new SpaceType(0);
          }
          else if( r == 8 && (c == 3 ))
          {
          map[c][r] = new SpaceType(0);
          }
          else
           {
           map[c][r] = new SpaceType(1);
           }
           /* locations of interactive features */
           map[4][7] = new SpaceType(2);
           map[11][8] = new SpaceType(3);
           map[7][1] = new SpaceType(4);
           map[10][1] = new SpaceType(5);
           map[1][2] = new SpaceType(6); 
           map[1][8] = new SpaceType(7); 
                
         }     
      }
      return map;   
    }
    
    
    String gameRules(int c,int r, SpaceType[][] map ) //This method reads the location of the user and returns
    {                                                 // a description of where the walls are around the user
      boolean edges = ( c<1 || c>12 || r<1 || r>8);   //This method is designed to work with any rectangular map
      if( edges )                                     //design. The only change required to accommodate a different
      {                                               //map is the boolean edges.
      return "You cant be here"; 
            }
        else{
        int north = map[c][r-1].type;
        int south = map[c][r+1].type;
        int east = map[c + 1][r].type;
        int west = map[c - 1][r].type;
        String Ndesc = "";
        String Edesc = "";
        String Sdesc = "";
        String Wdesc = "";
        if( north == 0 )
        {
          Ndesc = "North";
        }
        if( east == 0 )
        {
          Edesc = "East";
        }
        if( south == 0 )
        {
          Sdesc = "South";
        }
        if( west == 0 )
        {
          Wdesc = "West";
        }
        return ("There is a wall to your " + Ndesc + " " + Edesc + " " + Wdesc +" "+ Sdesc);
        }
    }
    public boolean trilobite(Scanner s, int stepcount, ArrayList <String> Backpack) //This method creates all the possible interactions with the monster.
    {
        System.out.println("Oh no! What is that?");
        System.out.println("It is a giant Trilobite! It must have survived the \n"+
        "Permian Mass Extinction (250 mya) by hiding in this mineshaft");
        System.out.println("Trilobite: Who are you?! What are you doing here?!");
        System.out.println();
        String message =
            "What would you like to say? (enter a number 1-3)\n" +
            "1. What? How can a three lobed fossil from the Permian talk?\n" +
            "2. AHHHHHHHHHHHHHH (run away)\n" +
            "3. Time to join your fossilized friends (attack)\n";
        String message2 =
            "What would you like to say? (enter a number 1-3)\n" +
            "1. As a geologist I would like to study you and gain \n"+
            "   your insights into the Proterozoic of course.\n" +
            "2. Nothing! AHHHHHHHH (run away)\n" +
            "3. Keys huh? (attack)\n";
        while (true)
        {
        System.out.println(message);
        System.out.print(">");
        String input = s.nextLine();
        
            if(input.equals("1"))
               {
               System.out.println("Trilobite: I have lived down here for many years, collecting things such as this key.");
               System.out.println("Trilobite: What do you want from me?");
               System.out.println();
               System.out.println(message2);
               System.out.print(">");
               String input2 = s.nextLine();
                  if (input2.equals("1"))
                  {
                     System.out.println("Trilobite: You will do no such thing!");
                     System.out.println("The Trilobite attacked you!");
                     int rockHammer = 0;
                     for (int i = 0; i<Backpack.size(); i++)
                     {
                        if( Backpack.get(i).equals("Rock Hammer:"))
                        {
                           rockHammer = 1;
                        }
                     }
                     if( rockHammer == 1 )
                     {
                        System.out.println("You used your rock hammer to send that trilobite crawling back \n"+
                        "to the Paleozoic seas!!");
                        return true;
                     }
                     else
                     {
                        System.out.println("You didn't have any weapons to defend yourself. You are dead!");
                        System.out.println( "number of steps: " + stepcount);
                        System.exit(0);
                     }
                  }
                  if (input2.equals("2"))
                  {
                     return false;
                  }
                  if (input2.equals("3"))
                  {
                     int rockHammer = 0;
                     for (int i = 0; i<Backpack.size(); i++)
                     {
                        if( Backpack.get(i).equals("Rock Hammer:"))
                        {
                           rockHammer = 1;
                        }
                     }
                     if( rockHammer == 1 )
                     {
                        System.out.println("You used your rock hammer to send that trilobite crawling back\n"+
                        "to the Paleozoic seas!!");
                        return true;
                     }
                     else
                     {
                        System.out.println("You attacked without any armaments and died!");
                        System.out.println( "number of steps: " + stepcount);
                        System.exit(0);
                     }
                  }    
                  else 
                  {
                     System.out.println("That is not a valid response"); 
                  }
               }
               if(input.equals("2"))
               {
                  return false;
               }
               if(input.equals("3"))
               {
                  int rockHammer = 0;
                  for (int i = 0; i<Backpack.size(); i++)
                  {
                  if( Backpack.get(i).equals("Rock Hammer:"))
                     {
                     rockHammer = 1;
                     }
                  }
                  if( rockHammer == 1 )
                  {
                        System.out.println("You used your rock hammer to send that trilobite crawling back \n"+
                        "to the Paleozoic seas!!");
                        return true;
                   }
                  else
                   {
                        System.out.println("You attacked without any armaments and died!");
                        System.out.println( "number of steps: " + stepcount);
                        System.exit(0);
                   }               
               }
               else
               {
                  System.out.println("That is not a valid response");
               }
      
    }
    }
     
     
      public boolean check(int c, int r, int stepcount, SpaceType[][] map, ArrayList<String> Backpack, Scanner s) 
      {                                         //This method checks to see if the user can move to a certain space 
         if(map[c][r].type == 0)                //If the user can move there, it returns true, else it returns false 
         {                                      // This method also functions with any map design, and interaction with
            nose = nose + 1;                    // with a new SpaceType can easily be implemented.
               if(nose <= 3)
            {
               System.out.println("Your nose hurts, you must have ran into a wall!...dumbass");
               
            }
            else if(nose > 3 && nose <= 6)
            {
               System.out.println("You seem to be having trouble with the concept of walls. \n"+
               "Try NOT running into them...");
               
            }
            else if(nose > 6 && nose <= 9)
            {
               System.out.println("Your head is ringing, you see stars, and you can feel\n"+
               "blood dripping down your chin. You're not sure if you will make it out\n"+
               "if you keep running into these damn walls");
               
             }
            else
            {
            System.out.println("Yet again, you hit a wall. Your knees feel weak...\n"+
            "they buckle and you slide slowly to the ground. The corridor around\n"+
            "you darkens and fades to black.\n"+
            "You have died");
            System.out.println( "number of steps: " + stepcount);
            System.exit(1);
            }
            
         return false;        
         }
         else if( map[c][r].type == 2 ) // interaction with door1
         {
         while( true )
         {
            System.out.println("OOH! A door! What a nice door! I wonder what's behind it");
            System.out.println("Would you like to open it?\n" +
            "1. Yes\n" +
            "2. No\n");
            System.out.print(">");
            String input_door = s.nextLine();
            if( input_door.equals("1"))
            {
             int goldkey = 0;
                  for (int i = 0; i<Backpack.size(); i++)
                  {
                  if( Backpack.get(i).equals("Gold Key:"))
                     {
                     goldkey = 1;
                     }
                  }
                  if( goldkey == 1 )
                  {
                        System.out.println("You unlocked the door with the Gold Key!\n"+
                        "What a marvellous invention keys are!");
                         map[4][7] = new SpaceType(1);
                        return true;
                         
                   }
                  else
                   {
                        System.out.println("The door is locked. I'd better go look for a key that fits");
                        System.out.println();
                        return false;
                   }  
                }         
            else if(input_door.equals("2"))
            {
            return false;
            }
            else
            {
            System.out.println("That's not a valid input");
            }
          }
          }
            
       
       
         else if( map[c][r].type == 3 )//interaction with gold key
         {
         key key1 = new key("Gold Key:", "Nice and shiny, might open something...");
         Backpack.add(key1.name);
         Backpack.add(key1.desc);
         map[11][8] = new SpaceType(1);
         System.out.print( "You found a Gold Key " );
         System.out.println();
         return true;
         }
         else if( map[c][r].type == 4 )//interaction with rock hammer
         {
         rockHammer h1 = new rockHammer("Rock Hammer:", "Standard issue for geologists," +
         " can break open geodes, or trilobite exoskeletons... if you know how to use it");
         Backpack.add(h1.name);
         Backpack.add(h1.desc);
         map[7][1] = new SpaceType(1);
         System.out.print( "You found a rock hammer " );
         System.out.println();
         return true;
         }
         else if( map[c][r].type == 5 )//interaction with ore sample
         {
         sample s1 = new sample("Chromite sample:", "A shiny black block of chromite... " +
         "Some good 'ol FeCr2O4 could make you rich! If you ever get out of here...");
         Backpack.add(s1.name);
         Backpack.add(s1.desc);
         map[10][1] = new SpaceType(1);
         System.out.print( "You've found a ore-grade vein of chromite! \n"+
         "Better take a sample back to show your boss. " );
         System.out.println();
         return true;
         }
          else if( map[c][r].type == 6 )//interaction with monster (calls trilobite method above)
         {
         boolean live = trilobite(s, stepcount, Backpack);
         key key2 = new key("Platinum Key:","Very nice and really shiny, might open something too..." );
            if (live)
            {  
               Backpack.add(key2.name);
               Backpack.add(key2.desc);
               System.out.println();
               System.out.println( "You picked up a Platinum Key out of the trilobite's gooey interior... Gross! ");
               System.out.println();
               return true;
            }
            else
            {
            System.out.println("You ran away...coward!");
            System.out.println();
            return false;
            }
         }
         else if( map[c][r].type == 7 )//interaction with door2, if opened user wins.
         {
         while( true )
         {
            System.out.println("OOH! A door! What a REALLY nice door! I think this is the way out!");
            System.out.println("Would you like to open it?\n" +
            "1. Yes\n" +
            "2. No\n");
            System.out.print(">");
            String input_door = s.nextLine();
            if( input_door.equals("1"))
            {
             int platkey = 0;
                  for (int i = 0; i<Backpack.size(); i++)
                  {
                  if( Backpack.get(i).equals("Platinum Key:"))
                     {
                     platkey = 1;
                     }
                  }
                  if( platkey == 1 )
                  {
                        System.out.println("You unlocked the door with the Platinum Key!\n"+  //This is where all of the 
                        "What a marvellous invention keys are!\n"+                            //different win conditions are coded
                        "The warm sunlight hits your face, a tear comes to your eye\n"+
                        "with the fresh air on your lips, you shout \"I\'M FREE!!!\"");
                        System.out.println();
                        if( stepcount > 200 )
                        {
                        System.out.println("You crawl out of the mine, weak from hunger and thirst.\n"+
                         "in your weakened state, don't notice the steep dropoff by the entrance\n"+
                         "and plunge to your death. Congratulations...");
                        }
                        else if ( nose > 6 )
                        {
                           if( Backpack.size() == 10 )
                              {
                              System.out.println("You stumble out of the mine, dizzy and bleeding. \n"+
                              "Thanks to your excellent geology skills, \n"+
                              "your discovery of the rich chromite vein earns\n"+
                              "you millions of dollars and you live \n"+
                              "happily ever after.\n"+
                              "However, thanks to your disregard of walls, for the rest of your life \n"+
                              "you can never quite believe that it's not butter");
                              }
                            else
                              {
                              System.out.println("You stumble out of the mine, dizzy and bleeding.\n"+
                              "Thanks to your disregard of walls, for the rest of your life \n"+
                              "you can never quite believe that it's not butter.");
                              }
                        }
                        else if ( Backpack.size() == 10 )
                        {
                        System.out.println("Congratulations! With your excellent survival skills and \n"+
                        "discovery of the rich chromite vein, you make millions of dollars and live \n"+
                        "happily ever after, despite the occasional trilobite nightmare");
                        }
                        else
                        {
                        System.out.println( "Congratulations! You've made it out of the mine!");
                        }
                        System.out.println("You escaped in " + stepcount + " moves");
                         System.exit( 0 );
                         
                   }
                  else
                   {
                        System.out.println("The door is locked. I'd better go look for a key that fits");
                        System.out.println();
                        return false;
                   }  
                }         
            else if(input_door.equals("2"))
            {
            return false;
            }
            else
            {
            System.out.println("That's not a valid input");
            }
          }
          }
         
         else
         {
         return true;
         }
        
     }

    public void showMap(int c,int r, SpaceType [][] map) //This method prints the map when called
    {
    for( r = 0; r < 10; r++)
      {
      
      System.out.println();
         for( c = 0; c <13; c++)
      
         {
             int test = map[c][r].type;
             if( test == 0 )
             {
            System.out.print("[]");
            }
            else
            {
          System.out.print("  ");
            }
        }
      }
    }
    
    public void mainNonStatic( String [] args ) //The main method here serves to prompt the user for input, 
    {                                           //call the other methods depending on that input,
      System.out.println();                     //and record stats (such as position or number of steps)
      System.out.println
     (
     "You are a geologist surveying a mineshaft in the Stillwater Complex\n"+    //Starting prompt w/instructions
     "in the Beartooth Mountains of Montana.\n" +
     "Unfortunately a rock has fallen on your head and you have no idea where you are...\n"+
     "\n"+
     "Use \"n\" to go north, \"e\" to go east,\n"+
     "\"s\", to go south and \"w\" to go west.\n"+
     "Press \"m\" to look at your map.\n"+
     "You can check to see what's in your backpack by pressing \"b\" \n"+
     "If you want to see your progress, type \"stat\".\n"+
     "If you forget how to do something, press \"h\" to display this message again\n" +
     "\n"+
     "GOOD LUCK");
     System.out.println();   
      SpaceType [][] map2= location();
      int c = 6;                               //initial location
      int r = 4;
      int stepcount = 0;
      System.out.println(gameRules(c, r, map2));
      compass comp;
      comp = new compass("Brunton Compass:", "Your trusty tool for strikes and dips...");
      ArrayList <String> Backpack = new ArrayList<String>();
      Backpack.add( comp.name );
      Backpack.add( comp.desc );
      boolean won = false;
      while (!won)
      {
       
         Scanner s = new Scanner (System.in);
         System.out.print(">");
         String input = s.nextLine();
         if (input.equalsIgnoreCase("north") || input.equalsIgnoreCase("n")) //if direction given
         {
            stepcount++;                                                     //increase stepcount
            if (check (c, r-1, stepcount, map2, Backpack, s))                //check to see if user can move there, 
            {
               r=r-1;                                                        //record change in location
               System.out.println(gameRules(c, r, map2));                    //print new location description
            }
            else
            {
               r=r;
               System.out.println(gameRules(c, r, map2));
            }
         }
         else if (input.equalsIgnoreCase("east") || input.equalsIgnoreCase("e"))
         {
            stepcount++;
            if (check (c+1, r, stepcount, map2, Backpack, s))
            {
               c=c+1;
               System.out.println(gameRules(c, r, map2));
            }
            else
            {
               r=r;
               System.out.println(gameRules(c, r, map2));
            }

         }
         else if (input.equalsIgnoreCase("south") || input.equalsIgnoreCase("s"))
         {
            stepcount++;
            if (check (c, r+1, stepcount, map2, Backpack, s))
            {
               r=r+1;
               System.out.println(gameRules(c, r, map2));
            }
            else
            {
               r=r;
               System.out.println(gameRules(c, r, map2));
            }

         }
         else if (input.equalsIgnoreCase("west") || input.equalsIgnoreCase("w"))
         {
            stepcount++;
            if (check (c-1, r, stepcount, map2, Backpack, s))
            {
               c=c-1;
               System.out.println(gameRules(c, r, map2));
            }
            else
            {
               r=r;
               System.out.println(gameRules(c, r, map2));
            }
 
         }
         else if (input.equalsIgnoreCase("b")||input.equalsIgnoreCase ("backpack"))   //Shows contents of backpack
         {
            for(int i= 0; i< Backpack.size(); i++)
            {
            System.out.println(Backpack.get(i));
            }  
         }
         else if (input.equalsIgnoreCase("M") || input.equalsIgnoreCase("Map"))     //Displays map
         {
            showMap(c, r, map2);
            System.out.println();
         }

          else if (input.equalsIgnoreCase("h")||input.equalsIgnoreCase ("help"))   //Displays help
         {
          System.out.println
           ("Use \"n\" to go north, \"e\" to go east, \"s\", to go south\n"+
            "and \"w\" to go west.\n"+
            "Press \"m\" to look at your map.\n"+
            "You can check to see what's in your backpack by pressing \"b\" \n"+
            "If you want to see your progress, type \"stat\".\n"+
            "If you forget how to do something, press \"h\" to display this message again\n" +
            "\n"+
            "GOOD LUCK");
            System.out.println();
            System.out.println(gameRules(c, r, map2));        
         }
         else if (input.equalsIgnoreCase("stat") || input.equalsIgnoreCase("stats"))
         {
            System.out.println( "number of steps: " + stepcount);
            System.out.println( "backpack items : " + Backpack.size()/2);
            System.out.println( "You've run into a wall " + nose + " times.");
         }
         else 
         {
            System.out.println("That is not a valid direction");
            System.out.println(gameRules(c, r, map2));
         }
         if (c==6 && r == 6)                                //If user finds tunnel
         {
            System.out.println("You found a tunnel! Would you like to go inside?\n"+
                               "1. Yes \n" +
                               "2. No");
            
            boolean tunnel = false;
            while (!tunnel)
            {
               String YN = s.nextLine();
               if (YN.equals("1"))
               {
                  c = 4;
                  r = 1;
                  
                  System.out.println("You go through the tunnel and stumble out into another location\n"+
                                     "The tunnel is to your East");
                  System.out.println(gameRules(c, r, map2));
                  System.out.println();
                  tunnel = true;
               }
               else if (YN.equals("2"))
               {
                  c = c+1;
                  System.out.println(gameRules(c, r, map2));
                  System.out.println();
                  tunnel = true;
               }
               else 
               {
               System.out.println("That is valid response. Please enter 1 or 2");
               }
            }
         }
         if (c==5 && r == 1)
         {
            System.out.println("You found a tunnel! Would you like to go inside?\n"+
                               "1. Yes \n" +
                               "2. No");
            
            boolean tunnel = false;
            while (!tunnel)
            {
               String YN = s.nextLine();
               if (YN.equals("1"))
               {
                  c = 7;
                  r = 6;
                  System.out.println("You go through the tunnel and stumble out into another location\n"+
                                     "The tunnel is to your West");
                  System.out.println(gameRules(c, r, map2));
                  System.out.println();
                  tunnel = true;
               }
               else if (YN.equals("2"))
               {
                  c = c-1;
                  System.out.println(gameRules(c, r, map2));
                  System.out.println();
                  tunnel = true;
               }
               else 
               {
               System.out.println("That is valid response. Please enter 1 or 2");
               }
            }
         }
             
      }
    }

    public static void main( String [] args ) {
        ( new Game() ).mainNonStatic( args );
    }
}
