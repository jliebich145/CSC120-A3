import java.util.Scanner;

class Conversation {

  public static void main(String[] arguments) {
    
    int rounds = 0;
    String response = "";
    String answer = "";
    boolean mirror = false;
    String[] cannedResponses = {"Mmm-hm", "That's cool", "Wow", "Fascinating", "What else?", "Tell me more", "Interesting", "Huh"};

    Scanner input = new Scanner(System.in);

    //Get number of rounds from user
    System.out.println("How many rounds: ");
    rounds = input.nextInt();
    String[] transcript = new String[2*rounds + 1];

    //Greeting
    System.out.println("\nHi there!  What's on your mind?");
    response = input.nextLine();
    transcript[0] = "Hi there! What's on your mind?";

    //Loop for conversation rounds
    for(int i = 0; i < rounds; i++){
      response = input.nextLine();
      answer = response;
      if (response.contains("I ")){
        answer = answer.replace("I", "you");
        mirror = true;
      }
      if (response.contains("you")){
        answer = answer.replace("you", "I");
        mirror = true;
      }
      if (response.contains("I'm")){
        answer = answer.replace("I'm", "you're");
        mirror = true;
      }
      if (response.contains("me")){
        answer = answer.replace("me", "you");
        mirror = true;
      }
      if (response.contains("am")){
        answer = answer.replace("am", "are");
        mirror = true;
      }
      if (response.contains("my")){
        answer = answer.replace("my", "your");
        mirror = true;
      }
      if (response.contains("your")){
        answer = answer.replace("your", "my");
        mirror = true;
      }
      // Ignoring mirroring phrases with I and you because the grammer doesn't work
      if (response.contains("I") & response.contains("you")){
        mirror = false;
      }
      if (mirror==true){
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
      
      transcript[2*i+1] = response;

      mirror = false;
    }

    System.out.println("\nTRANSCRIPT:");
    for (int i = 0; i < transcript.length; i++){
      System.out.println(transcript[i]);
    }
  }
}
