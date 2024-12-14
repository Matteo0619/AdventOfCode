package adventofcode.y2024.day14;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2024/day14/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;
        List<Robot> robots = new ArrayList<>();

        while ((line = buffer.readLine()) != null) {
            line = line.replace("p=", "").replace("v=", "");
            String[] arr = line.split(" ");
            int x = Integer.parseInt(arr[0].split(",")[0]);
            int y = Integer.parseInt(arr[0].split(",")[1]);
            int vx = Integer.parseInt(arr[1].split(",")[0]);
            int vy = Integer.parseInt(arr[1].split(",")[1]);

            robots.add(new Robot(x, y, vx, vy));
        }


        int height = 102;
        int width = 100;

        for(int i=0; i<10000; i++) {
            List<List<String>> mat = new ArrayList<>();
            for(int j=0; j<=height;  j++) {
                List<String> list = new ArrayList<>();
                for(int k=0; k<=width; k++) {
                    list.add(".");
                }
                mat.add(list);
            }
            for(Robot robot : robots) {
                int x = robot.getX();
                int y = robot.getY();
                int vx = robot.getVx();
                int vy = robot.getVy();

                if(vx >= 0) {
                    if(x + vx <= width) {
                        robot.setX(x+vx);
                    } else {
                        robot.setX((x+vx)-width-1);
                    }
                } else {
                    if(x + vx >= 0) {
                        robot.setX(x+vx);
                    } else {
                        robot.setX(width+(x+vx)+1);
                    }
                }

                if(vy >= 0) {
                    if(y + vy <= height) {
                        robot.setY(y+vy);
                    } else {
                        robot.setY((y+vy)-height-1);
                    }
                } else {
                    if(y + vy >= 0) {
                        robot.setY(y+vy);
                    } else {
                        robot.setY(height+(y+vy)+1);
                    }
                }

                mat.get(y).set(x, "O");

            }
            if(i == 8280) {
                System.out.println("INDEX : " + i);
                createImage(mat, i);
            }

        }


    }

    private static void createImage(List<List<String>> mat, int i) throws IOException {
        String directoryPath = "output_images"; // Cambia con il percorso desiderato
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdir(); // Crea la directory se non esiste
        }

        // Impostazioni immagine
        int cellSize = 40; // Nuova dimensione della cella (più grande)
        int imageWidth = 100 * cellSize; // Larghezza immagine
        int imageHeight = 102 * cellSize;; // Altezza immagine (ogni cella ha altezza 20px)
        BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Sfondo bianco
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, imageWidth, imageHeight);

        // Impostiamo il font (puoi scegliere un font più grande per una maggiore definizione)
        g2d.setFont(new Font("Courier New", Font.PLAIN, 28)); // Aumentato il font per una maggiore risoluzione

        // Disegniamo il testo della matrice nell'immagine
        for (int y = 0; y <= 102; y++) {
            for (int x = 0; x <= 100; x++) {
                String cell = mat.get(y).get(x);

                // Impostiamo il colore in base al carattere
                if (cell.equals("O")) {
                    g2d.setColor(Color.RED); // Colore rosso per il carattere "#"
                } else {
                    g2d.setColor(Color.BLACK); // Colore nero per il carattere "."
                }

                // Disegniamo il carattere nell'immagine
                g2d.drawString(cell, x * cellSize + 10, y * cellSize + 30); // Posizione dei caratteri
            }
        }

        // Salva l'immagine
        String fileName = "image_" + (i) + ".png"; // Usa 'i' per creare il nome del file dinamico

        // Salva l'immagine con il nome dinamico
        File outputfile = new File(directoryPath + "/" + fileName);
        ImageIO.write(image, "PNG", outputfile);
        g2d.dispose(); // Rilascia le risorse grafiche
    }

}
