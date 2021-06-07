# Mars Rover Kata Java

This code is a part of the [Java Tutorial Through Katas: Mars
Rover](http://technologyconversations.com/2014/10/17/java-tutorial-through-katas-mars-rover/)
article published on Technology Conversations article.

The graphical representation is based on [this
repository](https://github.com/stianeikeland/rover-clj).

We implemented this Kata in Clojure for our [User Group](https://www.meetup.com/de-DE/Dusseldorf-Clojure-Meetup/). You can play around with it in [this repository](https://github.com/clojuredus/clojure-coding-dojo/tree/master/rover).

## Description

In this Kata, we will develop an API to control a Mars Rover around a map. A map
consists of solid rocks, where the rover can't get over, or empty space, where
the rover can drive through. The class `RoverControl` represents the command
central to control our rover over the map. It has a function `execute`, which
takes an `IGame` instance and returns an `IGame` instance with the next state of
our game. Additionally, `execute` receives a parameter `String input`, which
contains characters with commands to control the rover.

Our goal is to read the input string, convert the literals to commands and
execute all commands in one iteration. Valid commands are:

* `l`: turn rover 90 degrees to the left
* `r`: same for right
* `f`: move rover one field into its direction
* `b`: move rover backwards one field

When a single `q` is provided as a command, the application will exit. This is
already handled by the game loop.

Valid directions of the rover:

* `north`: rover is faced to the top of our screen, indicated as `Λ`
* `east`: rover looks to the right side, symbol: `>`
* `south`: rover looks down, symbol: `V`
* `west`: rover looks to the left side, symbol: `<`

Solid rocks are represented as `#` in the graphical representation. Internally
`X` is used. Empty space is internally represented as `_`.

## Start

Use gradle to start the kata:

```
./gradlew run
```

This starts an interactive session of our rover. Here is a sample map:

```bash
   # #  #  ###         ###         #          #        #   #      # # #      #  
    ### # #    ## #      #    # #### #  #    # ## #  #  # ##     #   ##### #    
    #     ##  ##                   #     #               #  #   ## ##   #    ## 
 #  # #   ### # ##   # #      ##    ###    #           #  # # ##    #  #    # ##
    # ####         #  #    # #  ##  # #      #### ## # ## #      # ## ## #     #
 #     #      #   ##     # #    #   #       # ##    #  # #     #   # # #   #  ##
     ## #  #  ##     ### #        ## ## ##            ###            #       #  
      #   #  #            ##          #    #               # # #  #   #      #  
 #  #    # ##   ###     #  #          #         #  #          #         #    #  
##    #  # # #    ###       #    ##        # ##    #        #  ##    #          
#   # ##  #  #       #  # #       #            #      #     # ##  #      #      
 #             # ##      # #             # #   #     #         #     ##  #     #
     ## #   # ##      #  #      #   # # Λ          ## ##  #   ##      #   ##  # 
  #   ##    #        #    #    #          # #  # #   #  #  #   # #   #       #  
##      #         ###      #    #  ##   ##  #  #    ##  #  #      #       # ### 
#  #   # # #     #      #   #  ##### #   ##  #  # ##  ##      ##  ##         #  
  #  #               #       #     ##    #         #   #  ###    #          #   
#                  ## #  #       #                 ### #  #    ## #    # #  #  #
  #### ## #   #    #     #   #     #    #         #  #     #     ##  #          
  #    # ### ##        #     # #  #       ##       #    #   #  #          ##  # 
 ### #      #      ##  ## #    #  ## ###  #  #  #   #   #    #     #    ###     
  ###       ### # ##     # #  # #  #   #   ##     #  #  ###  ## #  ##    #  #   
 #    ## #          ### ##     ##  #           #    #  #      ## #  ###      ## 
 #    #  ##  ## #  #    ##       #             #     # # #   #      ####     ## 
Where do you want to move? Available commands: l, r, f, b, q
```

Currently, the rover is faced north and located in the middle of the map.

Now, it's time to implement `RoverControl.control` to complete the game.

## Hints

* Start with a failing test. This is a good Kata to practice TDD.
* Make your tests small in the beginning. Start with an empty String, then with Strings containing only one character. After all cases have been fulfilled, start with multiple commands in the string.
