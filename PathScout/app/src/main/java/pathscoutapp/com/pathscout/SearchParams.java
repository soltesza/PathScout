package pathscoutapp.com.pathscout;

/**
 * Created by Andrew on 9/20/2017.
 */

public class SearchParams {
    public enum Activity {
        WALK,
        RUN,
        BIKE
    }

    public int minDifficulty, maxDifficulty, minDistance, maxDistance;
    public Activity activity;

    public SearchParams(Activity activity, int minDifficulty, int maxDifficulty, int minDistance, int maxDistance) {
        this.activity = activity;
        this.minDifficulty = minDifficulty;
        this.maxDifficulty = maxDifficulty;
        this.minDistance = minDistance;
        this.maxDistance = maxDistance;
    }
}
