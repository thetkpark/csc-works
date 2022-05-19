import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Album> albums = new ArrayList<>();
        albums.add(SampleData.aLoveSupreme);
        albums.add(SampleData.manyTrackAlbum);
        albums.add(SampleData.sampleShortAlbum);

        // Using Stream API
        System.out.println("----Stream API----");
        Set<String> longTracName = findLongTracks(albums.stream());
        printFromListString(longTracName);

        System.out.println();
        longTracName = findLongTracks(SampleData.albums);
        printFromListString(longTracName);

        // Using the original code
        System.out.println("\n----Traditional----");
        longTracName = findLongTracks(albums);
        printFromListString(longTracName);
    }

    public static void printFromListString(Set<String> l) {
        for(String str : l) System.out.println(str);
    }

    public static Set<String> findLongTracks(Stream<Album> albums) {
        return albums.
                flatMap(Album::getTracks)
                .filter(track -> track.getLength() > 60)
                .map(Track::getName)
                .collect(Collectors.toSet());
    }

    public static Set<String> findLongTracks(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        for(Album album : albums) {
            for (Track track : album.getTrackList()) {
                if (track.getLength() > 60) {
                    String name = track.getName();
                    trackNames.add(name);
                }
            }
        }
        return trackNames;
    }
}
