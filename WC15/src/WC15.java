
/**
 * WC15 - This is a review of all kinds of concepts.
 * Only use AP official subset methods for ArrayLists, Strings, 1D arrays, etc.
 * These methods focus on various arrays, loops, and whatever else I think
 * you need practice on.
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;

public class WC15
{
  /**
   * 
   * Given a string of odd length, return the string length 3 from its middle,
   * so "Candy" yields "and".
   * 
   * <pre>
   * The string length will be at least 3.
   * 
   * middleThree("Candy") -> "and" 
   * middleThree("and") -> "and"
   * middleThree("solving") -> "lvi"
   * </pre>
   * 
   * @param letters
   * @return
   */
  public static String centralThree(String letters)
  {
    return letters.substring(letters.length() / 2 - 1,
        letters.length() / 2 + 2);
  }

  /**
   * Given a string, return a version without the first 2 chars. Except keep the
   * first char if it is 'a' and keep the second char if it is 'b'. The string
   * may be any length. Harder than it looks.
   * 
   * <pre>
   * PRECONDITION: str will be lowercase and length will be at least two
   * deFront("Hello") -> "llo" 
   * deFront("java") -> "va" 
   * deFront("away") -> "aay"
   * </pre>
   * 
   * @param str
   * @return
   */
  public static String chopFront(String str)
  {
    String answer = "";
    // If the 1st character is a, add it in
    if (str.substring(0, 1).equals("a"))
    {
      answer += "a";
      // if the 1st char isn't a, it won't do anything, which effectively
      // removes the character from answer
    }
    // same thing for the 2nd char
    if (str.substring(1, 2).equals("b"))
    {
      answer += "b";
    }
    // then just paste in the rest
    answer += str.substring(2);
    return answer;
  }

  /**
   * 
   * Given a string, if one or both of the first 2 chars is 'x', return the
   * string without those 'x' chars, and otherwise return the string unchanged.
   * This is a little harder than it looks.
   * 
   * <pre>
   * withoutX2("xHi") -> "Hi" 
   * withoutX2("Hxi") -> "Hi" 
   * withoutX2("Hi") -> "Hi"
   * </pre>
   * 
   * @param str
   * @return
   */
  public static String hateX(String str)
  {
    String answer = "";
    // this is the same as chopFront but inverted, it only adds them in if they
    // aren't the target character
    if (!str.substring(0, 1).equals("x"))
    {
      answer += str.substring(0, 1);
    }
    if (!str.substring(1, 2).equals("x"))
    {
      answer += str.substring(1, 2);
    }
    answer += str.substring(2);
    return answer;
  }

  /**
   * Swaps all values in the specified 2 rows of mat.
   * 
   * @param mat
   *          the array
   * @param rowAIndex
   *          the index of a row to be swapped
   * @param rowBIndex
   *          the index of a row to be swapped
   */
  public static void swapRows(int[][] mat, int rowAIndex, int rowBIndex)
  {
    int[] temp = mat[rowAIndex];
    mat[rowAIndex] = mat[rowBIndex];
    mat[rowBIndex] = temp;
  }

  /**
   * Swaps all values in the specified 2 columns of mat.
   * 
   * @param mat
   *          the array
   * @param colAIndex
   *          the index of a column to be swapped
   * @param colBIndex
   *          the index of a column to be swapped
   */
  public static void swapColumns(int[][] mat, int colAIndex, int colBIndex)
  {
    int[] temp = new int[mat[0].length];
    // since columns aren't actually arrays, but indexes of 1D arrays, we have
    // to make a loop to find all the items at that index (or column) for each
    // of the arrays
    for (int i = 0; i < mat.length; i++)
    {
      temp[i] = mat[i][colAIndex];
    }
    // otherwise it's the same principle as swapRows
    for (int i = 0; i < mat.length; i++)
    {
      mat[i][colAIndex] = mat[i][colBIndex];
    }
    for (int i = 0; i < mat.length; i++)
    {
      mat[i][colBIndex] = temp[i];
    }
  }

  /**
   * Returns an array with the specified number of rows and columns containing
   * the characters from str in row-major order. If str.length() is greater than
   * rows * cols, extra characters are ignored. If str.length() is less than
   * rows * cols, the remaining elements in the returned array contain null.
   * 
   * @param str
   *          the string to be placed in an array
   * @param rows
   *          the number of rows in the array to be returned
   * @param cols
   *          the number of columns in the array to be returned
   * @return an array containing the characters from str in row-major order
   */
  public static String[][] fill2DWithLetters(String str, int rows, int cols)
  {
    String[][] answer = new String[rows][cols];
    int index = 0;
    if (str.length() > rows * cols)
    {
      // paste in characters from str until you run out of answer space
      for (int r = 0; r < rows && index < str.length(); r++)
      {
        for (int c = 0; c < cols && index < str.length(); c++)
        {
          answer[r][c] = str.substring(index, index + 1);
          index++;
        }
      }
    }
    else
    {
      // paste in characters from str until you run out of str space
      for (int r = 0; r < rows && index < str.length(); r++)
      {
        for (int c = 0; c < cols && index < str.length(); c++)
        {
          answer[r][c] = str.substring(index, index + 1);
          index++;
        }
      }
    }
    return answer;
  }

  /**
   * Returns an array with the specified number of rows and columns that
   * contains the elements of vals in the order specified below. Elements from
   * vals are placed in the array by moving down the first column, up the second
   * column and so on.
   * 
   * <pre>
   * For example, if vals was:
   * {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}
   * 
   * rows was 3 and cols was 4,
   * the returned array would be:
   * { {1, 6, 7, 12},
   *   {2, 5, 8, 11},
   *   {3, 4, 9, 10} }
   * 
   * Precondition: vals.length == rows * cols
   * </pre>
   * 
   * @param vals
   *          the elements
   * @param rows
   *          the number of rows in the array to be returned
   * @param cols
   *          the number of columns in the array to be returned
   * @return an array containing the elements from vals in the specified order
   */
  public static int[][] fillDownAndUp(int[] vals, int rows, int cols)
  {
    int[][] answer = new int[rows][cols];
    int index = 0; // this is to keep track of where we are in vals
    for (int c = 0; c < cols && index < vals.length; c++)
    {
      for (int r = 0; r < rows && index < vals.length; r++)
      {
        // go down
        answer[r][c] = vals[index];
        index++;
      }
      c++; // go on to the next column before going back up
      if (c < cols)
      {
        for (int r = rows - 1; r >= 0 && index < vals.length; r--)
        {
          // and back up
          answer[r][c] = vals[index];
          index++;
        }
      }
    }
    return answer;
  }

  /**
   * Returns a smaller array containing the elements in the specified range of
   * the mat.
   * 
   * For example,
   * 
   * <pre>
   * mat: { {10, 9, 8, 7}, 
   *        {6, 5, 4, 3}, 
   *        {2, 1, -1, 0} }
   * 
   * startRow: 0, startCol: 1, endRow: 1, endCol: 2
   * 
   * would yield: { {9, 8},
   *                {5, 4} }
   * </pre>
   * 
   * @param mat
   *          the 2D array containing the original elements
   * @param startRow
   *          the first row to be kept
   * @param startCol
   *          the first column to be kept
   * @param endRow
   *          the last row to be kept
   * @param endCol
   *          the last column to be kept
   * @return a smaller array containing the specified elements
   */
  public static int[][] crop2D(int[][] mat, int startRow, int startCol,
      int endRow, int endCol)
  {
    int[][] answer = new int[endRow - startRow + 1][endCol - startCol + 1];
    // go through the mat array as though it was a normal array, but use start
    // and end instead of 0 and mat.length
    int answerR = 0, answerC = 0;
    // we will need ^^ separate indexes for the smaller answer array
    // we wouldn't if it was an ArrayList
    for (int r = startRow; r <= endRow && answerR < answer.length; r++)
    {
      answerC = 0;
      for (int c = startCol; c <= endCol && answerC < answer[0].length; c++)
      {
        answer[answerR][answerC] = mat[r][c];
        answerC++;
      }
      answerR++;
    }
    return answer;
  }
}