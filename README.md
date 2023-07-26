
Remember the dino game that shows up on your browser whenever your internet stops working? Well, Greed for Speed is a top down, endless runner game (just like the dino game!) where the player controls a car on a road as they try to avoid obstacles (in this case, rocks). The further you go without hitting a rock, the higher your score is. 

Controls:

Left Arrow Key (<) - moves the car left.
Right Arrow Key (>) - moves the car right.
Spacebar - starts a new run of the game.

Features:
Animation: 
The road and rocks move as the game goes on. The car itself does not move vertically, however, the player can control it to move horizontally. 
Interactive:
You can control the car by using the left and right keys. 

Randomized Collidables:
The rocks are generated randomly at different positions. Additionally, the sizes of the rocks are also randomized. 

Highscore System:
A highscore is recorded and displayed at the top of the screen. The score persists between runs of the game, and updates continuously if the player’s current score is greater than the high score. 

Scoring Mechanism: 
Like other endless runner games (like Subway Surfers), the score increases the longer you survive. In this game’s case, the score increases as long as you can survive not hitting your car into the rocks. The score is displayed to the player at the top of the screen. 

Ending Mechanism:
The game ends when the player’s car crashes into a rock. All of the game’s animation stops, the score stops increasing, and a game over text is displayed on the screen. This signals the end of that run of the game (players can start a new run by hitting the SPACE key). 

Physical Mechanism:
In our game, there is a horizontal (x-axis) motion for the car. If the player does not press any control keys, the car’s position will not change. If the player presses one of the control keys, the car’s position will change accordingly:
Left Arrow (xMotion -= 10)
Right Arrow (xMotion += 10)

Collision Detection:
The method carIntersectsRock() detects the collision between the car and a rock. If the car collides with the rock, the car will stop moving, and a game over text will be displayed on the screen. 

The developer took inspiration from endless runner games we played as kid (Temple Run, Subway Surfers,...) and wanted to create their own endless runner game in Java. Therefore, they created a game where the player is controlling a car and has to avoid obstacles (rocks) in the way. Also, “Greed For Speed” is a pretty creative name, right? 
