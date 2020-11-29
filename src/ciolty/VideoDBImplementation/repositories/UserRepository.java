package ciolty.VideoDBImplementation.repositories;

import ciolty.database.RepositoryAbstract;
import ciolty.database.ResourceManager;
import ciolty.VideoDBImplementation.entities.UserData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository extends RepositoryAbstract<UserData> {
    public UserRepository(final ResourceManager<UserData> resourceManager) {
        super(resourceManager);
    }

    public List<String> getAllFavorites() {
        ArrayList<String> allFavorites = new ArrayList<>();
        for (UserData userData : resourceManager.getAll()) {
            allFavorites.addAll(userData.getFavoriteMovies());
        }
        return allFavorites;
    }

    public Map<String, Integer> getAllHistory() {
        Map<String, Integer> allHistory = new HashMap<>();
        for (UserData userData : resourceManager.getAll()) {
            allHistory.putAll(userData.getHistory());
        }
        return allHistory;
    }
}
