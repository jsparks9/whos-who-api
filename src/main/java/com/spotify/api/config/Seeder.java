package com.spotify.api.config;

import com.spotify.api.entitites.*;
import com.spotify.api.repositories.AttemptRepository;
import com.spotify.api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
//@org.springframework.context.annotation.Profile("local || test")
public class Seeder implements CommandLineRunner {
    private final UserRepository userRepo;
    private final AttemptRepository attemptRepo;
    private static final Random random = new Random();


    private User createUser(String username, String password, String email, String fName) {
        final String difficulty = "Easy";
        final boolean showHints = true;
        Credentials creds = new Credentials();
        creds.setUsername(username);
        creds.setPassword(password);
        Profile profile = new Profile();
        profile.setEmail(email);
        profile.setFirstName(fName);
        Settings settings = new Settings();
        settings.setDifficulty(difficulty);
        settings.setHints(showHints);
        User user = new User();
        user.setProfile(profile);
        user.setCredentials(creds);
        user.setSettings(settings);
        return userRepo.saveAndFlush(user);
    }

    @Override
    public void run(String... args) throws Exception {
        final List<String> names = Arrays.asList(
                "Amber", "Charles", "Hugh", "Jay", "Katie", "Lester", "Linda",
                "Marjorie", "Rebekah", "Thomas", "Wanda", "William"
        );
        final int totalAttempts = 500;
        final int totalUsers = 15;
        User user0 = createUser("test", "tester", "testing@gmail.com", "Test");
        List<User> users = new ArrayList<>(List.of(user0));
        for (int i = 0; i < totalUsers; i++)
            users.add(createUser(
                    "test"+i,
                    "tester",
                    "testing" + i + "@gmail.com",
                    names.get(random.nextInt(names.size())))
            );
        users = userRepo.saveAllAndFlush(users);

        List<Integer> scoreOptions = new ArrayList<>(Arrays.asList(5, 10, 15));
        List<Attempt> attempts = new ArrayList<>(15);
        for (int i = 0; i < totalAttempts; i++) {
            Attempt attempt = new Attempt();
            attempt.setUser(users.get(random.nextInt(users.size())));
            attempt.setScore(scoreOptions.get(random.nextInt(scoreOptions.size())));
            attempt.setAlbumCover("https://i.scdn.co/image/ab67616d00004851e6710ca8d1b1532efda0899e");
            attempt.setAlbumName("Album Name");
            attempt.setArtistName("Artist Name");
            attempts.add(attempt);
        }
        attemptRepo.saveAllAndFlush(attempts);
    }
}
