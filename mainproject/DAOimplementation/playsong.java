package DAOimplementation;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;

public class playsong {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        new playsong().readAudio("C:\\NIIT PGP in SE\\Jukebox_Final_Project_Java\\src\\main\\resources\\a_song.wav",1);
    }


    public  void readAudio(String audioSrcFile, int count) {
        playaudio playAudio = new playaudio();
        int c = 0;
        count = count-1;
        try {
            playAudio.playAudio1(audioSrcFile,count);

            playAudio.play();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Pause");
                System.out.println("2. Resume");
                System.out.println("3. Restart");
                System.out.println("4. Stop");

                if (c == 4) {
                    break;
                }

                if (scanner.hasNextInt()) {
                    c = scanner.nextInt();
                } else {
                    break;
                }
                switch (c) {
                    case 1:
                        playAudio.pause();
                        break;
                    case 2:
                        playAudio.resumeAudio();
                        break;
                    case 3:
                        playAudio.restart();
                        break;
                    case 4:
                        playAudio.stop();
                        break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Error with playing sound." + ex);
        }
    }
}
