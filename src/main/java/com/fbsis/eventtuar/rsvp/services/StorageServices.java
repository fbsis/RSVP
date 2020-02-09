package com.fbsis.eventtuar.rsvp.services;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.HttpMethod;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URL;

@Component
public class StorageServices {
    public AmazonS3 s3Client;

    public String bucketName = System.getenv("STORAGE_BUCKETNAME");
    public String accessKey = System.getenv("STORAGE_ACESSKEY");
    public String secretKey = System.getenv("STORAGE_SECRETKEY");
    public String endPoint = System.getenv("STORAGE_ENDPOINT");

    StorageServices(){
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setSignerOverride("AWSS3V4SignerType");

        this.s3Client = AmazonS3ClientBuilder
                .standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endPoint, Regions.US_EAST_1.name()))
                .withPathStyleAccessEnabled(true)
                .withClientConfiguration(clientConfiguration)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }


    public S3Object get (String name){
        GetObjectRequest rangeObjectRequest = new GetObjectRequest(bucketName, name);
        return s3Client.getObject(rangeObjectRequest);
    }

    public URL getLink (String name){
        java.util.Date expiration = new java.util.Date();
        long expTimeMillis = expiration.getTime();
        expTimeMillis += 1000 * 60 * 60; // 1 hora
        expiration.setTime(expTimeMillis);

        // Generate the presigned URL.
        System.out.println("Generating pre-signed URL.");
        GeneratePresignedUrlRequest generatePresignedUrlRequest =
                new GeneratePresignedUrlRequest(bucketName, name)
                        .withMethod(HttpMethod.GET)
                        .withExpiration(expiration);
        return s3Client.generatePresignedUrl(generatePresignedUrlRequest);
    }

    public PutObjectResult put (String name, File file){
        return s3Client.putObject(new PutObjectRequest(bucketName, name, file));
    }

    public void delete (String name){
        s3Client.deleteObject(new DeleteObjectRequest(bucketName, name));
    }
}
