import java.util.*;

class Card {
    private String palo;
    private String color;
    private String valor;

    public Card(String palo, String color, String valor) {
        this.palo = palo;
        this.color = color;
        this.valor = valor;
    }

    public String getPalo() {
        return palo;
    }

    public String getColor() {
        return color;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return palo + "," + color + "," + valor;
    }
}

class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] palos = {"tréboles", "corazones", "spades", "diamantes"};
        String[] colores = {"negro", "rojo"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String palo : palos) {
            for (String color : colores) {
                if((palo == "tréboles" && color == "negro")||(palo == "spades" && color == "negro")||(palo == "corazones" && color == "rojo")||(palo == "diamantes" && color == "rojo")){
                for (String valor : valores) {
                    cards.add(new Card(palo, color, valor));
                    }
                }
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        Card card = cards.remove(0);
        System.out.println(card.toString());
        System.out.println("Quedan " + cards.size() + " cartas en deck");
    }

    public void pick() {
        int index = (int) (Math.random() * cards.size());
        Card card = cards.remove(index);
        System.out.println(card.toString());
        System.out.println("Quedan " + cards.size() + " cartas en deck");
    }

    public void hand() {
        System.out.println("Mano de 5 cartas:");

        for (int i = 0; i < 5; i++) {
            Card card = cards.remove(0);
            System.out.println(card.toString());
        }

        System.out.println("Quedan " + cards.size() + " cartas en deck");
    }
}
public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        System.out.println("\nObteniendo la primera carta:");
        deck.head();

        System.out.println("\nSeleccionando una carta al azar:");
        deck.pick();

        System.out.println("\nObteniendo una mano de 5 cartas:");
        deck.hand();
    }
}
