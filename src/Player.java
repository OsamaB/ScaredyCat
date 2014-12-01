public class Player {

	private String name;
	private int age;
	private Card[] cards = new Card[40];

	Player(String name, int age) {
		this.name = name;
		this.age = age;
		// Make all "card-spots" empty
		for (int i = 0; i < cards.length; i++) {
			cards[i] = Card.EMPTYCARD;
		}
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void addCard(Card card) {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] == Card.EMPTYCARD) {
				cards[i] = card;
				break;
			}
		}
	}

	public String getCards() {
		String theCards = new String("");
		for (Card card : cards) {
			if (card != Card.EMPTYCARD) {
				theCards = theCards.concat(card.getValue() + ", ");
			}
		}
		theCards = theCards.substring(0, theCards.length() - 2);
		theCards = theCards.concat("\n");
		return theCards;
	}

	public Card[] resetCards() {
		Card[] hand = new Card[cards.length];
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] != Card.EMPTYCARD) {
				hand[i] = cards[i];
				cards[i] = Card.EMPTYCARD;
			} else {
				hand[i] = Card.EMPTYCARD;
			}
		}
		return hand;
	}

	public int getPoints() {
		int point = 0;
		for (Card card : cards) {
			if (card != Card.EMPTYCARD) {
				point += card.getValue();
			}
		}
		return point;
	}
}
