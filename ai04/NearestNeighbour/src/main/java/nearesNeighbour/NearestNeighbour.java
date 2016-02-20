package nearesNeighbour;

import java.util.List;

public class NearestNeighbour {

    private final List<Image> trainigSet;
    private final List<Image> testSet;

    public NearestNeighbour(List<Image> images) {
        trainigSet = images.subList(0, 5000);
        testSet = images.subList(5000, images.size());
    }
    
    public int label(Image image) {
        Image closest = trainigSet.get(0);
        int smallestDistance = Integer.MAX_VALUE;
        for (Image i : trainigSet) {
            int dist = i.distanceTo(image);
            if (dist <= smallestDistance) {
                smallestDistance = dist;
                closest = i;
            }
        }
        return closest.characterClass;
    }

    public double testClassifier() {
        int success = 0;
        for (Image i : testSet) {
            int label = label(i);
            if (label == i.characterClass) {
                success++;
            }
        }
        return success / (double) testSet.size();
    }

    public double testClassifierWith(int a, int b) {
        int success = 0;
        int testCases = 0;
        for (Image i : testSet) {
            if (i.characterClass != a && i.characterClass != b) continue;
            testCases++;
            int label = label(i);
            if (label == i.characterClass) {
                success++;
            }
        }
        return success / (double) testCases;
    }
}
