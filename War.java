/*
Matthew Asis
CS 110
JAVA
*/

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class War
{
   public static void Deal() 
   {
      /*
         Creating the deck, player deck,
         and computer deck object
         
         Splitting the deck into two, to divide
         the cards      
      */
      Deck newDeck = new Deck();
      newDeck.shuffleDeck(); 
      Deck playerDeck = new Deck();
      Deck compDeck = new Deck();
    
      playerDeck.emptyDeck(); 
      compDeck.emptyDeck();
   
      for (int i = 1; i <= 25; i++) 
      { 
         playerDeck.addToBottom(newDeck.drawFromTop());
      }
   
      for (int j = 26; j <= 52; j++) 
      {
         compDeck.addToBottom(newDeck.drawFromTop());       
      }
      
      playTheGame(playerDeck, compDeck);  
   }
   
   public static void playGame(Deck player, Deck comp)
   { //define play method, recieve both players decks
      
      while (player.deckNotEmpty() && comp.deckNotEmpty()) 
      { 
         // While there are still cards in either player the game continues    
         Card playerDrawn = player.drawFromTop();
         Card compDrawn = comp.drawFromTop();
         
         // Compare ranks
         if (playerDrawn.getRank() > compDrawn.getRank())
         { 
            player.addToBottom(playerDrawn);
            player.addToBottom(compDrawn);
         }
         
         if (compDrawn.getRank() > playerDrawn.getRank()) 
         {
            comp.addToBottom(playerDrawn);
            player.addToBottom(compDrawn);
         }
         
         // In the event of a war
         if (playerDrawn.getRank() == compDrawn.getRank()) 
         { 
         
            //Creating the small deck in the event of the war
            ArrayList<Card> deckPile = new ArrayList<Card>();
            deckPile.add(playerDrawn);
            deckPile.add(compDrawn); 
            int deckCount = 2; 
            
            while ( playerDrawn == compDrawn ) 
            {            
               Card playerDrawn2 = player.drawFromTop(); 
               Card compDrawn2 = comp.drawFromTop();
               deckPile.add(playerDrawn2);
               deckPile.add(compDrawn2);
               deckCount = deckCount + 2;
               
               playerDrawn = player.drawFromTop();
               compDrawn = comp.drawFromTop();
               
               if ( playerDrawn.getRank() > compDrawn.getRank()) 
               { 
                  for ( int o = 1; o <= deckCount; o++ ) 
                  {
                     player.addToBottom( deckPile.get(o));
                  }
               }
               //If the computer wins they get a card
               if (compDrawn.getRank() > playerDrawn.getRank())
               {
                  for ( int o = 1; o <= deckCount; o++ ) 
                  {
                     comp.addToBottom( deckPile.get(o));
                  }
               }
            }
         }
      
            if (player.deckNotEmpty()) 
            {
            //Player wins
            }
            if (comp.deckNotEmpty()) 
            {
            //Computer wins
            } 
      }
      
   }
}