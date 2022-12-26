# Tic-Tac-Toe

![badge](https://img.shields.io/badge/language-Java-orange.svg)

This project is an intelligent system demonstrating the application of adversarial search strategies in ensuring optimal gameplay. In particular, the agent plays <b>tic-tac-toe</b> (also known as <b>noughts and crosses</b>) against a human player. The system has six levels of rationality; while the level 0 agent selects its moves only randomly, winning against the levels 1 to 5 agents is guaranteed to be an impossibility. Moreover, in the interest of algorithm analysis, the program also tracks the match statistics and the decision time spent per move.

This application follows the classical version of the game, where two players take turns in placing their tokens (X's and O's) on a 3 x 3 board and the winner is the player who first places three of their tokens to form a complete row, column, or diagonal. It is to be noted that tic-tac-toe is a solved game resulting in a forced draw given perfect play from both parties.

## Task
<b>Tic-tac-toe</b> is a major course output in an introduction to intelligent systems class under Dr. Judith J. Azcarraga of the Department of Computer Technology, De La Salle University. The goal of the agent is to <i>form one of the eight winning configurations before its opponent, thus winning the game</i>. This application exhibits six levels of rationality, distinguished by the complexity of their goals and their underlying algorithms:
- <b>Level 0:</b> The agent decides on its moves randomly as long as the position is unoccupied. 
- <b>Level 1:</b> From this level onwards, the agent also aims to <i>actively prevent its opponent from completing a winning configuration</i>. In order to do so, it consults a hard-coded table of optimal moves per board configuration.
- <b>Level 2:</b> The agent employs the standard minimax algorithm (a depth-first search strategy for adversarial games).
- <b>Level 3:</b> The agent combines the standard minimax algorithm with alpha-beta pruning to decrease the size of the search space.
- <b>Level 4:</b> From this level onwards, the agent also aims to <i>win in the least number of moves</i>. In order to do so, it employs a depth-sensitive variant of the minimax algorithm.
- <b>Level 5:</b> The agent combines the said depth-sensitive variant of the minimax algorithm with alpha-beta pruning to decrease the size of the search space.

In addition to the <b>match statistics</b> and the <b>decision time of both players</b>, the <b>evaluation of the agent</b> is also displayed whenever applicable. Below is a screenshot of the gameplay: <br/>

<img src="https://github.com/memgonzales/tic-tac-toe/blob/master/system_screenshots/TicTacToe_1.PNG?raw=True" alt="Screenshot (Level 5)" width = 500> 

The project consists of three folders:

- [<code>api</code>](https://github.com/memgonzales/tic-tac-toe/tree/master/api) - <code>Javadoc</code> documentation of this project
- [<code>out</code>](https://github.com/memgonzales/tic-tac-toe/tree/master/out) - <code>.class</code> files
- [<code>src</code>](https://github.com/memgonzales/tic-tac-toe/tree/master/src) - <code>.java</code> files (source codes)

Besides the [<code>Tic Tac Toe.jar</code>](https://github.com/memgonzales/tic-tac-toe/blob/master/Tic%20Tac%20Toe.jar) file, it also includes the following document:
- [<code>Technical Report.pdf</code>](https://github.com/memgonzales/tic-tac-toe/blob/master/Technical%20Report.pdf) - Formal discussion of the levels of rationality and behavior of the agent

## Built Using
This project was built using <b>Java</b> following the Model-View-Controller (MVC) architectural pattern, with the <code>.class</code> files generated via <b>Java SE Development Kit 14</b>. The graphical user interface was created using <b>Swing</b>, a platform-independent toolkit that is part of the Java Foundation Classes. 

## Authors
- <b>Mark Edward M. Gonzales</b> <br/>
  mark_gonzales@dlsu.edu.ph <br/>
  gonzales.markedward@gmail.com <br/>
  
- <b>Hylene Jules G. Lee</b> <br/>
  hylene_jules_lee@dlsu.edu.ph <br/>
  lee.hylene@gmail.com
  
 Assets (images) are properties of their respective owners. Attribution is found in the file [<code>src/gui/assets/asset-credits.txt</code>](https://github.com/memgonzales/tic-tac-toe/blob/master/src/gui/assets/asset-credits.txt).
