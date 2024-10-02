import java.util.Random;
import java.util.*;

class HelloWorld {
    public static void main(String[] args) {
        //create a randomized int[] array
        int[] array = createArr();
        
        System.out.println();
        
        // Print the rules
        System.out.println("This game is like the bottle match challenge on TikTok. \nExcept, we're matching numbers!\nThere are 5 numbers in a box, ranging from 1-5. \nYou will guess the numbers inside the box, \nand the numbers inside cannot be repeated.\nIf you want to end the game, just type \"end\" in the next prompt. \nAre you ready to guess?\n\nPlease enter your guesses, separated by commas, no spaces. \n(Example:  1,2,3,4,5)");
        
        // get input/guess from user
        Scanner sc = new Scanner(System.in);
        int correctGuesses = 0;
        
        // repeat prompt until users get all correctly
        while (correctGuesses < 5) {
            System.out.print("\nEnter your guesses: ");
            String rawInp = sc.nextLine();
            
            if (rawInp.equals("end")){
                System.out.print("\nCorrect Answer: ");
                printArr(array);
                System.out.println("\nThanks for playing!");
                break;
            }else{
                String[] guess = rawInp.split(",");
                int[] transGuess = new int[guess.length];
                
                for (int i = 0; i < guess.length; i++) {
                    transGuess[i] = Integer.parseInt(guess[i].trim());
                }
                
                // display the user's guess
                System.out.print("Your guesses: [");
                for (int x = 0; x < guess.length; x++) {
                    System.out.print(guess[x]);
                    
                    if (x < guess.length - 1) {
                        System.out.print(", ");    
                    }
                }
                System.out.print("]");
                
                // check the answers
                correctGuesses = check(transGuess, array);
                System.out.println("\nCorrect guesses: " + correctGuesses);
                
                if (correctGuesses == 5) {
                    System.out.println("\nCongratulations! You guessed all the numbers correctly!");
                } else if(correctGuesses == 1) {
                     System.out.println("\nHey! At least you got 1!");
                } else if(correctGuesses == 2) {
                     System.out.println("\nGood job! You got 2!");
                } else if(correctGuesses == 3) {
                     System.out.println("\nOh! Getting closer!");
                } else if(correctGuesses == 4) {
                     System.out.println("\nOne more to go!");
                } else {
                     System.out.println("\nNot quite! Try again!");
                }
            }
        }
    }
    
    public static int check(int[] transGuess, int[] array) {
        int correct = 0;
        for (int y = 0; y < transGuess.length; y++) {
            if (transGuess[y] == array[y]) {
                correct++;
            }
        }
        return correct;
    }
   
    public static int[] createArr() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        int[] array = list.stream().mapToInt(i -> i).toArray();
        return array;
    }
    
    public static void printArr(int[] arr) {
        System.out.print("[");
        for (int x = 0; x < arr.length; x++) {
            System.out.print(arr[x]);
            if (x < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
