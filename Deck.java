/*
Matthew Asis
CS 110
JAVA
*/

import java.util.*;

public class Deck 
{
   public static final int DECK_SIZE = 52;
   ArrayList<Card> cardPile = new ArrayList<Card>();
   ArrayList<Card> playerDeck = new ArrayList<Card>();
   ArrayList<Card> compDeck = new ArrayList<Card>();
   
   public Deck() 
   {  
      build();
   }
   
   public void build() 
   { 
      
      for (int q = 2; q <= 14; q++) 
      { 
         Card toDeckS = new Card("Spades", q);
         Card toDeckC = new Card("Clubs", q);
         Card toDeckH = new Card("Hearts", q);
         Card toDeckD = new Card("Diamonds", q);
         cardPile.add(toDeckS);
         cardPile.add(toDeckC);
         cardPile.add(toDeckH);
         cardPile.add(toDeckD);
      }
      shuffleDeck();
   }
   
   public void addToBottom(Card cardWon) 
   {       
      cardPile.add(cardWon);
   }
   
   public void shuffleDeck() 
   {       
      Random rand = new Random();
      for (int i = 0; i <= 51; i++) 
      { 
         Card c = cardPile.get(w);
         int position = rand.nextInt(DECK_SIZE);
         cardPile.set(position, c);
      }
   }
   
   public Card drawFromTop() 
   { 
      Card drawn = cardPile.get(0);
      cardPile.remove(0);
      return drawn;
   }
   
   public void emptyDeck() 
   { 
      for ( int j = 0; j <= 51; j++ ) 
      {
         cardPile.remove(j);
      }
   }
   
   public boolean deckNotEmpty() 
   {
      if (cardPile.get(0) != null) 
      { 
         return true;
      }
      else
      {
         return false;
      }
   }
      
      
}