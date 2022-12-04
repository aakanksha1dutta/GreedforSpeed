Greed for Speed is a game #TODO


##Controls:

Left Arrow Key (<) - moves the car left.
Right Arrow Key (>) - moves the car right.
Spacebar - starts a new run of the game.


##Game Graphics:
Car - the red square
Rocks - the gray ovals
Road - the black background with white stripes

##Animation: 
The road and rocks move as the game goes on. The car itself does not move vertically, however, the player can control it to move horizontally. Therefore, there is ANIMATION in the game as things move around.

##Interactive:
You can control the car by using the left and right keys. Therefore, the game is INTERACTIVE.

##Scoring Mechanism: 
Like other endless runner games (like Subway Surfers), the score increases the longer you survive. In this game’s case, the score increases as long as you can survive not hitting your car into the rocks. The score is displayed to the player at the top of the screen. Therefore, there is SCORING in the game.

##Ending Mechanism:
The game ends when the player’s car crashes into a rock. All of the game’s animation stops, the score stops increasing, and a game over text is displayed on the screen. This signals the end of that run of the game (players can start a new run by hitting the SPACE key). Therefore, there is an ENDING MECHANISM in the game. 

##Physical Mechanism:
In our game, there is a horizontal (x-axis) motion for the car. If the player does not press any control keys, the car’s position will not change. If the player presses one of the control keys, the car’s position will change accordingly:
Left Arrow (xMotion -= 10)
Right Arrow (xMotion += 10)
Therefore, there is a PHYSICAL MECHANISM in the game.

##Collision Detection:
The method carIntersectsRock() detects the collision between the car and a rock. If the car collides with the rock, the car will stop moving, and a game over text will be displayed on the screen. Therefore, there is a COLLISION DETECTION in our game.

##Creativity:
	We took inspiration from endless runner games we played as kid (Temple Run, Subway Surfers,...) and wanted to create our own endless runner game in Java. Therefore, we created a game where the player is controlling a car and has to avoid obstacles (rocks) in the way. Also, “Greed For Speed” is a pretty creative name, right? 

##Randomized Collidables (Flourish #1):
	The rocks are generated randomly at different positions. Additionally, the sizes of the rocks are also randomized. Therefore we have RANDOMIZED COLLIDABLES in our game. 

##Highscore System(Flourish #2):
	A highscore is recorded and displayed at the top of the screen. The score persists between runs of the game, and updates continuously if the player’s current score is greater than the high score. Therefore, there is a HIGHSCORE SYSTEM in our game. 



