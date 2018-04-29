package sounddrop.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;

import sounddrop.model.Genre;
import sounddrop.model.User;

@Service
public class AmazonClient {

    private AmazonS3 s3client;
    
    @Autowired
	private TrackService trackService;
    
    @Autowired
    private ProfilePicService picService;
    
    

    @Value("${aws.endpoint_url}")
    private String endpointUrl;
    @Value("${aws.track_bucket_name}")
    private String trackBucketName;
    @Value("${aws.pic_bucket_name}")
    private String picBucketName;
    @Value("${aws.access_key}")
    private String accessKey;
    @Value("${aws.secret_key}")
    private String secretKey;
    @Value("${aws.region}")
    private String region;
    @PostConstruct
    private void initializeAmazon() {
       AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
    //   this.s3client = new AmazonS3Client(credentials);
       s3client = AmazonS3ClientBuilder.standard().withRegion(Regions.fromName(region)).withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
}
    
    public String uploadFile(MultipartFile multipartFile, String trackName, String name, String artist, Genre genre) {
        String fileUrl = "";
        try {
            File file = convertMultiPartToFile(multipartFile);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
	        AudioFormat format = audioInputStream.getFormat();
	        long frames = audioInputStream.getFrameLength();
	        double durationInSeconds = (frames+0.0) / format.getFrameRate();  
            String fileName = generateFileName(multipartFile);
            fileUrl = endpointUrl + "/" + trackBucketName + "/" + fileName;
            uploadFileTos3bucket(fileName, file);
            file.delete();
            
            trackService.save(trackName, name, artist, fileName, genre);
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        return fileUrl;
    }
    
    public String uploadPic(MultipartFile multipartFile, User user) {
        String fileUrl = "";
        try {
            File file = convertMultiPartToFile(multipartFile);
            String fileName = generateFileName(multipartFile);
            fileUrl = endpointUrl + "/" + picBucketName + "/" + fileName;
            uploadPicTos3bucket(fileName, file);
            file.delete();       
            picService.save(user, fileName);
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        return fileUrl;
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }

    private void uploadFileTos3bucket(String fileName, File file) {
        s3client.putObject(new PutObjectRequest(trackBucketName, fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    }
    
    private void uploadPicTos3bucket(String fileName, File file) {
        s3client.putObject(new PutObjectRequest(picBucketName, fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    }

    public String deleteFileFromS3Bucket(String fileUrl) {
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
        s3client.deleteObject(new DeleteObjectRequest(trackBucketName, fileName));
        return "Successfully deleted";
    }
    
    public String deletePicFromS3Bucket(String fileUrl) {
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
        s3client.deleteObject(new DeleteObjectRequest(picBucketName, fileName));
        return "Successfully deleted";
    }

}