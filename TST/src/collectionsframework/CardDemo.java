package collectionsframework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *扑克牌
 */
class Card{
    public String suit;//花色
    public int rank;//牌面值
    public Card(String suit,int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("[%s %d]", suit, rank);
    }
}
public class CardDemo {
    public static final String[] suits = {"♥","♦","♣","♠"};
    private List<Card> buyPuck(){
        List<Card> deck = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 13; j++) {
                String suit = suits[i];
                int rank = j;
                Card card = new Card(suit,rank);
                deck.add(card);
            }
        }
        return deck;
    }

    private void swap(List<Card> deck,int start,int end) {
        Card tmp = deck.get(start);
        deck.set(start,deck.get(end));
        deck.set(end,tmp);
    }
    //洗牌
    public void shuffle(List<Card> deck) {
        Random random = new Random();
        for (int i = deck.size() - 1; i > 0; i--) {
            int index = random.nextInt(i);
            swap(deck,i,index);
        }
    }
    public static void main(String[] args) {
        CardDemo cardDemo = new CardDemo();
        List<Card> list = cardDemo.buyPuck();
        System.out.println(list);
        cardDemo.shuffle(list);
        System.out.println("洗牌：");
        System.out.println(list);
        System.out.println("发牌：");

        List<List<Card>> hands = new ArrayList<>();


        List<Card> human1 = new ArrayList<>();
        List<Card> human2 = new ArrayList<>();
        List<Card> human3 = new ArrayList<>();

        hands.add(human1);
        hands.add(human2);
        hands.add(human3);
        //三个人抓五张牌
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                hands.get(i).add(list.remove(0));
            }
        }
        System.out.println("第一个人的牌");
        System.out.println(human1);
        System.out.println("第二个人的牌");
        System.out.println(human2);
        System.out.println("第三个人的牌");
        System.out.println(human3);
        System.out.println("剩余的牌");
        System.out.println(list);
    }
}
