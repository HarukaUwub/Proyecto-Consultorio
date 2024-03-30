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
                if ((palo.equals("tréboles") && color.equals("negro")) || (palo.equals("spades") && color.equals("negro")) || (palo.equals("corazones") && color.equals("rojo")) || (palo.equals("diamantes") && color.equals("rojo"))) {
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
        if (cards.isEmpty()) {
            System.out.println("El mazo está vacío.");
            return;
        }
        Card card = cards.remove(0);
        System.out.println(card.toString());
        System.out.println("Quedan " + cards.size() + " cartas en el mazo");
    }

    public void pick() {
        if (cards.isEmpty()) {
            System.out.println("El mazo está vacío.");
            return;
        }
        int index = (int) (Math.random() * cards.size());
        Card card = cards.remove(index);
        System.out.println(card.toString());
        System.out.println("Quedan " + cards.size() + " cartas en el mazo");
    }

    public void hand() {
        if (cards.size() < 5) {
            System.out.println("No hay suficientes cartas en el mazo para generar una mano de 5 cartas.");
            return;
        }

        System.out.println("Mano de 5 cartas:");
        for (int i = 0; i < 5; i++) {
            Card card = cards.remove(0);
            System.out.println(card.toString());
        }
        System.out.println("Quedan " + cards.size() + " cartas en el mazo");
    }
}

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            option = showMenu(scanner);
            switch (option) {
                case 1:
                    deck.shuffle();
                    break;
                case 2:
                    deck.head();
                    break;
                case 3:
                    deck.pick();
                    break;
                case 4:
                    deck.hand();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (option != 0);

        scanner.close();
    }

    public static int showMenu(Scanner scanner) {
        System.out.println("\nBienvenido a Poker!");
        System.out.println("Selecciona una opción:");
        System.out.println("1 Mezclar deck");
        System.out.println("2 Sacar una carta");
        System.out.println("3 Carta al azar");
        System.out.println("4 Generar una mano de 5 cartas");
        System.out.println("0 Salir");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }
}
