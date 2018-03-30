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
	
### Object Control Flow
class
The Controller starts a new game.  This creates a Model which then creates all the pieces needed by the game and places them on the board.  Each piece when created sets a flag that they have never moved.  You could create 8 pawns and pass in the initial position of the pawns.  

	Pawn pawn1 = new Pawn(2A) // Pawn created at position 2A
  
Or you could object out each pawn to a specific pawn type.

 	Pawn pawn1 = new BlackPawn1();
	
I will have to think more of what the pro's and cons of this would be.  In the context of the bishops, each player has both a white tile and a black tile bishop.  From a software standpoint though it isn't required to call out which is which.  As long as each bishop starts on the proper tile, the algorithm will dictate how the bishop can move.

The simplest solution would be to have an 8x8 Matrix of chess pieces, where the array is initialized to the starting position of each piece.  Empty cells with no pieces are null.  Pieces don't need to store their position.  Positions are all maintained by the controller.  The controller can query pieces against positions.  This can be further exposed later on to show additional information in the view, like highlighting where a piece can go.

### Model Implementation Notes (First Java Commit)

The current implementation focus's only on the model.  I have decided that there will be a dedicated Model.class that will be the only interface to packages outside of the model.  This class is ultimately a superset of the chess board and chess pieces.  The model will create a new chessboard, and that chessboard will create an array chesspieces that mimic the board layout.  If there is no chess piece in a position, then that position just contains a null pointer to a piece.  Each Chesspiece is contructed with a Team (white|black) and also a pointer to the chessboard (more on that decision later).

Each piece once contructed, knows what team it is on and that is it.  Pieces where designed in a way that they do not keep track of their position in space.  Instead each peice is its own model.  You can pass a piece a position, and it will tell you all the possible moves that piece can make.  It does this by running through an algorithm based on that pieces rules, and makes sure its next move is one of several positions that is:
	A) a valid position on the board
	B) is not a position held by another team member
	C) can be a position held by an enemy, but stopping movement in that direction. ( A Rook can not move past an enemy position)
	D) Any special moves that are unique to a piece such as En Passant, or Castling

The reason for this list of possible moves to be returned is that this list can be used to add context to a view when a piece is selected to make its next move.  I also want to run tests where I see how long it will take the program to calculate every possible board move.  If I make the Pieces aware of their current position, they are just storing that information for no reason.  The Board still needs to know their position, and they still need the board to look up other pieces that affect their play.

The decision to pass a pointer to the board into each piece is because there is really only one instance of the board for all the pieces.  In fact in my example, the board creates all the pieces.  So if I do not pass the board into each piece for lookup purposes of the algorithm, then I need to make the board a Singleton, or some static member of my ChessPosition class i.e. have a roundabout way of letting the pieces access the board.  If I make the board a singleton, then I am immediately saying that I need to create a test class for the board in order to test all the pieces.  And having your production code point to test classes is more difficult than just passing a test class into your codes contructor.  Although the scale of this example is very limited and it would not be hard, the point of me spending time at home coding this application is to practice for a world that is unlimited and infinitely scalable.
