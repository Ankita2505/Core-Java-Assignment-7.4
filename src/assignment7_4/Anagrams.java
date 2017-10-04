package assignment7_4;
/*
 * program that finds all anagram sets from a list of words
 */
import java.util.*;//importing utility packages

public class Anagrams
{ 
	static class Word // class for each word of duplicate array
	{
		String str; // to store word itself
		int index; // index of the word in the original array

		Word(String str, int index)// Word parameterized constructor
		{
			this.str = str;
			this.index = index;
		}
	}
	
	static class DuplicateArray// class to represent duplicate array.
	{
		Word[] array; // Array of words
		int size; // Size of array
		
		public DuplicateArray(String str[], int size) // DuplicateArray parameterized constructor
		{
			this.size = size;
			array = new Word[size];

			// One by one copy words from the given wordArray to duplicateArray			
			int i;
			for (i = 0; i < size; ++i)
			{
				// create a word Object with the str[i] as str and index as i
				array[i] = new Word(str[i], i);
			}
		} 
	}

	// Compare two words. Used in Arrays.sort() for sorting an array of words
	
	static class compStr implements Comparator<Word>
	{
		public int compare(Word a, Word b)
		{
			return a.str.compareTo(b.str);
		}
	}

	// Given a list of words in wordArr[],
	static void printAnagramsTogether(String wordArr[],int size)
	{
		//Create a copy of all words present in given wordArr. The copy will also have original indexes of words
				
		DuplicateArray dupArray = new DuplicateArray(wordArr, size);

		//Iterate through all words in dupArray and sort individual words.
		
		int i;
		for (i = 0; i < size; ++i)
		{
			char[] char_arr = dupArray.array[i].str.toCharArray();
			Arrays.sort(char_arr);
			dupArray.array[i].str = new String(char_arr);
		}

		//sort the array of words in dupArray
		Arrays.sort(dupArray.array, new compStr());

		for (i = 0; i < size; ++i)
			System.out.print(wordArr[dupArray.array[i].index]+" ");
	}

	public static void main(String args[])//Start of Main Class
	{
		String wordArr[] = {"listen","pot","part","opt","trap","silent","top","this","hello","hits","what","shit"};
		int size = wordArr.length;
		printAnagramsTogether(wordArr, size);
	}//Close of Main Class
}


