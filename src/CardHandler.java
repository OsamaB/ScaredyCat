public class CardHandler {
	private Card[] deck = new Card[49];
	private int card = 0;

	// Construct how many of each bird card should be used in the deck
	CardHandler(int a, int b, int c, int d, int e, int f) {
		
		// If to many cards(exit the program)
		if (a + b + c + d + e + f != 40) {
			System.out.println("Error in CardHandler, to many Cards!");
			System.exit(0);
		}
		// 3 cat-cards (-1)
		for (int i = 0; i < 3; i++) {
			deck[card] = Card.CAT;
			card++;
		}
		// 6 scarecrow cards(0)
		for (int i = 0; i < 6; i++) {
			deck[card] = Card.SCARECROW;
			card++;
		}
		// a bird cards with 1 bird
		for (int i = 0; i < a; i++) {
			deck[card] = Card.BIRD1;
			card++;
		}
		// b bird cards with 2 birds
		for (int i = 0; i < b; i++) {
			deck[card] = Card.BIRD2;
			card++;
		}
		// c bird cards with 3 birds
		for (int i = 0; i < c; i++) {
			deck[card] = Card.BIRD3;
			card++;
		}
		// d bird cards with 4 birds
		for (int i = 0; i < d; i++) {
			deck[card] = Card.BIRD4;
			card++;
		}
		// e bird cards with 5 birds
		for (int i = 0; i < e; i++) {
			deck[card] = Card.BIRD5;
			card++;
		}
		// f bird cards with 6 birds
		for (int i = 0; i < f; i++) {
			deck[card] = Card.BIRD6;
			card++;
		}
	}

	// The shuffle-method for the deck
	public void shuffleCards() {
		for (int i = 0; i < deck.length; i++) {
			int otherCard = (int) (Math.random() * deck.length);
			Card temporary = deck[i];
			deck[i] = deck[otherCard];
			deck[otherCard] = temporary;
		}
	}

	// The pick-method when a player picks a card from the deck
	public Card pickCard() {
		Card returnCard = Card.EMPTYCARD;
		for (int i = 0; i < deck.length; i++) {
			if (deck[i] != Card.EMPTYCARD) {
				returnCard = deck[i];
				deck[i] = Card.EMPTYCARD;
				break;
			}
		}
		return returnCard;
	}

	// The reset-method for a players hand (if he/she picks a cat)
	public void resetCards(Card[] hand) {
		// Return cat-card.
		deck[0] = Card.CAT;
		for (int i = 0; i < hand.length; i++) {
			if (hand[i] != Card.EMPTYCARD) {
				for (int j = 1; j < deck.length; j++) {
					if (deck[j] == Card.EMPTYCARD) {
						deck[j] = hand[i];
						break;
					}
				}
			} else {
				break;
			}
		}
		shuffleCards();
	}
}