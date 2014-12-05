import java.util.*;

public class Card 
{
   public String suit, rankName;
   public int rank;
   
   //Card Constructor
   public Card( String st, int rk) 
   { 
      suit = st; 
      rank = rk;
   }

   //returns suit
   public String getSuit() 
   { 
      return suit;
   }
   
   //returns rank
   public int getRank() 
   {  
      return rank;
   }

   //toString Method
   public String toString() 
   { 
      if (rank == 11) 
      {
         rankName = "Jack";
      }
      if (rank == 12) 
      {
         rankName = "Queen";
      }
      if (rank == 13) 
      {
         rankName = "King";
      }
      if (rank == 14) 
      {
         rankName = "Ace";
      }
      else 
      {
         rankName = Integer.toString(rank);
      }
      
      return rankName + " of " + suit;
   }
   
   //Equals method
   //Returns true or false
   public boolean equalTo(Card c) 
   { 
      if (rank == c.getRank() && suit == c.getSuit()) 
         return true;
      else
         return false;
   }
}