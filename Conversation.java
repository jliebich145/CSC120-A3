import java.util.Scanner;

class Conversation {

  /**
   * 
   * @param arguments
   */
  public static void main(String[] arguments) {
    
    int rounds = 0;
    String response = "";
    String answer = "";
    boolean mirror = false;
    String[] cannedResponses = {"Mmm-hm", "That's cool", "Wow", "Fascinating", "What else?", "Tell me more", "Interesting", "Huh"};
    String[] mirrorInput = {"I", "you", "I'm", "me", "am", "my", "your", "i"};
    String[] mirrorOutput = {"you", "I", "you're", "you", "are", "your", "my", "you"};

    Scanner input = new Scanner(System.in);

    //Get number of rounds from user
    System.out.println("How many rounds: ");
    rounds = input.nextInt();
    String[] transcript = new String[2*rounds + 2];

    //Greeting
    System.out.println("\nHi there!  What's on your mind?");
    transcript[0] = "Hi there! What's on your mind?";
    input.nextLine(); // clear buffer

    //Loop for conversation rounds
    for(int i = 0; i < rounds; i++){
      response = input.nextLine();
      String[] words = response.split(" ");
      // Check for mirror words
      for (int j = 0; j < words.length; j++){
        for (int k = 0; k < mirrorInput.length; k++){
          if (words[j].equals(mirrorInput[k])){
            words[j] = mirrorOutput[k];
            mirror = true;
            break;
          }
        }
      }
      // Respond
      if (mirror==true){
        answer = String.join(" ", words);
        if (response.endsWith(".")){
          answer = answer.replace(".", "?");
        } else{
          answer = answer.concat("?");
        }
        System.out.println(answer);
        transcript[2*i + 2] = answer;
      } else {
        int randIndex = (int)(Math.random() * 8);
        String cannedResponse = cannedResponses[randIndex];
        System.out.println(cannedResponse);
        transcript[2*i + 2] = cannedResponse;
      }
      
      transcript[2*i + 1] = response;

      mirror = false;
    }
    // End Conversation
    System.out.println("See ya!");
    transcript[2*rounds + 1] = "See ya!";

    //Print Transcript
    System.out.println("\nTRANSCRIPT:");
    for (int i = 0; i < transcript.length; i++){
      System.out.println(transcript[i]);
    }
  }
}
