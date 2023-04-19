package apps.progfort.platform.configuration.cloud;

import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;

@Configuration
public class S3Configuration {

  private String accessKey;
  private String secretKey;
  private String bucketName;
  private String region;

  public S3Client s3Client() {
    AwsBasicCredentials awsCredentials =
        AwsBasicCredentials.create(accessKey, secretKey);

    S3Client client = new S3Client.builder()
                          .credentialsProvider(StaticCredentialsProvider.create(
                              AwsBasicCredentials.create(accessKey, secretKey)))
                          .region(Region.of(region))
                          .build();
  }
}
