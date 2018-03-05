The game of Chess

What makes a good design for the game of chess?  Chess at its basic form is a board game.  A good design could easily be modified to work for any board game.  A board game consists of a physical board containing the state of the game being played.  There are 1 to many players in a board game.  Players take turns changing the state of the board until an end state has been achieved.  Sometimes players can choose from many options when changing the state of the board.  Other times they follow a more simplistic rails approach, like rolling dice, or drawing a card.  Pieces on the board move based on a set of rules that are affected by the state of the board.  Sometimes there is only one set rules for all pieces.  Sometimes the rules are different for every piece on the board.

Application of a board game to chess.
## Talk about REST.  Other frameworks besides MVC.  What would C do?
The Board (The View)
	8x8 Matrix of alternating black and white.
	Always starts at the same initial state.
	Pieces can only move based on the position of other pieces on the Board.
	Captured pieces are removed from the board.

The Pieces (The Model)
	Each type of Piece on the board can only move in specific ways.
	Sometimes the condition of the board dicates that a piece cant move.
		(two pawns can get stuck with no passing option)
	Sometimes a special move can be made if certain conditions are met.
		( A king can castle as long as he and the rook hasn't moved yet)

The Combatants? (The Controller)
	A person chooses what move to make, but can only moved within the constraints of the Pieces and The Board.
	If the person is in check, their move has to be to take the king out of check.
	If the person is in checkmate, the game is over.
	A person can not move a piece if it puts them in check.
	 
