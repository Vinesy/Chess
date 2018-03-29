# The Game of Chess

What makes a good design for the game of chess?  Chess at its basic form is a board game.  A good design could easily be modified to work for any board game.  A board game consists of a physical board containing the state of the game being played.  There are 1 to many players in a board game.  Players take turns changing the state of the board until an end state has been achieved.  Sometimes players can choose from many options when changing the state of the board.  Other times they follow a more simplistic rails approach, like rolling dice, or drawing a card.  Pieces on the board move based on a set of rules that are affected by the state of the board.  Sometimes there is only one set rules for all pieces.  Sometimes the rules are different for every piece on the board.

## Talk about REST.  Other frameworks besides MVC.  What would C do?

## Application of a board game to chess in a MVC Framework

The Board (The View)
	8x8 Matrix of alternating black and white.
	Always starts at the same initial state.
	Pieces can only move based on the position of other pieces on the Board.
	Captured pieces are removed from the board.

The Pieces (The Model)
	Each type of Piece on the board can only move in specific ways.
	Sometimes the condition of the board dictates that a piece cant move.
		(two pawns can get stuck with no passing option)
	Sometimes a special move can be made if certain conditions are met.
		( A king can castle as long as he and the rook hasn't moved yet)

The Ruleset (The Controller)
	A person chooses what move to make, but can only moved within the constraints of the Pieces and The Board.
	If the person is in check, their move has to be to take the king out of check.
	If the person is in checkmate, the game is over.
	A person can not move a piece if it puts them in check.
	
### Control Flow

The Controller starts a new game.  This creates each piece needed by the game and places them on the board.  Each piece when created sets a flag that they have never moved.  You could create 8 pawns and pass in the initial position of the pawns.  

	Pawn pawn1 = new Pawn(2A) // Pawn created at position 2A
  
Or you could object out each pawn to a specific pawn type.

 	Pawn pawn1 = new BlackPawn1();
	
I will have to think more of what the pro's and cons of this would be.  In the context of the bishops, each player has both a white tile and a black tile bishop.  From a software standpoint though it isn't required to call out which is which.  As long as each bishop starts on the proper tile, the algorithm x = y will dictate how the bishop can move.

The simplest solution would be to have an 8x8 Matrix of chess pieces, where the array is initialized to the starting position of each piece.  Empty cells with no pieces are null.  Pieces don't need to store their position.  Positions are all maintained by the controller.  The controller can query pieces against positions.  This can be further exposed later on to show additional information in the view, like highlighting where a piece can go.
