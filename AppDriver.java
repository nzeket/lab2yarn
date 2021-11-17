package com.opstty;

import com.opstty.job.*;
import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that counts the words in the input files.");
            programDriver.addClass("districtcount", DistrictCount.class,
                    " This class counts the district containing trees");
            programDriver.addClass("difspecies", DifSpecies.class,
                    " This class displays the list of different species of trees in the file");
            programDriver.addClass("difspeciescount", DifSpeciesCount.class,
                    " This class count the different species of trees in the file");
            programDriver.addClass("maxheight", MaxHeight.class,
                    " This class calculates the tree with the highest height per specie");
            programDriver.addClass("sortheight", MaxHeight.class,
                    " This class sorts the trees by height");
            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}

