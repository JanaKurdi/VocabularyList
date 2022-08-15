
/** ****************************************************************************
 *
 * CPCS202, 1st Term 2019 (Fall 2019-20)
 * Program 4:  Text Processing
 *
 *
 ****************************************************************************** */
//CPCS202
//7/12/2019

import java.lang.String;
import java.util.Scanner;

public class VocabularyList {

    public static String getText() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text (press enter to stop):");//prompt the user to enter a text
        String text = input.nextLine();
       return text;//return the text
    }

    public static int arraySize(String[] array) {
       int countWord =0;//initial length
        for (int i = 0; i <array.length; i++) {
            //loop body
            if (array[i]!=null)  
                countWord++;
            }
        return countWord;//return the actual number of elements on array
    }

     public static void BOWVocabulary(String[] words, String[] uniquewords, int[] frequency) {
        int frequencyCount=0;//count which empty index
       for (int i = 0; i < words.length; i++) {//check array words
            int indexOfFrequency=-1;
           for (int j = 0; j < arraySize(uniquewords); j++) {
               if (uniquewords[j].equalsIgnoreCase(words[i])) {
                  indexOfFrequency=j; 
                 break;
               }
           }
               if(indexOfFrequency==-1){//if the word not found 
                 uniquewords[frequencyCount]=words[i];
                 frequency[frequencyCount]++;
                 frequencyCount++;//go to the next empty index
               }else{//if the word found
                   frequency[indexOfFrequency]++;
               }
             }
            }
 
   
   
 public static int maxFrequency(int[] frequency) {
        double max = frequency[0];//initial max
        int Maxindex = 0;//initial index
        for (int i = 1; i < frequency.length; i++) {
            //loop body
            if (frequency[i] > max) {//if frequency in index i greater than intial max
                max = frequency[i];
                Maxindex = i;//index of max equal i
            }
        }

        return Maxindex;//return the index of the max frequency
    }

    public static void printStat(String[] words, String[] uniquewords, int[] frequency) {//method display the ending statistics
        int maxFrequencyIndex=maxFrequency(frequency);
        System.out.println(" ");
        System.out.println("*** Text Processing Results ***");
        System.out.println("Words count:" + arraySize(words));//display the actual length
        System.out.println("Vocabulary size:"+arraySize(uniquewords));
        System.out.println("Most frequent word: "+  uniquewords[maxFrequencyIndex]+ " with a term-frequency counter of " +  frequency[maxFrequencyIndex]);
        System.out.println("The Vocabulary (8 words per line):");//display the text 8 words per line
        final int TEXR_PER_LINE=8;
        for (int i=0;i<arraySize(uniquewords);i++){
         if((i+1)%TEXR_PER_LINE==0) {
        System.out.println(uniquewords[i] + " ");//print in the next lie
         } else{
           System.out.print(uniquewords[i] + " "); //print in the same line 
         }
        
       }
    }

    
public static void main(String[] args) {
	//invoke getText
	String text=getText();
	
	//loop until the user enter a valid text
	//String isEmpty() method returns true if the given string is empty, else it returns false.
	while (text == null || text.isEmpty())
	{ 
       System.out.print("You should enter a text. Please try again");
       //invoke getText
	   text=getText();
       }
    
	//split string into words  
    String[] words = text.split("\\s+");
    
     //get the actual array size
     int len = arraySize(words); 
     
	//array to save unique words
	String[] uniquewords = new String[len];
	
	//array to save frequency 
	int [] frequency = new int[len];
	
	//invoke BOWVocabulary method
	BOWVocabulary(words,uniquewords, frequency);
	
	//invoke printStat method
	printStat(words,uniquewords,frequency);
	
	
	}//end-main
 	
}//-end class
