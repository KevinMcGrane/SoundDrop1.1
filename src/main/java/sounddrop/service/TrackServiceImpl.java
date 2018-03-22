package sounddrop.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import sounddrop.model.Genre;
import sounddrop.model.Playlist;
import sounddrop.model.PostText;
import sounddrop.model.Track;
import sounddrop.model.User;
import sounddrop.repository.TrackRepository;
import sounddrop.repository.UserRepository;

@Service
public class TrackServiceImpl implements TrackService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TrackRepository trackRepository;

	@Override
	public void save(String trackName, String name, String artist, String fileName, Genre genre) {
		Track newTrack = new Track();
		User user = userRepository.findByUsername(name);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		newTrack.setTrackName(trackName);
		newTrack.setFileName(fileName);
		newTrack.setArtist(artist);
		newTrack.setPublishTime(timestamp);
		newTrack.setUser(user);
		newTrack.setGenre(genre);
		trackRepository.save(newTrack);
	}
	
	
	@Override
	public List<Track> getAllTrack() {
		List<Track> trackList = trackRepository.findAll();

		return trackList;
	}

	@Override
	public List<Track> getTrackFeed(Set<User> friends, User user) {
		List<Track> trackList = trackRepository.findByUserIn(friends);
		List<Track> myTracks = trackRepository.findByUser(user);
		List<Track> newList = new ArrayList<Track>();
    	newList.addAll(trackList);
    	newList.addAll(myTracks);
    	class OutcomeAscComparator implements Comparator<Track>
	    {
	        public int compare(Track left, Track right) {
	            return right.getPublishTime().compareTo(left.getPublishTime());
	        }
	    }
    	Collections.sort(newList, new OutcomeAscComparator());

		return newList;
	}

	@Override
	public void delete(Track track) {
		trackRepository.delete(track);
	}

	@Override
	public Track findByTrackId(long id) {
		return trackRepository.findById(id);
	}
	
	@Override
	public void addTrackToPlaylist(Track track, Playlist pl) {
		
	}


	@Override
	public void update(long id) {
		
			Track track = findByTrackId(id);
			track.setComments(track.getComments());
			trackRepository.save(track);

		
	}
	
	@Override
	public List<Track> recommend(long userId) throws TasteException
	{
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setURL("jdbc:mysql://localhost:3306/accounts?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setDatabaseName("accounts");
		
		DataModel model = new MySQLJDBCDataModel(dataSource, "taste_preferences", "user_id",
			    "item_id", "preference", null);
		
		UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
		
		UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
		
		UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
		int i = 1;
		List<RecommendedItem> recommendations = recommender.recommend(userId, 3);
		List<Track> recommendedTracks = new ArrayList<Track>();
		for (RecommendedItem recommendation : recommendations) {
			
		  System.out.println(i + ". Recommend: " + findByTrackId(recommendation.getItemID()).getTrackName() + " - value: " + recommendation.getValue());
		  recommendedTracks.add(findByTrackId(recommendation.getItemID()));
		  i++;
		}

		return recommendedTracks;
	}
	
	@Override
	public List<Track> findByUser(User user){
		return trackRepository.findByUser(user);
	}

}
