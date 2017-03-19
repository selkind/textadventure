         if (c==6 && r == 6)
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
