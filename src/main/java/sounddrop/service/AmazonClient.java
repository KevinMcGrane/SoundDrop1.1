package sounddrop.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

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
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;

import sounddrop.model.Genre;

@Service
public class AmazonClient {

    private AmazonS3 s3client;
    
    @Autowired
	private TrackService trackService;
    
    @Autowired
    private GenreService genreService;

    @Value("${aws.endpoint_url}")
    private String endpointUrl;
    @Value("${aws.bucket_name}")
    private String bucketName;
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
    
    public String uploadFile(MultipartFile multipartFile, String track, String name, String genre) {
        String fileUrl = "";
        try {
            File file = convertMultiPartToFile(multipartFile);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
	        AudioFormat format = audioInputStream.getFormat();
	        long frames = audioInputStream.getFrameLength();
	        double durationInSeconds = (frames+0.0) / format.getFrameRate();  
	        System.out.println(durationInSeconds/60);
            String fileName = generateFileName(multipartFile);
            System.out.println(fileName);
            fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;
            uploadFileTos3bucket(fileName, file);
            file.delete();
            List<Genre> list = genreService.getAllGenre();
            if (genreService.containsName(list, genre)){
            	System.out.println("present");
            }else {
            	System.out.println("Not Present");
            }
            genreService.save(genre);
            trackService.save(track, name, fileName);
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
        s3client.putObject(new PutObjectRequest(bucketName, fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    }

    public String deleteFileFromS3Bucket(String fileUrl) {
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
        s3client.deleteObject(new DeleteObjectRequest(bucketName, fileName));
        return "Successfully deleted";
    }

}